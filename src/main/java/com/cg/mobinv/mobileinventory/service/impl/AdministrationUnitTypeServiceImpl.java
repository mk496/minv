package com.cg.mobinv.mobileinventory.service.impl;

import org.springframework.stereotype.Service;

import com.cg.mobinv.mobileinventory.common.api.to.MaterialTo;
import com.cg.mobinv.mobileinventory.logic.api.AdministrationUnitTypeLogic;
import com.cg.mobinv.mobileinventory.service.api.AdministrationUnitTypeService;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Service
public class AdministrationUnitTypeServiceImpl implements AdministrationUnitTypeService {

    private final String KEY = "Id";

    @Inject
    private AdministrationUnitTypeLogic administrationUnitTypeLogic;

    @Override
    public MaterialTo createEntity(MaterialTo to) {

        return this.administrationUnitTypeLogic.create(to);
    }

    @Override
    public MaterialTo createEmptyEntity() {

        return this.administrationUnitTypeLogic.createEmpty();
    }

    @Override
    public MaterialTo updateEntity(MaterialTo to) {

        return this.administrationUnitTypeLogic.update(to);
    }

    @Override
    public void deleteEntity(Map<String, Object> keys) {

        this.administrationUnitTypeLogic.deleteById((Long) keys.get(this.KEY));

    }

    @Override
    public List<MaterialTo> readAllEntities() {

        return this.administrationUnitTypeLogic.readAll();
    }

    @Override
    public MaterialTo readEntity(Map<String, Object> keys) {

        return this.administrationUnitTypeLogic.readById((Long) keys.get(this.KEY));
    }

    @Override
    public <S> List<S> readRelatedEntities(MaterialTo source, Class<S> targetClass) {

        return this.administrationUnitTypeLogic.readRelatedEntities(source, targetClass);
    }
    
    @Override
    public <S> S readRelatedEntity(MaterialTo source, Class<S> targetClass) {

        return this.administrationUnitTypeLogic.readRelatedEntity(source, targetClass);
    }

    @Override
    public Class<?> getToClassType() {

        return MaterialTo.class;
    }

	@Override
	public MaterialTo setRelation(MaterialTo source, Object nestedObject) {

		return this.administrationUnitTypeLogic.setRelation(source, nestedObject);
	}
}
