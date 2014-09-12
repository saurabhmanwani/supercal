package com.optus.supercal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.optus.supercal.entity.Product;
import com.optus.supercal.entity.RatePlan;
import com.optus.supercal.entity.RatePlanFamily;
import com.optus.supercal.entity.RatePlanField;
import com.optus.supercal.entity.RatePlanFieldValue;
import com.optus.supercal.util.LookupQuery;

@Repository
public class ViewRatePlanDAOImpl implements ViewRatePlanDAO{

	@PersistenceContext(unitName = "entityManager")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Product> getProducts() {
		
		return this.entityManager.createQuery(LookupQuery.PRODUCT_EJBQL).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RatePlanFamily> getRatePlanFamilies(Integer productId) {

		return this.entityManager.createQuery(LookupQuery.PRODUCT_RATE_PLAN_EJBQL +
				" where productRatePlanFamily.product.id = :productId ") 
				.setParameter("productId", productId).getResultList();

	}
	
	@SuppressWarnings("unchecked")
	public List<RatePlan> getRatePlans(Integer ratePlanFamilyId) {
		
		return entityManager.createQuery(LookupQuery.RATE_PLAN_FIELD_VALUE_EJBQL +
				" where ratePlanFieldValue.ratePlanFamilyFieldConfig" +
				".ratePlanFamily.id = :ratePlanFamilyId order by ratePlanFieldValue.ratePlan.id")
				.setParameter("ratePlanFamilyId", ratePlanFamilyId).getResultList();

	}
	
	@SuppressWarnings("unchecked")
	public List<RatePlanField> getRatePlanFieldNames(Integer ratePlanFamilyId) {
		
		return entityManager.createQuery(LookupQuery.COMPARE_RATE_PLAN_FIELD_EJBQL +
				" where ratePlanFieldValue.ratePlanFamilyFieldConfig" +
				".ratePlanFamily.id = :ratePlanFamilyId order by " +
				"ratePlanFieldValue.ratePlanFamilyFieldConfig.sequenceNo")
				.setParameter("ratePlanFamilyId", ratePlanFamilyId)
				.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<RatePlanFieldValue> getRatePlanValues(Integer ratePlanId) {
		
		return entityManager.createQuery("select ratePlanFieldValue from RatePlanFieldValue ratePlanFieldValue " +
				" where ratePlanFieldValue.ratePlan.id = :ratePlanId order by ratePlanFieldValue.ratePlanFamilyFieldConfig.sequenceNo") 
				.setParameter("ratePlanId", ratePlanId).getResultList();

	}
}