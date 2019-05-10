package com.cg.mobinv.mobileinventory.logic.impl;

import com.cg.mobinv.mobileinventory.common.api.to.MaterialTo;
import com.cg.mobinv.mobileinventory.dataaccess.api.MaterialEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.repository.MaterialEntityRepository;
import com.cg.mobinv.mobileinventory.logic.api.MaterialLogic;
import com.google.common.collect.Lists;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MaterialLogicImpl implements MaterialLogic {

    @Inject
    private MaterialEntityRepository materialEntityRepository;

    @Inject
    private Mapper mapper;

    @Override
    public List<MaterialTo> readAll() {

        List<MaterialEntity> queryResult =
                Lists.newArrayList(this.materialEntityRepository.findAll());
        List<MaterialTo> resultMapped =
                queryResult.stream().map(x -> mapToTransferObject(x)).collect(Collectors.toList());

        return resultMapped;
    }

    @Override
    public MaterialTo readById(Long id) {

        return mapToTransferObject(this.materialEntityRepository.findOne(id));
    }

    @Override
    public MaterialTo create(MaterialTo to) {

        MaterialEntity entity = mapToEntity(to);
        this.materialEntityRepository.save(entity);
        return mapToTransferObject(entity);

    }

    @Override
    public MaterialTo createEmpty() {

        return new MaterialTo();
    }

    @Override
    public MaterialTo update(MaterialTo to) {

        MaterialEntity entity = mapToEntity(to);
        this.materialEntityRepository.save(entity);
        return mapToTransferObject(entity);
    }
    
  	@Override
    public MaterialTo setRelation(MaterialTo source, Object targetObject) {

    	MaterialTo result = null;
  		return result;
  	}

    @Override
    public <S> List<S> readRelatedEntities(MaterialTo source, Class<S> targetClass) {

        List<S> result = null;
        return result;
    }
    
    @Override
    public <S> S readRelatedEntity(MaterialTo source, Class<S> targetClass) {

        S result = null;
        return result;
    }

    @Override
    public void deleteById(Long id) {

        this.materialEntityRepository.delete(id);

    }

	private MaterialTo mapToTransferObject(MaterialEntity entity) {

		MaterialTo materialTo = null;
		if (entity != null) {
			materialTo = this.mapper.map(entity, MaterialTo.class);
		}
		return materialTo;
	}

	private MaterialEntity mapToEntity(MaterialTo to) {

		return this.mapper.map(to, MaterialEntity.class);
	}

}

