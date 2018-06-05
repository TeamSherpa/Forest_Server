package com.sherpa.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.sql.Struct;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static Map<String, Object> success(Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put("result", 200);
        map.put("meta", obj);
        return map;
    }

    public static Map<String, Object> exceptionError(int code, String message) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result", code);
        jsonObject.addProperty("meta", message);
        Gson gson = gsonBuilder();
        Map<String, Object> map;
        map = (Map<String, Object>) gson.fromJson(jsonObject, new TypeToken<Map <String, Object>>(){}.getType());

        return map;
    }

    private static Gson gsonBuilder() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(new TypeToken<Map <String, Object>>(){}.getType(), new MapDeserializer());
        Gson gson = gsonBuilder.create();
        return gson;
    }
}