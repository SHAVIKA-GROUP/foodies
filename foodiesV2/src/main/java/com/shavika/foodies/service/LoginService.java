package com.shavika.foodies.service;

import javax.servlet.http.HttpServletRequest;

import com.shavika.foodies.api.dto.Login;
import com.shavika.foodies.api.exception.ShavikaAppException;


public abstract interface LoginService {
	
	public abstract Login getUserLoginByName(String userName) throws ShavikaAppException;

	public abstract Login getUserLoginByEmail(String userEmail) throws ShavikaAppException;

	public abstract Login getUserLoginByNamePwd(String userName, String password) throws ShavikaAppException;
	
	public abstract String genrateResponse(boolean status, int loginType) throws ShavikaAppException;
	
	public abstract Login getCurrentUser() throws ShavikaAppException;
	
	public abstract Login createRupdateUser(Login login) throws ShavikaAppException;
	
	public abstract Login getRequestUser(HttpServletRequest request) throws ShavikaAppException;
	
	

}
