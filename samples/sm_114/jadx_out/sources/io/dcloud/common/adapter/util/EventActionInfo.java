package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class EventActionInfo {
    private java.lang.String evalJs;
    private java.lang.String eventAction;
    private java.util.Map<java.lang.String, java.lang.Object> params;

    public EventActionInfo(java.lang.String str) {
        this.eventAction = str;
    }

    public java.lang.String getEvalJs() {
        return this.evalJs;
    }

    public java.lang.String getEventAction() {
        return this.eventAction;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getParams() {
        return this.params;
    }

    public EventActionInfo(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        this.eventAction = str;
        this.params = map;
    }

    public EventActionInfo(java.lang.String str, java.lang.String str2) {
        this.eventAction = str;
        this.evalJs = str2;
    }

    public EventActionInfo(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map) {
        this.eventAction = str;
        this.evalJs = str2;
        this.params = map;
    }
}
