package com.facebook.drawee.drawable;

/* JADX INFO: loaded from: classes.dex */
public class OrientedDrawable extends com.facebook.drawee.drawable.ForwardingDrawable {
    private int mExifOrientation;
    private int mRotationAngle;
    final android.graphics.Matrix mRotationMatrix;
    private final android.graphics.Matrix mTempMatrix;
    private final android.graphics.RectF mTempRectF;

    public OrientedDrawable(android.graphics.drawable.Drawable drawable, int i) {
        this(drawable, i, 0);
    }

    public OrientedDrawable(android.graphics.drawable.Drawable drawable, int i, int i2) {
        super(drawable);
        this.mTempMatrix = new android.graphics.Matrix();
        this.mTempRectF = new android.graphics.RectF();
        this.mRotationMatrix = new android.graphics.Matrix();
        this.mRotationAngle = i - (i % 90);
        this.mExifOrientation = (i2 < 0 || i2 > 8) ? 0 : i2;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        int i;
        if (this.mRotationAngle <= 0 && ((i = this.mExifOrientation) == 0 || i == 1)) {
            super.draw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.concat(this.mRotationMatrix);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = this.mExifOrientation;
        if (i == 5 || i == 7 || this.mRotationAngle % 180 != 0) {
            return super.getIntrinsicHeight();
        }
        return super.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = this.mExifOrientation;
        if (i == 5 || i == 7 || this.mRotationAngle % 180 != 0) {
            return super.getIntrinsicWidth();
        }
        return super.getIntrinsicHeight();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        int i;
        android.graphics.drawable.Drawable current = getCurrent();
        if (current == null) {
            return;
        }
        int i2 = this.mRotationAngle;
        if (i2 > 0 || ((i = this.mExifOrientation) != 0 && i != 1)) {
            int i3 = this.mExifOrientation;
            if (i3 == 2) {
                this.mRotationMatrix.setScale(-1.0f, 1.0f);
            } else if (i3 == 7) {
                this.mRotationMatrix.setRotate(270.0f, rect.centerX(), rect.centerY());
                this.mRotationMatrix.postScale(-1.0f, 1.0f);
            } else if (i3 == 4) {
                this.mRotationMatrix.setScale(1.0f, -1.0f);
            } else if (i3 == 5) {
                this.mRotationMatrix.setRotate(270.0f, rect.centerX(), rect.centerY());
                this.mRotationMatrix.postScale(1.0f, -1.0f);
            } else {
                this.mRotationMatrix.setRotate(i2, rect.centerX(), rect.centerY());
            }
            this.mTempMatrix.reset();
            this.mRotationMatrix.invert(this.mTempMatrix);
            this.mTempRectF.set(rect);
            this.mTempMatrix.mapRect(this.mTempRectF);
            current.setBounds((int) this.mTempRectF.left, (int) this.mTempRectF.top, (int) this.mTempRectF.right, (int) this.mTempRectF.bottom);
            return;
        }
        current.setBounds(rect);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public void getTransform(android.graphics.Matrix matrix) {
        getParentTransform(matrix);
        if (this.mRotationMatrix.isIdentity()) {
            return;
        }
        matrix.preConcat(this.mRotationMatrix);
    }
}
