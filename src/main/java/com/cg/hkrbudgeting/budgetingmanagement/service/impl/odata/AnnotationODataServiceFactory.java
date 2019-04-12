package com.cg.hkrbudgeting.budgetingmanagement.service.impl.odata;

import org.apache.olingo.odata2.api.ODataService;
import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.processor.ODataContext;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class AnnotationODataServiceFactory extends ODataServiceFactory {

    @Inject
    CustomAnnotationService customAnnotationService;

    @Override
    public ODataService createService(final ODataContext context) throws ODataException {

        return customAnnotationService.getOdataService();
    }
}
