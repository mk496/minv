package com.cg.mobinv.mobileinventory.logic.api.cloning.strategy;

import org.springframework.stereotype.Component;

@Component
public interface EntityCloningStrategy<T> {

    T doCloning(T entityToClone, Object parentEntity);
}
