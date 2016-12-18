package com.commercefacades.converters;

public interface Populator <T,V>
{
	V populate(T source, V target);
}
