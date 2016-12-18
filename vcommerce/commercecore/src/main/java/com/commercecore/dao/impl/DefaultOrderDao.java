package com.commercecore.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.commercecore.dao.OrderDao;
import com.commercecore.model.OrderModel;


public class DefaultOrderDao implements OrderDao
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
		return session.getCurrentSession().get(OrderModel.class, id);
	}

	public void saveModel(OrderModel model) 
	{
		session.getCurrentSession().save(model);
	}

	public void updateModel(OrderModel model) 
	{
		session.getCurrentSession().update(model);	
	}

	public void deleteModel(OrderModel model) 
	{
		session.getCurrentSession().delete(model);
	}

	@SuppressWarnings("unchecked")
	public List<OrderModel> getModels() 
	{
		return session.getCurrentSession().createQuery("From CategoryModel").list();
	}
	
}
