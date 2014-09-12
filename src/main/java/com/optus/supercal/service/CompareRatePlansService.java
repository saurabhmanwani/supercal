package com.optus.supercal.service;

import java.util.ArrayList;
import java.util.List;

import com.optus.supercal.entity.RatePlan;

public interface CompareRatePlansService {

	List<RatePlan>getRatePlans(Integer ratePlanFamilyId);
	
	ArrayList<ArrayList<String>> compareRatePlans(Integer ratePlan1Id, Integer ratePlan2Id, Integer ratePlan3Id);
}
