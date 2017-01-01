package com.commercecore.dao;


import java.util.List;

import com.commercebase.core.models.CategoryModel;

public interface CategoryDao
{
	Object getModel(int id);
	void saveModel(CategoryModel model);
	void updateModel(CategoryModel model);
	void deleteModel(CategoryModel model);
	List<CategoryModel> getModels();
}
