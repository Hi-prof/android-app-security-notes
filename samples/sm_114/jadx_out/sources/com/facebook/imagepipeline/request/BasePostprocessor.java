package com.facebook.imagepipeline.request;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasePostprocessor implements com.facebook.imagepipeline.request.Postprocessor {
    public static final android.graphics.Bitmap.Config FALLBACK_BITMAP_CONFIGURATION = android.graphics.Bitmap.Config.ARGB_8888;
    private static java.lang.reflect.Method sCopyBitmap;

    @Override // com.facebook.imagepipeline.request.Postprocessor
    @javax.annotation.Nullable
    public com.facebook.cache.common.CacheKey getPostprocessorCacheKey() {
        return null;
    }

    public void process(android.graphics.Bitmap bitmap) {
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public java.lang.String getName() {
        return "Unknown postprocessor";
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> process(android.graphics.Bitmap bitmap, com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory) {
        android.graphics.Bitmap.Config config = bitmap.getConfig();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (config == null) {
            config = FALLBACK_BITMAP_CONFIGURATION;
        }
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCreateBitmapInternal = platformBitmapFactory.createBitmapInternal(width, height, config);
        try {
            process(closeableReferenceCreateBitmapInternal.get(), bitmap);
            return closeableReferenceCreateBitmapInternal.mo248clone();
        } finally {
            com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceCreateBitmapInternal);
        }
    }

    public void process(android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2) {
        internalCopyBitmap(bitmap, bitmap2);
        process(bitmap);
    }

    private static void internalCopyBitmap(android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2) {
        if (com.facebook.imagepipeline.core.NativeCodeSetup.getUseNativeCode() && bitmap.getConfig() == bitmap2.getConfig()) {
            try {
                if (sCopyBitmap == null) {
                    sCopyBitmap = java.lang.Class.forName("com.facebook.imagepipeline.nativecode.Bitmaps").getDeclaredMethod("copyBitmap", android.graphics.Bitmap.class, android.graphics.Bitmap.class);
                }
                sCopyBitmap.invoke(null, bitmap, bitmap2);
                return;
            } catch (java.lang.ClassNotFoundException e) {
                throw new java.lang.RuntimeException("Wrong Native code setup, reflection failed.", e);
            } catch (java.lang.IllegalAccessException e2) {
                throw new java.lang.RuntimeException("Wrong Native code setup, reflection failed.", e2);
            } catch (java.lang.NoSuchMethodException e3) {
                throw new java.lang.RuntimeException("Wrong Native code setup, reflection failed.", e3);
            } catch (java.lang.reflect.InvocationTargetException e4) {
                throw new java.lang.RuntimeException("Wrong Native code setup, reflection failed.", e4);
            }
        }
        new android.graphics.Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, (android.graphics.Paint) null);
    }
}
