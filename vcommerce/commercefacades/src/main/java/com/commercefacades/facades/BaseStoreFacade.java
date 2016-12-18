package com.commercefacades.facades;

import java.util.List;

import com.commercefacades.data.BaseStoreData;

public interface BaseStoreFacade 
{
	void saveBaseStore(BaseStoreData baseStoreData);
	List<BaseStoreData> getBaseStores();
}
