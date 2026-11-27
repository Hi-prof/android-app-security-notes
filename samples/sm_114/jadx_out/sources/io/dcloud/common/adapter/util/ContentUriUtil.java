package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ContentUriUtil {
    public static boolean isDownloadsDocument(android.net.Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(android.net.Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(android.net.Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(android.net.Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static java.lang.String getDataColumn(android.content.Context context, android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) throws java.lang.Throwable {
        java.lang.Throwable th;
        android.database.Cursor cursor = null;
        try {
            android.database.Cursor cursorQuery = context.getContentResolver().query(uri, new java.lang.String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        cursorQuery.close();
                        return string;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor == null) {
                        throw th;
                    }
                    cursor.close();
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    public static java.lang.String getImageAbsolutePath(android.content.Context context, android.net.Uri uri) {
        android.net.Uri uri2 = null;
        if (context != null && uri != null) {
            if (android.provider.DocumentsContract.isDocumentUri(context, uri)) {
                if (isMediaDocument(uri)) {
                    java.lang.String[] strArrSplit = android.provider.DocumentsContract.getDocumentId(uri).split(":");
                    java.lang.String str = strArrSplit[0];
                    if ("image".equals(str)) {
                        uri2 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new java.lang.String[]{strArrSplit[1]});
                }
                if (isExternalStorageDocument(uri)) {
                    java.lang.String[] strArrSplit2 = android.provider.DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit2[0])) {
                        return android.os.Environment.getExternalStorageDirectory() + "/" + strArrSplit2[1];
                    }
                } else if (isDownloadsDocument(uri)) {
                    return getDataColumn(context, android.content.ContentUris.withAppendedId(android.net.Uri.parse("content://downloads/public_downloads"), java.lang.Long.valueOf(android.provider.DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                }
            } else {
                if (com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME.equalsIgnoreCase(uri.getScheme())) {
                    return isGooglePhotosUri(uri) ? uri.getLastPathSegment() : getDataColumn(context, uri, null, null);
                }
                if ("file".equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            }
        }
        return null;
    }
}
