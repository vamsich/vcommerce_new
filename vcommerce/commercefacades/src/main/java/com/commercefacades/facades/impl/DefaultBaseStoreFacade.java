package com.commercefacades.facades.impl;


import java.util.ArrayList;
import java.util.List;

import com.commercecore.model.BaseStoreModel;
import com.commercecore.service.BaseStoreService;
import com.commercefacades.converters.Converters;
import com.commercefacades.data.BaseStoreData;
import com.commercefacades.facades.BaseStoreFacade;

public class DefaultBaseStoreFacade implements BaseStoreFacade
{
	private BaseStoreService baseStoreService;
	
	private Converters<BaseStoreModel, BaseStoreData> baseStoreConverter;
	
	
	public Converters<BaseStoreModel, BaseStoreData> getBaseStoreConverter() {
		return baseStoreConverter;
	}


	public void setBaseStoreConverter(Converters<BaseStoreModel, BaseStoreData> baseStoreConverter) {
		this.baseStoreConverter = baseStoreConverter;
	}


	public BaseStoreService getBaseStoreService() {
		return baseStoreService;
	}


	public void setBaseStoreService(BaseStoreService baseStoreService) {
		this.baseStoreService = baseStoreService;
	}


	public void saveBaseStore(BaseStoreData baseStoreData) 
	{
		BaseStoreModel baseStoreModel= new BaseStoreModel();
		baseStoreModel.setStoreId(baseStoreData.getStoreId());
		baseStoreModel.setName(baseStoreData.getName());
		baseStoreService.saveModel(baseStoreModel);
	}


	public List<BaseStoreData> getBaseStores() 
	{
		List<BaseStoreModel> baseStores= baseStoreService.getModels();
		List<BaseStoreData> stores= new ArrayList<BaseStoreData>();
		for(BaseStoreModel baseStoreModel: baseStores)
		{
			BaseStoreData baseStore= new BaseStoreData();
			baseStore=baseStoreConverter.convert(baseStoreModel);
			stores.add(baseStore);
		}
		return stores;
	}
}
