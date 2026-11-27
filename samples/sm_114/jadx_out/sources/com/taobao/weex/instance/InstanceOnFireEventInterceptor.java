package com.taobao.weex.instance;

/* JADX INFO: loaded from: classes.dex */
public abstract class InstanceOnFireEventInterceptor {
    private java.util.List<java.lang.String> listenEvents = new java.util.ArrayList();

    public abstract void onFireEvent(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2);

    public void addInterceptEvent(java.lang.String str) {
        if (this.listenEvents.contains(str)) {
            return;
        }
        this.listenEvents.add(str);
    }

    public java.util.List<java.lang.String> getListenEvents() {
        return this.listenEvents;
    }

    public void onInterceptFireEvent(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        if (map != null && this.listenEvents.contains(str3)) {
            onFireEvent(str, str2, str3, map, map2);
        }
    }
}
