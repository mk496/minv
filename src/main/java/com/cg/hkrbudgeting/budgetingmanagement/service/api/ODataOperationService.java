package com.cg.hkrbudgeting.budgetingmanagement.service.api;

import java.util.List;
import java.util.Map;



/**Budget
 * @author manjinsi
 */
public interface ODataOperationService<T> {

    T createEntity(T to);

    T createEmptyEntity();

    T updateEntity(T to);

    void deleteEntity(Map<String, Object> keys);

    List<T> readAllEntities();

    T readEntity(Map<String, Object> keys);

    T setRelation(T source, Object nestedObject);

    <S> List<S> readRelatedEntities(T source, Class<S> targetClass);

    <S> S readRelatedEntity(T source, Class<S> targetClass);

    Class<?> getToClassType();

}
