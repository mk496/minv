package com.cg.mobinv.mobileinventory.common.api.to;

import java.util.List;

import org.apache.olingo.odata2.api.annotation.edm.*;


@EdmEntityType(name = "RequisitionHeader")
@EdmEntitySet(name = "RequisitionHeaders")
public class RequisitionHeaderTo {
	
	@EdmKey
    @EdmProperty
    private Long id;
	
	@EdmProperty
	private String requisitionDescription;
	
	@EdmProperty
	private Integer newAttribute;
	
	@EdmNavigationProperty
	private List<RequisitionItemTo> items;
	
	
	public RequisitionHeaderTo() {}


	public RequisitionHeaderTo(Long id, String requisitionDescription, Integer newAttribute,
			List<RequisitionItemTo> items) {
		this.id = id;
		this.requisitionDescription = requisitionDescription;
		this.newAttribute = newAttribute;
		this.items = items;
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


	public Integer getNewAttribute() {
		return newAttribute;
	}


	public void setNewAttribute(Integer newAttribute) {
		this.newAttribute = newAttribute;
	}


	public List<RequisitionItemTo> getItems() {
		return items;
	}


	public void setItems(List<RequisitionItemTo> items) {
		this.items = items;
	}
	
}
