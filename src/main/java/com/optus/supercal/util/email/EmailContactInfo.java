package com.optus.supercal.util.email;

public class EmailContactInfo {
	
	private String name;
	private String emailId;
	
	public EmailContactInfo()
	{
		super();
	}
	public EmailContactInfo(String name, String emailId) {
		super();
		this.name = name;
		this.emailId = emailId;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailId() {
		return emailId;
	}
	
	@Override
	public String toString() {
		return "EmailContactInfo [emailId=" + emailId + ", name=" + name + "]";
	}

}
