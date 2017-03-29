package com.shavika.foodies.common.service;

import java.util.List;
import java.util.Map;

import com.shavika.foodies.api.dto.Menus;
import com.shavika.foodies.api.dto.PojoMenuDetail;
import com.shavika.foodies.api.exception.ShavikaAppException;

public abstract interface MenuService {

	public abstract List<Menus> getAllMenus() throws ShavikaAppException;
	
	public abstract List<PojoMenuDetail> getAllPojoMenus() throws ShavikaAppException;
	
	public abstract Menus insertMenu(Menus menu) throws ShavikaAppException;
	
	public abstract void updateMenu(Menus menu) throws ShavikaAppException;
	
	public abstract void delete(Menus menu) throws ShavikaAppException;
	
	public abstract Menus getMenuById(long id) throws ShavikaAppException;
	
	public abstract List<Menus> getMenuByUniqueId(long uniqueId) throws ShavikaAppException;
	
	public abstract Menus parseMenuByPojo(PojoMenuDetail pojoMenuDetail, String rootDirectory) throws ShavikaAppException;
	
	public abstract PojoMenuDetail parseMenuByPojo(List<Menus> menuList) throws ShavikaAppException;
	
	public abstract List<Menus> insertRUpdateMenu(Menus menu) throws ShavikaAppException;
	
	public abstract PojoMenuDetail getSyncDashboard() throws ShavikaAppException;
	
	public abstract List<Map<String, byte[]>> getmenuImages(String uniqueIds) throws ShavikaAppException;
	
}
