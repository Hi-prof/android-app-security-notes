package com.alibaba.android.bindingx.plugin.weex;

/* JADX INFO: loaded from: classes.dex */
public class WXBindingXModuleService extends android.app.Service implements com.taobao.weex.ui.IExternalModuleGetter {
    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return null;
    }

    @Override // com.taobao.weex.ui.IExternalModuleGetter
    public java.lang.Class<? extends com.taobao.weex.common.WXModule> getExternalModuleClass(java.lang.String str, android.content.Context context) {
        if ("bindingx".equals(str) || "binding".equals(str)) {
            return com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.class;
        }
        if ("expressionBinding".equals(str)) {
            return com.alibaba.android.bindingx.plugin.weex.WXExpressionBindingModule.class;
        }
        return null;
    }
}
