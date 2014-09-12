package com.optus.supercal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.optus.supercal.entity.Product;
import com.optus.supercal.entity.RatePlanFamily;
import com.optus.supercal.service.ViewRatePlanService;
import com.optus.supercal.util.RestURIConstants;

@RestController
public class ViewRatePlanController {

	@Autowired
	ViewRatePlanService viewRatePlanService;
	
	@RequestMapping(value = RestURIConstants.GET_PRODUCTS, method = RequestMethod.GET)
	public List<Product> getProducts() {
        		
		return viewRatePlanService.getProducts();	
    }
	
	@RequestMapping(value = RestURIConstants.LOAD_RATE_PLAN_FAMILIES, method = RequestMethod.GET)
	public List<RatePlanFamily> loadRatePlanFamilies(@RequestParam(value="productId", required=true) Integer productId) {

		return viewRatePlanService.getRatePlanFamilies(productId);
	}
	
	@RequestMapping(value = RestURIConstants.VIEW_RATE_PLANS, method = RequestMethod.GET)
	public List<ArrayList<String>> viewRatePlans(@RequestParam(value="ratePlanFamilyId", required=true) Integer ratePlanFamilyId) {
		
		return viewRatePlanService.viewRatePlans(ratePlanFamilyId);
	}
	
}
