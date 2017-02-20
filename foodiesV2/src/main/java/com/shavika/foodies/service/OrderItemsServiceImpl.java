package com.shavika.foodies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shavika.foodies.api.dto.OrderItem;
import com.shavika.foodies.api.dto.Orders;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.dao.OrderItemsDao;
import com.shavika.foodies.dao.OrdersDao;
import com.shavika.foodies.util.Constants;

@Service("orderItemsService")
public class OrderItemsServiceImpl implements OrderItemsService {

	@Autowired
	private OrderItemsDao orderItemsDao;

	@Autowired
	private OrdersDao ordersDao;

	@Override
	public int insertOrderItems(List<OrderItem> orderItemList) throws ShavikaAppException {
		return orderItemsDao.saveAll(orderItemList);
	}

	@Override
	public List<OrderItem> getOrderItemsByOrderId(long orderId) throws ShavikaAppException {
		return orderItemsDao.getOrdeItemsByOrderId(orderId);
	}

	@Override
	public int saveOrUpdate(List<OrderItem> orderItemList) throws ShavikaAppException {
		for (OrderItem _orderItem : orderItemList) {
			List<Orders> ordersList = ordersDao.getOrderByItemId(_orderItem.getOrder_item_id());
			List<OrderItem> _OrderItemList = orderItemsDao.getOrdeItemBySrcOrderId(_orderItem.getOrder_item_id(),
					_orderItem.getSrc_element_id());
			if (ordersList.size() > 0 && _OrderItemList.size() == 0
					&& ordersList.get(0).getOrder_status().equals(Constants.ORDER_INISIATED)) {
				_orderItem.setStatus(Constants.ORDER_INISIATED);
				orderItemsDao.save(_orderItem);
			}
		}
		return orderItemList.size();
	}
}
