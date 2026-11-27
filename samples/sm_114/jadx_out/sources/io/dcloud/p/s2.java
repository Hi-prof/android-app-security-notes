package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class s2 {
    private static final android.graphics.Matrix a = new android.graphics.Matrix();

    public static int a(int i) {
        int i2 = 1;
        for (int i3 = i; i3 > 1; i3 >>= 1) {
            i2 <<= 1;
        }
        return i2 != i ? i2 << 1 : i2;
    }

    public static void a(android.graphics.RectF rectF, android.graphics.RectF rectF2) {
        rectF2.offset(rectF.centerX() - rectF2.centerX(), rectF.centerY() - rectF2.centerY());
    }

    public static io.dcloud.p.g2 b(android.graphics.RectF rectF, android.graphics.RectF rectF2, float f, float f2) {
        io.dcloud.p.g2 g2Var = new io.dcloud.p.g2(0.0f, 0.0f, 1.0f, 0.0f);
        if (!rectF2.contains(rectF)) {
            if (rectF2.width() < rectF.width() && rectF2.height() < rectF.height()) {
                g2Var.c = java.lang.Math.min(rectF.width() / rectF2.width(), rectF.height() / rectF2.height());
            }
            android.graphics.RectF rectF3 = new android.graphics.RectF();
            android.graphics.Matrix matrix = a;
            float f3 = g2Var.c;
            matrix.setScale(f3, f3, f, f2);
            matrix.mapRect(rectF3, rectF2);
            if (rectF3.width() < rectF.width()) {
                g2Var.a += rectF.centerX() - rectF3.centerX();
            } else {
                float f4 = rectF3.left;
                float f5 = rectF.left;
                if (f4 > f5) {
                    g2Var.a += f5 - f4;
                } else {
                    float f6 = rectF3.right;
                    float f7 = rectF.right;
                    if (f6 < f7) {
                        g2Var.a += f7 - f6;
                    }
                }
            }
            if (rectF3.height() < rectF.height()) {
                g2Var.b += rectF.centerY() - rectF3.centerY();
                return g2Var;
            }
            float f8 = rectF3.top;
            float f9 = rectF.top;
            if (f8 > f9) {
                g2Var.b += f9 - f8;
                return g2Var;
            }
            float f10 = rectF3.bottom;
            float f11 = rectF.bottom;
            if (f10 < f11) {
                g2Var.b += f11 - f10;
            }
        }
        return g2Var;
    }

    public static void a(android.graphics.RectF rectF, android.graphics.RectF rectF2, float f) {
        a(rectF, rectF2, f, f, f, f);
    }

    public static void a(android.graphics.RectF rectF, android.graphics.RectF rectF2, float f, float f2, float f3, float f4) {
        if (rectF.isEmpty() || rectF2.isEmpty()) {
            return;
        }
        if (rectF.width() < f + f3) {
            f = 0.0f;
            f3 = 0.0f;
        }
        if (rectF.height() < f2 + f4) {
            f2 = 0.0f;
            f4 = 0.0f;
        }
        float fMin = java.lang.Math.min(((rectF.width() - f) - f3) / rectF2.width(), ((rectF.height() - f2) - f4) / rectF2.height());
        rectF2.set(0.0f, 0.0f, rectF2.width() * fMin, rectF2.height() * fMin);
        rectF2.offset((rectF.centerX() + ((f - f3) / 2.0f)) - rectF2.centerX(), (rectF.centerY() + ((f2 - f4) / 2.0f)) - rectF2.centerY());
    }

    public static io.dcloud.p.g2 a(android.graphics.RectF rectF, android.graphics.RectF rectF2, boolean z) {
        io.dcloud.p.g2 g2Var = new io.dcloud.p.g2(0.0f, 0.0f, 1.0f, 0.0f);
        if (!rectF2.contains(rectF) || z) {
            if (z || (rectF2.width() < rectF.width() && rectF2.height() < rectF.height())) {
                g2Var.c = java.lang.Math.min(rectF.width() / rectF2.width(), rectF.height() / rectF2.height());
            }
            android.graphics.RectF rectF3 = new android.graphics.RectF();
            android.graphics.Matrix matrix = a;
            float f = g2Var.c;
            matrix.setScale(f, f, rectF2.centerX(), rectF2.centerY());
            matrix.mapRect(rectF3, rectF2);
            if (rectF3.width() < rectF.width()) {
                g2Var.a += rectF.centerX() - rectF3.centerX();
            } else {
                float f2 = rectF3.left;
                float f3 = rectF.left;
                if (f2 > f3) {
                    g2Var.a += f3 - f2;
                } else {
                    float f4 = rectF3.right;
                    float f5 = rectF.right;
                    if (f4 < f5) {
                        g2Var.a += f5 - f4;
                    }
                }
            }
            if (rectF3.height() < rectF.height()) {
                g2Var.b += rectF.centerY() - rectF3.centerY();
                return g2Var;
            }
            float f6 = rectF3.top;
            float f7 = rectF.top;
            if (f6 > f7) {
                g2Var.b += f7 - f6;
                return g2Var;
            }
            float f8 = rectF3.bottom;
            float f9 = rectF.bottom;
            if (f8 < f9) {
                g2Var.b += f9 - f8;
            }
        }
        return g2Var;
    }

    public static io.dcloud.p.g2 b(android.graphics.RectF rectF, android.graphics.RectF rectF2) {
        io.dcloud.p.g2 g2Var = new io.dcloud.p.g2(0.0f, 0.0f, 1.0f, 0.0f);
        if (rectF.equals(rectF2)) {
            return g2Var;
        }
        g2Var.c = java.lang.Math.max(rectF.width() / rectF2.width(), rectF.height() / rectF2.height());
        android.graphics.RectF rectF3 = new android.graphics.RectF();
        android.graphics.Matrix matrix = a;
        float f = g2Var.c;
        matrix.setScale(f, f, rectF2.centerX(), rectF2.centerY());
        matrix.mapRect(rectF3, rectF2);
        g2Var.a += rectF.centerX() - rectF3.centerX();
        g2Var.b += rectF.centerY() - rectF3.centerY();
        return g2Var;
    }

    public static io.dcloud.p.g2 a(android.graphics.RectF rectF, android.graphics.RectF rectF2, float f, float f2) {
        io.dcloud.p.g2 g2Var = new io.dcloud.p.g2(0.0f, 0.0f, 1.0f, 0.0f);
        if (!rectF2.contains(rectF)) {
            if (rectF2.width() < rectF.width() || rectF2.height() < rectF.height()) {
                g2Var.c = java.lang.Math.max(rectF.width() / rectF2.width(), rectF.height() / rectF2.height());
            }
            android.graphics.RectF rectF3 = new android.graphics.RectF();
            android.graphics.Matrix matrix = a;
            float f3 = g2Var.c;
            matrix.setScale(f3, f3, f, f2);
            matrix.mapRect(rectF3, rectF2);
            float f4 = rectF3.left;
            float f5 = rectF.left;
            if (f4 > f5) {
                g2Var.a += f5 - f4;
            } else {
                float f6 = rectF3.right;
                float f7 = rectF.right;
                if (f6 < f7) {
                    g2Var.a += f7 - f6;
                }
            }
            float f8 = rectF3.top;
            float f9 = rectF.top;
            if (f8 > f9) {
                g2Var.b += f9 - f8;
                return g2Var;
            }
            float f10 = rectF3.bottom;
            float f11 = rectF.bottom;
            if (f10 < f11) {
                g2Var.b += f11 - f10;
            }
        }
        return g2Var;
    }
}
