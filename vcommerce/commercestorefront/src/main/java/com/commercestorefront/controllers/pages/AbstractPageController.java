package com.commercestorefront.controllers.pages;

import org.springframework.ui.Model;

import com.commercefacades.data.ContentPageData;
import com.commercefacades.facades.ContentPageFacade;

public class AbstractPageController 
{
	public static final String REDIRECT= "redirect:";
	
	private ContentPageFacade contentPageFacade;

	public ContentPageFacade getContentPageFacade() {
		return contentPageFacade;
	}

	public void setContentPageFacade(ContentPageFacade contentPageFacade) {
		this.contentPageFacade = contentPageFacade;
	}
	
	public String getViewForPage(String code)
	{
		ContentPageData contentPage=getContentPageFacade().getContentPage(code);
		if(contentPage!=null)
		{
			contentPage.getLabel();
		}
		return null;
	}
	/*
	public static final String REDIRECT= "redirect:";

	@Resource(name="cmsSiteService")
	private CMSSiteService cmsSiteService;
	
	public CMSSiteService getCmsSiteService()
	{
		return cmsSiteService;
	}

	public void setCmsSiteService(CMSSiteService cmsSiteService)
	{
		this.cmsSiteService = cmsSiteService;
	}

	public String getViewForPage(Model model,String code)
	{
		
		if(contentPage!=null)
		{
			iterateComponents(model, contentPage.getPageTemplate());
			return contentPage.getLabel();
		}
		return null;
	}
	
	public String getViewForTemplate(Model model, String code)
	{
		PageTemplateModel pageTemplateModel=getCmsSiteService().getViewForTemplate(code);
		if(pageTemplateModel!=null)
		{
			iterateComponents(model, pageTemplateModel);
			
			if(pageTemplateModel.getDefaultPage()!=null)
			{
				return pageTemplateModel.getDefaultPage().getLabel();
			}
			
		}
		return null;
	}
	
	private void iterateComponents(Model model, PageTemplateModel pageTemplateModel)
	{
		ContentPageModel content= pageTemplateModel.getDefaultPage();
		
		for(PageSlotModel pageSlot:content.getPageSlots())
		{
			if(CollectionUtils.isEmpty(pageSlot.getComponents()))
			{
				for(TemplateSlotModel templateSlot:pageTemplateModel.getAvailableSlots())
				{
					if(templateSlot.getPosition().equalsIgnoreCase(pageSlot.getPosition()))
					{
						populateComponents(model,templateSlot.getComponents(), templateSlot.getPosition());
					}
				}
			}
			else
			{
				populateComponents(model,pageSlot.getComponents(), pageSlot.getPosition());
			}
			
		}
	}
	private void populateComponents(Model model, Set<ComponentModel> components,String position)
	{
		List<String> componentIDs= new ArrayList<String>();
		for(ComponentModel component: components)
		{
			componentIDs.add(String.valueOf(component.getId()));
		}
		model.addAttribute(position, componentIDs);
	}
*/}
