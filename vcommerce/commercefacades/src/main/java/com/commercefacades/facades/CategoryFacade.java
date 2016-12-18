package com.commercefacades.facades;

import java.util.List;

import com.commercebase.core.data.CategoryData;

public interface CategoryFacade 
{
	public void saveCatgory(CategoryData categoryData);
	public List<CategoryData> getCategories();
}
