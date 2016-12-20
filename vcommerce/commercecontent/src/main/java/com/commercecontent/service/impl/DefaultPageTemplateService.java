package com.commercecontent.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.commercecontent.dao.PageTemplateDao;
import com.commercecontent.model.PageTemplateModel;
import com.commercecontent.model.SlotModel;
import com.commercecontent.service.PageTemplateService;

@Transactional
public class DefaultPageTemplateService implements PageTemplateService 
{
	private PageTemplateDao pageTemplateDao;
	
	
	public PageTemplateDao getPageTemplateDao() {
		return pageTemplateDao;
	}

	public void setPageTemplateDao(PageTemplateDao pageTemplateDao) {
		this.pageTemplateDao = pageTemplateDao;
	}

	public PageTemplateModel getModel(int id) 
	{
		return pageTemplateDao.getModel(id);
	}

	public void saveModel(PageTemplateModel model) 
	{
		SlotModel slotModel= new SlotModel();
		slotModel.setCode("ok");
		slotModel.setName("ok");
		slotModel.setPosition("ok");
		Set<SlotModel> slots= new HashSet<SlotModel>();
		slots.add(slotModel);
		model.setAvailableSlots(slots);
		pageTemplateDao.saveModel(model);
	}

	public void updateModel(PageTemplateModel model) 
	{
		pageTemplateDao.updateModel(model);
	}

	public void deleteModel(PageTemplateModel model) 
	{
		pageTemplateDao.deleteModel(model);
	}

	public List<PageTemplateModel> getModels() 
	{
		return pageTemplateDao.getModels();
	}

	public PageTemplateModel getTemplate(String code) 
	{
		// TODO Auto-generated method stub
		return pageTemplateDao.getPageTemplate(code);
	}

}
