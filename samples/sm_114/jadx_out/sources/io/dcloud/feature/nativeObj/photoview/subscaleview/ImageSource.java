package io.dcloud.feature.nativeObj.photoview.subscaleview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public final class ImageSource {
    static final java.lang.String ASSET_SCHEME = "file:///android_asset/";
    static final java.lang.String FILE_SCHEME = "file:///";
    private final android.graphics.Bitmap bitmap;
    private boolean cached;
    private final java.lang.Integer resource;
    private int sHeight;
    private android.graphics.Rect sRegion;
    private int sWidth;
    private boolean tile;
    private final android.net.Uri uri;

    private ImageSource(android.graphics.Bitmap bitmap, boolean z) {
        this.bitmap = bitmap;
        this.uri = null;
        this.resource = null;
        this.tile = false;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
        this.cached = z;
    }

    public static io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource asset(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("Asset name must not be null");
        }
        return uri("file:///android_asset/" + str);
    }

    public static io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource bitmap(android.graphics.Bitmap bitmap) {
        if (bitmap != null) {
            return new io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource(bitmap, false);
        }
        throw new java.lang.NullPointerException("Bitmap must not be null");
    }

    public static io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource cachedBitmap(android.graphics.Bitmap bitmap) {
        if (bitmap != null) {
            return new io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource(bitmap, true);
        }
        throw new java.lang.NullPointerException("Bitmap must not be null");
    }

    public static io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource resource(int i) {
        return new io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource(i);
    }

    private void setInvariants() {
        android.graphics.Rect rect = this.sRegion;
        if (rect != null) {
            this.tile = true;
            this.sWidth = rect.width();
            this.sHeight = this.sRegion.height();
        }
    }

    public static io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource uri(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("Uri must not be null");
        }
        if (!str.contains("://")) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            str = FILE_SCHEME + str;
        }
        return new io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource(android.net.Uri.parse(str));
    }

    public io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource dimensions(int i, int i2) {
        if (this.bitmap == null) {
            this.sWidth = i;
            this.sHeight = i2;
        }
        setInvariants();
        return this;
    }

    protected final android.graphics.Bitmap getBitmap() {
        return this.bitmap;
    }

    protected final java.lang.Integer getResource() {
        return this.resource;
    }

    protected final int getSHeight() {
        return this.sHeight;
    }

    protected final android.graphics.Rect getSRegion() {
        return this.sRegion;
    }

    protected final int getSWidth() {
        return this.sWidth;
    }

    protected final boolean getTile() {
        return this.tile;
    }

    protected final android.net.Uri getUri() {
        return this.uri;
    }

    protected final boolean isCached() {
        return this.cached;
    }

    public io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource region(android.graphics.Rect rect) {
        this.sRegion = rect;
        setInvariants();
        return this;
    }

    public io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource tiling(boolean z) {
        this.tile = z;
        return this;
    }

    public io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource tilingDisabled() {
        return tiling(false);
    }

    public io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource tilingEnabled() {
        return tiling(true);
    }

    private ImageSource(android.net.Uri uri) {
        java.lang.String string = uri.toString();
        if (string.startsWith(FILE_SCHEME) && !new java.io.File(string.substring(7)).exists()) {
            try {
                uri = android.net.Uri.parse(java.net.URLDecoder.decode(string, "UTF-8"));
            } catch (java.io.UnsupportedEncodingException unused) {
            }
        }
        this.bitmap = null;
        this.uri = uri;
        this.resource = null;
        this.tile = true;
    }

    public static io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource uri(android.net.Uri uri) {
        if (uri != null) {
            return new io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource(uri);
        }
        throw new java.lang.NullPointerException("Uri must not be null");
    }

    private ImageSource(int i) {
        this.bitmap = null;
        this.uri = null;
        this.resource = java.lang.Integer.valueOf(i);
        this.tile = true;
    }
}
