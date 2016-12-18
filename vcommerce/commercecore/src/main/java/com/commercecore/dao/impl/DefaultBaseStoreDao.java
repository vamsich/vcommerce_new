package com.commercecore.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.commercecore.dao.BaseStoreDao;
import com.commercecore.model.BaseStoreModel;

public class DefaultBaseStoreDao implements BaseStoreDao 
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
		return getSession().getCurrentSession().get(BaseStoreModel.class, id);
	}

	public void saveModel(BaseStoreModel model) 
	{
		getSession().getCurrentSession().save(model);
	}

	public void updateModel(BaseStoreModel model) 
	{
		getSession().getCurrentSession().update(model);
	}

	public void deleteModel(BaseStoreModel model) 
	{
		getSession().getCurrentSession().delete(model);
	}

	@SuppressWarnings("unchecked")
	public List<BaseStoreModel> getModels() {
		return getSession().getCurrentSession().createQuery("From BaseStoreModel").list();
	}
	
}
