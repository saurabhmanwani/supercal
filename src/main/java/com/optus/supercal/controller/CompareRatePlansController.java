package com.optus.supercal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.optus.supercal.entity.RatePlan;
import com.optus.supercal.service.CompareRatePlansService;
import com.optus.supercal.util.RestURIConstants;

@RestController
public class CompareRatePlansController {

	@Autowired
	CompareRatePlansService compareRatePlansService;
	
	@RequestMapping(value = RestURIConstants.GET_RATE_PLANS, method = RequestMethod.GET)
	public List<RatePlan> getRatePlans(@RequestParam(value="ratePlanFamilyId", required=true) Integer ratePlanFamilyId) {
        		
			return compareRatePlansService.getRatePlans(ratePlanFamilyId);
    }
	
	@RequestMapping(value = RestURIConstants.COMPARE_RATE_PLANS, method = RequestMethod.GET)
	public ArrayList<ArrayList<String>> compareRatePlans(@RequestParam(value="ratePlan1Id", required=true) Integer ratePlan1Id,
			@RequestParam(value="ratePlan2Id", required=true) Integer ratePlan2Id,
			@RequestParam(value="ratePlan3Id", required=true) Integer ratePlan3Id) {
        		
			return compareRatePlansService.compareRatePlans(ratePlan1Id, ratePlan2Id, ratePlan3Id);
    }
	
/*	@RequestMapping(value = RestURIConstants.COMPARE_RATE_PLANS, method = RequestMethod.GET, headers="Accept=application/json")
	public void compareRatePlans(@RequestParam(value="ratePlans", required=true) String ratePlans) {
		
		System.out.println(ratePlans);
		ArrayList<Map<String,String>> map = new ArrayList<Map<String,String>>();
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		
		try {
			map = mapper.readValue(ratePlans, new TypeReference<ArrayList<HashMap<String,String>>>(){});
			System.out.println(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
    }
	
	@RequestMapping(value = RestURIConstants.COMPARE_RATE_PLANS_2, method = RequestMethod.POST, headers="Accept=application/json")
	public void compareRatePlans2(@RequestBody RatePlan ratePlan) {
		
		System.out.println(ratePlan);
    }*/
}
