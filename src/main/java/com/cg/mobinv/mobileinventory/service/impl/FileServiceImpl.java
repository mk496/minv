package com.cg.mobinv.mobileinventory.service.impl;

import org.apache.olingo.odata2.annotation.processor.core.datasource.DataSource.BinaryData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cg.mobinv.mobileinventory.common.api.to.FileTo;
import com.cg.mobinv.mobileinventory.logic.api.FileLogic;
import com.cg.mobinv.mobileinventory.service.api.FileService;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {

    private static final String ID = "Id";

    private final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Inject
    private FileLogic fileLogic;

    @Override
    public FileTo createEntity(FileTo to) {

        return fileLogic.create(to);
    }

    @Override
    public FileTo createEmptyEntity() {

        return fileLogic.createEmpty();
    }

    @Override
    public FileTo updateEntity(FileTo to) {

        return fileLogic.update(to);
    }

    @Override
    public void deleteEntity(Map<String, Object> keys) {

        fileLogic.deleteById((Long) keys.get(ID));
    }

    @Override
    public List<FileTo> readAllEntities() {

        return fileLogic.readAll();
    }

    @Override
    public FileTo readEntity(Map<String, Object> keys) {

        return fileLogic.readById((Long) keys.get(ID));
    }

    @Override
    public FileTo setRelation(FileTo source, Object nestedObject) {

        return fileLogic.setRelation(source, nestedObject);
    }

    @Override
    public Class<?> getToClassType() {

        return FileTo.class;
    }

    public BinaryData readBinaryData(Object mediaEnity) {

        return fileLogic.readBinaryData(mediaEnity);
    }

    public FileTo writeBinaryData(BinaryData mediaData, FileTo mediaEntity) {

        return fileLogic.writeBinaryData(mediaData, mediaEntity);
    }

    @Override
    public <S> List<S> readRelatedEntities(FileTo source, Class<S> targetClass) {

        return this.fileLogic.readRelatedEntities(source, targetClass);
    }

    @Override
    public <S> S readRelatedEntity(FileTo source, Class<S> targetClass) {

        return this.fileLogic.readRelatedEntity(source, targetClass);
    }
}
