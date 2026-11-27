package io.dcloud.feature.weex.adapter.Fresco;

/* JADX INFO: loaded from: classes2.dex */
public class DCRootDrawable extends com.facebook.drawee.generic.RootDrawable {
    private boolean isRefresh;
    private com.facebook.drawee.drawable.VisibilityCallback mVisibilityCallback;

    public DCRootDrawable(android.graphics.drawable.Drawable drawable) {
        super(drawable);
        this.isRefresh = true;
    }

    public void setRefresh(boolean z) {
        this.isRefresh = z;
    }

    @Override // com.facebook.drawee.generic.RootDrawable, com.facebook.drawee.drawable.VisibilityAwareDrawable
    public void setVisibilityCallback(com.facebook.drawee.drawable.VisibilityCallback visibilityCallback) {
        this.mVisibilityCallback = visibilityCallback;
    }

    @Override // com.facebook.drawee.generic.RootDrawable, com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        com.facebook.drawee.drawable.VisibilityCallback visibilityCallback = this.mVisibilityCallback;
        if (visibilityCallback != null && this.isRefresh) {
            try {
                visibilityCallback.onVisibilityChange(z);
            } catch (java.lang.Exception unused) {
            }
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.generic.RootDrawable, com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        if (isVisible()) {
            com.facebook.drawee.drawable.VisibilityCallback visibilityCallback = this.mVisibilityCallback;
            if (visibilityCallback != null) {
                visibilityCallback.onDraw();
            }
            super.draw(canvas);
        }
    }
}
