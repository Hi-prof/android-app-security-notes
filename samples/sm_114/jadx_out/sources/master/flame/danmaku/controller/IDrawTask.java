package master.flame.danmaku.controller;

/* JADX INFO: loaded from: classes2.dex */
public interface IDrawTask {
    public static final int PLAY_STATE_PAUSE = 2;
    public static final int PLAY_STATE_PLAYING = 1;

    public interface TaskListener {
        void onDanmakuAdd(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku);

        void onDanmakuConfigChanged();

        void onDanmakuShown(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku);

        void onDanmakusDrawingFinished();

        void ready();
    }

    void addDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku);

    void clearDanmakusOnScreen(long j);

    master.flame.danmaku.danmaku.renderer.IRenderer.RenderingState draw(master.flame.danmaku.danmaku.model.AbsDisplayer absDisplayer);

    master.flame.danmaku.danmaku.model.IDanmakus getVisibleDanmakusOnTime(long j);

    void invalidateDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, boolean z);

    void onPlayStateChanged(int i);

    void prepare();

    void quit();

    void removeAllDanmakus(boolean z);

    void removeAllLiveDanmakus();

    void requestClear();

    void requestClearRetainer();

    void requestHide();

    void requestSync(long j, long j2, long j3);

    void reset();

    void seek(long j);

    void setParser(master.flame.danmaku.danmaku.parser.BaseDanmakuParser baseDanmakuParser);

    void start();
}
