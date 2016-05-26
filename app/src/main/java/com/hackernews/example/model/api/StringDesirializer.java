package com.hackernews.example.model.api;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by n.goyal on 22/05/16.
 */
public class StringDesirializer implements JsonDeserializer<String> {
    @Override
    public String deserialize(JsonElement json, Type typeOfT,
                              JsonDeserializationContext context) throws JsonParseException {
        return json.toString();
    }
}
