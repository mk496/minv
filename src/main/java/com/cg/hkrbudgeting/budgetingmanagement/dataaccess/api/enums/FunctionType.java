package com.cg.hkrbudgeting.budgetingmanagement.dataaccess.api.enums;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum FunctionType implements BusinessEnum {

    MAIN_FUNCTION("Hauptfunktion", 1),
    SUB_FUNCTION("Oberfunktion", 2),
    FUNCTION("Funktion", 3);

    //to import SQL must be index of enum, which start from 0
    private String name;

    private Integer id;

    FunctionType(String name, Integer id) {

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
    public FunctionType findByName(String name) {

        return Arrays.stream(FunctionType.values()).filter(value -> value.getName().equals(name)).findAny()
                .orElse(null);
    }

    @Override
    public FunctionType findById(Integer id) {

        return Arrays.stream(FunctionType.values()).filter(value -> value.getId().equals(id)).findAny().orElse(null);
    }

    public static List<String> getAllValues() {

        return Arrays.stream(FunctionType.values()).map(value -> value.toString()).collect(Collectors.toList());
    }

    @Override
    public String toString() {

        JSONObject json = new JSONObject();
        json.put("name",name);
        json.put("id", id);

        return json.toString();
    }
}
