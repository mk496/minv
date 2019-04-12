package com.cg.hkrbudgeting.budgetingmanagement.dataaccess.api.enums;

public interface BusinessEnum {

    String getName();

    Integer getId();

    BusinessEnum findByName(String name);

    BusinessEnum findById(Integer id);

}
