package com.commercefacades.facades.impl;

import java.util.List;

import com.commercecore.model.BaseSiteModel;
import com.commercecore.service.BaseSiteService;
import com.commercefacades.data.BaseSiteData;
import com.commercefacades.facades.BaseSiteFacade;

public class DefaultBaseSiteFacade implements BaseSiteFacade
{
	private BaseSiteService baseSiteService;
	
	public BaseSiteService getBaseSiteService() {
		return baseSiteService;
	}

	public void setBaseSiteService(BaseSiteService baseSiteService) {
		this.baseSiteService = baseSiteService;
	}

	public BaseSiteData getSite(int id) 
	{
		baseSiteService.getModel(id);
		return null;
	}

	public void saveSite(BaseSiteData baseSite) 
	{
		BaseSiteModel baseSiteModel= new BaseSiteModel();
		baseSiteModel.setSiteId(baseSite.getSiteId());
		baseSiteModel.setName(baseSite.getName());
		baseSiteModel.setVersion(baseSite.getVersion());
		baseSiteService.saveModel(baseSiteModel);
	}

	public List<BaseSiteData> getSites() 
	{
		baseSiteService.getModels();
		return null;
	}

	public void updateSite(BaseSiteData baseSite) 
	{
		BaseSiteModel baseSiteModel= new BaseSiteModel();
		baseSiteModel.setSiteId(baseSite.getSiteId());
		baseSiteModel.setName(baseSite.getName());
		baseSiteModel.setVersion(baseSite.getVersion());
		baseSiteService.updateModel(baseSiteModel);
	}

}
