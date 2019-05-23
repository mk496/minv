package com.cg.mobinv.mobileinventory.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import com.cg.mobinv.mobileinventory.common.api.to.RequisitionHeaderTo;
import com.cg.mobinv.mobileinventory.common.api.to.RequisitionItemTo;
import com.cg.mobinv.mobileinventory.dataaccess.api.RequisitionHeaderEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.RequisitionItemEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.repository.RequisitionHeaderRepository;
import com.cg.mobinv.mobileinventory.logic.api.RequisitionHeaderLogic;
import com.google.common.collect.Lists;


@Component
public class RequisitionHeaderLogicImpl implements RequisitionHeaderLogic {
	
	@Inject
	private RequisitionHeaderRepository requisitionRepository;
	
	@Inject
    private Mapper mapper;

	@Override
	public List<RequisitionHeaderTo> readAll() {
		List<RequisitionHeaderEntity> queryResult = Lists.newArrayList(this.requisitionRepository.findAll());
		List<RequisitionHeaderTo> resultMapped =
                queryResult.stream().map(x -> mapToTransferObject(x)).collect(Collectors.toList());

		return resultMapped;
	}

	private RequisitionHeaderTo mapToTransferObject(RequisitionHeaderEntity entity) {
		RequisitionHeaderTo requisitionTo = null;
		if(entity != null) {
			requisitionTo = this.mapper.map(entity, RequisitionHeaderTo.class);
		}
		
		return requisitionTo;
	}

	@Override
	public RequisitionHeaderTo readById(Long id) {
	
		return mapToTransferObject(this.requisitionRepository.findOne(id));
	}

	@Override
	public RequisitionHeaderTo create(RequisitionHeaderTo to) {
		
		RequisitionHeaderEntity newEntity = mapToEntity(to);
		this.requisitionRepository.save(newEntity);
		return mapToTransferObject(newEntity);
	}

	private RequisitionHeaderEntity mapToEntity(RequisitionHeaderTo to) {
		
		return this.mapper.map(to, RequisitionHeaderEntity.class);
	}

	@Override
	public RequisitionHeaderTo createEmpty() {
		
		return new RequisitionHeaderTo();
	}

	@Override
	public RequisitionHeaderTo update(RequisitionHeaderTo headerTo) {

		RequisitionHeaderEntity entity = mapToEntity(headerTo);
		this.requisitionRepository.save(entity);
		return mapToTransferObject(entity);
	}
	
	private List<RequisitionItemTo> getRelatedItems(Long id){
		RequisitionHeaderEntity headerEntity = requisitionRepository.findOne(id);
		List<RequisitionItemEntity> relatedItems = headerEntity.getItems();
		List<RequisitionItemTo> relatedItemsTos = new ArrayList<>();
		for(RequisitionItemEntity itemEntity : relatedItems) {
			relatedItemsTos.add(mapper.map(itemEntity, RequisitionItemTo.class));
		}
		
		return relatedItemsTos;
	}

	@Override
	public RequisitionHeaderTo setRelation(RequisitionHeaderTo source, Object o) {
		RequisitionHeaderTo result = null;
		return result;
	}
	
	@Override
	public <S> List<S> readRelatedEntities(RequisitionHeaderTo source, Class<S> targetClass) {

        return (List<S>) this.getRelatedItems(source.getId());
	}

	@Override
	public <S> S readRelatedEntity(RequisitionHeaderTo source, Class<S> targetClass) {
		 S result = null;
	     return result;
	}

	@Override
	public void deleteById(Long id) {
		this.requisitionRepository.delete(id);
		
	}

}
