package com.commercecontent.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.commercecontent.dao.ContentPageDao;
import com.commercecontent.model.ContentPageModel;
import com.commercecontent.model.SlotModel;
import com.commercecontent.service.ContentPageService;

@Transactional
public class DefaultContentPageService implements ContentPageService
{
	private ContentPageDao contentPageDao;
	
	public ContentPageDao getContentPageDao() {
		return contentPageDao;
	}

	public void setContentPageDao(ContentPageDao contentPageDao) {
		this.contentPageDao = contentPageDao;
	}

	public void saveModel(ContentPageModel model) 
	{
		SlotModel slot= new SlotModel();
		slot.setCode("sample");
		slot.setPosition("sample");
		Set<SlotModel> slots= new HashSet<SlotModel>();
		slots.add(slot);
		model.setSlots(slots);
		getContentPageDao().saveModel(model);
	}

	public ContentPageModel getModel(int id) 
	{
		return getContentPageDao().getModel(id);
	}

	public void deleteMOdel(ContentPageModel model) 
	{
		getContentPageDao().deleteModel(model);
	}

	public void updateModel(ContentPageModel model) 
	{
		getContentPageDao().updateModel(model);
	}

	public List<ContentPageModel> getModels() 
	{
		return null;
	}

	public ContentPageModel getContentPageForCode(String code) 
	{
		return contentPageDao.getPageForCode(code);
	}

	public ContentPageModel getContentPage(String code) 
	{
		return contentPageDao.getPageForCode(code);
	}

}
