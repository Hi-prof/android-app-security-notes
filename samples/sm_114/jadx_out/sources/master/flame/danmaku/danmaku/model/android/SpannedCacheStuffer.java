package master.flame.danmaku.danmaku.model.android;

/* JADX INFO: loaded from: classes2.dex */
public class SpannedCacheStuffer extends master.flame.danmaku.danmaku.model.android.SimpleTextCacheStuffer {
    @Override // master.flame.danmaku.danmaku.model.android.SimpleTextCacheStuffer, master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    public void measure(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, android.text.TextPaint textPaint, boolean z) {
        java.lang.CharSequence charSequence;
        if ((baseDanmaku.text instanceof android.text.Spanned) && (charSequence = baseDanmaku.text) != null) {
            android.text.StaticLayout staticLayout = new android.text.StaticLayout(charSequence, textPaint, (int) java.lang.Math.ceil(android.text.StaticLayout.getDesiredWidth(baseDanmaku.text, textPaint)), android.text.Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            baseDanmaku.paintWidth = staticLayout.getWidth();
            baseDanmaku.paintHeight = staticLayout.getHeight();
            baseDanmaku.obj = new java.lang.ref.SoftReference(staticLayout);
            return;
        }
        super.measure(baseDanmaku, textPaint, z);
    }

    @Override // master.flame.danmaku.danmaku.model.android.SimpleTextCacheStuffer
    public void drawStroke(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, java.lang.String str, android.graphics.Canvas canvas, float f, float f2, android.graphics.Paint paint) {
        if (baseDanmaku.obj == null) {
            super.drawStroke(baseDanmaku, str, canvas, f, f2, paint);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.SimpleTextCacheStuffer
    public void drawText(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, java.lang.String str, android.graphics.Canvas canvas, float f, float f2, android.text.TextPaint textPaint, boolean z) {
        android.text.StaticLayout staticLayout;
        if (baseDanmaku.obj == null) {
            super.drawText(baseDanmaku, str, canvas, f, f2, textPaint, z);
            return;
        }
        android.text.StaticLayout staticLayout2 = (android.text.StaticLayout) ((java.lang.ref.SoftReference) baseDanmaku.obj).get();
        boolean z2 = true;
        boolean z3 = (baseDanmaku.requestFlags & 1) != 0;
        boolean z4 = (baseDanmaku.requestFlags & 2) != 0;
        if (z4 || staticLayout2 == null) {
            if (z4) {
                baseDanmaku.requestFlags &= -3;
            }
            java.lang.CharSequence charSequence = baseDanmaku.text;
            if (charSequence == null) {
                return;
            }
            if (z3) {
                staticLayout = new android.text.StaticLayout(charSequence, textPaint, (int) java.lang.Math.ceil(android.text.StaticLayout.getDesiredWidth(baseDanmaku.text, textPaint)), android.text.Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                baseDanmaku.paintWidth = staticLayout.getWidth();
                baseDanmaku.paintHeight = staticLayout.getHeight();
                baseDanmaku.requestFlags &= -2;
            } else {
                staticLayout = new android.text.StaticLayout(charSequence, textPaint, (int) baseDanmaku.paintWidth, android.text.Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            staticLayout2 = staticLayout;
            baseDanmaku.obj = new java.lang.ref.SoftReference(staticLayout2);
        }
        if (f == 0.0f || f2 == 0.0f) {
            z2 = false;
        } else {
            canvas.save();
            canvas.translate(f, f2 + textPaint.ascent());
        }
        staticLayout2.draw(canvas);
        if (z2) {
            canvas.restore();
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.SimpleTextCacheStuffer, master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    public void clearCaches() {
        super.clearCaches();
        java.lang.System.gc();
    }

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    public void clearCache(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
        super.clearCache(baseDanmaku);
        if (baseDanmaku.obj instanceof java.lang.ref.SoftReference) {
            ((java.lang.ref.SoftReference) baseDanmaku.obj).clear();
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    public void releaseResource(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
        clearCache(baseDanmaku);
        super.releaseResource(baseDanmaku);
    }
}
