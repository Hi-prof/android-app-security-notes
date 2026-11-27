package com.taobao.weex.http;

/* JADX INFO: loaded from: classes.dex */
public class CertDTO implements io.dcloud.common.DHInterface.IReflectAble {
    public java.lang.String client;
    public java.lang.String clientPassword;
    public java.lang.String host;
    public java.lang.String[] server;

    public java.lang.String getHost() {
        return this.host;
    }

    public void setHost(java.lang.String str) {
        this.host = str;
    }

    public java.lang.String getClient() {
        return this.client;
    }

    public void setClient(java.lang.String str) {
        this.client = str;
    }

    public java.lang.String getClientPassword() {
        return this.clientPassword;
    }

    public void setClientPassword(java.lang.String str) {
        this.clientPassword = str;
    }

    public java.lang.String[] getServer() {
        return this.server;
    }

    public void setServer(java.lang.String[] strArr) {
        this.server = strArr;
    }
}
