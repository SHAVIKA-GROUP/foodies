package com.shavika.foodies.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shavika.foodies.api.dto.Customer;
import com.shavika.foodies.api.dto.Menus;
import com.shavika.foodies.api.dto.OrderItem;
import com.shavika.foodies.api.dto.Orders;
import com.shavika.foodies.api.dto.PraserObject;
import com.shavika.foodies.api.dto.SyncDashBoard;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.common.service.CustomerService;
import com.shavika.foodies.common.service.MenuService;
import com.shavika.foodies.common.service.OrderItemsService;
import com.shavika.foodies.common.service.OrdersService;
import com.shavika.foodies.common.service.PropsService;
import com.shavika.foodies.common.service.UserService;
import com.shavika.foodies.common.utilities.Constants;

@RestController
public class OrderServiceController {

	private static final Logger LOGGER = Logger.getLogger(OrderServiceController.class);

	@Autowired
	private OrdersService ordersService;

	@Autowired
	private OrderItemsService orderItemsService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private PropsService propsService;

	@RequestMapping(value = "/customersService", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getCustomers() throws ShavikaAppException, JsonProcessingException {
		List<Customer> custs = customerService.getAllCustomer();
		System.out.println("Called /customersService service.size" + custs.size());
		if (custs.isEmpty())
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Customer>>(custs, HttpStatus.OK);
	}

	@RequestMapping(value = "/ordersService/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<PraserObject>> getOrders(@PathVariable("id") int id)
			throws ShavikaAppException, JsonProcessingException {
		List<PraserObject> returnData = genrateJsonDataUpdated(id);
		LOGGER.info("Called /ordersService/{id} service.size" + returnData.size());
		if (returnData.isEmpty())
			return new ResponseEntity<List<PraserObject>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<PraserObject>>(returnData, HttpStatus.OK);
	}

	private List<PraserObject> genrateJsonDataUpdated(int filterid)
			throws ShavikaAppException, JsonProcessingException {
		List<Customer> custs = customerService.getAllCustomer();
		List<Menus> menuItems = menuService.getAllMenus();
		List<Orders> orderList = new ArrayList<Orders>();
		if (filterid == 0) {
			orderList = ordersService.getOrdersByStatus();
		} else if (filterid > 0) {
			String _status = (filterid == 1) ? Constants.ORDER_INISIATED
					: ((filterid == 2) ? Constants.ORDER_CONFIRMED
							: (filterid == 3) ? Constants.ORDER_REJECTED : Constants.ORDER_DELIVERED);
			orderList = ordersService.getOrdersByStatus(_status);
		}
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
			for (OrderItem orderItem : orderItemList) {
				menuList.add(menusMap.get(orderItem.getFood_id()));
			}
			obj.setMenus(menuList);
			Praserobjlist.add(obj);
		} // list end.
		return Praserobjlist;
	}

	@RequestMapping(value = "/ordersConfService/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PraserObject>> getMenu(@PathVariable("id") long id)
			throws ShavikaAppException, JsonProcessingException {
		LOGGER.info("Called /ordersConfService/{id} service.id" + id);
		long orfer_id = Long.valueOf(id);
		ordersService.updateStatusbyUI(orfer_id);

		List<PraserObject> returnData = genrateJsonDataUpdated(0);
		LOGGER.info("Called /ordersConfService/{id} service.size=" + returnData.size());
		if (returnData.isEmpty())
			return new ResponseEntity<List<PraserObject>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<PraserObject>>(returnData, HttpStatus.OK);
	}

	@RequestMapping(value = "/ordersBulkConfService/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PraserObject>> bulkConfService(@PathVariable("id") String ids)
			throws ShavikaAppException, JsonProcessingException {
		LOGGER.info("Called /ordersBulkConfService/{id} service.ids=" + ids);
		ordersService.updateStatusbyUI(ids);

		List<PraserObject> returnData = genrateJsonDataUpdated(0);
		LOGGER.info("Called /ordersBulkConfService/{id} service.size=" + returnData.size());
		if (returnData.isEmpty())
			return new ResponseEntity<List<PraserObject>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<PraserObject>>(returnData, HttpStatus.OK);
	}

	@RequestMapping(value = "/syncDashboard", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SyncDashBoard>> syncDashboard() throws ShavikaAppException, JsonProcessingException {
		LOGGER.info("Called /syncDashboard service=");
		List<SyncDashBoard> finalObject = new ArrayList<SyncDashBoard>();
		finalObject.addAll(ordersService.getSyncDashboard());
		finalObject.add(customerService.getSyncDashboard());
		finalObject.add(propsService.getSyncDashboard());

		// finalObject.add(menuService.getSyncDashboard());
		if (finalObject.isEmpty())
			return new ResponseEntity<List<SyncDashBoard>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<SyncDashBoard>>(finalObject, HttpStatus.OK);
	}
}
