package master.flame.danmaku.danmaku.model.android;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleTextCacheStuffer extends master.flame.danmaku.danmaku.model.android.BaseCacheStuffer {
    private static final java.util.Map<java.lang.Float, java.lang.Float> sTextHeightCache = new java.util.HashMap();

    protected void drawBackground(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, android.graphics.Canvas canvas, float f, float f2) {
    }

    protected java.lang.Float getCacheHeight(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, android.graphics.Paint paint) {
        java.lang.Float fValueOf = java.lang.Float.valueOf(paint.getTextSize());
        java.util.Map<java.lang.Float, java.lang.Float> map = sTextHeightCache;
        java.lang.Float f = map.get(fValueOf);
        if (f != null) {
            return f;
        }
        android.graphics.Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        java.lang.Float fValueOf2 = java.lang.Float.valueOf((fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading);
        map.put(fValueOf, fValueOf2);
        return fValueOf2;
    }

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    public void measure(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, android.text.TextPaint textPaint, boolean z) {
        float fMax = 0.0f;
        java.lang.Float fValueOf = java.lang.Float.valueOf(0.0f);
        if (baseDanmaku.lines == null) {
            if (baseDanmaku.text != null) {
                fMax = textPaint.measureText(baseDanmaku.text.toString());
                fValueOf = getCacheHeight(baseDanmaku, textPaint);
            }
            baseDanmaku.paintWidth = fMax;
            baseDanmaku.paintHeight = fValueOf.floatValue();
            return;
        }
        java.lang.Float cacheHeight = getCacheHeight(baseDanmaku, textPaint);
        for (java.lang.String str : baseDanmaku.lines) {
            if (str.length() > 0) {
                fMax = java.lang.Math.max(textPaint.measureText(str), fMax);
            }
        }
        baseDanmaku.paintWidth = fMax;
        baseDanmaku.paintHeight = baseDanmaku.lines.length * cacheHeight.floatValue();
    }

    protected void drawStroke(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, java.lang.String str, android.graphics.Canvas canvas, float f, float f2, android.graphics.Paint paint) {
        if (str != null) {
            canvas.drawText(str, f, f2, paint);
        } else {
            canvas.drawText(baseDanmaku.text.toString(), f, f2, paint);
        }
    }

    protected void drawText(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, java.lang.String str, android.graphics.Canvas canvas, float f, float f2, android.text.TextPaint textPaint, boolean z) {
        if (str != null) {
            canvas.drawText(str, f, f2, textPaint);
        } else {
            canvas.drawText(baseDanmaku.text.toString(), f, f2, textPaint);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    public void clearCaches() {
        sTextHeightCache.clear();
    }

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    public void drawDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, android.graphics.Canvas canvas, float f, float f2, boolean z, master.flame.danmaku.danmaku.model.android.AndroidDisplayer.DisplayerConfig displayerConfig) {
        float f3;
        float f4;
        float f5;
        float f6 = f + baseDanmaku.padding;
        float f7 = f2 + baseDanmaku.padding;
        if (baseDanmaku.borderColor != 0) {
            f6 += 4.0f;
            f7 += 4.0f;
        }
        float f8 = f6;
        float f9 = f7;
        displayerConfig.definePaintParams(z);
        android.text.TextPaint paint = displayerConfig.getPaint(baseDanmaku, z);
        drawBackground(baseDanmaku, canvas, f, f2);
        if (baseDanmaku.lines != null) {
            java.lang.String[] strArr = baseDanmaku.lines;
            if (strArr.length == 1) {
                if (displayerConfig.hasStroke(baseDanmaku)) {
                    displayerConfig.applyPaintConfig(baseDanmaku, paint, true);
                    float fAscent = f9 - paint.ascent();
                    if (displayerConfig.HAS_PROJECTION) {
                        float f10 = displayerConfig.sProjectionOffsetX + f8;
                        fAscent += displayerConfig.sProjectionOffsetY;
                        f5 = f10;
                    } else {
                        f5 = f8;
                    }
                    drawStroke(baseDanmaku, strArr[0], canvas, f5, fAscent, paint);
                }
                displayerConfig.applyPaintConfig(baseDanmaku, paint, false);
                drawText(baseDanmaku, strArr[0], canvas, f8, f9 - paint.ascent(), paint, z);
            } else {
                float length = (baseDanmaku.paintHeight - (baseDanmaku.padding * 2)) / strArr.length;
                for (int i = 0; i < strArr.length; i++) {
                    java.lang.String str = strArr[i];
                    if (str != null && str.length() != 0) {
                        if (displayerConfig.hasStroke(baseDanmaku)) {
                            displayerConfig.applyPaintConfig(baseDanmaku, paint, true);
                            float fAscent2 = ((i * length) + f9) - paint.ascent();
                            if (displayerConfig.HAS_PROJECTION) {
                                float f11 = displayerConfig.sProjectionOffsetX + f8;
                                fAscent2 += displayerConfig.sProjectionOffsetY;
                                f4 = f11;
                            } else {
                                f4 = f8;
                            }
                            drawStroke(baseDanmaku, strArr[i], canvas, f4, fAscent2, paint);
                        }
                        displayerConfig.applyPaintConfig(baseDanmaku, paint, false);
                        drawText(baseDanmaku, strArr[i], canvas, f8, ((i * length) + f9) - paint.ascent(), paint, z);
                    }
                }
            }
        } else {
            if (displayerConfig.hasStroke(baseDanmaku)) {
                displayerConfig.applyPaintConfig(baseDanmaku, paint, true);
                float fAscent3 = f9 - paint.ascent();
                if (displayerConfig.HAS_PROJECTION) {
                    float f12 = displayerConfig.sProjectionOffsetX + f8;
                    fAscent3 += displayerConfig.sProjectionOffsetY;
                    f3 = f12;
                } else {
                    f3 = f8;
                }
                drawStroke(baseDanmaku, null, canvas, f3, fAscent3, paint);
            }
            displayerConfig.applyPaintConfig(baseDanmaku, paint, false);
            drawText(baseDanmaku, null, canvas, f8, f9 - paint.ascent(), paint, z);
        }
        if (baseDanmaku.underlineColor != 0) {
            android.graphics.Paint underlinePaint = displayerConfig.getUnderlinePaint(baseDanmaku);
            float f13 = (f2 + baseDanmaku.paintHeight) - displayerConfig.UNDERLINE_HEIGHT;
            canvas.drawLine(f, f13, f + baseDanmaku.paintWidth, f13, underlinePaint);
        }
        if (baseDanmaku.borderColor != 0) {
            canvas.drawRect(f, f2, f + baseDanmaku.paintWidth, f2 + baseDanmaku.paintHeight, displayerConfig.getBorderPaint(baseDanmaku));
        }
    }
}
