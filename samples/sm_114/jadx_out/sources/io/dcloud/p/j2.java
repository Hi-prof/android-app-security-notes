package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class j2 {
    private static final android.graphics.Bitmap F = android.graphics.Bitmap.createBitmap(100, 100, android.graphics.Bitmap.Config.ARGB_8888);
    private android.graphics.Paint A;
    private android.graphics.Paint B;
    private android.graphics.Paint C;
    private android.graphics.Matrix D;
    private java.util.List E;
    private android.graphics.Bitmap a;
    private android.graphics.Bitmap b;
    private io.dcloud.p.j2.b c;
    private io.dcloud.p.c2.a m;
    private io.dcloud.p.k2 r;
    private boolean s;
    private android.graphics.RectF t;
    private boolean u;
    private boolean v;
    private io.dcloud.p.m2 w;
    private java.util.List x;
    private java.util.List y;
    private java.util.List z;
    private android.graphics.RectF d = new android.graphics.RectF();
    private android.graphics.RectF e = new android.graphics.RectF();
    private android.graphics.RectF f = new android.graphics.RectF();
    private android.graphics.RectF g = new android.graphics.RectF();
    private float h = 0.0f;
    private float i = 0.0f;
    private float j = 0.0f;
    private boolean k = false;
    private boolean l = false;
    private boolean n = true;
    private android.graphics.Path o = new android.graphics.Path();
    private io.dcloud.p.d2 p = new io.dcloud.p.d2();
    private boolean q = false;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[io.dcloud.p.k2.values().length];
            a = iArr;
            try {
                iArr[io.dcloud.p.k2.DOODLE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[io.dcloud.p.k2.MOSAIC.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface b {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface c {
        void a();
    }

    public j2() {
        io.dcloud.p.k2 k2Var = io.dcloud.p.k2.NONE;
        this.r = k2Var;
        io.dcloud.p.k2 k2Var2 = io.dcloud.p.k2.CLIP;
        this.s = k2Var == k2Var2;
        this.t = new android.graphics.RectF();
        this.u = false;
        this.v = false;
        this.x = new java.util.ArrayList();
        this.y = new java.util.ArrayList();
        this.z = new java.util.ArrayList();
        this.D = new android.graphics.Matrix();
        this.o.setFillType(android.graphics.Path.FillType.WINDING);
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.A = paint;
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        this.A.setStrokeWidth(14.0f);
        this.A.setColor(-65536);
        this.A.setPathEffect(new android.graphics.CornerPathEffect(14.0f));
        this.A.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.A.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        this.E = new java.util.ArrayList();
        this.a = F;
        if (this.r == k2Var2) {
            g();
        }
    }

    private void b(float f) {
        this.D.setRotate(f, this.e.centerX(), this.e.centerY());
        for (io.dcloud.p.m2 m2Var : this.x) {
            this.D.mapRect(m2Var.getFrame());
            m2Var.setRotation(m2Var.getRotation() + f);
            m2Var.setX(m2Var.getFrame().centerX() - m2Var.getPivotX());
            m2Var.setY(m2Var.getFrame().centerY() - m2Var.getPivotY());
        }
    }

    private void g() {
        if (this.C == null) {
            android.graphics.Paint paint = new android.graphics.Paint(1);
            this.C = paint;
            paint.setColor(-872415232);
            this.C.setStyle(android.graphics.Paint.Style.FILL);
        }
    }

    private void l() {
        android.graphics.Bitmap bitmap;
        if (this.b == null && (bitmap = this.a) != null && this.r == io.dcloud.p.k2.MOSAIC) {
            int iRound = java.lang.Math.round(bitmap.getWidth() / 64.0f);
            int iRound2 = java.lang.Math.round(this.a.getHeight() / 64.0f);
            int iMax = java.lang.Math.max(iRound, 8);
            int iMax2 = java.lang.Math.max(iRound2, 8);
            if (this.B == null) {
                android.graphics.Paint paint = new android.graphics.Paint(1);
                this.B = paint;
                paint.setFilterBitmap(false);
                this.B.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
            }
            this.b = android.graphics.Bitmap.createScaledBitmap(this.a, iMax, iMax2, false);
        }
    }

    private void n() {
        this.u = false;
        h(this.t.width(), this.t.height());
        if (this.r == io.dcloud.p.k2.CLIP) {
            this.p.a(this.e, f());
        }
    }

    private void o() {
        if (this.r == io.dcloud.p.k2.CLIP) {
            this.p.a(this.e, f());
        }
    }

    private void v() {
        if (this.e.isEmpty()) {
            return;
        }
        float fMin = java.lang.Math.min(this.t.width() / this.e.width(), this.t.height() / this.e.height());
        this.D.setScale(fMin, fMin, this.e.centerX(), this.e.centerY());
        this.D.postTranslate(this.t.centerX() - this.e.centerX(), this.t.centerY() - this.e.centerY());
        this.D.mapRect(this.d);
        this.D.mapRect(this.e);
    }

    public void a(android.graphics.Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.a = bitmap;
        android.graphics.Bitmap bitmap2 = this.b;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        this.b = null;
        l();
        n();
    }

    public io.dcloud.p.k2 c() {
        return this.r;
    }

    public void d(io.dcloud.p.m2 m2Var) {
        b(m2Var);
    }

    public void e(io.dcloud.p.m2 m2Var) {
        if (this.w == m2Var) {
            this.w = null;
        } else {
            this.x.remove(m2Var);
        }
    }

    public void f(io.dcloud.p.m2 m2Var) {
        if (this.w != m2Var) {
            c(m2Var);
        }
    }

    protected void finalize() throws java.lang.Throwable {
        super.finalize();
        android.graphics.Bitmap bitmap = F;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    public boolean h() {
        return this.y.isEmpty();
    }

    public boolean i() {
        return this.s;
    }

    public boolean j() {
        return this.v;
    }

    public boolean k() {
        return this.z.isEmpty();
    }

    public boolean m() {
        return this.p.b();
    }

    public void p() {
    }

    public void q() {
    }

    public void r() {
        android.graphics.Bitmap bitmap = this.a;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.a.recycle();
    }

    public void s() {
        e(d() - (d() % 360.0f));
        this.e.set(this.d);
        this.p.a(this.e, f());
    }

    public void t() {
        b(this.w);
    }

    public void u() {
        this.D.setScale(e(), e());
        android.graphics.Matrix matrix = this.D;
        android.graphics.RectF rectF = this.d;
        matrix.postTranslate(rectF.left, rectF.top);
        this.D.mapRect(this.e, this.g);
        float fD = d() % 360.0f;
        if (java.lang.Math.abs(fD) >= 180.0f) {
            fD = 360.0f - java.lang.Math.abs(fD);
        }
        c(fD);
        e(this.h);
        this.k = true;
    }

    public void w() {
        if (this.y.isEmpty()) {
            return;
        }
        java.util.List list = this.y;
        list.remove(list.size() - 1);
    }

    public void x() {
        if (this.z.isEmpty()) {
            return;
        }
        java.util.List list = this.z;
        list.remove(list.size() - 1);
    }

    private void d(float f, float f2) {
        this.d.set(0.0f, 0.0f, this.a.getWidth(), this.a.getHeight());
        this.e.set(this.d);
        this.p.d(f, f2);
        if (this.e.isEmpty()) {
            return;
        }
        v();
        this.u = true;
        o();
    }

    public io.dcloud.p.g2 c(float f, float f2) {
        return new io.dcloud.p.g2(f, f2, e(), d());
    }

    public void h(float f, float f2) {
        if (f == 0.0f || f2 == 0.0f) {
            return;
        }
        this.t.set(0.0f, 0.0f, f, f2);
        if (this.u) {
            this.D.setTranslate(this.t.centerX() - this.e.centerX(), this.t.centerY() - this.e.centerY());
            this.D.mapRect(this.d);
            this.D.mapRect(this.e);
        } else {
            d(f, f2);
        }
        this.p.d(f, f2);
        this.v = true;
        a();
    }

    private void c(io.dcloud.p.m2 m2Var) {
        if (m2Var == null) {
            return;
        }
        b(this.w);
        if (m2Var.a()) {
            this.w = m2Var;
            this.x.remove(m2Var);
        } else {
            m2Var.b();
        }
    }

    public void f(android.graphics.Canvas canvas) {
        if (this.x.isEmpty()) {
            return;
        }
        canvas.save();
        for (io.dcloud.p.m2 m2Var : this.x) {
            if (!m2Var.a()) {
                float x = m2Var.getX() + m2Var.getPivotX();
                float y = m2Var.getY() + m2Var.getPivotY();
                canvas.save();
                this.D.setTranslate(m2Var.getX(), m2Var.getY());
                this.D.postScale(m2Var.getScale(), m2Var.getScale(), x, y);
                this.D.postRotate(m2Var.getRotation(), x, y);
                canvas.concat(this.D);
                m2Var.a(canvas);
                canvas.restore();
            }
        }
        canvas.restore();
    }

    public void e(android.graphics.Canvas canvas) {
        this.D.setRotate(d(), this.e.centerX(), this.e.centerY());
        this.D.mapRect(this.f, this.p.c() ? this.d : this.e);
        canvas.clipRect(this.f);
    }

    public void g(float f, float f2) {
        io.dcloud.p.j2.b bVar;
        io.dcloud.p.k2 k2Var = this.r;
        if ((k2Var == io.dcloud.p.k2.DOODLE || k2Var == io.dcloud.p.k2.MOSAIC) && (bVar = this.c) != null) {
            bVar.a();
        }
        if (this.m != null) {
            this.m = null;
        }
    }

    public android.graphics.RectF b() {
        return this.e;
    }

    public io.dcloud.p.g2 b(float f, float f2) {
        io.dcloud.p.g2 g2Var = new io.dcloud.p.g2(f, f2, e(), f());
        if (this.r == io.dcloud.p.k2.CLIP) {
            android.graphics.RectF rectF = new android.graphics.RectF(this.p.a());
            rectF.offset(f, f2);
            if (this.p.f()) {
                android.graphics.RectF rectF2 = new android.graphics.RectF();
                this.D.setRotate(f(), this.e.centerX(), this.e.centerY());
                this.D.mapRect(rectF2, this.e);
                g2Var.a(io.dcloud.p.s2.b(rectF, rectF2));
                return g2Var;
            }
            android.graphics.RectF rectF3 = new android.graphics.RectF();
            if (this.p.d()) {
                this.D.setRotate(f() - d(), this.e.centerX(), this.e.centerY());
                this.D.mapRect(rectF3, this.p.b(f, f2));
                g2Var.a(io.dcloud.p.s2.b(rectF, rectF3, this.e.centerX(), this.e.centerY()));
                return g2Var;
            }
            this.D.setRotate(f(), this.e.centerX(), this.e.centerY());
            this.D.mapRect(rectF3, this.d);
            g2Var.a(io.dcloud.p.s2.a(rectF, rectF3, this.e.centerX(), this.e.centerY()));
            return g2Var;
        }
        android.graphics.RectF rectF4 = new android.graphics.RectF();
        this.D.setRotate(f(), this.e.centerX(), this.e.centerY());
        this.D.mapRect(rectF4, this.e);
        android.graphics.RectF rectF5 = new android.graphics.RectF(this.t);
        rectF5.offset(f, f2);
        g2Var.a(io.dcloud.p.s2.a(rectF5, rectF4, this.k));
        this.k = false;
        return g2Var;
    }

    public void e(float f, float f2) {
        this.n = true;
        m();
        this.p.d(true);
    }

    public int c(android.graphics.Canvas canvas) {
        int iSaveLayer = canvas.saveLayer(this.d, null, 31);
        if (!k()) {
            canvas.save();
            float fE = e();
            android.graphics.RectF rectF = this.d;
            canvas.translate(rectF.left, rectF.top);
            canvas.scale(fE, fE);
            java.util.Iterator it = this.z.iterator();
            while (it.hasNext()) {
                ((io.dcloud.p.l2) it.next()).b(canvas, this.A);
            }
            canvas.restore();
        }
        return iSaveLayer;
    }

    public void e(float f) {
        this.j = f;
    }

    public float e() {
        return (this.d.width() * 1.0f) / this.a.getWidth();
    }

    public void d(android.graphics.Canvas canvas) {
        if (this.r == io.dcloud.p.k2.CLIP && this.n) {
            this.o.reset();
            android.graphics.Path path = this.o;
            android.graphics.RectF rectF = this.d;
            path.addRect(rectF.left - 2.0f, rectF.top - 2.0f, rectF.right + 2.0f, rectF.bottom + 2.0f, android.graphics.Path.Direction.CW);
            this.o.addRect(this.e, android.graphics.Path.Direction.CCW);
            canvas.drawPath(this.o, this.C);
        }
    }

    public void a(io.dcloud.p.k2 k2Var) {
        if (this.r == k2Var) {
            return;
        }
        b(this.w);
        io.dcloud.p.k2 k2Var2 = io.dcloud.p.k2.CLIP;
        if (k2Var == k2Var2) {
            c(true);
        }
        this.r = k2Var;
        if (k2Var == k2Var2) {
            g();
            this.h = d();
            this.g.set(this.e);
            float fE = 1.0f / e();
            android.graphics.Matrix matrix = this.D;
            android.graphics.RectF rectF = this.d;
            matrix.setTranslate(-rectF.left, -rectF.top);
            this.D.postScale(fE, fE);
            this.D.mapRect(this.g);
            this.p.a(this.e, f());
            return;
        }
        if (k2Var == io.dcloud.p.k2.MOSAIC) {
            l();
        }
        this.p.a(false);
    }

    public void c(float f) {
        this.i = f;
    }

    public float d() {
        return this.i;
    }

    public void f(float f, float f2) {
        io.dcloud.p.j2.b bVar;
        this.n = false;
        b(this.w);
        io.dcloud.p.k2 k2Var = this.r;
        if (k2Var == io.dcloud.p.k2.CLIP) {
            this.m = this.p.a(f, f2);
            this.p.d(false);
        } else if ((k2Var == io.dcloud.p.k2.DOODLE || k2Var == io.dcloud.p.k2.MOSAIC) && (bVar = this.c) != null) {
            bVar.b();
        }
    }

    private void c(boolean z) {
        if (z != this.s) {
            b(z ? -d() : f());
            this.s = z;
        }
    }

    public void d(float f) {
        b(f, this.e.centerX(), this.e.centerY());
    }

    public float f() {
        return this.j;
    }

    public io.dcloud.p.g2 a(float f, float f2) {
        android.graphics.RectF rectFB = this.p.b(f, f2);
        this.D.setRotate(-d(), this.e.centerX(), this.e.centerY());
        this.D.mapRect(this.e, rectFB);
        return new io.dcloud.p.g2(f + (this.e.centerX() - rectFB.centerX()), f2 + (this.e.centerY() - rectFB.centerY()), e(), d());
    }

    private void b(io.dcloud.p.m2 m2Var) {
        if (m2Var == null) {
            return;
        }
        if (!m2Var.a()) {
            if (!this.x.contains(m2Var)) {
                this.x.add(m2Var);
            }
            if (this.w == m2Var) {
                this.w = null;
                return;
            }
            return;
        }
        m2Var.dismiss();
    }

    public void a(io.dcloud.p.m2 m2Var) {
        if (m2Var != null) {
            c(m2Var);
        }
    }

    public void a(io.dcloud.p.l2 l2Var, float f, float f2) {
        if (l2Var == null) {
            return;
        }
        float fE = 1.0f / e();
        this.D.setTranslate(f, f2);
        this.D.postRotate(-d(), this.e.centerX(), this.e.centerY());
        android.graphics.Matrix matrix = this.D;
        android.graphics.RectF rectF = this.d;
        matrix.postTranslate(-rectF.left, -rectF.top);
        this.D.postScale(fE, fE);
        l2Var.a(this.D);
        int i = io.dcloud.p.j2.a.a[l2Var.b().ordinal()];
        if (i == 1) {
            l2Var.a(l2Var.d() * fE);
            this.y.add(l2Var);
        } else {
            if (i != 2) {
                return;
            }
            l2Var.a(l2Var.d() * fE);
            this.z.add(l2Var);
        }
    }

    public void b(io.dcloud.p.j2.c cVar) {
        java.util.List list = this.E;
        if (list != null) {
            list.remove(cVar);
        }
    }

    public void b(android.graphics.Canvas canvas) {
        canvas.clipRect(this.p.c() ? this.d : this.e);
        canvas.drawBitmap(this.a, (android.graphics.Rect) null, this.d, (android.graphics.Paint) null);
    }

    public void b(float f, float f2, float f3) {
        a(f / e(), f2, f3);
    }

    public void a(io.dcloud.p.j2.c cVar) {
        if (this.E == null) {
            this.E = new java.util.ArrayList();
        }
        this.E.add(cVar);
    }

    public void b(boolean z) {
        this.l = false;
        this.q = true;
    }

    public void b(int i) {
        this.p.a(i);
    }

    private void a() {
        java.util.List<io.dcloud.p.j2.c> list = this.E;
        if (list != null) {
            for (io.dcloud.p.j2.c cVar : list) {
                if (cVar != null) {
                    cVar.a();
                }
            }
        }
    }

    public void a(android.graphics.Canvas canvas, int i) {
        canvas.drawBitmap(this.b, (android.graphics.Rect) null, this.d, this.B);
        canvas.restoreToCount(i);
    }

    public void a(android.graphics.Canvas canvas) {
        if (h()) {
            return;
        }
        canvas.save();
        float fE = e();
        android.graphics.RectF rectF = this.d;
        canvas.translate(rectF.left, rectF.top);
        canvas.scale(fE, fE);
        java.util.Iterator it = this.y.iterator();
        while (it.hasNext()) {
            ((io.dcloud.p.l2) it.next()).a(canvas, this.A);
        }
        canvas.restore();
    }

    public void a(android.graphics.Canvas canvas, float f, float f2) {
        if (this.r == io.dcloud.p.k2.CLIP) {
            this.p.a(canvas);
        }
    }

    public io.dcloud.p.g2 a(float f, float f2, float f3, float f4) {
        if (this.r != io.dcloud.p.k2.CLIP) {
            return null;
        }
        this.p.d(false);
        io.dcloud.p.c2.a aVar = this.m;
        if (aVar == null) {
            return null;
        }
        this.p.a(aVar, f3, f4);
        android.graphics.RectF rectF = new android.graphics.RectF();
        this.D.setRotate(d(), this.e.centerX(), this.e.centerY());
        this.D.mapRect(rectF, this.d);
        android.graphics.RectF rectFB = this.p.b(f, f2);
        io.dcloud.p.g2 g2Var = new io.dcloud.p.g2(f, f2, e(), f());
        g2Var.a(io.dcloud.p.s2.a(rectFB, rectF, this.e.centerX(), this.e.centerY()));
        return g2Var;
    }

    public void a(int i) {
        this.j = java.lang.Math.round((this.i + i) / 90.0f) * 90;
        if (this.p.e()) {
            this.e.set(this.d);
        }
        this.p.a(this.e, f());
    }

    public void a(float f, float f2, float f3) {
        if (f == 1.0f) {
            return;
        }
        if (java.lang.Math.max(this.e.width(), this.e.height()) >= 10000.0f || java.lang.Math.min(this.e.width(), this.e.height()) <= 500.0f) {
            f += (1.0f - f) / 2.0f;
        }
        this.D.setScale(f, f, f2, f3);
        this.D.mapRect(this.d);
        this.D.mapRect(this.e);
        this.d.contains(this.e);
        for (io.dcloud.p.m2 m2Var : this.x) {
            this.D.mapRect(m2Var.getFrame());
            float x = m2Var.getX() + m2Var.getPivotX();
            float y = m2Var.getY() + m2Var.getPivotY();
            m2Var.a(f);
            m2Var.setX((m2Var.getX() + m2Var.getFrame().centerX()) - x);
            m2Var.setY((m2Var.getY() + m2Var.getFrame().centerY()) - y);
        }
    }

    public void a(float f) {
        this.p.a(f);
    }

    public boolean a(float f, float f2, boolean z) {
        this.q = true;
        if (this.r == io.dcloud.p.k2.CLIP) {
            boolean z2 = !this.l;
            this.p.b(false);
            this.p.a(true);
            this.p.c(false);
            return z2;
        }
        if (this.s && !this.l) {
            c(false);
        }
        return false;
    }

    public void a(boolean z) {
        this.l = true;
        android.util.Log.d("IMGImage", "Homing cancel");
    }

    public void a(int i, int i2) {
        io.dcloud.p.d2 d2Var = this.p;
        if (d2Var != null) {
            d2Var.e(i, i2);
        }
    }

    public void a(io.dcloud.p.j2.b bVar) {
        this.c = bVar;
    }
}
