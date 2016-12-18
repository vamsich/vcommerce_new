package com.commercecontent.dao;

import java.util.List;

import com.commercecontent.model.SlotModel;

public interface ContentSlotDao 
{
	void saveModel(SlotModel model);
	SlotModel getModel(int id);
	void deleteModel(SlotModel model);
	void updateModel(SlotModel model);
	List<SlotModel> getModels();
}
