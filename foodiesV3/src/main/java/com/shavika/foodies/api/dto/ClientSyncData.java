package com.shavika.foodies.api.dto;

import java.util.List;
import java.util.Map;

public class ClientSyncData {

	private List<SyncOrder> syncorder;
	private List<Menus> menus;
	private List<Map<String, byte[]>> menusImage;
	private List<Props> props;
	
	public ClientSyncData() {
		super();
	}

	public ClientSyncData(List<SyncOrder> syncorder, List<Menus> menus, List<Map<String, byte[]>> menusImage,
			List<Props> props) {
		super();
		this.syncorder = syncorder;
		this.menus = menus;
		this.menusImage = menusImage;
		this.props = props;
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

	public List<Map<String, byte[]>> getMenusImage() {
		return menusImage;
	}

	public void setMenusImage(List<Map<String, byte[]>> menusImage) {
		this.menusImage = menusImage;
	}

	public List<Props> getProps() {
		return props;
	}

	public void setProps(List<Props> props) {
		this.props = props;
	}

	@Override
	public String toString() {
		return "ClientSyncData [syncorder=" + syncorder + ", menus=" + menus + ", menusImage=" + menusImage + ", props="
				+ props + "]";
	}
}
