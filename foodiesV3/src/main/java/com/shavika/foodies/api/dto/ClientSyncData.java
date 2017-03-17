package com.shavika.foodies.api.dto;

import java.util.List;

public class ClientSyncData {

	private List<SyncOrder> syncorder;

	private List<Menus> menus;

	public ClientSyncData() {
		super();
	}

	public ClientSyncData(List<SyncOrder> syncorder, List<Menus> menus) {
		super();
		this.syncorder = syncorder;
		this.menus = menus;
	}

	public List<SyncOrder> getSyncorder() {
		return syncorder;
	}

	public void setSyncorder(List<SyncOrder> syncorder) {
		this.syncorder = syncorder;
	}

	public List<Menus> getMenus() {
		return menus;
	}

	public void setMenus(List<Menus> menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "ClientSyncData [syncorder=" + syncorder + ", menus=" + menus + "]";
	}
}
