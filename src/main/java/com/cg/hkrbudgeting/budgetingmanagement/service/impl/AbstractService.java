package com.cg.hkrbudgeting.budgetingmanagement.service.impl;

import com.cg.hkrbudgeting.budgetingmanagement.service.api.ODataOperationService;

public abstract class AbstractService<T> implements ODataOperationService<T> {

    public T writeEntity(T to) {

        return null;
    }
}
