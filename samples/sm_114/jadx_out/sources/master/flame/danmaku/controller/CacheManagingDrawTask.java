package master.flame.danmaku.controller;

/* JADX INFO: loaded from: classes2.dex */
public class CacheManagingDrawTask extends master.flame.danmaku.controller.DrawTask {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_CACHE_SCREEN_SIZE = 3;
    private master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager mCacheManager;
    private master.flame.danmaku.danmaku.model.DanmakuTimer mCacheTimer;
    private final java.lang.Object mDrawingNotify;
    private int mMaxCacheSize;
    private int mRemaininCacheCount;

    public CacheManagingDrawTask(master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext, master.flame.danmaku.controller.IDrawTask.TaskListener taskListener, int i) {
        super(danmakuTimer, danmakuContext, taskListener);
        this.mMaxCacheSize = 2;
        this.mDrawingNotify = new java.lang.Object();
        tv.cjump.jni.NativeBitmapFactory.loadLibs();
        this.mMaxCacheSize = i;
        if (tv.cjump.jni.NativeBitmapFactory.isInNativeAlloc()) {
            this.mMaxCacheSize = i * 2;
        }
        this.mCacheManager = new master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager(i, 3);
        this.mRenderer.setCacheManager(this.mCacheManager);
    }

    @Override // master.flame.danmaku.controller.DrawTask
    protected void initTimer(master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer) {
        this.mTimer = danmakuTimer;
        master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer2 = new master.flame.danmaku.danmaku.model.DanmakuTimer();
        this.mCacheTimer = danmakuTimer2;
        danmakuTimer2.update(danmakuTimer.currMillisecond);
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    public void addDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
        super.addDanmaku(baseDanmaku);
        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager cacheManager = this.mCacheManager;
        if (cacheManager == null) {
            return;
        }
        cacheManager.addDanmaku(baseDanmaku);
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    public void invalidateDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, boolean z) {
        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager cacheManager = this.mCacheManager;
        if (cacheManager == null) {
            super.invalidateDanmaku(baseDanmaku, z);
        } else {
            cacheManager.invalidateDanmaku(baseDanmaku, z);
        }
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    public void removeAllDanmakus(boolean z) {
        super.removeAllDanmakus(z);
        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager cacheManager = this.mCacheManager;
        if (cacheManager != null) {
            cacheManager.requestClearAll();
        }
    }

    @Override // master.flame.danmaku.controller.DrawTask
    protected void onDanmakuRemoved(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
        super.onDanmakuRemoved(baseDanmaku);
        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager cacheManager = this.mCacheManager;
        if (cacheManager != null) {
            int i = this.mRemaininCacheCount + 1;
            this.mRemaininCacheCount = i;
            if (i > 5) {
                cacheManager.requestClearTimeout();
                this.mRemaininCacheCount = 0;
                return;
            }
            return;
        }
        master.flame.danmaku.danmaku.model.IDrawingCache<?> drawingCache = baseDanmaku.getDrawingCache();
        if (drawingCache != null) {
            if (drawingCache.hasReferences()) {
                drawingCache.decreaseReference();
            } else {
                drawingCache.destroy();
            }
            baseDanmaku.cache = null;
        }
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    public master.flame.danmaku.danmaku.renderer.IRenderer.RenderingState draw(master.flame.danmaku.danmaku.model.AbsDisplayer absDisplayer) {
        master.flame.danmaku.danmaku.renderer.IRenderer.RenderingState renderingStateDraw = super.draw(absDisplayer);
        synchronized (this.mDrawingNotify) {
            this.mDrawingNotify.notify();
        }
        if (renderingStateDraw != null && this.mCacheManager != null && renderingStateDraw.totalDanmakuCount - renderingStateDraw.lastTotalDanmakuCount < -20) {
            this.mCacheManager.requestClearTimeout();
            this.mCacheManager.requestBuild(-this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION);
        }
        return renderingStateDraw;
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    public void seek(long j) {
        super.seek(j);
        if (this.mCacheManager == null) {
            start();
        }
        this.mCacheManager.seek(j);
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    public void start() {
        super.start();
        tv.cjump.jni.NativeBitmapFactory.loadLibs();
        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager cacheManager = this.mCacheManager;
        if (cacheManager == null) {
            master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager cacheManager2 = new master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager(this.mMaxCacheSize, 3);
            this.mCacheManager = cacheManager2;
            cacheManager2.begin();
            this.mRenderer.setCacheManager(this.mCacheManager);
            return;
        }
        cacheManager.resume();
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    public void quit() {
        super.quit();
        reset();
        this.mRenderer.setCacheManager(null);
        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager cacheManager = this.mCacheManager;
        if (cacheManager != null) {
            cacheManager.end();
            this.mCacheManager = null;
        }
        tv.cjump.jni.NativeBitmapFactory.releaseLibs();
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    public void prepare() {
        loadDanmakus(this.mParser);
        this.mCacheManager.begin();
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    public void onPlayStateChanged(int i) {
        super.onPlayStateChanged(i);
        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager cacheManager = this.mCacheManager;
        if (cacheManager != null) {
            cacheManager.onPlayStateChanged(i);
        }
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    public void requestSync(long j, long j2, long j3) {
        super.requestSync(j, j2, j3);
        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager cacheManager = this.mCacheManager;
        if (cacheManager != null) {
            cacheManager.seek(j2);
        }
    }

    public class CacheManager implements master.flame.danmaku.danmaku.model.ICacheManager {
        public static final byte RESULT_FAILED = 1;
        public static final byte RESULT_FAILED_OVERSIZE = 2;
        public static final byte RESULT_SUCCESS = 0;
        private static final java.lang.String TAG = "CacheManager";
        master.flame.danmaku.danmaku.model.objectpool.Pool<master.flame.danmaku.danmaku.model.android.DrawingCache> mCachePool;
        master.flame.danmaku.danmaku.model.android.DrawingCachePoolManager mCachePoolManager;
        master.flame.danmaku.danmaku.model.android.Danmakus mCaches = new master.flame.danmaku.danmaku.model.android.Danmakus();
        private boolean mEndFlag;
        private master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.CacheHandler mHandler;
        private int mMaxSize;
        private int mRealSize;
        private int mScreenSize;
        public android.os.HandlerThread mThread;

        public CacheManager(int i, int i2) {
            master.flame.danmaku.danmaku.model.android.DrawingCachePoolManager drawingCachePoolManager = new master.flame.danmaku.danmaku.model.android.DrawingCachePoolManager();
            this.mCachePoolManager = drawingCachePoolManager;
            this.mCachePool = master.flame.danmaku.danmaku.model.objectpool.Pools.finitePool(drawingCachePoolManager, 800);
            this.mEndFlag = false;
            this.mRealSize = 0;
            this.mMaxSize = i;
            this.mScreenSize = i2;
        }

        public void seek(long j) {
            master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler == null) {
                return;
            }
            cacheHandler.requestCancelCaching();
            this.mHandler.removeMessages(3);
            this.mHandler.obtainMessage(5, java.lang.Long.valueOf(j)).sendToTarget();
        }

        @Override // master.flame.danmaku.danmaku.model.ICacheManager
        public void addDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
            if (this.mHandler != null) {
                if (baseDanmaku.isLive) {
                    if (baseDanmaku.forceBuildCacheInSameThread) {
                        if (baseDanmaku.isTimeOut()) {
                            return;
                        }
                        this.mHandler.createCache(baseDanmaku);
                        return;
                    }
                    this.mHandler.obtainMessage(18, baseDanmaku).sendToTarget();
                    return;
                }
                this.mHandler.obtainMessage(2, baseDanmaku).sendToTarget();
            }
        }

        public void invalidateDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, boolean z) {
            master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.requestCancelCaching();
                this.mHandler.obtainMessage(17, baseDanmaku).sendToTarget();
            }
        }

        public void begin() {
            this.mEndFlag = false;
            if (this.mThread == null) {
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("DFM Cache-Building Thread");
                this.mThread = handlerThread;
                handlerThread.start();
            }
            if (this.mHandler == null) {
                this.mHandler = new master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.CacheHandler(this.mThread.getLooper());
            }
            this.mHandler.begin();
        }

        public void end() {
            this.mEndFlag = true;
            synchronized (master.flame.danmaku.controller.CacheManagingDrawTask.this.mDrawingNotify) {
                master.flame.danmaku.controller.CacheManagingDrawTask.this.mDrawingNotify.notifyAll();
            }
            master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.pause();
                this.mHandler = null;
            }
            android.os.HandlerThread handlerThread = this.mThread;
            if (handlerThread != null) {
                try {
                    handlerThread.join();
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
                this.mThread.quit();
                this.mThread = null;
            }
        }

        public void resume() {
            master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.resume();
            } else {
                begin();
            }
        }

        public void onPlayStateChanged(int i) {
            master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.onPlayStateChanged(i == 1);
            }
        }

        public float getPoolPercent() {
            int i = this.mMaxSize;
            if (i == 0) {
                return 0.0f;
            }
            return this.mRealSize / i;
        }

        public boolean isPoolFull() {
            return this.mRealSize + 5120 >= this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            master.flame.danmaku.danmaku.model.android.Danmakus danmakus = this.mCaches;
            if (danmakus != null) {
                master.flame.danmaku.danmaku.model.IDanmakuIterator it = danmakus.iterator();
                while (it.hasNext()) {
                    entryRemoved(true, it.next(), null);
                }
                this.mCaches.clear();
            }
            this.mRealSize = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAllNotInScreen() {
            evictAllNotInScreen(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAllNotInScreen(boolean z) {
            master.flame.danmaku.danmaku.model.android.Danmakus danmakus = this.mCaches;
            if (danmakus != null) {
                master.flame.danmaku.danmaku.model.IDanmakuIterator it = danmakus.iterator();
                while (it.hasNext()) {
                    master.flame.danmaku.danmaku.model.BaseDanmaku next = it.next();
                    master.flame.danmaku.danmaku.model.IDrawingCache<?> iDrawingCache = next.cache;
                    boolean z2 = iDrawingCache != null && iDrawingCache.hasReferences();
                    if (z && z2) {
                        if (iDrawingCache.get() != null) {
                            this.mRealSize -= iDrawingCache.size();
                            iDrawingCache.destroy();
                        }
                        entryRemoved(true, next, null);
                        it.remove();
                    } else if (next.isOutside()) {
                        entryRemoved(true, next, null);
                        it.remove();
                    }
                }
            }
            this.mRealSize = 0;
        }

        protected void entryRemoved(boolean z, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2) {
            master.flame.danmaku.danmaku.model.IDrawingCache<?> drawingCache = baseDanmaku.getDrawingCache();
            if (drawingCache != null) {
                long jClearCache = clearCache(baseDanmaku);
                if (baseDanmaku.isTimeOut()) {
                    master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.getDisplayer().getCacheStuffer().releaseResource(baseDanmaku);
                }
                if (jClearCache <= 0) {
                    return;
                }
                this.mRealSize = (int) (((long) this.mRealSize) - jClearCache);
                this.mCachePool.release((master.flame.danmaku.danmaku.model.android.DrawingCache) drawingCache);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long clearCache(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
            master.flame.danmaku.danmaku.model.IDrawingCache<?> iDrawingCache = baseDanmaku.cache;
            if (iDrawingCache == null) {
                return 0L;
            }
            if (iDrawingCache.hasReferences()) {
                iDrawingCache.decreaseReference();
                baseDanmaku.cache = null;
                return 0L;
            }
            long jSizeOf = sizeOf(baseDanmaku);
            iDrawingCache.destroy();
            baseDanmaku.cache = null;
            return jSizeOf;
        }

        protected int sizeOf(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
            if (baseDanmaku.cache == null || baseDanmaku.cache.hasReferences()) {
                return 0;
            }
            return baseDanmaku.cache.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCachePool() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.DrawingCache drawingCache = (master.flame.danmaku.danmaku.model.android.DrawingCache) this.mCachePool.acquire();
                if (drawingCache == null) {
                    return;
                } else {
                    drawingCache.destroy();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean push(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, boolean z) {
            while (this.mRealSize + i > this.mMaxSize && this.mCaches.size() > 0) {
                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmakuFirst = this.mCaches.first();
                if (!baseDanmakuFirst.isTimeOut()) {
                    if (z) {
                        break;
                    }
                    return false;
                }
                entryRemoved(false, baseDanmakuFirst, baseDanmaku);
                this.mCaches.removeItem(baseDanmakuFirst);
            }
            this.mCaches.addItem(baseDanmaku);
            this.mRealSize += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeOutCaches() {
            clearTimeOutCaches(master.flame.danmaku.controller.CacheManagingDrawTask.this.mTimer.currMillisecond);
        }

        private void clearTimeOutCaches(long j) {
            master.flame.danmaku.danmaku.model.IDanmakuIterator it = this.mCaches.iterator();
            while (it.hasNext() && !this.mEndFlag) {
                master.flame.danmaku.danmaku.model.BaseDanmaku next = it.next();
                if (!next.isTimeOut()) {
                    return;
                }
                synchronized (master.flame.danmaku.controller.CacheManagingDrawTask.this.mDrawingNotify) {
                    try {
                        master.flame.danmaku.controller.CacheManagingDrawTask.this.mDrawingNotify.wait(30L);
                    } catch (java.lang.InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                entryRemoved(false, next, null);
                it.remove();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public master.flame.danmaku.danmaku.model.BaseDanmaku findReuseableCache(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, boolean z, int i) {
            master.flame.danmaku.danmaku.model.IDanmakuIterator it = this.mCaches.iterator();
            int i2 = 0;
            int slopPixel = !z ? master.flame.danmaku.controller.CacheManagingDrawTask.this.mDisp.getSlopPixel() * 2 : 0;
            while (it.hasNext()) {
                int i3 = i2 + 1;
                if (i2 >= i) {
                    return null;
                }
                master.flame.danmaku.danmaku.model.BaseDanmaku next = it.next();
                master.flame.danmaku.danmaku.model.IDrawingCache<?> drawingCache = next.getDrawingCache();
                if (drawingCache != null && drawingCache.get() != null) {
                    if (next.paintWidth != baseDanmaku.paintWidth || next.paintHeight != baseDanmaku.paintHeight || next.underlineColor != baseDanmaku.underlineColor || next.borderColor != baseDanmaku.borderColor || next.textColor != baseDanmaku.textColor || !next.text.equals(baseDanmaku.text) || next.tag != baseDanmaku.tag) {
                        if (z) {
                            continue;
                        } else {
                            if (!next.isTimeOut()) {
                                return null;
                            }
                            if (drawingCache.hasReferences()) {
                                continue;
                            } else {
                                float fWidth = drawingCache.width() - baseDanmaku.paintWidth;
                                float fHeight = drawingCache.height() - baseDanmaku.paintHeight;
                                if (fWidth >= 0.0f) {
                                    float f = slopPixel;
                                    if (fWidth > f || fHeight < 0.0f || fHeight > f) {
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                    return next;
                }
                i2 = i3;
            }
            return null;
        }

        public class CacheHandler extends android.os.Handler {
            public static final int ADD_DANMAKKU = 2;
            public static final int BIND_CACHE = 18;
            public static final int BUILD_CACHES = 3;
            public static final int CLEAR_ALL_CACHES = 7;
            public static final int CLEAR_OUTSIDE_CACHES = 8;
            public static final int CLEAR_OUTSIDE_CACHES_AND_RESET = 9;
            public static final int CLEAR_TIMEOUT_CACHES = 4;
            public static final int DISABLE_CANCEL_FLAG = 19;
            public static final int DISPATCH_ACTIONS = 16;
            private static final int PREPARE = 1;
            public static final int QUIT = 6;
            public static final int REBUILD_CACHE = 17;
            public static final int SEEK = 5;
            private boolean mCancelFlag;
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean mSeekedFlag;

            public CacheHandler(android.os.Looper looper) {
                super(looper);
            }

            public void requestCancelCaching() {
                this.mCancelFlag = true;
            }

            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                int i = message.what;
                switch (i) {
                    case 1:
                        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.evictAllNotInScreen();
                        for (int i2 = 0; i2 < 300; i2++) {
                            master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.mCachePool.release(new master.flame.danmaku.danmaku.model.android.DrawingCache());
                        }
                        break;
                    case 2:
                        addDanmakuAndBuildCache((master.flame.danmaku.danmaku.model.BaseDanmaku) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(master.flame.danmaku.controller.CacheManagingDrawTask.this.mTaskListener == null || master.flame.danmaku.controller.CacheManagingDrawTask.this.mReadyState) || this.mSeekedFlag;
                        prepareCaches(z);
                        if (z) {
                            this.mSeekedFlag = false;
                        }
                        if (master.flame.danmaku.controller.CacheManagingDrawTask.this.mTaskListener == null || master.flame.danmaku.controller.CacheManagingDrawTask.this.mReadyState) {
                            return;
                        }
                        master.flame.danmaku.controller.CacheManagingDrawTask.this.mTaskListener.ready();
                        master.flame.danmaku.controller.CacheManagingDrawTask.this.mReadyState = true;
                        return;
                    case 4:
                        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.clearTimeOutCaches();
                        return;
                    case 5:
                        java.lang.Long l = (java.lang.Long) message.obj;
                        if (l != null) {
                            long jLongValue = l.longValue();
                            long j = master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.currMillisecond;
                            master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.update(jLongValue);
                            this.mSeekedFlag = true;
                            long firstCacheTime = master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.getFirstCacheTime();
                            if (jLongValue > j || firstCacheTime - jLongValue > master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION) {
                                master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.evictAllNotInScreen();
                            } else {
                                master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.clearTimeOutCaches();
                            }
                            prepareCaches(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.evictAll();
                        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.clearCachePool();
                        getLooper().quit();
                        return;
                    case 7:
                        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.evictAll();
                        master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.update(master.flame.danmaku.controller.CacheManagingDrawTask.this.mTimer.currMillisecond - master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION);
                        this.mSeekedFlag = true;
                        return;
                    case 8:
                        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.evictAllNotInScreen(true);
                        master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.update(master.flame.danmaku.controller.CacheManagingDrawTask.this.mTimer.currMillisecond);
                        return;
                    case 9:
                        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.evictAllNotInScreen(true);
                        master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.update(master.flame.danmaku.controller.CacheManagingDrawTask.this.mTimer.currMillisecond);
                        master.flame.danmaku.controller.CacheManagingDrawTask.this.requestClear();
                        return;
                    default:
                        switch (i) {
                            case 17:
                                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku = (master.flame.danmaku.danmaku.model.BaseDanmaku) message.obj;
                                if (baseDanmaku != null) {
                                    master.flame.danmaku.danmaku.model.IDrawingCache<?> drawingCache = baseDanmaku.getDrawingCache();
                                    if ((baseDanmaku.requestFlags & 1) == 0 && drawingCache != null && drawingCache.get() != null && !drawingCache.hasReferences()) {
                                        baseDanmaku.cache = master.flame.danmaku.danmaku.util.DanmakuUtils.buildDanmakuDrawingCache(baseDanmaku, master.flame.danmaku.controller.CacheManagingDrawTask.this.mDisp, (master.flame.danmaku.danmaku.model.android.DrawingCache) baseDanmaku.cache);
                                        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.push(baseDanmaku, 0, true);
                                    } else if (baseDanmaku.isLive) {
                                        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.clearCache(baseDanmaku);
                                        createCache(baseDanmaku);
                                    } else {
                                        if (drawingCache != null && drawingCache.hasReferences()) {
                                            drawingCache.destroy();
                                        }
                                        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.entryRemoved(true, baseDanmaku, null);
                                        addDanmakuAndBuildCache(baseDanmaku);
                                    }
                                }
                                break;
                            case 18:
                                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2 = (master.flame.danmaku.danmaku.model.BaseDanmaku) message.obj;
                                if (!baseDanmaku2.isTimeOut()) {
                                    createCache(baseDanmaku2);
                                    if (baseDanmaku2.cache != null) {
                                        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.push(baseDanmaku2, baseDanmaku2.cache.size(), true);
                                    }
                                }
                                break;
                            case 19:
                                this.mCancelFlag = false;
                                break;
                        }
                        return;
                }
                long jDispatchAction = dispatchAction();
                if (jDispatchAction <= 0) {
                    jDispatchAction = master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION / 2;
                }
                sendEmptyMessageDelayed(16, jDispatchAction);
            }

            private long dispatchAction() {
                if (master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.currMillisecond <= master.flame.danmaku.controller.CacheManagingDrawTask.this.mTimer.currMillisecond - master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION) {
                    master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.evictAllNotInScreen();
                    master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.update(master.flame.danmaku.controller.CacheManagingDrawTask.this.mTimer.currMillisecond);
                    sendEmptyMessage(3);
                    return 0L;
                }
                float poolPercent = master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.getPoolPercent();
                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmakuFirst = master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.mCaches.first();
                long actualTime = baseDanmakuFirst != null ? baseDanmakuFirst.getActualTime() - master.flame.danmaku.controller.CacheManagingDrawTask.this.mTimer.currMillisecond : 0L;
                long j = master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION * 2;
                if (poolPercent < 0.6f && actualTime > master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION) {
                    master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.update(master.flame.danmaku.controller.CacheManagingDrawTask.this.mTimer.currMillisecond);
                    removeMessages(3);
                    sendEmptyMessage(3);
                    return 0L;
                }
                if (poolPercent > 0.4f && actualTime < (-j)) {
                    removeMessages(4);
                    sendEmptyMessage(4);
                    return 0L;
                }
                if (poolPercent >= 0.9f) {
                    return 0L;
                }
                long j2 = master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.currMillisecond - master.flame.danmaku.controller.CacheManagingDrawTask.this.mTimer.currMillisecond;
                if (baseDanmakuFirst != null && baseDanmakuFirst.isTimeOut() && j2 < (-master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION)) {
                    master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.update(master.flame.danmaku.controller.CacheManagingDrawTask.this.mTimer.currMillisecond);
                    sendEmptyMessage(8);
                    sendEmptyMessage(3);
                    return 0L;
                }
                if (j2 > j) {
                    return 0L;
                }
                removeMessages(3);
                sendEmptyMessage(3);
                return 0L;
            }

            private void releaseDanmakuCache(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.android.DrawingCache drawingCache) {
                if (drawingCache == null) {
                    drawingCache = (master.flame.danmaku.danmaku.model.android.DrawingCache) baseDanmaku.cache;
                }
                baseDanmaku.cache = null;
                if (drawingCache == null) {
                    return;
                }
                drawingCache.destroy();
                master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.mCachePool.release(drawingCache);
            }

            private void preMeasure() {
                master.flame.danmaku.danmaku.model.IDanmakus iDanmakusSubnew;
                try {
                    long j = master.flame.danmaku.controller.CacheManagingDrawTask.this.mTimer.currMillisecond;
                    iDanmakusSubnew = master.flame.danmaku.controller.CacheManagingDrawTask.this.danmakuList.subnew(j - master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION, (master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION * 2) + j);
                } catch (java.lang.Exception unused) {
                    iDanmakusSubnew = null;
                }
                if (iDanmakusSubnew == null || iDanmakusSubnew.isEmpty()) {
                    return;
                }
                master.flame.danmaku.danmaku.model.IDanmakuIterator it = iDanmakusSubnew.iterator();
                while (it.hasNext() && !this.mPause) {
                    master.flame.danmaku.danmaku.model.BaseDanmaku next = it.next();
                    if (!next.hasPassedFilter()) {
                        master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFilters.filter(next, 0, 0, null, true, master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext);
                    }
                    if (!next.isFiltered()) {
                        if (!next.isMeasured()) {
                            next.measure(master.flame.danmaku.controller.CacheManagingDrawTask.this.mDisp, true);
                        }
                        if (!next.isPrepared()) {
                            next.prepare(master.flame.danmaku.controller.CacheManagingDrawTask.this.mDisp, true);
                        }
                    }
                }
            }

            /* JADX WARN: Code duplicated, block: B:109:0x019e A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:110:0x019e A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:84:0x0180 A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:85:0x0182  */
            private long prepareCaches(boolean z) {
                long j;
                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku;
                long j2;
                long jUptimeMillis;
                master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.CacheHandler cacheHandler = this;
                cacheHandler.preMeasure();
                long j3 = master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.currMillisecond;
                long j4 = (master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION * ((long) master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.mScreenSize)) + j3;
                long j5 = 0;
                if (j4 < master.flame.danmaku.controller.CacheManagingDrawTask.this.mTimer.currMillisecond) {
                    return 0L;
                }
                long jUptimeMillis2 = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis();
                master.flame.danmaku.danmaku.model.IDanmakus iDanmakusSubnew = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    j = j5;
                    try {
                        iDanmakusSubnew = master.flame.danmaku.controller.CacheManagingDrawTask.this.danmakuList.subnew(j3, j4);
                    } catch (java.lang.Exception unused) {
                        master.flame.danmaku.danmaku.util.SystemClock.sleep(10L);
                        z2 = true;
                    }
                    i++;
                    if (i >= 3 || iDanmakusSubnew != null || !z2) {
                        break;
                    }
                    j5 = j;
                }
                if (iDanmakusSubnew == null) {
                    master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.update(j4);
                    return j;
                }
                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmakuFirst = iDanmakusSubnew.first();
                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmakuLast = iDanmakusSubnew.last();
                if (baseDanmakuFirst == null || baseDanmakuLast == null) {
                    master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.update(j4);
                    return j;
                }
                long actualTime = baseDanmakuFirst.getActualTime() - master.flame.danmaku.controller.CacheManagingDrawTask.this.mTimer.currMillisecond;
                long jMin = java.lang.Math.min(100L, actualTime < j ? 30L : ((actualTime * 10) / master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION) + 30);
                if (z) {
                    jMin = j;
                }
                master.flame.danmaku.danmaku.model.IDanmakuIterator it = iDanmakusSubnew.iterator();
                int size = iDanmakusSubnew.size();
                int i2 = 0;
                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2 = null;
                int i3 = 0;
                while (!cacheHandler.mPause && !cacheHandler.mCancelFlag && it.hasNext()) {
                    master.flame.danmaku.danmaku.model.BaseDanmaku next = it.next();
                    if (baseDanmakuLast.getActualTime() < master.flame.danmaku.controller.CacheManagingDrawTask.this.mTimer.currMillisecond) {
                        cacheHandler = this;
                        baseDanmaku = next;
                    } else {
                        master.flame.danmaku.danmaku.model.IDrawingCache<?> drawingCache = next.getDrawingCache();
                        if ((drawingCache == null || drawingCache.get() == null) && (z || (!next.isTimeOut() && next.isOutside()))) {
                            cacheHandler = this;
                            if (!next.hasPassedFilter()) {
                                master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFilters.filter(next, i3, size, null, true, master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext);
                            }
                            baseDanmaku = next;
                            if (baseDanmaku.priority != 0 || !baseDanmaku.isFiltered()) {
                                if (baseDanmaku.getType() == 1) {
                                    j2 = j3;
                                    int actualTime2 = (int) ((baseDanmaku.getActualTime() - j3) / master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION);
                                    if (i2 == actualTime2) {
                                        i3++;
                                    } else {
                                        i2 = actualTime2;
                                        i3 = 0;
                                    }
                                } else {
                                    j2 = j3;
                                }
                                if (!z && !cacheHandler.mIsPlayerPause) {
                                    try {
                                        synchronized (master.flame.danmaku.controller.CacheManagingDrawTask.this.mDrawingNotify) {
                                            master.flame.danmaku.controller.CacheManagingDrawTask.this.mDrawingNotify.wait(jMin);
                                        }
                                        if (cacheHandler.buildCache(baseDanmaku, false) != 1) {
                                            if (!z) {
                                                jUptimeMillis = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis() - jUptimeMillis2;
                                                master.flame.danmaku.danmaku.model.android.DanmakuFactory danmakuFactory = master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory;
                                                if (jUptimeMillis >= ((long) master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.mScreenSize) * master.flame.danmaku.danmaku.model.android.DanmakuFactory.COMMON_DANMAKU_DURATION) {
                                                }
                                            }
                                            baseDanmaku2 = baseDanmaku;
                                            j3 = j2;
                                        }
                                    } catch (java.lang.InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } else if (cacheHandler.buildCache(baseDanmaku, false) != 1) {
                                    if (!z) {
                                        jUptimeMillis = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis() - jUptimeMillis2;
                                        master.flame.danmaku.danmaku.model.android.DanmakuFactory danmakuFactory2 = master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory;
                                        if (jUptimeMillis >= ((long) master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.mScreenSize) * master.flame.danmaku.danmaku.model.android.DanmakuFactory.COMMON_DANMAKU_DURATION) {
                                        }
                                    }
                                    baseDanmaku2 = baseDanmaku;
                                    j3 = j2;
                                }
                            }
                        } else {
                            cacheHandler = this;
                            baseDanmaku = next;
                        }
                        baseDanmaku2 = baseDanmaku;
                    }
                    baseDanmaku2 = baseDanmaku;
                }
                long jUptimeMillis3 = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis() - jUptimeMillis2;
                if (baseDanmaku2 != null) {
                    master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.update(baseDanmaku2.getActualTime());
                } else {
                    master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.update(j4);
                }
                return jUptimeMillis3;
            }

            public boolean createCache(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
                master.flame.danmaku.danmaku.model.android.DrawingCache drawingCacheBuildDanmakuDrawingCache;
                if (!baseDanmaku.isMeasured()) {
                    baseDanmaku.measure(master.flame.danmaku.controller.CacheManagingDrawTask.this.mDisp, true);
                }
                try {
                    drawingCacheBuildDanmakuDrawingCache = (master.flame.danmaku.danmaku.model.android.DrawingCache) master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.mCachePool.acquire();
                    try {
                        drawingCacheBuildDanmakuDrawingCache = master.flame.danmaku.danmaku.util.DanmakuUtils.buildDanmakuDrawingCache(baseDanmaku, master.flame.danmaku.controller.CacheManagingDrawTask.this.mDisp, drawingCacheBuildDanmakuDrawingCache);
                        baseDanmaku.cache = drawingCacheBuildDanmakuDrawingCache;
                        return true;
                    } catch (java.lang.Exception unused) {
                        if (drawingCacheBuildDanmakuDrawingCache != null) {
                            master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.mCachePool.release(drawingCacheBuildDanmakuDrawingCache);
                        }
                        baseDanmaku.cache = null;
                        return false;
                    } catch (java.lang.OutOfMemoryError unused2) {
                        if (drawingCacheBuildDanmakuDrawingCache != null) {
                            master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.mCachePool.release(drawingCacheBuildDanmakuDrawingCache);
                        }
                        baseDanmaku.cache = null;
                        return false;
                    }
                } catch (java.lang.Exception unused3) {
                    drawingCacheBuildDanmakuDrawingCache = null;
                } catch (java.lang.OutOfMemoryError unused4) {
                    drawingCacheBuildDanmakuDrawingCache = null;
                }
            }

            private byte buildCache(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, boolean z) {
                if (!baseDanmaku.isMeasured()) {
                    baseDanmaku.measure(master.flame.danmaku.controller.CacheManagingDrawTask.this.mDisp, true);
                }
                master.flame.danmaku.danmaku.model.android.DrawingCache drawingCache = null;
                try {
                    master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmakuFindReuseableCache = master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.findReuseableCache(baseDanmaku, true, 20);
                    master.flame.danmaku.danmaku.model.android.DrawingCache drawingCache2 = baseDanmakuFindReuseableCache != null ? (master.flame.danmaku.danmaku.model.android.DrawingCache) baseDanmakuFindReuseableCache.cache : null;
                    try {
                        if (drawingCache2 == null) {
                            master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmakuFindReuseableCache2 = master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.findReuseableCache(baseDanmaku, false, 50);
                            if (baseDanmakuFindReuseableCache2 != null) {
                                drawingCache2 = (master.flame.danmaku.danmaku.model.android.DrawingCache) baseDanmakuFindReuseableCache2.cache;
                            }
                            if (drawingCache2 != null) {
                                baseDanmakuFindReuseableCache2.cache = null;
                                baseDanmaku.cache = master.flame.danmaku.danmaku.util.DanmakuUtils.buildDanmakuDrawingCache(baseDanmaku, master.flame.danmaku.controller.CacheManagingDrawTask.this.mDisp, drawingCache2);
                                master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheManager.push(baseDanmaku, 0, z);
                                return (byte) 0;
                            }
                            if (!z) {
                                if (master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.mRealSize + master.flame.danmaku.danmaku.util.DanmakuUtils.getCacheSize((int) baseDanmaku.paintWidth, (int) baseDanmaku.paintHeight) > master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.mMaxSize) {
                                    return (byte) 1;
                                }
                            }
                            master.flame.danmaku.danmaku.model.android.DrawingCache drawingCacheBuildDanmakuDrawingCache = master.flame.danmaku.danmaku.util.DanmakuUtils.buildDanmakuDrawingCache(baseDanmaku, master.flame.danmaku.controller.CacheManagingDrawTask.this.mDisp, (master.flame.danmaku.danmaku.model.android.DrawingCache) master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.mCachePool.acquire());
                            baseDanmaku.cache = drawingCacheBuildDanmakuDrawingCache;
                            boolean zPush = master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheManager.push(baseDanmaku, master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.this.sizeOf(baseDanmaku), z);
                            if (!zPush) {
                                releaseDanmakuCache(baseDanmaku, drawingCacheBuildDanmakuDrawingCache);
                            }
                            return !zPush ? (byte) 1 : (byte) 0;
                        }
                        drawingCache2.increaseReference();
                        baseDanmaku.cache = drawingCache2;
                        master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheManager.push(baseDanmaku, 0, z);
                        return (byte) 0;
                    } catch (java.lang.Exception unused) {
                        drawingCache = drawingCache2;
                        releaseDanmakuCache(baseDanmaku, drawingCache);
                        return (byte) 1;
                    } catch (java.lang.OutOfMemoryError unused2) {
                        drawingCache = drawingCache2;
                        releaseDanmakuCache(baseDanmaku, drawingCache);
                        return (byte) 1;
                    }
                } catch (java.lang.Exception unused3) {
                } catch (java.lang.OutOfMemoryError unused4) {
                }
            }

            private final void addDanmakuAndBuildCache(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
                if (baseDanmaku.isTimeOut()) {
                    return;
                }
                if (baseDanmaku.getActualTime() <= master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.currMillisecond + master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION || baseDanmaku.isLive) {
                    if (baseDanmaku.priority == 0 && baseDanmaku.isFiltered()) {
                        return;
                    }
                    master.flame.danmaku.danmaku.model.IDrawingCache<?> drawingCache = baseDanmaku.getDrawingCache();
                    if (drawingCache == null || drawingCache.get() == null) {
                        buildCache(baseDanmaku, true);
                    }
                }
            }

            public void begin() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION);
            }

            public void pause() {
                this.mPause = true;
                removeCallbacksAndMessages(null);
                sendEmptyMessage(6);
            }

            public void resume() {
                sendEmptyMessage(19);
                this.mPause = false;
                removeMessages(16);
                sendEmptyMessage(16);
                sendEmptyMessageDelayed(4, master.flame.danmaku.controller.CacheManagingDrawTask.this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION);
            }

            public boolean isPause() {
                return this.mPause;
            }

            public void requestBuildCacheAndDraw(long j) {
                removeMessages(3);
                this.mSeekedFlag = true;
                sendEmptyMessage(19);
                master.flame.danmaku.controller.CacheManagingDrawTask.this.mCacheTimer.update(master.flame.danmaku.controller.CacheManagingDrawTask.this.mTimer.currMillisecond + j);
                sendEmptyMessage(3);
            }

            public void onPlayStateChanged(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long getFirstCacheTime() {
            master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmakuFirst;
            master.flame.danmaku.danmaku.model.android.Danmakus danmakus = this.mCaches;
            if (danmakus == null || danmakus.size() <= 0 || (baseDanmakuFirst = this.mCaches.first()) == null) {
                return 0L;
            }
            return baseDanmakuFirst.getActualTime();
        }

        public void requestBuild(long j) {
            master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.requestBuildCacheAndDraw(j);
            }
        }

        public void requestClearAll() {
            master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler == null) {
                return;
            }
            cacheHandler.removeMessages(3);
            this.mHandler.removeMessages(19);
            this.mHandler.requestCancelCaching();
            this.mHandler.removeMessages(7);
            this.mHandler.sendEmptyMessage(7);
        }

        public void requestClearUnused() {
            master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler == null) {
                return;
            }
            cacheHandler.removeMessages(9);
            this.mHandler.sendEmptyMessage(9);
        }

        public void requestClearTimeout() {
            master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler == null) {
                return;
            }
            cacheHandler.removeMessages(4);
            this.mHandler.sendEmptyMessage(4);
        }

        public void post(java.lang.Runnable runnable) {
            master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager.CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler == null) {
                return;
            }
            cacheHandler.post(runnable);
        }
    }

    @Override // master.flame.danmaku.controller.DrawTask
    public boolean onDanmakuConfigChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext, master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag danmakuConfigTag, java.lang.Object... objArr) {
        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager cacheManager;
        java.lang.Object obj;
        master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager cacheManager2;
        if (!super.handleOnDanmakuConfigChanged(danmakuContext, danmakuConfigTag, objArr)) {
            if (master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.mDisp.resetSlopPixel(this.mContext.scaleTextSize);
                requestClear();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && (obj = objArr[0]) != null && ((!(obj instanceof java.lang.Boolean) || ((java.lang.Boolean) obj).booleanValue()) && (cacheManager2 = this.mCacheManager) != null)) {
                    cacheManager2.requestBuild(0L);
                }
                requestClear();
            } else if (master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.mDisp.resetSlopPixel(this.mContext.scaleTextSize);
                }
                master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager cacheManager3 = this.mCacheManager;
                if (cacheManager3 != null) {
                    cacheManager3.requestClearAll();
                    this.mCacheManager.requestBuild(-this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION);
                }
            } else {
                master.flame.danmaku.controller.CacheManagingDrawTask.CacheManager cacheManager4 = this.mCacheManager;
                if (cacheManager4 != null) {
                    cacheManager4.requestClearUnused();
                    this.mCacheManager.requestBuild(0L);
                }
            }
        }
        if (this.mTaskListener == null || (cacheManager = this.mCacheManager) == null) {
            return true;
        }
        cacheManager.post(new java.lang.Runnable() { // from class: master.flame.danmaku.controller.CacheManagingDrawTask.1
            @Override // java.lang.Runnable
            public void run() {
                master.flame.danmaku.controller.CacheManagingDrawTask.this.mTaskListener.onDanmakuConfigChanged();
            }
        });
        return true;
    }
}
