package com.cg.mobinv.mobileinventory.common.api.to;

import org.apache.olingo.odata2.api.annotation.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.annotation.edm.EdmEntityType;
import org.apache.olingo.odata2.api.annotation.edm.EdmKey;
import org.apache.olingo.odata2.api.annotation.edm.EdmProperty;

@EdmEntityType(name = "RequisitionHeader")
@EdmEntitySet(name = "RequisitionHeaders")
public class RequisitionHeaderTo {
	
	@EdmKey
    @EdmProperty
    private Long id;
	
	@EdmProperty
	private String reqDesc;
	
	@EdmProperty
	private Integer newAttr;
	
	public RequisitionHeaderTo() {}
	

	public RequisitionHeaderTo(Long id, String reqDesc, Integer newAttr) {
		this.id = id;
		this.reqDesc = reqDesc;
		this.newAttr = newAttr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReqDesc() {
		return reqDesc;
	}

	public void setReqDesc(String reqDesc) {
		this.reqDesc = reqDesc;
	}

	public Integer getNewAttr() {
		return newAttr;
	}

	public void setNewAttr(Integer newAttr) {
		this.newAttr = newAttr;
	}


}
