package org.lemonPig.os.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.lemonPig.os.assist.mybaties.bean.PageList;
import org.lemonPig.os.assist.mybaties.bean.Paginator;
import org.lemonPig.os.common.Result;
import org.lemonPig.os.common.StringUtils;
import org.lemonPig.os.core.constants.UserStatus;
import org.lemonPig.os.web.vo.DataTablesVO;
import org.lemonPig.os.web.vo.PageVO;
import org.lemonPig.os.web.vo.UserVO;
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
	@Value(value = "${shiro.loginFailAttributeName}")
	private String loginFailAttributeName;
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
	@RequestMapping("/queryPageList")
	public Result queryPageList(String sEcho,@RequestBody DataTablesVO.KeyValuePairVO[] jsonParamVOs){
		Map<String, Object> jsonMap=DataTablesVO.toMap(jsonParamVOs);
		
		List<UserVO> list=new ArrayList<UserVO>();
		for (int i = 0; i < 10; i++) {
			UserVO userVO=new UserVO();
			userVO.setUserName("张三");
			userVO.setMail("邮箱");
			userVO.setPassWord("123");
			userVO.setSalt("xxx");
			userVO.setStatus(UserStatus.ACTIVEED);
			userVO.setTel("13882476468");
			list.add(userVO);
		}
		PageList<UserVO> pageList=new PageList<UserVO>(new ArrayList<UserVO>(),new Paginator(1, 10, 100));
		PageVO<UserVO> page=new PageVO<UserVO>(pageList);
		page.setsEcho(jsonMap.get("sEcho")+"");
		page.setAaData(list);
		page.setiTotalRecords(100);
		page.setiTotalDisplayRecords(100);
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			System.out.println(objectMapper.writeValueAsString(jsonParamVOs));
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
