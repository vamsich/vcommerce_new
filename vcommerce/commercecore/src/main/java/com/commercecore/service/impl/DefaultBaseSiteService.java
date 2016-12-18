package com.commercecore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.commercecore.dao.BaseSiteDao;
import com.commercecore.model.BaseSiteModel;
import com.commercecore.service.BaseSiteService;

@Transactional
public class DefaultBaseSiteService implements BaseSiteService
{
	private BaseSiteDao baseSiteDao;
	
	public BaseSiteDao getBaseSiteDao() {
		return baseSiteDao;
	}

	public void setBaseSiteDao(BaseSiteDao baseSiteDao) {
		this.baseSiteDao = baseSiteDao;
	}

	public void saveModel(BaseSiteModel model) 
	{
		baseSiteDao.saveModel(model);
	}

	public BaseSiteModel getModel(int id) 
	{
		return (BaseSiteModel) baseSiteDao.getModel(id);
	}

	public void deleteMOdel(BaseSiteModel model) 
	{
		baseSiteDao.deleteModel(model);
	}

	public void updateModel(BaseSiteModel model) 
	{
		baseSiteDao.updateModel(model);
	}

	public List<BaseSiteModel> getModels() 
	{
		return baseSiteDao.getModels();
	}

}
