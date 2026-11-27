package com.facebook.common.internal;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableList<E> extends java.util.ArrayList<E> {
    private ImmutableList(int i) {
        super(i);
    }

    private ImmutableList(java.util.List<E> list) {
        super(list);
    }

    public static <E> com.facebook.common.internal.ImmutableList<E> copyOf(java.util.List<E> list) {
        return new com.facebook.common.internal.ImmutableList<>(list);
    }

    public static <E> com.facebook.common.internal.ImmutableList<E> of(E... eArr) {
        com.facebook.common.internal.ImmutableList<E> immutableList = new com.facebook.common.internal.ImmutableList<>(eArr.length);
        java.util.Collections.addAll(immutableList, eArr);
        return immutableList;
    }
}
