package com.taobao.weex.adapter;

/* JADX INFO: loaded from: classes.dex */
public class ClassLoaderAdapter {
    public java.lang.Class<? extends com.taobao.weex.common.WXModule> getModuleClass(java.lang.String str, java.lang.String str2, android.content.Context context) {
        try {
            return context.getClassLoader().loadClass(str2);
        } catch (java.lang.ClassNotFoundException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent> getComponentClass(java.lang.String str, java.lang.String str2, com.taobao.weex.WXSDKInstance wXSDKInstance) {
        try {
            return wXSDKInstance.getContext().getClassLoader().loadClass(str2);
        } catch (java.lang.ClassNotFoundException e) {
            throw new java.lang.RuntimeException(e);
        }
    }
}
