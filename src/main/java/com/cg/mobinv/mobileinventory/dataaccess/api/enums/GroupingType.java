package com.cg.mobinv.mobileinventory.dataaccess.api.enums;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum GroupingType implements BusinessEnum {

    MAIN_GROUP("Hauptgruppe", 1),
    SUB_GROUP("Obergruppe", 2),
    GROUP("Gruppe", 3);

    //to import SQL must be index of enum, which start from 0
    private String name;

    private Integer id;

    GroupingType(String name, Integer id) {

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

        return Arrays.stream(GroupingType.values()).filter(value -> value.getName().equals(name)).findAny()
                .orElse(null);
    }

    @Override
    public BusinessEnum findById(Integer id) {

        return Arrays.stream(GroupingType.values()).filter(value -> value.getId().equals(id)).findAny().orElse(null);
    }

    public static List<String> getAllValues() {

        return Arrays.stream(GroupingType.values()).map(value -> value.toString()).collect(Collectors.toList());
    }

    @Override
    public String toString() {

        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("id", id);

        return json.toString();
    }
}
