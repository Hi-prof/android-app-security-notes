package io.dcloud.feature.weex_input;

/* JADX INFO: loaded from: classes2.dex */
public class DCWXInputRegister {
    public static void initPlugin(android.content.Context context) {
        try {
            com.taobao.weex.WXSDKEngine.registerComponent("u-input", (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.DCWXInput.class);
            com.taobao.weex.WXSDKEngine.registerComponent("u-textarea", (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.DCTextArea.class, false);
            io.dcloud.feature.weex.WeexInstanceMgr.self().addComponentByName("input", com.taobao.weex.ui.component.DCWXInput.class);
            io.dcloud.feature.weex.WeexInstanceMgr.self().addComponentByName(com.taobao.weex.ui.component.WXBasicComponentType.TEXTAREA, com.taobao.weex.ui.component.DCTextArea.class);
        } catch (com.taobao.weex.common.WXException e) {
            e.printStackTrace();
        }
    }
}
