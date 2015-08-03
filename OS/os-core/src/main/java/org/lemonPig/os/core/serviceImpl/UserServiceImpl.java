package org.lemonPig.os.core.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.lemonPig.os.assist.mybaties.bean.PageList;
import org.lemonPig.os.common.StringUtils;
import org.lemonPig.os.core.constants.UserStatus;
import org.lemonPig.os.core.idao.IUserDao;
import org.lemonPig.os.core.idao.IUserMetaDataDao;
import org.lemonPig.os.core.iservice.IUserService;
import org.lemonPig.os.core.pojo.UserMetadataPOJO;
import org.lemonPig.os.core.pojo.UserPOJO;
import org.lemonPig.os.core.pojo.UserPOJOExample;
import org.lemonPig.os.core.pojo.UserPOJOExample.Criteria;
import org.lemonPig.os.core.pojo.UserPermissionPOJO;
import org.lemonPig.os.core.pojo.UserRolePOJO;
import org.lemonPig.os.core.util.SwitchUtils;
import org.lemonPig.os.core.vo.Permission;
import org.lemonPig.os.core.vo.Role;
import org.lemonPig.os.core.vo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	IUserDao iUserDao;
	@Autowired
	IUserMetaDataDao iUserMetaDataDao;

	@Override
	public User findLoginUserByUserName(String username) {
		User user = iUserDao.selectLoginUserByUsername(username);
		return user;
	}

	@Override
	public void saveUser(User user) {
		UserPOJO userPOJO = new UserPOJO();
		BeanUtils.copyProperties(user, userPOJO);
		iUserDao.insert(userPOJO);

		UserMetadataPOJO userMetadataPOJO = new UserMetadataPOJO();
		BeanUtils.copyProperties(user.getUserMetaData(), userMetadataPOJO);
		userMetadataPOJO.setUserId(userPOJO.getId());
		iUserMetaDataDao.insert(userMetadataPOJO);
	}

	@Override
	public PageList<User> findUserByPage(String orUsername, String orMail,
			String orTel, int start, int length, String[] orderBys) {
		UserPOJOExample userPOJOExample = new UserPOJOExample();
		Criteria criteria=userPOJOExample.or().andStatusEqualTo(UserStatus.ACTIVEED.getCode());
		if (StringUtils.isNotBlank(orUsername)) {
			criteria.andUsernameEqualTo(orUsername);
		}
		userPOJOExample.or().andStatusEqualTo(UserStatus.ACTIVEED.getCode());
		if (StringUtils.isNotBlank(orMail)) {
			criteria.andMailEqualTo(orMail);
		}
		userPOJOExample.or().andStatusEqualTo(UserStatus.ACTIVEED.getCode());
		if (StringUtils.isNotBlank(orTel)) {
			criteria.andTelEqualTo(orTel);
		}
		for (String orderBy : orderBys) {
			userPOJOExample.setOrderByClause(orderBy);
		}
		
		PageList<UserPOJO> userPojoPagelist = iUserDao.selectPageByExample(
				userPOJOExample, start, length);
		PageList<User> userPageList = SwitchUtils.toVoPageList(User.class,
				userPojoPagelist);
		return userPageList;
	}
}
