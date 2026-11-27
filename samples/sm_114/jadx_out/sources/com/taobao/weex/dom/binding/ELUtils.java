package com.taobao.weex.dom.binding;

/* JADX INFO: loaded from: classes.dex */
public class ELUtils {
    public static final java.lang.String BINDING = "@binding";
    public static final java.lang.String COMPONENT_PROPS = "@componentProps";
    public static final java.lang.String[] EXCLUDES_BINDING = {"clickEventParams"};
    public static final java.lang.String IS_COMPONENT_ROOT = "@isComponentRoot";

    public static boolean isBinding(java.lang.Object obj) {
        if (obj instanceof com.alibaba.fastjson.JSONObject) {
            if (((com.alibaba.fastjson.JSONObject) obj).containsKey(BINDING)) {
                return true;
            }
        } else if (obj instanceof com.alibaba.fastjson.JSONArray) {
            com.alibaba.fastjson.JSONArray jSONArray = (com.alibaba.fastjson.JSONArray) obj;
            for (int i = 0; i < jSONArray.size(); i++) {
                if (isBinding(jSONArray.get(i))) {
                    return true;
                }
            }
        } else if ((obj instanceof java.lang.String) && ((java.lang.String) obj).indexOf(BINDING) >= 0) {
            return true;
        }
        return false;
    }

    public static java.lang.Object bindingBlock(java.lang.Object obj) {
        if (obj instanceof com.alibaba.fastjson.JSONObject) {
            com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) obj;
            if (jSONObject.containsKey(BINDING)) {
                java.lang.Object obj2 = jSONObject.get(BINDING);
                if (!(obj2 instanceof com.taobao.weex.el.parse.Token)) {
                    jSONObject.put(BINDING, (java.lang.Object) com.taobao.weex.el.parse.Parser.parse(obj2.toString()));
                }
            }
            for (java.lang.String str : jSONObject.keySet()) {
                if ((jSONObject.get(str) instanceof com.alibaba.fastjson.JSONObject) && ((com.alibaba.fastjson.JSONObject) jSONObject.get(str)).containsKey(BINDING)) {
                    com.alibaba.fastjson.JSONObject jSONObject2 = (com.alibaba.fastjson.JSONObject) jSONObject.get(str);
                    java.lang.Object obj3 = jSONObject2.get(BINDING);
                    if (!(obj3 instanceof com.taobao.weex.el.parse.Token)) {
                        jSONObject2.put(BINDING, (java.lang.Object) com.taobao.weex.el.parse.Parser.parse(obj3.toString()));
                    }
                }
            }
            return obj;
        }
        if (obj instanceof com.alibaba.fastjson.JSONArray) {
            com.alibaba.fastjson.JSONArray jSONArray = (com.alibaba.fastjson.JSONArray) obj;
            for (int i = 0; i < jSONArray.size(); i++) {
                bindingBlock(jSONArray.get(i));
            }
            return obj;
        }
        if (!(obj instanceof java.lang.String)) {
            return obj;
        }
        java.lang.String string = obj.toString();
        if (string.startsWith(com.taobao.weex.el.parse.Operators.BLOCK_START_STR)) {
            return bindingBlock(com.alibaba.fastjson.JSON.parseObject(string));
        }
        return string.startsWith(com.taobao.weex.el.parse.Operators.ARRAY_START_STR) ? bindingBlock(com.alibaba.fastjson.JSON.parseArray(string)) : obj;
    }

    public static java.lang.Object vforBlock(java.lang.Object obj) {
        if (obj instanceof com.alibaba.fastjson.JSONObject) {
            com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) obj;
            if (jSONObject.containsKey(com.taobao.weex.dom.binding.WXStatement.WX_FOR_LIST)) {
                java.lang.Object obj2 = jSONObject.get(com.taobao.weex.dom.binding.WXStatement.WX_FOR_LIST);
                if (!(obj2 instanceof com.taobao.weex.el.parse.Token)) {
                    jSONObject.put(com.taobao.weex.dom.binding.WXStatement.WX_FOR_LIST, (java.lang.Object) com.taobao.weex.el.parse.Parser.parse(obj2.toString()));
                    return obj;
                }
            }
        } else {
            if (obj instanceof java.lang.String) {
                return vforBlock(com.alibaba.fastjson.JSONObject.parseObject(obj.toString()));
            }
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.e("weex", "weex vfor is illegal " + obj);
            }
        }
        return obj;
    }
}
