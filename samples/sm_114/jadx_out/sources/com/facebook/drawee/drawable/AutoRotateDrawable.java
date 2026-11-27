package com.facebook.drawee.drawable;

/* JADX INFO: loaded from: classes.dex */
public class AutoRotateDrawable extends com.facebook.drawee.drawable.ForwardingDrawable implements java.lang.Runnable, com.facebook.drawee.drawable.CloneableDrawable {
    private static final int DEGREES_IN_FULL_ROTATION = 360;
    private static final int FRAME_INTERVAL_MS = 20;
    private boolean mClockwise;
    private int mInterval;
    private boolean mIsScheduled;
    float mRotationAngle;

    public AutoRotateDrawable(android.graphics.drawable.Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public AutoRotateDrawable(android.graphics.drawable.Drawable drawable, int i, boolean z) {
        super((android.graphics.drawable.Drawable) com.facebook.common.internal.Preconditions.checkNotNull(drawable));
        this.mRotationAngle = 0.0f;
        this.mIsScheduled = false;
        this.mInterval = i;
        this.mClockwise = z;
    }

    public void reset() {
        this.mRotationAngle = 0.0f;
        this.mIsScheduled = false;
        unscheduleSelf(this);
        invalidateSelf();
    }

    public void setClockwise(boolean z) {
        this.mClockwise = z;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        int iSave = canvas.save();
        android.graphics.Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.mRotationAngle;
        if (!this.mClockwise) {
            f = 360.0f - f;
        }
        canvas.rotate(f, bounds.left + (i / 2), bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(iSave);
        scheduleNextFrame();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mIsScheduled = false;
        this.mRotationAngle += getIncrement();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.CloneableDrawable
    public com.facebook.drawee.drawable.AutoRotateDrawable cloneDrawable() {
        android.graphics.drawable.Drawable drawableCloneDrawable = com.facebook.drawee.drawable.DrawableUtils.cloneDrawable(getDrawable());
        if (drawableCloneDrawable == null) {
            return null;
        }
        return new com.facebook.drawee.drawable.AutoRotateDrawable(drawableCloneDrawable, this.mInterval, this.mClockwise);
    }

    private void scheduleNextFrame() {
        if (this.mIsScheduled) {
            return;
        }
        this.mIsScheduled = true;
        scheduleSelf(this, android.os.SystemClock.uptimeMillis() + 20);
    }

    private int getIncrement() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
