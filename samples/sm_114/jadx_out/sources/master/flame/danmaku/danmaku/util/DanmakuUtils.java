package master.flame.danmaku.danmaku.util;

/* JADX INFO: loaded from: classes2.dex */
public class DanmakuUtils {
    public static int getCacheSize(int i, int i2) {
        return i * i2 * 4;
    }

    public static boolean willHitInDuration(master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2, long j, long j2) {
        int type = baseDanmaku.getType();
        if (type != baseDanmaku2.getType() || baseDanmaku.isOutside()) {
            return false;
        }
        long actualTime = baseDanmaku2.getActualTime() - baseDanmaku.getActualTime();
        if (actualTime <= 0) {
            return true;
        }
        if (java.lang.Math.abs(actualTime) >= j || baseDanmaku.isTimeOut() || baseDanmaku2.isTimeOut()) {
            return false;
        }
        return type == 5 || type == 4 || checkHitAtTime(iDisplayer, baseDanmaku, baseDanmaku2, j2) || checkHitAtTime(iDisplayer, baseDanmaku, baseDanmaku2, baseDanmaku.getActualTime() + baseDanmaku.getDuration());
    }

    private static boolean checkHitAtTime(master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2, long j) {
        float[] rectAtTime = baseDanmaku.getRectAtTime(iDisplayer, j);
        float[] rectAtTime2 = baseDanmaku2.getRectAtTime(iDisplayer, j);
        if (rectAtTime == null || rectAtTime2 == null) {
            return false;
        }
        return checkHit(baseDanmaku.getType(), baseDanmaku2.getType(), rectAtTime, rectAtTime2);
    }

    private static boolean checkHit(int i, int i2, float[] fArr, float[] fArr2) {
        if (i != i2) {
            return false;
        }
        if (i == 1) {
            return fArr2[0] < fArr[2];
        }
        return i == 6 && fArr2[2] > fArr[0];
    }

    public static master.flame.danmaku.danmaku.model.android.DrawingCache buildDanmakuDrawingCache(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, master.flame.danmaku.danmaku.model.android.DrawingCache drawingCache) {
        if (drawingCache == null) {
            drawingCache = new master.flame.danmaku.danmaku.model.android.DrawingCache();
        }
        drawingCache.build((int) java.lang.Math.ceil(baseDanmaku.paintWidth), (int) java.lang.Math.ceil(baseDanmaku.paintHeight), iDisplayer.getDensityDpi(), false);
        master.flame.danmaku.danmaku.model.android.DrawingCacheHolder drawingCacheHolder = drawingCache.get();
        if (drawingCacheHolder != null) {
            ((master.flame.danmaku.danmaku.model.AbsDisplayer) iDisplayer).drawDanmaku(baseDanmaku, drawingCacheHolder.canvas, 0.0f, 0.0f, true);
            if (iDisplayer.isHardwareAccelerated()) {
                drawingCacheHolder.splitWith(iDisplayer.getWidth(), iDisplayer.getHeight(), iDisplayer.getMaximumCacheWidth(), iDisplayer.getMaximumCacheHeight());
            }
        }
        return drawingCache;
    }

    public static final boolean isDuplicate(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2) {
        if (baseDanmaku == baseDanmaku2) {
            return false;
        }
        if (baseDanmaku.text == baseDanmaku2.text) {
            return true;
        }
        return baseDanmaku.text != null && baseDanmaku.text.equals(baseDanmaku2.text);
    }

    public static final int compare(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2) {
        if (baseDanmaku == baseDanmaku2) {
            return 0;
        }
        if (baseDanmaku == null) {
            return -1;
        }
        if (baseDanmaku2 == null) {
            return 1;
        }
        long time = baseDanmaku.getTime() - baseDanmaku2.getTime();
        if (time > 0) {
            return 1;
        }
        if (time < 0) {
            return -1;
        }
        int type = baseDanmaku.getType() - baseDanmaku2.getType();
        if (type > 0) {
            return 1;
        }
        if (type < 0 || baseDanmaku.text == null) {
            return -1;
        }
        if (baseDanmaku2.text == null) {
            return 1;
        }
        int iCompareTo = baseDanmaku.text.toString().compareTo(baseDanmaku2.text.toString());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int i = baseDanmaku.textColor - baseDanmaku2.textColor;
        if (i != 0) {
            return i < 0 ? -1 : 1;
        }
        int i2 = baseDanmaku.index - baseDanmaku2.index;
        if (i2 != 0) {
            return i2 < 0 ? -1 : 1;
        }
        return baseDanmaku.hashCode() - baseDanmaku.hashCode();
    }

    public static final boolean isOverSize(master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
        if (iDisplayer.isHardwareAccelerated()) {
            return baseDanmaku.paintWidth > ((float) iDisplayer.getMaximumCacheWidth()) || baseDanmaku.paintHeight > ((float) iDisplayer.getMaximumCacheHeight());
        }
        return false;
    }

    public static void fillText(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, java.lang.CharSequence charSequence) {
        baseDanmaku.text = charSequence;
        if (android.text.TextUtils.isEmpty(charSequence) || !charSequence.toString().contains(master.flame.danmaku.danmaku.model.BaseDanmaku.DANMAKU_BR_CHAR)) {
            return;
        }
        java.lang.String[] strArrSplit = java.lang.String.valueOf(baseDanmaku.text).split(master.flame.danmaku.danmaku.model.BaseDanmaku.DANMAKU_BR_CHAR, -1);
        if (strArrSplit.length > 1) {
            baseDanmaku.lines = strArrSplit;
        }
    }
}
