package io.dcloud.feature.weex_switch;

/* JADX INFO: loaded from: classes2.dex */
public class DCWXSwitchPlugin {
    public static void initPlugin(android.content.Context context) {
        try {
            com.taobao.weex.WXSDKEngine.registerComponent("dc-switch", (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) io.dcloud.feature.weex_switch.DCWXSwitch.class);
            io.dcloud.feature.weex.WeexInstanceMgr.self().addComponentByName(com.taobao.weex.common.Constants.Name.Recycler.LIST_DATA_TEMPLATE_SWITCH_KEY, io.dcloud.feature.weex_switch.DCWXSwitch.class);
        } catch (com.taobao.weex.common.WXException e) {
            e.printStackTrace();
        }
    }
}
