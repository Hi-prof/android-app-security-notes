package io.dcloud.feature.utsplugin;

/* JADX INFO: loaded from: classes2.dex */
public class UTSPlugin {
    public static void initPlugin(android.content.Context context) {
        try {
            com.taobao.weex.WXSDKEngine.registerModule("UTS-Proxy", io.dcloud.feature.utsplugin.ProxyModule.class);
        } catch (com.taobao.weex.common.WXException e) {
            e.printStackTrace();
        }
    }
}
