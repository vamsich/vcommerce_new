package com.commercecore.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.commercecore.dao.InventoryDao;
import com.commercecore.model.InventoryModel;


public class DefaultInventoryDao implements InventoryDao
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
		return getSession().getCurrentSession().get(InventoryModel.class, id);
	}

	public void saveModel(InventoryModel model) 
	{
		getSession().getCurrentSession().save(model);
	}

	public void updateModel(InventoryModel model) 
	{
		getSession().getCurrentSession().update(model);
	}

	public void deleteModel(InventoryModel model) 
	{
		getSession().getCurrentSession().delete(model);
	}

	@SuppressWarnings("unchecked")
	public List<InventoryModel> getModels() 
	{
		return getSession().getCurrentSession().createQuery("From InventoryModel").list();
	}
	
}
