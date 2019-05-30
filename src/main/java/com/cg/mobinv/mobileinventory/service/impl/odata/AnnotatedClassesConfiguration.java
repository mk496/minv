package com.cg.mobinv.mobileinventory.service.impl.odata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.cg.mobinv.mobileinventory.service.impl.odata.util.AnnotationHelper;
import com.cg.mobinv.mobileinventory.service.impl.odata.util.ClassHelper;
import com.cg.mobinv.mobileinventory.service.impl.odata.util.ImportFunctionHolder;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * dirty stuff with reflection here
 */
@Service
public class AnnotatedClassesConfiguration {

    private final Logger logger = LoggerFactory.getLogger(AnnotatedClassesConfiguration.class);

    public final String MODEL_PACKAGE = "com.cg.mobinv.mobileinventory.common.api.to";

    public final String REPORT_MODEL_PACKAGE = "com.cg.mobinv.mobileinventory.common.api.to";

    public final String FUNCTION_IMPORT_PACKAGE = "com.cg.mobinv.mobileinventory.service.api";

    public final String REPORTS_FUNCTION_IMPORT_PACKAGE = "com.cg.mobinv.mobileinventory.service.api";
    
    public final String ANALYTICS_FUNCTION_IMPORT_PACKAGE = "com.cg.hkrbudgeting.analytics.service.api";

    final AnnotationHelper annotationHelper = new AnnotationHelper();

    private List<Class<?>> allClassesToLoad;

    private List<Class<?>> classesAnnotatedEntity;

    private List<Class<?>> classesAnnotatedFunctionImport;

    private Map<String, ImportFunctionHolder> functionImportHolders;

    @Inject
    private ApplicationContext applicationContext;

    // do heavy reflection loading only once when springboot is starting
    @PostConstruct
    private void extractAllClasses() {

        this.allClassesToLoad = new ArrayList<Class<?>>();
        this.classesAnnotatedEntity = getAnnotatedClassesFromPackage(MODEL_PACKAGE);
        this.classesAnnotatedEntity.addAll(getAnnotatedClassesFromPackage(REPORT_MODEL_PACKAGE));

        this.logger.info("All loaded entities :" + this.classesAnnotatedEntity);
        this.classesAnnotatedFunctionImport = getAnnotatedClassesFromPackage(FUNCTION_IMPORT_PACKAGE);
        this.classesAnnotatedFunctionImport.addAll(getAnnotatedClassesFromPackage(REPORTS_FUNCTION_IMPORT_PACKAGE));
        this.classesAnnotatedFunctionImport.addAll(getAnnotatedClassesFromPackage(ANALYTICS_FUNCTION_IMPORT_PACKAGE));

        this.logger.info("All loaded FunctionImports :<" + this.classesAnnotatedFunctionImport);
        this.allClassesToLoad.addAll(this.classesAnnotatedEntity);
        this.allClassesToLoad.addAll(this.classesAnnotatedFunctionImport);

        initfunctionImportHolders();
    }

    private void initfunctionImportHolders() {

        this.functionImportHolders = new LinkedHashMap<String, ImportFunctionHolder>();

        for (Class<?> annotatedClass : this.classesAnnotatedFunctionImport) {
            List<Method> methods = this.annotationHelper.getAnnotatedMethods(annotatedClass,
                    org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.class, false);
            Object functionImport = this.applicationContext.getBean(annotatedClass);
            for (Method method : methods) {
                ImportFunctionHolder funcHolder = ImportFunctionHolder.initFunctionHolder(functionImport, method);
                org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport efi =
                        method.getAnnotation(org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.class);
                String name = efi.name();
                this.functionImportHolders.put(name, funcHolder);
            }
        }
    }

    public List<Class<?>> getAllAnnotatedClasses() {

        return this.allClassesToLoad;
    }

    public List<Class<?>> getAnnotatedEntites() {

        return this.classesAnnotatedEntity;
    }

    public List<Class<?>> getAnnotatedFunctionImport() {

        return this.classesAnnotatedFunctionImport;
    }

    public Map<String, ImportFunctionHolder> getFunctionImportHolders() {

        return this.functionImportHolders;
    }

    private List<Class<?>> getAnnotatedClassesFromPackage(String p) {

        List<Class<?>> listOfAnnotatedClasses = new ArrayList<Class<?>>();

        for (Class<?> type : ClassHelper.loadClasses(p)) {
            if (this.annotationHelper.isEdmAnnotated(type)) {
                listOfAnnotatedClasses.add(type);
            }
        }

        return listOfAnnotatedClasses;

    }
}
