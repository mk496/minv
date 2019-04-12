package com.cg.hkrbudgeting.budgetingmanagement.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.olingo.odata2.annotation.processor.core.datasource.DataSource.BinaryData;
import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.edm.EdmException;
import org.apache.olingo.odata2.api.edm.EdmFunctionImport;
import org.apache.olingo.odata2.api.edm.EdmMultiplicity;
import org.apache.olingo.odata2.api.exception.ODataNotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cg.hkrbudgeting.budgetingmanagement.common.api.to.FileTo;
import com.cg.hkrbudgeting.budgetingmanagement.service.api.FileService;
import com.cg.hkrbudgeting.budgetingmanagement.service.api.ODataManagingService;
import com.cg.hkrbudgeting.budgetingmanagement.service.api.ODataOperationService;
import com.cg.hkrbudgeting.budgetingmanagement.service.impl.odata.AnnotatedClassesConfiguration;
import com.cg.hkrbudgeting.budgetingmanagement.service.impl.odata.util.AnnotationHelper;
import com.cg.hkrbudgeting.budgetingmanagement.service.impl.odata.util.ImportFunctionHolder;

/**
 * @author manjinsi
 */
@Service
public class ODataManagingServiceImpl implements ODataManagingService {

    @Inject
    private AnnotationHelper annotationHelper;

    @Inject
    private List<ODataOperationService> oDataOperationServices;

    @Inject
    private AnnotatedClassesConfiguration annotatedClasses;

    private Map<String, ODataOperationService<?>> serviceLookup;

    private ODataOperationService<?> targetService;

    private final Logger logger = LoggerFactory.getLogger(ODataManagingServiceImpl.class);

    @PostConstruct
    private void mapServiceLookups() {

        this.serviceLookup = this.oDataOperationServices.stream()
                .collect(Collectors.toMap(service -> getEntityName(service), service -> service));
    }

    private String getEntityName(ODataOperationService service) {

        return this.annotationHelper.extractEntitySetName(service.getToClassType());
    }

    private ODataOperationService getService(String entityName) throws ODataNotImplementedException {

        if (!this.serviceLookup.containsKey(entityName)) {
            throw new ODataNotImplementedException(ODataNotImplementedException.COMMON);
        }
        return this.serviceLookup.get(entityName);
    }

    @Override
    public List<?> readData(EdmEntitySet entitySet) throws EdmException, ODataNotImplementedException {

        return getService(entitySet.getName()).readAllEntities();
    }

    @Override
    public Object readData(EdmEntitySet entitySet, Map<String, Object> keys)
            throws EdmException, ODataNotImplementedException {

        return getService(entitySet.getName()).readEntity(keys);
    }

    @Override
    public Object readData(EdmFunctionImport function, Map<String, Object> parameters, Map<String, Object> keys)
            throws EdmException {

        String functionImportName = function.getName();

        ImportFunctionHolder funcHolder = this.annotatedClasses.getFunctionImportHolders().get(functionImportName);
        return funcHolder.execute(parameters);

    }

    @Override
    public Object readRelatedData(EdmEntitySet sourceEntitySet, Object sourceData, EdmEntitySet targetEntitySet,
            Map<String, Object> targetKeys) throws EdmException, ODataNotImplementedException {

        Object result;
        ODataOperationService<Object> sourceService = getService(sourceEntitySet.getName());
        ODataOperationService<Object> targetService = getService(targetEntitySet.getName());

        // If keys not empty, then read it directly from the keys
        if (!targetKeys.isEmpty()) {
            result = targetService.readEntity(targetKeys);
        } else {
            EdmMultiplicity targetMultiplicity = annotationHelper
                    .getCommonNavigationInfo(sourceService.getToClassType(), targetService.getToClassType())
                    .getToMultiplicity();

            if (targetMultiplicity == EdmMultiplicity.MANY) {
                result = sourceService.readRelatedEntities(sourceData, targetService.getToClassType());
            } else {
                result = sourceService.readRelatedEntity(sourceData, targetService.getToClassType());
            }
        }

        return result;
    }

    @Override
    public Object newDataObject(EdmEntitySet entitySet) throws EdmException, ODataNotImplementedException {

        return getService(entitySet.getName()).createEmptyEntity();
    }

    @Override
    public void deleteData(EdmEntitySet entitySet, Map<String, Object> keys)
            throws EdmException, ODataNotImplementedException {

        getService(entitySet.getName()).deleteEntity(keys);

    }

    @Override
    public Object createData(EdmEntitySet entitySet, Object data) throws EdmException, ODataNotImplementedException {

        return getService(entitySet.getName()).createEntity(data);
    }

    @Override
    public Object updateData(EdmEntitySet entitySet, Object data) throws EdmException, ODataNotImplementedException {

        return getService(entitySet.getName()).updateEntity(data);
    }

    @Override
    public void deleteRelation(EdmEntitySet sourceEntitySet, Object sourceData, EdmEntitySet targetEntitySet,
            Map<String, Object> targetKeys) throws ODataNotImplementedException {

        throw new ODataNotImplementedException(ODataNotImplementedException.COMMON);

    }

    @Override
    public Object writeRelation(EdmEntitySet sourceEntitySet, Object sourceData, EdmEntitySet targetEntitySet,
            Map<String, Object> targetKeys) throws ODataNotImplementedException, EdmException {

        Object result = null;
        ODataOperationService<?> targetService = getService(targetEntitySet.getName());

        Object targetData = null;
        if (!targetKeys.isEmpty()) {
            targetData = targetService.readEntity(targetKeys);
        }

        if (targetData != null) {
            result = getService(sourceEntitySet.getName()).setRelation(sourceData, targetData);
        }
        return result;
    }

    @Override
    public Object writeBinaryData(EdmEntitySet entitySet, Object mediaLinkEntryData, BinaryData binaryData)
            throws ODataNotImplementedException, EdmException {

        if (mediaLinkEntryData instanceof FileTo) {
            FileServiceImpl mediaService = (FileServiceImpl) getService(entitySet.getName());
            return mediaService.writeBinaryData(binaryData, (FileTo) mediaLinkEntryData);
        }

        logger.warn("Write binary data is not supported for type: " + entitySet.getName());
        throw new ODataNotImplementedException(ODataNotImplementedException.COMMON);
    }

    @Override
    public BinaryData readBinaryData(EdmEntitySet entitySet, Object mediaLinkEntryData)
            throws ODataNotImplementedException, EdmException {

        if (mediaLinkEntryData instanceof FileTo) {
            FileService mediaService = (FileService) getService(entitySet.getName());
            return mediaService.readBinaryData(mediaLinkEntryData);
        }

        logger.warn("Read binary data is not supported for type: " + entitySet.getName());
        throw new ODataNotImplementedException(ODataNotImplementedException.COMMON);
    }

}
