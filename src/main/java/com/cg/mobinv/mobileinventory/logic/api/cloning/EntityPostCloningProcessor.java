package com.cg.mobinv.mobileinventory.logic.api.cloning;

public interface EntityPostCloningProcessor<T> {

    T process(T entity);
}
