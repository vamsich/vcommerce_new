package com.commercecore.dao;

import java.util.List;

import com.commercecore.model.CustomerModel;


public interface CustomerDao
{
	CustomerModel getModel(int id);
	void saveModel(CustomerModel model);
	void updateModel(CustomerModel model);
	void deleteModel(CustomerModel model);
	List<CustomerModel> getModels();
	CustomerModel getCustomer(String email);
}
