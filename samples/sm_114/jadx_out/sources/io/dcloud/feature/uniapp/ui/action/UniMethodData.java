package io.dcloud.feature.uniapp.ui.action;

/* JADX INFO: loaded from: classes2.dex */
public class UniMethodData {
    com.alibaba.fastjson.JSONArray args;
    java.lang.String method;

    public java.lang.String getMethod() {
        return this.method;
    }

    public com.alibaba.fastjson.JSONArray getArgs() {
        return this.args;
    }

    public UniMethodData(java.lang.String str, com.alibaba.fastjson.JSONArray jSONArray) {
        this.method = str;
        this.args = jSONArray;
    }
}
