package com.optus.supercal.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * RatePlanFamilyFieldConfig generated by hbm2java
 */
@Entity
@Table(name = "RATE_PLAN_FAMILY_FIELD_CONFIG", catalog = "supercal")
public class RatePlanFamilyFieldConfig implements java.io.Serializable,
	Comparable<RatePlanFamilyFieldConfig> {

	private static final long serialVersionUID = 4584587629289542716L;
	private Integer id;
	private RatePlanFamily ratePlanFamily;
	private RatePlanField ratePlanField;
	private int sequenceNo;
	private Set<RatePlanFieldValue> ratePlanFieldValues 
		= new HashSet<RatePlanFieldValue>(0);

	public RatePlanFamilyFieldConfig() {
	}

	public RatePlanFamilyFieldConfig(RatePlanFamily ratePlanFamily,
			RatePlanField ratePlanField, int sequenceNo) {
		this.ratePlanFamily = ratePlanFamily;
		this.ratePlanField = ratePlanField;
		this.sequenceNo = sequenceNo;
	}
	public RatePlanFamilyFieldConfig(RatePlanFamily ratePlanFamily,
			RatePlanField ratePlanField, int sequenceNo,
			Set<RatePlanFieldValue> ratePlanFieldValues) {
		this.ratePlanFamily = ratePlanFamily;
		this.ratePlanField = ratePlanField;
		this.sequenceNo = sequenceNo;
		this.ratePlanFieldValues = ratePlanFieldValues;
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

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RATE_PLAN_FAMILY_ID", nullable = false)
	@NotNull
	public RatePlanFamily getRatePlanFamily() {
		return this.ratePlanFamily;
	}

	public void setRatePlanFamily(RatePlanFamily ratePlanFamily) {
		this.ratePlanFamily = ratePlanFamily;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RATE_PLAN_FIELD_ID", nullable = false)
	@NotNull
	public RatePlanField getRatePlanField() {
		return this.ratePlanField;
	}

	public void setRatePlanField(RatePlanField ratePlanField) {
		this.ratePlanField = ratePlanField;
	}

	@Column(name = "SEQUENCE_NO", nullable = false)
	public int getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo = sequenceNo;
	} 

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ratePlanFamilyFieldConfig")
	public Set<RatePlanFieldValue> getRatePlanFieldValues() {
		return this.ratePlanFieldValues;
	}

	public void setRatePlanFieldValues(
			Set<RatePlanFieldValue> ratePlanFieldValues) {
		this.ratePlanFieldValues = ratePlanFieldValues;
	}

	@Override
	public int compareTo(RatePlanFamilyFieldConfig o) {
		return getSequenceNo() - o.getSequenceNo();
	}

}
