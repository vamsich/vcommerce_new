package com.commercefacades.data;

public class ContentPageData 
{
	private String name;
	private String code;
	private String pageName;
	private String label;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	
	public void setLabel(String label)
	{
		this.label= label;
	}
	
	public String getLabel()
	{
		return this.label;
	}
}

