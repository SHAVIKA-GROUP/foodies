package com.shavika.foodies.common.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.shavika.foodies.api.dto.Menus;
import com.shavika.foodies.api.dto.PojoMenuDetail;
import com.shavika.foodies.api.dto.Props;
import com.shavika.foodies.api.dto.UserLogin;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.common.service.MenuService;
import com.shavika.foodies.common.service.PropsService;
import com.shavika.foodies.common.service.UserService;
import com.shavika.foodies.common.utilities.Constants;

@RestController
public class MenuServiceController {

	@Autowired
	private MenuService menuService;

	@Autowired
	private UserService userService;

	@Autowired
	private PropsService propsService;

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
			HttpServletRequest request, UriComponentsBuilder ucBuilder) throws ShavikaAppException {
		System.out.println("============= [menuservice] CREATE...");
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		System.out.println("============= pojoMenuDetail=" + pojoMenuDetail);
		Menus menu = menuService.parseMenuByPojo(pojoMenuDetail, rootDirectory);
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

	@RequestMapping(value = "/menuservice/image", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> menuImage(@RequestParam("file") MultipartFile file,
			@RequestParam("filename") String filename, HttpServletRequest request, UriComponentsBuilder ucBuilder)
			throws ShavikaAppException {
		System.out.println("============= [menuservice/image] Upload...");
		String returndata = "{\"error\" : \"No content found\"}";
		if (file.isEmpty()) {
			return new ResponseEntity<String>(returndata, HttpStatus.NO_CONTENT);
		}
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		String imageDirectory = rootDirectory + Constants.IMAGE_FILE_PATH + File.separator;
		String _filename = file.getOriginalFilename();
		String _extension = _filename.substring(_filename.indexOf(".") + 1).toString();
		String finalName = filename.toString() + "." + _extension;
		System.out.println("finalName ===========>" + returndata);
		try {
			Constants.clearImageIfExist(finalName, rootDirectory);
			file.transferTo(new File(imageDirectory + finalName));
			returndata = "{\"filename\" : \"" + filename.toString() + "\"}";
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(returndata, HttpStatus.NO_CONTENT);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(returndata, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>(returndata, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/menuBlockStatConfgservice", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Props> getMenuBlockStatusConfg() throws ShavikaAppException {
		System.out.println("============= [menuBlockStatConfgservice]GET.../");
		Props props = propsService.updateSyncDashboard();
		if (props == null)
			return new ResponseEntity<Props>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Props>(props, HttpStatus.OK);
	}


}
