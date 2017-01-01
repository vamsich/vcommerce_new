package com.commercestorefront.controllers.pages;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commercefacades.data.ProductData;
import com.commercefacades.facades.ProductFacade;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/p")
public class ProductPageController 
{
	@Resource(name="productFacade")
	private ProductFacade productFacade;
	
	
	@RequestMapping(value="/create")
	public String createProduct()
	{
		return "forms/createProduct";
	}
	
	@RequestMapping(value="/save")
	public String saveProduct(ProductData productData)
	{
		productFacade.saveProduct(productData);
		return "success";
	}
	
	@RequestMapping(value="/{productCode}")
	@ResponseBody
	public ProductData pdPage(@PathVariable("productCode") final int productCode, final Model model,
			HttpServletRequest request, HttpServletResponse response)
	{
		ProductData productData=productFacade.getProduct(productCode);
		model.addAttribute("productData", productData);
		return productData;
	}
}
