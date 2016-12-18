package com.commercecore.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import com.commercecore.dao.ProductDao;
import com.commercecore.model.ProductModel;
import com.commercecore.service.ProductService;

public class DefaultProductService implements ProductService
{
	private static final Logger LOG = Logger.getLogger(DefaultProductService.class);
	
	private ProductDao productDao;
	
	
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public ProductModel getModel(int id) 
	{
		ProductModel productModel=(ProductModel) productDao.getModel(id);
		if(productModel==null)
		{
			LOG.info("No product found with id: "+id);
			return null;
		}
		return (ProductModel) productDao.getModel(id);
	}

	public List<ProductModel> getModels() 
	{
		List<ProductModel> products= new ArrayList<ProductModel>();
		products=productDao.getModels();
		return products;
	}

	public void saveModel(ProductModel model) 
	{
		productDao.saveModel(model);
	}

	public void deleteMOdel(ProductModel model) 
	{
		productDao.deleteModel(model);
	}

	public void updateModel(ProductModel model) 
	{
		productDao.updateModel(model);
	}
}
