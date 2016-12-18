package com.commercecore.service;

import java.util.List;

public interface ModelService<T> 
{
	void saveModel(T model);
	T getModel(int id);
	void deleteMOdel(T model);
	void updateModel(T model);
	List<T> getModels();
}
