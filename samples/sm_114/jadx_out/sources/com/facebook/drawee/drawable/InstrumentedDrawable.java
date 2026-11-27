package com.facebook.drawee.drawable;

/* JADX INFO: loaded from: classes.dex */
public class InstrumentedDrawable extends com.facebook.drawee.drawable.ForwardingDrawable {
    private boolean mIsChecked;
    private final com.facebook.drawee.drawable.InstrumentedDrawable.Listener mListener;
    private final java.lang.String mScaleType;

    public interface Listener {
        void track(int i, int i2, int i3, int i4, int i5, int i6, java.lang.String str);
    }

    public InstrumentedDrawable(android.graphics.drawable.Drawable drawable, com.facebook.drawee.drawable.InstrumentedDrawable.Listener listener) {
        super(drawable);
        this.mIsChecked = false;
        this.mListener = listener;
        this.mScaleType = getScaleType(drawable);
    }

    private java.lang.String getScaleType(android.graphics.drawable.Drawable drawable) {
        if (drawable instanceof com.facebook.drawee.drawable.ScaleTypeDrawable) {
            return ((com.facebook.drawee.drawable.ScaleTypeDrawable) drawable).getScaleType().toString();
        }
        return "none";
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        if (!this.mIsChecked) {
            this.mIsChecked = true;
            android.graphics.RectF rectF = new android.graphics.RectF();
            getRootBounds(rectF);
            int iWidth = (int) rectF.width();
            int iHeight = (int) rectF.height();
            getTransformedBounds(rectF);
            int iWidth2 = (int) rectF.width();
            int iHeight2 = (int) rectF.height();
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            com.facebook.drawee.drawable.InstrumentedDrawable.Listener listener = this.mListener;
            if (listener != null) {
                listener.track(iWidth, iHeight, intrinsicWidth, intrinsicHeight, iWidth2, iHeight2, this.mScaleType);
            }
        }
        super.draw(canvas);
    }
}
