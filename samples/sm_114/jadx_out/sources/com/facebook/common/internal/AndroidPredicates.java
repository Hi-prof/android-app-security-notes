package com.facebook.common.internal;

/* JADX INFO: loaded from: classes.dex */
public class AndroidPredicates {
    private AndroidPredicates() {
    }

    public static <T> com.facebook.common.internal.Predicate<T> True() {
        return new com.facebook.common.internal.Predicate<T>() { // from class: com.facebook.common.internal.AndroidPredicates.1
            @Override // com.facebook.common.internal.Predicate
            public boolean apply(T t) {
                return true;
            }
        };
    }

    public static <T> com.facebook.common.internal.Predicate<T> False() {
        return new com.facebook.common.internal.Predicate<T>() { // from class: com.facebook.common.internal.AndroidPredicates.2
            @Override // com.facebook.common.internal.Predicate
            public boolean apply(T t) {
                return false;
            }
        };
    }
}
