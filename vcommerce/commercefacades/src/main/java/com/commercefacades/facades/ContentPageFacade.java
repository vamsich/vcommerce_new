package com.commercefacades.facades;

import com.commercefacades.data.ContentPageData;

public interface ContentPageFacade 
{
	ContentPageData getSite(int id);
	void save(ContentPageData contentPage);
	ContentPageData getContentPage(String code);
}
