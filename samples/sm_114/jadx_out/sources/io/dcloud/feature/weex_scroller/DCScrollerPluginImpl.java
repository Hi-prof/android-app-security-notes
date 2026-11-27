package io.dcloud.feature.weex_scroller;

/* JADX INFO: loaded from: classes2.dex */
public class DCScrollerPluginImpl {
    public static void initPlugin(android.content.Context context) {
        try {
            com.taobao.weex.WXSDKEngine.registerComponent((com.taobao.weex.ui.IFComponentHolder) new com.taobao.weex.ui.SimpleComponentHolder(com.taobao.weex.ui.component.DCWXScroller.class, new com.taobao.weex.ui.component.DCWXScroller.Creator()), false, "scroll-view");
            io.dcloud.feature.weex.WeexInstanceMgr.self().addComponentByName("scroll-view", com.taobao.weex.ui.component.DCWXScroller.class);
        } catch (com.taobao.weex.common.WXException e) {
            e.printStackTrace();
        }
    }
}
