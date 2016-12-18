package com.commercefacades.facades;

import com.commercefacades.data.ProductData;

public interface ProductFacade 
{
	ProductData getProduct(int id);
	void saveProduct(ProductData productData);
}
