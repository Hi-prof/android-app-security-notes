package io.dcloud.media.weex.weex_video.ijkplayer.danmaku;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseDanmakuConverter<T extends io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BaseDanmakuData> {
    public abstract T convertDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku);

    protected void initData(T t, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
        int i = 1;
        if (!(baseDanmaku instanceof master.flame.danmaku.danmaku.model.R2LDanmaku)) {
            if (baseDanmaku instanceof master.flame.danmaku.danmaku.model.FBDanmaku) {
                i = 4;
            } else if (baseDanmaku instanceof master.flame.danmaku.danmaku.model.FTDanmaku) {
                i = 5;
            }
        }
        t.setType(i);
        t.setContent(baseDanmaku.text.toString());
        t.setTime(baseDanmaku.getTime());
        t.setTextSize(baseDanmaku.textSize);
        t.setTextColor(baseDanmaku.textColor);
    }
}
