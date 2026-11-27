package io.dcloud.feature.gallery.imageedit.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class IMGStickerView extends android.view.ViewGroup implements io.dcloud.p.m2, android.view.View.OnClickListener {
    private android.view.View a;
    private float b;
    private int c;
    private io.dcloud.p.p2 d;
    private io.dcloud.p.o2 e;
    private android.widget.ImageView f;
    private android.widget.ImageView g;
    private float h;
    private android.graphics.Paint i;
    private android.graphics.Matrix j;
    private android.graphics.RectF k;
    private android.graphics.Rect l;

    public IMGStickerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private android.view.ViewGroup.LayoutParams getAnchorLayoutParams() {
        return new android.view.ViewGroup.LayoutParams(48, 48);
    }

    private android.view.ViewGroup.LayoutParams getContentLayoutParams() {
        return new android.view.ViewGroup.LayoutParams(-2, -2);
    }

    public abstract android.view.View a(android.content.Context context);

    @Override // io.dcloud.p.t2
    public void a(float f) {
        setScale(getScale() * f);
    }

    public void b(android.content.Context context) {
        setBackgroundColor(0);
        android.view.View viewA = a(context);
        this.a = viewA;
        addView(viewA, getContentLayoutParams());
        android.widget.ImageView imageView = new android.widget.ImageView(context);
        this.f = imageView;
        android.widget.ImageView.ScaleType scaleType = android.widget.ImageView.ScaleType.FIT_XY;
        imageView.setScaleType(scaleType);
        this.f.setImageResource(io.dcloud.base.R.mipmap.image_ic_delete);
        addView(this.f, getAnchorLayoutParams());
        this.f.setOnClickListener(this);
        android.widget.ImageView imageView2 = new android.widget.ImageView(context);
        this.g = imageView2;
        imageView2.setScaleType(scaleType);
        this.g.setImageResource(io.dcloud.base.R.mipmap.image_ic_adjust);
        addView(this.g, getAnchorLayoutParams());
        new io.dcloud.p.n2(this, this.g);
        this.e = new io.dcloud.p.o2(this);
        this.d = new io.dcloud.p.p2(this);
    }

    public void c() {
    }

    public void d() {
        this.e.c();
    }

    @Override // io.dcloud.p.q2
    public boolean dismiss() {
        return this.e.dismiss();
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        android.graphics.Canvas canvas2;
        if (a()) {
            canvas2 = canvas;
            canvas2.drawRect(24.0f, 24.0f, getWidth() - 24, getHeight() - 24, this.i);
        } else {
            canvas2 = canvas;
        }
        super.draw(canvas2);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(android.graphics.Canvas canvas, android.view.View view, long j) {
        return a() && super.drawChild(canvas, view, j);
    }

    @Override // io.dcloud.p.q2
    public android.graphics.RectF getFrame() {
        return this.e.getFrame();
    }

    @Override // io.dcloud.p.t2
    public float getScale() {
        return this.b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (view == this.f) {
            d();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (a() || motionEvent.getAction() != 0) {
            return a() && super.onInterceptTouchEvent(motionEvent);
        }
        this.c = 0;
        b();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.k.set(i, i2, i3, i4);
        if (getChildCount() == 0) {
            return;
        }
        android.widget.ImageView imageView = this.f;
        imageView.layout(0, 0, imageView.getMeasuredWidth(), this.f.getMeasuredHeight());
        android.widget.ImageView imageView2 = this.g;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        imageView2.layout(i5 - imageView2.getMeasuredWidth(), i6 - this.g.getMeasuredHeight(), i5, i6);
        int i7 = i5 >> 1;
        int i8 = i6 >> 1;
        int measuredWidth = this.a.getMeasuredWidth() >> 1;
        int measuredHeight = this.a.getMeasuredHeight() >> 1;
        this.a.layout(i7 - measuredWidth, i8 - measuredHeight, i7 + measuredWidth, i8 + measuredHeight);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int iRound = 0;
        int iCombineMeasuredStates = 0;
        int iRound2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            android.view.View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                childAt.measure(i, i2);
                iRound2 = java.lang.Math.round(java.lang.Math.max(iRound2, childAt.getMeasuredWidth() * childAt.getScaleX()));
                iRound = java.lang.Math.round(java.lang.Math.max(iRound, childAt.getMeasuredHeight() * childAt.getScaleY()));
                iCombineMeasuredStates = android.view.ViewGroup.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        setMeasuredDimension(android.view.ViewGroup.resolveSizeAndState(java.lang.Math.max(iRound2, getSuggestedMinimumWidth()), i, iCombineMeasuredStates), android.view.ViewGroup.resolveSizeAndState(java.lang.Math.max(iRound, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates << 16));
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        boolean zA = this.d.a(this, motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.c++;
        } else if (actionMasked == 1 && this.c > 1 && motionEvent.getEventTime() - motionEvent.getDownTime() < android.view.ViewConfiguration.getTapTimeout()) {
            c();
            return true;
        }
        return super.onTouchEvent(motionEvent) | zA;
    }

    public void setScale(float f) {
        this.b = f;
        this.a.setScaleX(f);
        this.a.setScaleY(this.b);
        float left = (getLeft() + getRight()) >> 1;
        float top = (getTop() + getBottom()) >> 1;
        this.k.set(left, top, left, top);
        this.k.inset(-(this.a.getMeasuredWidth() >> 1), -(this.a.getMeasuredHeight() >> 1));
        android.graphics.Matrix matrix = this.j;
        float f2 = this.b;
        matrix.setScale(f2, f2, this.k.centerX(), this.k.centerY());
        this.j.mapRect(this.k);
        this.k.round(this.l);
        android.graphics.Rect rect = this.l;
        layout(rect.left, rect.top, rect.right, rect.bottom);
    }

    public IMGStickerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 1.0f;
        this.c = 0;
        this.h = 4.0f;
        this.j = new android.graphics.Matrix();
        this.k = new android.graphics.RectF();
        this.l = new android.graphics.Rect();
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.i = paint;
        paint.setColor(-1);
        this.i.setStyle(android.graphics.Paint.Style.STROKE);
        this.i.setStrokeWidth(3.0f);
        b(context);
    }

    @Override // io.dcloud.p.q2
    public boolean a() {
        return this.e.a();
    }

    @Override // io.dcloud.p.q2
    public void a(android.graphics.Canvas canvas) {
        canvas.translate(this.a.getX(), this.a.getY());
        this.a.draw(canvas);
    }

    @Override // io.dcloud.p.q2
    public void a(io.dcloud.p.q2.a aVar) {
        this.e.a(aVar);
    }

    @Override // io.dcloud.p.q2
    public boolean b() {
        return this.e.b();
    }

    @Override // io.dcloud.p.q2
    public void b(io.dcloud.p.q2.a aVar) {
        this.e.b(aVar);
    }
}
