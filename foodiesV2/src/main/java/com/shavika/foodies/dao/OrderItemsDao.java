package com.shavika.foodies.dao;

import java.util.List;

import com.shavika.foodies.api.dao.BaseDao;
import com.shavika.foodies.api.dto.OrderItem;
import com.shavika.foodies.api.exception.ShavikaAppException;

public abstract interface OrderItemsDao extends BaseDao<OrderItem> {

	public static final String GET_ORDERITEM_BY_ORDERID = "getOrderItemByOrderId";
	public static final String GET_ORDERITEM_BY_SRC_ORDERID = "getOrderItemBySrcOrderId";

	public abstract List<OrderItem> getOrdeItemsByOrderId(long orderId) throws ShavikaAppException;
	
	public abstract List<OrderItem> getOrdeItemBySrcOrderId(long orderId, String srcid) throws ShavikaAppException;

}
