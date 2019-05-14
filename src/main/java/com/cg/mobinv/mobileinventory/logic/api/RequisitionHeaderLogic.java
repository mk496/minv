package com.cg.mobinv.mobileinventory.logic.api;

import java.util.List;

import com.cg.mobinv.mobileinventory.common.api.to.RequisitionHeaderTo;
import com.cg.mobinv.mobileinventory.common.api.to.RequisitionItemTo;

public interface RequisitionHeaderLogic extends LogicComponent<RequisitionHeaderTo> {

	List<RequisitionItemTo> getRelatedItems(Long id);

}
