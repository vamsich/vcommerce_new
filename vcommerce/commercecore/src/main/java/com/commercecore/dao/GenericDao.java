package com.commercecore.dao;

import java.util.List;

public interface GenericDao<T> 
{
	Object getModel(int id);
	void saveModel(T model);
	void updateModel(T model);
	void deleteModel(T model);
	List<T> getModels();
}
