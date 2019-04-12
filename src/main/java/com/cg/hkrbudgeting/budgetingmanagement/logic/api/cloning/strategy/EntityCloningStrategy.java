package com.cg.hkrbudgeting.budgetingmanagement.logic.api.cloning.strategy;

import org.springframework.stereotype.Component;

@Component
public interface EntityCloningStrategy<T> {

    T doCloning(T entityToClone, Object parentEntity);
}
