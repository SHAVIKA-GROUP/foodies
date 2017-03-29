package com.shavika.foodies.common.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.shavika.foodies.api.dto.Customer;
import com.shavika.foodies.api.dto.OrderItem;
import com.shavika.foodies.api.dto.Orders;
import com.shavika.foodies.api.dto.SyncDashBoard;
import com.shavika.foodies.api.dto.SyncOrder;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.common.dao.OrderItemsDao;
import com.shavika.foodies.common.dao.OrdersDao;
import com.shavika.foodies.common.utilities.Constants;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDao ordersDao;

	@Autowired
	private OrderItemsDao orderItemsDao;

	@Override
	public int insertOrders(List<Orders> ordersList) throws ShavikaAppException {
		return ordersDao.saveAll(ordersList);
	}

	@Override
	public int saveOrUpdate(List<Orders> ordersList) throws ShavikaAppException {
		for (Orders _orders : ordersList) {
			List<Orders> orderlist = ordersDao.getOrderByItemId(_orders.getOrder_item_id());
			if (orderlist.size() == 0 && _orders.getOrder_status().equals(Constants.ORDER_PLACED)) {
				_orders.setOrder_status(Constants.ORDER_INISIATED);
				ordersDao.save(_orders);
			}
		}
		return ordersList.size();
	}

	@Override
	public List<Orders> getOrdersByStatus() throws ShavikaAppException {
		return ordersDao.getOrderByStatus();
	}

	@Override
	public void updateStatus(List<SyncOrder> syncOrderList) throws ShavikaAppException {
		for (SyncOrder syncOrder : syncOrderList) {
			List<Orders> orderlist = ordersDao.getOrderByItemId(syncOrder.getOrder_item_id());
			if (orderlist.size() > 0 && syncOrder.getStatus().equals(Constants.ORDER_CANCELED)) {
				Orders orders = orderlist.get(0);
				orders.setOrder_status(Constants.ORDER_CANCELED);
				ordersDao.update(orders);
				List<OrderItem> _orderItems = orderItemsDao.getOrdeItemsByOrderId(syncOrder.getOrder_item_id());
				List<OrderItem> _orderItemsUpd = new ArrayList<OrderItem>();
				for (OrderItem _orderItem : _orderItems) {
					_orderItem.setStatus(Constants.ORDER_CANCELED);
					_orderItemsUpd.add(_orderItem);
				}
				orderItemsDao.saveAll(_orderItemsUpd);
			}
		}
	}

	@Override
	public List<SyncOrder> getAllSyncData(Customer customerObj) throws ShavikaAppException {
		List<SyncOrder> _syncOrderList = new ArrayList<SyncOrder>();
		List<Orders> orderList = ordersDao.getOrderByCustomer(customerObj.getCustomer_item_id());

		for (Orders orders : orderList) {
			if (orders.getOrder_status().equals(Constants.ORDER_INISIATED)
					|| orders.getOrder_status().equals(Constants.ORDER_CONFIRMED)
					|| orders.getOrder_status().equals(Constants.ORDER_DELIVERED)
					|| orders.getOrder_status().equals(Constants.ORDER_RECEIVED)
					|| orders.getOrder_status().equals(Constants.ORDER_REJECTED)) {
				_syncOrderList.add(new SyncOrder(orders.getOrder_item_id(), orders.getOrder_status()));
			}
		}
		return _syncOrderList;
	}

	@Override
	public void updateStatusbyUI(long orderItemId) throws ShavikaAppException {
		List<Orders> orderlist = ordersDao.getOrderByItemId(orderItemId);
		if (orderlist.size() > 0) {
			Orders orders = orderlist.get(0);
			
			if(orders.getOrder_status().equals(Constants.ORDER_PLACED) || orders.getOrder_status().equals(Constants.ORDER_INISIATED)){
				orders.setOrder_status(Constants.ORDER_CONFIRMED);
			}else if(orders.getOrder_status().equals(Constants.ORDER_CONFIRMED)){
				orders.setOrder_status(Constants.ORDER_DELIVERED);
			}else if(orders.getOrder_status().equals(Constants.ORDER_DELIVERED)){
				orders.setOrder_status(Constants.ORDER_RECEIVED);
			}else{	
				orders.setOrder_status(Constants.ORDER_REJECTED);
			}
			ordersDao.update(orders);
			List<OrderItem> _orderItems = orderItemsDao.getOrdeItemsByOrderId(orderItemId);
			List<OrderItem> _orderItemsUpd = new ArrayList<OrderItem>();
			for (OrderItem _orderItem : _orderItems) {
				_orderItem.setStatus(orders.getOrder_status());
				_orderItemsUpd.add(_orderItem);
			}
			orderItemsDao.updateAll(_orderItemsUpd);
		}
	}

	@Override
	public List<SyncDashBoard> getSyncDashboard() throws ShavikaAppException {
		List<SyncDashBoard> objects = new ArrayList<SyncDashBoard>(); 
		List<Orders> _ordersList = ordersDao.findAll(Orders.class);
		System.out.println("___ordersList.size="+_ordersList.size());
		for(String orderstatus : Constants.ORDER_STATUS_ARRY){
			List<Orders> ordersList = ordersDao.getCountofOrderStatus(orderstatus); 
			System.out.println("ordersList.size="+ordersList.size());
			float percentage = (ordersList.size() > 0) ? (ordersList.size()*100)/_ordersList.size() : 0f;
			System.out.println("percentage="+percentage);
			SyncDashBoard syncDashBoard = new SyncDashBoard();
			syncDashBoard.setService(orderstatus);
			syncDashBoard.setSize(ordersList.size());
			syncDashBoard.setAll(_ordersList.size());
			syncDashBoard.setPercentage(percentage);
			objects.add(syncDashBoard);
		}
		return objects;
	}
}
