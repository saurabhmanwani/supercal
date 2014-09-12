package com.optus.supercal.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.optus.supercal.dao.GenericDAO;
import com.optus.supercal.entity.AuditRecord;
import com.optus.supercal.entity.EmailBoltOnAddition;
import com.optus.supercal.util.email.BoltOnAdditionEmailBuilder;

public class BoltOnAdditionServiceImpl implements BoltOnAdditionService {

	@Autowired
	private BoltOnAdditionEmailBuilder boltOnAdditionEmailBuilder;

	@Autowired
	private GenericDAO genericDAO;

	public String persist(EmailBoltOnAddition emailBoltOnAddition) {
		// getInstance().setBoltOnAdditions(boltOnAdditions);
		if (boltOnAdditionEmailBuilder.sendEmail(emailBoltOnAddition)) {
			if (genericDAO.persistObject(emailBoltOnAddition)) {
				AuditRecord auditRecord = new AuditRecord();
				auditRecord.setUserName("set user name from spring security configuration");
				auditRecord.setAuditDate(new Date(System.currentTimeMillis()));
				auditRecord.setAuditMessage("Bolt On Addtion Email sent to getInstance().getEmailAddress()");
				genericDAO.persistObject(auditRecord);
				return "Your BoltOn Additions email has been sent";
			}
		} else {
			return "Your BoltOn Additions email send Failed";
		}
		return "Your BoltOn Additions email send Failed";
	}
}
