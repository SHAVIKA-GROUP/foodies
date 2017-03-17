package com.shavika.foodies.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shavika.foodies.api.dto.UserLogin;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.common.service.UserService;

@Controller
public class CommonController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String welcomePage() {
		System.out.println("=================== /");
		// ModelAndView model = new ModelAndView();
		// model.setViewName("dashboard");
		// return model;
		return "redirect:/index";
	}

	@RequestMapping(value = { "/protected/dashboard" }, method = RequestMethod.GET)
	public ModelAndView dashboardPage() {
		ModelAndView model = new ModelAndView();
		System.out.println("=================== /protected/dashboard");
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws ShavikaAppException {
		ModelAndView model = new ModelAndView();
		System.out.println("=================== /views/index");

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		UserLogin userLogin = this.userService.getUserLoginByName(username);
		session.setAttribute("user", userLogin);
		model.setViewName("protected/index");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
		System.out.println("=================== /login");
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged out from JournalDEV successfully.");
		}

		model.setViewName("public/login");
		return model;
	}
}
