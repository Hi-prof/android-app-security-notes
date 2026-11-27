package io.dcloud.feature.nativeObj.richtext.span;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class HrSpan extends android.text.style.ReplacementSpan {
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    int align;
    int color;
    int hrWidth;
    int size;
    int width;

    public HrSpan(int i, int i2, int i3, int i4, int i5) {
        this.align = i;
        this.size = i2;
        this.width = i3;
        this.color = i4;
        this.hrWidth = i5;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(android.graphics.Canvas canvas, java.lang.CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, android.graphics.Paint paint) {
        paint.setStrokeWidth(this.size);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        paint.setColor(this.color);
        int i6 = this.align;
        if (i6 == 0) {
            int i7 = this.hrWidth;
            int i8 = this.width;
            float f2 = (i7 - i8) / 2;
            canvas.drawRect(f + f2, i4, i8 + f + f2, i4 + this.size, paint);
            return;
        }
        if (i6 == 2) {
            float f3 = this.hrWidth + f;
            canvas.drawRect(f3 - this.width, i4, f3, i4 + this.size, paint);
        } else if (i6 == 1) {
            canvas.drawRect(f, i4, f + this.width, i4 + this.size, paint);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(android.graphics.Paint paint, java.lang.CharSequence charSequence, int i, int i2, android.graphics.Paint.FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = 0;
            int i3 = this.size;
            fontMetricsInt.descent = i3;
            fontMetricsInt.bottom = i3;
            fontMetricsInt.top = 0;
        }
        return this.hrWidth;
    }
}
