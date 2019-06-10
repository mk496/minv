package com.cg.mobinv.mobileinventory.common.api.to;

import java.util.List;

import org.apache.olingo.odata2.api.annotation.edm.*;


@EdmEntityType(name = "RequisitionHeader")
@EdmEntitySet(name = "RequisitionHeaderSet")
public class RequisitionHeaderTo {
	
	@EdmKey
    @EdmProperty
    private Long id;
	
	@EdmProperty
	private String requisitionDescription;
	
	@EdmNavigationProperty
	private List<RequisitionItemTo> toItems;
	
	
	public RequisitionHeaderTo() {}


	public RequisitionHeaderTo(Long id, String requisitionDescription,
			List<RequisitionItemTo> toItems) {
		this.id = id;
		this.requisitionDescription = requisitionDescription;
		this.toItems = toItems;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRequisitionDescription() {
		return requisitionDescription;
	}


	public void setRequisitionDescription(String requisitionDescription) {
		this.requisitionDescription = requisitionDescription;
	}


	public List<RequisitionItemTo> getItems() {
		return toItems;
	}


	public void setItems(List<RequisitionItemTo> toItems) {
		this.toItems = toItems;
	}
	
}
