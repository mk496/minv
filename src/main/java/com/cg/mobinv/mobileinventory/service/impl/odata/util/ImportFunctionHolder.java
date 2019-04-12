package com.cg.mobinv.mobileinventory.service.impl.odata.util;

import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImportParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author manjinsi
 */
public class ImportFunctionHolder {

    private Object executor;

    private Method method;

    private EdmFunctionImport functionImport;

    private Map<String, EdmFunctionImportParameter> functionParameters;

    private final Logger logger = LoggerFactory.getLogger(ImportFunctionHolder.class);

    public ImportFunctionHolder(Object executer, Method method, EdmFunctionImport functionImport,
            Map<String, EdmFunctionImportParameter> functionParameters) {

        this.executor = executer;
        this.method = method;
        this.functionImport = functionImport;
        this.functionParameters = functionParameters;

    }

    public Object execute(Map<String, Object> parameters) {

        try {
            Object[] exParameters = mapParameters(parameters);
            return this.method.invoke(this.executor, exParameters);

        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            logger.error("Exception occured during function import call :", e);
            throw new AnnotationRuntimeException("Exception occured: " + e.getCause().getMessage(), e);
        }
    }

    public static ImportFunctionHolder initFunctionHolder(Object functionImport, Method method) {

        ImportFunctionHolder holder = null;

        EdmFunctionImport efi = method.getAnnotation(EdmFunctionImport.class);
        String name = efi.name();
        if (name.isEmpty()) {
            name = method.getName();
        }

        Map<String, EdmFunctionImportParameter> parameters = extractParameters(method.getParameters());

        holder = new ImportFunctionHolder(functionImport, method, efi, parameters);

        return holder;

    }

    private Object[] mapParameters(Map<String, Object> parameters) {

        List<Object> resParameters = new ArrayList<>();
        for (Map.Entry<String, EdmFunctionImportParameter> s : this.functionParameters.entrySet()) {
            Object paraInstance = parameters.get(s.getKey());
            resParameters.add(paraInstance);
        }

        return resParameters.toArray(new Object[resParameters.size()]);
    }

    private static Map<String, EdmFunctionImportParameter> extractParameters(Parameter[] parameters) {

        Map<String, EdmFunctionImportParameter> result = new LinkedHashMap<>();
        for (Parameter parameter : parameters) {
            EdmFunctionImportParameter efip = parameter.getAnnotation(EdmFunctionImportParameter.class);
            result.put(efip.name(), efip);
        }
        return result;
    }
}
