package com.facebook.common.internal;

/* JADX INFO: loaded from: classes.dex */
public final class Sets {
    private Sets() {
    }

    public static <E> java.util.HashSet<E> newHashSet() {
        return new java.util.HashSet<>();
    }

    public static <E> java.util.HashSet<E> newHashSet(E... eArr) {
        java.util.HashSet<E> hashSetNewHashSetWithCapacity = newHashSetWithCapacity(eArr.length);
        java.util.Collections.addAll(hashSetNewHashSetWithCapacity, eArr);
        return hashSetNewHashSetWithCapacity;
    }

    public static <E> java.util.HashSet<E> newHashSetWithCapacity(int i) {
        return new java.util.HashSet<>(i);
    }

    public static <E> java.util.HashSet<E> newHashSet(java.lang.Iterable<? extends E> iterable) {
        if (iterable instanceof java.util.Collection) {
            return new java.util.HashSet<>((java.util.Collection) iterable);
        }
        return newHashSet(iterable.iterator());
    }

    public static <E> java.util.HashSet<E> newHashSet(java.util.Iterator<? extends E> it) {
        java.util.HashSet<E> hashSetNewHashSet = newHashSet();
        while (it.hasNext()) {
            hashSetNewHashSet.add(it.next());
        }
        return hashSetNewHashSet;
    }

    public static <E> java.util.Set<E> newIdentityHashSet() {
        return newSetFromMap(new java.util.IdentityHashMap());
    }

    public static <E> java.util.Set<E> newSetFromMap(java.util.Map<E, java.lang.Boolean> map) {
        return java.util.Collections.newSetFromMap(map);
    }

    public static <E> java.util.concurrent.CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        return new java.util.concurrent.CopyOnWriteArraySet<>();
    }

    public static <E> java.util.LinkedHashSet<E> newLinkedHashSet() {
        return new java.util.LinkedHashSet<>();
    }
}
