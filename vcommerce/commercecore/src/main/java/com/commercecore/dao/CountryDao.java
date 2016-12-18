package com.commercecore.dao;

import java.util.List;
import com.commercecore.model.CountryModel;

public interface CountryDao extends GenericDao<CountryModel>
{
	Object getModel(int id);
	void saveModel(CountryModel model);
	void updateModel(CountryModel model);
	void deleteModel(CountryModel model);
	List<CountryModel> getModels();
}
