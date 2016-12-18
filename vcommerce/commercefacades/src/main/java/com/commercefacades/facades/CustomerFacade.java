package com.commercefacades.facades;

import java.util.List;

import com.commercefacades.data.CustomerData;

public interface CustomerFacade 
{
	void saveCustomer(CustomerData customerData);
	List<CustomerData> getCustomers();
}
