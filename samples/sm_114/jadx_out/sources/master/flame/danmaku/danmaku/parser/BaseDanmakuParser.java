package master.flame.danmaku.danmaku.parser;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseDanmakuParser {
    protected master.flame.danmaku.danmaku.model.android.DanmakuContext mContext;
    private master.flame.danmaku.danmaku.model.IDanmakus mDanmakus;
    protected master.flame.danmaku.danmaku.parser.IDataSource<?> mDataSource;
    protected master.flame.danmaku.danmaku.model.IDisplayer mDisp;
    protected float mDispDensity;
    protected int mDispHeight;
    protected int mDispWidth;
    protected float mScaledDensity;
    protected master.flame.danmaku.danmaku.model.DanmakuTimer mTimer;

    protected abstract master.flame.danmaku.danmaku.model.IDanmakus parse();

    public master.flame.danmaku.danmaku.parser.BaseDanmakuParser setDisplayer(master.flame.danmaku.danmaku.model.IDisplayer iDisplayer) {
        this.mDisp = iDisplayer;
        this.mDispWidth = iDisplayer.getWidth();
        this.mDispHeight = iDisplayer.getHeight();
        this.mDispDensity = iDisplayer.getDensity();
        this.mScaledDensity = iDisplayer.getScaledDensity();
        this.mContext.mDanmakuFactory.updateViewportState(this.mDispWidth, this.mDispHeight, getViewportSizeFactor());
        this.mContext.mDanmakuFactory.updateMaxDanmakuDuration();
        return this;
    }

    protected float getViewportSizeFactor() {
        return 1.0f / (this.mDispDensity - 0.6f);
    }

    public master.flame.danmaku.danmaku.model.IDisplayer getDisplayer() {
        return this.mDisp;
    }

    public master.flame.danmaku.danmaku.parser.BaseDanmakuParser load(master.flame.danmaku.danmaku.parser.IDataSource<?> iDataSource) {
        this.mDataSource = iDataSource;
        return this;
    }

    public master.flame.danmaku.danmaku.parser.BaseDanmakuParser setTimer(master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer) {
        this.mTimer = danmakuTimer;
        return this;
    }

    public master.flame.danmaku.danmaku.model.DanmakuTimer getTimer() {
        return this.mTimer;
    }

    public master.flame.danmaku.danmaku.model.IDanmakus getDanmakus() {
        master.flame.danmaku.danmaku.model.IDanmakus iDanmakus = this.mDanmakus;
        if (iDanmakus != null) {
            return iDanmakus;
        }
        this.mContext.mDanmakuFactory.resetDurationsData();
        this.mDanmakus = parse();
        releaseDataSource();
        this.mContext.mDanmakuFactory.updateMaxDanmakuDuration();
        return this.mDanmakus;
    }

    protected void releaseDataSource() {
        master.flame.danmaku.danmaku.parser.IDataSource<?> iDataSource = this.mDataSource;
        if (iDataSource != null) {
            iDataSource.release();
        }
        this.mDataSource = null;
    }

    public void release() {
        releaseDataSource();
    }

    public master.flame.danmaku.danmaku.parser.BaseDanmakuParser setConfig(master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
        master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext2 = this.mContext;
        if (danmakuContext2 != null && danmakuContext2 != danmakuContext) {
            this.mDanmakus = null;
        }
        this.mContext = danmakuContext;
        return this;
    }
}
