package com.cg.mobinv.mobileinventory.logic.impl;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cg.mobinv.mobileinventory.common.api.to.*;
import com.cg.mobinv.mobileinventory.dataaccess.api.FileEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.FileMatchingEntity;
import com.cg.mobinv.mobileinventory.dataaccess.api.repository.FileEntityRepository;
import com.cg.mobinv.mobileinventory.dataaccess.api.repository.FileMatchingEntityRepository;
import com.cg.mobinv.mobileinventory.logic.api.FileMatchingLogic;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FileMatchingLogicImpl implements FileMatchingLogic {

    private final Logger logger = LoggerFactory.getLogger(FileMatchingLogicImpl.class);

    @Inject
    private FileMatchingEntityRepository fileMatchingRepository;

    @Inject
    private FileEntityRepository fileRepository;

    @Inject
    private Mapper mapper;

    @Override
    public List<FileMatchingTo> readAll() {

        return fileMatchingRepository.findAll()
                .stream()
                .map(this::mapToTransferObject)
                .collect(Collectors.toList());
    }

    @Override
    public FileMatchingTo readById(Long id) {

        FileMatchingEntity entity = fileMatchingRepository.findOne(id);
        return mapToTransferObject(entity);
    }

    @Override
    public FileMatchingTo update(FileMatchingTo to) {

        return create(to);
    }

    @Override
    public FileMatchingTo create(FileMatchingTo to) {

        FileMatchingEntity entity = mapToEntityObject(to);
        entity = fileMatchingRepository.save(entity);
        return mapToTransferObject(entity);
    }

    @Override
    public FileMatchingTo createEmpty() {

        return new FileMatchingTo();
    }

    @Override
    public FileMatchingTo setRelation(FileMatchingTo source, Object targetObject) {

        FileMatchingTo result = null;

        if (targetObject != null && source != null) {
            FileMatchingEntity sourcePlanningDataEntity = this.fileMatchingRepository.findOne(source.getId());

            if (targetObject instanceof FileTo) {
                FileTo targetFileTo = (FileTo) targetObject;
                FileEntity targetFileEntity = this.fileRepository.findOne(targetFileTo.getId());
                sourcePlanningDataEntity.setFile(targetFileEntity);
                logger.debug("setting realtion between FileMatchingTo " + source.getId()
                        + " and FileTo " + targetFileEntity.getId());
            }

            this.fileMatchingRepository.save(sourcePlanningDataEntity);
            result = mapToTransferObject(sourcePlanningDataEntity);
        }

        return result;
    }

    @Override
    public void deleteById(Long id) {

        fileMatchingRepository.delete(id);
    }

    private FileMatchingEntity mapToEntityObject(FileMatchingTo fileMatchingTo) {

        return mapper.map(fileMatchingTo, FileMatchingEntity.class);
    }

    private FileMatchingTo mapToTransferObject(FileMatchingEntity fileMatchingEntity) {

        return mapper.map(fileMatchingEntity, FileMatchingTo.class);
    }

    @Override
    public <S> List<S> readRelatedEntities(FileMatchingTo source, Class<S> targetClass) {

        logger.debug("read related entities  " + targetClass + " and FileMatchingTo " + source.getId());
        return null;
    }

    @Override
    public <S> S readRelatedEntity(FileMatchingTo source, Class<S> targetClass) {

        S result = null;
        if (source != null && targetClass != null) {
            logger.debug("read related entity  " + targetClass + " and FileMatchingTo " + source.getId());
            FileMatchingEntity sourceSectionEntity = this.fileMatchingRepository.findOne(source.getId());

            if (targetClass == FileTo.class) {
                result = this.mapper.map(sourceSectionEntity.getFile(), targetClass);
            }
        }
        return result;
    }
}
