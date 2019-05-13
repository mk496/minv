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

import com.cg.mobinv.mobileinventory.common.api.to.RequisitionItemTo;
import com.cg.mobinv.mobileinventory.logic.api.RequisitionItemLogic;

@RestController
public class RequisitionItemRestService {
	
	@Inject RequisitionItemLogic itemLogic;
	
	@PostMapping("api/items")
	public RequisitionItemTo addItem(@RequestBody RequisitionItemTo item) {
		return itemLogic.create(item);
	}
	
	@GetMapping("api/items")
	public List<RequisitionItemTo> getAllItems() {
		return itemLogic.readAll();
	}
	
	@GetMapping("api/items/{itemId}")
	public RequisitionItemTo getItem(@PathVariable("itemId") long id) {
		return itemLogic.readById(id);
	}
	
	@PutMapping("api/items")
	public RequisitionItemTo updateItem(@RequestBody RequisitionItemTo item) {
		return itemLogic.update(item);
	}
	
	@DeleteMapping("api/items/{itemId}")
	public void deleteItem(@PathVariable("itemId") long id) {
		itemLogic.deleteById(id);
	}

}
