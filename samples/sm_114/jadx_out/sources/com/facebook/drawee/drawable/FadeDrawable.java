package com.facebook.drawee.drawable;

/* JADX INFO: loaded from: classes.dex */
public class FadeDrawable extends com.facebook.drawee.drawable.ArrayDrawable {
    public static final int TRANSITION_NONE = 2;
    public static final int TRANSITION_RUNNING = 1;
    public static final int TRANSITION_STARTING = 0;
    private final int mActualImageLayer;
    int mAlpha;
    int[] mAlphas;
    private final int mDefaultLayerAlpha;
    private final boolean mDefaultLayerIsOn;
    int mDurationMs;
    private boolean mIsFadingActualImage;
    boolean[] mIsLayerOn;
    private final android.graphics.drawable.Drawable[] mLayers;
    private boolean mMutateDrawables;

    @javax.annotation.Nullable
    private com.facebook.fresco.ui.common.OnFadeListener mOnFadeListener;
    private boolean mOnFadeListenerShowImmediately;
    int mPreventInvalidateCount;
    int[] mStartAlphas;
    long mStartTimeMs;
    int mTransitionState;

    public FadeDrawable(android.graphics.drawable.Drawable[] drawableArr) {
        this(drawableArr, false, -1);
    }

    public FadeDrawable(android.graphics.drawable.Drawable[] drawableArr, boolean z, int i) {
        super(drawableArr);
        this.mMutateDrawables = true;
        com.facebook.common.internal.Preconditions.checkState(drawableArr.length >= 1, "At least one layer required!");
        this.mLayers = drawableArr;
        this.mStartAlphas = new int[drawableArr.length];
        this.mAlphas = new int[drawableArr.length];
        this.mAlpha = 255;
        this.mIsLayerOn = new boolean[drawableArr.length];
        this.mPreventInvalidateCount = 0;
        this.mDefaultLayerIsOn = z;
        this.mDefaultLayerAlpha = z ? 255 : 0;
        this.mActualImageLayer = i;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.mPreventInvalidateCount == 0) {
            super.invalidateSelf();
        }
    }

    public void beginBatchMode() {
        this.mPreventInvalidateCount++;
    }

    public void endBatchMode() {
        this.mPreventInvalidateCount--;
        invalidateSelf();
    }

    public void setTransitionDuration(int i) {
        this.mDurationMs = i;
        if (this.mTransitionState == 1) {
            this.mTransitionState = 0;
        }
    }

    public int getTransitionDuration() {
        return this.mDurationMs;
    }

    private void resetInternal() {
        this.mTransitionState = 2;
        java.util.Arrays.fill(this.mStartAlphas, this.mDefaultLayerAlpha);
        this.mStartAlphas[0] = 255;
        java.util.Arrays.fill(this.mAlphas, this.mDefaultLayerAlpha);
        this.mAlphas[0] = 255;
        java.util.Arrays.fill(this.mIsLayerOn, this.mDefaultLayerIsOn);
        this.mIsLayerOn[0] = true;
    }

    public void reset() {
        resetInternal();
        invalidateSelf();
    }

    public void fadeInLayer(int i) {
        this.mTransitionState = 0;
        this.mIsLayerOn[i] = true;
        invalidateSelf();
    }

    public void fadeOutLayer(int i) {
        this.mTransitionState = 0;
        this.mIsLayerOn[i] = false;
        invalidateSelf();
    }

    public void fadeInAllLayers() {
        this.mTransitionState = 0;
        java.util.Arrays.fill(this.mIsLayerOn, true);
        invalidateSelf();
    }

    public void fadeOutAllLayers() {
        this.mTransitionState = 0;
        java.util.Arrays.fill(this.mIsLayerOn, false);
        invalidateSelf();
    }

    public void fadeToLayer(int i) {
        this.mTransitionState = 0;
        java.util.Arrays.fill(this.mIsLayerOn, false);
        this.mIsLayerOn[i] = true;
        invalidateSelf();
    }

    public void fadeUpToLayer(int i) {
        this.mTransitionState = 0;
        int i2 = i + 1;
        java.util.Arrays.fill(this.mIsLayerOn, 0, i2, true);
        java.util.Arrays.fill(this.mIsLayerOn, i2, this.mLayers.length, false);
        invalidateSelf();
    }

    public void showLayerImmediately(int i) {
        this.mIsLayerOn[i] = true;
        this.mAlphas[i] = 255;
        if (i == this.mActualImageLayer) {
            this.mOnFadeListenerShowImmediately = true;
        }
        invalidateSelf();
    }

    public void hideLayerImmediately(int i) {
        this.mIsLayerOn[i] = false;
        this.mAlphas[i] = 0;
        invalidateSelf();
    }

    public void finishTransitionImmediately() {
        this.mTransitionState = 2;
        for (int i = 0; i < this.mLayers.length; i++) {
            this.mAlphas[i] = this.mIsLayerOn[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean updateAlphas(float f) {
        boolean z = true;
        for (int i = 0; i < this.mLayers.length; i++) {
            boolean z2 = this.mIsLayerOn[i];
            int i2 = z2 ? 1 : -1;
            int[] iArr = this.mAlphas;
            int i3 = (int) (this.mStartAlphas[i] + (i2 * 255 * f));
            iArr[i] = i3;
            if (i3 < 0) {
                iArr[i] = 0;
            }
            if (iArr[i] > 255) {
                iArr[i] = 255;
            }
            if (z2 && iArr[i] < 255) {
                z = false;
            }
            if (!z2 && iArr[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0056 A[LOOP:0: B:25:0x0051->B:27:0x0056, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x0074  */
    /* JADX WARN: Code duplicated, block: B:31:0x007b  */
    /* JADX WARN: Code duplicated, block: B:33:0x0072 A[EDGE_INSN: B:33:0x0072->B:28:0x0072 BREAK  A[LOOP:0: B:25:0x0051->B:27:0x0056], SYNTHETIC] */
    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        boolean zUpdateAlphas;
        android.graphics.drawable.Drawable[] drawableArr;
        int i = this.mTransitionState;
        int i2 = 0;
        boolean z = true;
        if (i != 0) {
            if (i == 1) {
                com.facebook.common.internal.Preconditions.checkState(this.mDurationMs > 0);
                zUpdateAlphas = updateAlphas((getCurrentTimeMs() - this.mStartTimeMs) / this.mDurationMs);
                this.mTransitionState = zUpdateAlphas ? 2 : 1;
            }
            while (true) {
                drawableArr = this.mLayers;
                if (i2 < drawableArr.length) {
                    break;
                }
                drawDrawableWithAlpha(canvas, drawableArr[i2], (int) java.lang.Math.ceil(((double) (this.mAlphas[i2] * this.mAlpha)) / 255.0d));
                i2++;
            }
            if (z) {
                maybeOnFadeFinished();
                maybeOnImageShownImmediately();
            } else {
                invalidateSelf();
            }
        }
        java.lang.System.arraycopy(this.mAlphas, 0, this.mStartAlphas, 0, this.mLayers.length);
        this.mStartTimeMs = getCurrentTimeMs();
        zUpdateAlphas = updateAlphas(this.mDurationMs == 0 ? 1.0f : 0.0f);
        maybeOnFadeStarted();
        this.mTransitionState = zUpdateAlphas ? 2 : 1;
        z = zUpdateAlphas;
        while (true) {
            drawableArr = this.mLayers;
            if (i2 < drawableArr.length) {
                break;
                break;
            } else {
                drawDrawableWithAlpha(canvas, drawableArr[i2], (int) java.lang.Math.ceil(((double) (this.mAlphas[i2] * this.mAlpha)) / 255.0d));
                i2++;
            }
        }
        if (z) {
            maybeOnFadeFinished();
            maybeOnImageShownImmediately();
        } else {
            invalidateSelf();
        }
    }

    private void maybeOnImageShownImmediately() {
        if (this.mOnFadeListenerShowImmediately && this.mTransitionState == 2 && this.mIsLayerOn[this.mActualImageLayer]) {
            com.facebook.fresco.ui.common.OnFadeListener onFadeListener = this.mOnFadeListener;
            if (onFadeListener != null) {
                onFadeListener.onShownImmediately();
            }
            this.mOnFadeListenerShowImmediately = false;
        }
    }

    private void drawDrawableWithAlpha(android.graphics.Canvas canvas, android.graphics.drawable.Drawable drawable, int i) {
        if (drawable == null || i <= 0) {
            return;
        }
        this.mPreventInvalidateCount++;
        if (this.mMutateDrawables) {
            drawable.mutate();
        }
        drawable.setAlpha(i);
        this.mPreventInvalidateCount--;
        drawable.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mAlpha != i) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    protected long getCurrentTimeMs() {
        return android.os.SystemClock.uptimeMillis();
    }

    public int getTransitionState() {
        return this.mTransitionState;
    }

    public boolean isLayerOn(int i) {
        return this.mIsLayerOn[i];
    }

    public boolean isDefaultLayerIsOn() {
        return this.mDefaultLayerIsOn;
    }

    public void setOnFadeListener(@javax.annotation.Nullable com.facebook.fresco.ui.common.OnFadeListener onFadeListener) {
        this.mOnFadeListener = onFadeListener;
    }

    public void setMutateDrawables(boolean z) {
        this.mMutateDrawables = z;
    }

    private void maybeOnFadeStarted() {
        int i;
        if (!this.mIsFadingActualImage && (i = this.mActualImageLayer) >= 0) {
            boolean[] zArr = this.mIsLayerOn;
            if (i < zArr.length && zArr[i]) {
                this.mIsFadingActualImage = true;
                com.facebook.fresco.ui.common.OnFadeListener onFadeListener = this.mOnFadeListener;
                if (onFadeListener != null) {
                    onFadeListener.onFadeStarted();
                }
            }
        }
    }

    private void maybeOnFadeFinished() {
        if (this.mIsFadingActualImage) {
            this.mIsFadingActualImage = false;
            com.facebook.fresco.ui.common.OnFadeListener onFadeListener = this.mOnFadeListener;
            if (onFadeListener != null) {
                onFadeListener.onFadeFinished();
            }
        }
    }
}
