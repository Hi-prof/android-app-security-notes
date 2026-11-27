package io.dcloud.feature.weex_barcode;

/* JADX INFO: loaded from: classes2.dex */
public class BarcodePlugin {
    public static void initPlugin(android.content.Context context) {
        try {
            com.taobao.weex.WXSDKEngine.registerComponent("barcode", (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) io.dcloud.feature.weex_barcode.BarcodeComponent.class);
            com.taobao.weex.WXSDKEngine.registerModule("barcodeScan", io.dcloud.feature.weex_barcode.BarcodeModule.class);
            io.dcloud.feature.weex.WeexInstanceMgr.self().addComponentByName("barcode", io.dcloud.feature.weex_barcode.BarcodeComponent.class);
        } catch (com.taobao.weex.common.WXException e) {
            e.printStackTrace();
        }
    }
}
