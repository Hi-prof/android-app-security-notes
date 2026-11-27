package master.flame.danmaku.danmaku.renderer.android;

/* JADX INFO: loaded from: classes2.dex */
public class DanmakuRenderer extends master.flame.danmaku.danmaku.renderer.Renderer {
    private master.flame.danmaku.danmaku.model.ICacheManager mCacheManager;
    private final master.flame.danmaku.danmaku.model.android.DanmakuContext mContext;
    private final master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer mDanmakusRetainer;
    private master.flame.danmaku.danmaku.renderer.IRenderer.OnDanmakuShownListener mOnDanmakuShownListener;
    private master.flame.danmaku.danmaku.model.DanmakuTimer mStartTimer;
    private master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.Verifier mVerifier;
    private final master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.Verifier verifier = new master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.Verifier() { // from class: master.flame.danmaku.danmaku.renderer.android.DanmakuRenderer.1
        @Override // master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.Verifier
        public boolean skipLayout(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, float f, int i, boolean z) {
            if (baseDanmaku.priority != 0 || !master.flame.danmaku.danmaku.renderer.android.DanmakuRenderer.this.mContext.mDanmakuFilters.filterSecondary(baseDanmaku, i, 0, master.flame.danmaku.danmaku.renderer.android.DanmakuRenderer.this.mStartTimer, z, master.flame.danmaku.danmaku.renderer.android.DanmakuRenderer.this.mContext)) {
                return false;
            }
            baseDanmaku.setVisibility(false);
            return true;
        }
    };

    public DanmakuRenderer(master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
        this.mContext = danmakuContext;
        this.mDanmakusRetainer = new master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer(danmakuContext.isAlignBottom());
    }

    @Override // master.flame.danmaku.danmaku.renderer.IRenderer
    public void clear() {
        clearRetainer();
        this.mContext.mDanmakuFilters.clear();
    }

    @Override // master.flame.danmaku.danmaku.renderer.IRenderer
    public void clearRetainer() {
        this.mDanmakusRetainer.clear();
    }

    @Override // master.flame.danmaku.danmaku.renderer.IRenderer
    public void release() {
        this.mDanmakusRetainer.release();
        this.mContext.mDanmakuFilters.clear();
    }

    @Override // master.flame.danmaku.danmaku.renderer.IRenderer
    public void setVerifierEnabled(boolean z) {
        this.mVerifier = z ? this.verifier : null;
    }

    @Override // master.flame.danmaku.danmaku.renderer.IRenderer
    public void draw(master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, master.flame.danmaku.danmaku.model.IDanmakus iDanmakus, long j, master.flame.danmaku.danmaku.renderer.IRenderer.RenderingState renderingState) {
        this.mStartTimer = renderingState.timer;
        master.flame.danmaku.danmaku.model.IDanmakuIterator it = iDanmakus.iterator();
        master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku = null;
        while (it.hasNext()) {
            master.flame.danmaku.danmaku.model.BaseDanmaku next = it.next();
            if (next.isTimeOut()) {
                iDisplayer.recycle(next);
            } else if (!renderingState.isRunningDanmakus && next.isOffset()) {
                it.remove();
            } else {
                if (!next.hasPassedFilter()) {
                    this.mContext.mDanmakuFilters.filter(next, renderingState.indexInScreen, renderingState.totalSizeInScreen, renderingState.timer, false, this.mContext);
                }
                if (next.getActualTime() >= j && (next.priority != 0 || !next.isFiltered())) {
                    if (next.isLate()) {
                        master.flame.danmaku.danmaku.model.IDrawingCache<?> drawingCache = next.getDrawingCache();
                        if (this.mCacheManager != null && (drawingCache == null || drawingCache.get() == null)) {
                            this.mCacheManager.addDanmaku(next);
                        }
                        baseDanmaku = next;
                        break;
                    }
                    if (next.getType() == 1) {
                        renderingState.indexInScreen++;
                    }
                    if (!next.isMeasured()) {
                        next.measure(iDisplayer, false);
                    }
                    if (!next.isPrepared()) {
                        next.prepare(iDisplayer, false);
                    }
                    this.mDanmakusRetainer.fix(next, iDisplayer, this.mVerifier);
                    if (next.isShown() && (next.lines != null || next.getBottom() <= iDisplayer.getHeight())) {
                        int iDraw = next.draw(iDisplayer);
                        if (iDraw == 1) {
                            renderingState.cacheHitCount++;
                        } else if (iDraw == 2) {
                            renderingState.cacheMissCount++;
                            master.flame.danmaku.danmaku.model.ICacheManager iCacheManager = this.mCacheManager;
                            if (iCacheManager != null) {
                                iCacheManager.addDanmaku(next);
                            }
                        }
                        renderingState.addCount(next.getType(), 1);
                        renderingState.addTotalCount(1);
                        renderingState.appendToRunningDanmakus(next);
                        if (this.mOnDanmakuShownListener != null && next.firstShownFlag != this.mContext.mGlobalFlagValues.FIRST_SHOWN_RESET_FLAG) {
                            next.firstShownFlag = this.mContext.mGlobalFlagValues.FIRST_SHOWN_RESET_FLAG;
                            this.mOnDanmakuShownListener.onDanmakuShown(next);
                        }
                    }
                }
            }
            baseDanmaku = next;
        }
        renderingState.lastDanmaku = baseDanmaku;
    }

    @Override // master.flame.danmaku.danmaku.renderer.IRenderer
    public void setCacheManager(master.flame.danmaku.danmaku.model.ICacheManager iCacheManager) {
        this.mCacheManager = iCacheManager;
    }

    @Override // master.flame.danmaku.danmaku.renderer.IRenderer
    public void setOnDanmakuShownListener(master.flame.danmaku.danmaku.renderer.IRenderer.OnDanmakuShownListener onDanmakuShownListener) {
        this.mOnDanmakuShownListener = onDanmakuShownListener;
    }

    @Override // master.flame.danmaku.danmaku.renderer.IRenderer
    public void removeOnDanmakuShownListener() {
        this.mOnDanmakuShownListener = null;
    }

    @Override // master.flame.danmaku.danmaku.renderer.IRenderer
    public void alignBottom(boolean z) {
        master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer danmakusRetainer = this.mDanmakusRetainer;
        if (danmakusRetainer != null) {
            danmakusRetainer.alignBottom(z);
        }
    }
}
