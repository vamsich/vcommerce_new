package com.commercecore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.commercecore.dao.CustomerDao;
import com.commercecore.model.CartModel;
import com.commercecore.model.CustomerModel;
import com.commercecore.service.CustomerService;

@Transactional
public class DefaultCustomerService implements CustomerService
{

	private CustomerDao customerDao;
	
	
	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void saveModel(CustomerModel model) 
	{
		getCustomerDao().saveModel(model);
	}

	public CartModel getModel(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteMOdel(CustomerModel model) {
		// TODO Auto-generated method stub
		
	}

	public void updateModel(CustomerModel model) {
		// TODO Auto-generated method stub
		
	}

	public List<CustomerModel> getModels() 
	{
		return customerDao.getModels();
	}
	
}
