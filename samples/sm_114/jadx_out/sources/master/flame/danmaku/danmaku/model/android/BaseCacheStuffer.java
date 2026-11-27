package master.flame.danmaku.danmaku.model.android;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseCacheStuffer {
    protected master.flame.danmaku.danmaku.model.android.BaseCacheStuffer.Proxy mProxy;

    public static abstract class Proxy {
        public abstract void prepareDrawing(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, boolean z);

        public abstract void releaseResource(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku);
    }

    public void clearCache(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
    }

    public abstract void clearCaches();

    public abstract void drawDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, android.graphics.Canvas canvas, float f, float f2, boolean z, master.flame.danmaku.danmaku.model.android.AndroidDisplayer.DisplayerConfig displayerConfig);

    public abstract void measure(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, android.text.TextPaint textPaint, boolean z);

    public void prepare(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, boolean z) {
        master.flame.danmaku.danmaku.model.android.BaseCacheStuffer.Proxy proxy = this.mProxy;
        if (proxy != null) {
            proxy.prepareDrawing(baseDanmaku, z);
        }
    }

    public boolean drawCache(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, android.graphics.Canvas canvas, float f, float f2, android.graphics.Paint paint, android.text.TextPaint textPaint) {
        master.flame.danmaku.danmaku.model.android.DrawingCacheHolder drawingCacheHolder;
        master.flame.danmaku.danmaku.model.IDrawingCache<?> drawingCache = baseDanmaku.getDrawingCache();
        if (drawingCache == null || (drawingCacheHolder = (master.flame.danmaku.danmaku.model.android.DrawingCacheHolder) drawingCache.get()) == null) {
            return false;
        }
        return drawingCacheHolder.draw(canvas, f, f2, paint);
    }

    public void setProxy(master.flame.danmaku.danmaku.model.android.BaseCacheStuffer.Proxy proxy) {
        this.mProxy = proxy;
    }

    public void releaseResource(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
        master.flame.danmaku.danmaku.model.android.BaseCacheStuffer.Proxy proxy = this.mProxy;
        if (proxy != null) {
            proxy.releaseResource(baseDanmaku);
        }
    }
}
