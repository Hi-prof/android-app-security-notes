package io.dcloud.feature.gallery.imageedit.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class IMGColorRadio extends android.widget.RadioButton implements android.animation.ValueAnimator.AnimatorUpdateListener {
    private int a;
    private int b;
    private float c;
    private android.animation.ValueAnimator d;
    private android.graphics.Paint e;

    public IMGColorRadio(android.content.Context context) {
        this(context, null, 0);
    }

    private void a(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, io.dcloud.base.R.styleable.IMGColorRadio);
        this.a = typedArrayObtainStyledAttributes.getColor(io.dcloud.base.R.styleable.IMGColorRadio_image_color, -1);
        this.b = typedArrayObtainStyledAttributes.getColor(io.dcloud.base.R.styleable.IMGColorRadio_image_stroke_color, -1);
        typedArrayObtainStyledAttributes.recycle();
        setButtonDrawable((android.graphics.drawable.Drawable) null);
        this.e.setColor(this.a);
        this.e.setStrokeWidth(5.0f);
    }

    private float b(float f) {
        return f * ((this.c * 0.29999995f) + 0.6f);
    }

    private android.animation.ValueAnimator getAnimator() {
        if (this.d == null) {
            android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            this.d = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(this);
            this.d.setDuration(200L);
            this.d.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
        }
        return this.d;
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        super.draw(canvas);
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        float fMin = java.lang.Math.min(width, height);
        canvas.save();
        this.e.setColor(this.a);
        this.e.setStyle(android.graphics.Paint.Style.FILL);
        canvas.drawCircle(width, height, a(fMin), this.e);
        this.e.setColor(this.b);
        this.e.setStyle(android.graphics.Paint.Style.STROKE);
        canvas.drawCircle(width, height, b(fMin), this.e);
        canvas.restore();
    }

    public int getColor() {
        return this.a;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        this.c = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        boolean z2 = z != isChecked();
        super.setChecked(z);
        if (z2) {
            android.animation.ValueAnimator animator = getAnimator();
            if (z) {
                animator.start();
            } else {
                animator.reverse();
            }
        }
    }

    public void setColor(int i) {
        this.a = i;
        this.e.setColor(i);
    }

    public IMGColorRadio(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.b = -1;
        this.c = 0.0f;
        this.e = new android.graphics.Paint(1);
        a(context, attributeSet, 0);
    }

    private float a(float f) {
        return f * ((this.c * 0.120000005f) + 0.6f);
    }

    public IMGColorRadio(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = -1;
        this.b = -1;
        this.c = 0.0f;
        this.e = new android.graphics.Paint(1);
        a(context, attributeSet, i);
    }
}
