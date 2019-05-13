package com.cg.mobinv.mobileinventory.logic.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import com.cg.mobinv.mobileinventory.common.api.to.RequisitionItemTo;
import com.cg.mobinv.mobileinventory.dataaccess.api.RequisitionHeaderEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.RequisitionItemEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.repository.RequisitionHeaderRepository;
import com.cg.mobinv.mobileinventory.dataaccess.api.repository.RequisitionItemRepository;
import com.cg.mobinv.mobileinventory.logic.api.RequisitionItemLogic;
import com.google.common.collect.Lists;

@Component
public class RequisitionItemLogicImpl implements RequisitionItemLogic {

	@Inject
	private RequisitionItemRepository itemRepository;
	
	@Inject
	private RequisitionHeaderRepository requisitionRepository;
	
	@Inject
    private Mapper mapper;
	
	@Override
	public List<RequisitionItemTo> readAll() {
		List<RequisitionItemEntity> queryResult = Lists.newArrayList(this.itemRepository.findAll());
		List<RequisitionItemTo> resultMapped =
                queryResult.stream().map(x -> mapToTransferObject(x)).collect(Collectors.toList());

		return resultMapped;
	}

	private RequisitionItemTo mapToTransferObject(RequisitionItemEntity entity) {
		RequisitionItemTo requisitionTo = null;
		if(entity != null) {
			requisitionTo = this.mapper.map(entity, RequisitionItemTo.class);
		}
		
		return requisitionTo;
	}

	@Override
	public RequisitionItemTo readById(Long id) {
		
		return mapToTransferObject(this.itemRepository.findOne(id));
	}

	@Override
	public RequisitionItemTo create(RequisitionItemTo itemTo) {
		
		RequisitionHeaderEntity reqheader = requisitionRepository.findByReqDesc(itemTo.getRequisitionHeader());
		
		RequisitionItemEntity newItem = mapToEntity(itemTo);
		if(reqheader != null) {
			newItem.setRequisitionHeader(reqheader);
		}
		this.itemRepository.save(newItem);
		return mapToTransferObject(newItem);
	}

	private RequisitionItemEntity mapToEntity(RequisitionItemTo to) {
		
		return this.mapper.map(to, RequisitionItemEntity.class);
	}

	@Override
	public RequisitionItemTo createEmpty() {
		
		return new RequisitionItemTo();
	}

	@Override
	public RequisitionItemTo update(RequisitionItemTo to) {

		RequisitionItemEntity entity = mapToEntity(to);
		this.itemRepository.save(entity);
		return mapToTransferObject(entity);
	}

	@Override
	public RequisitionItemTo setRelation(RequisitionItemTo itemTo, Object targetObject) {
		RequisitionItemTo result = null;
		return result;
	}

	@Override
	public <S> List<S> readRelatedEntities(RequisitionItemTo source, Class<S> targetClass) {
		List<S> result = null;
        return result;
	}

	@Override
	public <S> S readRelatedEntity(RequisitionItemTo source, Class<S> targetClass) {
		S result = null;
	     return result;
	}

	@Override
	public void deleteById(Long id) {
		this.itemRepository.delete(id);
		
	}

}
