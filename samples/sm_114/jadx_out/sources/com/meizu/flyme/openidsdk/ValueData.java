package com.meizu.flyme.openidsdk;

/* JADX INFO: loaded from: classes.dex */
public class ValueData {
    public java.lang.String a;
    public int b;
    public long c = java.lang.System.currentTimeMillis() + 86400000;

    public ValueData(java.lang.String str, int i) {
        this.a = str;
        this.b = i;
    }

    public native java.lang.String toString();
}
