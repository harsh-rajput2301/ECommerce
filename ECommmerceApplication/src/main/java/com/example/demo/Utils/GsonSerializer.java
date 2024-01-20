package com.example.demo.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

public class GsonSerializer {

    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    private static GsonSerializer ourInstance = new GsonSerializer();

    public static GsonSerializer getInstance() {
        return ourInstance;
    }

    private GsonSerializer() {
    }

    public String toJson(Object object) {
        if (object == null) {
            return null;
        }
        return gson.toJson(object);
    }

    public String toJson(Object object, Class klass) {
        if (object == null) {
            return null;
        }
        return gson.toJson(object, klass);
    }

    public <T> T fromJson(String json, Class<T> klass) {
        if (json == null) {
            return null;
        }
        return gson.fromJson(json, klass);
    }

    public <T> T fromJson(String json, Type type) {
        if (json == null) {
            return null;
        }
        return gson.fromJson(json, type);
    }

    public boolean isJSONValid(String jsonInString) {
        try {
            gson.fromJson(jsonInString, Object.class);
            return true;
        } catch(com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }
}
