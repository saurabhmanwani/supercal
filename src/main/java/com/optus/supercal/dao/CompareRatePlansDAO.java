package com.optus.supercal.dao;

import java.util.List;

import com.optus.supercal.entity.RatePlan;
import com.optus.supercal.entity.RatePlanField;
import com.optus.supercal.entity.RatePlanFieldValue;

public interface CompareRatePlansDAO {

	List<RatePlan>getRatePlans(Integer ratePlanFamilyId);
	List<RatePlanField> getRatePlanFieldNames(Integer ratePlan1Id, Integer ratePlan2Id, Integer ratePlan3Id);
	List<RatePlanFieldValue> getRatePlanValues(Integer ratePlanId);
}
