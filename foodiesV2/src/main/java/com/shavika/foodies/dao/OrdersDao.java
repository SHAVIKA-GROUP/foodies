package com.shavika.foodies.dao;

import java.util.List;

import com.shavika.foodies.api.dao.BaseDao;
import com.shavika.foodies.api.dto.Orders;
import com.shavika.foodies.api.exception.ShavikaAppException;

public abstract interface OrdersDao extends BaseDao<Orders> {

	public static final String GET_ORDERS_WITHOUT_RECEIVED = "getOrdersWithOutReceived";
	public static final String GET_ORDERS_BY_ITEMID = "getOrdersByItemId";
	public static final String GET_ORDERS_BY_CUSTOMER = "getOrdersBycustomer";	

	public abstract List<Orders> getOrderByStatus() throws ShavikaAppException;
	
	public abstract List<Orders> getOrderByItemId(long orderItemId) throws ShavikaAppException;
	
	public abstract List<Orders> getOrderByCustomer(long customerId) throws ShavikaAppException;
	
}
