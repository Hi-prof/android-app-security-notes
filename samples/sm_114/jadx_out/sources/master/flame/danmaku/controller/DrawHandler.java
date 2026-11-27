package master.flame.danmaku.controller;

/* JADX INFO: loaded from: classes2.dex */
public class DrawHandler extends android.os.Handler {
    private static final int CLEAR_DANMAKUS_ON_SCREEN = 13;
    private static final int HIDE_DANMAKUS = 9;
    private static final long INDEFINITE_TIME = 10000000;
    private static final int MAX_RECORD_SIZE = 500;
    private static final int NOTIFY_DISP_SIZE_CHANGED = 10;
    private static final int NOTIFY_RENDERING = 11;
    private static final int PAUSE = 7;
    public static final int PREPARE = 5;
    private static final int QUIT = 6;
    public static final int RESUME = 3;
    public static final int SEEK_POS = 4;
    private static final int SHOW_DANMAKUS = 8;
    public static final int START = 1;
    public static final int UPDATE = 2;
    private static final int UPDATE_WHEN_PAUSED = 12;
    public master.flame.danmaku.controller.IDrawTask drawTask;
    private master.flame.danmaku.controller.DrawHandler.Callback mCallback;
    private master.flame.danmaku.danmaku.model.android.DanmakuContext mContext;
    private long mCordonTime;
    private long mCordonTime2;
    private master.flame.danmaku.controller.IDanmakuViewController mDanmakuView;
    private boolean mDanmakusVisible;
    private long mDesireSeekingTime;
    private master.flame.danmaku.danmaku.model.AbsDisplayer mDisp;
    private java.util.LinkedList<java.lang.Long> mDrawTimes;
    private long mFrameUpdateRate;
    private boolean mIdleSleep;
    private boolean mInSeekingAction;
    private boolean mInSyncAction;
    private boolean mInWaitingState;
    private long mLastDeltaTime;
    private master.flame.danmaku.danmaku.parser.BaseDanmakuParser mParser;
    private boolean mReady;
    private long mRemainingTime;
    private final master.flame.danmaku.danmaku.renderer.IRenderer.RenderingState mRenderingState;
    private master.flame.danmaku.controller.UpdateThread mThread;
    private long mThresholdTime;
    private long mTimeBase;
    private final boolean mUpdateInNewThread;
    private long pausedPosition;
    private boolean quitFlag;
    private master.flame.danmaku.danmaku.model.DanmakuTimer timer;

    public interface Callback {
        void danmakuShown(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku);

        void drawingFinished();

        void prepared();

        void updateTimer(master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer);
    }

    public DrawHandler(android.os.Looper looper, master.flame.danmaku.controller.IDanmakuViewController iDanmakuViewController, boolean z) {
        super(looper);
        this.pausedPosition = 0L;
        this.quitFlag = true;
        this.timer = new master.flame.danmaku.danmaku.model.DanmakuTimer();
        this.mDanmakusVisible = true;
        this.mRenderingState = new master.flame.danmaku.danmaku.renderer.IRenderer.RenderingState();
        this.mDrawTimes = new java.util.LinkedList<>();
        this.mCordonTime = 30L;
        this.mCordonTime2 = 60L;
        this.mFrameUpdateRate = 16L;
        this.mUpdateInNewThread = java.lang.Runtime.getRuntime().availableProcessors() > 3;
        this.mIdleSleep = true ^ tv.cjump.jni.DeviceUtils.isProblemBoxDevice();
        bindView(iDanmakuViewController);
        if (z) {
            showDanmakus(null);
        } else {
            hideDanmakus(false);
        }
        this.mDanmakusVisible = z;
    }

    private void bindView(master.flame.danmaku.controller.IDanmakuViewController iDanmakuViewController) {
        this.mDanmakuView = iDanmakuViewController;
    }

    public void setConfig(master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
        this.mContext = danmakuContext;
    }

    public void setParser(master.flame.danmaku.danmaku.parser.BaseDanmakuParser baseDanmakuParser) {
        this.mParser = baseDanmakuParser;
    }

    public void setCallback(master.flame.danmaku.controller.DrawHandler.Callback callback) {
        this.mCallback = callback;
    }

    public void quit() {
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.quitFlag;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:102:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00db  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:66:0x0101  */
    /* JADX WARN: Code duplicated, block: B:69:0x010e  */
    /* JADX WARN: Code duplicated, block: B:88:0x0149  */
    /* JADX WARN: Code duplicated, block: B:89:0x0150  */
    /* JADX WARN: Code duplicated, block: B:92:0x0157  */
    /* JADX WARN: Code duplicated, block: B:94:0x0182  */
    /* JADX WARN: Code duplicated, block: B:98:0x0199  */
    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        master.flame.danmaku.controller.IDrawTask iDrawTask;
        java.lang.Long l;
        master.flame.danmaku.controller.IDrawTask iDrawTask2;
        java.lang.Long l2;
        master.flame.danmaku.controller.IDrawTask iDrawTask3;
        master.flame.danmaku.danmaku.parser.BaseDanmakuParser baseDanmakuParser;
        master.flame.danmaku.controller.IDrawTask iDrawTask4;
        boolean z;
        master.flame.danmaku.controller.IDanmakuViewController iDanmakuViewController;
        master.flame.danmaku.controller.IDrawTask iDrawTask5;
        int i = message.what;
        switch (i) {
            case 1:
                l2 = (java.lang.Long) message.obj;
                if (l2 != null) {
                    this.pausedPosition = l2.longValue();
                } else {
                    this.pausedPosition = 0L;
                }
                if (i == 4) {
                    this.quitFlag = true;
                    quitUpdateThread();
                    l = (java.lang.Long) message.obj;
                    this.mTimeBase -= l.longValue() - this.timer.currMillisecond;
                    this.timer.update(l.longValue());
                    this.mContext.mGlobalFlagValues.updateMeasureFlag();
                    iDrawTask2 = this.drawTask;
                    if (iDrawTask2 != null) {
                        iDrawTask2.seek(l.longValue());
                    }
                    this.pausedPosition = l.longValue();
                }
                removeMessages(7);
                this.quitFlag = false;
                if (this.mReady) {
                    this.mRenderingState.reset();
                    this.mDrawTimes.clear();
                    long jUptimeMillis = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis();
                    long j = this.pausedPosition;
                    this.mTimeBase = jUptimeMillis - j;
                    this.timer.update(j);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.drawTask.start();
                    notifyRendering();
                    this.mInSeekingAction = false;
                    iDrawTask = this.drawTask;
                    if (iDrawTask != null) {
                        iDrawTask.onPlayStateChanged(1);
                    }
                } else {
                    sendEmptyMessageDelayed(3, 100L);
                }
                break;
            case 2:
                if (this.mUpdateInNewThread) {
                    updateInNewThread();
                } else {
                    updateInCurrentThread();
                }
                break;
            case 3:
                removeMessages(7);
                this.quitFlag = false;
                if (this.mReady) {
                    this.mRenderingState.reset();
                    this.mDrawTimes.clear();
                    long jUptimeMillis2 = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis();
                    long j2 = this.pausedPosition;
                    this.mTimeBase = jUptimeMillis2 - j2;
                    this.timer.update(j2);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.drawTask.start();
                    notifyRendering();
                    this.mInSeekingAction = false;
                    iDrawTask = this.drawTask;
                    if (iDrawTask != null) {
                        iDrawTask.onPlayStateChanged(1);
                    }
                } else {
                    sendEmptyMessageDelayed(3, 100L);
                }
                break;
            case 4:
                if (i == 4) {
                    this.quitFlag = true;
                    quitUpdateThread();
                    l = (java.lang.Long) message.obj;
                    this.mTimeBase -= l.longValue() - this.timer.currMillisecond;
                    this.timer.update(l.longValue());
                    this.mContext.mGlobalFlagValues.updateMeasureFlag();
                    iDrawTask2 = this.drawTask;
                    if (iDrawTask2 != null) {
                        iDrawTask2.seek(l.longValue());
                    }
                    this.pausedPosition = l.longValue();
                }
                removeMessages(7);
                this.quitFlag = false;
                if (this.mReady) {
                    this.mRenderingState.reset();
                    this.mDrawTimes.clear();
                    long jUptimeMillis3 = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis();
                    long j3 = this.pausedPosition;
                    this.mTimeBase = jUptimeMillis3 - j3;
                    this.timer.update(j3);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.drawTask.start();
                    notifyRendering();
                    this.mInSeekingAction = false;
                    iDrawTask = this.drawTask;
                    if (iDrawTask != null) {
                        iDrawTask.onPlayStateChanged(1);
                    }
                } else {
                    sendEmptyMessageDelayed(3, 100L);
                }
                break;
            case 5:
                this.mTimeBase = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis();
                if (this.mParser == null || !this.mDanmakuView.isViewReady()) {
                    sendEmptyMessageDelayed(5, 100L);
                } else {
                    prepare(new java.lang.Runnable() { // from class: master.flame.danmaku.controller.DrawHandler.1
                        @Override // java.lang.Runnable
                        public void run() {
                            master.flame.danmaku.controller.DrawHandler.this.pausedPosition = 0L;
                            master.flame.danmaku.controller.DrawHandler.this.mReady = true;
                            if (master.flame.danmaku.controller.DrawHandler.this.mCallback != null) {
                                master.flame.danmaku.controller.DrawHandler.this.mCallback.prepared();
                            }
                        }
                    });
                }
                break;
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.quitFlag = true;
                syncTimerIfNeeded();
                this.pausedPosition = this.timer.currMillisecond;
                if (this.mThread != null) {
                    notifyRendering();
                    quitUpdateThread();
                }
                if (i == 6) {
                    iDrawTask3 = this.drawTask;
                    if (iDrawTask3 != null) {
                        iDrawTask3.quit();
                    }
                    baseDanmakuParser = this.mParser;
                    if (baseDanmakuParser != null) {
                        baseDanmakuParser.release();
                    }
                    if (getLooper() != android.os.Looper.getMainLooper()) {
                        getLooper().quit();
                    }
                }
                break;
            case 7:
                removeMessages(3);
                removeMessages(2);
                iDrawTask4 = this.drawTask;
                if (iDrawTask4 != null) {
                    iDrawTask4.onPlayStateChanged(2);
                }
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.quitFlag = true;
                syncTimerIfNeeded();
                this.pausedPosition = this.timer.currMillisecond;
                if (this.mThread != null) {
                    notifyRendering();
                    quitUpdateThread();
                }
                if (i == 6) {
                    iDrawTask3 = this.drawTask;
                    if (iDrawTask3 != null) {
                        iDrawTask3.quit();
                    }
                    baseDanmakuParser = this.mParser;
                    if (baseDanmakuParser != null) {
                        baseDanmakuParser.release();
                    }
                    if (getLooper() != android.os.Looper.getMainLooper()) {
                        getLooper().quit();
                    }
                }
                break;
            case 8:
                this.mDanmakusVisible = true;
                java.lang.Long l3 = (java.lang.Long) message.obj;
                master.flame.danmaku.controller.IDrawTask iDrawTask6 = this.drawTask;
                if (iDrawTask6 == null) {
                    z = false;
                } else if (l3 == null) {
                    this.timer.update(getCurrentTime());
                    this.drawTask.requestClear();
                    z = false;
                } else {
                    iDrawTask6.start();
                    this.drawTask.seek(l3.longValue());
                    this.drawTask.requestClear();
                    z = true;
                }
                if (this.quitFlag && (iDanmakuViewController = this.mDanmakuView) != null) {
                    iDanmakuViewController.drawDanmakus();
                }
                notifyRendering();
                if (!z) {
                }
                l2 = (java.lang.Long) message.obj;
                if (l2 != null) {
                    this.pausedPosition = l2.longValue();
                } else {
                    this.pausedPosition = 0L;
                }
                if (i == 4) {
                    this.quitFlag = true;
                    quitUpdateThread();
                    l = (java.lang.Long) message.obj;
                    this.mTimeBase -= l.longValue() - this.timer.currMillisecond;
                    this.timer.update(l.longValue());
                    this.mContext.mGlobalFlagValues.updateMeasureFlag();
                    iDrawTask2 = this.drawTask;
                    if (iDrawTask2 != null) {
                        iDrawTask2.seek(l.longValue());
                    }
                    this.pausedPosition = l.longValue();
                }
                removeMessages(7);
                this.quitFlag = false;
                if (this.mReady) {
                    this.mRenderingState.reset();
                    this.mDrawTimes.clear();
                    long jUptimeMillis4 = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis();
                    long j4 = this.pausedPosition;
                    this.mTimeBase = jUptimeMillis4 - j4;
                    this.timer.update(j4);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.drawTask.start();
                    notifyRendering();
                    this.mInSeekingAction = false;
                    iDrawTask = this.drawTask;
                    if (iDrawTask != null) {
                        iDrawTask.onPlayStateChanged(1);
                    }
                } else {
                    sendEmptyMessageDelayed(3, 100L);
                }
                break;
            case 9:
                this.mDanmakusVisible = false;
                master.flame.danmaku.controller.IDanmakuViewController iDanmakuViewController2 = this.mDanmakuView;
                if (iDanmakuViewController2 != null) {
                    iDanmakuViewController2.clear();
                }
                master.flame.danmaku.controller.IDrawTask iDrawTask7 = this.drawTask;
                if (iDrawTask7 != null) {
                    iDrawTask7.requestClear();
                    this.drawTask.requestHide();
                }
                java.lang.Boolean bool = (java.lang.Boolean) message.obj;
                if (bool.booleanValue() && (iDrawTask5 = this.drawTask) != null) {
                    iDrawTask5.quit();
                }
                if (!bool.booleanValue()) {
                }
                removeMessages(3);
                removeMessages(2);
                iDrawTask4 = this.drawTask;
                if (iDrawTask4 != null) {
                    iDrawTask4.onPlayStateChanged(2);
                }
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.quitFlag = true;
                syncTimerIfNeeded();
                this.pausedPosition = this.timer.currMillisecond;
                if (this.mThread != null) {
                    notifyRendering();
                    quitUpdateThread();
                }
                if (i == 6) {
                    iDrawTask3 = this.drawTask;
                    if (iDrawTask3 != null) {
                        iDrawTask3.quit();
                    }
                    baseDanmakuParser = this.mParser;
                    if (baseDanmakuParser != null) {
                        baseDanmakuParser.release();
                    }
                    if (getLooper() != android.os.Looper.getMainLooper()) {
                        getLooper().quit();
                    }
                }
                break;
            case 10:
                this.mContext.mDanmakuFactory.notifyDispSizeChanged(this.mContext);
                java.lang.Boolean bool2 = (java.lang.Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.mContext.mGlobalFlagValues.updateMeasureFlag();
                    this.mContext.mGlobalFlagValues.updateVisibleFlag();
                    this.drawTask.requestClearRetainer();
                    break;
                }
                break;
            case 11:
                notifyRendering();
                break;
            case 12:
                if (this.quitFlag && this.mDanmakuView != null) {
                    this.drawTask.requestClear();
                    this.mDanmakuView.drawDanmakus();
                    notifyRendering();
                    break;
                }
                break;
            case 13:
                master.flame.danmaku.controller.IDrawTask iDrawTask8 = this.drawTask;
                if (iDrawTask8 != null) {
                    iDrawTask8.clearDanmakusOnScreen(getCurrentTime());
                }
                break;
        }
    }

    private void quitUpdateThread() {
        master.flame.danmaku.controller.UpdateThread updateThread = this.mThread;
        if (updateThread != null) {
            this.mThread = null;
            synchronized (this.drawTask) {
                this.drawTask.notifyAll();
            }
            updateThread.quit();
            try {
                updateThread.join();
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateInCurrentThread() {
        if (this.quitFlag) {
            return;
        }
        long jSyncTimer = syncTimer(master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis());
        if (jSyncTimer < 0) {
            removeMessages(2);
            sendEmptyMessageDelayed(2, 60 - jSyncTimer);
            return;
        }
        long jDrawDanmakus = this.mDanmakuView.drawDanmakus();
        removeMessages(2);
        if (jDrawDanmakus > this.mCordonTime2) {
            this.timer.add(jDrawDanmakus);
            this.mDrawTimes.clear();
        }
        if (!this.mDanmakusVisible) {
            waitRendering(INDEFINITE_TIME);
            return;
        }
        if (this.mRenderingState.nothingRendered && this.mIdleSleep) {
            long j = this.mRenderingState.endTime - this.timer.currMillisecond;
            if (j > 500) {
                waitRendering(j - 10);
                return;
            }
        }
        long j2 = this.mFrameUpdateRate;
        if (jDrawDanmakus < j2) {
            sendEmptyMessageDelayed(2, j2 - jDrawDanmakus);
        } else {
            sendEmptyMessage(2);
        }
    }

    private void updateInNewThread() {
        if (this.mThread != null) {
            return;
        }
        master.flame.danmaku.controller.UpdateThread updateThread = new master.flame.danmaku.controller.UpdateThread("DFM Update") { // from class: master.flame.danmaku.controller.DrawHandler.2
            @Override // master.flame.danmaku.controller.UpdateThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                long jUptimeMillis = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis();
                while (!isQuited() && !master.flame.danmaku.controller.DrawHandler.this.quitFlag) {
                    long jUptimeMillis2 = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis();
                    if (master.flame.danmaku.controller.DrawHandler.this.mFrameUpdateRate - (master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis() - jUptimeMillis) <= 1) {
                        long jSyncTimer = master.flame.danmaku.controller.DrawHandler.this.syncTimer(jUptimeMillis2);
                        if (jSyncTimer >= 0) {
                            long jDrawDanmakus = master.flame.danmaku.controller.DrawHandler.this.mDanmakuView.drawDanmakus();
                            if (jDrawDanmakus > master.flame.danmaku.controller.DrawHandler.this.mCordonTime2) {
                                master.flame.danmaku.controller.DrawHandler.this.timer.add(jDrawDanmakus);
                                master.flame.danmaku.controller.DrawHandler.this.mDrawTimes.clear();
                            }
                            if (!master.flame.danmaku.controller.DrawHandler.this.mDanmakusVisible) {
                                master.flame.danmaku.controller.DrawHandler.this.waitRendering(master.flame.danmaku.controller.DrawHandler.INDEFINITE_TIME);
                            } else if (master.flame.danmaku.controller.DrawHandler.this.mRenderingState.nothingRendered && master.flame.danmaku.controller.DrawHandler.this.mIdleSleep) {
                                long j = master.flame.danmaku.controller.DrawHandler.this.mRenderingState.endTime - master.flame.danmaku.controller.DrawHandler.this.timer.currMillisecond;
                                if (j > 500) {
                                    master.flame.danmaku.controller.DrawHandler.this.notifyRendering();
                                    master.flame.danmaku.controller.DrawHandler.this.waitRendering(j - 10);
                                }
                            }
                        } else {
                            master.flame.danmaku.danmaku.util.SystemClock.sleep(60 - jSyncTimer);
                        }
                        jUptimeMillis = jUptimeMillis2;
                    } else {
                        master.flame.danmaku.danmaku.util.SystemClock.sleep(1L);
                    }
                }
            }
        };
        this.mThread = updateThread;
        updateThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long syncTimer(long j) {
        long j2 = 0;
        if (!this.mInSeekingAction && !this.mInSyncAction) {
            this.mInSyncAction = true;
            long j3 = j - this.mTimeBase;
            if (!this.mDanmakusVisible || this.mRenderingState.nothingRendered || this.mInWaitingState) {
                this.timer.update(j3);
                this.mRemainingTime = 0L;
            } else {
                long j4 = j3 - this.timer.currMillisecond;
                long jMax = java.lang.Math.max(this.mFrameUpdateRate, getAverageRenderingTime());
                if (j4 <= 2000) {
                    long j5 = this.mRenderingState.consumingTime;
                    long j6 = this.mCordonTime;
                    if (j5 <= j6 && jMax <= j6) {
                        long j7 = this.mFrameUpdateRate;
                        long jMin = java.lang.Math.min(this.mCordonTime, java.lang.Math.max(j7, jMax + (j4 / j7)));
                        long j8 = this.mLastDeltaTime;
                        long j9 = jMin - j8;
                        if (j9 > 3 && j9 < 8 && j8 >= this.mFrameUpdateRate && j8 <= this.mCordonTime) {
                            jMin = j8;
                        }
                        this.mLastDeltaTime = jMin;
                        j2 = j4 - jMin;
                        j4 = jMin;
                    }
                }
                this.mRemainingTime = j2;
                this.timer.add(j4);
                j2 = j4;
            }
            master.flame.danmaku.controller.DrawHandler.Callback callback = this.mCallback;
            if (callback != null) {
                callback.updateTimer(this.timer);
            }
            this.mInSyncAction = false;
        }
        return j2;
    }

    private void syncTimerIfNeeded() {
        if (this.mInWaitingState) {
            syncTimer(master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRenderingConfigs() {
        long jMax = java.lang.Math.max(33L, (long) (16 * 2.5f));
        this.mCordonTime = jMax;
        this.mCordonTime2 = (long) (jMax * 2.5f);
        long jMax2 = java.lang.Math.max(16L, 15L);
        this.mFrameUpdateRate = jMax2;
        this.mThresholdTime = jMax2 + 3;
    }

    private void prepare(final java.lang.Runnable runnable) {
        if (this.drawTask == null) {
            this.drawTask = createDrawTask(this.mDanmakuView.isDanmakuDrawingCacheEnabled(), this.timer, this.mDanmakuView.getContext(), this.mDanmakuView.getWidth(), this.mDanmakuView.getHeight(), this.mDanmakuView.isHardwareAccelerated(), new master.flame.danmaku.controller.IDrawTask.TaskListener() { // from class: master.flame.danmaku.controller.DrawHandler.3
                @Override // master.flame.danmaku.controller.IDrawTask.TaskListener
                public void ready() {
                    master.flame.danmaku.controller.DrawHandler.this.initRenderingConfigs();
                    runnable.run();
                }

                @Override // master.flame.danmaku.controller.IDrawTask.TaskListener
                public void onDanmakuAdd(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
                    if (baseDanmaku.isTimeOut()) {
                        return;
                    }
                    long actualTime = baseDanmaku.getActualTime() - master.flame.danmaku.controller.DrawHandler.this.timer.currMillisecond;
                    if (actualTime <= 0) {
                        if (master.flame.danmaku.controller.DrawHandler.this.mInWaitingState) {
                            master.flame.danmaku.controller.DrawHandler.this.notifyRendering();
                            return;
                        }
                        return;
                    }
                    master.flame.danmaku.controller.DrawHandler.this.sendEmptyMessageDelayed(11, actualTime);
                }

                @Override // master.flame.danmaku.controller.IDrawTask.TaskListener
                public void onDanmakuShown(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
                    if (master.flame.danmaku.controller.DrawHandler.this.mCallback != null) {
                        master.flame.danmaku.controller.DrawHandler.this.mCallback.danmakuShown(baseDanmaku);
                    }
                }

                @Override // master.flame.danmaku.controller.IDrawTask.TaskListener
                public void onDanmakusDrawingFinished() {
                    if (master.flame.danmaku.controller.DrawHandler.this.mCallback != null) {
                        master.flame.danmaku.controller.DrawHandler.this.mCallback.drawingFinished();
                    }
                }

                @Override // master.flame.danmaku.controller.IDrawTask.TaskListener
                public void onDanmakuConfigChanged() {
                    master.flame.danmaku.controller.DrawHandler.this.redrawIfNeeded();
                }
            });
        } else {
            runnable.run();
        }
    }

    public boolean isPrepared() {
        return this.mReady;
    }

    private master.flame.danmaku.controller.IDrawTask createDrawTask(boolean z, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, android.content.Context context, int i, int i2, boolean z2, master.flame.danmaku.controller.IDrawTask.TaskListener taskListener) {
        master.flame.danmaku.danmaku.model.AbsDisplayer displayer = this.mContext.getDisplayer();
        this.mDisp = displayer;
        displayer.setSize(i, i2);
        android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mDisp.setDensities(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.mDisp.resetSlopPixel(this.mContext.scaleTextSize);
        this.mDisp.setHardwareAccelerated(z2);
        master.flame.danmaku.controller.IDrawTask cacheManagingDrawTask = z ? new master.flame.danmaku.controller.CacheManagingDrawTask(danmakuTimer, this.mContext, taskListener, (master.flame.danmaku.danmaku.util.AndroidUtils.getMemoryClass(context) * 1048576) / 3) : new master.flame.danmaku.controller.DrawTask(danmakuTimer, this.mContext, taskListener);
        cacheManagingDrawTask.setParser(this.mParser);
        cacheManagingDrawTask.prepare();
        obtainMessage(10, false).sendToTarget();
        return cacheManagingDrawTask;
    }

    public void seekTo(java.lang.Long l) {
        this.mInSeekingAction = true;
        this.mDesireSeekingTime = l.longValue();
        removeMessages(2);
        removeMessages(3);
        removeMessages(4);
        obtainMessage(4, l).sendToTarget();
    }

    public void addDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
        if (this.drawTask != null) {
            baseDanmaku.flags = this.mContext.mGlobalFlagValues;
            baseDanmaku.setTimer(this.timer);
            this.drawTask.addDanmaku(baseDanmaku);
            obtainMessage(11).sendToTarget();
        }
    }

    public void invalidateDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, boolean z) {
        master.flame.danmaku.controller.IDrawTask iDrawTask = this.drawTask;
        if (iDrawTask != null && baseDanmaku != null) {
            iDrawTask.invalidateDanmaku(baseDanmaku, z);
        }
        redrawIfNeeded();
    }

    public void resume() {
        removeMessages(7);
        sendEmptyMessage(3);
    }

    public void prepare() {
        sendEmptyMessage(5);
    }

    public void pause() {
        removeMessages(3);
        syncTimerIfNeeded();
        sendEmptyMessage(7);
    }

    public void showDanmakus(java.lang.Long l) {
        if (this.mDanmakusVisible) {
            return;
        }
        this.mDanmakusVisible = true;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(8, l).sendToTarget();
    }

    public long hideDanmakus(boolean z) {
        if (!this.mDanmakusVisible) {
            return this.timer.currMillisecond;
        }
        this.mDanmakusVisible = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, java.lang.Boolean.valueOf(z)).sendToTarget();
        return this.timer.currMillisecond;
    }

    public boolean getVisibility() {
        return this.mDanmakusVisible;
    }

    public master.flame.danmaku.danmaku.renderer.IRenderer.RenderingState draw(android.graphics.Canvas canvas) {
        master.flame.danmaku.danmaku.model.AbsDanmakuSync absDanmakuSync;
        boolean zIsSyncPlayingState;
        if (this.drawTask == null) {
            return this.mRenderingState;
        }
        if (!this.mInWaitingState && (absDanmakuSync = this.mContext.danmakuSync) != null && ((zIsSyncPlayingState = absDanmakuSync.isSyncPlayingState()) || this.quitFlag)) {
            int syncState = absDanmakuSync.getSyncState();
            if (syncState == 2) {
                long j = this.timer.currMillisecond;
                long uptimeMillis = absDanmakuSync.getUptimeMillis();
                long j2 = uptimeMillis - j;
                if (java.lang.Math.abs(j2) > absDanmakuSync.getThresholdTimeMills()) {
                    if (zIsSyncPlayingState && this.quitFlag) {
                        resume();
                    }
                    this.drawTask.requestSync(j, uptimeMillis, j2);
                    this.timer.update(uptimeMillis);
                    this.mTimeBase = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis() - uptimeMillis;
                    this.mRemainingTime = 0L;
                }
            } else if (syncState == 1 && zIsSyncPlayingState && !this.quitFlag) {
                pause();
            }
        }
        this.mDisp.setExtraData(canvas);
        this.mRenderingState.set(this.drawTask.draw(this.mDisp));
        recordRenderingTime();
        return this.mRenderingState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void redrawIfNeeded() {
        if (this.quitFlag && this.mDanmakusVisible) {
            obtainMessage(12).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRendering() {
        if (this.mInWaitingState) {
            master.flame.danmaku.controller.IDrawTask iDrawTask = this.drawTask;
            if (iDrawTask != null) {
                iDrawTask.requestClear();
            }
            if (this.mUpdateInNewThread) {
                synchronized (this) {
                    this.mDrawTimes.clear();
                }
                synchronized (this.drawTask) {
                    this.drawTask.notifyAll();
                }
            } else {
                this.mDrawTimes.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.mInWaitingState = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitRendering(long j) {
        this.mRenderingState.sysTime = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis();
        this.mInWaitingState = true;
        if (!this.mUpdateInNewThread) {
            if (j == INDEFINITE_TIME) {
                removeMessages(11);
                removeMessages(2);
                return;
            } else {
                removeMessages(11);
                removeMessages(2);
                sendEmptyMessageDelayed(11, j);
                return;
            }
        }
        if (this.mThread == null) {
            return;
        }
        try {
            synchronized (this.drawTask) {
                try {
                    if (j == INDEFINITE_TIME) {
                        this.drawTask.wait();
                    } else {
                        this.drawTask.wait(j);
                    }
                    sendEmptyMessage(11);
                } catch (java.lang.Throwable th) {
                    throw th;
                }
            }
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized long getAverageRenderingTime() {
        int size = this.mDrawTimes.size();
        if (size <= 0) {
            return 0L;
        }
        java.lang.Long lPeekFirst = this.mDrawTimes.peekFirst();
        java.lang.Long lPeekLast = this.mDrawTimes.peekLast();
        if (lPeekFirst != null && lPeekLast != null) {
            return (lPeekLast.longValue() - lPeekFirst.longValue()) / ((long) size);
        }
        return 0L;
    }

    private synchronized void recordRenderingTime() {
        this.mDrawTimes.addLast(java.lang.Long.valueOf(master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis()));
        if (this.mDrawTimes.size() > MAX_RECORD_SIZE) {
            this.mDrawTimes.removeFirst();
        }
    }

    public master.flame.danmaku.danmaku.model.IDisplayer getDisplayer() {
        return this.mDisp;
    }

    public void notifyDispSizeChanged(int i, int i2) {
        master.flame.danmaku.danmaku.model.AbsDisplayer absDisplayer = this.mDisp;
        if (absDisplayer == null) {
            return;
        }
        if (absDisplayer.getWidth() == i && this.mDisp.getHeight() == i2) {
            return;
        }
        this.mDisp.setSize(i, i2);
        obtainMessage(10, true).sendToTarget();
    }

    public void removeAllDanmakus(boolean z) {
        master.flame.danmaku.controller.IDrawTask iDrawTask = this.drawTask;
        if (iDrawTask != null) {
            iDrawTask.removeAllDanmakus(z);
        }
    }

    public void removeAllLiveDanmakus() {
        master.flame.danmaku.controller.IDrawTask iDrawTask = this.drawTask;
        if (iDrawTask != null) {
            iDrawTask.removeAllLiveDanmakus();
        }
    }

    public master.flame.danmaku.danmaku.model.IDanmakus getCurrentVisibleDanmakus() {
        master.flame.danmaku.controller.IDrawTask iDrawTask = this.drawTask;
        if (iDrawTask != null) {
            return iDrawTask.getVisibleDanmakusOnTime(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        long jUptimeMillis;
        long j;
        if (!this.mReady) {
            return 0L;
        }
        if (this.mInSeekingAction) {
            return this.mDesireSeekingTime;
        }
        if (this.quitFlag || !this.mInWaitingState) {
            jUptimeMillis = this.timer.currMillisecond;
            j = this.mRemainingTime;
        } else {
            jUptimeMillis = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis();
            j = this.mTimeBase;
        }
        return jUptimeMillis - j;
    }

    public void clearDanmakusOnScreen() {
        obtainMessage(13).sendToTarget();
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext getConfig() {
        return this.mContext;
    }
}
