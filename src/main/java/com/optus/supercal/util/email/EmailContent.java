package com.optus.supercal.util.email;

import java.util.List;

import com.optus.supercal.entity.OpomData;

public	class EmailContent {
	
	public List<OpomData> opomDataList;
	public OpomData firstOpomData;
	public String emailAddress;
	public String customerName;
	
	public EmailContent(List<OpomData> opomDataList) {
		this.opomDataList = opomDataList;
		firstOpomData = opomDataList.get(0);
	}
	public List<OpomData> getOpomDataList() {
		return opomDataList;
	}
	public void setOpomDataList(List<OpomData> opomDataList) {
		this.opomDataList = opomDataList;
	}
	public OpomData getFirstOpomData() {
		return firstOpomData;
	}
	public void setFirstOpomData(OpomData firstOpomData) {
		this.firstOpomData = firstOpomData;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}