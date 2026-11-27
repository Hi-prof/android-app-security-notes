package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public class EventResult {
    private java.lang.Object result;
    private boolean success = false;

    public void onCallback(java.lang.Object obj) {
        this.success = true;
        this.result = obj;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public java.lang.Object getResult() {
        return this.result;
    }
}
