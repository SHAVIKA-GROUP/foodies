package com.shavika.foodies.common.service;

import java.util.List;

import com.google.gson.JsonObject;
import com.shavika.foodies.api.dto.Customer;
import com.shavika.foodies.api.dto.Orders;
import com.shavika.foodies.api.dto.SyncDashBoard;
import com.shavika.foodies.api.dto.SyncOrder;
import com.shavika.foodies.api.exception.ShavikaAppException;

public interface OrdersService {

	public abstract int insertOrders(List<Orders> ordersList) throws ShavikaAppException;
	
	public abstract int saveOrUpdate(List<Orders> ordersList) throws ShavikaAppException;

	public abstract List<Orders> getOrdersByStatus() throws ShavikaAppException;
	
	public abstract void updateStatus(List<SyncOrder> syncOrderList) throws ShavikaAppException;
	
	public abstract void updateStatusbyUI(long orderItemId) throws ShavikaAppException;
	
	public abstract List<SyncOrder> getAllSyncData(Customer customerObj) throws ShavikaAppException;
	
	public abstract List<SyncDashBoard> getSyncDashboard() throws ShavikaAppException;
}
