package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonNull extends io.dcloud.uts.gson.JsonElement {
    public static final io.dcloud.uts.gson.JsonNull INSTANCE = new io.dcloud.uts.gson.JsonNull();

    @java.lang.Deprecated
    public JsonNull() {
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public io.dcloud.uts.gson.JsonNull deepCopy() {
        return INSTANCE;
    }

    public int hashCode() {
        return io.dcloud.uts.gson.JsonNull.class.hashCode();
    }

    public boolean equals(java.lang.Object obj) {
        return this == obj || (obj instanceof io.dcloud.uts.gson.JsonNull);
    }
}
