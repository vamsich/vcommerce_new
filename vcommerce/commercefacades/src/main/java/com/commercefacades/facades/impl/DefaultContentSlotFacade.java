package com.commercefacades.facades.impl;

import com.commercecontent.model.SlotModel;
import com.commercecontent.service.ContentSlotService;
import com.commercefacades.converters.Converters;
import com.commercefacades.data.ContentSlotData;
import com.commercefacades.facades.ContentSlotFacade;

public class DefaultContentSlotFacade implements ContentSlotFacade
{
	Converters<SlotModel, ContentSlotData> contentSlotConverter;
	
	private ContentSlotService contentSlotService;
	
	
	public Converters<SlotModel, ContentSlotData> getContentSlotConverter() {
		return contentSlotConverter;
	}

	public void setContentSlotConverter(Converters<SlotModel, ContentSlotData> contentSlotConverter) {
		this.contentSlotConverter = contentSlotConverter;
	}

	public ContentSlotService getContentSlotService() {
		return contentSlotService;
	}

	public void setContentSlotService(ContentSlotService contentSlotService) {
		this.contentSlotService = contentSlotService;
	}

	public ContentSlotData getSlot(int id) 
	{
		return contentSlotConverter.convert(contentSlotService.getModel(id));
	}

	public void save(ContentSlotData contentSlot) 
	{
		SlotModel contentSlotModel= new SlotModel();
		contentSlotModel.setPosition(contentSlot.getPosition());
		contentSlotModel.setName(contentSlot.getPosition());
		contentSlotService.saveModel(contentSlotModel);
	}

}
