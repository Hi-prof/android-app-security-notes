package com.facebook.drawee.drawable;

/* JADX INFO: loaded from: classes.dex */
public class RoundedNinePatchDrawable extends com.facebook.drawee.drawable.RoundedDrawable {
    public RoundedNinePatchDrawable(android.graphics.drawable.NinePatchDrawable ninePatchDrawable) {
        super(ninePatchDrawable);
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("RoundedNinePatchDrawable#draw");
        }
        if (!shouldRound()) {
            super.draw(canvas);
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                return;
            }
            return;
        }
        updateTransform();
        updatePath();
        canvas.clipPath(this.mPath);
        super.draw(canvas);
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }
}
