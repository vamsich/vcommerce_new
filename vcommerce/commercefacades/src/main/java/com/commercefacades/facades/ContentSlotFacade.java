package com.commercefacades.facades;

import com.commercefacades.data.ContentSlotData;

public interface ContentSlotFacade 
{
	ContentSlotData getSlot(int id);
	void save(ContentSlotData contentSlot);
}
