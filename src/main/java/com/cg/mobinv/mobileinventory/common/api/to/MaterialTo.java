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
	private String expirationDays;
	
	@EdmProperty
	private String expirationType;
	
	@EdmProperty
	private String treshold;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpirationDays() {
		return expirationDays;
	}

	public void setExpirationDays(String expirationDays) {
		this.expirationDays = expirationDays;
	}

	public String getExpirationType() {
		return expirationType;
	}

	public void setExpirationType(String expirationType) {
		this.expirationType = expirationType;
	}

	public String getMaterialDescription() {
		return materialDescription;
	}

	public void setMaterialDescription(String materialDescription) {
		this.materialDescription = materialDescription;
	}

	public String getTreshold() {
		return treshold;
	}

	public void setTreshold(String treshold) {
		this.treshold = treshold;
	}
	
}
