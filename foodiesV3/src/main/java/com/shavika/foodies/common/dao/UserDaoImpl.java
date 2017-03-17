package com.shavika.foodies.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shavika.foodies.api.dao.BaseDaoImpl;
import com.shavika.foodies.api.dto.UserLogin;
import com.shavika.foodies.api.exception.ShavikaAppException;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserLogin>implements UserDao {

	@SuppressWarnings("unchecked")
	public UserLogin getUserLoginByName(String userName) throws ShavikaAppException {
		UserLogin userLogin = null;
		List<UserLogin> userLoginList = getSession().createQuery(GET_USER_BY_NAME).setString(0, userName).list();
		if (!userLoginList.isEmpty())
			userLogin = userLoginList.get(0);
		return userLogin;
	}

	@SuppressWarnings("unchecked")
	public UserLogin getUserLoginByEmail(String userName) throws ShavikaAppException {
		UserLogin userLogin = null;
		List<UserLogin> userLoginList = getSession().getNamedQuery(GET_USER_BY_EMAIL).setString(0, userName).list();
		if (!userLoginList.isEmpty())
			userLogin = userLoginList.get(0);
		return userLogin;
	}

	@SuppressWarnings("unchecked")
	public UserLogin getAnyUserLoginByName(String userName) throws ShavikaAppException {
		UserLogin userLogin = null;
		List<UserLogin> userLoginList = getSession().getNamedQuery(GET_ANY_USER_BY_NAME).setString(0, userName).list();
		if (!userLoginList.isEmpty())
			userLogin = userLoginList.get(0);
		return userLogin;
	}
}
