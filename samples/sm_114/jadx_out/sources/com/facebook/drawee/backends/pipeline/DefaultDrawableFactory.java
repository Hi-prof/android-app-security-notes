package com.facebook.drawee.backends.pipeline;

/* JADX INFO: loaded from: classes.dex */
public class DefaultDrawableFactory implements com.facebook.imagepipeline.drawable.DrawableFactory {

    @javax.annotation.Nullable
    private final com.facebook.imagepipeline.drawable.DrawableFactory mAnimatedDrawableFactory;
    private final android.content.res.Resources mResources;

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public boolean supportsImageType(com.facebook.imagepipeline.image.CloseableImage closeableImage) {
        return true;
    }

    public DefaultDrawableFactory(android.content.res.Resources resources, @javax.annotation.Nullable com.facebook.imagepipeline.drawable.DrawableFactory drawableFactory) {
        this.mResources = resources;
        this.mAnimatedDrawableFactory = drawableFactory;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable createDrawable(com.facebook.imagepipeline.image.CloseableImage closeableImage) {
        try {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("DefaultDrawableFactory#createDrawable");
            }
            if (!(closeableImage instanceof com.facebook.imagepipeline.image.CloseableStaticBitmap)) {
                com.facebook.imagepipeline.drawable.DrawableFactory drawableFactory = this.mAnimatedDrawableFactory;
                if (drawableFactory == null || !drawableFactory.supportsImageType(closeableImage)) {
                    if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                        com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                    }
                    return null;
                }
                android.graphics.drawable.Drawable drawableCreateDrawable = this.mAnimatedDrawableFactory.createDrawable(closeableImage);
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                }
                return drawableCreateDrawable;
            }
            com.facebook.imagepipeline.image.CloseableStaticBitmap closeableStaticBitmap = (com.facebook.imagepipeline.image.CloseableStaticBitmap) closeableImage;
            android.graphics.drawable.BitmapDrawable bitmapDrawable = new android.graphics.drawable.BitmapDrawable(this.mResources, closeableStaticBitmap.getUnderlyingBitmap());
            if (!hasTransformableRotationAngle(closeableStaticBitmap) && !hasTransformableExifOrientation(closeableStaticBitmap)) {
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                }
                return bitmapDrawable;
            }
            com.facebook.drawee.drawable.OrientedDrawable orientedDrawable = new com.facebook.drawee.drawable.OrientedDrawable(bitmapDrawable, closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation());
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
            return orientedDrawable;
        } catch (java.lang.Throwable th) {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
            throw th;
        }
    }

    private static boolean hasTransformableRotationAngle(com.facebook.imagepipeline.image.CloseableStaticBitmap closeableStaticBitmap) {
        return (closeableStaticBitmap.getRotationAngle() == 0 || closeableStaticBitmap.getRotationAngle() == -1) ? false : true;
    }

    private static boolean hasTransformableExifOrientation(com.facebook.imagepipeline.image.CloseableStaticBitmap closeableStaticBitmap) {
        return (closeableStaticBitmap.getExifOrientation() == 1 || closeableStaticBitmap.getExifOrientation() == 0) ? false : true;
    }
}
