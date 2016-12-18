package com.commercecore.dao.impl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.commercecore.dao.ProductDao;
import com.commercecore.model.ProductModel;

public class DefaultProductDao implements  ProductDao
{	
	private SessionFactory session;

	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}

	@Transactional
	public ProductModel getModel(int id) 
	{
		return (ProductModel)session.getCurrentSession().get(ProductModel.class,id);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<ProductModel> getModels() 
	{
		return session.getCurrentSession().createQuery("From ProductModel").list();
	}

	public void saveProduct(ProductModel product) 
	{
		try
		{
			session.getCurrentSession().save(product);
		}
		catch(Exception e)
		{
			//
		}
	}

	public void saveModel(ProductModel model) 
	{
		session.getCurrentSession().save(model);
	}

	public void updateModel(ProductModel model) 
	{
		session.getCurrentSession().update(model);
	}

	public void deleteModel(ProductModel model) 
	{
		session.getCurrentSession().delete(model);
	}
}
