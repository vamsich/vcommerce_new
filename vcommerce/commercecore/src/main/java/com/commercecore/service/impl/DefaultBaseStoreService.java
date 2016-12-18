package com.commercecore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.commercecore.dao.BaseStoreDao;
import com.commercecore.model.BaseStoreModel;
import com.commercecore.service.BaseStoreService;

@Transactional
public class DefaultBaseStoreService implements BaseStoreService
{
	private BaseStoreDao baseStoreDao;
	
	
	public BaseStoreDao getBaseStoreDao() {
		return baseStoreDao;
	}

	public void setBaseStoreDao(BaseStoreDao baseStoreDao) {
		this.baseStoreDao = baseStoreDao;
	}

	public void saveModel(BaseStoreModel model) 
	{
		baseStoreDao.saveModel(model);
	}

	public BaseStoreModel getModel(int id) 
	{
		return (BaseStoreModel) baseStoreDao.getModel(id);
	}

	public void deleteMOdel(BaseStoreModel model) 
	{
		
	}

	public void updateModel(BaseStoreModel model) 
	{
		
	}

	public List<BaseStoreModel> getModels() 
	{
		return baseStoreDao.getModels();
	}

}
