package com.cg.mobinv.mobileinventory.service.rest;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mobinv.mobileinventory.common.api.to.InventoryTo;
import com.cg.mobinv.mobileinventory.service.api.InventoryService;

@RestController
public class InventoryRestService {

	@Inject
	private InventoryService inventoryService;
	
	@PostMapping("api/inventories")
	public InventoryTo addInventory(@RequestBody InventoryTo inventory) {
		return inventoryService.createEntity(inventory);
	}
	
	@GetMapping("api/inventories")
	public List<InventoryTo> getAllInventories(){
		return inventoryService.readAllEntities();
	}
	
	@GetMapping("api/inventories/{inventoryId}")
	public InventoryTo getInventory(@PathVariable("inventoryId") Map<String, Object> id){
		return inventoryService.readEntity(id);
	}
	
	@PutMapping("api/inventories")
	public InventoryTo updateInventory(@RequestBody InventoryTo inventory) {
		return inventoryService.updateEntity(inventory);
	}
	
	@DeleteMapping("api/inventories/{inventoryId}")
	public void deleteInventory(@PathVariable("inventoryId") Map<String, Object> id) {
		inventoryService.deleteEntity(id);
	}
	
	
}
