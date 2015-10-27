package org.lemonPig.os.web.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.lemonPig.os.assist.mybaties.bean.PageList;
import org.lemonPig.os.assist.shiro.SaltHashHelper;
import org.lemonPig.os.assist.spring.Result;
import org.lemonPig.os.assist.spring.jsr.Save;
import org.lemonPig.os.common.DateUtils;
import org.lemonPig.os.common.StringUtils;
import org.lemonPig.os.core.iservice.IUserService;
import org.lemonPig.os.core.vo.User;
import org.lemonPig.os.web.util.BizAssert;
import org.lemonPig.os.web.util.WebUtils;
import org.lemonPig.os.web.vo.DataTables;
import org.lemonPig.os.web.vo.DatatablePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 该controller只有登录失败后才会进入，主要是处理失败跳转和参数处理
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
@SessionAttributes()
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Value(value = "${shiro.failureKeyAttribute}")
	private String loginFailAttributeName;

	@Value(value = "${shiro.successUrl}")
	private String successUrl;
	
	@Value(value="${shiro.loginPage}")
	private String loginPage;
	
	@Autowired
	IUserService iUserService;

	@Autowired
	SaltHashHelper saltHashHelper;

	@ResponseBody
	@RequestMapping("/findCategory")
	public Result findCategory() {
		User user=WebUtils.getCurrentUser();
		Result result = Result.buildSuccessResult(user, "成功");
		return result;
	}

	@RequestMapping("/forward/{toGO}")
	public String forward(@PathVariable String toGO) {
		return toGO;
	}

	@ResponseBody
	// spring3.2.2 bug see http://jinnianshilongnian.iteye.com/blog/1831408
	@RequestMapping(value = { "/{login:login;?.*}" })
	public ModelAndView login(HttpServletRequest request) {
		Result result = null;
		// Subject subject = SecurityUtils.getSubject();
		// Session session = subject.getSession();
		// 捕获登录错误
		String loginError = (String) request
				.getAttribute(loginFailAttributeName);
		if (StringUtils.isNotBlank(loginError)) {
			result = Result.buildErrorResult(loginError);
		} else {
			Map<String, String> dataMap = new HashMap<String, String>();
			dataMap.put("successUrl", successUrl);
			result = Result.buildSuccessResult(dataMap, "登录成功!");
			//更新最后登录时间
		}
		//modelAndView 可以用内容协商管理器动态的根据contentType将object转json或者跳转view
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject(result);
		modelAndView.setViewName(loginPage);
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/regist")
	public Result regist(@Validated({ Save.class }) User user,
			BindingResult bindingResult) {
		Timestamp timestamp=DateUtils.getCurrentTimestamp();
		user.setCreateTime(timestamp);
		user.setLastLogin(timestamp);
		WebUtils.handleBandingResult(bindingResult);
		Result result = null;
		String publicSalt = UUID.randomUUID().toString();
		String password = saltHashHelper
				.getHash(user.getPassword(), publicSalt);
		user.setSalt(publicSalt);
		user.setPassword(password);
		iUserService.saveUser(user);
		result = Result.buildSuccessResult(null, "保存成功");
		return result;
	}

	@ResponseBody
	@RequestMapping("/queryPageList")
	public Result queryPageList(String sEcho,
			@RequestBody DataTables.KeyValuePair[] jsonParams) {
		DataTables dataTables = new DataTables(jsonParams);
		Map<String, Object> jsonMap = dataTables.getMap();
		String condition = (String) jsonMap.get("condition");
		Object startObj = jsonMap.get(DataTables.startKeyName);
		Object lenObj = jsonMap.get(DataTables.lengthKeyName);
		BizAssert.assertNotNull(startObj, "分页查询起始位置不能为空");
		BizAssert.assertNotNull(lenObj, "分页查询每页大小不能为空");
		int start = Integer.parseInt(startObj.toString());
		int length = Integer.parseInt(lenObj.toString());
		PageList<User> pageList = iUserService.findUserByPage(condition,
				condition, condition, start, length,
				dataTables.getOrderBy(DataTables.ColNames.userManage));
		DatatablePage<User> page = new DatatablePage<User>(pageList);
		page.setsEcho(jsonMap.get("sEcho") + "");
		page.setAaData(pageList);
		page.setiTotalRecords(pageList.getPaginator().getTotalCount());
		page.setiTotalDisplayRecords(pageList.getPaginator().getTotalCount());
		return Result.buildSuccessResult(page, "操作成功");
	}
}
