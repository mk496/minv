package com.cg.mobinv.mobileinventory.service.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mobinv.mobileinventory.common.api.to.RequisitionHeaderTo;
import com.cg.mobinv.mobileinventory.common.api.to.RequisitionItemTo;
import com.cg.mobinv.mobileinventory.dataaccess.api.repository.RequisitionHeaderRepository;
import com.cg.mobinv.mobileinventory.logic.api.RequisitionHeaderLogic;

@RestController
public class RequisitionHeaderRestService {
	
	@Inject
	private RequisitionHeaderLogic requisitionLogic;
	
	@Inject
	private RequisitionHeaderRepository requisitionRepository;
	
	@PostMapping("api/requisitions")
	public RequisitionHeaderTo addRequisition(@RequestBody RequisitionHeaderTo requisition) {
		return requisitionLogic.create(requisition);
	}
	
	@GetMapping("api/requisitions/{requisitionId}")
	public RequisitionHeaderTo getRequisition(@PathVariable("requisitionId") long id){
		return requisitionLogic.readById(id);
	}
	
	@GetMapping("api/requisitions")
	public List<RequisitionHeaderTo> getAllRequisitions(){
		return requisitionLogic.readAll();
	}
	
	@PutMapping("api/requisitions")
	public RequisitionHeaderTo updateRequisition(@RequestBody RequisitionHeaderTo requisition) {
		return requisitionLogic.update(requisition);
	}
	
	@DeleteMapping("api/requisitions/{requisitionId}")
	public void deleteRequisition(@PathVariable("requisitionId") long id) {
		requisitionLogic.deleteById(id);
	}
	
	@GetMapping("api/requisitions/{requisitionId}/navToItems")
	public List<RequisitionItemTo> getItems(@PathVariable("requisitionId") long id) {
		return requisitionLogic.getRelatedItems(id);
	}

}
