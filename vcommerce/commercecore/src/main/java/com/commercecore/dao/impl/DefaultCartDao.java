package com.commercecore.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.commercecore.dao.CartDao;
import com.commercecore.model.CartModel;


public class DefaultCartDao implements CartDao 
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
		return session.getCurrentSession().get(CartModel.class, id);
	}

	public void saveModel(CartModel model) 
	{
		session.getCurrentSession().save(model);
	}

	public void updateModel(CartModel model) 
	{
		session.getCurrentSession().update(model);
	}

	public void deleteModel(CartModel model) 
	{
		session.getCurrentSession().delete(model);
	}

	@SuppressWarnings("unchecked")
	public List<CartModel> getModels() 
	{
		return session.getCurrentSession().createQuery("From CartModel").list();
	}

}
