package com.cg.mobinv.mobileinventory.service.impl;

import com.cg.mobinv.mobileinventory.service.api.ODataOperationService;

public abstract class AbstractService<T> implements ODataOperationService<T> {

    public T writeEntity(T to) {

        return null;
    }
}
