package com.alibaba.android.bindingx.plugin.weex;

/* JADX INFO: loaded from: classes.dex */
public class WXModuleUtils {
    private WXModuleUtils() {
    }

    public static android.view.View findViewByRef(java.lang.String str, java.lang.String str2) {
        com.taobao.weex.ui.component.WXComponent wXComponentFindComponentByRef = findComponentByRef(str, str2);
        if (wXComponentFindComponentByRef == null) {
            return null;
        }
        return wXComponentFindComponentByRef.getHostView();
    }

    public static com.taobao.weex.ui.component.WXComponent findComponentByRef(java.lang.String str, java.lang.String str2) {
        return com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(str, str2);
    }
}
