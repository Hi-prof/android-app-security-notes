package com.facebook.imagepipeline.filter;

/* JADX INFO: compiled from: XferRoundFilter.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/facebook/imagepipeline/filter/XferRoundFilter;", "", "<init>", "()V", "xferRoundBitmap", "", "output", "Landroid/graphics/Bitmap;", "source", "enableAntiAliasing", "", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class XferRoundFilter {
    public static final com.facebook.imagepipeline.filter.XferRoundFilter INSTANCE = new com.facebook.imagepipeline.filter.XferRoundFilter();

    private XferRoundFilter() {
    }

    @kotlin.jvm.JvmStatic
    public static final void xferRoundBitmap(android.graphics.Bitmap output, android.graphics.Bitmap source, boolean enableAntiAliasing) {
        android.graphics.Paint paint;
        android.graphics.Paint paint2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(output, "output");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        output.setHasAlpha(true);
        if (enableAntiAliasing) {
            paint = new android.graphics.Paint(1);
            paint2 = new android.graphics.Paint(1);
        } else {
            paint = new android.graphics.Paint();
            paint2 = new android.graphics.Paint();
        }
        paint.setColor(-16777216);
        paint2.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        float width = source.getWidth() / 2.0f;
        float height = source.getHeight() / 2.0f;
        android.graphics.Canvas canvas = new android.graphics.Canvas(output);
        canvas.drawCircle(width, height, java.lang.Math.min(width, height), paint);
        canvas.drawBitmap(source, 0.0f, 0.0f, paint2);
    }
}
