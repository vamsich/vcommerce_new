package com.commercecore.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.commercecore.dao.AddressDao;
import com.commercecore.model.AddressModel;


public class DefaultAddressDao implements AddressDao 
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
		return getSession().getCurrentSession().get(AddressModel.class, id);
	}

	public void saveModel(AddressModel model) 
	{
		getSession().getCurrentSession().save(model);
	}

	public void updateModel(AddressModel model) 
	{
		getSession().getCurrentSession().update(model);
	}

	public void deleteModel(AddressModel model) 
	{
		getSession().getCurrentSession().delete(model);
	}

	@SuppressWarnings("unchecked")
	public List<AddressModel> getModels() 
	{
		return getSession().getCurrentSession().createQuery("From AddressModel").list();
	}

}
