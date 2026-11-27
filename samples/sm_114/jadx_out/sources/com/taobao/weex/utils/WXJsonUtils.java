package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class WXJsonUtils {
    public static <T> java.util.List<T> getList(java.lang.String str, java.lang.Class<T> cls) {
        try {
            return com.alibaba.fastjson.JSONObject.parseArray(str, cls);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return new java.util.ArrayList();
        }
    }

    public static java.lang.String fromObjectToJSONString(java.lang.Object obj, boolean z) {
        try {
            return z ? com.alibaba.fastjson.JSON.toJSONString(obj, com.alibaba.fastjson.serializer.SerializerFeature.WriteNonStringKeyAsString) : com.alibaba.fastjson.JSON.toJSONString(obj);
        } catch (java.lang.Exception e) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                throw new com.taobao.weex.common.WXRuntimeException("fromObjectToJSONString parse error!");
            }
            com.taobao.weex.utils.WXLogUtils.e("fromObjectToJSONString error:", e);
            return "{}";
        }
    }

    public static java.lang.String fromObjectToJSONString(java.lang.Object obj) {
        return fromObjectToJSONString(obj, false);
    }

    public static void putAll(java.util.Map<java.lang.String, java.lang.Object> map, com.alibaba.fastjson.JSONObject jSONObject) {
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : jSONObject.entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.Object value = entry.getValue();
            if (key != null && value != null) {
                map.put(key, value);
            }
        }
    }
}
