package com.cg.mobinv.mobileinventory.common.api.to;

import org.apache.olingo.odata2.api.annotation.edm.*;

@EdmEntityType(name = "Material")
@EdmEntitySet(name = "MaterialSet")
public class MaterialTo {

	@EdmKey
	@EdmProperty
	private Long id;

	@EdmProperty
	private String materialDescription;

	@EdmProperty
	private Integer number;

	@EdmProperty
	private Integer expirationDays;
	
	@EdmProperty
	private String expirationType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaterialDesc() {
		return materialDescription;
	}

	public void setMaterialDesc(String materialDescription) {
		this.materialDescription = materialDescription;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getExpirationDays() {
		return expirationDays;
	}

	public void setExpirationDays(Integer expirationDays) {
		this.expirationDays = expirationDays;
	}

	public String getExpirationType() {
		return expirationType;
	}

	public void setExpirationType(String expirationType) {
		this.expirationType = expirationType;
	}

	
}
