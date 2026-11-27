package com.taobao.weex.dom;

/* JADX INFO: loaded from: classes.dex */
public class WXLineHeightSpan implements android.text.style.LineHeightSpan {
    private int lineHeight;

    public WXLineHeightSpan(int i) {
        this.lineHeight = i;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(java.lang.CharSequence charSequence, int i, int i2, int i3, int i4, android.graphics.Paint.FontMetricsInt fontMetricsInt) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d("LineHeight", ((java.lang.Object) charSequence) + " ; start " + i + "; end " + i2 + "; spanstartv " + i3 + "; v " + i4 + "; fm " + fontMetricsInt);
        }
        int i5 = this.lineHeight - (fontMetricsInt.descent - fontMetricsInt.ascent);
        int i6 = i5 / 2;
        int i7 = i5 - i6;
        fontMetricsInt.top -= i7;
        fontMetricsInt.bottom += i6;
        fontMetricsInt.ascent -= i7;
        fontMetricsInt.descent += i6;
    }
}
