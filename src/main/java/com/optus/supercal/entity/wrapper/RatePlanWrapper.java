package com.optus.supercal.entity.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.optus.supercal.entity.RatePlan;

public class RatePlanWrapper {

	private List<RatePlan> ratePlans = new ArrayList<RatePlan>();
	
    public List<RatePlan> getRatePlans() {
        return ratePlans;
    }

    public void setRatePlans(List<RatePlan> ratePlans) {
        this.ratePlans = ratePlans;
    }
}
