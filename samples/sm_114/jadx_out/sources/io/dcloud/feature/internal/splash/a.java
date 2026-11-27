package io.dcloud.feature.internal.splash;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class a extends android.view.View {
    private static float E = 2.0f;
    android.graphics.Paint A;
    android.graphics.Path B;
    int C;
    android.graphics.PaintFlagsDrawFilter D;
    private android.util.DisplayMetrics a;
    android.graphics.Bitmap b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    int l;
    int m;
    int n;
    int o;
    int p;
    int q;
    int r;
    int s;
    int t;
    int u;
    int v;
    int w;
    int x;
    android.graphics.RectF y;
    android.graphics.RectF z;

    public a(android.content.Context context, boolean z) {
        super(context);
        this.b = null;
        this.A = new android.graphics.Paint();
        this.B = new android.graphics.Path();
        this.C = 0;
        this.D = null;
        if (z) {
            E = 6.0f;
        }
        this.D = new android.graphics.PaintFlagsDrawFilter(0, 3);
    }

    private void b(android.graphics.Canvas canvas) {
        this.A.reset();
        this.A.setAntiAlias(true);
        this.A.setStyle(android.graphics.Paint.Style.STROKE);
        this.A.setStrokeWidth(this.h);
        this.A.setColor(this.w);
        canvas.drawArc(this.z, this.t, this.u, false, this.A);
        int i = (int) (this.u + E);
        this.u = i;
        if (i > 360) {
            this.u = i - 360;
        }
        invalidate();
    }

    private void c(android.graphics.Canvas canvas) {
        this.A.reset();
        android.graphics.Bitmap bitmap = this.b;
        if (bitmap == null || bitmap.isRecycled()) {
            this.A.setColor(-1118482);
            this.A.setAntiAlias(true);
            this.A.setStyle(android.graphics.Paint.Style.FILL);
            android.graphics.RectF rectF = this.y;
            float fWidth = rectF.left + (rectF.width() / 2.0f);
            android.graphics.RectF rectF2 = this.y;
            canvas.drawCircle(fWidth, rectF2.top + (rectF2.height() / 2.0f), this.y.width() / 2.0f, this.A);
            return;
        }
        canvas.save();
        try {
            canvas.clipPath(this.B);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        this.A.setAntiAlias(true);
        canvas.setDrawFilter(this.D);
        canvas.drawBitmap(this.b, (android.graphics.Rect) null, this.y, this.A);
        canvas.restore();
        int i = (this.g * 4) + 3;
        this.A.setStrokeWidth(i);
        this.A.setStyle(android.graphics.Paint.Style.STROKE);
        this.A.setAntiAlias(true);
        this.A.setColor(this.C);
        android.graphics.RectF rectF3 = this.y;
        float fWidth2 = rectF3.left + (rectF3.width() / 2.0f);
        android.graphics.RectF rectF4 = this.y;
        canvas.drawCircle(fWidth2, rectF4.top + (rectF4.height() / 2.0f), ((this.y.width() / 2.0f) + (i / 2)) - (3 / 8), this.A);
    }

    float a(float f) {
        if (this.a == null) {
            this.a = getResources().getDisplayMetrics();
        }
        return android.util.TypedValue.applyDimension(1, f, this.a);
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        c(canvas);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.c, this.d);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        this.C = i;
    }

    public void setBitmap(android.graphics.Bitmap bitmap) {
        android.graphics.Bitmap bitmap2 = this.b;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.b.recycle();
        }
        this.b = bitmap;
    }

    public void a(android.graphics.Bitmap bitmap, int i, int i2, int i3, int i4, int i5) {
        int left = getLeft();
        int top = getTop();
        this.b = bitmap;
        this.c = i;
        this.d = i2;
        this.g = i3;
        int i6 = i3 * 8;
        int i7 = i - i6;
        this.e = i7;
        int i8 = i2 - i6;
        this.f = i8;
        this.l = ((i - i7) / 2) + left;
        this.m = ((i2 - i8) / 2) + top;
        int i9 = this.l;
        int i10 = this.m;
        this.y = new android.graphics.RectF(i9, i10, i9 + this.e, i10 + this.f);
        this.B.reset();
        this.B.addRoundRect(this.y, this.l + (this.e / 2), this.m + (this.f / 2), android.graphics.Path.Direction.CCW);
        int i11 = this.c;
        int i12 = i11 / 2;
        int i13 = this.g;
        this.k = i12 - i13;
        this.w = i5;
        this.x = i4;
        this.i = i12 + left;
        int i14 = this.d;
        this.j = (i14 / 2) + top;
        this.t = 270;
        this.v = 270;
        this.h = i13;
        int i15 = left + i13;
        this.n = i15;
        int i16 = top + i13;
        this.o = i16;
        int i17 = i13 * 2;
        int i18 = i11 - i17;
        this.r = i18;
        int i19 = i14 - i17;
        this.s = i19;
        this.p = i15 + i18;
        this.q = i16 + i19;
        this.z = new android.graphics.RectF(this.n, this.o, this.p, this.q);
    }

    private void a(android.graphics.Canvas canvas) {
        this.A.reset();
        this.A.setStrokeWidth(this.g);
        this.A.setStyle(android.graphics.Paint.Style.STROKE);
        this.A.setAntiAlias(true);
        this.A.setColor(this.x);
        canvas.drawCircle(this.i, this.j, this.k, this.A);
    }
}
