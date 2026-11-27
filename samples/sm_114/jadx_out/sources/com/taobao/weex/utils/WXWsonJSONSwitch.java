package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class WXWsonJSONSwitch {
    private static final java.lang.String TAG = "WXSwitch";
    public static boolean USE_WSON = true;
    public static final java.lang.String WSON_OFF = "wson_off";

    public static final byte[] convertJSONToWsonIfUseWson(byte[] bArr) {
        if (!USE_WSON) {
            return bArr;
        }
        if (bArr == null) {
            return null;
        }
        java.lang.String str = new java.lang.String(bArr);
        if (str.startsWith(com.taobao.weex.el.parse.Operators.ARRAY_START_STR)) {
            return com.taobao.weex.wson.WsonUtils.toWson(com.alibaba.fastjson.JSON.parseArray(str));
        }
        return com.taobao.weex.wson.WsonUtils.toWson(com.alibaba.fastjson.JSON.parse(str));
    }

    public static final java.lang.Object parseWsonOrJSON(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            if (USE_WSON) {
                return com.taobao.weex.wson.Wson.parse(bArr);
            }
            return com.alibaba.fastjson.JSON.parse(new java.lang.String(bArr, "UTF-8"));
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, e);
            if (USE_WSON) {
                return com.alibaba.fastjson.JSON.parse(new java.lang.String(bArr));
            }
            return com.taobao.weex.wson.Wson.parse(bArr);
        }
    }

    public static final com.taobao.weex.bridge.WXJSObject toWsonOrJsonWXJSObject(java.lang.Object obj) {
        if (obj == null) {
            return new com.taobao.weex.bridge.WXJSObject(null);
        }
        if (obj.getClass() == com.taobao.weex.bridge.WXJSObject.class) {
            return (com.taobao.weex.bridge.WXJSObject) obj;
        }
        if (USE_WSON) {
            return new com.taobao.weex.bridge.WXJSObject(4, com.taobao.weex.wson.Wson.toWson(obj));
        }
        return new com.taobao.weex.bridge.WXJSObject(3, com.taobao.weex.utils.WXJsonUtils.fromObjectToJSONString(obj));
    }

    public static final java.lang.Object convertWXJSObjectDataToJSON(com.taobao.weex.bridge.WXJSObject wXJSObject) {
        if (wXJSObject.type == 4) {
            return com.alibaba.fastjson.JSON.parse(com.taobao.weex.wson.Wson.parse((byte[]) wXJSObject.data).toString());
        }
        return com.alibaba.fastjson.JSON.parse(wXJSObject.data.toString());
    }

    public static java.lang.String fromObjectToJSONString(com.taobao.weex.bridge.WXJSObject wXJSObject) {
        java.lang.Object obj;
        if (wXJSObject != null && wXJSObject.type == 4 && (obj = com.taobao.weex.wson.Wson.parse((byte[]) wXJSObject.data)) != null) {
            return obj.toString();
        }
        return com.taobao.weex.utils.WXJsonUtils.fromObjectToJSONString(wXJSObject, false);
    }
}
