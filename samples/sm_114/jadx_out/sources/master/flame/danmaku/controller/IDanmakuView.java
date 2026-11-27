package master.flame.danmaku.controller;

/* JADX INFO: loaded from: classes2.dex */
public interface IDanmakuView {
    public static final int THREAD_TYPE_HIGH_PRIORITY = 2;
    public static final int THREAD_TYPE_LOW_PRIORITY = 3;
    public static final int THREAD_TYPE_MAIN_THREAD = 1;
    public static final int THREAD_TYPE_NORMAL_PRIORITY = 0;

    public interface OnDanmakuClickListener {
        boolean onDanmakuClick(master.flame.danmaku.danmaku.model.IDanmakus iDanmakus);

        boolean onViewClick(master.flame.danmaku.controller.IDanmakuView iDanmakuView);
    }

    void addDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku);

    void clearDanmakusOnScreen();

    void enableDanmakuDrawingCache(boolean z);

    master.flame.danmaku.danmaku.model.android.DanmakuContext getConfig();

    long getCurrentTime();

    master.flame.danmaku.danmaku.model.IDanmakus getCurrentVisibleDanmakus();

    int getHeight();

    master.flame.danmaku.controller.IDanmakuView.OnDanmakuClickListener getOnDanmakuClickListener();

    android.view.View getView();

    int getWidth();

    void hide();

    long hideAndPauseDrawTask();

    void invalidateDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, boolean z);

    boolean isDanmakuDrawingCacheEnabled();

    boolean isHardwareAccelerated();

    boolean isPaused();

    boolean isPrepared();

    boolean isShown();

    void pause();

    void prepare(master.flame.danmaku.danmaku.parser.BaseDanmakuParser baseDanmakuParser, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext);

    void release();

    void removeAllDanmakus(boolean z);

    void removeAllLiveDanmakus();

    void resume();

    void seekTo(java.lang.Long l);

    void setCallback(master.flame.danmaku.controller.DrawHandler.Callback callback);

    void setDrawingThreadType(int i);

    void setOnDanmakuClickListener(master.flame.danmaku.controller.IDanmakuView.OnDanmakuClickListener onDanmakuClickListener);

    void setVisibility(int i);

    void show();

    void showAndResumeDrawTask(java.lang.Long l);

    void showFPS(boolean z);

    void start();

    void start(long j);

    void stop();

    void toggle();
}
