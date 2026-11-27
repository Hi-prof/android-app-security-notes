package io.dcloud.feature.weex.adapter.widget.refresh;

/* JADX INFO: loaded from: classes2.dex */
public class DCWeexCircleImageView extends android.widget.ImageView {
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final int KEY_SHADOW_COLOR = 1577058304;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 2.5f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.0f;
    private android.view.animation.Animation.AnimationListener mListener;
    private int mShadowRadius;

    private boolean elevationSupported() {
        return true;
    }

    public DCWeexCircleImageView(android.content.Context context, int i, float f) {
        android.graphics.drawable.ShapeDrawable shapeDrawable;
        super(context);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (f * f2 * 2.0f);
        int i3 = (int) (Y_OFFSET * f2);
        int i4 = (int) (0.0f * f2);
        this.mShadowRadius = (int) (SHADOW_RADIUS * f2);
        if (elevationSupported()) {
            shapeDrawable = new android.graphics.drawable.ShapeDrawable(new android.graphics.drawable.shapes.OvalShape());
            com.dcloud.android.v4.view.ViewCompat.setElevation(this, f2 * 4.0f);
        } else {
            shapeDrawable = new android.graphics.drawable.ShapeDrawable(new io.dcloud.feature.weex.adapter.widget.refresh.DCWeexCircleImageView.OvalShadow(this.mShadowRadius, i2));
            com.dcloud.android.v4.view.ViewCompat.setLayerType(this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer(this.mShadowRadius, i4, i3, KEY_SHADOW_COLOR);
            int i5 = this.mShadowRadius;
            setPadding(i5, i5, i5, i5);
        }
        shapeDrawable.getPaint().setColor(i);
        setBackgroundDrawable(shapeDrawable);
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

    public void setBackgroundColorRes(int i) {
        setBackgroundColor(getContext().getResources().getColor(i));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (getBackground() instanceof android.graphics.drawable.ShapeDrawable) {
            ((android.graphics.drawable.ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    private class OvalShadow extends android.graphics.drawable.shapes.OvalShape {
        private int mCircleDiameter;
        private android.graphics.RadialGradient mRadialGradient;
        private android.graphics.Paint mShadowPaint = new android.graphics.Paint();

        public OvalShadow(int i, int i2) {
            io.dcloud.feature.weex.adapter.widget.refresh.DCWeexCircleImageView.this.mShadowRadius = i;
            this.mCircleDiameter = i2;
            int i3 = this.mCircleDiameter;
            android.graphics.RadialGradient radialGradient = new android.graphics.RadialGradient(i3 / 2, i3 / 2, io.dcloud.feature.weex.adapter.widget.refresh.DCWeexCircleImageView.this.mShadowRadius, new int[]{io.dcloud.feature.weex.adapter.widget.refresh.DCWeexCircleImageView.FILL_SHADOW_COLOR, 0}, (float[]) null, android.graphics.Shader.TileMode.CLAMP);
            this.mRadialGradient = radialGradient;
            this.mShadowPaint.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(android.graphics.Canvas canvas, android.graphics.Paint paint) {
            float width = io.dcloud.feature.weex.adapter.widget.refresh.DCWeexCircleImageView.this.getWidth() / 2;
            float height = io.dcloud.feature.weex.adapter.widget.refresh.DCWeexCircleImageView.this.getHeight() / 2;
            canvas.drawCircle(width, height, (this.mCircleDiameter / 2) + io.dcloud.feature.weex.adapter.widget.refresh.DCWeexCircleImageView.this.mShadowRadius, this.mShadowPaint);
            canvas.drawCircle(width, height, this.mCircleDiameter / 2, paint);
        }
    }
}
