package com.shavika.foodies.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.shavika.foodies.api.dto.UserLogin;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.common.service.UserService;

@RestController
public class UserLoginRSController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/userlogin", method = RequestMethod.GET)
	public ResponseEntity<List<UserLogin>> listAllUserLogin() throws ShavikaAppException {
		System.out.println("============= GET All...");
		List<UserLogin> userlogins = userService.getAllUserLogin();
		System.out.println("============= GET All... size="+userlogins.size());
		System.out.println("============= GET All... organizations="+userlogins);
		if (userlogins.isEmpty())
			return new ResponseEntity<List<UserLogin>>(HttpStatus.NO_CONTENT);
		System.out.println("============= GET All... organizations=123");
		return new ResponseEntity<List<UserLogin>>(userlogins, HttpStatus.OK);
	}

	@RequestMapping(value = "/userlogin/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserLogin> getOrganization(@PathVariable("id") long id) throws ShavikaAppException {
		System.out.println("============= GET.../"+id);
		UserLogin userlogin = userService.getUserLoginById(id);
		System.out.println("============= GET ... userlogin="+userlogin);
		if (userlogin == null)
			return new ResponseEntity<UserLogin>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<UserLogin>(userlogin, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public ResponseEntity<UserLogin> createOrganization(@RequestBody UserLogin userLogin, UriComponentsBuilder ucBuilder) throws ShavikaAppException {
		System.out.println("============= CREATE...");
		System.out.println("============= organization="+userLogin);
		UserLogin _userLogin = userService.insertUser(userLogin);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/userlogin/{id}").buildAndExpand(userLogin.getId()).toUri());
		return new ResponseEntity<UserLogin>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/userlogin/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserLogin> updateOrganization(@PathVariable("id") long id, @RequestBody UserLogin userLogin) throws ShavikaAppException {
		System.out.println("============= UPDATE...");
		System.out.println("============= id="+id);
		System.out.println("============= organization="+userLogin);
		UserLogin _userLogin = userService.getUserLoginById(id);
		if (_userLogin == null)
			return new ResponseEntity<UserLogin>(HttpStatus.NOT_FOUND);
		_userLogin.setUsername(userLogin.getUsername());
		_userLogin.setEmail(userLogin.getEmail());
		_userLogin.setPassword(userLogin.getPassword());
		userService.updateUser(_userLogin);
		return new ResponseEntity<UserLogin>(_userLogin, HttpStatus.OK);
	}

	@RequestMapping(value = "/userlogin/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserLogin> deleteOrganization(@PathVariable("id") long id) throws ShavikaAppException {
		System.out.println("============= DELETE...");
		System.out.println("============= id="+id);
		UserLogin _userLogin = userService.getUserLoginById(id);
		if (_userLogin == null)
			return new ResponseEntity<UserLogin>(HttpStatus.NOT_FOUND);
		userService.delete(_userLogin);
		return new ResponseEntity<UserLogin>(HttpStatus.NO_CONTENT);
	}

}
