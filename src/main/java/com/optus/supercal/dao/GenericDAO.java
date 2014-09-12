package com.optus.supercal.dao;

public interface GenericDAO {

	public boolean persistObject (Object object);
	public Object getObject(Class entityClass, Object id);
}
