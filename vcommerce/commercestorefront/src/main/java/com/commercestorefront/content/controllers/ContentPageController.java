package com.commercestorefront.content.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commercefacades.data.ContentPageData;
import com.commercefacades.data.ContentSlotData;
import com.commercefacades.facades.ContentPageFacade;
import com.commercefacades.facades.ContentSlotFacade;
import com.commercestorefront.forms.ContentPageForm;
import com.commercestorefront.forms.ContentSlotForm;

@Controller
@RequestMapping("/content")
public class ContentPageController 
{
	@Resource(name="contentPageFacade")
	private ContentPageFacade contentPageFacade;
	
	@Resource(name="contentSlotFacade")
	private ContentSlotFacade contentSlotFacade;
	
	
	@RequestMapping(method= RequestMethod.GET)
	public String createPage(Model model)
	{
		return "forms/contentPageForm";
	}
	
	@RequestMapping(value="/save",method= RequestMethod.POST,produces= "application/json")
	@ResponseBody
	public String savePage(Model model,ContentPageForm contentPageForm)
	{
		ContentPageData contentPageData= new ContentPageData();
		contentPageData.setCode(contentPageForm.getCode());
		contentPageData.setName(contentPageForm.getName());
		contentPageData.setPageName(contentPageForm.getPageName());
		contentPageFacade.save(contentPageData);
		return "success";
	}
	
	@RequestMapping(value="/createSlot",method= RequestMethod.GET)
	public String createSlot(Model model)
	{
		return "forms/addSlot";
	}
	
	@RequestMapping(value="/saveSlot",method= RequestMethod.POST,produces= "application/json")
	@ResponseBody
	public String saveContentSlot(Model model,ContentSlotForm contentSlotForm)
	{
		ContentSlotData contentSlotData= new ContentSlotData();
		contentSlotData.setName(contentSlotForm.getName());
		contentSlotData.setPosition(contentSlotForm.getPosition());
		contentSlotFacade.save(contentSlotData);
		return "success";
	}
}
