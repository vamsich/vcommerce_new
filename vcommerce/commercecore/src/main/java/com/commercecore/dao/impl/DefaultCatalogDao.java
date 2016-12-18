package com.commercecore.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.commercecore.dao.CatelogDao;
import com.commercecore.model.CatalogModel;


public class DefaultCatalogDao implements CatelogDao
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
		return getSession().getCurrentSession().get(CatalogModel.class, id);
	}

	public void saveModel(CatalogModel model) 
	{
		getSession().getCurrentSession().save(model);
	}

	public void updateModel(CatalogModel model) 
	{
		getSession().getCurrentSession().update(model);
	}

	public void deleteModel(CatalogModel model) 
	{
		getSession().getCurrentSession().delete(model);
	}

	@SuppressWarnings("unchecked")
	public List<CatalogModel> getModels() 
	{
		return getSession().getCurrentSession().createQuery("From BaseSiteModel").list();
	}
	
}
