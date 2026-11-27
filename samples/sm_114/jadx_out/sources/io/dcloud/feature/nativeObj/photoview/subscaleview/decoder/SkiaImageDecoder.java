package io.dcloud.feature.nativeObj.photoview.subscaleview.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class SkiaImageDecoder implements io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageDecoder {
    private static final java.lang.String ASSET_PREFIX = "file:///android_asset/";
    private static final java.lang.String FILE_PREFIX = "file://";
    private static final java.lang.String RESOURCE_PREFIX = "android.resource://";
    private final android.graphics.Bitmap.Config bitmapConfig;

    public SkiaImageDecoder() {
        this(null);
    }

    @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageDecoder
    public android.graphics.Bitmap decode(android.content.Context context, android.net.Uri uri) throws java.lang.Exception {
        android.graphics.Bitmap bitmapDecodeFile;
        java.lang.String string = uri.toString();
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inPreferredConfig = this.bitmapConfig;
        if (string.startsWith(RESOURCE_PREFIX)) {
            java.lang.String authority = uri.getAuthority();
            android.content.res.Resources resources = context.getPackageName().equals(authority) ? context.getResources() : context.getPackageManager().getResourcesForApplication(authority);
            java.util.List<java.lang.String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            int identifier = 0;
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                identifier = resources.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else if (size == 1 && android.text.TextUtils.isDigitsOnly(pathSegments.get(0))) {
                try {
                    identifier = java.lang.Integer.parseInt(pathSegments.get(0));
                } catch (java.lang.NumberFormatException unused) {
                }
            }
            bitmapDecodeFile = android.graphics.BitmapFactory.decodeResource(context.getResources(), identifier, options);
        } else {
            java.io.InputStream inputStream = null;
            if (string.startsWith("file:///android_asset/")) {
                bitmapDecodeFile = android.graphics.BitmapFactory.decodeStream(context.getAssets().open(string.substring(22)), null, options);
            } else if (string.startsWith("file://")) {
                bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(string.substring(7), options);
            } else {
                try {
                    java.io.InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                    try {
                        android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (java.lang.Exception unused2) {
                            }
                        }
                        bitmapDecodeFile = bitmapDecodeStream;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        inputStream = inputStreamOpenInputStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.lang.Exception unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            }
        }
        if (bitmapDecodeFile != null) {
            return bitmapDecodeFile;
        }
        throw new java.lang.RuntimeException("Skia image region decoder returned null bitmap - image format may not be supported");
    }

    public SkiaImageDecoder(android.graphics.Bitmap.Config config) {
        android.graphics.Bitmap.Config preferredBitmapConfig = io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.bitmapConfig = config;
        } else if (preferredBitmapConfig != null) {
            this.bitmapConfig = preferredBitmapConfig;
        } else {
            this.bitmapConfig = android.graphics.Bitmap.Config.RGB_565;
        }
    }
}
