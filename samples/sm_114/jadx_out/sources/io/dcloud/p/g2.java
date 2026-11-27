package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class g2 {
    public float a;
    public float b;
    public float c;
    public float d;

    public g2(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public void a(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public java.lang.String toString() {
        return "IMGHoming{x=" + this.a + ", y=" + this.b + ", scale=" + this.c + ", rotate=" + this.d + com.taobao.weex.el.parse.Operators.BLOCK_END;
    }

    public void a(io.dcloud.p.g2 g2Var) {
        this.c *= g2Var.c;
        this.a -= g2Var.a;
        this.b -= g2Var.b;
    }

    public static boolean a(io.dcloud.p.g2 g2Var, io.dcloud.p.g2 g2Var2) {
        return java.lang.Float.compare(g2Var.d, g2Var2.d) != 0;
    }
}
