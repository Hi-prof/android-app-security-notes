package com.taobao.weex.ui.view;

/* JADX INFO: loaded from: classes.dex */
public class WXImageView extends android.widget.ImageView implements com.taobao.weex.ui.view.gesture.WXGestureObservable, com.taobao.weex.ui.view.IRenderStatus<com.taobao.weex.ui.component.WXImage>, com.taobao.weex.ui.view.IRenderResult<com.taobao.weex.ui.component.WXImage>, com.taobao.weex.ui.component.WXImage.Measurable {
    private float[] borderRadius;
    private boolean enableBitmapAutoManage;
    private boolean gif;
    private boolean isBitmapReleased;
    private boolean mOutWindowVisibilityChangedReally;
    private java.lang.ref.WeakReference<com.taobao.weex.ui.component.WXImage> mWeakReference;
    private com.taobao.weex.ui.view.gesture.WXGesture wxGesture;

    public WXImageView(android.content.Context context) {
        super(context);
        this.isBitmapReleased = false;
        this.enableBitmapAutoManage = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        setImageDrawable(getResources().getDrawable(i));
    }

    public void setImageDrawable(android.graphics.drawable.Drawable drawable, boolean z) {
        com.taobao.weex.ui.component.WXImage wXImage;
        this.gif = z;
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            android.graphics.drawable.Drawable drawableCreateImageDrawable = com.taobao.weex.utils.ImageDrawable.createImageDrawable(drawable, getScaleType(), this.borderRadius, (layoutParams.width - getPaddingLeft()) - getPaddingRight(), (layoutParams.height - getPaddingTop()) - getPaddingBottom(), z);
            if (drawableCreateImageDrawable instanceof com.taobao.weex.utils.ImageDrawable) {
                com.taobao.weex.utils.ImageDrawable imageDrawable = (com.taobao.weex.utils.ImageDrawable) drawableCreateImageDrawable;
                if (!java.util.Arrays.equals(imageDrawable.getCornerRadii(), this.borderRadius)) {
                    imageDrawable.setCornerRadii(this.borderRadius);
                }
            }
            super.setImageDrawable(drawableCreateImageDrawable);
            java.lang.ref.WeakReference<com.taobao.weex.ui.component.WXImage> weakReference = this.mWeakReference;
            if (weakReference == null || (wXImage = weakReference.get()) == null) {
                return;
            }
            wXImage.readyToRender();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        setImageDrawable(drawable, this.gif);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        setImageDrawable(bitmap == null ? null : new android.graphics.drawable.BitmapDrawable(getResources(), bitmap));
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(com.taobao.weex.ui.view.gesture.WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public com.taobao.weex.ui.view.gesture.WXGesture getGestureListener() {
        return this.wxGesture;
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        com.taobao.weex.ui.view.gesture.WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? wXGesture.onTouch(this, motionEvent) | zOnTouchEvent : zOnTouchEvent;
    }

    public void setBorderRadius(float[] fArr) {
        this.borderRadius = fArr;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            setImageDrawable(getDrawable(), this.gif);
        }
    }

    @Override // com.taobao.weex.ui.view.IRenderStatus
    public void holdComponent(com.taobao.weex.ui.component.WXImage wXImage) {
        this.mWeakReference = new java.lang.ref.WeakReference<>(wXImage);
    }

    @Override // com.taobao.weex.ui.view.IRenderResult
    public com.taobao.weex.ui.component.WXImage getComponent() {
        java.lang.ref.WeakReference<com.taobao.weex.ui.component.WXImage> weakReference = this.mWeakReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.taobao.weex.ui.component.WXImage.Measurable
    public int getNaturalWidth() {
        android.graphics.drawable.Drawable drawable = getDrawable();
        if (drawable == null) {
            return -1;
        }
        if (drawable instanceof com.taobao.weex.utils.ImageDrawable) {
            return ((com.taobao.weex.utils.ImageDrawable) drawable).getBitmapWidth();
        }
        if (drawable instanceof android.graphics.drawable.BitmapDrawable) {
            android.graphics.Bitmap bitmap = ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap();
            if (bitmap != null) {
                return bitmap.getWidth();
            }
            com.taobao.weex.utils.WXLogUtils.w("WXImageView", "Bitmap on " + drawable.toString() + " is null");
            return -1;
        }
        com.taobao.weex.utils.WXLogUtils.w("WXImageView", "Not supported drawable type: " + drawable.getClass().getSimpleName());
        return -1;
    }

    @Override // com.taobao.weex.ui.component.WXImage.Measurable
    public int getNaturalHeight() {
        android.graphics.drawable.Drawable drawable = getDrawable();
        if (drawable == null) {
            return -1;
        }
        if (drawable instanceof com.taobao.weex.utils.ImageDrawable) {
            return ((com.taobao.weex.utils.ImageDrawable) drawable).getBitmapHeight();
        }
        if (drawable instanceof android.graphics.drawable.BitmapDrawable) {
            android.graphics.Bitmap bitmap = ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap();
            if (bitmap != null) {
                return bitmap.getHeight();
            }
            com.taobao.weex.utils.WXLogUtils.w("WXImageView", "Bitmap on " + drawable.toString() + " is null");
            return -1;
        }
        com.taobao.weex.utils.WXLogUtils.w("WXImageView", "Not supported drawable type: " + drawable.getClass().getSimpleName());
        return -1;
    }

    @Override // android.view.View
    public void dispatchWindowVisibilityChanged(int i) {
        this.mOutWindowVisibilityChangedReally = true;
        super.dispatchWindowVisibilityChanged(i);
        this.mOutWindowVisibilityChangedReally = false;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.mOutWindowVisibilityChangedReally) {
            if (i == 0) {
                autoRecoverImage();
            } else {
                autoReleaseImage();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        autoRecoverImage();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        autoReleaseImage();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        autoReleaseImage();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        autoRecoverImage();
    }

    public void setEnableBitmapAutoManage(boolean z) {
        this.enableBitmapAutoManage = z;
    }

    public void autoReleaseImage() {
        if (!this.enableBitmapAutoManage || this.isBitmapReleased) {
            return;
        }
        this.isBitmapReleased = true;
        com.taobao.weex.ui.component.WXImage component = getComponent();
        if (component != null) {
            component.autoReleaseImage();
        }
    }

    public void autoRecoverImage() {
        if (this.enableBitmapAutoManage && this.isBitmapReleased) {
            com.taobao.weex.ui.component.WXImage component = getComponent();
            if (component != null) {
                component.autoRecoverImage();
            }
            this.isBitmapReleased = false;
        }
    }
}
