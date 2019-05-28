package com.cg.mobinv.mobileinventory.common.api.to;

import org.apache.olingo.odata2.api.annotation.edm.*;

@EdmEntityType(name = "RequisitionItem")
@EdmEntitySet(name = "RequisitionItemSet")
public class RequisitionItemTo {


	@EdmKey
    @EdmProperty
    private Long id;
	
	@EdmProperty
	private String itemDesc;
	
	@EdmProperty
	private Integer quantity;
	
	@EdmProperty
	private String unit;
	
	@EdmNavigationProperty
	private RequisitionHeaderTo requisitionHeader;

	public RequisitionItemTo() {}

	public RequisitionItemTo(Long id, String itemDesc, Integer quantity, String unit) {
		this.id = id;
		this.itemDesc = itemDesc;
		this.quantity = quantity;
		this.unit = unit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public RequisitionHeaderTo getRequisitionHeader() {
		return requisitionHeader;
	}

	public void setRequisitionHeader(RequisitionHeaderTo requisitionHeader) {
		this.requisitionHeader = requisitionHeader;
	}
	

}
