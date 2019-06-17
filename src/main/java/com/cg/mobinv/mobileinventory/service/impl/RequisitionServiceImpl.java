package com.cg.mobinv.mobileinventory.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.cg.mobinv.mobileinventory.common.api.to.RequisitionHeaderTo;
import com.cg.mobinv.mobileinventory.dataaccess.api.InventoryEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.RequisitionHeaderEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.RequisitionItemEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.enums.Status;
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
			if (Integer.parseInt(inventory.getShelfStock()) < threshold
					&& Integer.parseInt(inventory.getInStock()) > Integer.parseInt(inventory.getShelfStock())
					&& !isOrdered(inventory)) {
				inventoryToOrder.add(inventory);
			}
		}
		if (!inventoryToOrder.isEmpty()) {
			RequisitionHeaderEntity newRequisition = new RequisitionHeaderEntity();
			newRequisition.setRequisitionDescription("Probne zamowienie");
			newRequisition.setRequisitionDate(new Date());
			newRequisition.setRequisitionStatus(Status.Open);
			headerRepository.save(newRequisition);
			RequisitionItemEntity newItem;
			for (InventoryEntity inventory : inventoryToOrder) {
				newItem = createItem(inventory);
				newItem.setRequisitionHeader(newRequisition);
				itemsRepository.save(newItem);
			}
			return mapper.map(newRequisition, RequisitionHeaderTo.class);
		}
		return null;
	}

	private RequisitionItemEntity createItem(InventoryEntity inventory) {
		RequisitionItemEntity item = new RequisitionItemEntity();
		item.setInventoryId(inventory.getId());
		item.setItemDesc(inventory.getProductDescription());
		int quantity = Integer.parseInt(inventory.getInStock()) - Integer.parseInt(inventory.getShelfStock());
		item.setQuantity(quantity);
		item.setUnit(inventory.getUnit());
		return item;
	}

	private boolean isOrdered(InventoryEntity inventory) {
		List<RequisitionItemEntity> items = itemsRepository.findByInventoryId(inventory.getId());
		boolean isOrdered = false;
		for (RequisitionItemEntity item : items) {
			if (item != null && item.getRequisitionHeader().getRequisitionStatus().equals(Status.Open)) {
				isOrdered = true;
				break;
			}
		}
		return isOrdered;
	}

}
