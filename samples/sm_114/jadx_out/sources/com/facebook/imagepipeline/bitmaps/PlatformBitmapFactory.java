package com.facebook.imagepipeline.bitmaps;

/* JADX INFO: loaded from: classes.dex */
public abstract class PlatformBitmapFactory {
    public abstract com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmapInternal(int i, int i2, android.graphics.Bitmap.Config config);

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(int i, int i2, android.graphics.Bitmap.Config config) {
        return createBitmap(i, i2, config, (java.lang.Object) null);
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(int i, int i2) {
        return createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(int i, int i2, android.graphics.Bitmap.Config config, @javax.annotation.Nullable java.lang.Object obj) {
        return createBitmapInternal(i, i2, config);
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(int i, int i2, @javax.annotation.Nullable java.lang.Object obj) {
        return createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888, obj);
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(android.graphics.Bitmap bitmap) {
        return createBitmap(bitmap, (java.lang.Object) null);
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(android.graphics.Bitmap bitmap, @javax.annotation.Nullable java.lang.Object obj) {
        return createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), obj);
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(android.graphics.Bitmap bitmap, int i, int i2, int i3, int i4) {
        return createBitmap(bitmap, i, i2, i3, i4, (java.lang.Object) null);
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(android.graphics.Bitmap bitmap, int i, int i2, int i3, int i4, @javax.annotation.Nullable java.lang.Object obj) {
        return createBitmap(bitmap, i, i2, i3, i4, (android.graphics.Matrix) null, false, obj);
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(android.graphics.Bitmap bitmap, int i, int i2, int i3, int i4, @javax.annotation.Nullable android.graphics.Matrix matrix, boolean z) {
        return createBitmap(bitmap, i, i2, i3, i4, matrix, z, (java.lang.Object) null);
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createScaledBitmap(android.graphics.Bitmap bitmap, int i, int i2, boolean z) {
        return createScaledBitmap(bitmap, i, i2, z, null);
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createScaledBitmap(android.graphics.Bitmap bitmap, int i, int i2, boolean z, @javax.annotation.Nullable java.lang.Object obj) {
        checkWidthHeight(i, i2);
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        matrix.setScale(i / width, i2 / height);
        return createBitmap(bitmap, 0, 0, width, height, matrix, z, obj);
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(android.graphics.Bitmap bitmap, int i, int i2, int i3, int i4, @javax.annotation.Nullable android.graphics.Matrix matrix, boolean z, @javax.annotation.Nullable java.lang.Object obj) {
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCreateBitmap;
        android.graphics.Canvas canvas;
        android.graphics.Paint paint;
        com.facebook.common.internal.Preconditions.checkNotNull(bitmap, "Source bitmap cannot be null");
        checkXYSign(i, i2);
        checkWidthHeight(i3, i4);
        checkFinalImageBounds(bitmap, i, i2, i3, i4);
        android.graphics.Rect rect = new android.graphics.Rect(i, i2, i + i3, i2 + i4);
        android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, i3, i4);
        android.graphics.Bitmap.Config suitableBitmapConfig = getSuitableBitmapConfig(bitmap);
        if (matrix == null || matrix.isIdentity()) {
            closeableReferenceCreateBitmap = createBitmap(i3, i4, suitableBitmapConfig, bitmap.hasAlpha(), obj);
            setPropertyFromSourceBitmap(bitmap, closeableReferenceCreateBitmap.get());
            canvas = new android.graphics.Canvas(closeableReferenceCreateBitmap.get());
            paint = null;
        } else {
            boolean zRectStaysRect = matrix.rectStaysRect();
            android.graphics.RectF rectF2 = new android.graphics.RectF();
            matrix.mapRect(rectF2, rectF);
            int iRound = java.lang.Math.round(rectF2.width());
            int iRound2 = java.lang.Math.round(rectF2.height());
            if (!zRectStaysRect) {
                suitableBitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
            }
            closeableReferenceCreateBitmap = createBitmap(iRound, iRound2, suitableBitmapConfig, !zRectStaysRect || bitmap.hasAlpha(), obj);
            setPropertyFromSourceBitmap(bitmap, closeableReferenceCreateBitmap.get());
            canvas = new android.graphics.Canvas(closeableReferenceCreateBitmap.get());
            canvas.translate(-rectF2.left, -rectF2.top);
            canvas.concat(matrix);
            paint = new android.graphics.Paint();
            paint.setFilterBitmap(z);
            if (!zRectStaysRect) {
                paint.setAntiAlias(true);
            }
        }
        canvas.drawBitmap(bitmap, rect, rectF, paint);
        canvas.setBitmap(null);
        return closeableReferenceCreateBitmap;
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(android.util.DisplayMetrics displayMetrics, int i, int i2, android.graphics.Bitmap.Config config) {
        return createBitmap(displayMetrics, i, i2, config, (java.lang.Object) null);
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(android.util.DisplayMetrics displayMetrics, int i, int i2, android.graphics.Bitmap.Config config, @javax.annotation.Nullable java.lang.Object obj) {
        return createBitmap(displayMetrics, i, i2, config, true, obj);
    }

    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(int i, int i2, android.graphics.Bitmap.Config config, boolean z) {
        return createBitmap(i, i2, config, z, (java.lang.Object) null);
    }

    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(int i, int i2, android.graphics.Bitmap.Config config, boolean z, @javax.annotation.Nullable java.lang.Object obj) {
        return createBitmap((android.util.DisplayMetrics) null, i, i2, config, z, obj);
    }

    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(android.util.DisplayMetrics displayMetrics, int i, int i2, android.graphics.Bitmap.Config config, boolean z) {
        return createBitmap(displayMetrics, i, i2, config, z, (java.lang.Object) null);
    }

    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(@javax.annotation.Nullable android.util.DisplayMetrics displayMetrics, int i, int i2, android.graphics.Bitmap.Config config, boolean z, @javax.annotation.Nullable java.lang.Object obj) {
        checkWidthHeight(i, i2);
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCreateBitmapInternal = createBitmapInternal(i, i2, config);
        android.graphics.Bitmap bitmap = closeableReferenceCreateBitmapInternal.get();
        if (displayMetrics != null) {
            bitmap.setDensity(displayMetrics.densityDpi);
        }
        bitmap.setHasAlpha(z);
        if (config == android.graphics.Bitmap.Config.ARGB_8888 && !z) {
            bitmap.eraseColor(-16777216);
        }
        return closeableReferenceCreateBitmapInternal;
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(int[] iArr, int i, int i2, android.graphics.Bitmap.Config config) {
        return createBitmap(iArr, i, i2, config, (java.lang.Object) null);
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(int[] iArr, int i, int i2, android.graphics.Bitmap.Config config, @javax.annotation.Nullable java.lang.Object obj) {
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCreateBitmapInternal = createBitmapInternal(i, i2, config);
        closeableReferenceCreateBitmapInternal.get().setPixels(iArr, 0, i, 0, 0, i, i2);
        return closeableReferenceCreateBitmapInternal;
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(android.util.DisplayMetrics displayMetrics, int[] iArr, int i, int i2, android.graphics.Bitmap.Config config) {
        return createBitmap(displayMetrics, iArr, i, i2, config, (java.lang.Object) null);
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(android.util.DisplayMetrics displayMetrics, int[] iArr, int i, int i2, android.graphics.Bitmap.Config config, @javax.annotation.Nullable java.lang.Object obj) {
        return createBitmap(displayMetrics, iArr, 0, i, i, i2, config, obj);
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(android.util.DisplayMetrics displayMetrics, int[] iArr, int i, int i2, int i3, int i4, android.graphics.Bitmap.Config config) {
        return createBitmap(displayMetrics, iArr, i, i2, i3, i4, config, (java.lang.Object) null);
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(android.util.DisplayMetrics displayMetrics, int[] iArr, int i, int i2, int i3, int i4, android.graphics.Bitmap.Config config, @javax.annotation.Nullable java.lang.Object obj) {
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCreateBitmap = createBitmap(displayMetrics, i3, i4, config, obj);
        closeableReferenceCreateBitmap.get().setPixels(iArr, i, i2, 0, 0, i3, i4);
        return closeableReferenceCreateBitmap;
    }

    private static android.graphics.Bitmap.Config getSuitableBitmapConfig(android.graphics.Bitmap bitmap) {
        android.graphics.Bitmap.Config config = android.graphics.Bitmap.Config.ARGB_8888;
        android.graphics.Bitmap.Config config2 = bitmap.getConfig();
        if (config2 == null) {
            return config;
        }
        int i = com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory.AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config2.ordinal()];
        if (i == 1) {
            return android.graphics.Bitmap.Config.RGB_565;
        }
        if (i == 2) {
            return android.graphics.Bitmap.Config.ALPHA_8;
        }
        return android.graphics.Bitmap.Config.ARGB_8888;
    }

    /* JADX INFO: renamed from: com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[android.graphics.Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[android.graphics.Bitmap.Config.RGB_565.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ALPHA_8.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    private static void checkWidthHeight(int i, int i2) {
        com.facebook.common.internal.Preconditions.checkArgument(i > 0, "width must be > 0");
        com.facebook.common.internal.Preconditions.checkArgument(i2 > 0, "height must be > 0");
    }

    private static void checkXYSign(int i, int i2) {
        com.facebook.common.internal.Preconditions.checkArgument(i >= 0, "x must be >= 0");
        com.facebook.common.internal.Preconditions.checkArgument(i2 >= 0, "y must be >= 0");
    }

    private static void checkFinalImageBounds(android.graphics.Bitmap bitmap, int i, int i2, int i3, int i4) {
        com.facebook.common.internal.Preconditions.checkArgument(i + i3 <= bitmap.getWidth(), "x + width must be <= bitmap.width()");
        com.facebook.common.internal.Preconditions.checkArgument(i2 + i4 <= bitmap.getHeight(), "y + height must be <= bitmap.height()");
    }

    private static void setPropertyFromSourceBitmap(android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2) {
        bitmap2.setDensity(bitmap.getDensity());
        bitmap2.setHasAlpha(bitmap.hasAlpha());
        bitmap2.setPremultiplied(bitmap.isPremultiplied());
    }
}
