package com.cg.mobinv.mobileinventory.logic.impl;

import com.cg.mobinv.mobileinventory.common.api.to.AdministrationUnitTypeTo;
import com.cg.mobinv.mobileinventory.dataaccess.api.AdministrationUnitTypeEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.repository.AdministrationUnitTypeEntityRepository;
import com.cg.mobinv.mobileinventory.logic.api.AdministrationUnitTypeLogic;
import com.google.common.collect.Lists;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdministrationUnitTypeLogicImpl implements AdministrationUnitTypeLogic {

    @Inject
    private AdministrationUnitTypeEntityRepository administrationUnitTypeEntityRepository;

    @Inject
    private Mapper mapper;

    @Override
    public List<AdministrationUnitTypeTo> readAll() {

        List<AdministrationUnitTypeEntity> queryResult =
                Lists.newArrayList(this.administrationUnitTypeEntityRepository.findAll());
        List<AdministrationUnitTypeTo> resultMapped =
                queryResult.stream().map(x -> mapToTransferObject(x)).collect(Collectors.toList());

        return resultMapped;
    }

    @Override
    public AdministrationUnitTypeTo readById(Long id) {

        return mapToTransferObject(this.administrationUnitTypeEntityRepository.findOne(id));
    }

    @Override
    public AdministrationUnitTypeTo create(AdministrationUnitTypeTo to) {

        AdministrationUnitTypeEntity entity = mapToEntity(to);
        this.administrationUnitTypeEntityRepository.save(entity);
        return mapToTransferObject(entity);

    }

    @Override
    public AdministrationUnitTypeTo createEmpty() {

        return new AdministrationUnitTypeTo();
    }

    @Override
    public AdministrationUnitTypeTo update(AdministrationUnitTypeTo to) {

        AdministrationUnitTypeEntity entity = mapToEntity(to);
        this.administrationUnitTypeEntityRepository.save(entity);
        return mapToTransferObject(entity);
    }
    
  	@Override
    public AdministrationUnitTypeTo setRelation(AdministrationUnitTypeTo source, Object targetObject) {

    	AdministrationUnitTypeTo result = null;
  		return result;
  	}

    @Override
    public <S> List<S> readRelatedEntities(AdministrationUnitTypeTo source, Class<S> targetClass) {

        List<S> result = null;
        return result;
    }
    
    @Override
    public <S> S readRelatedEntity(AdministrationUnitTypeTo source, Class<S> targetClass) {

        S result = null;
        return result;
    }

    @Override
    public void deleteById(Long id) {

        this.administrationUnitTypeEntityRepository.delete(id);

    }

	private AdministrationUnitTypeTo mapToTransferObject(AdministrationUnitTypeEntity entity) {

		AdministrationUnitTypeTo administrationUnitTypeTo = null;
		if (entity != null) {
			administrationUnitTypeTo = this.mapper.map(entity, AdministrationUnitTypeTo.class);
		}
		return administrationUnitTypeTo;
	}

	private AdministrationUnitTypeEntity mapToEntity(AdministrationUnitTypeTo to) {

		return this.mapper.map(to, AdministrationUnitTypeEntity.class);
	}

}

