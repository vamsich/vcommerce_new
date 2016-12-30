package com.commercefacades.facades.impl;

import java.util.List;

import com.commercebase.content.data.CategoryData;
import com.commercebase.core.models.CategoryModel;
import com.commercecore.service.CategoryService;
import com.commercefacades.converters.Converters;
import com.commercefacades.facades.CategoryFacade;

public class DefaultCategoryFacade implements CategoryFacade 
{
	private CategoryService categoryService;
	
	private Converters<CategoryModel, CategoryData> categoryConverter;
	
	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Converters<CategoryModel, CategoryData> getCategoryConverter() {
		return categoryConverter;
	}

	public void setCategoryConverter(Converters<CategoryModel, CategoryData> categoryConverter) {
		this.categoryConverter = categoryConverter;
	}

	public void saveCatgory(CategoryData categoryData) 
	{
		CategoryModel categoryModel= new CategoryModel();
		categoryModel.setCode(categoryData.getCode());
		categoryModel.setName(categoryData.getName());
		categoryService.saveModel(categoryModel);
	}

	public List<CategoryData> getCategories() 
	{
		categoryService.getModels();
		return null;
	}

}
