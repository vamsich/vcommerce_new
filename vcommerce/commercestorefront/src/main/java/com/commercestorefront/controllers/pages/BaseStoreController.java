package com.commercestorefront.controllers.pages;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.commercefacades.data.BaseStoreData;
import com.commercefacades.facades.BaseStoreFacade;
import com.commercestorefront.forms.StoreForm;

@Controller
@RequestMapping("/store")
public class BaseStoreController 
{
	@Resource
	private BaseStoreFacade baseStoreFacade;
	
	public BaseStoreFacade getBaseStoreFacade() {
		return baseStoreFacade;
	}

	public void setBaseStoreFacade(BaseStoreFacade baseStoreFacade) {
		this.baseStoreFacade = baseStoreFacade;
	}

	@RequestMapping(method= RequestMethod.GET)
	public String registerBaseStore()
	{
		return "forms/addStore";
	}
	
	@RequestMapping(value="/save",method= RequestMethod.POST)
	public String saveBaseStore(Model model, StoreForm storeForm)
	{
		BaseStoreData baseStore= new BaseStoreData();
		baseStore.setStoreId(storeForm.getStoreId());
		baseStore.setName(storeForm.getName());
		baseStoreFacade.saveBaseStore(baseStore);
		return "success";
	}
}
