package com.facebook.drawee.view;

/* JADX INFO: loaded from: classes.dex */
public class AspectRatioMeasure {

    public static class Spec {
        public int height;
        public int width;
    }

    private static boolean shouldAdjust(int i) {
        return i == 0 || i == -2;
    }

    public static void updateMeasureSpec(com.facebook.drawee.view.AspectRatioMeasure.Spec spec, float f, @javax.annotation.Nullable android.view.ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f <= 0.0f || layoutParams == null) {
            return;
        }
        if (shouldAdjust(layoutParams.height)) {
            spec.height = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.resolveSize((int) (((android.view.View.MeasureSpec.getSize(spec.width) - i) / f) + i2), spec.height), 1073741824);
        } else if (shouldAdjust(layoutParams.width)) {
            spec.width = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.resolveSize((int) (((android.view.View.MeasureSpec.getSize(spec.height) - i2) * f) + i), spec.width), 1073741824);
        }
    }
}
