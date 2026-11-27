package com.facebook.common.internal;

/* JADX INFO: loaded from: classes.dex */
public final class Throwables {
    private Throwables() {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    public static <X extends java.lang.Throwable> void propagateIfInstanceOf(@javax.annotation.Nullable java.lang.Throwable th, java.lang.Class<X> cls) throws java.lang.Throwable {
        if (th != null && cls.isInstance(th)) {
            throw cls.cast(th);
        }
    }

    public static void propagateIfPossible(@javax.annotation.Nullable java.lang.Throwable th) throws java.lang.Throwable {
        propagateIfInstanceOf(th, java.lang.Error.class);
        propagateIfInstanceOf(th, java.lang.RuntimeException.class);
    }

    public static <X extends java.lang.Throwable> void propagateIfPossible(@javax.annotation.Nullable java.lang.Throwable th, java.lang.Class<X> cls) throws java.lang.Throwable {
        propagateIfInstanceOf(th, cls);
        propagateIfPossible(th);
    }

    public static <X1 extends java.lang.Throwable, X2 extends java.lang.Throwable> void propagateIfPossible(@javax.annotation.Nullable java.lang.Throwable th, java.lang.Class<X1> cls, java.lang.Class<X2> cls2) throws java.lang.Throwable {
        com.facebook.common.internal.Preconditions.checkNotNull(cls2);
        propagateIfInstanceOf(th, cls);
        propagateIfPossible(th, cls2);
    }

    public static java.lang.RuntimeException propagate(java.lang.Throwable th) throws java.lang.Throwable {
        propagateIfPossible((java.lang.Throwable) com.facebook.common.internal.Preconditions.checkNotNull(th));
        throw new java.lang.RuntimeException(th);
    }

    public static java.lang.Throwable getRootCause(java.lang.Throwable th) {
        while (true) {
            java.lang.Throwable cause = th.getCause();
            if (cause == null) {
                return th;
            }
            th = cause;
        }
    }

    public static java.util.List<java.lang.Throwable> getCausalChain(java.lang.Throwable th) {
        com.facebook.common.internal.Preconditions.checkNotNull(th);
        java.util.ArrayList arrayList = new java.util.ArrayList(4);
        while (th != null) {
            arrayList.add(th);
            th = th.getCause();
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public static java.lang.String getStackTraceAsString(java.lang.Throwable th) {
        return android.util.Log.getStackTraceString(th);
    }
}
