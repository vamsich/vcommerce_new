package com.commercecontent.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.commercecontent.dao.ContentSlotDao;
import com.commercecontent.model.SlotModel;
import com.commercecontent.service.ContentSlotService;

@Transactional
public class DefaultContentSlotService implements ContentSlotService
{
	private ContentSlotDao contentSlotDao;
	
	
	public ContentSlotDao getContentSlotDao() {
		return contentSlotDao;
	}

	public void setContentSlotDao(ContentSlotDao contentSlotDao) {
		this.contentSlotDao = contentSlotDao;
	}

	public void saveModel(SlotModel model) 
	{
		contentSlotDao.saveModel(model);
	}

	public SlotModel getModel(int id) 
	{
		return contentSlotDao.getModel(id);
	}

	public void deleteModel(SlotModel model) 
	{
		contentSlotDao.deleteModel(model);
	}

	public void updateModel(SlotModel model) 
	{
		contentSlotDao.updateModel(model);
	}

	public List<SlotModel> getModels() 
	{
		return contentSlotDao.getModels();
	}

	public SlotModel getSlotForCode(String code) 
	{
		return contentSlotDao.getSlotForCode(code);
	}

	public List<SlotModel> getSlotsForTemplate(int id) 
	{
		List<SlotModel> slots=contentSlotDao.getSlotsForTemplate(id);
		if(CollectionUtils.isEmpty(slots))
		{
			return Collections.emptyList();
		}
		return slots;
	}

}
