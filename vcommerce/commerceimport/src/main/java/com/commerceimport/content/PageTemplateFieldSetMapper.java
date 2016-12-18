package com.commerceimport.content;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.commercecontent.model.PageTemplateModel;


public class PageTemplateFieldSetMapper implements FieldSetMapper<PageTemplateModel> 
{

	public PageTemplateModel mapFieldSet(FieldSet fieldSet) throws BindException 
	{
		PageTemplateModel pageTemplateModel = new PageTemplateModel();
		pageTemplateModel.setCode(fieldSet.readString(0));
		pageTemplateModel.setName(fieldSet.readString(1));
		pageTemplateModel.setFrontPageName(fieldSet.readString(2));

		return pageTemplateModel;
	}

}