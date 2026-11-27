package com.dcloud.android.v4.widget;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class MaterialProgressDrawable extends android.graphics.drawable.Drawable implements android.graphics.drawable.Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final float ARROW_OFFSET_ANGLE = 5.0f;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 8.75f;
    private static final float CENTER_RADIUS_LARGE = 12.5f;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float COLOR_START_DELAY_OFFSET = 0.75f;
    public static final int DEFAULT = 1;
    private static final float END_TRIM_START_DELAY_OFFSET = 0.5f;
    private static final float FULL_ROTATION = 1080.0f;
    public static final int LARGE = 0;
    private static final android.view.animation.Interpolator LINEAR_INTERPOLATOR = new android.view.animation.LinearInterpolator();
    private static final android.view.animation.Interpolator MATERIAL_INTERPOLATOR = new com.dcloud.android.v4.view.animation.FastOutSlowInInterpolator();
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float NUM_POINTS = 5.0f;
    private static final float START_TRIM_DURATION_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private final int[] COLORS;
    private android.view.animation.Animation mAnimation;
    private final java.util.ArrayList<android.view.animation.Animation> mAnimators = new java.util.ArrayList<>();
    private final android.graphics.drawable.Drawable.Callback mCallback;
    boolean mFinishing;
    private double mHeight;
    private android.view.View mParent;
    private android.content.res.Resources mResources;
    private final com.dcloud.android.v4.widget.MaterialProgressDrawable.Ring mRing;
    private float mRotation;
    private float mRotationCount;
    private double mWidth;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
    public @interface ProgressDrawableSize {
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class Ring {
        private int mAlpha;
        private android.graphics.Path mArrow;
        private int mArrowHeight;
        private final android.graphics.Paint mArrowPaint;
        private float mArrowScale;
        private int mArrowWidth;
        private int mBackgroundColor;
        private final android.graphics.drawable.Drawable.Callback mCallback;
        private final android.graphics.Paint mCirclePaint;
        private int mColorIndex;
        private int[] mColors;
        private int mCurrentColor;
        private float mEndTrim;
        private final android.graphics.Paint mPaint;
        private double mRingCenterRadius;
        private float mRotation;
        private boolean mShowArrow;
        private float mStartTrim;
        private float mStartingEndTrim;
        private float mStartingRotation;
        private float mStartingStartTrim;
        private float mStrokeInset;
        private float mStrokeWidth;
        private final android.graphics.RectF mTempBounds = new android.graphics.RectF();

        public Ring(android.graphics.drawable.Drawable.Callback callback) {
            android.graphics.Paint paint = new android.graphics.Paint();
            this.mPaint = paint;
            android.graphics.Paint paint2 = new android.graphics.Paint();
            this.mArrowPaint = paint2;
            this.mStartTrim = 0.0f;
            this.mEndTrim = 0.0f;
            this.mRotation = 0.0f;
            this.mStrokeWidth = 5.0f;
            this.mStrokeInset = com.dcloud.android.v4.widget.MaterialProgressDrawable.STROKE_WIDTH;
            this.mCirclePaint = new android.graphics.Paint(1);
            this.mCallback = callback;
            paint.setStrokeCap(android.graphics.Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            paint2.setStyle(android.graphics.Paint.Style.FILL);
            paint2.setAntiAlias(true);
        }

        private void drawTriangle(android.graphics.Canvas canvas, float f, float f2, android.graphics.Rect rect) {
            if (this.mShowArrow) {
                android.graphics.Path path = this.mArrow;
                if (path == null) {
                    android.graphics.Path path2 = new android.graphics.Path();
                    this.mArrow = path2;
                    path2.setFillType(android.graphics.Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f3 = (((int) this.mStrokeInset) / 2) * this.mArrowScale;
                float fCos = (float) ((this.mRingCenterRadius * java.lang.Math.cos(0.0d)) + ((double) rect.exactCenterX()));
                float fSin = (float) ((this.mRingCenterRadius * java.lang.Math.sin(0.0d)) + ((double) rect.exactCenterY()));
                this.mArrow.moveTo(0.0f, 0.0f);
                this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
                android.graphics.Path path3 = this.mArrow;
                float f4 = this.mArrowWidth;
                float f5 = this.mArrowScale;
                path3.lineTo((f4 * f5) / 2.0f, this.mArrowHeight * f5);
                this.mArrow.offset(fCos - f3, fSin);
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mCurrentColor);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.mArrow, this.mArrowPaint);
            }
        }

        private int getNextColorIndex() {
            return (this.mColorIndex + 1) % this.mColors.length;
        }

        private void invalidateSelf() {
            this.mCallback.invalidateDrawable(null);
        }

        public void draw(android.graphics.Canvas canvas, android.graphics.Rect rect) {
            android.graphics.RectF rectF = this.mTempBounds;
            rectF.set(rect);
            float f = this.mStrokeInset;
            rectF.inset(f, f);
            float f2 = this.mStartTrim;
            float f3 = this.mRotation;
            float f4 = (f2 + f3) * 360.0f;
            float f5 = ((this.mEndTrim + f3) * 360.0f) - f4;
            this.mPaint.setColor(this.mCurrentColor);
            canvas.drawArc(rectF, f4, f5, false, this.mPaint);
            drawTriangle(canvas, f4, f5, rect);
            if (this.mAlpha < 255) {
                this.mCirclePaint.setColor(this.mBackgroundColor);
                this.mCirclePaint.setAlpha(255 - this.mAlpha);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2, this.mCirclePaint);
            }
        }

        public int getAlpha() {
            return this.mAlpha;
        }

        public double getCenterRadius() {
            return this.mRingCenterRadius;
        }

        public float getEndTrim() {
            return this.mEndTrim;
        }

        public float getInsets() {
            return this.mStrokeInset;
        }

        public int getNextColor() {
            return this.mColors[getNextColorIndex()];
        }

        public float getRotation() {
            return this.mRotation;
        }

        public float getStartTrim() {
            return this.mStartTrim;
        }

        public int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        public float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        public float getStartingRotation() {
            return this.mStartingRotation;
        }

        public float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public void goToNextColor() {
            setColorIndex(getNextColorIndex());
        }

        public void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }

        public void setAlpha(int i) {
            this.mAlpha = i;
        }

        public void setArrowDimensions(float f, float f2) {
            this.mArrowWidth = (int) f;
            this.mArrowHeight = (int) f2;
        }

        public void setArrowScale(float f) {
            if (f != this.mArrowScale) {
                this.mArrowScale = f;
                invalidateSelf();
            }
        }

        public void setBackgroundColor(int i) {
            this.mBackgroundColor = i;
        }

        public void setCenterRadius(double d) {
            this.mRingCenterRadius = d;
        }

        public void setColor(int i) {
            this.mCurrentColor = i;
        }

        public void setColorFilter(android.graphics.ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        public void setColorIndex(int i) {
            this.mColorIndex = i;
            this.mCurrentColor = this.mColors[i];
        }

        public void setColors(int[] iArr) {
            this.mColors = iArr;
            setColorIndex(0);
        }

        public void setEndTrim(float f) {
            this.mEndTrim = f;
            invalidateSelf();
        }

        public void setInsets(int i, int i2) {
            float fMin = java.lang.Math.min(i, i2);
            double d = this.mRingCenterRadius;
            this.mStrokeInset = (float) ((d <= 0.0d || fMin < 0.0f) ? java.lang.Math.ceil(this.mStrokeWidth / 2.0f) : ((double) (fMin / 2.0f)) - d);
        }

        public void setRotation(float f) {
            this.mRotation = f;
            invalidateSelf();
        }

        public void setShowArrow(boolean z) {
            if (this.mShowArrow != z) {
                this.mShowArrow = z;
                invalidateSelf();
            }
        }

        public void setStartTrim(float f) {
            this.mStartTrim = f;
            invalidateSelf();
        }

        public void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
            this.mPaint.setStrokeWidth(f);
            invalidateSelf();
        }

        public void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }
    }

    public MaterialProgressDrawable(android.content.Context context, android.view.View view) {
        int[] iArr = {-16777216};
        this.COLORS = iArr;
        android.graphics.drawable.Drawable.Callback callback = new android.graphics.drawable.Drawable.Callback() { // from class: com.dcloud.android.v4.widget.MaterialProgressDrawable.3
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(android.graphics.drawable.Drawable drawable) {
                com.dcloud.android.v4.widget.MaterialProgressDrawable.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable, long j) {
                com.dcloud.android.v4.widget.MaterialProgressDrawable.this.scheduleSelf(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable) {
                com.dcloud.android.v4.widget.MaterialProgressDrawable.this.unscheduleSelf(runnable);
            }
        };
        this.mCallback = callback;
        this.mParent = view;
        this.mResources = context.getResources();
        com.dcloud.android.v4.widget.MaterialProgressDrawable.Ring ring = new com.dcloud.android.v4.widget.MaterialProgressDrawable.Ring(callback);
        this.mRing = ring;
        ring.setColors(iArr);
        updateSizes(1);
        setupAnimators();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyFinishTranslation(float f, com.dcloud.android.v4.widget.MaterialProgressDrawable.Ring ring) {
        updateRingColor(f, ring);
        float fFloor = (float) (java.lang.Math.floor(ring.getStartingRotation() / MAX_PROGRESS_ARC) + 1.0d);
        ring.setStartTrim(ring.getStartingStartTrim() + (((ring.getStartingEndTrim() - getMinProgressArc(ring)) - ring.getStartingStartTrim()) * f));
        ring.setEndTrim(ring.getStartingEndTrim());
        ring.setRotation(ring.getStartingRotation() + ((fFloor - ring.getStartingRotation()) * f));
    }

    private int evaluateColorChange(float f, int i, int i2) {
        int i3 = (i >> 24) & 255;
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = i & 255;
        return ((i3 + ((int) ((((i2 >> 24) & 255) - i3) * f))) << 24) | ((i4 + ((int) ((((i2 >> 16) & 255) - i4) * f))) << 16) | ((i5 + ((int) ((((i2 >> 8) & 255) - i5) * f))) << 8) | (i6 + ((int) (f * ((i2 & 255) - i6))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getMinProgressArc(com.dcloud.android.v4.widget.MaterialProgressDrawable.Ring ring) {
        return (float) java.lang.Math.toRadians(((double) ring.getStrokeWidth()) / (ring.getCenterRadius() * 6.283185307179586d));
    }

    private float getRotation() {
        return this.mRotation;
    }

    private void setSizeParameters(double d, double d2, double d3, double d4, float f, float f2) {
        com.dcloud.android.v4.widget.MaterialProgressDrawable.Ring ring = this.mRing;
        float f3 = this.mResources.getDisplayMetrics().density;
        double d5 = f3;
        this.mWidth = d * d5;
        this.mHeight = d2 * d5;
        ring.setStrokeWidth(((float) d4) * f3);
        ring.setCenterRadius(d3 * d5);
        ring.setColorIndex(0);
        ring.setArrowDimensions(f * f3, f2 * f3);
        ring.setInsets((int) this.mWidth, (int) this.mHeight);
    }

    private void setupAnimators() {
        final com.dcloud.android.v4.widget.MaterialProgressDrawable.Ring ring = this.mRing;
        android.view.animation.Animation animation = new android.view.animation.Animation() { // from class: com.dcloud.android.v4.widget.MaterialProgressDrawable.1
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, android.view.animation.Transformation transformation) {
                com.dcloud.android.v4.widget.MaterialProgressDrawable materialProgressDrawable = com.dcloud.android.v4.widget.MaterialProgressDrawable.this;
                if (materialProgressDrawable.mFinishing) {
                    materialProgressDrawable.applyFinishTranslation(f, ring);
                    return;
                }
                float minProgressArc = materialProgressDrawable.getMinProgressArc(ring);
                float startingEndTrim = ring.getStartingEndTrim();
                float startingStartTrim = ring.getStartingStartTrim();
                float startingRotation = ring.getStartingRotation();
                com.dcloud.android.v4.widget.MaterialProgressDrawable.this.updateRingColor(f, ring);
                if (f <= 0.5f) {
                    ring.setStartTrim(startingStartTrim + ((com.dcloud.android.v4.widget.MaterialProgressDrawable.MAX_PROGRESS_ARC - minProgressArc) * com.dcloud.android.v4.widget.MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation(f / 0.5f)));
                }
                if (f > 0.5f) {
                    ring.setEndTrim(startingEndTrim + ((com.dcloud.android.v4.widget.MaterialProgressDrawable.MAX_PROGRESS_ARC - minProgressArc) * com.dcloud.android.v4.widget.MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation((f - 0.5f) / 0.5f)));
                }
                ring.setRotation(startingRotation + (0.25f * f));
                com.dcloud.android.v4.widget.MaterialProgressDrawable.this.setRotation((f * 216.0f) + ((com.dcloud.android.v4.widget.MaterialProgressDrawable.this.mRotationCount / 5.0f) * com.dcloud.android.v4.widget.MaterialProgressDrawable.FULL_ROTATION));
            }
        };
        animation.setRepeatCount(-1);
        animation.setRepeatMode(1);
        animation.setInterpolator(LINEAR_INTERPOLATOR);
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.dcloud.android.v4.widget.MaterialProgressDrawable.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation2) {
                ring.storeOriginals();
                ring.goToNextColor();
                com.dcloud.android.v4.widget.MaterialProgressDrawable.Ring ring2 = ring;
                ring2.setStartTrim(ring2.getEndTrim());
                com.dcloud.android.v4.widget.MaterialProgressDrawable materialProgressDrawable = com.dcloud.android.v4.widget.MaterialProgressDrawable.this;
                if (!materialProgressDrawable.mFinishing) {
                    materialProgressDrawable.mRotationCount = (materialProgressDrawable.mRotationCount + 1.0f) % 5.0f;
                    return;
                }
                materialProgressDrawable.mFinishing = false;
                animation2.setDuration(1332L);
                ring.setShowArrow(false);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation2) {
                com.dcloud.android.v4.widget.MaterialProgressDrawable.this.mRotationCount = 0.0f;
            }
        });
        this.mAnimation = animation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRingColor(float f, com.dcloud.android.v4.widget.MaterialProgressDrawable.Ring ring) {
        if (f > 0.75f) {
            ring.setColor(evaluateColorChange((f - 0.75f) / 0.25f, ring.getStartingColor(), ring.getNextColor()));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        android.graphics.Rect bounds = getBounds();
        int iSave = canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.draw(canvas, bounds);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.mHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        java.util.ArrayList<android.view.animation.Animation> arrayList = this.mAnimators;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            android.view.animation.Animation animation = arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mRing.setAlpha(i);
    }

    public void setArrowScale(float f) {
        this.mRing.setArrowScale(f);
    }

    public void setBackgroundColor(int i) {
        this.mRing.setBackgroundColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        this.mRing.setColorFilter(colorFilter);
    }

    public void setColorSchemeColors(int... iArr) {
        this.mRing.setColors(iArr);
        this.mRing.setColorIndex(0);
    }

    public void setProgressRotation(float f) {
        this.mRing.setRotation(f);
    }

    void setRotation(float f) {
        this.mRotation = f;
        invalidateSelf();
    }

    public void setStartEndTrim(float f, float f2) {
        this.mRing.setStartTrim(f);
        this.mRing.setEndTrim(f2);
    }

    public void showArrow(boolean z) {
        this.mRing.setShowArrow(z);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mAnimation.reset();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
            this.mFinishing = true;
            this.mAnimation.setDuration(666L);
            this.mParent.startAnimation(this.mAnimation);
        } else {
            this.mRing.setColorIndex(0);
            this.mRing.resetOriginals();
            this.mAnimation.setDuration(1332L);
            this.mParent.startAnimation(this.mAnimation);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mParent.clearAnimation();
        setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
    }

    public void updateSizes(int i) {
        if (i == 0) {
            setSizeParameters(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            setSizeParameters(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }
}
