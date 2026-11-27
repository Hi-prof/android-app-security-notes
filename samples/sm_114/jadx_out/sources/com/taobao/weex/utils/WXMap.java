package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class WXMap extends java.util.HashMap<java.lang.String, java.lang.String> implements java.io.Serializable {
    public java.lang.String put(java.lang.String str, byte[] bArr) {
        return (java.lang.String) super.put(str, new java.lang.String(bArr));
    }
}
