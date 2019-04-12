package com.cg.mobinv.mobileinventory.service.api;

import java.util.List;
import java.util.Map;

import org.apache.olingo.odata2.annotation.processor.core.datasource.DataSource.BinaryData;
import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.edm.EdmException;
import org.apache.olingo.odata2.api.edm.EdmFunctionImport;
import org.apache.olingo.odata2.api.exception.ODataNotImplementedException;

/**
 * @author manjinsi
 *
 */
public interface ODataManagingService {

    List<?> readData(EdmEntitySet entitySet) throws EdmException, ODataNotImplementedException;

    Object readData(EdmEntitySet entitySet, Map<String, Object> keys)
            throws EdmException, ODataNotImplementedException;

    Object readData(EdmFunctionImport function, Map<String, Object> parameters, Map<String, Object> keys)
            throws EdmException;

    Object readRelatedData(EdmEntitySet sourceEntitySet, Object sourceData, EdmEntitySet targetEntitySet,
            Map<String, Object> targetKeys) throws EdmException, ODataNotImplementedException;

    BinaryData readBinaryData(EdmEntitySet entitySet, Object mediaLinkEntryData)
            throws ODataNotImplementedException, EdmException;
    
    Object writeBinaryData(EdmEntitySet entitySet, Object mediaLinkEntryData, BinaryData binaryData)
            throws ODataNotImplementedException, EdmException;
  
    Object newDataObject(EdmEntitySet entitySet) throws EdmException, ODataNotImplementedException;

    void deleteData(EdmEntitySet entitySet, Map<String, Object> keys)
            throws EdmException, ODataNotImplementedException;

    Object createData(EdmEntitySet entitySet, Object data) throws EdmException, ODataNotImplementedException;

    Object updateData(EdmEntitySet entitySet, Object data) throws EdmException, ODataNotImplementedException;

    void deleteRelation(EdmEntitySet sourceEntitySet, Object sourceData, EdmEntitySet targetEntitySet,
            Map<String, Object> targetKeys) throws ODataNotImplementedException;

    Object writeRelation(EdmEntitySet sourceEntitySet, Object sourceData, EdmEntitySet targetEntitySet,
            Map<String, Object> targetKeys) throws ODataNotImplementedException, EdmException;

}
