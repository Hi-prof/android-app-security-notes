package com.dcloud.zxing2.oned.rss;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractRSSReader extends com.dcloud.zxing2.oned.OneDReader {
    private static final float MAX_AVG_VARIANCE = 0.2f;
    private static final float MAX_FINDER_PATTERN_RATIO = 0.89285713f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.45f;
    private static final float MIN_FINDER_PATTERN_RATIO = 0.7916667f;
    private final int[] decodeFinderCounters = new int[4];
    private final int[] dataCharacterCounters = new int[8];
    private final float[] oddRoundingErrors = new float[4];
    private final float[] evenRoundingErrors = new float[4];
    private final int[] oddCounts = new int[4];
    private final int[] evenCounts = new int[4];

    protected AbstractRSSReader() {
    }

    protected static int count(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    protected static void decrement(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            float f2 = fArr[i2];
            if (f2 < f) {
                i = i2;
                f = f2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    protected static void increment(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            float f2 = fArr[i2];
            if (f2 > f) {
                i = i2;
                f = f2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    protected static boolean isFinderPattern(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f = i / ((iArr[2] + i) + iArr[3]);
        if (f >= MIN_FINDER_PATTERN_RATIO && f <= MAX_FINDER_PATTERN_RATIO) {
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MIN_VALUE;
            for (int i4 : iArr) {
                if (i4 > i3) {
                    i3 = i4;
                }
                if (i4 < i2) {
                    i2 = i4;
                }
            }
            if (i3 < i2 * 10) {
                return true;
            }
        }
        return false;
    }

    protected static int parseFinderValue(int[] iArr, int[][] iArr2) throws com.dcloud.zxing2.NotFoundException {
        for (int i = 0; i < iArr2.length; i++) {
            if (com.dcloud.zxing2.oned.OneDReader.patternMatchVariance(iArr, iArr2[i], MAX_INDIVIDUAL_VARIANCE) < 0.2f) {
                return i;
            }
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    protected final int[] getDataCharacterCounters() {
        return this.dataCharacterCounters;
    }

    protected final int[] getDecodeFinderCounters() {
        return this.decodeFinderCounters;
    }

    protected final int[] getEvenCounts() {
        return this.evenCounts;
    }

    protected final float[] getEvenRoundingErrors() {
        return this.evenRoundingErrors;
    }

    protected final int[] getOddCounts() {
        return this.oddCounts;
    }

    protected final float[] getOddRoundingErrors() {
        return this.oddRoundingErrors;
    }
}
