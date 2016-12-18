package com.commercestorefront.controllers.pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class AccountPageController extends AbstractPageController
{
	
	@RequestMapping(value="/pwd", method=RequestMethod.GET)
	public String updatePasswordPage(Model model, HttpServletRequest request, HttpServletResponse response)
	{
		return null;
	}
	
	@RequestMapping(value="/pwd", method=RequestMethod.POST)
	public String updatePassword(Model model, HttpServletRequest request, HttpServletResponse response)
	{
		return null;
	}
}
