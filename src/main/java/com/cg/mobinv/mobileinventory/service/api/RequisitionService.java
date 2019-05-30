package com.cg.mobinv.mobileinventory.service.api;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.HttpMethod;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType.Type;

import com.cg.mobinv.mobileinventory.common.api.to.RequisitionHeaderTo;

public interface RequisitionService {

	@SuppressWarnings("unchecked")
	@EdmFunctionImport(name = "newRequisition", entitySet = "RequisitionHeaderSet", 
	httpMethod = HttpMethod.GET, returnType = @ReturnType(type = Type.ENTITY))
	RequisitionHeaderTo addRequisition();
	
}
