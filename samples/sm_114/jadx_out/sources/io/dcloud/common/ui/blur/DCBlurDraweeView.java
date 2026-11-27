package io.dcloud.common.ui.blur;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DCBlurDraweeView extends android.widget.FrameLayout implements io.dcloud.common.ui.blur.AppEventForBlurManager.OnAppChangedCallBack {
    public static final java.lang.String AUTOMATICALLY = "automatically";
    public static final java.lang.String DARK = "dark";
    public static final java.lang.String EXTRALIGHT = "extralight";
    public static final java.lang.String LIGHT = "light";
    public static final java.lang.String NONE = "none";
    public static final java.lang.String SEMI_AUTOMATICALLY = "semi-automatic";
    public static final java.lang.String STATIC = "static";
    private final java.lang.String TAG;
    private android.view.Choreographer.FrameCallback invalidationLoop;
    private boolean isBlur;
    private float mAlpha;
    private boolean mAttachedToWindow;
    private java.lang.String mBlurEffect;
    private int mBlurRadius;
    private java.lang.String mBlurState;
    private io.dcloud.common.ui.blur.DCBlurDraweeView.BlurLayoutChangeCallBack mChangeCB;
    private float mCornerRadius;
    private float mDownscaleFactor;
    private int mFPS;
    private int mGravityType;
    private android.widget.ImageView mImageView;
    private float mOverlayColorAlpha;
    private long mPostTime;
    private java.lang.ref.WeakReference<android.view.View> mRootView;
    private boolean mRunning;
    private int postDelayTime;
    private android.view.Choreographer.FrameCallback postInvalidationLoop;
    private java.lang.Runnable removePostDelayed;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface BlurLayoutChangeCallBack {
        void setVisibility(int i);
    }

    public DCBlurDraweeView(android.content.Context context) {
        super(context);
        this.TAG = "DCBlurDraweeView";
        this.mDownscaleFactor = 0.2f;
        this.mBlurRadius = 15;
        this.mFPS = 60;
        this.mCornerRadius = 0.0f;
        this.mAlpha = Float.NaN;
        this.isBlur = false;
        this.mGravityType = 17;
        this.mBlurState = "static";
        this.mBlurEffect = "none";
        this.mPostTime = 1500L;
        this.invalidationLoop = new android.view.Choreographer.FrameCallback() { // from class: io.dcloud.common.ui.blur.DCBlurDraweeView.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                if (!io.dcloud.common.util.BaseInfo.sDoingAnimation) {
                    io.dcloud.common.ui.blur.DCBlurDraweeView.this.invalidate();
                }
                android.view.Choreographer.getInstance().postFrameCallbackDelayed(this, 1000 / io.dcloud.common.ui.blur.DCBlurDraweeView.this.mFPS);
            }
        };
        this.postDelayTime = 50;
        this.postInvalidationLoop = new android.view.Choreographer.FrameCallback() { // from class: io.dcloud.common.ui.blur.DCBlurDraweeView.2
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                if (io.dcloud.common.ui.blur.DCBlurDraweeView.this.mRunning) {
                    return;
                }
                if (!io.dcloud.common.util.BaseInfo.sDoingAnimation) {
                    io.dcloud.common.ui.blur.DCBlurDraweeView.this.invalidate();
                }
                android.view.Choreographer.getInstance().postFrameCallbackDelayed(this, io.dcloud.common.ui.blur.DCBlurDraweeView.this.postDelayTime);
            }
        };
        this.removePostDelayed = new java.lang.Runnable() { // from class: io.dcloud.common.ui.blur.DCBlurDraweeView.3
            @Override // java.lang.Runnable
            public void run() {
                android.view.Choreographer.getInstance().removeFrameCallback(io.dcloud.common.ui.blur.DCBlurDraweeView.this.postInvalidationLoop);
            }
        };
        this.mOverlayColorAlpha = 0.6f;
    }

    private android.view.View getActivityView() {
        try {
            return ((android.app.Activity) getContext()).getWindow().getDecorView().findViewById(android.R.id.content);
        } catch (java.lang.ClassCastException unused) {
            return null;
        }
    }

    private android.graphics.Bitmap getDownscaledBitmapForView(android.view.View view, android.graphics.Rect rect, float f, int i) throws java.lang.Exception {
        int iHeight;
        int iHeight2;
        float f2 = f / 0.5f;
        if (f >= 0.5f) {
            f2 = 1.0f;
        } else {
            f = 0.5f;
        }
        int iWidth = (int) (rect.width() * f);
        int iHeight3 = (int) (rect.height() * f);
        if (view.getWidth() <= 0 || view.getHeight() <= 0 || iWidth <= 0 || iHeight3 <= 0) {
            throw new java.lang.Exception("No screen available (width or height = 0)");
        }
        float f3 = (-rect.left) * f;
        float f4 = ((-rect.top) + i) * f;
        int i2 = this.mGravityType;
        if (i2 != 17) {
            if (i2 != 48) {
                iHeight = rect.height();
            } else {
                iHeight2 = (int) ((rect.height() + i) * f);
                f4 -= i * f;
            }
            setViewVisibility(4);
            android.graphics.Bitmap.Config config = android.graphics.Bitmap.Config.ARGB_8888;
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(iWidth, iHeight2, config);
            io.dcloud.common.ui.blur.BlurCanvas blurCanvas = new io.dcloud.common.ui.blur.BlurCanvas(bitmapCreateBitmap);
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.postScale(f, f);
            matrix.postTranslate(f3, f4);
            blurCanvas.setMatrix(matrix);
            view.draw(blurCanvas);
            blurCanvas.drawColor(getOverlayColor());
            blurCanvas.save();
            setViewVisibility(0);
            float f5 = iWidth;
            int i3 = (int) (f5 * f2);
            float f6 = iHeight2;
            int i4 = (int) (f2 * f6);
            android.graphics.Bitmap bitmapCreateBitmap2 = android.graphics.Bitmap.createBitmap(i3, i4, config);
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap2);
            android.graphics.Matrix matrix2 = new android.graphics.Matrix();
            matrix2.setScale(i3 / f5, i4 / f6);
            canvas.setMatrix(matrix2);
            canvas.drawColor(getBlurBGColor());
            android.graphics.Paint paint = new android.graphics.Paint();
            paint.setFlags(3);
            canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, paint);
            bitmapCreateBitmap.recycle();
            return bitmapCreateBitmap2;
        }
        iHeight = rect.height();
        i *= 2;
        iHeight2 = (int) ((iHeight + i) * f);
        setViewVisibility(4);
        android.graphics.Bitmap.Config config2 = android.graphics.Bitmap.Config.ARGB_8888;
        android.graphics.Bitmap bitmapCreateBitmap3 = android.graphics.Bitmap.createBitmap(iWidth, iHeight2, config2);
        io.dcloud.common.ui.blur.BlurCanvas blurCanvas2 = new io.dcloud.common.ui.blur.BlurCanvas(bitmapCreateBitmap3);
        android.graphics.Matrix matrix3 = new android.graphics.Matrix();
        matrix3.postScale(f, f);
        matrix3.postTranslate(f3, f4);
        blurCanvas2.setMatrix(matrix3);
        view.draw(blurCanvas2);
        blurCanvas2.drawColor(getOverlayColor());
        blurCanvas2.save();
        setViewVisibility(0);
        float f7 = iWidth;
        int i5 = (int) (f7 * f2);
        float f8 = iHeight2;
        int i6 = (int) (f2 * f8);
        android.graphics.Bitmap bitmapCreateBitmap4 = android.graphics.Bitmap.createBitmap(i5, i6, config2);
        android.graphics.Canvas canvas2 = new android.graphics.Canvas(bitmapCreateBitmap4);
        android.graphics.Matrix matrix4 = new android.graphics.Matrix();
        matrix4.setScale(i5 / f7, i6 / f8);
        canvas2.setMatrix(matrix4);
        canvas2.drawColor(getBlurBGColor());
        android.graphics.Paint paint2 = new android.graphics.Paint();
        paint2.setFlags(3);
        canvas2.drawBitmap(bitmapCreateBitmap3, 0.0f, 0.0f, paint2);
        bitmapCreateBitmap3.recycle();
        return bitmapCreateBitmap4;
    }

    private int getOverlayColor() {
        java.lang.String str = this.mBlurEffect;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "dark":
                return android.graphics.Color.parseColor(io.dcloud.common.util.TitleNViewUtil.changeColorAlpha("#454545", this.mOverlayColorAlpha));
            case "light":
                return android.graphics.Color.parseColor(io.dcloud.common.util.TitleNViewUtil.changeColorAlpha("#F8F8F8", this.mOverlayColorAlpha));
            case "extralight":
                return android.graphics.Color.parseColor(io.dcloud.common.util.TitleNViewUtil.changeColorAlpha(io.dcloud.common.util.TitleNViewUtil.TRANSPARENT_BUTTON_TEXT_COLOR, this.mOverlayColorAlpha));
            default:
                return 0;
        }
    }

    private android.graphics.Point getPositionInScreen() {
        android.graphics.PointF positionInScreen = getPositionInScreen(this);
        return new android.graphics.Point((int) positionInScreen.x, (int) positionInScreen.y);
    }

    private void initImageView() {
        android.widget.ImageView imageView = this.mImageView;
        if (imageView == null) {
            this.mImageView = new android.widget.ImageView(getContext());
        } else if (imageView.getParent() == null) {
            ((android.view.ViewGroup) this.mImageView.getParent()).removeView(this.mImageView);
        }
        this.mImageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        addView(this.mImageView, 0);
        setCornerRadius(this.mCornerRadius);
    }

    private void pauseBlur() {
        if (this.mRunning && this.isBlur) {
            this.mRunning = false;
            android.view.Choreographer.getInstance().removeFrameCallback(this.invalidationLoop);
        }
    }

    private void setViewVisibility(int i) {
        setVisibility(i);
        io.dcloud.common.ui.blur.DCBlurDraweeView.BlurLayoutChangeCallBack blurLayoutChangeCallBack = this.mChangeCB;
        if (blurLayoutChangeCallBack != null) {
            blurLayoutChangeCallBack.setVisibility(i);
        }
    }

    private void startBlur() {
        if (this.mRunning || !this.isBlur || this.mFPS <= 0 || this.mBlurState.equals("static")) {
            return;
        }
        this.mRunning = true;
        android.view.Choreographer.getInstance().removeFrameCallback(this.postInvalidationLoop);
        android.view.Choreographer.getInstance().postFrameCallback(this.invalidationLoop);
    }

    public boolean checkBlurEffect(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(LIGHT) || str.equals(DARK) || str.equals(EXTRALIGHT);
    }

    public int getBlurBGColor() {
        java.lang.String str = this.mBlurEffect;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "dark":
                return android.graphics.Color.parseColor("#F2454545");
            case "light":
                return android.graphics.Color.parseColor("#F2F8F8F8");
            case "extralight":
                return android.graphics.Color.parseColor("#F2FFFFFF");
            default:
                return 0;
        }
    }

    @Override // android.view.View
    public void invalidate() {
        android.graphics.Bitmap bitmapMakeBlur;
        super.invalidate();
        if (!this.mAttachedToWindow || this.mImageView == null || !this.isBlur || (bitmapMakeBlur = makeBlur()) == null) {
            return;
        }
        this.mImageView.setImageBitmap(bitmapMakeBlur);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ca  */
    public android.graphics.Bitmap makeBlur() {
        android.graphics.Bitmap downscaledBitmapForView = null;
        if (getContext() == null || isInEditMode() || !this.isBlur) {
            return null;
        }
        java.lang.ref.WeakReference<android.view.View> weakReference = this.mRootView;
        if (weakReference == null || weakReference.get() == null) {
            java.lang.ref.WeakReference<android.view.View> weakReference2 = new java.lang.ref.WeakReference<>(getActivityView());
            this.mRootView = weakReference2;
            if (weakReference2.get() == null) {
                return null;
            }
        }
        getLocationOnScreen(new int[2]);
        android.graphics.Point positionInScreen = getPositionInScreen();
        android.graphics.Rect rect = new android.graphics.Rect();
        if (!getGlobalVisibleRect(rect)) {
            return null;
        }
        int height = getHeight();
        int width = getWidth();
        boolean z = rect.height() >= height;
        int i = z ? this.mBlurRadius : 0;
        try {
            android.view.View view = this.mRootView.get();
            int i2 = positionInScreen.x;
            int i3 = positionInScreen.y;
            downscaledBitmapForView = getDownscaledBitmapForView(view, new android.graphics.Rect(i2, i3, width + i2, height + i3), this.mDownscaleFactor, i);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        if (downscaledBitmapForView == null) {
            return downscaledBitmapForView;
        }
        android.graphics.Bitmap bitmapProcessNatively = io.dcloud.common.ui.blur.BlurManager.getInstance().processNatively(downscaledBitmapForView, this.mBlurRadius, false);
        int i4 = (int) (i * this.mDownscaleFactor);
        int i5 = z ? i4 : 0;
        int height2 = z ? bitmapProcessNatively.getHeight() - (i4 * 2) : bitmapProcessNatively.getHeight();
        int i6 = this.mGravityType;
        if (i6 == 17) {
            if (z) {
                height2 = bitmapProcessNatively.getHeight() - (i4 * 2);
            } else {
                height2 = bitmapProcessNatively.getHeight();
            }
        } else if (i6 == 48) {
            i5 = 5;
            height2 = (z ? bitmapProcessNatively.getHeight() - i4 : bitmapProcessNatively.getHeight()) - 5;
        } else if (i6 == 80) {
            if (z) {
                height2 = bitmapProcessNatively.getHeight() - (i4 * 2);
            } else {
                height2 = bitmapProcessNatively.getHeight();
            }
        }
        return android.graphics.Bitmap.createBitmap(bitmapProcessNatively, 0, i5, bitmapProcessNatively.getWidth(), height2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:6:0x001a  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        byte b = 1;
        this.mAttachedToWindow = true;
        if (this.isBlur) {
            java.lang.String str = this.mBlurState;
            str.getClass();
            str.hashCode();
            switch (str.hashCode()) {
                case -892481938:
                    if (!str.equals("static")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 1030681228:
                    if (!str.equals(SEMI_AUTOMATICALLY)) {
                        b = -1;
                    }
                    break;
                case 1977933731:
                    if (!str.equals(AUTOMATICALLY)) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    postInvalidate(this.mPostTime);
                    io.dcloud.common.ui.blur.AppEventForBlurManager.removeEventChangedCallBack(this);
                    break;
                case 1:
                    postInvalidate(this.mPostTime);
                    io.dcloud.common.ui.blur.AppEventForBlurManager.addEventChangedCallBack(this);
                    break;
                case 2:
                    io.dcloud.common.ui.blur.AppEventForBlurManager.removeEventChangedCallBack(this);
                    startBlur();
                    break;
            }
        }
    }

    @Override // io.dcloud.common.ui.blur.AppEventForBlurManager.OnAppChangedCallBack
    public void onContentScrollEnd() {
        pauseBlur();
    }

    @Override // io.dcloud.common.ui.blur.AppEventForBlurManager.OnAppChangedCallBack
    public void onContentScrollStart() {
        startBlur();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttachedToWindow = false;
        pauseBlur();
        io.dcloud.common.ui.blur.AppEventForBlurManager.removeEventChangedCallBack(this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.isBlur) {
            postInvalidate(this.mPostTime);
        }
    }

    @Override // io.dcloud.common.ui.blur.AppEventForBlurManager.OnAppChangedCallBack
    public void onSplashclosed() {
        postInvalidate(this.mPostTime);
    }

    public void postInvalidate(long j) {
        if (this.mRunning || !this.isBlur) {
            return;
        }
        io.dcloud.common.adapter.util.MessageHandler.removeCallbacks(this.removePostDelayed);
        android.view.Choreographer.getInstance().removeFrameCallback(this.postInvalidationLoop);
        android.view.Choreographer.getInstance().postFrameCallback(this.postInvalidationLoop);
        io.dcloud.common.adapter.util.MessageHandler.postDelayed(this.removePostDelayed, j + 10);
    }

    public void setBlur(boolean z) {
        this.isBlur = z;
        if (z && this.mImageView == null) {
            initImageView();
        }
    }

    public void setBlurEffect(java.lang.String str) {
        this.mBlurEffect = str;
        if (this.isBlur || !this.mBlurState.equals("none")) {
            setBackgroundColor(0);
        } else {
            setBackgroundColor(getBlurBGColor());
        }
    }

    public void setBlurLayoutChangeCallBack(io.dcloud.common.ui.blur.DCBlurDraweeView.BlurLayoutChangeCallBack blurLayoutChangeCallBack) {
        this.mChangeCB = blurLayoutChangeCallBack;
    }

    public void setBlurRadius(int i) {
        if (i < 0) {
            i = 15;
        } else if (i > 25) {
            i = 25;
        }
        this.mBlurRadius = i;
        invalidate();
    }

    public void setBlurState(java.lang.String str) {
        this.mBlurState = str;
    }

    public void setContentFocusable(boolean z) {
        java.lang.String str = this.mBlurState;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "static":
                io.dcloud.common.ui.blur.AppEventForBlurManager.removeEventChangedCallBack(this);
                pauseBlur();
                break;
            case "semi-automatic":
                if (!z) {
                    io.dcloud.common.ui.blur.AppEventForBlurManager.removeEventChangedCallBack(this);
                    break;
                } else {
                    io.dcloud.common.ui.blur.AppEventForBlurManager.addEventChangedCallBack(this);
                    break;
                }
                break;
            case "automatically":
                if (!z) {
                    pauseBlur();
                    break;
                } else {
                    startBlur();
                    break;
                }
                break;
        }
    }

    public void setCornerRadius(float f) {
        this.mCornerRadius = f;
        invalidate();
    }

    public void setDownscaleFactor(float f) {
        this.mDownscaleFactor = f;
        invalidate();
    }

    public void setFPS(int i) {
        if (this.mRunning) {
            pauseBlur();
        }
        this.mFPS = i;
    }

    public void setGravityType(int i) {
        this.mGravityType = i;
    }

    public void setOverlayColorAlpha(float f) {
        this.mOverlayColorAlpha = f;
    }

    public void setRootView(android.view.View view) {
        java.lang.ref.WeakReference<android.view.View> weakReference = this.mRootView;
        if (weakReference != null && weakReference.get() != null) {
            this.mRootView.clear();
        }
        this.mRootView = new java.lang.ref.WeakReference<>(view);
    }

    private android.graphics.PointF getPositionInScreen(android.view.View view) {
        if (getParent() == null) {
            return new android.graphics.PointF();
        }
        if (this.mRootView.get() != null && view == this.mRootView.get()) {
            return new android.graphics.PointF();
        }
        try {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
            if (viewGroup == null) {
                return new android.graphics.PointF();
            }
            android.graphics.PointF positionInScreen = getPositionInScreen(viewGroup);
            positionInScreen.offset(view.getX(), view.getY());
            return positionInScreen;
        } catch (java.lang.Exception unused) {
            return new android.graphics.PointF();
        }
    }

    public DCBlurDraweeView(android.content.Context context, boolean z, java.lang.String str) {
        super(context);
        this.TAG = "DCBlurDraweeView";
        this.mDownscaleFactor = 0.2f;
        this.mBlurRadius = 15;
        this.mFPS = 60;
        this.mCornerRadius = 0.0f;
        this.mAlpha = Float.NaN;
        this.isBlur = false;
        this.mGravityType = 17;
        this.mBlurState = "static";
        this.mBlurEffect = "none";
        this.mPostTime = 1500L;
        this.invalidationLoop = new android.view.Choreographer.FrameCallback() { // from class: io.dcloud.common.ui.blur.DCBlurDraweeView.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                if (!io.dcloud.common.util.BaseInfo.sDoingAnimation) {
                    io.dcloud.common.ui.blur.DCBlurDraweeView.this.invalidate();
                }
                android.view.Choreographer.getInstance().postFrameCallbackDelayed(this, 1000 / io.dcloud.common.ui.blur.DCBlurDraweeView.this.mFPS);
            }
        };
        this.postDelayTime = 50;
        this.postInvalidationLoop = new android.view.Choreographer.FrameCallback() { // from class: io.dcloud.common.ui.blur.DCBlurDraweeView.2
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                if (io.dcloud.common.ui.blur.DCBlurDraweeView.this.mRunning) {
                    return;
                }
                if (!io.dcloud.common.util.BaseInfo.sDoingAnimation) {
                    io.dcloud.common.ui.blur.DCBlurDraweeView.this.invalidate();
                }
                android.view.Choreographer.getInstance().postFrameCallbackDelayed(this, io.dcloud.common.ui.blur.DCBlurDraweeView.this.postDelayTime);
            }
        };
        this.removePostDelayed = new java.lang.Runnable() { // from class: io.dcloud.common.ui.blur.DCBlurDraweeView.3
            @Override // java.lang.Runnable
            public void run() {
                android.view.Choreographer.getInstance().removeFrameCallback(io.dcloud.common.ui.blur.DCBlurDraweeView.this.postInvalidationLoop);
            }
        };
        this.mOverlayColorAlpha = 0.6f;
        this.isBlur = z;
        this.mBlurState = str;
        if (z) {
            initImageView();
        }
    }
}
