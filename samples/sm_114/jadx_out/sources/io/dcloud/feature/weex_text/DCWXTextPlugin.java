package io.dcloud.feature.weex_text;

/* JADX INFO: loaded from: classes2.dex */
public class DCWXTextPlugin {
    public static void initPlugin(android.content.Context context) {
        try {
            com.taobao.weex.WXSDKEngine.registerComponent((com.taobao.weex.ui.IFComponentHolder) new com.taobao.weex.ui.SimpleComponentHolder(io.dcloud.feature.weex_text.DCWXText.class, new io.dcloud.feature.weex_text.DCWXText.Creator()), false, "u-text");
            com.taobao.weex.WXSDKEngine.registerComponent((com.taobao.weex.ui.IFComponentHolder) new com.taobao.weex.ui.SimpleComponentHolder(io.dcloud.feature.weex_text.DCWXRichText.class, new io.dcloud.feature.weex_text.DCWXRichText.Creator()), false, "u-rich-text");
            io.dcloud.feature.weex.WeexInstanceMgr.self().addComponentByName("text", io.dcloud.feature.weex_text.DCWXText.class);
            io.dcloud.feature.weex.WeexInstanceMgr.self().addComponentByName("rich-text", io.dcloud.feature.weex_text.DCWXRichText.class);
        } catch (com.taobao.weex.common.WXException e) {
            e.printStackTrace();
        }
    }
}
