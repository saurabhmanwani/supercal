package com.optus.supercal.dao;

import java.util.List;

import com.optus.supercal.entity.Product;
import com.optus.supercal.entity.RatePlan;
import com.optus.supercal.entity.RatePlanFamily;
import com.optus.supercal.entity.RatePlanField;
import com.optus.supercal.entity.RatePlanFieldValue;

public interface ViewRatePlanDAO {

	List<Product> getProducts();
	List<RatePlanFamily> getRatePlanFamilies(Integer productId);
	List<RatePlan> getRatePlans(Integer ratePlanFamilyId);
	List<RatePlanField> getRatePlanFieldNames(Integer ratePlanFamilyId);
	List<RatePlanFieldValue> getRatePlanValues(Integer ratePlanId);
	
}
