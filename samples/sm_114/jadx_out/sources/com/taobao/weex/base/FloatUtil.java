package com.taobao.weex.base;

/* JADX INFO: loaded from: classes.dex */
public class FloatUtil {
    private static final float EPSILON = 1.0E-5f;

    public static boolean floatsEqual(float f, float f2) {
        if (java.lang.Float.isNaN(f) || java.lang.Float.isNaN(f2)) {
            return java.lang.Float.isNaN(f) && java.lang.Float.isNaN(f2);
        }
        return java.lang.Math.abs(f2 - f) < EPSILON;
    }
}
