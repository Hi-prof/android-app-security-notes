package com.facebook.common.internal;

/* JADX INFO: loaded from: classes.dex */
public class Suppliers {
    public static final com.facebook.common.internal.Supplier<java.lang.Boolean> BOOLEAN_TRUE = new com.facebook.common.internal.Supplier<java.lang.Boolean>() { // from class: com.facebook.common.internal.Suppliers.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.common.internal.Supplier
        public java.lang.Boolean get() {
            return true;
        }
    };
    public static final com.facebook.common.internal.Supplier<java.lang.Boolean> BOOLEAN_FALSE = new com.facebook.common.internal.Supplier<java.lang.Boolean>() { // from class: com.facebook.common.internal.Suppliers.3
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.common.internal.Supplier
        public java.lang.Boolean get() {
            return false;
        }
    };
    public static final com.facebook.common.internal.Supplier<java.lang.String> STRING_EMPTY = new com.facebook.common.internal.Supplier<java.lang.String>() { // from class: com.facebook.common.internal.Suppliers.4
        @Override // com.facebook.common.internal.Supplier
        public java.lang.String get() {
            return "";
        }
    };

    public static <T> com.facebook.common.internal.Supplier<T> of(final T t) {
        return new com.facebook.common.internal.Supplier<T>() { // from class: com.facebook.common.internal.Suppliers.1
            @Override // com.facebook.common.internal.Supplier
            public T get() {
                return (T) t;
            }
        };
    }
}
