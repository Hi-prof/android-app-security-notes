package master.flame.danmaku.controller;

/* JADX INFO: loaded from: classes2.dex */
public class DrawTask implements master.flame.danmaku.controller.IDrawTask {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected boolean clearRetainerFlag;
    protected master.flame.danmaku.danmaku.model.IDanmakus danmakuList;
    protected final master.flame.danmaku.danmaku.model.android.DanmakuContext mContext;
    protected final master.flame.danmaku.danmaku.model.AbsDisplayer mDisp;
    private boolean mIsHidden;
    private long mLastBeginMills;
    private master.flame.danmaku.danmaku.model.BaseDanmaku mLastDanmaku;
    private long mLastEndMills;
    protected master.flame.danmaku.danmaku.parser.BaseDanmakuParser mParser;
    protected int mPlayState;
    protected boolean mReadyState;
    final master.flame.danmaku.danmaku.renderer.IRenderer mRenderer;
    private master.flame.danmaku.danmaku.model.IDanmakus mRunningDanmakus;
    master.flame.danmaku.controller.IDrawTask.TaskListener mTaskListener;
    master.flame.danmaku.danmaku.model.DanmakuTimer mTimer;
    private master.flame.danmaku.danmaku.model.IDanmakus danmakus = new master.flame.danmaku.danmaku.model.android.Danmakus(4);
    private long mStartRenderTime = 0;
    private final master.flame.danmaku.danmaku.renderer.IRenderer.RenderingState mRenderingState = new master.flame.danmaku.danmaku.renderer.IRenderer.RenderingState();
    private master.flame.danmaku.danmaku.model.android.Danmakus mLiveDanmakus = new master.flame.danmaku.danmaku.model.android.Danmakus(4);
    private master.flame.danmaku.danmaku.model.android.DanmakuContext.ConfigChangedCallback mConfigChangedCallback = new master.flame.danmaku.danmaku.model.android.DanmakuContext.ConfigChangedCallback() { // from class: master.flame.danmaku.controller.DrawTask.1
        @Override // master.flame.danmaku.danmaku.model.android.DanmakuContext.ConfigChangedCallback
        public boolean onDanmakuConfigChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext, master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag danmakuConfigTag, java.lang.Object... objArr) {
            return master.flame.danmaku.controller.DrawTask.this.onDanmakuConfigChanged(danmakuContext, danmakuConfigTag, objArr);
        }
    };

    protected void onDanmakuRemoved(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
    }

    public DrawTask(master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext, master.flame.danmaku.controller.IDrawTask.TaskListener taskListener) {
        if (danmakuContext == null) {
            throw new java.lang.IllegalArgumentException("context is null");
        }
        this.mContext = danmakuContext;
        this.mDisp = danmakuContext.getDisplayer();
        this.mTaskListener = taskListener;
        master.flame.danmaku.danmaku.renderer.android.DanmakuRenderer danmakuRenderer = new master.flame.danmaku.danmaku.renderer.android.DanmakuRenderer(danmakuContext);
        this.mRenderer = danmakuRenderer;
        danmakuRenderer.setOnDanmakuShownListener(new master.flame.danmaku.danmaku.renderer.IRenderer.OnDanmakuShownListener() { // from class: master.flame.danmaku.controller.DrawTask.2
            @Override // master.flame.danmaku.danmaku.renderer.IRenderer.OnDanmakuShownListener
            public void onDanmakuShown(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
                if (master.flame.danmaku.controller.DrawTask.this.mTaskListener != null) {
                    master.flame.danmaku.controller.DrawTask.this.mTaskListener.onDanmakuShown(baseDanmaku);
                }
            }
        });
        danmakuRenderer.setVerifierEnabled(danmakuContext.isPreventOverlappingEnabled() || danmakuContext.isMaxLinesLimited());
        initTimer(danmakuTimer);
        boolean zIsDuplicateMergingEnabled = danmakuContext.isDuplicateMergingEnabled();
        java.lang.Boolean boolValueOf = java.lang.Boolean.valueOf(zIsDuplicateMergingEnabled);
        if (boolValueOf != null) {
            boolValueOf.getClass();
            if (zIsDuplicateMergingEnabled) {
                danmakuContext.mDanmakuFilters.registerFilter(master.flame.danmaku.controller.DanmakuFilters.TAG_DUPLICATE_FILTER);
            } else {
                danmakuContext.mDanmakuFilters.unregisterFilter(master.flame.danmaku.controller.DanmakuFilters.TAG_DUPLICATE_FILTER);
            }
        }
    }

    protected void initTimer(master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer) {
        this.mTimer = danmakuTimer;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public synchronized void addDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
        boolean zAddItem;
        boolean zAddItem2;
        master.flame.danmaku.controller.IDrawTask.TaskListener taskListener;
        if (this.danmakuList == null) {
            return;
        }
        if (baseDanmaku.isLive) {
            this.mLiveDanmakus.addItem(baseDanmaku);
            removeUnusedLiveDanmakusIn(10);
        }
        baseDanmaku.index = this.danmakuList.size();
        if (this.mLastBeginMills <= baseDanmaku.getActualTime() && baseDanmaku.getActualTime() <= this.mLastEndMills) {
            synchronized (this.danmakus) {
                zAddItem = this.danmakus.addItem(baseDanmaku);
            }
        } else {
            zAddItem = !baseDanmaku.isLive;
        }
        synchronized (this.danmakuList) {
            zAddItem2 = this.danmakuList.addItem(baseDanmaku);
        }
        if (!zAddItem) {
            this.mLastEndMills = 0L;
            this.mLastBeginMills = 0L;
        }
        if (zAddItem2 && (taskListener = this.mTaskListener) != null) {
            taskListener.onDanmakuAdd(baseDanmaku);
        }
        master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2 = this.mLastDanmaku;
        if (baseDanmaku2 == null || (baseDanmaku != null && baseDanmaku2 != null && baseDanmaku.getActualTime() > this.mLastDanmaku.getActualTime())) {
            this.mLastDanmaku = baseDanmaku;
        }
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void invalidateDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, boolean z) {
        this.mContext.getDisplayer().getCacheStuffer().clearCache(baseDanmaku);
        baseDanmaku.requestFlags |= 2;
        if (z) {
            baseDanmaku.paintWidth = -1.0f;
            baseDanmaku.paintHeight = -1.0f;
            baseDanmaku.requestFlags |= 1;
            baseDanmaku.measureResetFlag++;
        }
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public synchronized void removeAllDanmakus(boolean z) {
        master.flame.danmaku.danmaku.model.IDanmakus iDanmakus = this.danmakuList;
        if (iDanmakus != null && !iDanmakus.isEmpty()) {
            synchronized (this.danmakuList) {
                if (!z) {
                    master.flame.danmaku.danmaku.model.IDanmakus iDanmakusSubnew = this.danmakuList.subnew((this.mTimer.currMillisecond - this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION) - 100, this.mTimer.currMillisecond + this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION);
                    if (iDanmakusSubnew != null) {
                        this.danmakus = iDanmakusSubnew;
                    }
                }
                this.danmakuList.clear();
            }
        }
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public synchronized void removeAllLiveDanmakus() {
        master.flame.danmaku.danmaku.model.IDanmakus iDanmakus = this.danmakus;
        if (iDanmakus != null && !iDanmakus.isEmpty()) {
            synchronized (this.danmakus) {
                master.flame.danmaku.danmaku.model.IDanmakuIterator it = this.danmakus.iterator();
                while (it.hasNext()) {
                    master.flame.danmaku.danmaku.model.BaseDanmaku next = it.next();
                    if (next.isLive) {
                        it.remove();
                        onDanmakuRemoved(next);
                    }
                }
            }
        }
    }

    protected synchronized void removeUnusedLiveDanmakusIn(int i) {
        master.flame.danmaku.danmaku.model.BaseDanmaku next;
        boolean zIsTimeOut;
        master.flame.danmaku.danmaku.model.IDanmakus iDanmakus = this.danmakuList;
        if (iDanmakus != null && !iDanmakus.isEmpty() && !this.mLiveDanmakus.isEmpty()) {
            long jUptimeMillis = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis();
            master.flame.danmaku.danmaku.model.IDanmakuIterator it = this.mLiveDanmakus.iterator();
            while (it.hasNext() && (zIsTimeOut = (next = it.next()).isTimeOut())) {
                it.remove();
                this.danmakuList.removeItem(next);
                onDanmakuRemoved(next);
                if (!zIsTimeOut || master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis() - jUptimeMillis > i) {
                    break;
                }
            }
        }
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public master.flame.danmaku.danmaku.model.IDanmakus getVisibleDanmakusOnTime(long j) {
        master.flame.danmaku.danmaku.model.IDanmakus iDanmakusSubnew = this.danmakuList.subnew((j - this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION) - 100, j + this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION);
        master.flame.danmaku.danmaku.model.android.Danmakus danmakus = new master.flame.danmaku.danmaku.model.android.Danmakus();
        if (iDanmakusSubnew != null && !iDanmakusSubnew.isEmpty()) {
            master.flame.danmaku.danmaku.model.IDanmakuIterator it = iDanmakusSubnew.iterator();
            while (it.hasNext()) {
                master.flame.danmaku.danmaku.model.BaseDanmaku next = it.next();
                if (next.isShown() && !next.isOutside()) {
                    danmakus.addItem(next);
                }
            }
        }
        return danmakus;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public synchronized master.flame.danmaku.danmaku.renderer.IRenderer.RenderingState draw(master.flame.danmaku.danmaku.model.AbsDisplayer absDisplayer) {
        return drawDanmakus(absDisplayer, this.mTimer);
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void reset() {
        if (this.danmakus != null) {
            this.danmakus = new master.flame.danmaku.danmaku.model.android.Danmakus();
        }
        master.flame.danmaku.danmaku.renderer.IRenderer iRenderer = this.mRenderer;
        if (iRenderer != null) {
            iRenderer.clear();
        }
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmakuLast;
        reset();
        this.mContext.mGlobalFlagValues.updateVisibleFlag();
        this.mContext.mGlobalFlagValues.updateFirstShownFlag();
        this.mContext.mGlobalFlagValues.updateSyncOffsetTimeFlag();
        this.mContext.mGlobalFlagValues.updatePrepareFlag();
        this.mRunningDanmakus = new master.flame.danmaku.danmaku.model.android.Danmakus(4);
        if (j < 1000) {
            j = 0;
        }
        this.mStartRenderTime = j;
        this.mRenderingState.reset();
        this.mRenderingState.endTime = this.mStartRenderTime;
        this.mLastEndMills = 0L;
        this.mLastBeginMills = 0L;
        master.flame.danmaku.danmaku.model.IDanmakus iDanmakus = this.danmakuList;
        if (iDanmakus == null || (baseDanmakuLast = iDanmakus.last()) == null || baseDanmakuLast.isTimeOut()) {
            return;
        }
        this.mLastDanmaku = baseDanmakuLast;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void clearDanmakusOnScreen(long j) {
        reset();
        this.mContext.mGlobalFlagValues.updateVisibleFlag();
        this.mContext.mGlobalFlagValues.updateFirstShownFlag();
        this.mStartRenderTime = j;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void start() {
        this.mContext.registerConfigChangedCallback(this.mConfigChangedCallback);
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void quit() {
        this.mContext.unregisterAllConfigChangedCallbacks();
        master.flame.danmaku.danmaku.renderer.IRenderer iRenderer = this.mRenderer;
        if (iRenderer != null) {
            iRenderer.release();
        }
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void prepare() {
        loadDanmakus(this.mParser);
        this.mLastEndMills = 0L;
        this.mLastBeginMills = 0L;
        master.flame.danmaku.controller.IDrawTask.TaskListener taskListener = this.mTaskListener;
        if (taskListener != null) {
            taskListener.ready();
            this.mReadyState = true;
        }
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void onPlayStateChanged(int i) {
        this.mPlayState = i;
    }

    protected void loadDanmakus(master.flame.danmaku.danmaku.parser.BaseDanmakuParser baseDanmakuParser) {
        master.flame.danmaku.danmaku.model.IDanmakus danmakus = baseDanmakuParser.setConfig(this.mContext).setDisplayer(this.mDisp).setTimer(this.mTimer).getDanmakus();
        this.danmakuList = danmakus;
        if (danmakus != null && !danmakus.isEmpty() && this.danmakuList.first().flags == null) {
            master.flame.danmaku.danmaku.model.IDanmakuIterator it = this.danmakuList.iterator();
            while (it.hasNext()) {
                master.flame.danmaku.danmaku.model.BaseDanmaku next = it.next();
                if (next != null) {
                    next.flags = this.mContext.mGlobalFlagValues;
                }
            }
        }
        this.mContext.mGlobalFlagValues.resetAll();
        master.flame.danmaku.danmaku.model.IDanmakus iDanmakus = this.danmakuList;
        if (iDanmakus != null) {
            this.mLastDanmaku = iDanmakus.last();
        }
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void setParser(master.flame.danmaku.danmaku.parser.BaseDanmakuParser baseDanmakuParser) {
        this.mParser = baseDanmakuParser;
        this.mReadyState = false;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0050  */
    /* JADX WARN: Code duplicated, block: B:19:0x0058  */
    protected master.flame.danmaku.danmaku.renderer.IRenderer.RenderingState drawDanmakus(master.flame.danmaku.danmaku.model.AbsDisplayer absDisplayer, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer) {
        long j;
        if (this.clearRetainerFlag) {
            this.mRenderer.clearRetainer();
            this.clearRetainerFlag = false;
        }
        if (this.danmakuList == null) {
            return null;
        }
        master.flame.danmaku.controller.DrawHelper.clearCanvas((android.graphics.Canvas) absDisplayer.getExtraData());
        if (this.mIsHidden) {
            return this.mRenderingState;
        }
        master.flame.danmaku.danmaku.renderer.IRenderer.RenderingState renderingState = this.mRenderingState;
        long j2 = (danmakuTimer.currMillisecond - this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION) - 100;
        long j3 = danmakuTimer.currMillisecond + this.mContext.mDanmakuFactory.MAX_DANMAKU_DURATION;
        master.flame.danmaku.danmaku.model.IDanmakus iDanmakusSub = this.danmakus;
        if (this.mLastBeginMills <= j2) {
            long j4 = danmakuTimer.currMillisecond;
            j = this.mLastEndMills;
            if (j4 > j) {
                iDanmakusSub = this.danmakuList.sub(j2, j3);
                if (iDanmakusSub != null) {
                    this.danmakus = iDanmakusSub;
                }
                this.mLastBeginMills = j2;
                this.mLastEndMills = j3;
                j = j3;
            } else {
                j2 = this.mLastBeginMills;
            }
        } else {
            iDanmakusSub = this.danmakuList.sub(j2, j3);
            if (iDanmakusSub != null) {
                this.danmakus = iDanmakusSub;
            }
            this.mLastBeginMills = j2;
            this.mLastEndMills = j3;
            j = j3;
        }
        master.flame.danmaku.danmaku.model.IDanmakus iDanmakus = iDanmakusSub;
        long j5 = j2;
        master.flame.danmaku.danmaku.model.IDanmakus iDanmakus2 = this.mRunningDanmakus;
        beginTracing(renderingState, iDanmakus2, iDanmakus);
        if (iDanmakus2 != null && !iDanmakus2.isEmpty()) {
            this.mRenderingState.isRunningDanmakus = true;
            this.mRenderer.draw(absDisplayer, iDanmakus2, 0L, this.mRenderingState);
        }
        this.mRenderingState.isRunningDanmakus = false;
        if (iDanmakus != null && !iDanmakus.isEmpty()) {
            this.mRenderer.draw(this.mDisp, iDanmakus, this.mStartRenderTime, renderingState);
            endTracing(renderingState);
            if (renderingState.nothingRendered) {
                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku = this.mLastDanmaku;
                if (baseDanmaku != null && baseDanmaku.isTimeOut()) {
                    this.mLastDanmaku = null;
                    master.flame.danmaku.controller.IDrawTask.TaskListener taskListener = this.mTaskListener;
                    if (taskListener != null) {
                        taskListener.onDanmakusDrawingFinished();
                    }
                }
                if (renderingState.beginTime == -1) {
                    renderingState.beginTime = j5;
                }
                if (renderingState.endTime == -1) {
                    renderingState.endTime = j;
                }
            }
            return renderingState;
        }
        renderingState.nothingRendered = true;
        renderingState.beginTime = j5;
        renderingState.endTime = j;
        return renderingState;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void requestClear() {
        this.mLastEndMills = 0L;
        this.mLastBeginMills = 0L;
        this.mIsHidden = false;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void requestClearRetainer() {
        this.clearRetainerFlag = true;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void requestSync(long j, long j2, long j3) {
        master.flame.danmaku.danmaku.model.IDanmakus iDanmakusObtainRunningDanmakus = this.mRenderingState.obtainRunningDanmakus();
        this.mRunningDanmakus = iDanmakusObtainRunningDanmakus;
        master.flame.danmaku.danmaku.model.IDanmakuIterator it = iDanmakusObtainRunningDanmakus.iterator();
        while (it.hasNext()) {
            master.flame.danmaku.danmaku.model.BaseDanmaku next = it.next();
            if (next.isOutside()) {
                it.remove();
            } else {
                next.setTimeOffset(next.timeOffset + j3);
                next.isOffset = true;
            }
        }
        this.mStartRenderTime = j2;
    }

    public boolean onDanmakuConfigChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext, master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag danmakuConfigTag, java.lang.Object... objArr) {
        boolean zHandleOnDanmakuConfigChanged = handleOnDanmakuConfigChanged(danmakuContext, danmakuConfigTag, objArr);
        master.flame.danmaku.controller.IDrawTask.TaskListener taskListener = this.mTaskListener;
        if (taskListener != null) {
            taskListener.onDanmakuConfigChanged();
        }
        return zHandleOnDanmakuConfigChanged;
    }

    protected boolean handleOnDanmakuConfigChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext, master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag danmakuConfigTag, java.lang.Object[] objArr) {
        java.lang.Boolean bool;
        if (danmakuConfigTag == null || master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN.equals(danmakuConfigTag)) {
            return true;
        }
        if (master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.DUPLICATE_MERGING_ENABLED.equals(danmakuConfigTag)) {
            java.lang.Boolean bool2 = (java.lang.Boolean) objArr[0];
            if (bool2 != null) {
                if (bool2.booleanValue()) {
                    this.mContext.mDanmakuFilters.registerFilter(master.flame.danmaku.controller.DanmakuFilters.TAG_DUPLICATE_FILTER);
                } else {
                    this.mContext.mDanmakuFilters.unregisterFilter(master.flame.danmaku.controller.DanmakuFilters.TAG_DUPLICATE_FILTER);
                }
                return true;
            }
        } else {
            if (master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                requestClearRetainer();
                return false;
            }
            if (master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
                master.flame.danmaku.danmaku.renderer.IRenderer iRenderer = this.mRenderer;
                if (iRenderer != null) {
                    iRenderer.setVerifierEnabled(this.mContext.isPreventOverlappingEnabled() || this.mContext.isMaxLinesLimited());
                }
                return true;
            }
            if (master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) && (bool = (java.lang.Boolean) objArr[0]) != null) {
                master.flame.danmaku.danmaku.renderer.IRenderer iRenderer2 = this.mRenderer;
                if (iRenderer2 != null) {
                    iRenderer2.alignBottom(bool.booleanValue());
                }
                return true;
            }
        }
        return false;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void requestHide() {
        this.mIsHidden = true;
    }

    private void beginTracing(master.flame.danmaku.danmaku.renderer.IRenderer.RenderingState renderingState, master.flame.danmaku.danmaku.model.IDanmakus iDanmakus, master.flame.danmaku.danmaku.model.IDanmakus iDanmakus2) {
        renderingState.reset();
        renderingState.timer.update(master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis());
        renderingState.indexInScreen = 0;
        renderingState.totalSizeInScreen = (iDanmakus != null ? iDanmakus.size() : 0) + (iDanmakus2 != null ? iDanmakus2.size() : 0);
    }

    private void endTracing(master.flame.danmaku.danmaku.renderer.IRenderer.RenderingState renderingState) {
        renderingState.nothingRendered = renderingState.totalDanmakuCount == 0;
        if (renderingState.nothingRendered) {
            renderingState.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku = renderingState.lastDanmaku;
        renderingState.lastDanmaku = null;
        renderingState.endTime = baseDanmaku != null ? baseDanmaku.getActualTime() : -1L;
        renderingState.consumingTime = renderingState.timer.update(master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis());
    }
}
