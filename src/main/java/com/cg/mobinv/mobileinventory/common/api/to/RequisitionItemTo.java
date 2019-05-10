package com.cg.mobinv.mobileinventory.common.api.to;

import org.apache.olingo.odata2.api.annotation.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.annotation.edm.EdmEntityType;
import org.apache.olingo.odata2.api.annotation.edm.EdmKey;
import org.apache.olingo.odata2.api.annotation.edm.EdmProperty;

@EdmEntityType(name = "RequisitionItem")
@EdmEntitySet(name = "RequisitionItems")
public class RequisitionItemTo {
	
	@EdmKey
    @EdmProperty
    private Long id;
	
	@EdmProperty
	private String itemDesc;
	
	@EdmProperty
	private int quantity;
	
	@EdmProperty
	private String unit;
	
	public RequisitionItemTo() {}

	public RequisitionItemTo(Long id, String itemDesc, int quantity, String unit) {
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	

}
