package com.commercefacades.facades.impl;

import java.util.List;

import com.commercebase.core.data.CategoryData;
import com.commercecore.service.CategoryService;
import com.commercefacades.facades.CategoryFacade;

public class DefaultCategoryFacadeImpl implements CategoryFacade 
{
	CategoryService categoryService;
	
	public void saveCatgory(CategoryData categoryData) 
	{
		
	}

	public List<CategoryData> getCategories() 
	{
		return null;
	}

}
