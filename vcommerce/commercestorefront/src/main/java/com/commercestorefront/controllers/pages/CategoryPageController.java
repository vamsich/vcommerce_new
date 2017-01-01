package com.commercestorefront.controllers.pages;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commercebase.content.data.CategoryData;
import com.commercefacades.data.ProductData;
import com.commercefacades.facades.CategoryFacade;

@Controller
@RequestMapping("/c")
public class CategoryPageController 
{
	@Resource(name="categoryFacade")
	private CategoryFacade categoryFacade;
	
	@RequestMapping(value="/create")
	public String createCategory()
	{
		return "forms/createCategory";
	}
	
	@RequestMapping(value="/save")
	@ResponseBody
	public String saveProduct(CategoryData categoryData)
	{
		categoryFacade.saveCatgory(categoryData);
		return "success";
	}
	@RequestMapping("/{categoryCode}")
	public String categoryPage(@PathVariable("categoryCode")final String categoryCode, Model model,
			HttpServletRequest request, HttpServletResponse response)
	{
		return null;
	}
}
