package com.cg.hkrbudgeting.budgetingmanagement.service.impl.odata;

import com.google.common.base.Preconditions;
import org.apache.olingo.odata2.api.ODataService;
import org.apache.olingo.odata2.api.exception.ODataApplicationException;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.rt.RuntimeDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Service
public class CustomAnnotationService {

    @Inject
    private AnnotatedClassesConfiguration annotatedClassesConfiguration;

    @Inject
    private ODataProcessor odataProcessor;

    private final Logger logger = LoggerFactory.getLogger(CustomAnnotationService.class);

    private ODataService annotationOdataService;

    @PostConstruct
    public void initializeODataService() {

        try {

            AnnotationEdmProviderExtension edmProvider =
                    new AnnotationEdmProviderExtension(this.annotatedClassesConfiguration.getAllAnnotatedClasses());

            this.annotationOdataService =
                    RuntimeDelegate.createODataSingleProcessorService(edmProvider, this.odataProcessor);

            this.logger.info("ODataService initilialized with instance " + this.annotationOdataService);
        } catch (ODataApplicationException ex) {
            throw new RuntimeException("Exception during sample data generation.", ex);
        } catch (ODataException ex) {
            throw new RuntimeException("Exception during data source initialization generation.", ex);
        }
    }

    public ODataService getOdataService() {

        Preconditions.checkNotNull(this.annotationOdataService, "ODataService is not correctly initilialized");
        return this.annotationOdataService;
    }
}
