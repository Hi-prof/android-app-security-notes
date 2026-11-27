package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class l2 {
    protected android.graphics.Path a;
    private int b;
    private float c;
    private io.dcloud.p.k2 d;

    public l2() {
        this(new android.graphics.Path());
    }

    public int a() {
        return this.b;
    }

    public io.dcloud.p.k2 b() {
        return this.d;
    }

    public android.graphics.Path c() {
        return this.a;
    }

    public float d() {
        return this.c;
    }

    public l2(android.graphics.Path path) {
        this(path, io.dcloud.p.k2.DOODLE);
    }

    public void a(int i) {
        this.b = i;
    }

    public void b(android.graphics.Canvas canvas, android.graphics.Paint paint) {
        if (this.d == io.dcloud.p.k2.MOSAIC) {
            paint.setStrokeWidth(this.c);
            canvas.drawPath(this.a, paint);
        }
    }

    public l2(android.graphics.Path path, io.dcloud.p.k2 k2Var) {
        this(path, k2Var, -65536);
    }

    public void a(io.dcloud.p.k2 k2Var) {
        this.d = k2Var;
    }

    public l2(android.graphics.Path path, io.dcloud.p.k2 k2Var, int i) {
        this(path, k2Var, i, 72.0f);
    }

    public void a(float f) {
        this.c = f;
    }

    public l2(android.graphics.Path path, io.dcloud.p.k2 k2Var, int i, float f) {
        this.b = -65536;
        this.c = 72.0f;
        io.dcloud.p.k2 k2Var2 = io.dcloud.p.k2.NONE;
        this.a = path;
        this.d = k2Var;
        this.b = i;
        this.c = f;
        if (k2Var == io.dcloud.p.k2.MOSAIC) {
            path.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        }
    }

    public void a(android.graphics.Canvas canvas, android.graphics.Paint paint) {
        if (this.d == io.dcloud.p.k2.DOODLE) {
            paint.setColor(this.b);
            paint.setStrokeWidth(this.c);
            canvas.drawPath(this.a, paint);
        }
    }

    public void a(android.graphics.Matrix matrix) {
        this.a.transform(matrix);
    }
}
