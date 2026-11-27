package io.dcloud.feature.weex_media;

/* JADX INFO: loaded from: classes2.dex */
public class VideoPlayerPlugin {
    public static void initPlugin(android.content.Context context) {
        try {
            com.taobao.weex.WXSDKEngine.registerComponent("u-video", (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) io.dcloud.feature.weex_media.VideoComponent.class);
            io.dcloud.feature.weex.WeexInstanceMgr.self().addComponentByName("video", io.dcloud.feature.weex_media.VideoComponent.class);
        } catch (com.taobao.weex.common.WXException e) {
            e.printStackTrace();
        }
    }
}
