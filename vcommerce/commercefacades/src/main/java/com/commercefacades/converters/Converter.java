package com.commercefacades.converters;

public abstract class Converter<T ,V> {
	T object1;
	V object2;
	public abstract V convert(T source, V target);
}
