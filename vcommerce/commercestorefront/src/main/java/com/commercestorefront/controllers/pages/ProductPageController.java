package com.commercestorefront.controllers.pages;
/*package com.wedevelopwebapp.controller.pages;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wedevelopfacades.data.ProductData;
import com.wedevelopfacades.facades.ProductFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/p")
public class ProductPageController 
{
	private ProductFacade productFacade;
	@RequestMapping(value="/{productCode}")
	public void pdPage(@PathVariable("productCode") final int productCode, final Model model,
			HttpServletRequest request, HttpServletResponse response)
	{
		ProductData productData=productFacade.getProduct(productCode);
		model.addAttribute("productData", productData);
	}
}
*/