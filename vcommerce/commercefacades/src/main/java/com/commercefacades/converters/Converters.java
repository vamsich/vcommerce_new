package com.commercefacades.converters;

import java.util.List;

public class Converters<T,V> {
	
	private List<Populator<T, V>> populators;
	
	private Class<V> target;
	
	
	public Class<V> getTarget() {
		return target;
	}


	public void setTarget(Class<V> target) {
		this.target = target;
	}



	public List<Populator<T, V>> getPopulators() {
		return populators;
	}



	public void setPopulators(List<Populator<T, V>> populators) {
		this.populators = populators;
	}



	public V convert(T source)
	{
		V target=createTargetObject();
		for(Populator<T,V> populator: getPopulators())
		{
			populator.populate(source, target);
		}
		return target;
	}
	
	private V createTargetObject()
	{
		try
		{
			return (V) target.newInstance();
		}
		catch(Exception e)
		{
			//
		}
		return null;
	}
}
  