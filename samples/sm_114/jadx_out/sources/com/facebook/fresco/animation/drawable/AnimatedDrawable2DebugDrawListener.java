package com.facebook.fresco.animation.drawable;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedDrawable2DebugDrawListener implements com.facebook.fresco.animation.drawable.AnimatedDrawable2.DrawListener {
    private static final java.lang.Class<?> TAG = com.facebook.fresco.animation.drawable.AnimatedDrawable2DebugDrawListener.class;
    private int mDrawCalls;
    private int mDuplicateFrames;
    private int mLastFrameNumber = -1;
    private int mSkippedFrames;

    @Override // com.facebook.fresco.animation.drawable.AnimatedDrawable2.DrawListener
    public void onDraw(com.facebook.fresco.animation.drawable.AnimatedDrawable2 animatedDrawable2, com.facebook.fresco.animation.frame.FrameScheduler frameScheduler, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        if (animatedDrawable2.getAnimationBackend() == null) {
            return;
        }
        int frameCount = animatedDrawable2.getAnimationBackend().getFrameCount();
        long j8 = j2 - j3;
        this.mDrawCalls++;
        int i2 = this.mLastFrameNumber;
        int i3 = (i2 + 1) % frameCount;
        if (i3 != i) {
            if (i2 == i) {
                this.mDuplicateFrames++;
            } else {
                int i4 = (i - i3) % frameCount;
                if (i4 < 0) {
                    i4 += frameCount;
                }
                this.mSkippedFrames += i4;
            }
        }
        this.mLastFrameNumber = i;
        com.facebook.common.logging.FLog.d(TAG, "draw: frame: %2d, drawn: %b, delay: %3d ms, rendering: %3d ms, prev: %3d ms ago, duplicates: %3d, skipped: %3d, draw calls: %4d, anim time: %6d ms, next start: %6d ms, next scheduled: %6d ms", java.lang.Integer.valueOf(i), java.lang.Boolean.valueOf(z), java.lang.Long.valueOf((j2 % frameScheduler.getLoopDurationMs()) - frameScheduler.getTargetRenderTimeMs(i)), java.lang.Long.valueOf(j5 - j4), java.lang.Long.valueOf(j8), java.lang.Integer.valueOf(this.mDuplicateFrames), java.lang.Integer.valueOf(this.mSkippedFrames), java.lang.Integer.valueOf(this.mDrawCalls), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j6), java.lang.Long.valueOf(j7));
    }
}
