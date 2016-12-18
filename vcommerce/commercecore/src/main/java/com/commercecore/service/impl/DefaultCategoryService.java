package com.commercecore.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import com.commercecore.dao.CategoryDao;
import com.commercebase.core.models.CategoryModel;
import com.commercecore.service.CategoryService;


public class DefaultCategoryService implements CategoryService
{
	private static final Logger LOG = Logger.getLogger(DefaultCategoryService.class);
	
	private CategoryDao categoryDao;
	
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public CategoryModel getCategory(int id) 
	{
		CategoryModel category=(CategoryModel) categoryDao.getModel(id);
		if(category==null)
		{
			LOG.info("No category found with id "+id);
			return null;
		}
		return category;
	}
	
	public List<CategoryModel> getModels() 
	{
		List<CategoryModel> categories= new ArrayList<CategoryModel>();
		categories=categoryDao.getModels();
		return categories;
	}

	public void saveModel(CategoryModel model) 
	{
		categoryDao.saveModel(model);
	}

	public CategoryModel getModel(int id) 
	{
		return (CategoryModel) categoryDao.getModel(id);
	}

	public void deleteMOdel(CategoryModel model) 
	{
		categoryDao.deleteModel(model);
	}

	public void updateModel(CategoryModel model) 
	{
		categoryDao.updateModel(model);
	}
	
}
