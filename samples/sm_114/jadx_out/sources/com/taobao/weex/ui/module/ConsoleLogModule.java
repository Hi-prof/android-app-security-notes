package com.taobao.weex.ui.module;

/* JADX INFO: loaded from: classes.dex */
public class ConsoleLogModule extends com.taobao.weex.common.WXModule {
    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void switchLogLevel(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback) {
        io.dcloud.feature.uniapp.utils.AbsLogLevel logLevel = getLogLevel(str);
        androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap();
        if (logLevel == null) {
            arrayMap.put("status", "failure");
        } else {
            com.taobao.weex.WXEnvironment.sLogLevel = logLevel;
            com.taobao.weex.bridge.WXBridgeManager.getInstance().setLogLevel(com.taobao.weex.WXEnvironment.sLogLevel.getValue(), com.taobao.weex.WXEnvironment.isPerf());
            arrayMap.put("status", com.taobao.weex.ui.component.WXImage.SUCCEED);
        }
        if (jSCallback != null) {
            jSCallback.invoke(arrayMap);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void setPerfMode(java.lang.String str) {
        com.taobao.weex.WXEnvironment.isPerf = io.dcloud.common.constant.AbsoluteConst.TRUE.equals(str);
        com.taobao.weex.bridge.WXBridgeManager.getInstance().setLogLevel(com.taobao.weex.WXEnvironment.sLogLevel.getValue(), com.taobao.weex.WXEnvironment.isPerf());
    }

    private io.dcloud.feature.uniapp.utils.AbsLogLevel getLogLevel(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "off":
                return com.taobao.weex.utils.LogLevel.OFF;
            case "info":
                return com.taobao.weex.utils.LogLevel.INFO;
            case "debug":
                return com.taobao.weex.utils.LogLevel.DEBUG;
            case "error":
                return com.taobao.weex.utils.LogLevel.ERROR;
            case "warning":
                return com.taobao.weex.utils.LogLevel.WARN;
            default:
                return null;
        }
    }
}
