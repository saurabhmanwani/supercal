package com.optus.supercal.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.optus.supercal.entity.EmailTemplate;
import com.optus.supercal.util.LookupQuery;

public class EmailDAOImpl implements EmailDAO{

	@PersistenceContext(unitName = "entityManager")
	private EntityManager entityManager;
	
	public EmailTemplate findEmailTemplate(String templateType) {

		return (EmailTemplate) entityManager.createQuery(LookupQuery.EMAIL_TEMPLATE_EJBQL +
				" where lower(emailTemplate.templateType) = lower(:templateType)");
	}
}
