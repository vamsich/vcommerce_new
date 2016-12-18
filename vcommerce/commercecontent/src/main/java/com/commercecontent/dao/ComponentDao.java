package com.commercecontent.dao;

import java.util.List;

import com.commercecontent.model.ComponentModel;

public interface ComponentDao
{
	ComponentModel getModel(int id);
	void saveModel(ComponentModel model);
	void updateModel(ComponentModel model);
	void deleteModel(ComponentModel model);
	List<ComponentModel> getModels();
}
