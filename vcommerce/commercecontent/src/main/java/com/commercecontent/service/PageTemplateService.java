package com.commercecontent.service;

import java.util.List;

import com.commercecontent.model.PageTemplateModel;

public interface PageTemplateService 
{
	PageTemplateModel getModel(int id);
	void saveModel(PageTemplateModel model);
	void updateModel(PageTemplateModel model);
	void deleteModel(PageTemplateModel model);
	List<PageTemplateModel> getModels();
	PageTemplateModel getTemplate(String code);
}
