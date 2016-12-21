package com.commerceimport.content;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;

import com.commercecontent.model.PageTemplateModel;
import com.commercecontent.model.SlotModel;
import com.commercecontent.service.ContentSlotService;
import com.commercecontent.service.PageTemplateService;


public class PageTemplateFieldSetMapper implements FieldSetMapper<PageTemplateModel> 
{
	private PageTemplateService pageTemplateService;
	
	private ContentSlotService contentSlotService;
	
	
	public ContentSlotService getContentSlotService() {
		return contentSlotService;
	}


	public void setContentSlotService(ContentSlotService contentSlotService) {
		this.contentSlotService = contentSlotService;
	}


	public PageTemplateService getPageTemplateService() {
		return pageTemplateService;
	}


	public void setPageTemplateService(PageTemplateService pageTemplateService) {
		this.pageTemplateService = pageTemplateService;
	}


	public PageTemplateModel mapFieldSet(FieldSet fieldSet) throws BindException 
	{
		PageTemplateModel pageTemplateModel = new PageTemplateModel();
		if(fieldSet.readString(0).contains("slots"))
		{
			pageTemplateModel=getPageTemplateService().getTemplate(fieldSet.readString(1));
			
			Set<SlotModel> slots=pageTemplateModel.getAvailableSlots();
			if(!CollectionUtils.isEmpty(slots))
			{
				List<String> slotsList= new ArrayList<String>(Arrays.asList(fieldSet.readString(2).split(",")));
				for(String slotCode:slotsList)
				{
					SlotModel slotModel=contentSlotService.getSlotForCode(slotCode);
					if(null!=slotModel)
					{
						slots.add(slotModel);
					}
				}
				pageTemplateModel.setAvailableSlots(slots);
			}
			else
			{
				
				List<String> slotsList= new ArrayList<String>(Arrays.asList(fieldSet.readString(2).split(",")));
				Set<SlotModel> newSlots= new HashSet<SlotModel>();
				for(String slotCode:slotsList)
				{
					SlotModel slotModel=contentSlotService.getSlotForCode(slotCode);
					if(null!=slotModel)
					{
						newSlots.add(slotModel);
					}
				}
				pageTemplateModel.setAvailableSlots(newSlots);
			}
		}
		else
		{
			pageTemplateModel.setCode(fieldSet.readString(0));
			pageTemplateModel.setName(fieldSet.readString(1));
			pageTemplateModel.setFrontPageName(fieldSet.readString(2));
		}

		return pageTemplateModel;
	}

}