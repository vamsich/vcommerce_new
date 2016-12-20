package com.commercebase.services.impl;


import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.commercebase.services.ModelService;

@Transactional
public class ModelServiceImpl implements ModelService
{
	private SessionFactory session;
	
	public void saveModel(Object model) 
	{
		session.getCurrentSession().saveOrUpdate(model);
	}
}
