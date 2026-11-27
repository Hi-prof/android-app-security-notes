package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public interface JsonDeserializationContext {
    <T> T deserialize(io.dcloud.uts.gson.JsonElement jsonElement, java.lang.reflect.Type type) throws io.dcloud.uts.gson.JsonParseException;
}
