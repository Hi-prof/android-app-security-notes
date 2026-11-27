package com.dcloud.android.widget.photoview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class PhotoViewAttacher implements android.view.View.OnTouchListener, com.dcloud.android.widget.photoview.OnGestureListener, android.view.View.OnLayoutChangeListener {
    private static float DEFAULT_MAX_SCALE = 3.0f;
    private static float DEFAULT_MID_SCALE = 1.75f;
    private static float DEFAULT_MIN_SCALE = 1.0f;
    private static int DEFAULT_ZOOM_DURATION = 200;
    private static final int EDGE_BOTH = 2;
    private static final int EDGE_LEFT = 0;
    private static final int EDGE_NONE = -1;
    private static final int EDGE_RIGHT = 1;
    private static int SINGLE_TOUCH = 1;
    private float mBaseRotation;
    private com.dcloud.android.widget.photoview.PhotoViewAttacher.FlingRunnable mCurrentFlingRunnable;
    private android.view.GestureDetector mGestureDetector;
    private android.widget.ImageView mImageView;
    private android.view.View.OnLongClickListener mLongClickListener;
    private com.dcloud.android.widget.photoview.OnMatrixChangedListener mMatrixChangeListener;
    private android.view.View.OnClickListener mOnClickListener;
    private com.dcloud.android.widget.photoview.OnOutsidePhotoTapListener mOutsidePhotoTapListener;
    private com.dcloud.android.widget.photoview.OnPhotoTapListener mPhotoTapListener;
    private com.dcloud.android.widget.photoview.OnScaleChangedListener mScaleChangeListener;
    private com.dcloud.android.widget.photoview.CustomGestureDetector mScaleDragDetector;
    private com.dcloud.android.widget.photoview.OnSingleFlingListener mSingleFlingListener;
    private android.view.animation.Interpolator mInterpolator = new android.view.animation.AccelerateDecelerateInterpolator();
    private int mZoomDuration = DEFAULT_ZOOM_DURATION;
    private float mMinScale = DEFAULT_MIN_SCALE;
    private float mMidScale = DEFAULT_MID_SCALE;
    private float mMaxScale = DEFAULT_MAX_SCALE;
    private boolean mAllowParentInterceptOnEdge = true;
    private boolean mBlockParentIntercept = false;
    private final android.graphics.Matrix mBaseMatrix = new android.graphics.Matrix();
    private final android.graphics.Matrix mDrawMatrix = new android.graphics.Matrix();
    private final android.graphics.Matrix mSuppMatrix = new android.graphics.Matrix();
    private final android.graphics.RectF mDisplayRect = new android.graphics.RectF();
    private final float[] mMatrixValues = new float[9];
    private int mScrollEdge = 2;
    private boolean mZoomEnabled = true;
    private android.widget.ImageView.ScaleType mScaleType = android.widget.ImageView.ScaleType.FIT_CENTER;

    /* JADX INFO: renamed from: com.dcloud.android.widget.photoview.PhotoViewAttacher$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[android.widget.ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[android.widget.ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class AnimatedZoomRunnable implements java.lang.Runnable {
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = java.lang.System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f, float f2, float f3, float f4) {
            this.mFocalX = f3;
            this.mFocalY = f4;
            this.mZoomStart = f;
            this.mZoomEnd = f2;
        }

        private float interpolate() {
            return com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mInterpolator.getInterpolation(java.lang.Math.min(1.0f, ((java.lang.System.currentTimeMillis() - this.mStartTime) * 1.0f) / com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mZoomDuration));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fInterpolate = interpolate();
            float f = this.mZoomStart;
            com.dcloud.android.widget.photoview.PhotoViewAttacher.this.onScale((f + ((this.mZoomEnd - f) * fInterpolate)) / com.dcloud.android.widget.photoview.PhotoViewAttacher.this.getScale(), this.mFocalX, this.mFocalY);
            if (fInterpolate < 1.0f) {
                com.dcloud.android.widget.photoview.Compat.postOnAnimation(com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mImageView, this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class FlingRunnable implements java.lang.Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final android.widget.OverScroller mScroller;

        public FlingRunnable(android.content.Context context) {
            this.mScroller = new android.widget.OverScroller(context);
        }

        public void cancelFling() {
            this.mScroller.forceFinished(true);
        }

        public void fling(int i, int i2, int i3, int i4) {
            int i5;
            int iRound;
            int i6;
            int iRound2;
            android.graphics.RectF displayRect = com.dcloud.android.widget.photoview.PhotoViewAttacher.this.getDisplayRect();
            if (displayRect == null) {
                return;
            }
            int iRound3 = java.lang.Math.round(-displayRect.left);
            float f = i;
            if (f < displayRect.width()) {
                iRound = java.lang.Math.round(displayRect.width() - f);
                i5 = 0;
            } else {
                i5 = iRound3;
                iRound = i5;
            }
            int iRound4 = java.lang.Math.round(-displayRect.top);
            float f2 = i2;
            if (f2 < displayRect.height()) {
                iRound2 = java.lang.Math.round(displayRect.height() - f2);
                i6 = 0;
            } else {
                i6 = iRound4;
                iRound2 = i6;
            }
            this.mCurrentX = iRound3;
            this.mCurrentY = iRound4;
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.mScroller.fling(iRound3, iRound4, i3, i4, i5, iRound, i6, iRound2, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mSuppMatrix.postTranslate(this.mCurrentX - currX, this.mCurrentY - currY);
                com.dcloud.android.widget.photoview.PhotoViewAttacher photoViewAttacher = com.dcloud.android.widget.photoview.PhotoViewAttacher.this;
                photoViewAttacher.setImageViewMatrix(photoViewAttacher.getDrawMatrix());
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                com.dcloud.android.widget.photoview.Compat.postOnAnimation(com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mImageView, this);
            }
        }
    }

    public PhotoViewAttacher(android.widget.ImageView imageView) {
        this.mImageView = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.mBaseRotation = 0.0f;
        this.mScaleDragDetector = new com.dcloud.android.widget.photoview.CustomGestureDetector(imageView.getContext(), this);
        android.view.GestureDetector gestureDetector = new android.view.GestureDetector(imageView.getContext(), new android.view.GestureDetector.SimpleOnGestureListener() { // from class: com.dcloud.android.widget.photoview.PhotoViewAttacher.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
                if (com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mSingleFlingListener == null || com.dcloud.android.widget.photoview.PhotoViewAttacher.this.getScale() > com.dcloud.android.widget.photoview.PhotoViewAttacher.DEFAULT_MIN_SCALE || androidx.core.view.MotionEventCompat.getPointerCount(motionEvent) > com.dcloud.android.widget.photoview.PhotoViewAttacher.SINGLE_TOUCH || androidx.core.view.MotionEventCompat.getPointerCount(motionEvent2) > com.dcloud.android.widget.photoview.PhotoViewAttacher.SINGLE_TOUCH) {
                    return false;
                }
                return com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mSingleFlingListener.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(android.view.MotionEvent motionEvent) {
                if (com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mLongClickListener != null) {
                    com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mLongClickListener.onLongClick(com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mImageView);
                }
            }
        });
        this.mGestureDetector = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new android.view.GestureDetector.OnDoubleTapListener() { // from class: com.dcloud.android.widget.photoview.PhotoViewAttacher.2
            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(android.view.MotionEvent motionEvent) {
                try {
                    float scale = com.dcloud.android.widget.photoview.PhotoViewAttacher.this.getScale();
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (scale < com.dcloud.android.widget.photoview.PhotoViewAttacher.this.getMediumScale()) {
                        com.dcloud.android.widget.photoview.PhotoViewAttacher photoViewAttacher = com.dcloud.android.widget.photoview.PhotoViewAttacher.this;
                        photoViewAttacher.setScale(photoViewAttacher.getMediumScale(), x, y, true);
                    } else if (scale < com.dcloud.android.widget.photoview.PhotoViewAttacher.this.getMediumScale() || scale >= com.dcloud.android.widget.photoview.PhotoViewAttacher.this.getMaximumScale()) {
                        com.dcloud.android.widget.photoview.PhotoViewAttacher photoViewAttacher2 = com.dcloud.android.widget.photoview.PhotoViewAttacher.this;
                        photoViewAttacher2.setScale(photoViewAttacher2.getMinimumScale(), x, y, true);
                    } else {
                        com.dcloud.android.widget.photoview.PhotoViewAttacher photoViewAttacher3 = com.dcloud.android.widget.photoview.PhotoViewAttacher.this;
                        photoViewAttacher3.setScale(photoViewAttacher3.getMaximumScale(), x, y, true);
                    }
                } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(android.view.MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(android.view.MotionEvent motionEvent) {
                if (com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mOnClickListener != null) {
                    com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mOnClickListener.onClick(com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mImageView);
                }
                android.graphics.RectF displayRect = com.dcloud.android.widget.photoview.PhotoViewAttacher.this.getDisplayRect();
                if (displayRect == null) {
                    return false;
                }
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (!displayRect.contains(x, y)) {
                    if (com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mOutsidePhotoTapListener == null) {
                        return false;
                    }
                    com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mOutsidePhotoTapListener.onOutsidePhotoTap(com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mImageView);
                    return false;
                }
                float fWidth = (x - displayRect.left) / displayRect.width();
                float fHeight = (y - displayRect.top) / displayRect.height();
                if (com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mPhotoTapListener == null) {
                    return true;
                }
                com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mPhotoTapListener.onPhotoTap(com.dcloud.android.widget.photoview.PhotoViewAttacher.this.mImageView, fWidth, fHeight);
                return true;
            }
        });
    }

    private void cancelFling() {
        com.dcloud.android.widget.photoview.PhotoViewAttacher.FlingRunnable flingRunnable = this.mCurrentFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.mCurrentFlingRunnable = null;
        }
    }

    private void checkAndDisplayMatrix() {
        if (checkMatrixBounds()) {
            setImageViewMatrix(getDrawMatrix());
        }
    }

    private boolean checkMatrixBounds() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        android.graphics.RectF displayRect = getDisplayRect(getDrawMatrix());
        if (displayRect == null) {
            return false;
        }
        float fHeight = displayRect.height();
        float fWidth = displayRect.width();
        float imageViewHeight = getImageViewHeight(this.mImageView);
        float f6 = 0.0f;
        if (fHeight <= imageViewHeight) {
            int i = com.dcloud.android.widget.photoview.PhotoViewAttacher.AnonymousClass3.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    imageViewHeight = (imageViewHeight - fHeight) / 2.0f;
                    f2 = displayRect.top;
                } else {
                    imageViewHeight -= fHeight;
                    f2 = displayRect.top;
                }
            } else {
                f = displayRect.top;
                f3 = -f;
            }
        } else {
            f = displayRect.top;
            if (f > 0.0f) {
                f3 = -f;
            } else {
                f2 = displayRect.bottom;
                f3 = f2 < imageViewHeight ? imageViewHeight - f2 : 0.0f;
            }
        }
        float imageViewWidth = getImageViewWidth(this.mImageView);
        if (fWidth <= imageViewWidth) {
            int i2 = com.dcloud.android.widget.photoview.PhotoViewAttacher.AnonymousClass3.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f4 = (imageViewWidth - fWidth) / 2.0f;
                    f5 = displayRect.left;
                } else {
                    f4 = imageViewWidth - fWidth;
                    f5 = displayRect.left;
                }
                f6 = f4 - f5;
            } else {
                f6 = -displayRect.left;
            }
            this.mScrollEdge = 2;
        } else {
            float f7 = displayRect.left;
            if (f7 > 0.0f) {
                this.mScrollEdge = 0;
                f6 = -f7;
            } else {
                float f8 = displayRect.right;
                if (f8 < imageViewWidth) {
                    f6 = imageViewWidth - f8;
                    this.mScrollEdge = 1;
                } else {
                    this.mScrollEdge = -1;
                }
            }
        }
        this.mSuppMatrix.postTranslate(f6, f3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.graphics.Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.mBaseMatrix);
        this.mDrawMatrix.postConcat(this.mSuppMatrix);
        return this.mDrawMatrix;
    }

    private int getImageViewHeight(android.widget.ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private int getImageViewWidth(android.widget.ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float getValue(android.graphics.Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    private void resetMatrix() {
        this.mSuppMatrix.reset();
        setRotationBy(this.mBaseRotation);
        setImageViewMatrix(getDrawMatrix());
        checkMatrixBounds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageViewMatrix(android.graphics.Matrix matrix) {
        android.graphics.RectF displayRect;
        this.mImageView.setImageMatrix(matrix);
        if (this.mMatrixChangeListener == null || (displayRect = getDisplayRect(matrix)) == null) {
            return;
        }
        this.mMatrixChangeListener.onMatrixChanged(displayRect);
    }

    private void updateBaseMatrix(android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float imageViewWidth = getImageViewWidth(this.mImageView);
        float imageViewHeight = getImageViewHeight(this.mImageView);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.mBaseMatrix.reset();
        float f = intrinsicWidth;
        float f2 = imageViewWidth / f;
        float f3 = intrinsicHeight;
        float f4 = imageViewHeight / f3;
        android.widget.ImageView.ScaleType scaleType = this.mScaleType;
        if (scaleType == android.widget.ImageView.ScaleType.CENTER) {
            this.mBaseMatrix.postTranslate((imageViewWidth - f) / 2.0f, (imageViewHeight - f3) / 2.0f);
        } else if (scaleType == android.widget.ImageView.ScaleType.CENTER_CROP) {
            float fMax = java.lang.Math.max(f2, f4);
            this.mBaseMatrix.postScale(fMax, fMax);
            this.mBaseMatrix.postTranslate((imageViewWidth - (f * fMax)) / 2.0f, (imageViewHeight - (f3 * fMax)) / 2.0f);
        } else if (scaleType == android.widget.ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = java.lang.Math.min(1.0f, java.lang.Math.min(f2, f4));
            this.mBaseMatrix.postScale(fMin, fMin);
            this.mBaseMatrix.postTranslate((imageViewWidth - (f * fMin)) / 2.0f, (imageViewHeight - (f3 * fMin)) / 2.0f);
        } else {
            android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, f, f3);
            android.graphics.RectF rectF2 = new android.graphics.RectF(0.0f, 0.0f, imageViewWidth, imageViewHeight);
            if (((int) this.mBaseRotation) % 180 != 0) {
                rectF = new android.graphics.RectF(0.0f, 0.0f, f3, f);
            }
            int i = com.dcloud.android.widget.photoview.PhotoViewAttacher.AnonymousClass3.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i == 1) {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, android.graphics.Matrix.ScaleToFit.CENTER);
            } else if (i == 2) {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, android.graphics.Matrix.ScaleToFit.START);
            } else if (i == 3) {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, android.graphics.Matrix.ScaleToFit.END);
            } else if (i == 4) {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, android.graphics.Matrix.ScaleToFit.FILL);
            }
        }
        resetMatrix();
    }

    public void getDisplayMatrix(android.graphics.Matrix matrix) {
        matrix.set(getDrawMatrix());
    }

    public android.graphics.RectF getDisplayRect() {
        checkMatrixBounds();
        return getDisplayRect(getDrawMatrix());
    }

    public android.graphics.Matrix getImageMatrix() {
        return this.mDrawMatrix;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getMediumScale() {
        return this.mMidScale;
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getScale() {
        return (float) java.lang.Math.sqrt(((float) java.lang.Math.pow(getValue(this.mSuppMatrix, 0), 2.0d)) + ((float) java.lang.Math.pow(getValue(this.mSuppMatrix, 3), 2.0d)));
    }

    public android.widget.ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void getSuppMatrix(android.graphics.Matrix matrix) {
        matrix.set(this.mSuppMatrix);
    }

    public boolean isZoomEnabled() {
        return this.mZoomEnabled;
    }

    @Override // com.dcloud.android.widget.photoview.OnGestureListener
    public void onDrag(float f, float f2) {
        if (this.mScaleDragDetector.isScaling()) {
            return;
        }
        this.mSuppMatrix.postTranslate(f, f2);
        checkAndDisplayMatrix();
        android.view.ViewParent parent = this.mImageView.getParent();
        if (!this.mAllowParentInterceptOnEdge || this.mScaleDragDetector.isScaling() || this.mBlockParentIntercept) {
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
                return;
            }
            return;
        }
        int i = this.mScrollEdge;
        if ((i == 2 || ((i == 0 && f >= 1.0f) || (i == 1 && f <= -1.0f))) && parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    @Override // com.dcloud.android.widget.photoview.OnGestureListener
    public void onFling(float f, float f2, float f3, float f4) {
        com.dcloud.android.widget.photoview.PhotoViewAttacher.FlingRunnable flingRunnable = new com.dcloud.android.widget.photoview.PhotoViewAttacher.FlingRunnable(this.mImageView.getContext());
        this.mCurrentFlingRunnable = flingRunnable;
        flingRunnable.fling(getImageViewWidth(this.mImageView), getImageViewHeight(this.mImageView), (int) f3, (int) f4);
        this.mImageView.post(this.mCurrentFlingRunnable);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        updateBaseMatrix(this.mImageView.getDrawable());
    }

    @Override // com.dcloud.android.widget.photoview.OnGestureListener
    public void onScale(float f, float f2, float f3) {
        if (getScale() < this.mMaxScale || f < 1.0f) {
            if (getScale() > this.mMinScale || f > 1.0f) {
                com.dcloud.android.widget.photoview.OnScaleChangedListener onScaleChangedListener = this.mScaleChangeListener;
                if (onScaleChangedListener != null) {
                    onScaleChangedListener.onScaleChange(f, f2, f3);
                }
                this.mSuppMatrix.postScale(f, f, f2, f3);
                checkAndDisplayMatrix();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0058  */
    /* JADX WARN: Code duplicated, block: B:30:0x0074  */
    /* JADX WARN: Code duplicated, block: B:35:0x0081  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        boolean z;
        com.dcloud.android.widget.photoview.CustomGestureDetector customGestureDetector;
        android.view.GestureDetector gestureDetector;
        boolean zIsScaling;
        boolean zIsDragging;
        boolean z2;
        boolean z3;
        android.graphics.RectF displayRect;
        boolean z4 = false;
        if (!this.mZoomEnabled || !com.dcloud.android.widget.photoview.Util.hasDrawable((android.widget.ImageView) view)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3) && getScale() < this.mMinScale && (displayRect = getDisplayRect()) != null) {
                this = this;
                view.post(this.new AnimatedZoomRunnable(getScale(), this.mMinScale, displayRect.centerX(), displayRect.centerY()));
                z = true;
            }
            customGestureDetector = this.mScaleDragDetector;
            if (customGestureDetector != null) {
                zIsScaling = customGestureDetector.isScaling();
                zIsDragging = this.mScaleDragDetector.isDragging();
                boolean zOnTouchEvent = this.mScaleDragDetector.onTouchEvent(motionEvent);
                if (!zIsScaling || this.mScaleDragDetector.isScaling()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!zIsDragging || this.mScaleDragDetector.isDragging()) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z2 && z3) {
                    z4 = true;
                }
                this.mBlockParentIntercept = z4;
                z = zOnTouchEvent;
            }
            gestureDetector = this.mGestureDetector;
            if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
            return z;
        }
        android.view.ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        cancelFling();
        z = false;
        customGestureDetector = this.mScaleDragDetector;
        if (customGestureDetector != null) {
            zIsScaling = customGestureDetector.isScaling();
            zIsDragging = this.mScaleDragDetector.isDragging();
            boolean zOnTouchEvent2 = this.mScaleDragDetector.onTouchEvent(motionEvent);
            if (zIsScaling) {
                z2 = false;
            } else {
                z2 = false;
            }
            if (zIsDragging) {
                z3 = false;
            } else {
                z3 = false;
            }
            if (z2) {
                z4 = true;
            }
            this.mBlockParentIntercept = z4;
            z = zOnTouchEvent2;
        }
        gestureDetector = this.mGestureDetector;
        if (gestureDetector == null) {
        }
        return z;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.mAllowParentInterceptOnEdge = z;
    }

    public void setBaseRotation(float f) {
        this.mBaseRotation = f % 360.0f;
        update();
        setRotationBy(this.mBaseRotation);
        checkAndDisplayMatrix();
    }

    public boolean setDisplayMatrix(android.graphics.Matrix matrix) {
        if (matrix == null) {
            throw new java.lang.IllegalArgumentException("Matrix cannot be null");
        }
        if (this.mImageView.getDrawable() == null) {
            return false;
        }
        this.mSuppMatrix.set(matrix);
        setImageViewMatrix(getDrawMatrix());
        checkMatrixBounds();
        return true;
    }

    public void setMaximumScale(float f) {
        com.dcloud.android.widget.photoview.Util.checkZoomLevels(this.mMinScale, this.mMidScale, f);
        this.mMaxScale = f;
    }

    public void setMediumScale(float f) {
        com.dcloud.android.widget.photoview.Util.checkZoomLevels(this.mMinScale, f, this.mMaxScale);
        this.mMidScale = f;
    }

    public void setMinimumScale(float f) {
        com.dcloud.android.widget.photoview.Util.checkZoomLevels(f, this.mMidScale, this.mMaxScale);
        this.mMinScale = f;
    }

    public void setOnClickListener(android.view.View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnDoubleTapListener(android.view.GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mGestureDetector.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(android.view.View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnMatrixChangeListener(com.dcloud.android.widget.photoview.OnMatrixChangedListener onMatrixChangedListener) {
        this.mMatrixChangeListener = onMatrixChangedListener;
    }

    public void setOnOutsidePhotoTapListener(com.dcloud.android.widget.photoview.OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.mOutsidePhotoTapListener = onOutsidePhotoTapListener;
    }

    public void setOnPhotoTapListener(com.dcloud.android.widget.photoview.OnPhotoTapListener onPhotoTapListener) {
        this.mPhotoTapListener = onPhotoTapListener;
    }

    public void setOnScaleChangeListener(com.dcloud.android.widget.photoview.OnScaleChangedListener onScaleChangedListener) {
        this.mScaleChangeListener = onScaleChangedListener;
    }

    public void setOnSingleFlingListener(com.dcloud.android.widget.photoview.OnSingleFlingListener onSingleFlingListener) {
        this.mSingleFlingListener = onSingleFlingListener;
    }

    public void setRotationBy(float f) {
        this.mSuppMatrix.postRotate(f % 360.0f);
        checkAndDisplayMatrix();
    }

    public void setRotationTo(float f) {
        this.mSuppMatrix.setRotate(f % 360.0f);
        checkAndDisplayMatrix();
    }

    public void setScale(float f) {
        setScale(f, false);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        com.dcloud.android.widget.photoview.Util.checkZoomLevels(f, f2, f3);
        this.mMinScale = f;
        this.mMidScale = f2;
        this.mMaxScale = f3;
    }

    public void setScaleType(android.widget.ImageView.ScaleType scaleType) {
        if (!com.dcloud.android.widget.photoview.Util.isSupportedScaleType(scaleType) || scaleType == this.mScaleType) {
            return;
        }
        this.mScaleType = scaleType;
        update();
    }

    public void setZoomInterpolator(android.view.animation.Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setZoomTransitionDuration(int i) {
        this.mZoomDuration = i;
    }

    public void setZoomable(boolean z) {
        this.mZoomEnabled = z;
        update();
    }

    public void update() {
        if (this.mZoomEnabled) {
            updateBaseMatrix(this.mImageView.getDrawable());
        } else {
            resetMatrix();
        }
    }

    public void setScale(float f, boolean z) {
        setScale(f, this.mImageView.getRight() / 2, this.mImageView.getBottom() / 2, z);
    }

    private android.graphics.RectF getDisplayRect(android.graphics.Matrix matrix) {
        android.graphics.drawable.Drawable drawable = this.mImageView.getDrawable();
        if (drawable == null) {
            return null;
        }
        this.mDisplayRect.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.mDisplayRect);
        return this.mDisplayRect;
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        if (f < this.mMinScale || f > this.mMaxScale) {
            throw new java.lang.IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z) {
            this.mImageView.post(new com.dcloud.android.widget.photoview.PhotoViewAttacher.AnimatedZoomRunnable(getScale(), f, f2, f3));
        } else {
            this.mSuppMatrix.setScale(f, f, f2, f3);
            checkAndDisplayMatrix();
        }
    }
}
