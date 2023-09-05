package com.api.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.util.Base64;

/**
 *
 * @author edisson
 */
public class ByteArraySerializer implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {

    @Override
    public JsonElement serialize(byte[] src, java.lang.reflect.Type typeOfSrc, JsonSerializationContext context) {
        if (src != null) {
            Base64.Encoder encoder = Base64.getEncoder();
            return new JsonPrimitive(encoder.encodeToString(src));
        } else {
            return null;
        }
    }

    @Override
    public byte[] deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) {
        if (json != null) {
            Base64.Decoder decoder = Base64.getDecoder();
            return decoder.decode(json.getAsString());
        } else {
            return new byte[]{};
        }

    }
}
