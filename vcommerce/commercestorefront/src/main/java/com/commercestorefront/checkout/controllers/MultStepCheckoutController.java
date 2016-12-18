package com.commercestorefront.checkout.controllers;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.commercefacades.data.CartData;
import com.commercefacades.facades.CartFacade;
import com.commercestorefront.controllers.pages.AbstractPageController;

@Controller
@RequestMapping("/multiCheckout")
public class MultStepCheckoutController extends AbstractPageController
{
	private static final String CART= "/cart";
	@Resource(name="cartFacade")
	private CartFacade cartFacade;
	
	public CartFacade getCartFacade() {
		return cartFacade;
	}


	public void setCartFacade(CartFacade cartFacade) {
		this.cartFacade = cartFacade;
	}


	@RequestMapping(method= RequestMethod.GET)
	public String startCheckout(Model model, HttpServletRequest request, HttpServletResponse response)
	{
		if(getCartFacade().checkCart())
		{
			CartData cartData=getCartFacade().getSessionCart();
			model.addAttribute("cartData", cartData);
			
			return "multiCheckoutLandingPage";
		}
		return REDIRECT+CART;
	}
}
