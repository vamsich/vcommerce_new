package com.commercefacades.converters.impl;

import com.commercecore.model.ProductModel;
import com.commercefacades.converters.Populator;
import com.commercefacades.data.ProductData;

public class ProductPopulator implements Populator<ProductModel, ProductData>
{

	public ProductData populate(ProductModel source, ProductData target) 
	{
		target.setId(source.getId());
		target.setName(source.getName());
		target.setCode(source.getCode());
		target.setDescription(source.getDescription());
		target.setBrand(source.getBrand());
		return target;
	}
		
}
