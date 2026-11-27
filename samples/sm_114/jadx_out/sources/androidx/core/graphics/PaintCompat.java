package androidx.core.graphics;

/* JADX INFO: loaded from: classes.dex */
public final class PaintCompat {
    private static final java.lang.String EM_STRING = "m";
    private static final java.lang.String TOFU_STRING = "\udfffd";
    private static final java.lang.ThreadLocal<androidx.core.util.Pair<android.graphics.Rect, android.graphics.Rect>> sRectThreadLocal = new java.lang.ThreadLocal<>();

    public static boolean hasGlyph(android.graphics.Paint paint, java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return androidx.core.graphics.PaintCompat.Api23Impl.hasGlyph(paint, str);
        }
        int length = str.length();
        if (length == 1 && java.lang.Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float fMeasureText = paint.measureText(TOFU_STRING);
        float fMeasureText2 = paint.measureText("m");
        float fMeasureText3 = paint.measureText(str);
        float fMeasureText4 = 0.0f;
        if (fMeasureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (fMeasureText3 > fMeasureText2 * 2.0f) {
                return false;
            }
            int i = 0;
            while (i < length) {
                int iCharCount = java.lang.Character.charCount(str.codePointAt(i)) + i;
                fMeasureText4 += paint.measureText(str, i, iCharCount);
                i = iCharCount;
            }
            if (fMeasureText3 >= fMeasureText4) {
                return false;
            }
        }
        if (fMeasureText3 != fMeasureText) {
            return true;
        }
        androidx.core.util.Pair<android.graphics.Rect, android.graphics.Rect> pairObtainEmptyRects = obtainEmptyRects();
        paint.getTextBounds(TOFU_STRING, 0, 2, pairObtainEmptyRects.first);
        paint.getTextBounds(str, 0, length, pairObtainEmptyRects.second);
        return !pairObtainEmptyRects.first.equals(pairObtainEmptyRects.second);
    }

    public static boolean setBlendMode(android.graphics.Paint paint, androidx.core.graphics.BlendModeCompat blendModeCompat) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            androidx.core.graphics.PaintCompat.Api29Impl.setBlendMode(paint, blendModeCompat != null ? androidx.core.graphics.BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(blendModeCompat) : null);
            return true;
        }
        if (blendModeCompat != null) {
            android.graphics.PorterDuff.Mode modeObtainPorterDuffFromCompat = androidx.core.graphics.BlendModeUtils.obtainPorterDuffFromCompat(blendModeCompat);
            paint.setXfermode(modeObtainPorterDuffFromCompat != null ? new android.graphics.PorterDuffXfermode(modeObtainPorterDuffFromCompat) : null);
            return modeObtainPorterDuffFromCompat != null;
        }
        paint.setXfermode(null);
        return true;
    }

    private static androidx.core.util.Pair<android.graphics.Rect, android.graphics.Rect> obtainEmptyRects() {
        java.lang.ThreadLocal<androidx.core.util.Pair<android.graphics.Rect, android.graphics.Rect>> threadLocal = sRectThreadLocal;
        androidx.core.util.Pair<android.graphics.Rect, android.graphics.Rect> pair = threadLocal.get();
        if (pair == null) {
            androidx.core.util.Pair<android.graphics.Rect, android.graphics.Rect> pair2 = new androidx.core.util.Pair<>(new android.graphics.Rect(), new android.graphics.Rect());
            threadLocal.set(pair2);
            return pair2;
        }
        pair.first.setEmpty();
        pair.second.setEmpty();
        return pair;
    }

    private PaintCompat() {
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setBlendMode(android.graphics.Paint paint, java.lang.Object obj) {
            paint.setBlendMode((android.graphics.BlendMode) obj);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static boolean hasGlyph(android.graphics.Paint paint, java.lang.String str) {
            return paint.hasGlyph(str);
        }
    }
}
