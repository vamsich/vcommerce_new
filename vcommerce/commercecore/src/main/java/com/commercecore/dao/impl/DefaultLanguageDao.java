package com.commercecore.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.commercecore.dao.LanguageDao;
import com.commercecore.model.LanguageModel;


public class DefaultLanguageDao implements LanguageDao
{
	private SessionFactory session;
	
	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}

	public Object getModel(int id) {
		// TODO Auto-generated method stub
		return getSession().getCurrentSession().get(LanguageModel.class, id);
	}

	public void saveModel(LanguageModel model) 
	{
		getSession().getCurrentSession().save(model);
	}

	public void updateModel(LanguageModel model) 
	{
		getSession().getCurrentSession().update(model);
	}

	public void deleteModel(LanguageModel model) 
	{
		getSession().getCurrentSession().delete(model);
	}

	@SuppressWarnings("unchecked")
	public List<LanguageModel> getModels() 
	{
		return getSession().getCurrentSession().createQuery("From LanguageModel").list();
	}
	
}
