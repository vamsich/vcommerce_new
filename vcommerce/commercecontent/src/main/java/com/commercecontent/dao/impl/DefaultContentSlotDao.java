package com.commercecontent.dao.impl;

import java.util.Collections;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.util.CollectionUtils;

import com.commercecontent.dao.ContentSlotDao;
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

	@SuppressWarnings("unchecked")
	public SlotModel getSlotForCode(String code) 
	{
		List<SlotModel> slots=getSession().getCurrentSession().createQuery("From ContentSlotModel where code:code").setParameter("code", code).list();
		if(CollectionUtils.isEmpty(slots))
		{
			return null;
		}
		return slots.get(0);
	}

	public List<SlotModel> getSlotsForTemplate(int id) 
	{
		@SuppressWarnings("unchecked")
		List<SlotModel> slots=getSession().getCurrentSession().createSQLQuery("select * from slot where slotid in (select slotid from template_slots where template_id="+id+")").list();
		if(CollectionUtils.isEmpty(slots))
		{
			return Collections.emptyList();
		}
		return slots;
	}

}
