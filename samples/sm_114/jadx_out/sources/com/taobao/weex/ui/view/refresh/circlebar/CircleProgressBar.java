package com.taobao.weex.ui.view.refresh.circlebar;

/* JADX INFO: loaded from: classes.dex */
public class CircleProgressBar extends android.widget.ImageView {
    public static final int DEFAULT_CIRCLE_BG_LIGHT = -328966;
    public static final int DEFAULT_CIRCLE_COLOR = -1048576;
    private static final int DEFAULT_CIRCLE_DIAMETER = 40;
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final int KEY_SHADOW_COLOR = 503316480;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final int STROKE_WIDTH_LARGE = 3;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.75f;
    private boolean isLayoutFinished;
    private int mArrowHeight;
    private int mArrowWidth;
    private int mBackGroundColor;
    private android.graphics.drawable.ShapeDrawable mBgCircle;
    private boolean mCircleBackgroundEnabled;
    private int[] mColors;
    private int mDiameter;
    private android.os.Handler mHandler;
    private int mInnerRadius;
    private android.view.animation.Animation.AnimationListener mListener;
    private int mMax;
    private int mProgress;
    private int mProgressColor;
    public com.taobao.weex.ui.view.refresh.circlebar.MaterialProgressDrawable mProgressDrawable;
    private int mProgressStokeWidth;
    private int mShadowRadius;
    private boolean mShowArrow;

    private boolean elevationSupported() {
        return true;
    }

    public CircleProgressBar(android.content.Context context) {
        super(context);
        this.mColors = new int[]{-16777216};
        this.isLayoutFinished = false;
        this.mHandler = new android.os.Handler() { // from class: com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                super.handleMessage(message);
                if (message.what == 10010) {
                    if (com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.this.isLayoutFinished && com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.this.mProgressDrawable != null) {
                        com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.this.mProgressDrawable.start();
                    } else {
                        postDelayed(new java.lang.Runnable() { // from class: com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.this.mHandler.sendEmptyMessage(10010);
                            }
                        }, 100L);
                    }
                }
            }
        };
        init(context, null, 0);
    }

    public CircleProgressBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mColors = new int[]{-16777216};
        this.isLayoutFinished = false;
        this.mHandler = new android.os.Handler() { // from class: com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                super.handleMessage(message);
                if (message.what == 10010) {
                    if (com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.this.isLayoutFinished && com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.this.mProgressDrawable != null) {
                        com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.this.mProgressDrawable.start();
                    } else {
                        postDelayed(new java.lang.Runnable() { // from class: com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.this.mHandler.sendEmptyMessage(10010);
                            }
                        }, 100L);
                    }
                }
            }
        };
        init(context, attributeSet, 0);
    }

    public CircleProgressBar(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mColors = new int[]{-16777216};
        this.isLayoutFinished = false;
        this.mHandler = new android.os.Handler() { // from class: com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                super.handleMessage(message);
                if (message.what == 10010) {
                    if (com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.this.isLayoutFinished && com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.this.mProgressDrawable != null) {
                        com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.this.mProgressDrawable.start();
                    } else {
                        postDelayed(new java.lang.Runnable() { // from class: com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.this.mHandler.sendEmptyMessage(10010);
                            }
                        }, 100L);
                    }
                }
            }
        };
        init(context, attributeSet, i);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.mBackGroundColor = DEFAULT_CIRCLE_BG_LIGHT;
        this.mProgressColor = DEFAULT_CIRCLE_COLOR;
        this.mColors = new int[]{DEFAULT_CIRCLE_COLOR};
        this.mInnerRadius = -1;
        this.mProgressStokeWidth = (int) (f * 3.0f);
        this.mArrowWidth = -1;
        this.mArrowHeight = -1;
        this.mShowArrow = true;
        this.mCircleBackgroundEnabled = true;
        this.mProgress = 0;
        this.mMax = 100;
        com.taobao.weex.ui.view.refresh.circlebar.MaterialProgressDrawable materialProgressDrawable = new com.taobao.weex.ui.view.refresh.circlebar.MaterialProgressDrawable(getContext(), this);
        this.mProgressDrawable = materialProgressDrawable;
        super.setImageDrawable(materialProgressDrawable);
    }

    public void setProgressBackGroundColor(int i) {
        this.mBackGroundColor = i;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (elevationSupported()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.mShadowRadius * 2), getMeasuredHeight() + (this.mShadowRadius * 2));
    }

    public int getProgressStokeWidth() {
        return this.mProgressStokeWidth;
    }

    public void setProgressStokeWidth(int i) {
        this.mProgressStokeWidth = (int) (i * getContext().getResources().getDisplayMetrics().density);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float f = getContext().getResources().getDisplayMetrics().density;
        int iMin = java.lang.Math.min(getMeasuredWidth(), getMeasuredHeight());
        this.mDiameter = iMin;
        if (iMin <= 0) {
            this.mDiameter = ((int) f) * 40;
        }
        if (getBackground() == null && this.mCircleBackgroundEnabled) {
            int i5 = (int) (Y_OFFSET * f);
            int i6 = (int) (f * 0.0f);
            this.mShadowRadius = (int) (SHADOW_RADIUS * f);
            if (elevationSupported()) {
                this.mBgCircle = new android.graphics.drawable.ShapeDrawable(new android.graphics.drawable.shapes.OvalShape());
                androidx.core.view.ViewCompat.setElevation(this, f * 4.0f);
            } else {
                int i7 = this.mShadowRadius;
                android.graphics.drawable.ShapeDrawable shapeDrawable = new android.graphics.drawable.ShapeDrawable(new com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.OvalShadow(i7, this.mDiameter - (i7 * 2)));
                this.mBgCircle = shapeDrawable;
                androidx.core.view.ViewCompat.setLayerType(this, 1, shapeDrawable.getPaint());
                this.mBgCircle.getPaint().setShadowLayer(this.mShadowRadius, i6, i5, KEY_SHADOW_COLOR);
                int i8 = this.mShadowRadius;
                setPadding(i8, i8, i8, i8);
            }
            this.mBgCircle.getPaint().setColor(this.mBackGroundColor);
            setBackgroundDrawable(this.mBgCircle);
        }
        com.taobao.weex.ui.view.refresh.circlebar.MaterialProgressDrawable materialProgressDrawable = this.mProgressDrawable;
        if (materialProgressDrawable == null) {
            return;
        }
        materialProgressDrawable.setBackgroundColor(this.mBackGroundColor);
        this.mProgressDrawable.setColorSchemeColors(this.mColors);
        if (isShowArrow()) {
            this.mProgressDrawable.setArrowScale(1.0f);
            this.mProgressDrawable.showArrow(true);
        }
        super.setImageDrawable(null);
        super.setImageDrawable(this.mProgressDrawable);
        this.mProgressDrawable.setAlpha(255);
        if (getVisibility() == 0) {
            this.mProgressDrawable.setStartEndTrim(0.0f, 0.8f);
        }
        this.isLayoutFinished = true;
    }

    public boolean isShowArrow() {
        return this.mShowArrow;
    }

    public void setShowArrow(boolean z) {
        this.mShowArrow = z;
    }

    public void setAnimationListener(android.view.animation.Animation.AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        android.view.animation.Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        android.view.animation.Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void setColorSchemeColors(int... iArr) {
        this.mColors = iArr;
        com.taobao.weex.ui.view.refresh.circlebar.MaterialProgressDrawable materialProgressDrawable = this.mProgressDrawable;
        if (materialProgressDrawable != null) {
            materialProgressDrawable.setColorSchemeColors(iArr);
        }
    }

    public void setBackgroundColorResource(int i) {
        if (getBackground() instanceof android.graphics.drawable.ShapeDrawable) {
            ((android.graphics.drawable.ShapeDrawable) getBackground()).getPaint().setColor(getResources().getColor(i));
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (getBackground() instanceof android.graphics.drawable.ShapeDrawable) {
            ((android.graphics.drawable.ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    public int getMax() {
        return this.mMax;
    }

    public void setMax(int i) {
        this.mMax = i;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int i) {
        if (getMax() > 0) {
            this.mProgress = i;
        }
        invalidate();
    }

    public boolean circleBackgroundEnabled() {
        return this.mCircleBackgroundEnabled;
    }

    public void setCircleBackgroundEnabled(boolean z) {
        this.mCircleBackgroundEnabled = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.taobao.weex.ui.view.refresh.circlebar.MaterialProgressDrawable materialProgressDrawable = this.mProgressDrawable;
        if (materialProgressDrawable != null) {
            materialProgressDrawable.stop();
            this.mProgressDrawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.taobao.weex.ui.view.refresh.circlebar.MaterialProgressDrawable materialProgressDrawable = this.mProgressDrawable;
        if (materialProgressDrawable != null) {
            materialProgressDrawable.stop();
            this.mProgressDrawable.setVisible(false, false);
        }
    }

    private class OvalShadow extends android.graphics.drawable.shapes.OvalShape {
        private int mCircleDiameter;
        private android.graphics.RadialGradient mRadialGradient;
        private android.graphics.Paint mShadowPaint = new android.graphics.Paint();
        private int mShadowRadius;

        public OvalShadow(int i, int i2) {
            this.mShadowRadius = i;
            this.mCircleDiameter = i2;
            int i3 = this.mCircleDiameter;
            android.graphics.RadialGradient radialGradient = new android.graphics.RadialGradient(i3 / 2, i3 / 2, this.mShadowRadius, new int[]{com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.FILL_SHADOW_COLOR, 0}, (float[]) null, android.graphics.Shader.TileMode.CLAMP);
            this.mRadialGradient = radialGradient;
            this.mShadowPaint.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(android.graphics.Canvas canvas, android.graphics.Paint paint) {
            float width = com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.this.getWidth() / 2;
            float height = com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar.this.getHeight() / 2;
            canvas.drawCircle(width, height, (this.mCircleDiameter / 2) + this.mShadowRadius, this.mShadowPaint);
            canvas.drawCircle(width, height, this.mCircleDiameter / 2, paint);
        }
    }

    public void start() {
        this.mHandler.sendEmptyMessage(10010);
    }

    public void setStartEndTrim(float f, float f2) {
        com.taobao.weex.ui.view.refresh.circlebar.MaterialProgressDrawable materialProgressDrawable = this.mProgressDrawable;
        if (materialProgressDrawable != null) {
            materialProgressDrawable.setStartEndTrim(f, f2);
        }
    }

    public void stop() {
        com.taobao.weex.ui.view.refresh.circlebar.MaterialProgressDrawable materialProgressDrawable = this.mProgressDrawable;
        if (materialProgressDrawable != null) {
            materialProgressDrawable.stop();
        }
        this.mHandler.removeMessages(10010);
    }

    public void setProgressRotation(float f) {
        com.taobao.weex.ui.view.refresh.circlebar.MaterialProgressDrawable materialProgressDrawable = this.mProgressDrawable;
        if (materialProgressDrawable != null) {
            materialProgressDrawable.setProgressRotation(f);
        }
    }

    public void destory() {
        this.mProgressDrawable.stop();
        this.mProgressDrawable = null;
    }
}
