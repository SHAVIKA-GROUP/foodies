package com.shavika.foodies.common.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.Gson;
import com.shavika.foodies.api.dto.ClientSyncData;
import com.shavika.foodies.api.dto.Customer;
import com.shavika.foodies.api.dto.Menus;
import com.shavika.foodies.api.dto.OrderItem;
import com.shavika.foodies.api.dto.Orders;
import com.shavika.foodies.api.dto.SyncOrder;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.common.service.CustomerService;
import com.shavika.foodies.common.service.MenuService;
import com.shavika.foodies.common.service.OrderItemsService;
import com.shavika.foodies.common.service.OrdersService;

@RestController
@RequestMapping(value = "/rService")
public class restServiceController {

	private static final Logger LOGGER = Logger.getLogger(restServiceController.class);

	@Autowired
	CustomerService customerService;

	@Autowired
	OrdersService ordersService;

	@Autowired
	OrderItemsService orderItemsService;

	@Autowired
	MenuService menuService;

	@RequestMapping(value = "/syncdata", method = RequestMethod.POST)
	public ResponseEntity<String> syncData(@RequestParam("CUSTOMER") String customer,
			@RequestParam("ORDERPLACED") String placedOrders, @RequestParam("ORDERITEMPLACED") String placedOrderItem,
			@RequestParam("ORDERSYNC") String syncOrders, @RequestParam("MENUSYNC") String syncMenus)
			throws ShavikaAppException {
		String returnsyncOrders = null;
		try {
			Customer customerObj = syncCustomerData(customer);
			syncOrderData(placedOrders);
			syncOrderItemData(placedOrderItem);
			syncOrderSyncData(syncOrders);
			ClientSyncData syncOrderList = getAllsyncData(customerObj, syncMenus);
			returnsyncOrders = new Gson().toJson(syncOrderList);
			System.out.println("-----------------------------------------------------");
			System.out.println("CUSTOMER	==>" + customerObj.getCustomer_item_id());
			System.out.println("RESULT		==>" + syncOrderList);
			System.out.println("-----------------------------------------------------");
		} catch (JsonParseException e) {
			LOGGER.error("restServiceController/syncData", e);
		} catch (JsonMappingException e) {
			LOGGER.error("restServiceController/syncData", e);
		} catch (IOException e) {
			LOGGER.error("restServiceController/syncData", e);
		}
		return new ResponseEntity<String>(returnsyncOrders, HttpStatus.OK);
	}

	private Customer syncCustomerData(String _strcustomr)
			throws ShavikaAppException, JsonParseException, JsonMappingException, IOException {
		if (null == _strcustomr || _strcustomr.length() == 0)
			return null;
		Customer cust = new ObjectMapper().readValue(_strcustomr, Customer.class);
		System.out.println("CUSTOMER=>" + cust);
		return customerService.saveOrUpdate(cust);
	}

	private void syncOrderData(String placedOrders)
			throws ShavikaAppException, JsonParseException, JsonMappingException, IOException {
		if (null == placedOrders || placedOrders.length() == 0)
			return;
		List<Orders> orderPlcdList = new ObjectMapper().readValue(placedOrders,
				TypeFactory.defaultInstance().constructCollectionType(List.class, Orders.class));
		System.out.println("ORDERPLACED=>" + orderPlcdList);
		ordersService.saveOrUpdate(orderPlcdList);
	}

	private void syncOrderItemData(String placedOrderItem)
			throws ShavikaAppException, JsonParseException, JsonMappingException, IOException {
		if (null == placedOrderItem || placedOrderItem.length() == 0)
			return;
		List<OrderItem> orderItemPlcdList = new ObjectMapper().readValue(placedOrderItem,
				TypeFactory.defaultInstance().constructCollectionType(List.class, OrderItem.class));
		System.out.println("ORDERITEMPLACED=>" + orderItemPlcdList);
		orderItemsService.saveOrUpdate(orderItemPlcdList);
	}

	private void syncOrderSyncData(String syncOrders)
			throws ShavikaAppException, JsonParseException, JsonMappingException, IOException {
		if (null == syncOrders || syncOrders.length() == 0)
			return;
		List<SyncOrder> syncOrder = new ObjectMapper().readValue(syncOrders, new TypeReference<List<SyncOrder>>() {
		});
		ordersService.updateStatus(syncOrder);
		System.out.println("ORDERSYNC=>" + syncOrder);
	}

	private ClientSyncData getAllsyncData(Customer customerObj, String syncMenus) throws ShavikaAppException {
		List<SyncOrder> syncOrder = ordersService.getAllSyncData(customerObj);
		List<Menus> menusList = new ArrayList<Menus>();
		String _syncMenus = syncMenus;
		if (null != _syncMenus || _syncMenus.length() > 0) {
			String[] syncMneusArry = _syncMenus.split("@");
			for (String uniqueid : syncMneusArry) {
				menusList.addAll(menuService.getMenuByUniqueId(Long.valueOf(uniqueid)));
			}
		}
		return new ClientSyncData(syncOrder, menusList);
	}
}
