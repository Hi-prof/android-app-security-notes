package com.taobao.weex.appfram.storage;

/* JADX INFO: loaded from: classes.dex */
public class StorageResultHandler {
    private static final java.lang.String DATA = "data";
    private static final java.lang.String RESULT = "result";
    private static final java.lang.String RESULT_FAILED = "failed";
    private static final java.lang.String RESULT_FAILED_INVALID_PARAM = "invalid_param";
    private static final java.lang.String RESULT_FAILED_NO_HANDLER = "no_handler";
    private static final java.lang.String RESULT_OK = "success";
    private static final java.lang.String UNDEFINED = "undefined";

    private StorageResultHandler() {
    }

    public static java.util.Map<java.lang.String, java.lang.Object> getItemResult(java.lang.String str) {
        java.util.HashMap map = new java.util.HashMap(4);
        map.put("result", str != null ? "success" : "failed");
        if (str == null) {
            str = "undefined";
        }
        map.put("data", str);
        return map;
    }

    public static java.util.Map<java.lang.String, java.lang.Object> setItemResult(boolean z) {
        java.util.HashMap map = new java.util.HashMap(4);
        map.put("result", z ? "success" : "failed");
        map.put("data", "undefined");
        return map;
    }

    public static java.util.Map<java.lang.String, java.lang.Object> removeItemResult(boolean z) {
        java.util.HashMap map = new java.util.HashMap(4);
        map.put("result", z ? "success" : "failed");
        map.put("data", "undefined");
        return map;
    }

    public static java.util.Map<java.lang.String, java.lang.Object> getLengthResult(long j) {
        java.util.HashMap map = new java.util.HashMap(4);
        map.put("result", "success");
        map.put("data", java.lang.Long.valueOf(j));
        return map;
    }

    public static java.util.Map<java.lang.String, java.lang.Object> getAllkeysResult(java.util.List<java.lang.String> list) {
        if (list == null) {
            list = new java.util.ArrayList<>(1);
        }
        java.util.HashMap map = new java.util.HashMap(4);
        map.put("result", "success");
        map.put("data", list);
        return map;
    }

    private static void handleResult(com.taobao.weex.bridge.JSCallback jSCallback, java.lang.String str, java.lang.Object obj) {
        if (jSCallback == null) {
            return;
        }
        java.util.HashMap map = new java.util.HashMap(4);
        map.put("result", str);
        map.put("data", obj);
        jSCallback.invoke(map);
    }

    public static void handleNoHandlerError(com.taobao.weex.bridge.JSCallback jSCallback) {
        handleResult(jSCallback, "failed", RESULT_FAILED_NO_HANDLER);
    }

    public static void handleInvalidParam(com.taobao.weex.bridge.JSCallback jSCallback) {
        handleResult(jSCallback, "failed", RESULT_FAILED_INVALID_PARAM);
    }
}
