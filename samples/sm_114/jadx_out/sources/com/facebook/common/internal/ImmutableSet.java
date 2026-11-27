package com.facebook.common.internal;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableSet<E> extends java.util.HashSet<E> {
    private ImmutableSet(java.util.Set<E> set) {
        super(set);
    }

    public static <E> com.facebook.common.internal.ImmutableSet<E> copyOf(java.util.Set<E> set) {
        return new com.facebook.common.internal.ImmutableSet<>(set);
    }

    public static <E> com.facebook.common.internal.ImmutableSet<E> of(E... eArr) {
        java.util.HashSet hashSet = new java.util.HashSet(eArr.length);
        java.util.Collections.addAll(hashSet, eArr);
        return new com.facebook.common.internal.ImmutableSet<>(hashSet);
    }
}
