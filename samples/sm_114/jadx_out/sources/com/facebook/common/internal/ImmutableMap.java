package com.facebook.common.internal;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableMap<K, V> extends java.util.HashMap<K, V> {
    private ImmutableMap(java.util.Map<? extends K, ? extends V> map) {
        super(map);
    }

    public static <K, V> java.util.Map<K, V> of() {
        return java.util.Collections.unmodifiableMap(new java.util.HashMap());
    }

    public static <K, V> java.util.Map<K, V> of(K k, V v) {
        java.util.HashMap map = new java.util.HashMap(1);
        map.put(k, v);
        return java.util.Collections.unmodifiableMap(map);
    }

    public static <K, V> java.util.Map<K, V> of(K k, V v, K k2, V v2) {
        java.util.HashMap map = new java.util.HashMap(2);
        map.put(k, v);
        map.put(k2, v2);
        return java.util.Collections.unmodifiableMap(map);
    }

    public static <K, V> java.util.Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        java.util.HashMap map = new java.util.HashMap(3);
        map.put(k, v);
        map.put(k2, v2);
        map.put(k3, v3);
        return java.util.Collections.unmodifiableMap(map);
    }

    public static <K, V> java.util.Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        java.util.HashMap map = new java.util.HashMap(4);
        map.put(k, v);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return java.util.Collections.unmodifiableMap(map);
    }

    public static <K, V> java.util.Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        java.util.HashMap map = new java.util.HashMap(5);
        map.put(k, v);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return java.util.Collections.unmodifiableMap(map);
    }

    public static <K, V> java.util.Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        java.util.HashMap map = new java.util.HashMap(6);
        map.put(k, v);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        return java.util.Collections.unmodifiableMap(map);
    }

    public static <K, V> com.facebook.common.internal.ImmutableMap<K, V> copyOf(java.util.Map<? extends K, ? extends V> map) {
        return new com.facebook.common.internal.ImmutableMap<>(map);
    }
}
