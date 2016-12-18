package com.commercecore.dao;

import java.util.List;

import com.commercecore.model.LanguageModel;


public interface LanguageDao
{
	Object getModel(int id);
	void saveModel(LanguageModel model);
	void updateModel(LanguageModel model);
	void deleteModel(LanguageModel model);
	List<LanguageModel> getModels();
}
