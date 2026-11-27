package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
public class WXJSService implements com.taobao.weex.common.IWXObject {
    private java.lang.String name;
    private java.util.Map<java.lang.String, java.lang.Object> options = new java.util.HashMap();
    private java.lang.String script;

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public java.lang.String getScript() {
        return this.script;
    }

    public void setScript(java.lang.String str) {
        this.script = str;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getOptions() {
        return this.options;
    }

    public void setOptions(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.options = map;
    }
}
