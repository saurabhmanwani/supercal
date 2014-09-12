package com.optus.supercal.dao;

import com.optus.supercal.entity.EmailTemplate;

public interface EmailDAO {
	
	public EmailTemplate findEmailTemplate(String templateType);

}
