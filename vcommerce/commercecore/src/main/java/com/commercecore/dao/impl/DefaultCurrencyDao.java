package com.commercecore.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.commercecore.dao.CurrencyDao;
import com.commercecore.model.CurrencyModel;


public class DefaultCurrencyDao implements CurrencyDao
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
		return getSession().getCurrentSession().get(CurrencyModel.class, id);
	}

	public void saveModel(CurrencyModel model) 
	{
		getSession().getCurrentSession().save(model);
	}

	public void updateModel(CurrencyModel model) 
	{
		getSession().getCurrentSession().update(model);
	}

	public void deleteModel(CurrencyModel model) 
	{
		getSession().getCurrentSession().delete(model);
	}

	@SuppressWarnings("unchecked")
	public List<CurrencyModel> getModels() 
	{
		return getSession().getCurrentSession().createQuery("From CurrencyModel").list();
	}
	
}
