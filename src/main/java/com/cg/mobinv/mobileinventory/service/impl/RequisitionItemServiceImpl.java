package com.cg.mobinv.mobileinventory.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cg.mobinv.mobileinventory.common.api.to.RequisitionItemTo;
import com.cg.mobinv.mobileinventory.logic.api.RequisitionItemLogic;
import com.cg.mobinv.mobileinventory.service.api.RequisitionItemService;

@Service
public class RequisitionItemServiceImpl implements RequisitionItemService {

	private final String KEY = "Id";
	
	@Inject
	private RequisitionItemLogic itemLogic;
	
	@Override
	public RequisitionItemTo createEntity(RequisitionItemTo to) {

		return this.itemLogic.create(to);
	}

	@Override
	public RequisitionItemTo createEmptyEntity() {
		
		return this.itemLogic.createEmpty();
	}

	@Override
	public RequisitionItemTo updateEntity(RequisitionItemTo to) {
		
		return this.itemLogic.update(to);
	}

	@Override
	public void deleteEntity(Map<String, Object> keys) {
		this.itemLogic.deleteById((Long) keys.get(this.KEY));
		
	}

	@Override
	public List<RequisitionItemTo> readAllEntities() {
		
		return this.itemLogic.readAll();
	}

	@Override
	public RequisitionItemTo readEntity(Map<String, Object> keys) {
		
		return this.itemLogic.readById((Long) keys.get(this.KEY));
	}

	//to do
	@Override
	public RequisitionItemTo setRelation(RequisitionItemTo source, Object nestedObject) {
		
		return this.itemLogic.setRelation(source, nestedObject);
	}

	//to do
	@Override
	public <S> List<S> readRelatedEntities(RequisitionItemTo source, Class<S> targetClass) {
		
		return this.itemLogic.readRelatedEntities(source, targetClass);
	}

	//to do
	@Override
	public <S> S readRelatedEntity(RequisitionItemTo source, Class<S> targetClass) {
		
		return this.itemLogic.readRelatedEntity(source, targetClass);
	}

	@Override
	public Class<?> getToClassType() {
		
		return RequisitionItemTo.class;
	}

}
