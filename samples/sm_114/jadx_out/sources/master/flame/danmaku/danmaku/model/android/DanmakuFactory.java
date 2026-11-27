package master.flame.danmaku.danmaku.model.android;

/* JADX INFO: loaded from: classes2.dex */
public class DanmakuFactory {
    public static final float BILI_PLAYER_HEIGHT = 438.0f;
    public static final float BILI_PLAYER_WIDTH = 682.0f;
    public static final long COMMON_DANMAKU_DURATION = 3800;
    public static final int DANMAKU_MEDIUM_TEXTSIZE = 25;
    public static final long MAX_DANMAKU_DURATION_HIGH_DENSITY = 9000;
    public static final long MIN_DANMAKU_DURATION = 4000;
    public static final float OLD_BILI_PLAYER_HEIGHT = 385.0f;
    public static final float OLD_BILI_PLAYER_WIDTH = 539.0f;
    public master.flame.danmaku.danmaku.model.Duration MAX_Duration_Fix_Danmaku;
    public master.flame.danmaku.danmaku.model.Duration MAX_Duration_Scroll_Danmaku;
    public master.flame.danmaku.danmaku.model.Duration MAX_Duration_Special_Danmaku;
    private master.flame.danmaku.danmaku.model.android.DanmakuContext sLastConfig;
    public master.flame.danmaku.danmaku.model.IDisplayer sLastDisp;
    public int CURRENT_DISP_WIDTH = 0;
    public int CURRENT_DISP_HEIGHT = 0;
    private float CURRENT_DISP_SIZE_FACTOR = 1.0f;
    public long REAL_DANMAKU_DURATION = COMMON_DANMAKU_DURATION;
    public long MAX_DANMAKU_DURATION = MIN_DANMAKU_DURATION;
    public master.flame.danmaku.danmaku.model.IDanmakus sSpecialDanmakus = new master.flame.danmaku.danmaku.model.android.Danmakus();

    static master.flame.danmaku.danmaku.model.android.DanmakuFactory create() {
        return new master.flame.danmaku.danmaku.model.android.DanmakuFactory();
    }

    protected DanmakuFactory() {
    }

    public void resetDurationsData() {
        this.sLastDisp = null;
        this.CURRENT_DISP_HEIGHT = 0;
        this.CURRENT_DISP_WIDTH = 0;
        this.sSpecialDanmakus.clear();
        this.MAX_Duration_Scroll_Danmaku = null;
        this.MAX_Duration_Fix_Danmaku = null;
        this.MAX_Duration_Special_Danmaku = null;
        this.MAX_DANMAKU_DURATION = MIN_DANMAKU_DURATION;
    }

    public void notifyDispSizeChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
        this.sLastConfig = danmakuContext;
        this.sLastDisp = danmakuContext.getDisplayer();
        createDanmaku(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.BaseDanmaku createDanmaku(int i) {
        return createDanmaku(i, this.sLastConfig);
    }

    public master.flame.danmaku.danmaku.model.BaseDanmaku createDanmaku(int i, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.sLastConfig = danmakuContext;
        master.flame.danmaku.danmaku.model.AbsDisplayer displayer = danmakuContext.getDisplayer();
        this.sLastDisp = displayer;
        return createDanmaku(i, displayer.getWidth(), this.sLastDisp.getHeight(), this.CURRENT_DISP_SIZE_FACTOR, danmakuContext.scrollSpeedFactor);
    }

    public master.flame.danmaku.danmaku.model.BaseDanmaku createDanmaku(int i, master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, float f, float f2) {
        if (iDisplayer == null) {
            return null;
        }
        this.sLastDisp = iDisplayer;
        return createDanmaku(i, iDisplayer.getWidth(), iDisplayer.getHeight(), f, f2);
    }

    public master.flame.danmaku.danmaku.model.BaseDanmaku createDanmaku(int i, int i2, int i3, float f, float f2) {
        return createDanmaku(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.BaseDanmaku createDanmaku(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        int i2 = this.CURRENT_DISP_WIDTH;
        int i3 = this.CURRENT_DISP_HEIGHT;
        boolean zUpdateViewportState = updateViewportState(f, f2, f3);
        master.flame.danmaku.danmaku.model.Duration duration = this.MAX_Duration_Scroll_Danmaku;
        if (duration == null) {
            master.flame.danmaku.danmaku.model.Duration duration2 = new master.flame.danmaku.danmaku.model.Duration(this.REAL_DANMAKU_DURATION);
            this.MAX_Duration_Scroll_Danmaku = duration2;
            duration2.setFactor(f4);
        } else if (zUpdateViewportState) {
            duration.setValue(this.REAL_DANMAKU_DURATION);
        }
        if (this.MAX_Duration_Fix_Danmaku == null) {
            this.MAX_Duration_Fix_Danmaku = new master.flame.danmaku.danmaku.model.Duration(COMMON_DANMAKU_DURATION);
        }
        if (zUpdateViewportState && f > 0.0f) {
            updateMaxDanmakuDuration();
            if (i2 <= 0 || i3 <= 0) {
                f5 = 1.0f;
                f6 = 1.0f;
            } else {
                f5 = f / i2;
                f6 = f2 / i3;
            }
            if (f2 > 0.0f) {
                updateSpecialDanmakusDate(f5, f6);
            }
        }
        if (i == 1) {
            return new master.flame.danmaku.danmaku.model.R2LDanmaku(this.MAX_Duration_Scroll_Danmaku);
        }
        if (i == 4) {
            return new master.flame.danmaku.danmaku.model.FBDanmaku(this.MAX_Duration_Fix_Danmaku);
        }
        if (i == 5) {
            return new master.flame.danmaku.danmaku.model.FTDanmaku(this.MAX_Duration_Fix_Danmaku);
        }
        if (i == 6) {
            return new master.flame.danmaku.danmaku.model.L2RDanmaku(this.MAX_Duration_Scroll_Danmaku);
        }
        if (i != 7) {
            return null;
        }
        master.flame.danmaku.danmaku.model.SpecialDanmaku specialDanmaku = new master.flame.danmaku.danmaku.model.SpecialDanmaku();
        this.sSpecialDanmakus.addItem(specialDanmaku);
        return specialDanmaku;
    }

    public boolean updateViewportState(float f, float f2, float f3) {
        int i = (int) f;
        if (this.CURRENT_DISP_WIDTH == i && this.CURRENT_DISP_HEIGHT == ((int) f2) && this.CURRENT_DISP_SIZE_FACTOR == f3) {
            return false;
        }
        long j = (long) (((f * f3) / 682.0f) * 3800.0f);
        this.REAL_DANMAKU_DURATION = j;
        long jMin = java.lang.Math.min(MAX_DANMAKU_DURATION_HIGH_DENSITY, j);
        this.REAL_DANMAKU_DURATION = jMin;
        this.REAL_DANMAKU_DURATION = java.lang.Math.max(MIN_DANMAKU_DURATION, jMin);
        this.CURRENT_DISP_WIDTH = i;
        this.CURRENT_DISP_HEIGHT = (int) f2;
        this.CURRENT_DISP_SIZE_FACTOR = f3;
        return true;
    }

    private void updateSpecialDanmakusDate(float f, float f2) {
        master.flame.danmaku.danmaku.model.IDanmakuIterator it = this.sSpecialDanmakus.iterator();
        while (it.hasNext()) {
            master.flame.danmaku.danmaku.model.SpecialDanmaku specialDanmaku = (master.flame.danmaku.danmaku.model.SpecialDanmaku) it.next();
            fillTranslationData(specialDanmaku, specialDanmaku.beginX, specialDanmaku.beginY, specialDanmaku.endX, specialDanmaku.endY, specialDanmaku.translationDuration, specialDanmaku.translationStartDelay, f, f2);
            master.flame.danmaku.danmaku.model.SpecialDanmaku.LinePath[] linePathArr = specialDanmaku.linePaths;
            if (linePathArr != null && linePathArr.length > 0) {
                int length = linePathArr.length;
                int i = 0;
                float[][] fArr = (float[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Float.TYPE, length + 1, 2);
                while (i < length) {
                    fArr[i] = linePathArr[i].getBeginPoint();
                    int i2 = i + 1;
                    fArr[i2] = linePathArr[i].getEndPoint();
                    i = i2;
                }
                fillLinePathData(specialDanmaku, fArr, f, f2);
            }
        }
    }

    public void updateMaxDanmakuDuration() {
        master.flame.danmaku.danmaku.model.Duration duration = this.MAX_Duration_Scroll_Danmaku;
        long j = duration == null ? 0L : duration.value;
        master.flame.danmaku.danmaku.model.Duration duration2 = this.MAX_Duration_Fix_Danmaku;
        long j2 = duration2 == null ? 0L : duration2.value;
        master.flame.danmaku.danmaku.model.Duration duration3 = this.MAX_Duration_Special_Danmaku;
        long j3 = duration3 != null ? duration3.value : 0L;
        long jMax = java.lang.Math.max(j, j2);
        this.MAX_DANMAKU_DURATION = jMax;
        long jMax2 = java.lang.Math.max(jMax, j3);
        this.MAX_DANMAKU_DURATION = jMax2;
        long jMax3 = java.lang.Math.max(COMMON_DANMAKU_DURATION, jMax2);
        this.MAX_DANMAKU_DURATION = jMax3;
        this.MAX_DANMAKU_DURATION = java.lang.Math.max(this.REAL_DANMAKU_DURATION, jMax3);
    }

    public void updateDurationFactor(float f) {
        master.flame.danmaku.danmaku.model.Duration duration = this.MAX_Duration_Scroll_Danmaku;
        if (duration == null || this.MAX_Duration_Fix_Danmaku == null) {
            return;
        }
        duration.setFactor(f);
        updateMaxDanmakuDuration();
    }

    public void fillTranslationData(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, float f, float f2, float f3, float f4, long j, long j2, float f5, float f6) {
        if (baseDanmaku.getType() != 7) {
            return;
        }
        ((master.flame.danmaku.danmaku.model.SpecialDanmaku) baseDanmaku).setTranslationData(f * f5, f2 * f6, f3 * f5, f4 * f6, j, j2);
        updateSpecicalDanmakuDuration(baseDanmaku);
    }

    public static void fillLinePathData(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, float[][] fArr, float f, float f2) {
        if (baseDanmaku.getType() == 7 && fArr.length != 0 && fArr[0].length == 2) {
            for (float[] fArr2 : fArr) {
                fArr2[0] = fArr2[0] * f;
                fArr2[1] = fArr2[1] * f2;
            }
            ((master.flame.danmaku.danmaku.model.SpecialDanmaku) baseDanmaku).setLinePathData(fArr);
        }
    }

    public void fillAlphaData(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, long j) {
        if (baseDanmaku.getType() != 7) {
            return;
        }
        ((master.flame.danmaku.danmaku.model.SpecialDanmaku) baseDanmaku).setAlphaData(i, i2, j);
        updateSpecicalDanmakuDuration(baseDanmaku);
    }

    private void updateSpecicalDanmakuDuration(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
        if (this.MAX_Duration_Special_Danmaku == null || (baseDanmaku.duration != null && baseDanmaku.duration.value > this.MAX_Duration_Special_Danmaku.value)) {
            this.MAX_Duration_Special_Danmaku = baseDanmaku.duration;
            updateMaxDanmakuDuration();
        }
    }
}
