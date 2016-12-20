package com.commercecontent.dao;

import java.util.List;

import com.commercecontent.model.PageTemplateModel;

public interface PageTemplateDao 
{
	PageTemplateModel getModel(int id);
	void saveModel(PageTemplateModel model);
	void updateModel(PageTemplateModel model);
	void deleteModel(PageTemplateModel model);
	List<PageTemplateModel> getModels();
	PageTemplateModel getPageTemplate(String code);
}
