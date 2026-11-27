package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: loaded from: classes.dex */
class Euler {
    private static final java.lang.String DEFAULT_ORDER = "XYZ";
    java.lang.String order;
    boolean isEuler = true;
    double x = 0.0d;
    double y = 0.0d;
    double z = 0.0d;

    Euler() {
    }

    void setValue(double d, double d2, double d3, java.lang.String str) {
        this.x = d;
        this.y = d2;
        this.z = d3;
        if (android.text.TextUtils.isEmpty(str)) {
            str = DEFAULT_ORDER;
        }
        this.order = str;
    }
}
