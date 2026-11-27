package io.dcloud.uts.gson.internal.reflect;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ReflectionAccessor {
    private static final io.dcloud.uts.gson.internal.reflect.ReflectionAccessor instance;

    public abstract void makeAccessible(java.lang.reflect.AccessibleObject accessibleObject);

    static {
        instance = io.dcloud.uts.gson.internal.JavaVersion.getMajorJavaVersion() < 9 ? new io.dcloud.uts.gson.internal.reflect.PreJava9ReflectionAccessor() : new io.dcloud.uts.gson.internal.reflect.UnsafeReflectionAccessor();
    }

    public static io.dcloud.uts.gson.internal.reflect.ReflectionAccessor getInstance() {
        return instance;
    }
}
