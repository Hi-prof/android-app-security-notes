package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class o2 implements io.dcloud.p.q2, io.dcloud.p.q2.a {
    private android.graphics.RectF a;
    private android.view.View b;
    private io.dcloud.p.q2.a c;
    private boolean d = false;

    public o2(android.view.View view) {
        this.b = view;
    }

    @Override // io.dcloud.p.q2
    public boolean a() {
        return this.d;
    }

    @Override // io.dcloud.p.q2
    public boolean b() {
        if (a()) {
            return false;
        }
        this.d = true;
        a(this.b);
        return true;
    }

    public boolean c() {
        return b(this.b);
    }

    @Override // io.dcloud.p.q2
    public boolean dismiss() {
        if (!a()) {
            return false;
        }
        this.d = false;
        c(this.b);
        return true;
    }

    @Override // io.dcloud.p.q2
    public android.graphics.RectF getFrame() {
        if (this.a == null) {
            this.a = new android.graphics.RectF(0.0f, 0.0f, this.b.getWidth(), this.b.getHeight());
            float x = this.b.getX() + this.b.getPivotX();
            float y = this.b.getY() + this.b.getPivotY();
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.setTranslate(this.b.getX(), this.b.getY());
            matrix.postScale(this.b.getScaleX(), this.b.getScaleY(), x, y);
            matrix.mapRect(this.a);
        }
        return this.a;
    }

    @Override // io.dcloud.p.q2
    public void a(io.dcloud.p.q2.a aVar) {
        this.c = aVar;
    }

    @Override // io.dcloud.p.q2.a
    public void c(android.view.View view) {
        this.a = null;
        view.invalidate();
        io.dcloud.p.q2.a aVar = this.c;
        if (aVar != null) {
            aVar.c(view);
        }
    }

    @Override // io.dcloud.p.q2.a
    public void a(android.view.View view) {
        view.invalidate();
        io.dcloud.p.q2.a aVar = this.c;
        if (aVar != null) {
            aVar.a(view);
        }
    }

    @Override // io.dcloud.p.q2
    public void b(io.dcloud.p.q2.a aVar) {
        this.c = null;
    }

    @Override // io.dcloud.p.q2.a
    public boolean b(android.view.View view) {
        io.dcloud.p.q2.a aVar = this.c;
        return aVar != null && aVar.b(view);
    }
}
