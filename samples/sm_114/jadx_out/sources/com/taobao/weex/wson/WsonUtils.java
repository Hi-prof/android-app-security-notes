package com.taobao.weex.wson;

/* JADX INFO: loaded from: classes.dex */
public class WsonUtils {
    public static final java.lang.Object parseWson(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return com.taobao.weex.wson.Wson.parse(bArr);
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("weex wson parse error ", e);
            return null;
        }
    }

    public static final byte[] toWson(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return com.taobao.weex.wson.Wson.toWson(obj);
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("weex wson to wson error ", e);
            return null;
        }
    }
}
