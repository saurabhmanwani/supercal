package com.optus.supercal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optus.supercal.dao.ViewRatePlanDAO;
import com.optus.supercal.entity.Product;
import com.optus.supercal.entity.RatePlan;
import com.optus.supercal.entity.RatePlanFamily;
import com.optus.supercal.entity.RatePlanField;
import com.optus.supercal.entity.RatePlanFieldValue;
import com.optus.supercal.util.Column;

@Service
public class ViewRatePlanServiceImpl implements ViewRatePlanService{

	@Autowired
	ViewRatePlanDAO viewRatePlanDAO;
	
	public List<Product> getProducts() {		
		return viewRatePlanDAO.getProducts();
	}

	public List<RatePlanFamily> getRatePlanFamilies(Integer productId) {		
		return viewRatePlanDAO.getRatePlanFamilies(productId);
	}
	
	public ArrayList<ArrayList<String>> viewRatePlans(Integer ratePlanFamilyId) {
		
		ArrayList<ArrayList<String>> ratePlanResults = new ArrayList<ArrayList<String>>(0);		
		
		List<RatePlan> ratePlans = viewRatePlanDAO.getRatePlans(ratePlanFamilyId);
		List<RatePlanField> ratePlanFieldNames = viewRatePlanDAO.getRatePlanFieldNames(ratePlanFamilyId);
		
		processRatePlan(ratePlans, ratePlanFieldNames, ratePlanResults);
		
		return ratePlanResults;
	}
	
	private void processRatePlan(List<RatePlan> ratePlans, List<RatePlanField> ratePlanFieldNames, ArrayList<ArrayList<String>> ratePlanResults) {
		
		Map<String, List<RatePlanFieldValue>> ratePlanValues = new HashMap<String, List<RatePlanFieldValue>>(0);
		ArrayList<String> columns = new ArrayList<String>();
		
		
		columns.add("Field Name");
		for (RatePlan ratePlan : ratePlans) {
			
			// adding column headers
			columns.add(ratePlan.getRatePlanId());
			
			List<RatePlanFieldValue> values
				= viewRatePlanDAO.getRatePlanValues(ratePlan.getId());
			List<RatePlanFieldValue> rpValues = new ArrayList<RatePlanFieldValue>(0);
			for (RatePlanField field : ratePlanFieldNames) {
				RatePlanFieldValue ratePlanFieldValue = null;
				for (RatePlanFieldValue rpfValue : values) {
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
			ratePlanValues.put(ratePlan.getRatePlanId(), rpValues);
		}

		// adding column list to result array
		ratePlanResults.add(columns);
		
		for (RatePlanField field : ratePlanFieldNames) {
			ArrayList<String> row = new ArrayList<String>(0);
			row.add(field.getFieldName());
			for (RatePlan ratePlan : ratePlans) {
				String key = ratePlan.getRatePlanId();
				List<RatePlanFieldValue> values = ratePlanValues.get(key);
				for (RatePlanFieldValue rpfValue : values) {
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
			}
			ratePlanResults.add(row);
		}
		
		/*columns.clear();
		for (RatePlan ratePlan : ratePlans) {
			String key = ratePlan.getRatePlanId();
			columns.add(new Column(key));
		}*/
	}
}
