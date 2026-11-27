package com.taobao.weex.dom;

/* JADX INFO: loaded from: classes.dex */
public class WXCustomStyleSpan extends android.text.style.MetricAffectingSpan {
    private final java.lang.String mFontFamily;
    private final int mStyle;
    private final int mWeight;

    public WXCustomStyleSpan(int i, int i2, java.lang.String str) {
        this.mStyle = i;
        this.mWeight = i2;
        this.mFontFamily = str;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(android.text.TextPaint textPaint) {
        com.taobao.weex.utils.TypefaceUtil.applyFontStyle(textPaint, this.mStyle, this.mWeight, this.mFontFamily);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(android.text.TextPaint textPaint) {
        com.taobao.weex.utils.TypefaceUtil.applyFontStyle(textPaint, this.mStyle, this.mWeight, this.mFontFamily);
    }

    public int getStyle() {
        int i = this.mStyle;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    public int getWeight() {
        int i = this.mWeight;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    public java.lang.String getFontFamily() {
        return this.mFontFamily;
    }
}
