package com.facebook.common.references;

/* JADX INFO: loaded from: classes.dex */
public class OOMSoftReference<T> {

    @javax.annotation.Nullable
    java.lang.ref.SoftReference<T> softRef1 = null;

    @javax.annotation.Nullable
    java.lang.ref.SoftReference<T> softRef2 = null;

    @javax.annotation.Nullable
    java.lang.ref.SoftReference<T> softRef3 = null;

    public void set(T t) {
        this.softRef1 = new java.lang.ref.SoftReference<>(t);
        this.softRef2 = new java.lang.ref.SoftReference<>(t);
        this.softRef3 = new java.lang.ref.SoftReference<>(t);
    }

    @javax.annotation.Nullable
    public T get() {
        java.lang.ref.SoftReference<T> softReference = this.softRef1;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void clear() {
        java.lang.ref.SoftReference<T> softReference = this.softRef1;
        if (softReference != null) {
            softReference.clear();
            this.softRef1 = null;
        }
        java.lang.ref.SoftReference<T> softReference2 = this.softRef2;
        if (softReference2 != null) {
            softReference2.clear();
            this.softRef2 = null;
        }
        java.lang.ref.SoftReference<T> softReference3 = this.softRef3;
        if (softReference3 != null) {
            softReference3.clear();
            this.softRef3 = null;
        }
    }
}
