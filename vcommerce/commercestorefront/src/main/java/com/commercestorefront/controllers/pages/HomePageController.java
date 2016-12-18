package com.commercestorefront.controllers.pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomePageController extends AbstractPageController
{
	
	@RequestMapping(method= RequestMethod.GET)
	public String getHomePage(Model model,HttpServletRequest request, HttpServletResponse response)
	{
		return "landingPage";
		//return getViewForPage(model,"home");
	}
}
