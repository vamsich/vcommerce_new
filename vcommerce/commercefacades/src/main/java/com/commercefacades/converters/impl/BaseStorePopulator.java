package com.commercefacades.converters.impl;

import com.commercecore.model.BaseStoreModel;
import com.commercefacades.converters.Populator;
import com.commercefacades.data.BaseStoreData;

public class BaseStorePopulator implements Populator<BaseStoreModel, BaseStoreData> 
{
	public BaseStoreData populate(BaseStoreModel source, BaseStoreData target) 
	{
		target.setName(source.getName());
		target.setStoreId(source.getStoreId());
		return target;
	}
}
