package com.shavika.foodies.common.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.shavika.foodies.api.dto.Menus;
import com.shavika.foodies.api.dto.PojoMenuDetail;
import com.shavika.foodies.api.dto.UserLogin;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.common.service.MenuService;
import com.shavika.foodies.common.utilities.DateTimeUtil;

@RestController
public class MenuServiceController {

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/menuservice", method = RequestMethod.GET)
	public ResponseEntity<List<PojoMenuDetail>> listAllMenus() throws ShavikaAppException {
		System.out.println("============= [menuservice]GET All...");
		List<PojoMenuDetail> pojoMenuList = menuService.getAllPojoMenus();
		System.out.println("============= GET All... size=" + pojoMenuList.size());
		System.out.println("============= GET All... pojoMenuList=" + pojoMenuList);
		if (pojoMenuList.isEmpty())
			return new ResponseEntity<List<PojoMenuDetail>>(HttpStatus.NO_CONTENT);
		System.out.println("============= GET All... organizations=123");
		return new ResponseEntity<List<PojoMenuDetail>>(pojoMenuList, HttpStatus.OK);
	}

	@RequestMapping(value = "/menuservice/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PojoMenuDetail> getMenu(@PathVariable("id") long id) throws ShavikaAppException {
		System.out.println("============= [menuservice]GET.../" + id);
		List<Menus> menuList = menuService.getMenuByUniqueId(id);
		System.out.println("============= menuList=" + menuList);
		if (menuList.isEmpty())
			return new ResponseEntity<PojoMenuDetail>(HttpStatus.NO_CONTENT);
		PojoMenuDetail _pojoMenuDetail = menuService.parseMenuByPojo(menuList);
		System.out.println("============= _pojoMenuDetail=" + _pojoMenuDetail);
		return new ResponseEntity<PojoMenuDetail>(_pojoMenuDetail, HttpStatus.OK);
	}

	@RequestMapping(value = "/menuservice", method = RequestMethod.POST)
	public ResponseEntity<PojoMenuDetail> createMenu(@RequestBody PojoMenuDetail pojoMenuDetail,
			UriComponentsBuilder ucBuilder) throws ShavikaAppException {
		System.out.println("============= [menuservice] CREATE...");
		System.out.println("============= pojoMenuDetail=" + pojoMenuDetail);
		Menus menu = menuService.parseMenuByPojo(pojoMenuDetail);
		System.out.println("============= menu=" + menu);
		List<Menus> menuList = menuService.insertRUpdateMenu(menu);
		System.out.println("============= menuList=" + menuList);
		PojoMenuDetail _pojoMenuDetail = menuService.parseMenuByPojo(menuList);
		System.out.println("============= _pojoMenuDetail=" + _pojoMenuDetail);
		// HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/menuservice/{id}").buildAndExpand(_menu.getId()).toUri());
		return new ResponseEntity<PojoMenuDetail>(_pojoMenuDetail, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/menuserviceforDashboard", method = RequestMethod.GET)
	public ResponseEntity<List<PojoMenuDetail>> listMenus4dashboard() throws ShavikaAppException {
		System.out.println("============= [menuserviceforDashboard]GET All...");
		List<PojoMenuDetail> pojoMenuList = new ArrayList<PojoMenuDetail>();
		pojoMenuList.add(menuService.getSyncDashboard());		
		System.out.println("============= GET All... size=" + pojoMenuList.size());
		System.out.println("============= GET All... pojoMenuList=" + pojoMenuList);
		if (pojoMenuList.isEmpty())
			return new ResponseEntity<List<PojoMenuDetail>>(HttpStatus.NO_CONTENT);
		System.out.println("============= GET All... menuserviceforDashboard=123");
		return new ResponseEntity<List<PojoMenuDetail>>(pojoMenuList, HttpStatus.OK);
	}


}
