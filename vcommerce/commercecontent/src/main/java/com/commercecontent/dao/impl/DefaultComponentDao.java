package com.commercecontent.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.commercecontent.dao.ComponentDao;
import com.commercecontent.model.ComponentModel;

public class DefaultComponentDao implements ComponentDao
{
	private SessionFactory session;
	
	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}

	public ComponentModel getModel(int id) 
	{
		return (ComponentModel) getSession().getCurrentSession().get(ComponentModel.class, id);
	}

	public void saveModel(ComponentModel model) 
	{
		
	}

	public void updateModel(ComponentModel model) 
	{
		
	}

	public void deleteModel(ComponentModel model) 
	{
		
	}

	public List<ComponentModel> getModels() 
	{
		return null;
	}

}
