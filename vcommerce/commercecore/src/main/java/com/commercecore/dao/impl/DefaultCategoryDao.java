package com.commercecore.dao.impl;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.commercecore.dao.CategoryDao;
import com.commercebase.core.models.CategoryModel;


public class DefaultCategoryDao implements  CategoryDao 
{
	private SessionFactory session;
	
	
	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}

	@Transactional
	public CategoryModel getModel(int id) 
	{
		return (CategoryModel)session.getCurrentSession().get(CategoryModel.class,id);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<CategoryModel> getModels() {
		return session.getCurrentSession().createQuery("From CategoryModel").list();
	}

	public void saveModel(CategoryModel model) 
	{
		session.getCurrentSession().save(model);
	}

	public void updateModel(CategoryModel model) 
	{
		session.getCurrentSession().update(model);
	}

	public void deleteModel(CategoryModel model) 
	{
		session.getCurrentSession().delete(model);
	}

}
