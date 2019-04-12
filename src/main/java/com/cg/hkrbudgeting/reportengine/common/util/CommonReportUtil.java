package com.cg.hkrbudgeting.reportengine.common.util;

public class CommonReportUtil {

    public static long getNotEmptyLongValue(Long value) {

        return value != null ? value : 0;
    }

    public static int getNotEmptIntegerValue(Integer value) {

        return value != null ? value : 0;
    }

    private CommonReportUtil() {

    }
}
