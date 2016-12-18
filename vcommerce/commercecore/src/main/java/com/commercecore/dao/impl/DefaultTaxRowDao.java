package com.commercecore.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.commercecore.dao.TaxRowDao;
import com.commercecore.model.TaxRowModel;


public class DefaultTaxRowDao implements TaxRowDao 
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
		return getSession().getCurrentSession().get(TaxRowModel.class, id);
	}

	public void saveModel(TaxRowModel model) 
	{
		getSession().getCurrentSession().save(model);
	}

	public void updateModel(TaxRowModel model) 
	{
		getSession().getCurrentSession().update(model);
	}

	public void deleteModel(TaxRowModel model) 
	{
		getSession().getCurrentSession().delete(model);
	}

	@SuppressWarnings("unchecked")
	public List<TaxRowModel> getModels() 
	{
		return getSession().getCurrentSession().createQuery("From TaxRowModel").list();
	}

}
