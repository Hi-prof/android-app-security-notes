package com.taobao.weex.utils.tools;

/* JADX INFO: loaded from: classes.dex */
public class TimeCalculator {
    public static final java.lang.String PLATFORM_ANDROID = "Android";
    public static final java.lang.String TIMELINE_TAG = "timeline";
    private java.lang.String test = "{\"time\":{\"execTime\":0,\"constructor\":0,\"destructor\":0,\"taskStart\":0,\"taskEnd\":0,\"waitTime\":0},\"Info\":{\"taskInfo\":{\"relateTaskId\":0,\"args\":\"stringReplace\"},\"taskName\":\"stringReplace\",\"instanceId\":\"1\",\"platform\":\"stringReplace\",\"taskId\":0}}";
    private java.util.concurrent.CopyOnWriteArrayList<com.taobao.weex.utils.tools.LogDetail> logRecorder = new java.util.concurrent.CopyOnWriteArrayList<>();

    public TimeCalculator(com.taobao.weex.WXSDKInstance wXSDKInstance) {
    }

    public void addLog(com.taobao.weex.utils.tools.LogDetail logDetail) {
        if (com.taobao.weex.WXEnvironment.isPerf()) {
            this.logRecorder.add(logDetail);
        }
    }

    public com.taobao.weex.utils.tools.LogDetail createLogDetail(java.lang.String str) {
        com.taobao.weex.utils.tools.LogDetail logDetail = new com.taobao.weex.utils.tools.LogDetail();
        logDetail.name(str);
        addLog(logDetail);
        return logDetail;
    }

    public void println() {
        if (com.taobao.weex.WXEnvironment.isPerf()) {
            java.util.Iterator<com.taobao.weex.utils.tools.LogDetail> it = this.logRecorder.iterator();
            while (it.hasNext()) {
                android.util.Log.e(TIMELINE_TAG, com.alibaba.fastjson.JSON.toJSONString(it.next()));
            }
        }
    }
}
