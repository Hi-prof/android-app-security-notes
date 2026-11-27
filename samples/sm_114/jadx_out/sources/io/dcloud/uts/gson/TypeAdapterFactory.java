package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public interface TypeAdapterFactory {
    <T> io.dcloud.uts.gson.TypeAdapter<T> create(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.reflect.TypeToken<T> typeToken);
}
