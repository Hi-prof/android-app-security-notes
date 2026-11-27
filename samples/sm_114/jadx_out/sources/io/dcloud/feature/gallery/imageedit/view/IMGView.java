package io.dcloud.feature.gallery.imageedit.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class IMGView extends android.widget.FrameLayout implements java.lang.Runnable, android.view.ScaleGestureDetector.OnScaleGestureListener, android.animation.ValueAnimator.AnimatorUpdateListener, io.dcloud.p.q2.a, android.animation.Animator.AnimatorListener {
    private io.dcloud.p.k2 a;
    private io.dcloud.p.j2 b;
    private android.view.GestureDetector c;
    private android.view.ScaleGestureDetector d;
    private io.dcloud.p.h2 e;
    private io.dcloud.feature.gallery.imageedit.view.IMGView.c f;
    private int g;
    private android.graphics.Paint h;
    private android.graphics.Paint i;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements io.dcloud.p.j2.c {
        a() {
        }

        @Override // io.dcloud.p.j2.c
        public void a() {
            io.dcloud.feature.gallery.imageedit.view.IMGView.this.e();
            io.dcloud.feature.gallery.imageedit.view.IMGView.this.b.b(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class b extends android.view.GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(android.view.MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
            return io.dcloud.feature.gallery.imageedit.view.IMGView.this.a(f, f2);
        }

        /* synthetic */ b(io.dcloud.feature.gallery.imageedit.view.IMGView iMGView, io.dcloud.feature.gallery.imageedit.view.IMGView.a aVar) {
            this();
        }
    }

    public IMGView(android.content.Context context) {
        this(context, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        invalidate();
        j();
        a(this.b.c(getScrollX(), getScrollY()), this.b.b(getScrollX(), getScrollY()));
    }

    private boolean f(android.view.MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            return b(motionEvent);
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                return c(motionEvent);
            }
            if (actionMasked != 3) {
                return false;
            }
        }
        return this.f.b(motionEvent.getPointerId(0)) && f();
    }

    private void j() {
        io.dcloud.p.h2 h2Var = this.e;
        if (h2Var != null) {
            h2Var.cancel();
        }
    }

    public void c() {
        if (d()) {
            return;
        }
        this.b.a(-90);
        e();
    }

    boolean d() {
        io.dcloud.p.h2 h2Var = this.e;
        return h2Var != null && h2Var.isRunning();
    }

    boolean g() {
        android.util.Log.d("IMGView", "onSteady: isHoming=" + d());
        if (d()) {
            return false;
        }
        this.b.e(getScrollX(), getScrollY());
        e();
        return true;
    }

    public io.dcloud.p.k2 getMode() {
        return this.b.c();
    }

    public void h() {
        this.b.s();
        e();
    }

    public android.graphics.Bitmap i() {
        this.b.t();
        float fE = 1.0f / this.b.e();
        android.graphics.RectF rectF = new android.graphics.RectF(this.b.b());
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setRotate(this.b.d(), rectF.centerX(), rectF.centerY());
        matrix.mapRect(rectF);
        matrix.setScale(fE, fE, rectF.left, rectF.top);
        matrix.mapRect(rectF);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(java.lang.Math.round(rectF.width()), java.lang.Math.round(rectF.height()), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        canvas.translate(-rectF.left, -rectF.top);
        canvas.scale(fE, fE, rectF.left, rectF.top);
        a(canvas);
        return bitmapCreateBitmap;
    }

    public void k() {
        this.b.w();
        invalidate();
    }

    public void l() {
        this.b.x();
        invalidate();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(android.animation.Animator animator) {
        android.util.Log.d("IMGView", "onAnimationCancel");
        this.b.a(this.e.a());
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(android.animation.Animator animator) {
        android.util.Log.d("IMGView", "onAnimationEnd");
        if (this.b.a(getScrollX(), getScrollY(), this.e.a())) {
            a(this.b.a(getScrollX(), getScrollY()));
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(android.animation.Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(android.animation.Animator animator) {
        android.util.Log.d("IMGView", "onAnimationStart");
        this.b.b(this.e.a());
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        this.b.a(valueAnimator.getAnimatedFraction());
        a((io.dcloud.p.g2) valueAnimator.getAnimatedValue());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this);
        this.b.r();
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        a(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            return a(motionEvent) || super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.b.h(i3 - i, i4 - i2);
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(android.view.ScaleGestureDetector scaleGestureDetector) {
        if (this.g <= 1) {
            return false;
        }
        this.b.a(scaleGestureDetector.getScaleFactor(), getScrollX() + scaleGestureDetector.getFocusX(), getScrollY() + scaleGestureDetector.getFocusY());
        invalidate();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(android.view.ScaleGestureDetector scaleGestureDetector) {
        if (this.g <= 1) {
            return false;
        }
        this.b.p();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(android.view.ScaleGestureDetector scaleGestureDetector) {
        this.b.q();
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            removeCallbacks(this);
        } else if (actionMasked == 1 || actionMasked == 3) {
            postDelayed(this, 1200L);
        }
        return d(motionEvent);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (g()) {
            return;
        }
        postDelayed(this, 500L);
    }

    public void setDoodleTouchListener(io.dcloud.p.j2.b bVar) {
        this.b.a(bVar);
    }

    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        this.b.a(bitmap);
        invalidate();
    }

    public void setMode(io.dcloud.p.k2 k2Var) {
        this.a = this.b.c();
        this.b.a(k2Var);
        this.f.a(k2Var);
        if (this.b.j()) {
            e();
        } else {
            this.b.a(new io.dcloud.feature.gallery.imageedit.view.IMGView.a());
        }
    }

    public void setPenColor(int i) {
        this.f.a(i);
    }

    public IMGView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void b() {
        this.b.a(getScrollX(), getScrollY());
        setMode(this.a);
        e();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class c extends io.dcloud.p.l2 {
        private int e;

        private c() {
            this.e = Integer.MIN_VALUE;
        }

        void a(float f, float f2) {
            this.a.lineTo(f, f2);
        }

        void b(float f, float f2) {
            this.a.reset();
            this.a.moveTo(f, f2);
            this.e = Integer.MIN_VALUE;
        }

        void c(int i) {
            this.e = i;
        }

        boolean e() {
            return this.a.isEmpty();
        }

        void f() {
            this.a.reset();
            this.e = Integer.MIN_VALUE;
        }

        io.dcloud.p.l2 g() {
            if (b() == io.dcloud.p.k2.DOODLE) {
                a(14.0f);
            } else {
                a(72.0f);
            }
            return new io.dcloud.p.l2(new android.graphics.Path(this.a), b(), a(), d());
        }

        /* synthetic */ c(io.dcloud.feature.gallery.imageedit.view.IMGView.a aVar) {
            this();
        }

        boolean b(int i) {
            return this.e == i;
        }
    }

    public IMGView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = io.dcloud.p.k2.NONE;
        this.b = new io.dcloud.p.j2();
        this.f = new io.dcloud.feature.gallery.imageedit.view.IMGView.c(null);
        this.g = 0;
        this.h = new android.graphics.Paint(1);
        this.i = new android.graphics.Paint(1);
        android.graphics.Paint paint = this.h;
        android.graphics.Paint.Style style = android.graphics.Paint.Style.STROKE;
        paint.setStyle(style);
        this.h.setStrokeWidth(14.0f);
        this.h.setColor(-65536);
        this.h.setPathEffect(new android.graphics.CornerPathEffect(14.0f));
        android.graphics.Paint paint2 = this.h;
        android.graphics.Paint.Cap cap = android.graphics.Paint.Cap.ROUND;
        paint2.setStrokeCap(cap);
        android.graphics.Paint paint3 = this.h;
        android.graphics.Paint.Join join = android.graphics.Paint.Join.ROUND;
        paint3.setStrokeJoin(join);
        this.i.setStyle(style);
        this.i.setStrokeWidth(72.0f);
        this.i.setColor(-16777216);
        this.i.setPathEffect(new android.graphics.CornerPathEffect(72.0f));
        this.i.setStrokeCap(cap);
        this.i.setStrokeJoin(join);
        a(context);
        this.b.b(io.dcloud.p.p4.a(getContext()));
    }

    private void a(android.content.Context context) {
        this.f.a(this.b.c());
        android.view.GestureDetector gestureDetector = new android.view.GestureDetector(context, new io.dcloud.feature.gallery.imageedit.view.IMGView.b(this, null));
        this.c = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.d = new android.view.ScaleGestureDetector(context, this);
    }

    boolean d(android.view.MotionEvent motionEvent) {
        boolean zE;
        if (d()) {
            return false;
        }
        this.g = motionEvent.getPointerCount();
        boolean zOnTouchEvent = this.d.onTouchEvent(motionEvent);
        io.dcloud.p.k2 k2VarC = this.b.c();
        if (k2VarC != io.dcloud.p.k2.NONE && k2VarC != io.dcloud.p.k2.CLIP) {
            if (this.g > 1) {
                f();
                zE = e(motionEvent);
            } else {
                zE = f(motionEvent);
            }
        } else {
            zE = e(motionEvent);
        }
        boolean z = zOnTouchEvent | zE;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.b.f(motionEvent.getX(), motionEvent.getY());
            if (this.b.c() == io.dcloud.p.k2.CLIP) {
                invalidate();
            }
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.b.g(getScrollX(), getScrollY());
            e();
            return z;
        }
        return z;
    }

    private boolean c(android.view.MotionEvent motionEvent) {
        if (!this.f.b(motionEvent.getPointerId(0))) {
            return false;
        }
        this.f.a(motionEvent.getX(), motionEvent.getY());
        invalidate();
        return true;
    }

    public void b(int i, int i2) {
        io.dcloud.p.j2 j2Var = this.b;
        if (j2Var != null) {
            j2Var.a(i, i2);
        }
    }

    private boolean e(android.view.MotionEvent motionEvent) {
        return this.c.onTouchEvent(motionEvent);
    }

    private void a(io.dcloud.p.g2 g2Var, io.dcloud.p.g2 g2Var2) {
        if (this.e == null) {
            io.dcloud.p.h2 h2Var = new io.dcloud.p.h2();
            this.e = h2Var;
            h2Var.addUpdateListener(this);
            this.e.addListener(this);
        }
        this.e.a(g2Var, g2Var2);
        this.e.start();
    }

    private boolean b(android.view.MotionEvent motionEvent) {
        this.f.b(motionEvent.getX(), motionEvent.getY());
        this.f.c(motionEvent.getPointerId(0));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.p.q2.a
    public void c(android.view.View view) {
        this.b.d((io.dcloud.p.m2) view);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.p.q2.a
    public boolean b(android.view.View view) {
        io.dcloud.p.j2 j2Var = this.b;
        if (j2Var != null) {
            j2Var.e((io.dcloud.p.m2) view);
        }
        ((io.dcloud.p.q2) view).b(this);
        android.view.ViewParent parent = view.getParent();
        if (parent == null) {
            return true;
        }
        ((android.view.ViewGroup) parent).removeView(view);
        return true;
    }

    private boolean f() {
        if (this.f.e()) {
            return false;
        }
        this.b.a(this.f.g(), getScrollX(), getScrollY());
        this.f.f();
        invalidate();
        return true;
    }

    public void a() {
        this.b.u();
        setMode(this.a);
    }

    private void a(android.graphics.Canvas canvas) {
        canvas.save();
        android.graphics.RectF rectFB = this.b.b();
        canvas.rotate(this.b.d(), rectFB.centerX(), rectFB.centerY());
        this.b.b(canvas);
        if (!this.b.k() || (this.b.c() == io.dcloud.p.k2.MOSAIC && !this.f.e())) {
            int iC = this.b.c(canvas);
            if (this.b.c() == io.dcloud.p.k2.MOSAIC && !this.f.e()) {
                this.h.setStrokeWidth(72.0f);
                canvas.save();
                android.graphics.RectF rectFB2 = this.b.b();
                canvas.rotate(-this.b.d(), rectFB2.centerX(), rectFB2.centerY());
                canvas.translate(getScrollX(), getScrollY());
                canvas.drawPath(this.f.c(), this.h);
                canvas.restore();
            }
            this.b.a(canvas, iC);
        }
        this.b.a(canvas);
        if (this.b.c() == io.dcloud.p.k2.DOODLE && !this.f.e()) {
            this.h.setColor(this.f.a());
            this.h.setStrokeWidth(14.0f);
            canvas.save();
            android.graphics.RectF rectFB3 = this.b.b();
            canvas.rotate(-this.b.d(), rectFB3.centerX(), rectFB3.centerY());
            canvas.translate(getScrollX(), getScrollY());
            canvas.drawPath(this.f.c(), this.h);
            canvas.restore();
        }
        if (this.b.i()) {
            this.b.f(canvas);
        }
        this.b.d(canvas);
        canvas.restore();
        if (!this.b.i()) {
            this.b.e(canvas);
            this.b.f(canvas);
        }
        if (this.b.c() == io.dcloud.p.k2.CLIP) {
            canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            this.b.a(canvas, getScrollX(), getScrollY());
            canvas.restore();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(android.view.View view, android.widget.FrameLayout.LayoutParams layoutParams) {
        if (view != 0) {
            addView(view, layoutParams);
            ((io.dcloud.p.q2) view).a(this);
            this.b.a((io.dcloud.p.m2) view);
        }
    }

    public void a(io.dcloud.p.r2 r2Var) {
        io.dcloud.feature.gallery.imageedit.view.IMGStickerTextView iMGStickerTextView = new io.dcloud.feature.gallery.imageedit.view.IMGStickerTextView(getContext());
        iMGStickerTextView.setText(r2Var);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        iMGStickerTextView.setX(getScrollX());
        iMGStickerTextView.setY(getScrollY());
        a(iMGStickerTextView, layoutParams);
    }

    boolean a(android.view.MotionEvent motionEvent) {
        if (!d()) {
            return this.b.c() == io.dcloud.p.k2.CLIP;
        }
        j();
        return true;
    }

    private void a(io.dcloud.p.g2 g2Var) {
        this.b.d(g2Var.c);
        this.b.c(g2Var.d);
        if (a(java.lang.Math.round(g2Var.a), java.lang.Math.round(g2Var.b))) {
            return;
        }
        invalidate();
    }

    private boolean a(int i, int i2) {
        if (getScrollX() == i && getScrollY() == i2) {
            return false;
        }
        scrollTo(i, i2);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.p.q2.a
    public void a(android.view.View view) {
        this.b.f((io.dcloud.p.m2) view);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(float f, float f2) {
        io.dcloud.p.g2 g2VarA = this.b.a(getScrollX(), getScrollY(), -f, -f2);
        if (g2VarA != null) {
            a(g2VarA);
            return true;
        }
        return a(getScrollX() + java.lang.Math.round(f), getScrollY() + java.lang.Math.round(f2));
    }
}
