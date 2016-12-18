package com.commercefacades.facades.impl;

import java.util.ArrayList;
import java.util.List;

import com.commercecore.model.CustomerModel;
import com.commercecore.service.CustomerService;
import com.commercefacades.converters.Converters;
import com.commercefacades.data.CustomerData;
import com.commercefacades.facades.CustomerFacade;

public class DefaultCustomerFacade implements CustomerFacade 
{
	private CustomerService customerService;
	
	private Converters<CustomerModel, CustomerData> customerConverter;
	

	public Converters<CustomerModel, CustomerData> getConverter() {
		return customerConverter;
	}


	public void setConverter(Converters<CustomerModel, CustomerData> customerConverter) {
		this.customerConverter = customerConverter;
	}


	public CustomerService getCustomerService() {
		return customerService;
	}


	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	public void saveCustomer(CustomerData customerData) 
	{
		CustomerModel customerModel= new CustomerModel();
		customerModel.setFirstName(customerData.getFirstName());
		customerModel.setLastName(customerData.getLastName());
		customerService.saveModel(customerModel);
	}


	public List<CustomerData> getCustomers() 
	{
		List<CustomerModel> customers=customerService.getModels();
		List<CustomerData> customerDataList= new ArrayList<CustomerData>();
		
		for(CustomerModel customer:customers)
		{
			CustomerData customerData= new CustomerData();
			customerData=customerConverter.convert(customer);
			customerDataList.add(customerData);
		}
		return customerDataList;
	}

}
