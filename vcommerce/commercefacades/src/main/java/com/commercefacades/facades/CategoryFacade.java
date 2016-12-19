package com.commercefacades.facades;

import java.util.List;

import com.commercebase.content.data.CategoryData;


public interface CategoryFacade 
{
	public void saveCatgory(CategoryData categoryData);
	public List<CategoryData> getCategories();
}
