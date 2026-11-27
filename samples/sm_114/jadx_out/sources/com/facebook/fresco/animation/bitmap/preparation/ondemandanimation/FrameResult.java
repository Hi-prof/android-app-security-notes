package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

/* JADX INFO: compiled from: FrameLoader.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\rB\u001f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameResult;", "", "bitmapRef", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "type", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameResult$FrameType;", "<init>", "(Lcom/facebook/common/references/CloseableReference;Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameResult$FrameType;)V", "getBitmapRef", "()Lcom/facebook/common/references/CloseableReference;", "getType", "()Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameResult$FrameType;", "FrameType", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FrameResult {
    private final com.facebook.common.references.CloseableReference<android.graphics.Bitmap> bitmapRef;
    private final com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult.FrameType type;

    /* JADX INFO: compiled from: FrameLoader.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameResult$FrameType;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "NEAREST", "MISSING", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public enum FrameType {
        SUCCESS,
        NEAREST,
        MISSING;

        private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());

        public static kotlin.enums.EnumEntries<com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult.FrameType> getEntries() {
            return $ENTRIES;
        }
    }

    public FrameResult(com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference, com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult.FrameType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        this.bitmapRef = closeableReference;
        this.type = type;
    }

    public final com.facebook.common.references.CloseableReference<android.graphics.Bitmap> getBitmapRef() {
        return this.bitmapRef;
    }

    public final com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult.FrameType getType() {
        return this.type;
    }
}
