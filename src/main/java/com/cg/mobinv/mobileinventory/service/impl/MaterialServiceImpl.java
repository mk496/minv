package com.cg.mobinv.mobileinventory.service.impl;

import org.springframework.stereotype.Service;

import com.cg.mobinv.mobileinventory.common.api.to.MaterialTo;
import com.cg.mobinv.mobileinventory.logic.api.MaterialLogic;
import com.cg.mobinv.mobileinventory.service.api.MaterialService;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final String KEY = "Id";

    @Inject
    private MaterialLogic materialLogic;

    @Override
    public MaterialTo createEntity(MaterialTo to) {

        return this.materialLogic.create(to);
    }

    @Override
    public MaterialTo createEmptyEntity() {

        return this.materialLogic.createEmpty();
    }

    @Override
    public MaterialTo updateEntity(MaterialTo to) {

        return this.materialLogic.update(to);
    }

    @Override
    public void deleteEntity(Map<String, Object> keys) {

        this.materialLogic.deleteById((Long) keys.get(this.KEY));

    }

    @Override
    public List<MaterialTo> readAllEntities() {

        return this.materialLogic.readAll();
    }

    @Override
    public MaterialTo readEntity(Map<String, Object> keys) {

        return this.materialLogic.readById((Long) keys.get(this.KEY));
    }

    @Override
    public <S> List<S> readRelatedEntities(MaterialTo source, Class<S> targetClass) {

        return this.materialLogic.readRelatedEntities(source, targetClass);
    }
    
    @Override
    public <S> S readRelatedEntity(MaterialTo source, Class<S> targetClass) {

        return this.materialLogic.readRelatedEntity(source, targetClass);
    }

    @Override
    public Class<?> getToClassType() {

        return MaterialTo.class;
    }

	@Override
	public MaterialTo setRelation(MaterialTo source, Object nestedObject) {

		return this.materialLogic.setRelation(source, nestedObject);
	}
}
