package com.commercecore.service;

import java.util.List;

import com.commercecore.model.CartModel;
import com.commercecore.model.CustomerModel;

public interface CustomerService 
{
	void saveModel(CustomerModel model);
	CartModel getModel(int id);
	void deleteMOdel(CustomerModel model);
	void updateModel(CustomerModel model);
	List<CustomerModel> getModels();
}
