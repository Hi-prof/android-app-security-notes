package io.dcloud.feature.weex.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class DCDefaultConfigAdapter implements com.taobao.weex.adapter.IWXConfigAdapter {
    @Override // com.taobao.weex.adapter.IWXConfigAdapter
    public boolean checkMode(java.lang.String str) {
        return false;
    }

    @Override // com.taobao.weex.adapter.IWXConfigAdapter
    public java.lang.String getConfig(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return str3;
    }

    @Override // com.taobao.weex.adapter.IWXConfigAdapter
    public java.lang.String getConfigWhenInit(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return str3;
    }
}
