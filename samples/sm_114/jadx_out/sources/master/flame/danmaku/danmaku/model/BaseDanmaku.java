package master.flame.danmaku.danmaku.model;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseDanmaku {
    public static final java.lang.String DANMAKU_BR_CHAR = "/n";
    public static final int FLAG_REQUEST_INVALIDATE = 2;
    public static final int FLAG_REQUEST_REMEASURE = 1;
    public static final int INVISIBLE = 0;
    public static final int TYPE_FIX_BOTTOM = 4;
    public static final int TYPE_FIX_TOP = 5;
    public static final int TYPE_MOVEABLE_XXX = 0;
    public static final int TYPE_SCROLL_LR = 6;
    public static final int TYPE_SCROLL_RL = 1;
    public static final int TYPE_SPECIAL = 7;
    public static final int VISIBLE = 1;
    public master.flame.danmaku.danmaku.model.IDrawingCache<?> cache;
    public master.flame.danmaku.danmaku.model.Duration duration;
    public boolean forceBuildCacheInSameThread;
    public int index;
    public boolean isGuest;
    public boolean isLive;
    public boolean isOffset;
    public java.lang.String[] lines;
    protected master.flame.danmaku.danmaku.model.DanmakuTimer mTimer;
    public java.lang.Object obj;
    private long realTime;
    public float rotationY;
    public float rotationZ;
    public java.lang.Object tag;
    public java.lang.CharSequence text;
    public int textColor;
    public int textShadowColor;
    private long time;
    public long timeOffset;
    public java.lang.String userHash;
    public int visibility;
    public int underlineColor = 0;
    public float textSize = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte priority = 0;
    public float paintWidth = -1.0f;
    public float paintHeight = -1.0f;
    private int visibleResetFlag = 0;
    public int measureResetFlag = 0;
    public int syncTimeOffsetResetFlag = 0;
    public int prepareResetFlag = -1;
    public int userId = 0;
    protected int alpha = master.flame.danmaku.danmaku.model.AlphaValue.MAX;
    public int mFilterParam = 0;
    public int filterResetFlag = -1;
    public master.flame.danmaku.danmaku.model.GlobalFlagValues flags = null;
    public int requestFlags = 0;
    public int firstShownFlag = -1;

    public abstract float getBottom();

    public abstract float getLeft();

    public abstract float[] getRectAtTime(master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, long j);

    public abstract float getRight();

    public abstract float getTop();

    public abstract int getType();

    public abstract void layout(master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, float f, float f2);

    public long getDuration() {
        return this.duration.value;
    }

    public void setDuration(master.flame.danmaku.danmaku.model.Duration duration) {
        this.duration = duration;
    }

    public int draw(master.flame.danmaku.danmaku.model.IDisplayer iDisplayer) {
        return iDisplayer.draw(this);
    }

    public boolean isMeasured() {
        return this.paintWidth > -1.0f && this.paintHeight > -1.0f && this.measureResetFlag == this.flags.MEASURE_RESET_FLAG;
    }

    public void measure(master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, boolean z) {
        iDisplayer.measure(this, z);
        this.measureResetFlag = this.flags.MEASURE_RESET_FLAG;
    }

    public boolean isPrepared() {
        return this.prepareResetFlag == this.flags.PREPARE_RESET_FLAG;
    }

    public void prepare(master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, boolean z) {
        iDisplayer.prepare(this, z);
        this.prepareResetFlag = this.flags.PREPARE_RESET_FLAG;
    }

    public master.flame.danmaku.danmaku.model.IDrawingCache<?> getDrawingCache() {
        return this.cache;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.visibleResetFlag == this.flags.VISIBLE_RESET_FLAG;
    }

    public boolean isTimeOut() {
        master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer = this.mTimer;
        return danmakuTimer == null || isTimeOut(danmakuTimer.currMillisecond);
    }

    public boolean isTimeOut(long j) {
        return j - getActualTime() >= this.duration.value;
    }

    public boolean isOutside() {
        master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer = this.mTimer;
        return danmakuTimer == null || isOutside(danmakuTimer.currMillisecond);
    }

    public boolean isOutside(long j) {
        long actualTime = j - getActualTime();
        return actualTime <= 0 || actualTime >= this.duration.value;
    }

    public boolean isLate() {
        master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer = this.mTimer;
        return danmakuTimer == null || danmakuTimer.currMillisecond < getActualTime();
    }

    public boolean hasPassedFilter() {
        if (this.filterResetFlag == this.flags.FILTER_RESET_FLAG) {
            return true;
        }
        this.mFilterParam = 0;
        return false;
    }

    public boolean isFiltered() {
        return this.filterResetFlag == this.flags.FILTER_RESET_FLAG && this.mFilterParam != 0;
    }

    public boolean isFilteredBy(int i) {
        return this.filterResetFlag == this.flags.FILTER_RESET_FLAG && (this.mFilterParam & i) == i;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.visibleResetFlag = this.flags.VISIBLE_RESET_FLAG;
            this.visibility = 1;
        } else {
            this.visibility = 0;
        }
    }

    public master.flame.danmaku.danmaku.model.DanmakuTimer getTimer() {
        return this.mTimer;
    }

    public void setTimer(master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer) {
        this.mTimer = danmakuTimer;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(java.lang.Object obj) {
        this.tag = obj;
    }

    public void setTimeOffset(long j) {
        this.timeOffset = j;
        this.syncTimeOffsetResetFlag = this.flags.SYNC_TIME_OFFSET_RESET_FLAG;
    }

    public void setTime(long j) {
        this.time = j;
        this.timeOffset = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long getActualTime() {
        master.flame.danmaku.danmaku.model.GlobalFlagValues globalFlagValues = this.flags;
        if (globalFlagValues == null || globalFlagValues.SYNC_TIME_OFFSET_RESET_FLAG != this.syncTimeOffsetResetFlag) {
            return this.time;
        }
        return this.time + this.timeOffset;
    }

    public boolean isOffset() {
        master.flame.danmaku.danmaku.model.GlobalFlagValues globalFlagValues = this.flags;
        if (globalFlagValues == null || globalFlagValues.SYNC_TIME_OFFSET_RESET_FLAG != this.syncTimeOffsetResetFlag) {
            return false;
        }
        return this.isOffset;
    }
}
