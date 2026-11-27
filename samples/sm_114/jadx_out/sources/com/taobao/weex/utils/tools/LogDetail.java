package com.taobao.weex.utils.tools;

/* JADX INFO: loaded from: classes.dex */
public class LogDetail {
    public static final java.lang.String KeyWords_Render = "Weex_Render";
    public static final java.lang.String KeyWrod_Init = "Weex_Init";
    public java.lang.String keyWords = KeyWords_Render;

    @com.alibaba.fastjson.annotation.JSONField(name = com.taobao.weex.common.Constants.Value.TIME)
    public com.taobao.weex.utils.tools.Time time = new com.taobao.weex.utils.tools.Time();

    @com.alibaba.fastjson.annotation.JSONField(name = "Info")
    public com.taobao.weex.utils.tools.Info info = new com.taobao.weex.utils.tools.Info();

    public java.lang.String toString() {
        return "taskName : " + this.info.taskName + " - LogDetail : {time = '" + this.time + "', info = '" + this.info + "'}";
    }

    public void println() {
        if (com.taobao.weex.WXEnvironment.isPerf()) {
            android.util.Log.e(com.taobao.weex.utils.tools.TimeCalculator.TIMELINE_TAG, " timeline " + this.keyWords + " java LogDetail: " + toString());
        }
    }

    public void name(java.lang.String str) {
        this.time.constructor();
        this.info.taskName = str;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.lang.String lowerCase = str.toLowerCase(java.util.Locale.ROOT);
        if (lowerCase.contains("module") || lowerCase.contains(com.taobao.weex.bridge.WXBridgeManager.COMPONENT) || lowerCase.contains("framework")) {
            this.keyWords = KeyWrod_Init;
        }
    }

    public void keyWorkds(java.lang.String str) {
        this.keyWords = str;
    }

    public void taskStart() {
        this.time.taskStart();
    }

    public void taskEnd() {
        this.time.taskEnd();
        println();
    }
}
