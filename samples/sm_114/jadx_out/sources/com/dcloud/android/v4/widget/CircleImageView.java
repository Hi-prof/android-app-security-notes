package com.dcloud.android.v4.widget;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class CircleImageView extends android.widget.ImageView {
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final int KEY_SHADOW_COLOR = 1577058304;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 2.5f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.0f;
    private android.view.animation.Animation.AnimationListener mListener;
    private int mShadowRadius;
    boolean mUseElevation;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class OvalShadow extends android.graphics.drawable.shapes.OvalShape {
        private int mCircleDiameter;
        private android.graphics.RadialGradient mRadialGradient;
        private android.graphics.Paint mShadowPaint = new android.graphics.Paint();

        public OvalShadow(int i, int i2) {
            com.dcloud.android.v4.widget.CircleImageView.this.mShadowRadius = i;
            this.mCircleDiameter = i2;
            float f = this.mCircleDiameter / 2;
            android.graphics.RadialGradient radialGradient = new android.graphics.RadialGradient(f, f, com.dcloud.android.v4.widget.CircleImageView.this.mShadowRadius, new int[]{com.dcloud.android.v4.widget.CircleImageView.FILL_SHADOW_COLOR, 0}, (float[]) null, android.graphics.Shader.TileMode.CLAMP);
            this.mRadialGradient = radialGradient;
            this.mShadowPaint.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(android.graphics.Canvas canvas, android.graphics.Paint paint) {
            float width = com.dcloud.android.v4.widget.CircleImageView.this.getWidth() / 2;
            float height = com.dcloud.android.v4.widget.CircleImageView.this.getHeight() / 2;
            canvas.drawCircle(width, height, (this.mCircleDiameter / 2) + com.dcloud.android.v4.widget.CircleImageView.this.mShadowRadius, this.mShadowPaint);
            canvas.drawCircle(width, height, this.mCircleDiameter / 2, paint);
        }
    }

    public CircleImageView(android.content.Context context, int i, float f, boolean z) {
        android.graphics.drawable.ShapeDrawable shapeDrawable;
        super(context);
        this.mUseElevation = true;
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (f * f2 * 2.0f);
        int i3 = (int) (Y_OFFSET * f2);
        int i4 = (int) (0.0f * f2);
        this.mUseElevation = z;
        this.mShadowRadius = (int) (SHADOW_RADIUS * f2);
        if (elevationSupported()) {
            shapeDrawable = new android.graphics.drawable.ShapeDrawable(new android.graphics.drawable.shapes.OvalShape());
            com.dcloud.android.v4.view.ViewCompat.setElevation(this, f2 * 4.0f);
        } else {
            android.graphics.drawable.ShapeDrawable shapeDrawable2 = new android.graphics.drawable.ShapeDrawable(new com.dcloud.android.v4.widget.CircleImageView.OvalShadow(this.mShadowRadius, i2));
            com.dcloud.android.v4.view.ViewCompat.setLayerType(this, 1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.mShadowRadius, i4, i3, KEY_SHADOW_COLOR);
            int i5 = this.mShadowRadius;
            setPadding(i5, i5, i5, i5);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        setBackgroundDrawable(shapeDrawable);
    }

    private boolean elevationSupported() {
        return this.mUseElevation;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        android.view.animation.Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        android.view.animation.Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (elevationSupported()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.mShadowRadius * 2), getMeasuredHeight() + (this.mShadowRadius * 2));
    }

    public void setAnimationListener(android.view.animation.Animation.AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (getBackground() instanceof android.graphics.drawable.ShapeDrawable) {
            ((android.graphics.drawable.ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    public void setBackgroundColorRes(int i) {
        setBackgroundColor(getContext().getResources().getColor(i));
    }

    public CircleImageView(android.content.Context context, int i, float f) {
        this(context, i, f, true);
    }
}
