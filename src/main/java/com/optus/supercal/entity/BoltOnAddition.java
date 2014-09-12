package com.optus.supercal.entity;
// Generated 16/08/2011 11:37:55 AM by Hibernate Tools 3.2.4.GA

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * BoltOnAddition generated by hbm2java
 */
@Entity
@Table(name = "BOLT_ON_ADDITION", catalog = "supercal")
public class BoltOnAddition implements java.io.Serializable {

	private static final long serialVersionUID = -3880083721334752990L;
	private Integer id;
	private Integer boltOnId;
	private EmailBoltOnAddition emailBoltOnAddition;

	public BoltOnAddition() {
	}

	public BoltOnAddition(EmailBoltOnAddition emailBoltOnAddition,
			BoltOn boltOn) {
		this.emailBoltOnAddition = emailBoltOnAddition;
		this.boltOnId = boltOn.getId();
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "BOLT_ON_ID", nullable = false)
	public Integer getBoltOnId() {
		return this.boltOnId;
	}

	public void setBoltOnId(int boltOnId) {
		this.boltOnId = boltOnId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMAIL_BOLT_ON_ADDITION_ID", nullable = false)
	@NotNull
	public EmailBoltOnAddition getEmailBoltOnAddition() {
		return this.emailBoltOnAddition;
	}

	public void setEmailBoltOnAddition(EmailBoltOnAddition emailBoltOnAddition) {
		this.emailBoltOnAddition = emailBoltOnAddition;
	}

}