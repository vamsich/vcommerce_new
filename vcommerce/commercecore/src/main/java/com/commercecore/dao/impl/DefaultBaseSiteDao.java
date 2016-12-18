package com.commercecore.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.commercecore.dao.BaseSiteDao;
import com.commercecore.model.BaseSiteModel;


public class DefaultBaseSiteDao implements BaseSiteDao 
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
		return getSession().getCurrentSession().get(BaseSiteModel.class, id);
	}

	public void saveModel(BaseSiteModel model) 
	{
		getSession().getCurrentSession().save(model);
	}

	public void updateModel(BaseSiteModel model) 
	{
		getSession().getCurrentSession().update(model);
	}

	public void deleteModel(BaseSiteModel model) 
	{
		getSession().getCurrentSession().delete(model);
	}

	@SuppressWarnings("unchecked")
	public List<BaseSiteModel> getModels() 
	{
		return getSession().getCurrentSession().createQuery("From BaseSiteModel").list();
	}

}
