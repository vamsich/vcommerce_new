package com.commercecontent.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.commercecontent.dao.ContentSlotDao;
import com.commercecontent.model.ContentSlotModel;
import com.commercecontent.model.SlotModel;

public class DefaultContentSlotDao implements ContentSlotDao
{
	private SessionFactory session;
	
	
	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) 
	{
		this.session = session;
	}

	public void saveModel(SlotModel model) 
	{
		getSession().getCurrentSession().save(model);
	}

	public SlotModel getModel(int id) 
	{
		return (SlotModel) getSession().getCurrentSession().get(SlotModel.class, id);
	}

	public void deleteModel(SlotModel model) 
	{
		getSession().getCurrentSession().delete(model);
	}

	public void updateModel(SlotModel model) 
	{
		getSession().getCurrentSession().update(model);
	}

	@SuppressWarnings("unchecked")
	public List<SlotModel> getModels() 
	{
		return getSession().getCurrentSession().createQuery("From ContentSlotModel").list();
	}

}
