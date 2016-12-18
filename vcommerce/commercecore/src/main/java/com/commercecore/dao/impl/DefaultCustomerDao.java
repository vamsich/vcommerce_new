package com.commercecore.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.commercecore.dao.CustomerDao;
import com.commercecore.model.CustomerModel;


public class DefaultCustomerDao implements CustomerDao
{
	private SessionFactory session;
	
	
	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}

	public CustomerModel getModel(int id) 
	{
		return (CustomerModel) session.getCurrentSession().get(CustomerModel.class, id);
	}

	public void saveModel(CustomerModel model) 
	{
		session.getCurrentSession().save(model);
	}

	public void updateModel(CustomerModel model) 
	{
		session.getCurrentSession().update(model);
	}

	public void deleteModel(CustomerModel model) 
	{
		session.getCurrentSession().delete(model);
	}

	@SuppressWarnings("unchecked")
	public List<CustomerModel> getModels() 
	{
		return session.getCurrentSession().createQuery("From CustomerModel").list();
	}

	public CustomerModel getCustomer(String email) 
	{
		return (CustomerModel) session.getCurrentSession().createQuery("From CustomerModel where username:email").setParameter("email", email).list().get(0);
	}

}
