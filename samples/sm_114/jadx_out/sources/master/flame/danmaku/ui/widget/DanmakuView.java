package master.flame.danmaku.ui.widget;

/* JADX INFO: loaded from: classes2.dex */
public class DanmakuView extends android.view.View implements master.flame.danmaku.controller.IDanmakuView, master.flame.danmaku.controller.IDanmakuViewController {
    private static final int MAX_RECORD_SIZE = 50;
    private static final int ONE_SECOND = 1000;
    public static final java.lang.String TAG = "DanmakuView";
    private master.flame.danmaku.controller.DrawHandler handler;
    private boolean isSurfaceCreated;
    private master.flame.danmaku.controller.DrawHandler.Callback mCallback;
    private boolean mClearFlag;
    private boolean mDanmakuVisible;
    private boolean mDrawFinished;
    private java.lang.Object mDrawMonitor;
    private java.util.LinkedList<java.lang.Long> mDrawTimes;
    protected int mDrawingThreadType;
    private boolean mEnableDanmakuDrwaingCache;
    private android.os.HandlerThread mHandlerThread;
    private android.view.View.OnClickListener mOnClickListener;
    private master.flame.danmaku.controller.IDanmakuView.OnDanmakuClickListener mOnDanmakuClickListener;
    private boolean mRequestRender;
    private java.lang.Runnable mResumeRunnable;
    private int mResumeTryCount;
    private boolean mShowFps;
    private master.flame.danmaku.ui.widget.DanmakuTouchHelper mTouchHelper;
    private long mUiThreadId;

    @Override // master.flame.danmaku.controller.IDanmakuView
    public android.view.View getView() {
        return this;
    }

    static /* synthetic */ int access$108(master.flame.danmaku.ui.widget.DanmakuView danmakuView) {
        int i = danmakuView.mResumeTryCount;
        danmakuView.mResumeTryCount = i + 1;
        return i;
    }

    public DanmakuView(android.content.Context context) {
        super(context);
        this.mEnableDanmakuDrwaingCache = true;
        this.mDanmakuVisible = true;
        this.mDrawingThreadType = 0;
        this.mDrawMonitor = new java.lang.Object();
        this.mDrawFinished = false;
        this.mRequestRender = false;
        this.mResumeTryCount = 0;
        this.mResumeRunnable = new java.lang.Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (master.flame.danmaku.ui.widget.DanmakuView.this.handler == null) {
                    return;
                }
                master.flame.danmaku.ui.widget.DanmakuView.access$108(master.flame.danmaku.ui.widget.DanmakuView.this);
                if (master.flame.danmaku.ui.widget.DanmakuView.this.mResumeTryCount > 4 || master.flame.danmaku.ui.widget.DanmakuView.super.isShown()) {
                    master.flame.danmaku.ui.widget.DanmakuView.this.handler.resume();
                } else {
                    master.flame.danmaku.ui.widget.DanmakuView.this.handler.postDelayed(this, master.flame.danmaku.ui.widget.DanmakuView.this.mResumeTryCount * 100);
                }
            }
        };
        init();
    }

    private void init() {
        this.mUiThreadId = java.lang.Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        master.flame.danmaku.controller.DrawHelper.useDrawColorToClearCanvas(true, false);
        this.mTouchHelper = master.flame.danmaku.ui.widget.DanmakuTouchHelper.instance(this);
    }

    public DanmakuView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEnableDanmakuDrwaingCache = true;
        this.mDanmakuVisible = true;
        this.mDrawingThreadType = 0;
        this.mDrawMonitor = new java.lang.Object();
        this.mDrawFinished = false;
        this.mRequestRender = false;
        this.mResumeTryCount = 0;
        this.mResumeRunnable = new java.lang.Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (master.flame.danmaku.ui.widget.DanmakuView.this.handler == null) {
                    return;
                }
                master.flame.danmaku.ui.widget.DanmakuView.access$108(master.flame.danmaku.ui.widget.DanmakuView.this);
                if (master.flame.danmaku.ui.widget.DanmakuView.this.mResumeTryCount > 4 || master.flame.danmaku.ui.widget.DanmakuView.super.isShown()) {
                    master.flame.danmaku.ui.widget.DanmakuView.this.handler.resume();
                } else {
                    master.flame.danmaku.ui.widget.DanmakuView.this.handler.postDelayed(this, master.flame.danmaku.ui.widget.DanmakuView.this.mResumeTryCount * 100);
                }
            }
        };
        init();
    }

    public DanmakuView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEnableDanmakuDrwaingCache = true;
        this.mDanmakuVisible = true;
        this.mDrawingThreadType = 0;
        this.mDrawMonitor = new java.lang.Object();
        this.mDrawFinished = false;
        this.mRequestRender = false;
        this.mResumeTryCount = 0;
        this.mResumeRunnable = new java.lang.Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (master.flame.danmaku.ui.widget.DanmakuView.this.handler == null) {
                    return;
                }
                master.flame.danmaku.ui.widget.DanmakuView.access$108(master.flame.danmaku.ui.widget.DanmakuView.this);
                if (master.flame.danmaku.ui.widget.DanmakuView.this.mResumeTryCount > 4 || master.flame.danmaku.ui.widget.DanmakuView.super.isShown()) {
                    master.flame.danmaku.ui.widget.DanmakuView.this.handler.resume();
                } else {
                    master.flame.danmaku.ui.widget.DanmakuView.this.handler.postDelayed(this, master.flame.danmaku.ui.widget.DanmakuView.this.mResumeTryCount * 100);
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void addDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.addDanmaku(baseDanmaku);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void invalidateDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, boolean z) {
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.invalidateDanmaku(baseDanmaku, z);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void removeAllDanmakus(boolean z) {
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.removeAllDanmakus(z);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void removeAllLiveDanmakus() {
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.removeAllLiveDanmakus();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public master.flame.danmaku.danmaku.model.IDanmakus getCurrentVisibleDanmakus() {
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            return drawHandler.getCurrentVisibleDanmakus();
        }
        return null;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void setCallback(master.flame.danmaku.controller.DrawHandler.Callback callback) {
        this.mCallback = callback;
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.setCallback(callback);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void release() {
        stop();
        java.util.LinkedList<java.lang.Long> linkedList = this.mDrawTimes;
        if (linkedList != null) {
            linkedList.clear();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void stop() {
        stopDraw();
    }

    private void stopDraw() {
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        this.handler = null;
        unlockCanvasAndPost();
        if (drawHandler != null) {
            drawHandler.quit();
        }
        android.os.HandlerThread handlerThread = this.mHandlerThread;
        this.mHandlerThread = null;
        if (handlerThread != null) {
            try {
                handlerThread.join();
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
            handlerThread.quit();
        }
    }

    protected android.os.Looper getLooper(int i) {
        int i2;
        android.os.HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mHandlerThread = null;
        }
        if (i == 1) {
            return android.os.Looper.getMainLooper();
        }
        if (i != 2) {
            i2 = i != 3 ? 0 : 19;
        } else {
            i2 = -8;
        }
        android.os.HandlerThread handlerThread2 = new android.os.HandlerThread("DFM Handler Thread #" + i2, i2);
        this.mHandlerThread = handlerThread2;
        handlerThread2.start();
        return this.mHandlerThread.getLooper();
    }

    private void prepare() {
        if (this.handler == null) {
            this.handler = new master.flame.danmaku.controller.DrawHandler(getLooper(this.mDrawingThreadType), this, this.mDanmakuVisible);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void prepare(master.flame.danmaku.danmaku.parser.BaseDanmakuParser baseDanmakuParser, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
        prepare();
        this.handler.setConfig(danmakuContext);
        this.handler.setParser(baseDanmakuParser);
        this.handler.setCallback(this.mCallback);
        this.handler.prepare();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public boolean isPrepared() {
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        return drawHandler != null && drawHandler.isPrepared();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public master.flame.danmaku.danmaku.model.android.DanmakuContext getConfig() {
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler == null) {
            return null;
        }
        return drawHandler.getConfig();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void showFPS(boolean z) {
        this.mShowFps = z;
    }

    private float fps() {
        long jUptimeMillis = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis();
        this.mDrawTimes.addLast(java.lang.Long.valueOf(jUptimeMillis));
        java.lang.Long lPeekFirst = this.mDrawTimes.peekFirst();
        if (lPeekFirst == null) {
            return 0.0f;
        }
        float fLongValue = jUptimeMillis - lPeekFirst.longValue();
        if (this.mDrawTimes.size() > 50) {
            this.mDrawTimes.removeFirst();
        }
        if (fLongValue > 0.0f) {
            return (this.mDrawTimes.size() * 1000) / fLongValue;
        }
        return 0.0f;
    }

    @Override // master.flame.danmaku.controller.IDanmakuViewController
    public long drawDanmakus() {
        if (!this.isSurfaceCreated) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long jUptimeMillis = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis();
        lockCanvas();
        return master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis() - jUptimeMillis;
    }

    private void postInvalidateCompat() {
        this.mRequestRender = true;
        postInvalidateOnAnimation();
    }

    private void lockCanvas() {
        master.flame.danmaku.controller.DrawHandler drawHandler;
        if (this.mDanmakuVisible) {
            postInvalidateCompat();
            synchronized (this.mDrawMonitor) {
                while (!this.mDrawFinished && this.handler != null) {
                    try {
                        this.mDrawMonitor.wait(200L);
                    } catch (java.lang.InterruptedException unused) {
                        if (!this.mDanmakuVisible || (drawHandler = this.handler) == null || drawHandler.isStop()) {
                            break;
                            break;
                            break;
                        }
                        java.lang.Thread.currentThread().interrupt();
                        this.mDrawFinished = false;
                    }
                }
                this.mDrawFinished = false;
            }
        }
    }

    private void lockCanvasAndClear() {
        this.mClearFlag = true;
        lockCanvas();
    }

    private void unlockCanvasAndPost() {
        synchronized (this.mDrawMonitor) {
            this.mDrawFinished = true;
            this.mDrawMonitor.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (!this.mDanmakuVisible && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.mClearFlag) {
            master.flame.danmaku.controller.DrawHelper.clearCanvas(canvas);
            this.mClearFlag = false;
        } else {
            master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
            if (drawHandler != null) {
                master.flame.danmaku.danmaku.renderer.IRenderer.RenderingState renderingStateDraw = drawHandler.draw(canvas);
                if (this.mShowFps) {
                    if (this.mDrawTimes == null) {
                        this.mDrawTimes = new java.util.LinkedList<>();
                    }
                    master.flame.danmaku.controller.DrawHelper.drawFPS(canvas, java.lang.String.format(java.util.Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", java.lang.Float.valueOf(fps()), java.lang.Long.valueOf(getCurrentTime() / 1000), java.lang.Long.valueOf(renderingStateDraw.cacheHitCount), java.lang.Long.valueOf(renderingStateDraw.cacheMissCount)));
                }
            }
        }
        this.mRequestRender = false;
        unlockCanvasAndPost();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.notifyDispSizeChanged(i3 - i, i4 - i2);
        }
        this.isSurfaceCreated = true;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void toggle() {
        if (this.isSurfaceCreated) {
            master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
            if (drawHandler == null) {
                start();
            } else if (drawHandler.isStop()) {
                resume();
            } else {
                pause();
            }
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void pause() {
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.removeCallbacks(this.mResumeRunnable);
            this.handler.pause();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void resume() {
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler != null && drawHandler.isPrepared()) {
            this.mResumeTryCount = 0;
            this.handler.post(this.mResumeRunnable);
        } else if (this.handler == null) {
            restart();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public boolean isPaused() {
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            return drawHandler.isStop();
        }
        return false;
    }

    public void restart() {
        stop();
        start();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void start() {
        start(0L);
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void start(long j) {
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler == null) {
            prepare();
        } else {
            drawHandler.removeCallbacksAndMessages(null);
        }
        this.handler.obtainMessage(1, java.lang.Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        boolean zOnTouchEvent = this.mTouchHelper.onTouchEvent(motionEvent);
        return !zOnTouchEvent ? super.onTouchEvent(motionEvent) : zOnTouchEvent;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void seekTo(java.lang.Long l) {
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.seekTo(l);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void enableDanmakuDrawingCache(boolean z) {
        this.mEnableDanmakuDrwaingCache = z;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView, master.flame.danmaku.controller.IDanmakuViewController
    public boolean isDanmakuDrawingCacheEnabled() {
        return this.mEnableDanmakuDrwaingCache;
    }

    @Override // master.flame.danmaku.controller.IDanmakuViewController
    public boolean isViewReady() {
        return this.isSurfaceCreated;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void show() {
        showAndResumeDrawTask(null);
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void showAndResumeDrawTask(java.lang.Long l) {
        this.mDanmakuVisible = true;
        this.mClearFlag = false;
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler == null) {
            return;
        }
        drawHandler.showDanmakus(l);
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void hide() {
        this.mDanmakuVisible = false;
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler == null) {
            return;
        }
        drawHandler.hideDanmakus(false);
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public long hideAndPauseDrawTask() {
        this.mDanmakuVisible = false;
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler == null) {
            return 0L;
        }
        return drawHandler.hideDanmakus(true);
    }

    @Override // master.flame.danmaku.controller.IDanmakuViewController
    public void clear() {
        if (isViewReady()) {
            if (!this.mDanmakuVisible || java.lang.Thread.currentThread().getId() == this.mUiThreadId) {
                this.mClearFlag = true;
                postInvalidateCompat();
            } else {
                lockCanvasAndClear();
            }
        }
    }

    @Override // android.view.View, master.flame.danmaku.controller.IDanmakuView
    public boolean isShown() {
        return this.mDanmakuVisible && super.isShown();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void setDrawingThreadType(int i) {
        this.mDrawingThreadType = i;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public long getCurrentTime() {
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            return drawHandler.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.controller.IDanmakuView, master.flame.danmaku.controller.IDanmakuViewController
    public boolean isHardwareAccelerated() {
        return super.isHardwareAccelerated();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void clearDanmakusOnScreen() {
        master.flame.danmaku.controller.DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.clearDanmakusOnScreen();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void setOnDanmakuClickListener(master.flame.danmaku.controller.IDanmakuView.OnDanmakuClickListener onDanmakuClickListener) {
        this.mOnDanmakuClickListener = onDanmakuClickListener;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public master.flame.danmaku.controller.IDanmakuView.OnDanmakuClickListener getOnDanmakuClickListener() {
        return this.mOnDanmakuClickListener;
    }
}
