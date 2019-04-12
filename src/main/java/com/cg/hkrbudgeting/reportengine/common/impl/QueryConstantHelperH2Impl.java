package com.cg.hkrbudgeting.reportengine.common.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


public class QueryConstantHelperH2Impl implements QueryConstantHelper {

    public final static String ID = " UUID() ";

    @Override
    public String getSystemId() {

        return ID;
    }

    @Override
    public String[] getParams() {

        return new String[] {ID};
    }
}
