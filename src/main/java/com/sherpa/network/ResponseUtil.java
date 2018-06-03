package com.sherpa.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.sql.Struct;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static Map<String, Object> exceptionError(int code, String message) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("code", code);
        jsonObject.addProperty("meta", message);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(new TypeToken<Map <String, Object>>(){}.getType(), new MapDeserializer());
        Gson gson = gsonBuilder.create();

        Map<String, Object> map;
        map = (Map<String, Object>) gson.fromJson(jsonObject, new TypeToken<Map <String, Object>>(){}.getType());
        return map;
    }
}