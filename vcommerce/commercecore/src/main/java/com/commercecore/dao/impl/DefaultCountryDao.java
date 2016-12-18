package com.commercecore.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.commercecore.dao.CountryDao;
import com.commercecore.model.CountryModel;


public class DefaultCountryDao implements CountryDao
{
	private SessionFactory session;
	
	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}

	public Object getModel(int id) 
	{
		// TODO Auto-generated method stub
		return getSession().getCurrentSession().get(CountryModel.class, id);
	}

	public void saveModel(CountryModel model) 
	{
		getSession().getCurrentSession().save(model);
	}

	public void updateModel(CountryModel model) 
	{
		getSession().getCurrentSession().update(model);
	}

	public void deleteModel(CountryModel model) 
	{
		getSession().getCurrentSession().delete(model);
	}

	@SuppressWarnings("unchecked")
	public List<CountryModel> getModels() 
	{
		return getSession().getCurrentSession().createQuery("From CountryModel").list();
	}
	
}
