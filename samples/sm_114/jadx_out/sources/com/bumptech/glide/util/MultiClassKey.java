package com.bumptech.glide.util;

/* JADX INFO: loaded from: classes.dex */
public class MultiClassKey {
    private java.lang.Class<?> first;
    private java.lang.Class<?> second;
    private java.lang.Class<?> third;

    public MultiClassKey() {
    }

    public MultiClassKey(java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        set(cls, cls2);
    }

    public MultiClassKey(java.lang.Class<?> cls, java.lang.Class<?> cls2, java.lang.Class<?> cls3) {
        set(cls, cls2, cls3);
    }

    public void set(java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        set(cls, cls2, null);
    }

    public void set(java.lang.Class<?> cls, java.lang.Class<?> cls2, java.lang.Class<?> cls3) {
        this.first = cls;
        this.second = cls2;
        this.third = cls3;
    }

    public java.lang.String toString() {
        return "MultiClassKey{first=" + this.first + ", second=" + this.second + com.taobao.weex.el.parse.Operators.BLOCK_END;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.bumptech.glide.util.MultiClassKey multiClassKey = (com.bumptech.glide.util.MultiClassKey) obj;
        return this.first.equals(multiClassKey.first) && this.second.equals(multiClassKey.second) && com.bumptech.glide.util.Util.bothNullOrEqual(this.third, multiClassKey.third);
    }

    public int hashCode() {
        int iHashCode = ((this.first.hashCode() * 31) + this.second.hashCode()) * 31;
        java.lang.Class<?> cls = this.third;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }
}
