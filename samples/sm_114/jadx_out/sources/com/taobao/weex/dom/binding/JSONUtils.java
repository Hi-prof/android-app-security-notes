package com.taobao.weex.dom.binding;

/* JADX INFO: loaded from: classes.dex */
public class JSONUtils {
    public static boolean isJSON(java.lang.Object obj) {
        if (obj instanceof com.alibaba.fastjson.JSONObject) {
            return true;
        }
        if (obj instanceof java.lang.String) {
            return ((java.lang.String) obj).startsWith(com.taobao.weex.el.parse.Operators.BLOCK_START_STR);
        }
        return false;
    }

    public static com.alibaba.fastjson.JSONObject toJSON(java.lang.Object obj) {
        if (obj instanceof com.alibaba.fastjson.JSONObject) {
            return (com.alibaba.fastjson.JSONObject) obj;
        }
        return com.alibaba.fastjson.JSONObject.parseObject(obj.toString());
    }

    public static boolean isJSON(java.lang.String str) {
        return str.startsWith(com.taobao.weex.el.parse.Operators.BLOCK_START_STR);
    }
}
