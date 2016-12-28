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
		if(fieldSet.readString(0).contains("Slots"))
		{
			PageTemplateModel pageTemplateModel = new PageTemplateModel();
			pageTemplateModel=getPageTemplateService().getTemplate(fieldSet.readString(2));
			List<SlotModel> slots=new ArrayList<SlotModel>();
			if(null != pageTemplateModel)
			{
				slots=contentSlotService.getSlotsForTemplate(pageTemplateModel.getId());
			}
			
			if(null!= slots && !CollectionUtils.isEmpty(slots))
			{
				List<String> slotsList= new ArrayList<String>(Arrays.asList(fieldSet.readString(3).split(",")));
				for(String slotCode:slotsList)
				{
					SlotModel slotModel=contentSlotService.getSlotForCode(slotCode);
					if(null!=slotModel)
					{
						slots.add(slotModel);
					}
				}
				Set<SlotModel> listOfSlots= new HashSet<SlotModel>(slots);
				pageTemplateModel.setAvailableSlots(listOfSlots);
			}
			else
			{
				
				List<String> slotsList= new ArrayList<String>(Arrays.asList(fieldSet.readString(3).split(",")));
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
			return pageTemplateModel;
		}
		else
		{
			PageTemplateModel pageTemplateModel = new PageTemplateModel();
			pageTemplateModel.setCode(fieldSet.readString(2));
			pageTemplateModel.setName(fieldSet.readString(3));
			pageTemplateModel.setFrontPageName(fieldSet.readString(4));
			return pageTemplateModel;
		}

	}

}