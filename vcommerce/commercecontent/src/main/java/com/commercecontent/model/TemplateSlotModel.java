package com.commercecontent.model;

import java.util.Set;

public class TemplateSlotModel extends SlotModel
{
	private ContentPageModel contentPage;

	private Set<ComponentModel> components;
	
	public Set<ComponentModel> getComponents()
	{
		return components;
	}

	public void setComponents(Set<ComponentModel> components)
	{
		this.components = components;
	}

	public ContentPageModel getContentPage()
	{
		return contentPage;
	}

	public void setContentPage(ContentPageModel contentPage)
	{
		this.contentPage = contentPage;
	}
	
}
