package com.shavika.foodies.dao;

import com.shavika.foodies.api.dao.BaseDao;
import com.shavika.foodies.api.dto.Login;
import com.shavika.foodies.api.exception.ShavikaAppException;

public abstract interface LoginDao extends BaseDao<Login> {

	public static final String GET_USER_BY_NAME = "getUserByName";
	public static final String GET_USER_BY_EMAIL = "getUserByEmail";
	public static final String GET_ANY_USER_BY_NAME_PWD = "getAnyUserByNamePwd";

	public abstract Login getLoginByName(String name) throws ShavikaAppException;

	public abstract Login getLoginByEmail(String email) throws ShavikaAppException;

	public abstract Login getLoginByNamePwd(String name, String passwaord) throws ShavikaAppException;
}
