package com.facebook.fresco.animation.bitmap.preparation.loadframe;

/* JADX INFO: compiled from: FpsCompressorInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u0003J*\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003J6\u0010\u0010\u001a\u00020\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nH\u0002J\n\u0010\u0012\u001a\u00020\u0013*\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/loadframe/FpsCompressorInfo;", "", "maxFpsLimit", "", "<init>", "(I)V", "compress", "Lcom/facebook/fresco/animation/bitmap/preparation/loadframe/FpsCompressorInfo$CompressionResult;", "durationMs", "frameBitmaps", "", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "targetFps", "calculateReducedIndexes", "frameCount", "compressAnimation", "realToReducedIndex", "millisecondsToSeconds", "", "CompressionResult", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FpsCompressorInfo {
    private final int maxFpsLimit;

    public final float millisecondsToSeconds(int i) {
        return i / 1000.0f;
    }

    public FpsCompressorInfo(int i) {
        this.maxFpsLimit = i;
    }

    public final com.facebook.fresco.animation.bitmap.preparation.loadframe.FpsCompressorInfo.CompressionResult compress(int durationMs, java.util.Map<java.lang.Integer, ? extends com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> frameBitmaps, int targetFps) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(frameBitmaps, "frameBitmaps");
        return compressAnimation(frameBitmaps, calculateReducedIndexes(durationMs, frameBitmaps.size(), targetFps));
    }

    public final java.util.Map<java.lang.Integer, java.lang.Integer> calculateReducedIndexes(int durationMs, int frameCount, int targetFps) {
        float fCoerceAtLeast = kotlin.ranges.RangesKt.coerceAtLeast(kotlin.ranges.RangesKt.coerceAtMost(kotlin.ranges.RangesKt.coerceAtLeast(targetFps, 1), this.maxFpsLimit) * millisecondsToSeconds(durationMs), 0.0f);
        float f = frameCount;
        float fCoerceAtMost = f / kotlin.ranges.RangesKt.coerceAtMost(fCoerceAtLeast, f);
        int i = 0;
        kotlin.ranges.IntRange intRangeUntil = kotlin.ranges.RangesKt.until(0, frameCount);
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(kotlin.ranges.RangesKt.coerceAtLeast(kotlin.collections.MapsKt.mapCapacity(kotlin.collections.CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10)), 16));
        for (java.lang.Integer num : intRangeUntil) {
            java.util.LinkedHashMap linkedHashMap2 = linkedHashMap;
            int iIntValue = num.intValue();
            if (((int) (iIntValue % fCoerceAtMost)) == 0) {
                i = iIntValue;
            }
            linkedHashMap2.put(num, java.lang.Integer.valueOf(i));
        }
        return linkedHashMap;
    }

    private final com.facebook.fresco.animation.bitmap.preparation.loadframe.FpsCompressorInfo.CompressionResult compressAnimation(java.util.Map<java.lang.Integer, ? extends com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> frameBitmaps, java.util.Map<java.lang.Integer, java.lang.Integer> realToReducedIndex) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.util.Map.Entry<java.lang.Integer, ? extends com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> entry : frameBitmaps.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> value = entry.getValue();
            java.lang.Integer num = realToReducedIndex.get(java.lang.Integer.valueOf(iIntValue));
            if (num != null) {
                num.intValue();
                if (linkedHashMap.containsKey(num)) {
                    arrayList.add(value);
                } else {
                    linkedHashMap.put(num, value);
                }
            }
        }
        return new com.facebook.fresco.animation.bitmap.preparation.loadframe.FpsCompressorInfo.CompressionResult(linkedHashMap, realToReducedIndex, arrayList);
    }

    /* JADX INFO: compiled from: FpsCompressorInfo.kt */
    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001BI\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\t¢\u0006\u0004\b\n\u0010\u000bR#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/loadframe/FpsCompressorInfo$CompressionResult;", "", "compressedAnim", "", "", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "realToReducedIndex", "removedFrames", "", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/List;)V", "getCompressedAnim", "()Ljava/util/Map;", "getRealToReducedIndex", "getRemovedFrames", "()Ljava/util/List;", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CompressionResult {
        private final java.util.Map<java.lang.Integer, com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> compressedAnim;
        private final java.util.Map<java.lang.Integer, java.lang.Integer> realToReducedIndex;
        private final java.util.List<com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> removedFrames;

        /* JADX WARN: Multi-variable type inference failed */
        public CompressionResult(java.util.Map<java.lang.Integer, ? extends com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> compressedAnim, java.util.Map<java.lang.Integer, java.lang.Integer> realToReducedIndex, java.util.List<? extends com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> removedFrames) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(compressedAnim, "compressedAnim");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(realToReducedIndex, "realToReducedIndex");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(removedFrames, "removedFrames");
            this.compressedAnim = compressedAnim;
            this.realToReducedIndex = realToReducedIndex;
            this.removedFrames = removedFrames;
        }

        public final java.util.Map<java.lang.Integer, com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> getCompressedAnim() {
            return this.compressedAnim;
        }

        public final java.util.Map<java.lang.Integer, java.lang.Integer> getRealToReducedIndex() {
            return this.realToReducedIndex;
        }

        public final java.util.List<com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> getRemovedFrames() {
            return this.removedFrames;
        }
    }
}
