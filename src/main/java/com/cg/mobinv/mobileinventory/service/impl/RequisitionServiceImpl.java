package com.cg.mobinv.mobileinventory.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.HttpMethod;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType.Type;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.cg.mobinv.mobileinventory.common.api.to.RequisitionHeaderTo;
import com.cg.mobinv.mobileinventory.dataaccess.api.InventoryEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.RequisitionHeaderEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.RequisitionItemEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.repository.InventoryEntityRepository;
import com.cg.mobinv.mobileinventory.dataaccess.api.repository.RequisitionHeaderRepository;
import com.cg.mobinv.mobileinventory.dataaccess.api.repository.RequisitionItemRepository;
import com.cg.mobinv.mobileinventory.service.api.RequisitionService;

@Service
public class RequisitionServiceImpl implements RequisitionService {

	@Inject
	RequisitionHeaderRepository headerRepository;

	@Inject
	RequisitionItemRepository itemsRepository;

	@Inject
	InventoryEntityRepository inventoryRepository;

	@Inject
	private Mapper mapper;

	private final static long threshold = 10;

	@Override
	public RequisitionHeaderTo addRequisition() {
		List<InventoryEntity> inventoryFromDb = inventoryRepository.findAll();
		List<InventoryEntity> inventoryToOrder = new ArrayList<>();
		for (InventoryEntity inventory : inventoryFromDb) {
			if (Integer.parseInt(inventory.getShelfStock()) < threshold) {
				inventoryToOrder.add(inventory);
			}
		}
		if (!inventoryToOrder.isEmpty()) {
			RequisitionHeaderEntity newRequisition = new RequisitionHeaderEntity();
			newRequisition.setRequisitionDescription("Probne zamowienie");
			headerRepository.saveAndFlush(newRequisition);
			for (InventoryEntity inventory : inventoryToOrder) {
				RequisitionItemEntity newItem = new RequisitionItemEntity();
				newItem.setItemDesc(inventory.getProductDescription());
				int quantity = Integer.parseInt(inventory.getInStock()) - Integer.parseInt(inventory.getShelfStock());
				newItem.setQuantity(quantity);
				newItem.setRequisitionHeader(newRequisition);
				itemsRepository.save(newItem);
			}
			return mapper.map(newRequisition, RequisitionHeaderTo.class);
		}
		return null;
	}

}
