package com.taobao.weex.adapter;

/* JADX INFO: loaded from: classes.dex */
public interface IWXJscProcessManager {
    boolean enableBackUpThreadCache();

    boolean enableBackupThread();

    long rebootTimeout();

    boolean shouldReboot();

    boolean withException(com.taobao.weex.WXSDKInstance wXSDKInstance);
}
