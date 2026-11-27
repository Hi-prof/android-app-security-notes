package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public class WXJSObject {
    public static final int JSON = 3;
    public static final int NUMBER = 1;
    public static final int String = 2;
    public static final int WSON = 4;
    public java.lang.Object data;
    public java.lang.String key;
    public int type;

    public WXJSObject(int i, java.lang.Object obj) {
        this.type = i;
        this.data = obj;
    }

    public WXJSObject(int i, java.lang.Object obj, java.lang.String str) {
        this.type = i;
        this.data = obj;
        this.key = str;
    }

    public WXJSObject(java.lang.Object obj) {
        if (obj == null) {
            this.type = 2;
            this.data = "";
            return;
        }
        this.data = obj;
        if (obj instanceof java.lang.Integer) {
            this.type = 1;
            this.data = new java.lang.Double(((java.lang.Integer) obj).intValue());
            return;
        }
        if (obj instanceof java.lang.Double) {
            this.type = 1;
            return;
        }
        if (obj instanceof java.lang.Float) {
            this.type = 1;
            this.data = new java.lang.Double(((java.lang.Float) obj).intValue());
        } else if (obj instanceof java.lang.String) {
            this.type = 2;
        } else if (obj instanceof java.lang.Object) {
            this.type = 3;
            this.data = com.taobao.weex.utils.WXJsonUtils.fromObjectToJSONString(obj, true);
        }
    }
}
