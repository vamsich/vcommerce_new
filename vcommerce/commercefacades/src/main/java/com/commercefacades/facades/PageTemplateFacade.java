package com.commercefacades.facades;

import java.util.List;

import com.commercebase.content.data.PageTemplateData;

public interface PageTemplateFacade 
{
	PageTemplateData getModel(int id);
	void saveModel(PageTemplateData pageTemplate);
	void updateModel(PageTemplateData pageTemplateData);
	void deleteModel(PageTemplateData model);
	List<PageTemplateData> getModels();
}
