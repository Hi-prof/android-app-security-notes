package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DHImageView extends android.widget.FrameLayout {
    boolean isSlipping;
    boolean isTouchIntercept;
    public android.graphics.Bitmap mBitmap;
    public long mBitmapHeight;
    public long mBitmapWidth;
    private io.dcloud.common.DHInterface.IFrameView mFrameView;
    public android.widget.ImageView mImageView;
    public io.dcloud.common.DHInterface.INativeView mView;

    public DHImageView(android.content.Context context) {
        super(context);
        this.isTouchIntercept = true;
        this.mBitmapWidth = 0L;
        this.mBitmapHeight = 0L;
        this.mView = null;
        this.isSlipping = false;
        android.widget.ImageView imageView = new android.widget.ImageView(context);
        this.mImageView = imageView;
        addView(imageView, new android.widget.FrameLayout.LayoutParams(-1, -1));
    }

    public void addNativeView(io.dcloud.common.DHInterface.IFrameView iFrameView, io.dcloud.common.DHInterface.INativeView iNativeView) {
        this.mFrameView = iFrameView;
        io.dcloud.common.DHInterface.INativeView iNativeView2 = this.mView;
        if (iNativeView2 != null) {
            removeView(iNativeView2.obtanMainView());
            this.mView.setNativeShowType(false);
            this.mView = null;
        }
        this.mView = iNativeView;
        if (iNativeView.obtanMainView().getParent() != null) {
            ((android.view.ViewGroup) iNativeView.obtanMainView().getParent()).removeView(iNativeView.obtanMainView());
        }
        iNativeView.obtanMainView().setVisibility(0);
        iNativeView.setNativeShowType(true);
        addView(iNativeView.obtanMainView());
    }

    public void clear() {
        setImageBitmap(null);
        removeNativeView();
        setVisibility(4);
        io.dcloud.common.DHInterface.IFrameView iFrameView = this.mFrameView;
        if (iFrameView != null) {
            iFrameView.setSnapshotView(null, "none");
        }
    }

    public android.graphics.Bitmap getBitmap() {
        return this.mBitmap;
    }

    public boolean isNativeView() {
        return this.mView != null;
    }

    public boolean isSlipping() {
        return this.isSlipping;
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.isTouchIntercept) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void recycledBitmap(android.graphics.Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public void refreshImagerView() {
        io.dcloud.nineoldandroids.view.ViewHelper.setAlpha(this, 1.0f);
        io.dcloud.nineoldandroids.view.ViewHelper.setScaleX(this, 1.0f);
        io.dcloud.nineoldandroids.view.ViewHelper.setScaleY(this, 1.0f);
        io.dcloud.nineoldandroids.view.ViewHelper.setRotationX(this, 0.0f);
        io.dcloud.nineoldandroids.view.ViewHelper.setRotationY(this, 0.0f);
        io.dcloud.nineoldandroids.view.ViewHelper.setTranslationX(this, 0.0f);
        io.dcloud.nineoldandroids.view.ViewHelper.setTranslationY(this, 0.0f);
        io.dcloud.nineoldandroids.view.ViewHelper.setX(this, 0.0f);
        io.dcloud.nineoldandroids.view.ViewHelper.setY(this, 0.0f);
        io.dcloud.nineoldandroids.view.ViewHelper.setScrollX(this, 0);
        io.dcloud.nineoldandroids.view.ViewHelper.setScrollY(this, 0);
        setPadding(0, 0, 0, 0);
        this.isSlipping = false;
        setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        requestLayout();
    }

    public void removeNativeView() {
        io.dcloud.common.DHInterface.INativeView iNativeView = this.mView;
        if (iNativeView != null) {
            removeView(iNativeView.obtanMainView());
            this.mView.setNativeShowType(false);
            this.mView = null;
        }
    }

    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        if (this.isSlipping) {
            recycledBitmap(bitmap);
            return;
        }
        recycledBitmap(this.mBitmap);
        this.mBitmap = bitmap;
        if (bitmap != null) {
            this.mBitmapWidth = bitmap.getWidth();
            this.mBitmapHeight = bitmap.getHeight();
        } else {
            this.mBitmapWidth = 0L;
            this.mBitmapHeight = 0L;
        }
        android.widget.ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void setIntercept(boolean z) {
        this.isTouchIntercept = z;
    }

    public void setNativeAnimationRuning(boolean z) {
        io.dcloud.common.DHInterface.INativeView iNativeView = this.mView;
        if (iNativeView != null) {
            iNativeView.setWebAnimationRuning(z);
        }
    }

    public void setScaleType(android.widget.ImageView.ScaleType scaleType) {
        this.mImageView.setScaleType(scaleType);
    }

    public void setSlipping(boolean z) {
        this.isSlipping = z;
    }
}
