package com.facebook.fresco.animation.backend;

/* JADX INFO: loaded from: classes.dex */
public class AnimationBackendDelegate<T extends com.facebook.fresco.animation.backend.AnimationBackend> implements com.facebook.fresco.animation.backend.AnimationBackend {
    private static final int ALPHA_UNSET = -1;
    private int mAlpha = -1;

    @javax.annotation.Nullable
    private T mAnimationBackend;

    @javax.annotation.Nullable
    private android.graphics.Rect mBounds;

    @javax.annotation.Nullable
    private android.graphics.ColorFilter mColorFilter;

    public AnimationBackendDelegate(@javax.annotation.Nullable T t) {
        this.mAnimationBackend = t;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i) {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getFrameDurationMs(i);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopDurationMs() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getLoopDurationMs();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int width() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.width();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int height() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.height();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(android.graphics.drawable.Drawable drawable, android.graphics.Canvas canvas, int i) {
        T t = this.mAnimationBackend;
        return t != null && t.drawFrame(drawable, canvas, i);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(int i) {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.setAlpha(i);
        }
        this.mAlpha = i;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(@javax.annotation.Nullable android.graphics.ColorFilter colorFilter) {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.setColorFilter(colorFilter);
        }
        this.mColorFilter = colorFilter;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(android.graphics.Rect rect) {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.setBounds(rect);
        }
        this.mBounds = rect;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getSizeInBytes();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.clear();
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void preloadAnimation() {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.preloadAnimation();
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAnimationListener(@javax.annotation.Nullable com.facebook.fresco.animation.backend.AnimationBackend.Listener listener) {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.setAnimationListener(listener);
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return -1;
        }
        return t.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return -1;
        }
        return t.getIntrinsicHeight();
    }

    public void setAnimationBackend(@javax.annotation.Nullable T t) {
        this.mAnimationBackend = t;
        if (t != null) {
            applyBackendProperties(t);
        }
    }

    @javax.annotation.Nullable
    public T getAnimationBackend() {
        return this.mAnimationBackend;
    }

    private void applyBackendProperties(com.facebook.fresco.animation.backend.AnimationBackend animationBackend) {
        android.graphics.Rect rect = this.mBounds;
        if (rect != null) {
            animationBackend.setBounds(rect);
        }
        int i = this.mAlpha;
        if (i >= 0 && i <= 255) {
            animationBackend.setAlpha(i);
        }
        android.graphics.ColorFilter colorFilter = this.mColorFilter;
        if (colorFilter != null) {
            animationBackend.setColorFilter(colorFilter);
        }
    }
}
