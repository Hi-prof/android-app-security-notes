package com.facebook.drawee.drawable;

/* JADX INFO: loaded from: classes.dex */
public class MatrixDrawable extends com.facebook.drawee.drawable.ForwardingDrawable {

    @javax.annotation.Nullable
    private android.graphics.Matrix mDrawMatrix;
    private android.graphics.Matrix mMatrix;
    private int mUnderlyingHeight;
    private int mUnderlyingWidth;

    public MatrixDrawable(android.graphics.drawable.Drawable drawable, android.graphics.Matrix matrix) {
        super((android.graphics.drawable.Drawable) com.facebook.common.internal.Preconditions.checkNotNull(drawable));
        this.mUnderlyingWidth = 0;
        this.mUnderlyingHeight = 0;
        this.mMatrix = matrix;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable setCurrent(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public android.graphics.Matrix getMatrix() {
        return this.mMatrix;
    }

    public void setMatrix(android.graphics.Matrix matrix) {
        this.mMatrix = matrix;
        configureBounds();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        configureBoundsIfUnderlyingChanged();
        if (this.mDrawMatrix != null) {
            int iSave = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.mDrawMatrix);
            super.draw(canvas);
            canvas.restoreToCount(iSave);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        configureBounds();
    }

    private void configureBoundsIfUnderlyingChanged() {
        android.graphics.drawable.Drawable current = getCurrent();
        if (current == null) {
            return;
        }
        if (this.mUnderlyingWidth == current.getIntrinsicWidth() && this.mUnderlyingHeight == current.getIntrinsicHeight()) {
            return;
        }
        configureBounds();
    }

    private void configureBounds() {
        android.graphics.drawable.Drawable current = getCurrent();
        if (current == null) {
            return;
        }
        android.graphics.Rect bounds = getBounds();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.mUnderlyingWidth = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.mUnderlyingHeight = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.mDrawMatrix = this.mMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public void getTransform(android.graphics.Matrix matrix) {
        super.getTransform(matrix);
        android.graphics.Matrix matrix2 = this.mDrawMatrix;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }
}
