package com.facebook.common.webp;

/* JADX INFO: loaded from: classes.dex */
public interface WebpBitmapFactory {

    public interface WebpErrorLogger {
        void onWebpErrorLog(java.lang.String str, @javax.annotation.Nullable java.lang.String str2);
    }

    @javax.annotation.Nullable
    android.graphics.Bitmap decodeByteArray(byte[] bArr, int i, int i2, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options);

    @javax.annotation.Nullable
    android.graphics.Bitmap decodeFile(java.lang.String str, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options);

    @javax.annotation.Nullable
    android.graphics.Bitmap decodeFileDescriptor(java.io.FileDescriptor fileDescriptor, @javax.annotation.Nullable android.graphics.Rect rect, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options);

    @javax.annotation.Nullable
    android.graphics.Bitmap decodeStream(java.io.InputStream inputStream, @javax.annotation.Nullable android.graphics.Rect rect, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options);

    void setBitmapCreator(com.facebook.common.webp.BitmapCreator bitmapCreator);

    void setWebpErrorLogger(com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger webpErrorLogger);
}
