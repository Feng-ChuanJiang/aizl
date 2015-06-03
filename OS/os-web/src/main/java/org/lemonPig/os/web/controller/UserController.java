package org.lemonPig.os.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.lemonPig.os.assist.mybaties.bean.PageList;
import org.lemonPig.os.assist.mybaties.bean.Paginator;
import org.lemonPig.os.assist.shiro.SaltHashHelper;
import org.lemonPig.os.common.StringUtils;
import org.lemonPig.os.core.constants.UserStatus;
import org.lemonPig.os.core.dto.User;
import org.lemonPig.os.core.iservice.IUserService;
import org.lemonPig.os.web.vo.DataTablesVO;
import org.lemonPig.os.web.vo.PageVO;
import org.lemonPig.os.web.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 该controller只有登录失败后才会进入，主要是处理失败跳转和参数处理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
@SessionAttributes()
public class UserController {
Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@Value(value = "${shiro.loginFailAttributeName}")
	private String loginFailAttributeName;
	
	@Autowired
	IUserService iUserService;
	
	@Autowired
	SaltHashHelper saltHashHelper;
	
	@ResponseBody
	@RequestMapping("/login")
	public Result login(HttpServletRequest request) {
		Result result=null;
		//捕获登录错误
		String loginError=(String) request.getAttribute(loginFailAttributeName);
		if (StringUtils.isNotBlank(loginError)) {
			result=Result.buildErrorResult(loginError);
			return result;
		}
		//没有错误信息却进入该错误处理方法
		result=Result.buildErrorResult("未能识别的登录错误!");
		return result;
	}
	@ResponseBody
	@RequestMapping("/regist")
	public Result regist(User user) {
		
		Result result=null;
		String publicSalt=UUID.randomUUID().toString();
		String password=saltHashHelper.getHash(user.getPassWord(), publicSalt);
		user.setSalt(publicSalt);
		user.setPassWord(password);
		iUserService.saveUser(user);
		result=Result.buildSuccessResult(null, "保存成功");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/queryPageList")
	public Result queryPageList(String sEcho,@RequestBody DataTablesVO.KeyValuePair[] jsonParams){
		
		logger.trace("trace123");
		logger.debug("debug123");
		logger.warn("warn123");
		logger.info("info123");
		logger.error("error123");
		
		
		Map<String, Object> jsonMap=DataTablesVO.toMap(jsonParams);
		
		List<User> list=new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User user=new User();
			user.setUserName("张三");
			user.setMail("邮箱");
			user.setPassWord("123");
			user.setSalt("xxx");
			user.setStatus(UserStatus.ACTIVEED.ordinal());
			user.setTel("13882476468");
			list.add(user);
		}
		PageList<User> pageList=new PageList<User>(new ArrayList<User>(),new Paginator(1, 10, 100));
		PageVO<User> page=new PageVO<User>(pageList);
		page.setsEcho(jsonMap.get("sEcho")+"");
		page.setAaData(list);
		page.setiTotalRecords(100);
		page.setiTotalDisplayRecords(100);
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			System.out.println(objectMapper.writeValueAsString(jsonParams));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Result.buildSuccessResult(page, "操作成功");
	}
}
