package com.cg.hkrbudgeting.budgetingmanagement.logic.api.cloning;

public interface EntityPostCloningProcessor<T> {

    T process(T entity);
}
