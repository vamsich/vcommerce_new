package com.commercefacades.facades;

import java.util.List;

import com.commercefacades.data.BaseSiteData;

public interface BaseSiteFacade 
{
	BaseSiteData getSite(int id);
	void saveSite(BaseSiteData baseSite);
	List<BaseSiteData> getSites();
	void updateSite(BaseSiteData baseSite);
}
