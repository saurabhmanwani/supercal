package com.optus.supercal.entity;
// Generated Jul 15, 2011 10:09:14 PM by Hibernate Tools 3.2.4.GA

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Length;


/**
 * OpomEmailField generated by hbm2java
 */
@Entity
@Table(name = "OPOM_EMAIL_FIELD", catalog = "supercal")
public class OpomEmailField implements java.io.Serializable {

	private static final long serialVersionUID = -3313865012961042729L;
	private Integer id;
	private String fieldName;
	private String fieldLabel;
	private String fieldType;
	private char showInEmail;
	
	private Set<EmailTemplateOpomFieldConfig> emailTemplateOpomFieldConfigs
		= new HashSet<EmailTemplateOpomFieldConfig>(0);

	public OpomEmailField() {
	}

	public OpomEmailField(String fieldName, String fieldLabel, char showInEmail) {
		this.fieldName = fieldName;
		this.fieldLabel = fieldLabel;
		this.showInEmail = showInEmail;
	}
	public OpomEmailField(String fieldName, String fieldLabel,
			char showInEmail,
			Set<EmailTemplateOpomFieldConfig> emailTemplateOpomFieldConfigs) {
		this.fieldName = fieldName;
		this.fieldLabel = fieldLabel;
		this.showInEmail = showInEmail;
		this.emailTemplateOpomFieldConfigs = emailTemplateOpomFieldConfigs;
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

	@Column(name = "FIELD_NAME", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Column(name = "FIELD_LABEL", nullable = false)
	@NotNull
	public String getFieldLabel() {
		return this.fieldLabel;
	}

	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}
	
	@Column(name = "FIELD_TYPE", nullable = false)
	@NotNull
	public String getFieldType() {
		return this.fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	
	@Column(name = "SHOW_IN_EMAIL", nullable = false, length = 1)
	public char getShowInEmail() {
		return this.showInEmail;
	}

	public void setShowInEmail(char showInEmail) {
		this.showInEmail = showInEmail;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "opomEmailField")
	public Set<EmailTemplateOpomFieldConfig> getEmailTemplateOpomFieldConfigs() {
		return this.emailTemplateOpomFieldConfigs;
	}

	public void setemailTemplateOpomFieldConfigs(
			Set<EmailTemplateOpomFieldConfig> emailTemplateOpomFieldConfigs) {
		this.emailTemplateOpomFieldConfigs = emailTemplateOpomFieldConfigs;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id.equals(((OpomEmailField)obj).id);
	}
	
	
}