package com.shavika.foodies.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shavika.foodies.api.dao.BaseDaoImpl;
import com.shavika.foodies.api.dto.Login;
import com.shavika.foodies.api.exception.ShavikaAppException;

@Repository("loginDao")
public class LoginDaoImpl extends BaseDaoImpl<Login> implements LoginDao {

	@SuppressWarnings("unchecked")
	@Override
	public Login getLoginByName(String name) throws ShavikaAppException {
		Login login = null;
		List<Login> loginList = getSession().getNamedQuery(GET_USER_BY_NAME).setString(0, name).list();
		if (!loginList.isEmpty())
			login = loginList.get(0);
		return login;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Login getLoginByEmail(String email) throws ShavikaAppException {
		Login login = null;
		List<Login> loginList = getSession().getNamedQuery(GET_USER_BY_EMAIL).setString(0, email).list();
		if (!loginList.isEmpty())
			login = loginList.get(0);
		return login;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Login getLoginByNamePwd(String name, String passwaord) throws ShavikaAppException {
		Login login = null;
		List<Login> loginList = getSession().getNamedQuery(GET_ANY_USER_BY_NAME_PWD).setString(0, name).setString(1, passwaord).list();
		if (!loginList.isEmpty())
			login = loginList.get(0);
		return login;
	}

}
