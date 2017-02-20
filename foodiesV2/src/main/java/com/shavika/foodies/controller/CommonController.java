package com.shavika.foodies.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shavika.foodies.api.exception.ShavikaAppException;

@Controller
public class CommonController {

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView indexPage(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws ShavikaAppException {
		ModelAndView model = new ModelAndView();
		System.out.println("=================== /protected/index");
		model.setViewName("protected/index");
		return model;
	}

	
}
