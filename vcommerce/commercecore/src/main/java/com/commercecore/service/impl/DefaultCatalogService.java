package com.commercecore.service.impl;

import java.util.List;

import com.commercecore.dao.CatelogDao;
import com.commercecore.model.CatalogModel;
import com.commercecore.service.CatalogService;


public class DefaultCatalogService implements CatalogService
{
	private CatelogDao catelogDao;
	
	public CatelogDao getCatelogDao() {
		return catelogDao;
	}

	public void setCatelogDao(CatelogDao catelogDao) {
		this.catelogDao = catelogDao;
	}

	public void saveModel(CatalogModel model) 
	{
		catelogDao.saveModel(model);
	}

	public CatalogModel getModel(int id) 
	{
		return (CatalogModel) catelogDao.getModel(id);
	}

	public void deleteMOdel(CatalogModel model) 
	{
		catelogDao.deleteModel(model);
	}

	public void updateModel(CatalogModel model) 
	{
		catelogDao.updateModel(model);
	}

	public List<CatalogModel> getModels() 
	{
		return catelogDao.getModels();
	}
	
}
