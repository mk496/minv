package com.cg.hkrbudgeting.budgetingmanagement.service.impl;

import com.cg.hkrbudgeting.budgetingmanagement.common.api.to.AdministrationUnitTypeTo;
import com.cg.hkrbudgeting.budgetingmanagement.logic.api.AdministrationUnitTypeLogic;
import com.cg.hkrbudgeting.budgetingmanagement.service.api.AdministrationUnitTypeService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Service
public class AdministrationUnitTypeServiceImpl implements AdministrationUnitTypeService {

    private final String KEY = "Id";

    @Inject
    private AdministrationUnitTypeLogic administrationUnitTypeLogic;

    @Override
    public AdministrationUnitTypeTo createEntity(AdministrationUnitTypeTo to) {

        return this.administrationUnitTypeLogic.create(to);
    }

    @Override
    public AdministrationUnitTypeTo createEmptyEntity() {

        return this.administrationUnitTypeLogic.createEmpty();
    }

    @Override
    public AdministrationUnitTypeTo updateEntity(AdministrationUnitTypeTo to) {

        return this.administrationUnitTypeLogic.update(to);
    }

    @Override
    public void deleteEntity(Map<String, Object> keys) {

        this.administrationUnitTypeLogic.deleteById((Long) keys.get(this.KEY));

    }

    @Override
    public List<AdministrationUnitTypeTo> readAllEntities() {

        return this.administrationUnitTypeLogic.readAll();
    }

    @Override
    public AdministrationUnitTypeTo readEntity(Map<String, Object> keys) {

        return this.administrationUnitTypeLogic.readById((Long) keys.get(this.KEY));
    }

    @Override
    public <S> List<S> readRelatedEntities(AdministrationUnitTypeTo source, Class<S> targetClass) {

        return this.administrationUnitTypeLogic.readRelatedEntities(source, targetClass);
    }
    
    @Override
    public <S> S readRelatedEntity(AdministrationUnitTypeTo source, Class<S> targetClass) {

        return this.administrationUnitTypeLogic.readRelatedEntity(source, targetClass);
    }

    @Override
    public Class<?> getToClassType() {

        return AdministrationUnitTypeTo.class;
    }

	@Override
	public AdministrationUnitTypeTo setRelation(AdministrationUnitTypeTo source, Object nestedObject) {

		return this.administrationUnitTypeLogic.setRelation(source, nestedObject);
	}
}
