package com.alibaba.android.bindingx.plugin.weex;

/* JADX INFO: loaded from: classes.dex */
public class BindingX {
    private BindingX() {
    }

    public static void register() throws com.taobao.weex.common.WXException {
        com.taobao.weex.WXSDKEngine.registerModule("expressionBinding", com.alibaba.android.bindingx.plugin.weex.WXExpressionBindingModule.class);
        com.taobao.weex.WXSDKEngine.registerModule("binding", com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.class);
        com.taobao.weex.WXSDKEngine.registerModule("bindingx", com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.class);
    }
}
