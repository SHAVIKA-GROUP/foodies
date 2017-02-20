package com.shavika.foodies.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shavika.foodies.api.dto.Customer;
import com.shavika.foodies.api.dto.FoodItem;
import com.shavika.foodies.api.dto.Login;
import com.shavika.foodies.api.dto.OrderItem;
import com.shavika.foodies.api.dto.Orders;
import com.shavika.foodies.api.dto.PraserObject;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.service.CustomerService;
import com.shavika.foodies.service.FoodsService;
import com.shavika.foodies.service.LoginService;
import com.shavika.foodies.service.OrderItemsService;
import com.shavika.foodies.service.OrdersService;
import com.shavika.foodies.util.Constants;

@RestController
public class LoginController {

	private static final Logger LOGGER = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private OrdersService ordersService;

	@Autowired
	private OrderItemsService orderItemsService;

	@Autowired
	private FoodsService foodsService;

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/loginformService", method = RequestMethod.POST)
	public ResponseEntity<String> verifyLogin(HttpServletRequest req, HttpServletResponse res, HttpSession session)
			throws ShavikaAppException {
		String returnObject = null;
		String login_type = req.getParameter("loginType").trim().toString();
		int loginType = Integer.parseInt(login_type.trim().toString());
		LOGGER.info("[processRequest] ============== called loginformService/" + loginType);
		if (loginType == Constants.LOGIN_TYPE) {
			String username = req.getParameter("loginuserid");
			String password = req.getParameter("loginpassword");
			Login login = this.loginService.getUserLoginByNamePwd(username, password);
			returnObject = loginService.genrateResponse(((login != null) ? true : false), loginType);
			return new ResponseEntity<String>(returnObject, HttpStatus.OK);
		}
		return new ResponseEntity<String>(returnObject, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/forgetformService", method = RequestMethod.POST)
	public ResponseEntity<String> forgetPassword(HttpServletRequest req, HttpServletResponse res, HttpSession session)
			throws ShavikaAppException {
		String returnObject = null;
		String login_type = req.getParameter("loginType").trim().toString();
		int loginType = Integer.parseInt(login_type.trim().toString());
		LOGGER.info("[processRequest] ============== called forgetformService/" + loginType);
		if (loginType == Constants.FORGOTPASSWORD_TYPE) {
			String email = req.getParameter("forgotpwdEmail");
			LOGGER.info("[processRequest] ============== email=" + email);
			Login login = loginService.getUserLoginByEmail(email);
			LOGGER.info("==>USER=" + login.getUser_name() + "/PWD" + login.getPassword());
			returnObject = loginService.genrateResponse((login != null) ? true : false, loginType);
			return new ResponseEntity<String>(returnObject, HttpStatus.OK);
		}
		return new ResponseEntity<String>(returnObject, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/registrationformService", method = RequestMethod.POST)
	public ResponseEntity<String> registration(HttpServletRequest req, HttpServletResponse res, HttpSession session)
			throws ShavikaAppException {
		String returnObject = null;
		String login_type = req.getParameter("loginType").trim().toString();
		int loginType = Integer.parseInt(login_type.trim().toString());
		LOGGER.info("[processRequest] ============== called registrationformService/" + loginType);
		if (loginType == Constants.REGISTERATION_TYPE) {
			Login login = loginService.createRupdateUser(loginService.getRequestUser(req));
			LOGGER.info("[processRequest] ============== login=" + login);
			returnObject = loginService.genrateResponse((login != null) ? true : false, loginType);
			return new ResponseEntity<String>(returnObject, HttpStatus.OK);
		}
		return new ResponseEntity<String>(returnObject, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/ordersService", method = RequestMethod.GET)
	public ResponseEntity<List<PraserObject>> getOrders(HttpServletRequest req, HttpServletResponse res,
			HttpSession session) throws ShavikaAppException, JsonProcessingException {
		List<PraserObject> returnData = genrateJsonData();
		return new ResponseEntity<List<PraserObject>>(returnData, HttpStatus.OK);
	}

	private List<PraserObject> genrateJsonData() throws ShavikaAppException, JsonProcessingException {
		List<Customer> custs = customerService.getAllCustomer();
		List<FoodItem> foodItems = foodsService.getAllFoodItems();
		List<Orders> orderList = ordersService.getOrdersByStatus();

		Map<Long, Customer> customerMap = new HashMap<Long, Customer>();
		for (Customer cust : custs)
			customerMap.put(cust.getCustomer_item_id(), cust);

		Map<Long, FoodItem> foodsMap = new HashMap<Long, FoodItem>();
		for (FoodItem foods : foodItems)
			foodsMap.put(foods.getId(), foods);

		List<PraserObject> Praserobjlist = new ArrayList<PraserObject>();
		for (Orders ords : orderList) {
			PraserObject obj = new PraserObject();
			obj.setOrders(ords);
			obj.setCustomer(customerMap.get(ords.getCustomer_item_id()));
			List<OrderItem> orderItemList = orderItemsService.getOrderItemsByOrderId(ords.getOrder_item_id());
			obj.setOrderitems(orderItemList);
			obj.setFoods(foodItems);
			Praserobjlist.add(obj);
		}
		return Praserobjlist;

		/*
		 * final ObjectMapper mapper = new ObjectMapper(); ArrayNode arrayNode =
		 * mapper.createArrayNode();
		 * 
		 * for (Orders ords : orderList) { ObjectNode objNode =
		 * mapper.createObjectNode(); objNode. //objNode.putPOJO("orders",
		 * ords); //objNode.putPOJO("customers",
		 * customerMap.get(ords.getCustomer_item_id()));
		 * 
		 * List<OrderItem> orderItemList =
		 * orderItemsService.getOrderItemsByOrderId(ords.getOrder_item_id());
		 * ArrayNode ordItemArrayNode = mapper.createArrayNode(); for (OrderItem
		 * ordItem : orderItemList) { ObjectNode innerObj =
		 * mapper.createObjectNode(); innerObj.putPOJO("orderitem", ordItem);
		 * innerObj.putPOJO("foods", foodsMap.get(ordItem.getFood_id()));
		 * ordItemArrayNode.add(innerObj); } // inner for
		 * //objNode.putPOJO("orderitems", ordItemArrayNode);
		 * arrayNode.add(objNode); } // outer for
		 * System.out.println(mapper.writerWithDefaultPrettyPrinter().
		 * writeValueAsString(arrayNode)); return arrayNode.toString();
		 */
	}

	@RequestMapping(value = "/ordersConfService", method = RequestMethod.GET)
	public ResponseEntity<List<PraserObject>> confirmOrder(HttpServletRequest req, HttpServletResponse res,
			HttpSession session) throws ShavikaAppException, JsonProcessingException {
		System.out.println("Called in ordersConfService...");
		long orfer_id = Long.valueOf(req.getParameter("order_id"));
		System.out.println("orfer_id==>" + orfer_id);
		ordersService.updateStatusbyUI(orfer_id);
		List<PraserObject> returnData = genrateJsonData();
		return new ResponseEntity<List<PraserObject>>(returnData, HttpStatus.OK);
	}
}
