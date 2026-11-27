package com.bumptech.glide.load.resource.drawable;

/* JADX INFO: loaded from: classes.dex */
public class ResourceDrawableDecoder implements com.bumptech.glide.load.ResourceDecoder<android.net.Uri, android.graphics.drawable.Drawable> {
    private static final java.lang.String ANDROID_PACKAGE_NAME = "android";
    private static final int ID_PATH_SEGMENTS = 1;
    private static final int MISSING_RESOURCE_ID = 0;
    private static final int NAME_PATH_SEGMENT_INDEX = 1;
    private static final int NAME_URI_PATH_SEGMENTS = 2;
    private static final int RESOURCE_ID_SEGMENT_INDEX = 0;
    public static final com.bumptech.glide.load.Option<android.content.res.Resources.Theme> THEME = com.bumptech.glide.load.Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme");
    private static final int TYPE_PATH_SEGMENT_INDEX = 0;
    private final android.content.Context context;

    public ResourceDrawableDecoder(android.content.Context context) {
        this.context = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(android.net.Uri uri, com.bumptech.glide.load.Options options) {
        java.lang.String scheme = uri.getScheme();
        return scheme != null && scheme.equals(com.facebook.common.util.UriUtil.QUALIFIED_RESOURCE_SCHEME);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> decode(android.net.Uri uri, int i, int i2, com.bumptech.glide.load.Options options) {
        android.graphics.drawable.Drawable drawable;
        java.lang.String authority = uri.getAuthority();
        if (android.text.TextUtils.isEmpty(authority)) {
            throw new java.lang.IllegalStateException("Package name for " + uri + " is null or empty");
        }
        android.content.Context contextFindContextForPackage = findContextForPackage(uri, authority);
        int iFindResourceIdFromUri = findResourceIdFromUri(contextFindContextForPackage, uri);
        android.content.res.Resources.Theme theme = ((java.lang.String) com.bumptech.glide.util.Preconditions.checkNotNull(authority)).equals(this.context.getPackageName()) ? (android.content.res.Resources.Theme) options.get(THEME) : null;
        if (theme == null) {
            drawable = com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat.getDrawable(this.context, contextFindContextForPackage, iFindResourceIdFromUri);
        } else {
            drawable = com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat.getDrawable(this.context, iFindResourceIdFromUri, theme);
        }
        return com.bumptech.glide.load.resource.drawable.NonOwnedDrawableResource.newInstance(drawable);
    }

    private android.content.Context findContextForPackage(android.net.Uri uri, java.lang.String str) {
        if (str.equals(this.context.getPackageName())) {
            return this.context;
        }
        try {
            return this.context.createPackageContext(str, 0);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            if (str.contains(this.context.getPackageName())) {
                return this.context;
            }
            throw new java.lang.IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
        }
    }

    private int findResourceIdFromUri(android.content.Context context, android.net.Uri uri) {
        java.util.List<java.lang.String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return findResourceIdFromTypeAndNameResourceUri(context, uri);
        }
        if (pathSegments.size() == 1) {
            return findResourceIdFromResourceIdUri(uri);
        }
        throw new java.lang.IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    private int findResourceIdFromTypeAndNameResourceUri(android.content.Context context, android.net.Uri uri) {
        java.util.List<java.lang.String> pathSegments = uri.getPathSegments();
        java.lang.String authority = uri.getAuthority();
        java.lang.String str = pathSegments.get(0);
        java.lang.String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = android.content.res.Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new java.lang.IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    private int findResourceIdFromResourceIdUri(android.net.Uri uri) {
        try {
            return java.lang.Integer.parseInt(uri.getPathSegments().get(0));
        } catch (java.lang.NumberFormatException e) {
            throw new java.lang.IllegalArgumentException("Unrecognized Uri format: " + uri, e);
        }
    }
}
