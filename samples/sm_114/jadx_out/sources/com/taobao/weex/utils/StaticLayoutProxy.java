package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class StaticLayoutProxy {
    private static java.lang.reflect.Constructor<android.text.StaticLayout> layoutConstructor;

    public static android.text.StaticLayout create(java.lang.CharSequence charSequence, android.text.TextPaint textPaint, int i, android.text.Layout.Alignment alignment, float f, float f2, boolean z, boolean z2) {
        if (z2) {
            android.text.StaticLayout staticLayoutCreateInternal = createInternal(charSequence, textPaint, i, alignment, android.text.TextDirectionHeuristics.RTL, f, f2, z);
            return staticLayoutCreateInternal != null ? staticLayoutCreateInternal : new android.text.StaticLayout(charSequence, textPaint, i, alignment, f, f2, z);
        }
        return new android.text.StaticLayout(charSequence, textPaint, i, alignment, f, f2, z);
    }

    private static android.text.StaticLayout createInternal(java.lang.CharSequence charSequence, android.text.TextPaint textPaint, int i, android.text.Layout.Alignment alignment, android.text.TextDirectionHeuristic textDirectionHeuristic, float f, float f2, boolean z) {
        try {
            if (layoutConstructor == null) {
                java.lang.Class cls = java.lang.Float.TYPE;
                layoutConstructor = android.text.StaticLayout.class.getConstructor(java.lang.CharSequence.class, android.text.TextPaint.class, java.lang.Integer.TYPE, android.text.Layout.Alignment.class, android.text.TextDirectionHeuristic.class, cls, cls, java.lang.Boolean.TYPE);
            }
            java.lang.reflect.Constructor<android.text.StaticLayout> constructor = layoutConstructor;
            if (constructor != null) {
                return constructor.newInstance(charSequence, textPaint, java.lang.Integer.valueOf(i), alignment, textDirectionHeuristic, java.lang.Float.valueOf(f), java.lang.Float.valueOf(f2), java.lang.Boolean.valueOf(z));
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
