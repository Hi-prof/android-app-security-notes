package com.facebook.infer.annotation;

/* JADX INFO: loaded from: classes.dex */
public class Assertions {
    public static void assumeCondition(boolean z) {
    }

    public static void assumeCondition(boolean z, java.lang.String str) {
    }

    public static <T> T assumeNotNull(@javax.annotation.Nullable T t) {
        return t;
    }

    public static <T> T assumeNotNull(@javax.annotation.Nullable T t, java.lang.String str) {
        return t;
    }

    public static <T> T nullsafeFIXME(@javax.annotation.Nullable T t, java.lang.String str) {
        return t;
    }

    public static <T> T assertNotNull(@javax.annotation.Nullable T t, java.lang.String str) {
        if (t != null) {
            return t;
        }
        throw new java.lang.AssertionError(str);
    }

    public static <T> T assertNotNull(@javax.annotation.Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new java.lang.AssertionError();
    }

    public static <T> T assertGet(int i, java.util.List<T> list) {
        assertCondition(i >= 0 && i < list.size(), "Index not in bound");
        return (T) assertNotNull(list.get(i), "Null value");
    }

    public static <K, V> V assertGet(K k, java.util.Map<K, V> map) {
        assertCondition(map.containsKey(k), "Key not found");
        return (V) assertNotNull(map.get(k), "Null value");
    }

    public static void assertCondition(boolean z) {
        if (!z) {
            throw new java.lang.AssertionError();
        }
    }

    public static void assertCondition(boolean z, java.lang.String str) {
        if (!z) {
            throw new java.lang.AssertionError(str);
        }
    }

    public static java.lang.AssertionError assertUnreachable() {
        throw new java.lang.AssertionError();
    }

    public static java.lang.AssertionError assertUnreachable(java.lang.String str) {
        throw new java.lang.AssertionError(str);
    }

    public static java.lang.AssertionError assertUnreachable(java.lang.Exception exc) {
        throw new java.lang.AssertionError(exc);
    }
}
