package master.flame.danmaku.controller;

/* JADX INFO: loaded from: classes2.dex */
public interface IDanmakuViewController {
    void clear();

    long drawDanmakus();

    android.content.Context getContext();

    int getHeight();

    int getWidth();

    boolean isDanmakuDrawingCacheEnabled();

    boolean isHardwareAccelerated();

    boolean isViewReady();
}
