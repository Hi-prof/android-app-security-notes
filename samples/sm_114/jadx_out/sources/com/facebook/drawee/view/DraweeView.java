package com.facebook.drawee.view;

/* JADX INFO: loaded from: classes.dex */
@java.lang.Deprecated
public class DraweeView<DH extends com.facebook.drawee.interfaces.DraweeHierarchy> extends android.widget.ImageView {
    private static boolean sGlobalLegacyVisibilityHandlingEnabled = false;
    private float mAspectRatio;
    private com.facebook.drawee.view.DraweeHolder<DH> mDraweeHolder;

    @javax.annotation.Nullable
    private java.lang.Object mExtraData;
    private boolean mInitialised;
    private boolean mLegacyVisibilityHandlingEnabled;
    private final com.facebook.drawee.view.AspectRatioMeasure.Spec mMeasureSpec;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        sGlobalLegacyVisibilityHandlingEnabled = z;
    }

    public DraweeView(android.content.Context context) {
        super(context);
        this.mMeasureSpec = new com.facebook.drawee.view.AspectRatioMeasure.Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        this.mExtraData = null;
        init(context);
    }

    public DraweeView(android.content.Context context, @javax.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMeasureSpec = new com.facebook.drawee.view.AspectRatioMeasure.Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        this.mExtraData = null;
        init(context);
    }

    public DraweeView(android.content.Context context, @javax.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMeasureSpec = new com.facebook.drawee.view.AspectRatioMeasure.Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        this.mExtraData = null;
        init(context);
    }

    public DraweeView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mMeasureSpec = new com.facebook.drawee.view.AspectRatioMeasure.Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        this.mExtraData = null;
        init(context);
    }

    private void init(android.content.Context context) {
        boolean zIsTracing;
        try {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("DraweeView#init");
            }
            if (this.mInitialised) {
                if (zIsTracing) {
                    return;
                } else {
                    return;
                }
            }
            boolean z = true;
            this.mInitialised = true;
            this.mDraweeHolder = com.facebook.drawee.view.DraweeHolder.create(null, context);
            android.content.res.ColorStateList imageTintList = getImageTintList();
            if (imageTintList == null) {
                if (zIsTracing) {
                    return;
                } else {
                    return;
                }
            }
            setColorFilter(imageTintList.getDefaultColor());
            if (!sGlobalLegacyVisibilityHandlingEnabled || context.getApplicationInfo().targetSdkVersion < 24) {
                z = false;
            }
            this.mLegacyVisibilityHandlingEnabled = z;
        } finally {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
        }
    }

    public void setExtraData(@javax.annotation.Nullable java.lang.Object obj) {
        this.mExtraData = obj;
    }

    @javax.annotation.Nullable
    public java.lang.Object getExtraData() {
        return this.mExtraData;
    }

    public void setHierarchy(DH dh) {
        this.mDraweeHolder.setHierarchy(dh);
        super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return (DH) this.mDraweeHolder.getHierarchy();
    }

    public boolean hasHierarchy() {
        return this.mDraweeHolder.hasHierarchy();
    }

    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable getTopLevelDrawable() {
        return this.mDraweeHolder.getTopLevelDrawable();
    }

    public void setController(@javax.annotation.Nullable com.facebook.drawee.interfaces.DraweeController draweeController) {
        this.mDraweeHolder.setController(draweeController);
        super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
    }

    @javax.annotation.Nullable
    public com.facebook.drawee.interfaces.DraweeController getController() {
        return this.mDraweeHolder.getController();
    }

    public boolean hasController() {
        return this.mDraweeHolder.getController() != null;
    }

    public void resetActualImage() {
        setController(null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeOverrideVisibilityHandling();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        maybeOverrideVisibilityHandling();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        maybeOverrideVisibilityHandling();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        maybeOverrideVisibilityHandling();
        onAttach();
    }

    protected void onAttach() {
        doAttach();
    }

    protected void onDetach() {
        doDetach();
    }

    protected void doAttach() {
        this.mDraweeHolder.onAttach();
    }

    protected void doDetach() {
        this.mDraweeHolder.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.mDraweeHolder.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @java.lang.Deprecated
    public void setImageDrawable(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        init(getContext());
        this.mDraweeHolder.resetActualImage();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @java.lang.Deprecated
    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        init(getContext());
        this.mDraweeHolder.resetActualImage();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @java.lang.Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.mDraweeHolder.resetActualImage();
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @java.lang.Deprecated
    public void setImageURI(android.net.Uri uri) {
        init(getContext());
        this.mDraweeHolder.resetActualImage();
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f == this.mAspectRatio) {
            return;
        }
        this.mAspectRatio = f;
        requestLayout();
    }

    public float getAspectRatio() {
        return this.mAspectRatio;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.mLegacyVisibilityHandlingEnabled = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mMeasureSpec.width = i;
        this.mMeasureSpec.height = i2;
        com.facebook.drawee.view.AspectRatioMeasure.updateMeasureSpec(this.mMeasureSpec, this.mAspectRatio, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.mMeasureSpec.width, this.mMeasureSpec.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        maybeOverrideVisibilityHandling();
    }

    private void maybeOverrideVisibilityHandling() {
        android.graphics.drawable.Drawable drawable;
        if (!this.mLegacyVisibilityHandlingEnabled || (drawable = getDrawable()) == null) {
            return;
        }
        drawable.setVisible(getVisibility() == 0, false);
    }

    @Override // android.view.View
    public java.lang.String toString() {
        com.facebook.common.internal.Objects.ToStringHelper stringHelper = com.facebook.common.internal.Objects.toStringHelper(this);
        com.facebook.drawee.view.DraweeHolder<DH> draweeHolder = this.mDraweeHolder;
        return stringHelper.add("holder", draweeHolder != null ? draweeHolder.toString() : "<no holder set>").toString();
    }
}
