package com.facebook.imagepipeline.filter;

/* JADX INFO: compiled from: InPlaceRoundFilter.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/imagepipeline/filter/InPlaceRoundFilter;", "", "<init>", "()V", "roundBitmapInPlace", "", "bitmap", "Landroid/graphics/Bitmap;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InPlaceRoundFilter {
    public static final com.facebook.imagepipeline.filter.InPlaceRoundFilter INSTANCE = new com.facebook.imagepipeline.filter.InPlaceRoundFilter();

    private InPlaceRoundFilter() {
    }

    @kotlin.jvm.JvmStatic
    public static final void roundBitmapInPlace(android.graphics.Bitmap bitmap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMin = java.lang.Math.min(width, height) / 2;
        int i = width / 2;
        int i2 = height / 2;
        if (iMin == 0) {
            return;
        }
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(iMin >= 1));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(width > 0 && ((float) width) <= 2048.0f));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(height > 0 && ((float) height) <= 2048.0f));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i > 0 && i < width));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i2 > 0 && i2 < height));
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = iMin - 1;
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i - i3 >= 0 && i2 - i3 >= 0 && i + i3 < width && i2 + i3 < height));
        int i4 = (-iMin) * 2;
        int[] iArr2 = new int[width];
        int i5 = i4 + 1;
        int i6 = 0;
        int i7 = 1;
        int i8 = 1;
        while (i3 >= i6) {
            int i9 = i + i3;
            int i10 = i - i3;
            int i11 = i + i6;
            iMin = iMin;
            int i12 = i - i6;
            int i13 = i2 + i3;
            int i14 = i2 - i3;
            int i15 = i3;
            int i16 = i2 + i6;
            int i17 = i2 - i6;
            com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i15 >= 0 && i11 < width && i12 >= 0 && i16 < height && i17 >= 0));
            int i18 = i16 * width;
            int i19 = i4;
            int i20 = width * i17;
            int i21 = i5;
            int i22 = width * i13;
            int i23 = i6;
            int i24 = width * i14;
            i = i;
            java.lang.System.arraycopy(iArr2, 0, iArr, i18, i10);
            java.lang.System.arraycopy(iArr2, 0, iArr, i20, i10);
            java.lang.System.arraycopy(iArr2, 0, iArr, i22, i12);
            java.lang.System.arraycopy(iArr2, 0, iArr, i24, i12);
            int i25 = width - i9;
            java.lang.System.arraycopy(iArr2, 0, iArr, i18 + i9, i25);
            java.lang.System.arraycopy(iArr2, 0, iArr, i20 + i9, i25);
            int i26 = width - i11;
            java.lang.System.arraycopy(iArr2, 0, iArr, i22 + i11, i26);
            java.lang.System.arraycopy(iArr2, 0, iArr, i24 + i11, i26);
            if (i21 <= 0) {
                i6 = i23 + 1;
                i8 += 2;
                i5 = i21 + i8;
            } else {
                i6 = i23;
                i5 = i21;
            }
            if (i5 > 0) {
                i3 = i15 - 1;
                i7 += 2;
                i5 += i7 + i19;
            } else {
                i3 = i15;
            }
            i4 = i19;
        }
        int i27 = iMin;
        for (int i28 = i2 - i27; -1 < i28; i28--) {
            java.lang.System.arraycopy(iArr2, 0, iArr, i28 * width, width);
        }
        for (int i29 = i2 + i27; i29 < height; i29++) {
            java.lang.System.arraycopy(iArr2, 0, iArr, i29 * width, width);
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
    }
}
