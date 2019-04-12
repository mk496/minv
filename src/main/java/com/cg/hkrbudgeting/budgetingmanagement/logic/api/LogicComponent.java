package com.cg.hkrbudgeting.budgetingmanagement.logic.api;

import java.util.List;

/**
 * @author Szymon Kuc
 */
public interface LogicComponent<T> {

    List<T> readAll();

    T readById(Long id);

    T create(T to);

    T createEmpty();

    T update(T to);

    T setRelation(T source, Object targetObject);

    <S> List<S> readRelatedEntities(T source, Class<S> targetClass);

    <S> S readRelatedEntity(T source, Class<S> targetClass);

    void deleteById(Long id);

}
