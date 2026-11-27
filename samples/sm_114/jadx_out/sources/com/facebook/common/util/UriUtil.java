package com.facebook.common.util;

/* JADX INFO: loaded from: classes.dex */
public class UriUtil {
    public static final java.lang.String DATA_SCHEME = "data";
    public static final java.lang.String HTTPS_SCHEME = "https";
    public static final java.lang.String HTTP_SCHEME = "http";
    public static final java.lang.String LOCAL_ASSET_SCHEME = "asset";
    private static final android.net.Uri LOCAL_CONTACT_IMAGE_URI = android.net.Uri.withAppendedPath((android.net.Uri) com.facebook.infer.annotation.Assertions.assumeNotNull(android.provider.ContactsContract.AUTHORITY_URI), "display_photo");
    public static final java.lang.String LOCAL_CONTENT_SCHEME = "content";
    public static final java.lang.String LOCAL_FILE_SCHEME = "file";
    public static final java.lang.String LOCAL_RESOURCE_SCHEME = "res";
    public static final java.lang.String QUALIFIED_RESOURCE_SCHEME = "android.resource";

    @javax.annotation.Nullable
    public static java.net.URL uriToUrl(@javax.annotation.Nullable android.net.Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new java.net.URL(uri.toString());
        } catch (java.net.MalformedURLException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static boolean isNetworkUri(@javax.annotation.Nullable android.net.Uri uri) {
        java.lang.String schemeOrNull = getSchemeOrNull(uri);
        return "https".equals(schemeOrNull) || "http".equals(schemeOrNull);
    }

    public static boolean isLocalFileUri(@javax.annotation.Nullable android.net.Uri uri) {
        return "file".equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalContentUri(@javax.annotation.Nullable android.net.Uri uri) {
        return LOCAL_CONTENT_SCHEME.equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalContactUri(android.net.Uri uri) {
        return uri.getPath() != null && isLocalContentUri(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith((java.lang.String) com.facebook.infer.annotation.Assertions.assumeNotNull(LOCAL_CONTACT_IMAGE_URI.getPath()));
    }

    public static boolean isLocalCameraUri(android.net.Uri uri) {
        java.lang.String string = uri.toString();
        return string.startsWith(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || string.startsWith(android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
    }

    public static boolean isLocalAssetUri(@javax.annotation.Nullable android.net.Uri uri) {
        return LOCAL_ASSET_SCHEME.equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalResourceUri(@javax.annotation.Nullable android.net.Uri uri) {
        return LOCAL_RESOURCE_SCHEME.equals(getSchemeOrNull(uri));
    }

    public static boolean isQualifiedResourceUri(@javax.annotation.Nullable android.net.Uri uri) {
        return QUALIFIED_RESOURCE_SCHEME.equals(getSchemeOrNull(uri));
    }

    public static boolean isDataUri(@javax.annotation.Nullable android.net.Uri uri) {
        return "data".equals(getSchemeOrNull(uri));
    }

    @javax.annotation.Nullable
    public static java.lang.String getSchemeOrNull(@javax.annotation.Nullable android.net.Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getScheme();
    }

    @javax.annotation.Nullable
    public static android.net.Uri parseUriOrNull(@javax.annotation.Nullable java.lang.String str) {
        if (str != null) {
            return android.net.Uri.parse(str);
        }
        return null;
    }

    @javax.annotation.Nullable
    public static java.lang.String getRealPathFromUri(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        android.net.Uri uri2;
        java.lang.String str;
        java.lang.String[] strArr;
        int columnIndexOrThrow;
        java.lang.String type = contentResolver.getType(uri);
        java.lang.String string = null;
        if (isLocalContentUri(uri)) {
            boolean z = type != null && type.startsWith("video/");
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                java.lang.String documentId = android.provider.DocumentsContract.getDocumentId(uri);
                com.facebook.common.internal.Preconditions.checkNotNull(documentId);
                uri2 = (android.net.Uri) com.facebook.common.internal.Preconditions.checkNotNull(getExternalContentUri(z));
                str = getMediaIdString(z) + "=?";
                strArr = new java.lang.String[]{documentId.split(":")[1]};
            } else {
                uri2 = uri;
                str = null;
                strArr = null;
            }
            android.database.Cursor cursorQuery = contentResolver.query(uri2, new java.lang.String[]{getDataPathString(z)}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst() && (columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow(getDataPathString(z))) != -1) {
                        string = cursorQuery.getString(columnIndexOrThrow);
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
            return string;
        }
        if (isLocalFileUri(uri)) {
            return uri.getPath();
        }
        return null;
    }

    private static android.net.Uri getExternalContentUri(boolean z) {
        if (z) {
            return android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        return android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    private static java.lang.String getMediaIdString(boolean z) {
        return "_id";
    }

    private static java.lang.String getDataPathString(boolean z) {
        return "_data";
    }

    @javax.annotation.Nullable
    public static android.content.res.AssetFileDescriptor getAssetFileDescriptor(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        if (isLocalContentUri(uri)) {
            try {
                return contentResolver.openAssetFileDescriptor(uri, "r");
            } catch (java.io.FileNotFoundException unused) {
            }
        }
        return null;
    }

    public static android.net.Uri getUriForFile(java.io.File file) {
        return android.net.Uri.fromFile(file);
    }

    public static android.net.Uri getUriForResourceId(int i) {
        return new android.net.Uri.Builder().scheme(LOCAL_RESOURCE_SCHEME).path(java.lang.String.valueOf(i)).build();
    }

    public static android.net.Uri getUriForQualifiedResource(java.lang.String str, int i) {
        return new android.net.Uri.Builder().scheme(QUALIFIED_RESOURCE_SCHEME).authority(str).path(java.lang.String.valueOf(i)).build();
    }
}
