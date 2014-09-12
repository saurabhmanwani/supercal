package com.optus.supercal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.optus.supercal.entity.RatePlan;
import com.optus.supercal.entity.RatePlanField;
import com.optus.supercal.entity.RatePlanFieldValue;
import com.optus.supercal.util.LookupQuery;

@Repository
public class CompareRatePlansDAOImpl implements CompareRatePlansDAO {

	@Autowired
	ViewRatePlanDAO viewRatePlanDAO;
	
	@PersistenceContext(unitName = "entityManager")
	private EntityManager entityManager;
	
	public List<RatePlan>getRatePlans(Integer ratePlanFamilyId) {
		
		return viewRatePlanDAO.getRatePlans(ratePlanFamilyId);
	}
	
	@SuppressWarnings("unchecked")
	public List<RatePlanField> getRatePlanFieldNames(Integer ratePlan1Id, Integer ratePlan2Id, Integer ratePlan3Id) {
		
		return entityManager.createQuery(LookupQuery.COMPARE_RATE_PLAN_FIELD_EJBQL +
				" where ratePlanFieldValue.ratePlan.id in (:ratePlanId1, " +
				":ratePlanId2, :ratePlanId3) order by " +
				"ratePlanFieldValue.ratePlanFamilyFieldConfig.sequenceNo")
				.setParameter("ratePlanId1", ratePlan1Id)
				.setParameter("ratePlanId2", ratePlan2Id)
				.setParameter("ratePlanId3", ratePlan3Id).getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<RatePlanFieldValue> getRatePlanValues(Integer ratePlanId) {
		
		return entityManager.createQuery("select ratePlanFieldValue from RatePlanFieldValue ratePlanFieldValue " +
				" where ratePlanFieldValue.ratePlan.id = :ratePlanId order by ratePlanFieldValue.ratePlanFamilyFieldConfig.sequenceNo") 
				.setParameter("ratePlanId", ratePlanId).getResultList();

	}
}
