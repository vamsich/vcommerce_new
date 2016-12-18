package com.commercefacades.facades.impl;

import com.commercecore.model.ProductModel;
import com.commercecore.service.ProductService;
import com.commercefacades.data.ProductData;
import com.commercefacades.facades.ProductFacade;

public class DefaultProductFacade implements ProductFacade
{
	/*private Converters<ProductModel, ProductData> productConverter;*/
	private ProductService productService;
	
/*	public Converters<ProductModel, ProductData> getProductConverter() {
		return productConverter;
	}


	public void setProductConverter(Converters<ProductModel, ProductData> productConverter) {
		this.productConverter = productConverter;
	}*/

	/*public ProductData getProduct(int id) 
	{
		ProductModel product=(ProductModel) productService.getModel(id);
		ProductData productData=productConverter.convert(product);
		return productData;
	}*/


	public void saveProduct(ProductData productData) 
	{
		ProductModel product= new ProductModel();
		product.setCode(productData.getCode());
		product.setName(productData.getName());
		product.setDescription(productData.getDescription());
		productService.saveModel(product);
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public ProductData getProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
