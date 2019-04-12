package com.cg.hkrbudgeting.budgetingmanagement.dataaccess.api.enums;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum PermissionType implements BusinessEnum {

    TITLE("Title", 1),
    CHAPTER("Kapitel", 2),
    SECTION("Einzelplan", 3);

    private String name;

    private Integer id;

    PermissionType(String name, Integer id) {

        this.name = name;
        this.id = id;
    }

    @Override
    public String getName() {

        return name;
    }

    @Override
    public Integer getId() {

        return id;
    }

    @Override
    public BusinessEnum findByName(String name) {

        return Arrays.stream(PermissionType.values()).filter(value -> value.getName().equals(name)).findAny()
                .orElse(null);
    }

    @Override
    public BusinessEnum findById(Integer id) {

        return Arrays.stream(PermissionType.values()).filter(value -> value.getId().equals(id)).findAny().orElse(null);
    }

    public static List<String> getAllValues() {

        return Arrays.stream(PermissionType.values()).map(value -> value.toString()).collect(Collectors.toList());
    }

    @Override
    public String toString() {

        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("id", id);
        return json.toString();
    }
}
