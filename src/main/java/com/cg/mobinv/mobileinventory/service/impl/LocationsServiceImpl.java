package com.cg.mobinv.mobileinventory.service.impl;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.cg.mobinv.mobileinventory.common.api.to.LocationsTo;
import com.cg.mobinv.mobileinventory.logic.api.LocationsLogic;
import com.cg.mobinv.mobileinventory.service.api.LocationsService;

@Service
public class LocationsServiceImpl implements LocationsService {

    private final String KEY = "Id";
    
	@Inject
    private LocationsLogic locationsLogic;

	@Override
	public LocationsTo createEntity(LocationsTo to) {
		return this.locationsLogic.create(to);
	}

	@Override
	public LocationsTo createEmptyEntity() {
		return this.locationsLogic.createEmpty();
	}

	@Override
	public LocationsTo updateEntity(LocationsTo to) {
		return this.locationsLogic.update(to);
	}

	@Override
	public void deleteEntity(Map<String, Object> keys) {
		this.locationsLogic.deleteById((Long) keys.get(this.KEY));
		
	}
	
	public void deleteEntityById(long id) {
		this.locationsLogic.deleteById(id);
		
	}

	@Override
	public List<LocationsTo> readAllEntities() {
	
		return this.locationsLogic.readAll();
	}

	@Override
	public LocationsTo readEntity(Map<String, Object> keys) {
	
		return this.locationsLogic.readById((Long) keys.get(this.KEY));
	}

	@Override
	public LocationsTo setRelation(LocationsTo source, Object nestedObject) {
	
		return this.locationsLogic.setRelation(source, nestedObject);
	}

	@Override
	public <S> List<S> readRelatedEntities(LocationsTo source, Class<S> targetClass) {
		return this.locationsLogic.readRelatedEntities(source, targetClass);
	}

	@Override
	public <S> S readRelatedEntity(LocationsTo source, Class<S> targetClass) {

        return this.locationsLogic.readRelatedEntity(source, targetClass);
	}

	@Override
	public Class<?> getToClassType() {
	
		return LocationsTo.class;
	}

}
