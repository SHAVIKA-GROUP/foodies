package com.shavika.foodies.common.service;

import java.util.List;

import com.shavika.foodies.api.dto.Privilege;
import com.shavika.foodies.api.dto.Roles;
import com.shavika.foodies.api.dto.UserLogin;
import com.shavika.foodies.api.exception.ShavikaAppException;

public abstract interface UserService {

	public abstract UserLogin getUserLoginByName(String userName) throws ShavikaAppException;

	public abstract UserLogin getUserLoginByEmail(String userEmail) throws ShavikaAppException;

	public abstract Roles findUserRole(int paramInt) throws ShavikaAppException;

	public abstract List<Privilege> getPrivilegesByUserRole(Roles paramRole) throws ShavikaAppException;
	
	public abstract UserLogin getUserLoginById(long id) throws ShavikaAppException;
	
	public abstract List<UserLogin> getAllUserLogin() throws ShavikaAppException;
	
	public abstract UserLogin insertUser(UserLogin userLogin) throws ShavikaAppException;
	
	public abstract void updateUser(UserLogin userLogin) throws ShavikaAppException;
	
	public abstract void delete(UserLogin userLogin) throws ShavikaAppException;
	
}
