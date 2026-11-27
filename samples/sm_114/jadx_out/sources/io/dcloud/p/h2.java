package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class h2 extends android.animation.ValueAnimator {
    private boolean a = false;
    private io.dcloud.p.i2 b;

    public h2() {
        setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
    }

    public void a(io.dcloud.p.g2 g2Var, io.dcloud.p.g2 g2Var2) {
        setObjectValues(g2Var, g2Var2);
        this.a = io.dcloud.p.g2.a(g2Var, g2Var2);
    }

    @Override // android.animation.ValueAnimator
    public void setObjectValues(java.lang.Object... objArr) {
        super.setObjectValues(objArr);
        if (this.b == null) {
            this.b = new io.dcloud.p.i2();
        }
        setEvaluator(this.b);
    }

    public boolean a() {
        return this.a;
    }
}
