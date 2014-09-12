package com.optus.supercal.entity;

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

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * ProductRatePlanFamily generated by hbm2java
 */
@Entity
@Table(name = "PRODUCT_RATE_PLAN_FAMILY", catalog = "supercal")
public class ProductRatePlanFamily implements java.io.Serializable {

	private static final long serialVersionUID = 7595397302887916232L;
	private Integer id;
	private RatePlanFamily ratePlanFamily;
	private Product product;

	public ProductRatePlanFamily() {
	}

	public ProductRatePlanFamily(RatePlanFamily ratePlanFamily, Product product) {
		this.ratePlanFamily = ratePlanFamily;
		this.product = product;
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
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	@NotNull
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}