package com.dcloud.android.widget.photoview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class PhotoView extends android.widget.ImageView {
    private com.dcloud.android.widget.photoview.PhotoViewAttacher attacher;

    public PhotoView(android.content.Context context) {
        this(context, null);
    }

    private void init() {
        this.attacher = new com.dcloud.android.widget.photoview.PhotoViewAttacher(this);
        super.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    public com.dcloud.android.widget.photoview.PhotoViewAttacher getAttacher() {
        return this.attacher;
    }

    public void getDisplayMatrix(android.graphics.Matrix matrix) {
        this.attacher.getDisplayMatrix(matrix);
    }

    public android.graphics.RectF getDisplayRect() {
        return this.attacher.getDisplayRect();
    }

    @Override // android.widget.ImageView
    public android.graphics.Matrix getImageMatrix() {
        return this.attacher.getImageMatrix();
    }

    public float getMaximumScale() {
        return this.attacher.getMaximumScale();
    }

    public float getMediumScale() {
        return this.attacher.getMediumScale();
    }

    public float getMinimumScale() {
        return this.attacher.getMinimumScale();
    }

    public float getScale() {
        return this.attacher.getScale();
    }

    @Override // android.widget.ImageView
    public android.widget.ImageView.ScaleType getScaleType() {
        return this.attacher.getScaleType();
    }

    public boolean isZoomEnabled() {
        return this.attacher.isZoomEnabled();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.attacher.setAllowParentInterceptOnEdge(z);
    }

    public boolean setDisplayMatrix(android.graphics.Matrix matrix) {
        return this.attacher.setDisplayMatrix(matrix);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.attacher.update();
        }
        return frame;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        super.setImageDrawable(drawable);
        com.dcloud.android.widget.photoview.PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        com.dcloud.android.widget.photoview.PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(android.net.Uri uri) {
        super.setImageURI(uri);
        com.dcloud.android.widget.photoview.PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    public void setMaximumScale(float f) {
        this.attacher.setMaximumScale(f);
    }

    public void setMediumScale(float f) {
        this.attacher.setMediumScale(f);
    }

    public void setMinimumScale(float f) {
        this.attacher.setMinimumScale(f);
    }

    @Override // android.view.View
    public void setOnClickListener(android.view.View.OnClickListener onClickListener) {
        this.attacher.setOnClickListener(onClickListener);
    }

    public void setOnDoubleTapListener(android.view.GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.attacher.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(android.view.View.OnLongClickListener onLongClickListener) {
        this.attacher.setOnLongClickListener(onLongClickListener);
    }

    public void setOnMatrixChangeListener(com.dcloud.android.widget.photoview.OnMatrixChangedListener onMatrixChangedListener) {
        this.attacher.setOnMatrixChangeListener(onMatrixChangedListener);
    }

    public void setOnOutsidePhotoTapListener(com.dcloud.android.widget.photoview.OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.attacher.setOnOutsidePhotoTapListener(onOutsidePhotoTapListener);
    }

    public void setOnPhotoTapListener(com.dcloud.android.widget.photoview.OnPhotoTapListener onPhotoTapListener) {
        this.attacher.setOnPhotoTapListener(onPhotoTapListener);
    }

    public void setOnScaleChangeListener(com.dcloud.android.widget.photoview.OnScaleChangedListener onScaleChangedListener) {
        this.attacher.setOnScaleChangeListener(onScaleChangedListener);
    }

    public void setOnSingleFlingListener(com.dcloud.android.widget.photoview.OnSingleFlingListener onSingleFlingListener) {
        this.attacher.setOnSingleFlingListener(onSingleFlingListener);
    }

    public void setRotationBy(float f) {
        this.attacher.setRotationBy(f);
    }

    public void setRotationTo(float f) {
        this.attacher.setRotationTo(f);
    }

    public void setScale(float f) {
        this.attacher.setScale(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.attacher.setScaleLevels(f, f2, f3);
    }

    @Override // android.widget.ImageView
    public void setScaleType(android.widget.ImageView.ScaleType scaleType) {
        com.dcloud.android.widget.photoview.PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.setScaleType(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i) {
        this.attacher.setZoomTransitionDuration(i);
    }

    public void setZoomable(boolean z) {
        this.attacher.setZoomable(z);
    }

    public PhotoView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScale(float f, boolean z) {
        this.attacher.setScale(f, z);
    }

    public PhotoView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.attacher.setScale(f, f2, f3, z);
    }

    public PhotoView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }
}
