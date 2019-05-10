package com.cg.mobinv.mobileinventory.logic.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import com.cg.mobinv.mobileinventory.common.api.to.InventoryTo;
import com.cg.mobinv.mobileinventory.dataaccess.api.InventoryEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.repository.InventoryEntityRepository;
import com.cg.mobinv.mobileinventory.logic.api.InventoryLogic;
import com.google.common.collect.Lists;

@Component
public class InventoryLogicImpl implements InventoryLogic {
	
	@Inject
	private InventoryEntityRepository inventoryEntityRepository;
	
	@Inject
    private Mapper mapper;

	@Override
	public List<InventoryTo> readAll() {
		List<InventoryEntity> queryResult =
                Lists.newArrayList(this.inventoryEntityRepository.findAll());
        List<InventoryTo> resultMapped =
                queryResult.stream().map(x -> mapToTransferObject(x)).collect(Collectors.toList());

        return resultMapped;
	}

	private InventoryTo mapToTransferObject(InventoryEntity entity) {
		InventoryTo inventoryTo = null;
		if (entity != null) {
			inventoryTo = this.mapper.map(entity, InventoryTo.class);
		}
		return inventoryTo;
	}

	@Override
	public InventoryTo readById(Long id) {
		return mapToTransferObject(this.inventoryEntityRepository.findOne(id));
	}

	@Override
	public InventoryTo create(InventoryTo inventoryTo) {
		
		InventoryEntity newEntity = mapToEntity(inventoryTo);
		this.inventoryEntityRepository.save(newEntity);
		return mapToTransferObject(newEntity);
	}

	private InventoryEntity mapToEntity(InventoryTo inventoryTo) {
		return this.mapper.map(inventoryTo, InventoryEntity.class);
	}

	@Override
	public InventoryTo createEmpty() {
		return new InventoryTo();
	}

	@Override
	public InventoryTo update(InventoryTo inventoryTo) {
		InventoryEntity entity = mapToEntity(inventoryTo);
		this.inventoryEntityRepository.save(entity);
		return mapToTransferObject(entity);
	}

	@Override
	public InventoryTo setRelation(InventoryTo source, Object targetObject) {
		InventoryTo result = null;
  		return result;
	}

	@Override
	public <S> List<S> readRelatedEntities(InventoryTo source, Class<S> targetClass) {
		List<S> result = null;
        return result;
	}

	@Override
	public <S> S readRelatedEntity(InventoryTo source, Class<S> targetClass) {
		 S result = null;
	     return result;
	}

	@Override
	public void deleteById(Long id) {
		this.inventoryEntityRepository.delete(id);
		
	}

}
