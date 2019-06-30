package com.cg.mobinv.mobileinventory.logic.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import com.cg.mobinv.mobileinventory.common.api.to.LocationsTo;
import com.cg.mobinv.mobileinventory.dataaccess.api.LocationsEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.MaterialEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.repository.LocationsEntityRepository;
import com.cg.mobinv.mobileinventory.logic.api.LocationsLogic;
import com.google.common.collect.Lists;

@Component
public class LocationsLogicImpl implements LocationsLogic {

	@Inject
	private LocationsEntityRepository locationsEntityRepository;

	@Inject
	private Mapper mapper;

	@Override
	public List<LocationsTo> readAll() {
		List<LocationsEntity> queryResult = Lists.newArrayList(this.locationsEntityRepository.findAll());
		List<LocationsTo> resultMapped = queryResult.stream().map(x -> mapToTransferObject(x))
				.collect(Collectors.toList());

		return resultMapped;
	}

	private LocationsTo mapToTransferObject(LocationsEntity entity) {
		LocationsTo locationsTo = null;
		if (entity != null) {
			locationsTo = this.mapper.map(entity, LocationsTo.class);
		}
		return locationsTo;
	}

	@Override
	public LocationsTo readById(Long id) {
		return mapToTransferObject(this.locationsEntityRepository.findOne(id));
	}

	@Override
	public LocationsTo create(LocationsTo locationsTo) {

		LocationsEntity newEntity = mapToEntity(locationsTo);
		this.locationsEntityRepository.save(newEntity);
		return mapToTransferObject(newEntity);
	}

	private LocationsEntity mapToEntity(LocationsTo locationsTo) {
		return this.mapper.map(locationsTo, LocationsEntity.class);
	}

	@Override
	public LocationsTo createEmpty() {
		return new LocationsTo();
	}

	@Override
	public LocationsTo update(LocationsTo locationsTo) {

		LocationsEntity entity = mapToEntity(locationsTo);
        this.locationsEntityRepository.save(entity);
        return mapToTransferObject(entity);
	}

	@Override
	public LocationsTo setRelation(LocationsTo source, Object targetObject) {
		LocationsTo result = null;
		return result;
	}

	@Override
	public <S> List<S> readRelatedEntities(LocationsTo source, Class<S> targetClass) {
		List<S> result = null;
		return result;
	}

	@Override
	public <S> S readRelatedEntity(LocationsTo source, Class<S> targetClass) {
		S result = null;
		return result;
	}

	@Override
	public void deleteById(Long id) {
		this.locationsEntityRepository.delete(id);

	}

}
