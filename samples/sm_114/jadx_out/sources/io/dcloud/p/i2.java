package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class i2 implements android.animation.TypeEvaluator {
    private io.dcloud.p.g2 a;

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public io.dcloud.p.g2 evaluate(float f, io.dcloud.p.g2 g2Var, io.dcloud.p.g2 g2Var2) {
        float f2 = g2Var.a;
        float f3 = f2 + ((g2Var2.a - f2) * f);
        float f4 = g2Var.b;
        float f5 = f4 + ((g2Var2.b - f4) * f);
        float f6 = g2Var.c;
        float f7 = f6 + ((g2Var2.c - f6) * f);
        float f8 = g2Var.d;
        float f9 = f8 + (f * (g2Var2.d - f8));
        io.dcloud.p.g2 g2Var3 = this.a;
        if (g2Var3 == null) {
            this.a = new io.dcloud.p.g2(f3, f5, f7, f9);
        } else {
            g2Var3.a(f3, f5, f7, f9);
        }
        return this.a;
    }
}
