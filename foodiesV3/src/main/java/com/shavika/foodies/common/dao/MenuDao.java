package com.shavika.foodies.common.dao;

import java.util.List;

import com.shavika.foodies.api.dao.BaseDao;
import com.shavika.foodies.api.dto.Menus;
import com.shavika.foodies.api.exception.ShavikaAppException;

public abstract interface MenuDao extends BaseDao<Menus> {

	public static final String IS_MENU_EXIST = "isMenuExist";
	
	public static final String GET_MENU_BY_UNIQUEID = "getMenuByUniqueId";
	
	public static final String GET_LATEST_MENU = "getLatestMenu";
	
	public abstract List<Menus> isRecordExist(Menus menus) throws ShavikaAppException;
	
	public abstract long getLatestMenu() throws ShavikaAppException;
	
	public abstract List<Menus> findMenuByUniqueId(long uniqueId) throws ShavikaAppException;
}
