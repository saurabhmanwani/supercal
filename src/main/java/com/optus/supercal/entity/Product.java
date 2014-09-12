package com.optus.supercal.entity;

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


@Entity
@Table(name = "PRODUCT", catalog = "supercal")
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 1866726975474485978L;
	private Integer id;
	private String productName;
	private Set<EmailTemplate> emailTemplates = new HashSet<EmailTemplate>(0);
	private Set<ProductRatePlanFamily> productRatePlanFamilies 
		= new HashSet<ProductRatePlanFamily>(0);

	public Product() {
	}

	public Product(String productName) {
		this.productName = productName;
	}
	public Product(String productName, Set<EmailTemplate> emailTemplates,
			Set<ProductRatePlanFamily> productRatePlanFamilies) {
		this.productName = productName;
		this.emailTemplates = emailTemplates;
		this.productRatePlanFamilies = productRatePlanFamilies;
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

	@Column(name = "PRODUCT_NAME", nullable = false, length = 150)
	@NotNull
	@Length(max = 150)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
	public Set<EmailTemplate> getEmailTemplates() {
		return this.emailTemplates;
	}

	public void setEmailTemplates(Set<EmailTemplate> emailTemplates) {
		this.emailTemplates = emailTemplates;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
	public Set<ProductRatePlanFamily> getProductRatePlanFamilies() {
		return this.productRatePlanFamilies;
	}

	public void setProductRatePlanFamilies(
			Set<ProductRatePlanFamily> productRatePlanFamilies) {
		this.productRatePlanFamilies = productRatePlanFamilies;
	}

}
