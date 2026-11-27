package com.facebook.drawee.generic;

/* JADX INFO: loaded from: classes.dex */
public class RootDrawable extends com.facebook.drawee.drawable.ForwardingDrawable implements com.facebook.drawee.drawable.VisibilityAwareDrawable {

    @javax.annotation.Nullable
    android.graphics.drawable.Drawable mControllerOverlay;

    @javax.annotation.Nullable
    private com.facebook.drawee.drawable.VisibilityCallback mVisibilityCallback;

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    public RootDrawable(android.graphics.drawable.Drawable drawable) {
        super(drawable);
        this.mControllerOverlay = null;
    }

    @Override // com.facebook.drawee.drawable.VisibilityAwareDrawable
    public void setVisibilityCallback(@javax.annotation.Nullable com.facebook.drawee.drawable.VisibilityCallback visibilityCallback) {
        this.mVisibilityCallback = visibilityCallback;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        com.facebook.drawee.drawable.VisibilityCallback visibilityCallback = this.mVisibilityCallback;
        if (visibilityCallback != null) {
            visibilityCallback.onVisibilityChange(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        if (isVisible()) {
            com.facebook.drawee.drawable.VisibilityCallback visibilityCallback = this.mVisibilityCallback;
            if (visibilityCallback != null) {
                visibilityCallback.onDraw();
            }
            super.draw(canvas);
            android.graphics.drawable.Drawable drawable = this.mControllerOverlay;
            if (drawable != null) {
                drawable.setBounds(getBounds());
                this.mControllerOverlay.draw(canvas);
            }
        }
    }

    public void setControllerOverlay(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.mControllerOverlay = drawable;
        invalidateSelf();
    }
}
