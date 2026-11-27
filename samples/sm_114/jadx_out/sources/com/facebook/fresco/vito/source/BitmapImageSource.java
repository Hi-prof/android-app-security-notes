package com.facebook.fresco.vito.source;

/* JADX INFO: compiled from: BitmapImageSource.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/facebook/fresco/vito/source/BitmapImageSource;", "Lcom/facebook/fresco/vito/source/ImageSource;", "bitmap", "Landroid/graphics/Bitmap;", "<init>", "(Landroid/graphics/Bitmap;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "equals", "", "other", "", "hashCode", "", "component1", "copy", "toString", "", "source_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class BitmapImageSource implements com.facebook.fresco.vito.source.ImageSource {
    private final android.graphics.Bitmap bitmap;

    public static /* synthetic */ com.facebook.fresco.vito.source.BitmapImageSource copy$default(com.facebook.fresco.vito.source.BitmapImageSource bitmapImageSource, android.graphics.Bitmap bitmap, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            bitmap = bitmapImageSource.bitmap;
        }
        return bitmapImageSource.copy(bitmap);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final android.graphics.Bitmap getBitmap() {
        return this.bitmap;
    }

    public final com.facebook.fresco.vito.source.BitmapImageSource copy(android.graphics.Bitmap bitmap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return new com.facebook.fresco.vito.source.BitmapImageSource(bitmap);
    }

    public java.lang.String toString() {
        return "BitmapImageSource(bitmap=" + this.bitmap + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
    }

    public BitmapImageSource(android.graphics.Bitmap bitmap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.bitmap = bitmap;
    }

    public final android.graphics.Bitmap getBitmap() {
        return this.bitmap;
    }

    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!kotlin.jvm.internal.Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        android.graphics.Bitmap bitmap = this.bitmap;
        kotlin.jvm.internal.Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.facebook.fresco.vito.source.BitmapImageSource");
        return kotlin.jvm.internal.Intrinsics.areEqual(bitmap, ((com.facebook.fresco.vito.source.BitmapImageSource) other).bitmap);
    }

    public int hashCode() {
        return this.bitmap.hashCode();
    }
}
