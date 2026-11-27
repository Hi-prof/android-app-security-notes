package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public interface JsonSerializer<T> {
    io.dcloud.uts.gson.JsonElement serialize(T t, java.lang.reflect.Type type, io.dcloud.uts.gson.JsonSerializationContext jsonSerializationContext);
}
