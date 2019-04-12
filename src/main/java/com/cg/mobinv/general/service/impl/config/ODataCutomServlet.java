package com.cg.mobinv.general.service.impl.config;

import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.core.servlet.ODataServlet;
import org.springframework.context.annotation.Configuration;

import com.cg.mobinv.mobileinventory.service.impl.odata.AnnotationODataServiceFactory;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * @author mchudy
 */
@Configuration
public class ODataCutomServlet extends ODataServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private AnnotationODataServiceFactory annotationServiceFactory;

    @Override
    protected ODataServiceFactory getServiceFactory(HttpServletRequest request) {

        return annotationServiceFactory;
    }
}
