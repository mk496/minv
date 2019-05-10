package com.cg.mobinv.mobileinventory.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cg.mobinv.mobileinventory.common.api.to.RequisitionHeaderTo;
import com.cg.mobinv.mobileinventory.logic.api.RequisitionHeaderLogic;
import com.cg.mobinv.mobileinventory.service.api.RequisitionHeaderService;


@Service
public class RequisitionHeaderServiceImpl implements RequisitionHeaderService {
	
	private final String KEY = "Id";
	
	@Inject
	private RequisitionHeaderLogic requisitionLogic;

	@Override
	public RequisitionHeaderTo createEntity(RequisitionHeaderTo to) {
		
		return this.requisitionLogic.create(to);
	}

	@Override
	public RequisitionHeaderTo createEmptyEntity() {
		
		return this.requisitionLogic.createEmpty();
	}

	@Override
	public RequisitionHeaderTo updateEntity(RequisitionHeaderTo to) {
		
		return this.requisitionLogic.update(to);
	}

	@Override
	public void deleteEntity(Map<String, Object> keys) {
		this.requisitionLogic.deleteById((Long) keys.get(this.KEY));
		
	}

	@Override
	public List<RequisitionHeaderTo> readAllEntities() {
		
		return this.requisitionLogic.readAll();
	}

	@Override
	public RequisitionHeaderTo readEntity(Map<String, Object> keys) {
		
		return this.requisitionLogic.readById((Long) keys.get(this.KEY));
	}

	//to do
	@Override
	public RequisitionHeaderTo setRelation(RequisitionHeaderTo source, Object nestedObject) {
		
		return this.requisitionLogic.setRelation(source, nestedObject);
	}

	//to do
	@Override
	public <S> List<S> readRelatedEntities(RequisitionHeaderTo source, Class<S> targetClass) {
		
		return this.requisitionLogic.readRelatedEntities(source, targetClass);
	}

	//to do
	@Override
	public <S> S readRelatedEntity(RequisitionHeaderTo source, Class<S> targetClass) {
		
		return this.requisitionLogic.readRelatedEntity(source, targetClass);
	}

	@Override
	public Class<?> getToClassType() {
		
		return RequisitionHeaderTo.class;
	}

}
