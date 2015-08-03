package org.lemonPig.os.web.controller;

import org.junit.Test;
import org.lemonPig.os.BaseControllerTest;
import org.lemonPig.os.core.constants.Constants;
import org.lemonPig.os.core.constants.Sex;
import org.lemonPig.os.core.constants.UserStatus;
import org.lemonPig.os.core.vo.User;
import org.lemonPig.os.core.vo.UserMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.Rollback;

public class UserControllerITCase extends BaseControllerTest {
	@Autowired
	UserController userController;

	@Test
	@Rollback(false)
	public void saveUserTest() {
//		MockHttpServletRequest request = new MockHttpServletRequest();
//		MockHttpServletResponse response = new MockHttpServletResponse();
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setConfirmation("admin");
		user.setMail("408696894@qq.com");
		user.setTel("15882476468");
		user.setStatus(UserStatus.ACTIVEED.ordinal());
		
		UserMetaData userMetaData=new UserMetaData();
		userMetaData.setAddress("成都市锦江区蓝谷地");
		userMetaData.setAge(26);
		userMetaData.setCname("艾章林");
		userMetaData.setEname("ai.zhanglin");
		userMetaData.setPhoto("");
		userMetaData.setQq("408696894");
		userMetaData.setSex(Sex.MAN.getCode());
		userMetaData.setTel("15882476468");
		user.setUserMetaData(userMetaData);
		
		userController.regist(user,null);
	}
}
