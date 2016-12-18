package com.commercecore.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.commercecore.dao.PriceRowDao;
import com.commercecore.model.PriceRowModel;

public class DefaultPriceRowDao implements PriceRowDao
{

	private SessionFactory session;
	
	
	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<PriceRowModel> getModels() 
	{
		return session.getCurrentSession().createQuery("From PriceRowModel").list();
	}
	
	@Transactional
	public Object getModel(int id) 
	{
		return session.getCurrentSession().get(PriceRowModel.class, id);
	}

	public void saveModel(PriceRowModel model) 
	{
		session.getCurrentSession().save(model);
	}

	public void updateModel(PriceRowModel model) 
	{
		session.getCurrentSession().update(model);
	}

	public void deleteModel(PriceRowModel model) 
	{
		session.getCurrentSession().delete(model);
	}

}
