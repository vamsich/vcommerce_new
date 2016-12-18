package com.commercefacades.converters.impl;

import com.commercecontent.model.SlotModel;
import com.commercefacades.converters.Populator;
import com.commercefacades.data.ContentSlotData;

public class ContentSlotPopulator implements Populator<SlotModel, ContentSlotData>
{

	public ContentSlotData populate(SlotModel source, ContentSlotData target) 
	{
		target.setPosition(source.getPosition());
		target.setName(source.getName());
		return target;
	}

}
