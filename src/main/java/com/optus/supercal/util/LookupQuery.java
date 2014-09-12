package com.optus.supercal.util;

public class LookupQuery {

	public static final String OPOM_DATE_EJBQL 
		= "select opomData from OpomData opomData";
	
	public static final String PRODUCT_EJBQL 
		= "select product from Product product";

	public static final String BOLT_ON_FIELD_EJBQL 
		= "select boltOnField from BoltOnField boltOnField";
	
	public static final String BOLT_ON_FAMILY_EJBQL 
		= "select boltOnFamily from BoltOnFamily boltOnFamily";
	
	public static final String RATE_PLAN_FIELD_EJBQL 
		= "select ratePlanField from RatePlanField ratePlanField";
	
	public static final String RATE_PLAN_FAMILY_EJBQL 
		= "select ratePlanFamily from RatePlanFamily ratePlanFamily";
	
	public static final String RATE_PLAN_FAMILY_FIELDS_CONFIG_EJBQL 
		= "select ratePlanFamilyFieldConfig from RatePlanFamilyFieldConfig " +
				"ratePlanFamilyFieldConfig";
	
	public static final String BOLT_ON_FAMILY_FIELDS_CONFIG_EJBQL 
		= "select boltOnFamilyFieldConfig from BoltOnFamilyFieldConfig " +
				"boltOnFamilyFieldConfig";
	
	public static final String EJBQL 
		= "select ratePlanFamilyBoltOnFamilyConfig.boltOnFamily from " +
				"RatePlanFamilyBoltOnFamilyConfig ratePlanFamilyBoltOnFamilyConfig";
	
	public static final String EMAIL_TEMPLATE_OPOM_FIELD_EJBQL 
		= "select opomEmailField from OpomEmailField opomEmailField ";
	
	public static final String EMAIL_TEMPLATE_RATE_PLAN_FIELD_EJBQL 
		= "select ratePlanField from RatePlanField ratePlanField where " +
				"ratePlanField.showInEmail = 'Y'";

	public static final String EMAIL_TEMPLATE_BOLT_ON_FIELD_EJBQL 
		= "select boltOnField from BoltOnField boltOnField where " +
				"boltOnField.showInEmail = 'Y'";
	
	public static final String PRODUCT_RATE_PLAN_EJBQL 
		= "select productRatePlanFamily.ratePlanFamily from " +
				"ProductRatePlanFamily productRatePlanFamily";
	
	public static final String RATE_PLAN_FIELD_VALUE_EJBQL 
		= "select distinct ratePlanFieldValue.ratePlan from RatePlanFieldValue " +
				"ratePlanFieldValue";
	
	public static final String COMPARE_RATE_PLAN_FIELD_EJBQL 
		= "select distinct ratePlanFieldValue.ratePlanFamilyFieldConfig" +
				".ratePlanField from RatePlanFieldValue ratePlanFieldValue";
	
	public static final String EMAIL_FIELD_GROUP_EJBQL 
		= "select emailFieldGroup from EmailFieldGroup emailFieldGroup";

	public static final String BOLT_ON_EJBQL
		= "select boltOn from BoltOn boltOn";
	
	public static final String RATE_PLAN_EJBQL
		= "select ratePlan from RatePlan ratePlan";
	
	public static final String CHANNEL_EJBQL
		= "select channel from Channel channel";
	
	public static final String EMAIL_TEMPLATE_EJBQL 
		= "select emailTemplate from EmailTemplate emailTemplate";
	
	public static final String EMAIL_TEMPLATE_TYPE_EJBQL 
		= "select emailTemplateType from EmailTemplateType emailTemplateType";
	
	public static final String SCREEN_EJBQL = "select screen from Screen screen";
	
	public static final String RETAIL_STORE_EJBQL 
		= "select retailStore from RetailStore retailStore";
	
}
