package com.commercecore.dao;

import java.util.List;

import com.commercecore.model.OrderModel;


public interface OrderDao
{
	Object getModel(int id);
	void saveModel(OrderModel model);
	void updateModel(OrderModel model);
	void deleteModel(OrderModel model);
	List<OrderModel> getModels();
}
