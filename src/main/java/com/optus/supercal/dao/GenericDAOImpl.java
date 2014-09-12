package com.optus.supercal.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDAOImpl implements GenericDAO {

	@PersistenceContext(unitName = "entityManager")
	private EntityManager entityManager;

	public boolean persistObject(Object object) {

		try {
			entityManager.getTransaction();
			entityManager.persist(object);
			entityManager.getTransaction();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Object getObject(Class entityClass, Object id) {

		return entityManager.find(entityClass, id);
	}
}
