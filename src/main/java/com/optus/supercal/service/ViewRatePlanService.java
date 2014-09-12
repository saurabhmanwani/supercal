package com.optus.supercal.service;

import java.util.ArrayList;
import java.util.List;

import com.optus.supercal.entity.Product;
import com.optus.supercal.entity.RatePlanFamily;

public interface ViewRatePlanService {
	
	public List<Product> getProducts();
	public List<RatePlanFamily> getRatePlanFamilies(Integer productId);
	public ArrayList<ArrayList<String>> viewRatePlans(Integer ratePlanFamilyId);
}
