package com.cg.mobinv.reportengine.common.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


public class QueryConstantHelperHanaImpl implements QueryConstantHelper {

    private final static String ID = " SYSUUID ";

    public String getSystemId() {

        return ID;
    }

    @Override
    public String[] getParams() {

        return new String[] {ID};
    }
}
