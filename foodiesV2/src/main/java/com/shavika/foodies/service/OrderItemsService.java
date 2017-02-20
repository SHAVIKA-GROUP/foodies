package com.shavika.foodies.service;

import java.util.List;

import com.shavika.foodies.api.dto.OrderItem;
import com.shavika.foodies.api.dto.Orders;
import com.shavika.foodies.api.exception.ShavikaAppException;

public interface OrderItemsService {

	public abstract int saveOrUpdate(List<OrderItem> orderItemList) throws ShavikaAppException;
	
	public abstract int insertOrderItems(List<OrderItem> orderItemList) throws ShavikaAppException;
	
	public abstract List<OrderItem> getOrderItemsByOrderId(long orderId) throws ShavikaAppException;
}
