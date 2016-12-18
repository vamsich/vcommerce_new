package com.commercecontent.service;

import java.util.List;

import com.commercecontent.model.SlotModel;


public interface ContentSlotService 
{
	void saveModel(SlotModel model);
	SlotModel getModel(int id);
	void deleteModel(SlotModel model);
	void updateModel(SlotModel model);
	List<SlotModel> getModels();
}
