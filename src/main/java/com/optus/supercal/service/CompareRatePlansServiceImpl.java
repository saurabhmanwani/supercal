package com.optus.supercal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optus.supercal.dao.CompareRatePlansDAO;
import com.optus.supercal.entity.RatePlan;
import com.optus.supercal.entity.RatePlanField;
import com.optus.supercal.entity.RatePlanFieldValue;

@Service
public class CompareRatePlansServiceImpl implements CompareRatePlansService{

	@Autowired
	CompareRatePlansDAO compareRatePlansDAO;
	
	public List<RatePlan>getRatePlans(Integer ratePlanFamilyId) {
		
		return compareRatePlansDAO.getRatePlans(ratePlanFamilyId);
	}
	
	public ArrayList<ArrayList<String>> compareRatePlans(Integer ratePlan1Id, Integer ratePlan2Id, Integer ratePlan3Id) {
		
		// check rate plan id and if null or blank  -- > 0
		
		List<RatePlanField> ratePlanFieldNames = compareRatePlansDAO.getRatePlanFieldNames(
					(ratePlan1Id != null) ? ratePlan1Id : 0, 
					(ratePlan2Id != null) ? ratePlan2Id : 0,
					(ratePlan3Id != null) ? ratePlan3Id : 0);		
		
		List<RatePlanFieldValue> ratePlanValues1 = processRatePlan(ratePlan1Id, ratePlanFieldNames);
		List<RatePlanFieldValue> ratePlanValues2 = processRatePlan(ratePlan2Id, ratePlanFieldNames);
		List<RatePlanFieldValue> ratePlanValues3 = processRatePlan(ratePlan3Id, ratePlanFieldNames);

		ArrayList<ArrayList<String>> ratePlanResults = new ArrayList<ArrayList<String>>(0);
			for (RatePlanField field : ratePlanFieldNames) {
				ArrayList<String> row = new ArrayList<String>(0);
				row.add(field.getFieldName());
				for (RatePlanFieldValue rpfValue : ratePlanValues1) {
					if(rpfValue.getRatePlanFamilyFieldConfig() != null && 
							field.getId().equals(rpfValue.getRatePlanFamilyFieldConfig()
							.getRatePlanField().getId())) {
						if(rpfValue.getRatePlanFieldValue().isEmpty()) {
							row.add("N/A");
						} else {
							if(field.getFieldType().equals("LINK")) {
								row.add("<a href='" + 
										rpfValue.getRatePlanFieldValue() + "' target='_blank'> Click </a>");
							} else {
								row.add(rpfValue.getRatePlanFieldValue());
							}
						}
						break;					
					} 	
				}
				if (row.size() < 2) {
					row.add("N/A");
				}
				for (RatePlanFieldValue rpfValue : ratePlanValues2) {
					if(rpfValue.getRatePlanFamilyFieldConfig() != null && 
							field.getId().equals(rpfValue.getRatePlanFamilyFieldConfig()
							.getRatePlanField().getId())) {
						if(rpfValue.getRatePlanFieldValue().isEmpty()) {
							row.add("N/A");
						} else {
							if(field.getFieldType().equals("LINK")) {
								row.add("<a href='" + 
										rpfValue.getRatePlanFieldValue() + "' target='_blank'> Click </a>");
							} else {
								row.add(rpfValue.getRatePlanFieldValue());
							}
						}
						break;					
					} 	
				}
				if (row.size() < 3) {
					row.add("N/A");
				}
				for (RatePlanFieldValue rpfValue : ratePlanValues3) {
					if(rpfValue.getRatePlanFamilyFieldConfig() != null && 
							field.getId().equals(rpfValue.getRatePlanFamilyFieldConfig()
							.getRatePlanField().getId())) {
						if(rpfValue.getRatePlanFieldValue().isEmpty()) {
							row.add("N/A");
						} else {
							if(field.getFieldType().equals("LINK")) {
								row.add("<a href='" + 
										rpfValue.getRatePlanFieldValue() + "' target='_blank'> Click </a>");
							} else {
								row.add(rpfValue.getRatePlanFieldValue());
							}
						}
						break;					
					} 	
				}
				ratePlanResults.add(row);
			}
			
			return ratePlanResults;
			/*columns = new ArrayList<Column>(0);
			if (ratePlan1 != null) {
				columns.add(new Column(ratePlan1.getRatePlanId()));
			}
			if (ratePlan2 != null) {
				columns.add(new Column(ratePlan2.getRatePlanId()));
			}
			if (ratePlan3 != null) {
				columns.add(new Column(ratePlan3.getRatePlanId()));
			}	*/	
	}
	
	private List<RatePlanFieldValue> processRatePlan(Integer ratePlanId, List<RatePlanField> ratePlanFieldNames) {
		List<RatePlanFieldValue> ratePlanValues = compareRatePlansDAO.getRatePlanValues(
				(ratePlanId != null) ? ratePlanId : 0);
		List<RatePlanFieldValue> rpValues = new ArrayList<RatePlanFieldValue>(0);
		for (RatePlanField field : ratePlanFieldNames) {
			RatePlanFieldValue ratePlanFieldValue = null;
			for (RatePlanFieldValue rpfValue : ratePlanValues) {
				if(field.getId().equals(rpfValue.getRatePlanFamilyFieldConfig()
						.getRatePlanField().getId())) {
					ratePlanFieldValue = rpfValue;
					break;					
				} 
			}
			if (ratePlanFieldValue != null) {
				rpValues.add(ratePlanFieldValue);
			} else {
				rpValues.add(new RatePlanFieldValue());
			}
		}
		if (ratePlanId != null) {
			ratePlanValues.addAll(rpValues);
		}		
		return ratePlanValues;
	}
}
