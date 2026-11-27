package com.taobao.weex.performance;

/* JADX INFO: loaded from: classes.dex */
public interface IWXApmMonitorAdapter {
    void addProperty(java.lang.String str, java.lang.Object obj);

    void addStats(java.lang.String str, double d);

    void onAppear();

    void onDisappear();

    void onEnd();

    void onEvent(java.lang.String str, java.lang.Object obj);

    void onStage(java.lang.String str, long j);

    void onStart(java.lang.String str);

    void onSubProcedureEvent(java.lang.String str, java.lang.String str2);

    void onSubProcedureStage(java.lang.String str, java.lang.String str2);

    java.lang.String parseReportUrl(java.lang.String str);

    void setSubProcedureProperties(java.lang.String str, java.lang.String str2, java.lang.Object obj);

    void setSubProcedureStats(java.lang.String str, java.lang.String str2, double d);
}
