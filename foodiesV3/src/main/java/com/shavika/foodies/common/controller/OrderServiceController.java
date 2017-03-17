package com.shavika.foodies.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.shavika.foodies.api.dto.Customer;
import com.shavika.foodies.api.dto.Menus;
import com.shavika.foodies.api.dto.OrderItem;
import com.shavika.foodies.api.dto.Orders;
import com.shavika.foodies.api.dto.PojoMenuDetail;
import com.shavika.foodies.api.dto.PraserObject;
import com.shavika.foodies.api.dto.SyncDashBoard;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.common.service.CustomerService;
import com.shavika.foodies.common.service.MenuService;
import com.shavika.foodies.common.service.OrderItemsService;
import com.shavika.foodies.common.service.OrdersService;

@RestController
public class OrderServiceController {

	@Autowired
	private OrdersService ordersService;

	@Autowired
	private OrderItemsService orderItemsService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/customersService", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getCustomers() throws ShavikaAppException, JsonProcessingException {
		System.out.println("============= [menuservice]GET All...");
		List<Customer> custs = customerService.getAllCustomer();
		System.out.println("============= GET All... size=" + custs.size());
		if (custs.isEmpty())
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		System.out.println("============= GET All... menus=123");
		return new ResponseEntity<List<Customer>>(custs, HttpStatus.OK);
	}

	@RequestMapping(value = "/ordersService", method = RequestMethod.GET)
	public ResponseEntity<List<PraserObject>> getOrders() throws ShavikaAppException, JsonProcessingException {
		System.out.println("============= [menuservice]GET All...");
		List<PraserObject> returnData = genrateJsonData();
		System.out.println("============= GET All... size=" + returnData.size());
		if (returnData.isEmpty())
			return new ResponseEntity<List<PraserObject>>(HttpStatus.NO_CONTENT);
		System.out.println("============= GET All... menus=123");
		return new ResponseEntity<List<PraserObject>>(returnData, HttpStatus.OK);
	}

	private List<PraserObject> genrateJsonData() throws ShavikaAppException, JsonProcessingException {
		List<Customer> custs = customerService.getAllCustomer();
		List<Menus> menuItems = menuService.getAllMenus();
		List<Orders> orderList = ordersService.getOrdersByStatus();

		Map<Long, Customer> customerMap = new HashMap<Long, Customer>();
		for (Customer cust : custs)
			customerMap.put(cust.getCustomer_item_id(), cust);

		Map<Long, Menus> menusMap = new HashMap<Long, Menus>();
		for (Menus menus : menuItems)
			menusMap.put(menus.getId(), menus);

		List<PraserObject> Praserobjlist = new ArrayList<PraserObject>();
		for (Orders ords : orderList) {
			PraserObject obj = new PraserObject();
			obj.setOrders(ords);
			obj.setCustomer(customerMap.get(ords.getCustomer_item_id()));
			List<OrderItem> orderItemList = orderItemsService.getOrderItemsByOrderId(ords.getOrder_item_id());
			obj.setOrderitems(orderItemList);
			
			List<Menus> menuList = new ArrayList<Menus>();
			for(OrderItem orderItem : orderItemList){
				menuList.add(menusMap.get(orderItem.getFood_id()));
			}
			obj.setMenus(menuList);
			Praserobjlist.add(obj);
		}
		return Praserobjlist;
	}

	@RequestMapping(value = "/ordersConfService/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PraserObject>> getMenu(@PathVariable("id") long id) throws ShavikaAppException, JsonProcessingException {
		System.out.println("============= [menuservice]GET.../" + id);
		long orfer_id = Long.valueOf(id);
		System.out.println("orfer_id==>" + orfer_id);
		ordersService.updateStatusbyUI(orfer_id);
		List<PraserObject> returnData = genrateJsonData();
		System.out.println("============= GET All... size=" + returnData.size());
		if (returnData.isEmpty())
			return new ResponseEntity<List<PraserObject>>(HttpStatus.NO_CONTENT);
		System.out.println("============= GET All... menus=123");
		return new ResponseEntity<List<PraserObject>>(returnData, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/syncDashboard", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SyncDashBoard>> syncDashboard() throws ShavikaAppException, JsonProcessingException {
		System.out.println("============= [syncDashboard]GET...");
		List<SyncDashBoard> finalObject = new ArrayList<SyncDashBoard>();
		finalObject.addAll(ordersService.getSyncDashboard());
		finalObject.add(customerService.getSyncDashboard());
		//finalObject.add(menuService.getSyncDashboard());
		if (finalObject.isEmpty())
			return new ResponseEntity<List<SyncDashBoard>>(HttpStatus.NO_CONTENT);
		System.out.println("============= GET All... menus="+finalObject);
		return new ResponseEntity<List<SyncDashBoard>>(finalObject, HttpStatus.OK);
	}
}
