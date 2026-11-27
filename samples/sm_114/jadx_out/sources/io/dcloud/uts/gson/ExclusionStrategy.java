package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public interface ExclusionStrategy {
    boolean shouldSkipClass(java.lang.Class<?> cls);

    boolean shouldSkipField(io.dcloud.uts.gson.FieldAttributes fieldAttributes);
}
