package com.shavika.foodies.common.dao;

import com.shavika.foodies.api.dao.BaseDao;
import com.shavika.foodies.api.dto.UserLogin;
import com.shavika.foodies.api.exception.ShavikaAppException;

public abstract interface UserDao extends BaseDao<UserLogin> {

	public static final String GET_USER_BY_NAME = "getUserByName";
	public static final String GET_USER_BY_EMAIL = "getUserByEmail";
	public static final String GET_ANY_USER_BY_NAME = "getAnyUserByName";

	public abstract UserLogin getUserLoginByName(String paramString) throws ShavikaAppException;

	public abstract UserLogin getUserLoginByEmail(String paramString) throws ShavikaAppException;

	public abstract UserLogin getAnyUserLoginByName(String paramString) throws ShavikaAppException;
}
