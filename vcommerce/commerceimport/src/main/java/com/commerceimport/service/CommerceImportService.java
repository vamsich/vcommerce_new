package com.commerceimport.service;

import java.io.IOException;

import org.codehaus.jettison.json.JSONException;

public interface CommerceImportService 
{
	void importData(String fileName) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, JSONException;
}
