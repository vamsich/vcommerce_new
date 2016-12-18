package com.commercecore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.commercecore.dao.PriceRowDao;
import com.commercecore.model.PriceRowModel;
import com.commercecore.service.PriceRowService;

public class DefaultPriceRowService implements PriceRowService 
{
	private static final Logger LOG = Logger.getLogger(DefaultPriceRowService.class);
	
	private PriceRowDao priceRowDao;
	
	
	public PriceRowDao getPriceRowDao() {
		return priceRowDao;
	}

	public void setPriceRowDao(PriceRowDao priceRowDao) {
		this.priceRowDao = priceRowDao;
	}

	public PriceRowModel getModel(int id) 
	{
		PriceRowModel priceRow=(PriceRowModel) priceRowDao.getModel(id);
		
		if(priceRow==null)
		{
			LOG.info("no price row found with id: "+id);
			return null;
		}
		return priceRow;
	}

	public List<PriceRowModel> getModels() 
	{
		List<PriceRowModel> categories= new ArrayList<PriceRowModel>();
		categories=priceRowDao.getModels();
		return categories;
	}

	public void saveModel(PriceRowModel model) 
	{
		priceRowDao.saveModel(model);
	}


	public void deleteMOdel(PriceRowModel model) 
	{
		priceRowDao.deleteModel(model);
	}

	public void updateModel(PriceRowModel model) 
	{
		priceRowDao.updateModel(model);
	}

}
