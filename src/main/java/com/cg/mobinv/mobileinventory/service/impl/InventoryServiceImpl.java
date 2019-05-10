package com.cg.mobinv.mobileinventory.service.impl;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.cg.mobinv.mobileinventory.common.api.to.InventoryTo;
import com.cg.mobinv.mobileinventory.logic.api.InventoryLogic;
import com.cg.mobinv.mobileinventory.service.api.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final String KEY = "Id";
    
	@Inject
    private InventoryLogic inventoryLogic;

	@Override
	public InventoryTo createEntity(InventoryTo to) {
		return this.inventoryLogic.create(to);
	}

	@Override
	public InventoryTo createEmptyEntity() {
		return this.inventoryLogic.createEmpty();
	}

	@Override
	public InventoryTo updateEntity(InventoryTo to) {
		return this.inventoryLogic.update(to);
	}

	@Override
	public void deleteEntity(Map<String, Object> keys) {
		this.inventoryLogic.deleteById((Long) keys.get(this.KEY));
		
	}
	
	public void deleteEntityById(long id) {
		this.inventoryLogic.deleteById(id);
		
	}

	@Override
	public List<InventoryTo> readAllEntities() {
	
		return this.inventoryLogic.readAll();
	}

	@Override
	public InventoryTo readEntity(Map<String, Object> keys) {
	
		return this.inventoryLogic.readById((Long) keys.get(this.KEY));
	}

	@Override
	public InventoryTo setRelation(InventoryTo source, Object nestedObject) {
	
		return this.inventoryLogic.setRelation(source, nestedObject);
	}

	@Override
	public <S> List<S> readRelatedEntities(InventoryTo source, Class<S> targetClass) {
		return this.inventoryLogic.readRelatedEntities(source, targetClass);
	}

	@Override
	public <S> S readRelatedEntity(InventoryTo source, Class<S> targetClass) {

        return this.inventoryLogic.readRelatedEntity(source, targetClass);
	}

	@Override
	public Class<?> getToClassType() {
	
		return InventoryTo.class;
	}

}
