package com.hmi.router;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class ObjectType {

    private static final Logger LOGGER = LogManager.getLogger();

    private static List<ObjectType> values = new ArrayList<>();

    static {
        try {
            JSONObject objectTypes = new JSONObject(Files.readString(Path.of("object_types.json")));
            int i = 0;
            for (java.lang.Object object : objectTypes.getJSONArray("objectTypes")) {
                JSONObject jsonObjectType = (JSONObject) object;
                ObjectType objectType = new ObjectType(jsonObjectType.getString("name"),
                        jsonObjectType.getBoolean("creatable"), i);
                i++;
                values.add(objectType);
                LOGGER.debug("Loaded object type {}", objectType.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String name;
    private boolean creatable;
    private int ordinal;

    public ObjectType(String name, boolean creatable, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
        this.creatable = creatable;
    }

    public static List<ObjectType> values() {
        return values;
    }

    public boolean isCreatable() {
        return creatable;
    }

    public static ObjectType get(String name) {
        for (ObjectType value : values) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }

    public static ObjectType get(Integer ordinal) {
        for (ObjectType value : values) {
            if (value.getOrdinal().equals(ordinal)) {
                return value;
            }
        }
        return null;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}
