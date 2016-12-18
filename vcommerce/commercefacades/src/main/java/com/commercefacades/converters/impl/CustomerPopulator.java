package com.commercefacades.converters.impl;

import com.commercecore.model.CustomerModel;
import com.commercefacades.converters.Populator;
import com.commercefacades.data.CustomerData;

public class CustomerPopulator implements Populator<CustomerModel, CustomerData>
{
	public CustomerData populate(CustomerModel source, CustomerData target) 
	{
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		return target;
	}
}
