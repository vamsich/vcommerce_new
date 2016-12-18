package com.commercecore.service;

import java.util.List;

import com.commercebase.core.models.CategoryModel;

public interface CategoryService 
{
	void saveModel(CategoryModel model);
	CategoryModel getModel(int id);
	void deleteMOdel(CategoryModel model);
	void updateModel(CategoryModel model);
	List<CategoryModel> getModels();
}
