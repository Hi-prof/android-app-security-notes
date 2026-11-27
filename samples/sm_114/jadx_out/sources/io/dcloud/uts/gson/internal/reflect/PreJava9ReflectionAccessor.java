package io.dcloud.uts.gson.internal.reflect;

/* JADX INFO: loaded from: classes2.dex */
final class PreJava9ReflectionAccessor extends io.dcloud.uts.gson.internal.reflect.ReflectionAccessor {
    PreJava9ReflectionAccessor() {
    }

    @Override // io.dcloud.uts.gson.internal.reflect.ReflectionAccessor
    public void makeAccessible(java.lang.reflect.AccessibleObject accessibleObject) {
        accessibleObject.setAccessible(true);
    }
}
