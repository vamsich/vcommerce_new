package com.commercecontent.dao.impl;

import java.util.Collections;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.util.CollectionUtils;

import com.commercecontent.dao.PageTemplateDao;
import com.commercecontent.model.PageTemplateModel;

public class DefaultPageTemplateDao implements PageTemplateDao
{
	private SessionFactory session;
	
	public SessionFactory getSession() 
	{
		return session;
	}

	public void setSession(SessionFactory session) 
	{
		this.session = session;
	}

	public PageTemplateModel getModel(int id) 
	{
		return (PageTemplateModel) session.getCurrentSession().get(PageTemplateModel.class, id);
	}

	public void saveModel(PageTemplateModel model) 
	{
		session.getCurrentSession().save(model);
	}

	public void updateModel(PageTemplateModel model) 
	{
		session.getCurrentSession().update(model);
	}

	public void deleteModel(PageTemplateModel model) 
	{
		session.getCurrentSession().delete(model);
	}

	public List<PageTemplateModel> getModels() 
	{
		return null;
	}

	@SuppressWarnings("unchecked")
	public PageTemplateModel getPageTemplate(String code) 
	{
		List<PageTemplateModel> templates=session.getCurrentSession().createQuery("From PageTemplateModel where code=:code").setParameter("code", code).list();
		if(CollectionUtils.isEmpty(templates))
		{
			return null;
		}
		return templates.get(0);
	}

}
