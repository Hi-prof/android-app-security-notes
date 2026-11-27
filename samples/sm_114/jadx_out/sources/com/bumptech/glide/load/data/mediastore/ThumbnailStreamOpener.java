package com.bumptech.glide.load.data.mediastore;

/* JADX INFO: loaded from: classes.dex */
class ThumbnailStreamOpener {
    private static final com.bumptech.glide.load.data.mediastore.FileService DEFAULT_SERVICE = new com.bumptech.glide.load.data.mediastore.FileService();
    private static final java.lang.String TAG = "ThumbStreamOpener";
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool byteArrayPool;
    private final android.content.ContentResolver contentResolver;
    private final java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers;
    private final com.bumptech.glide.load.data.mediastore.ThumbnailQuery query;
    private final com.bumptech.glide.load.data.mediastore.FileService service;

    ThumbnailStreamOpener(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.data.mediastore.ThumbnailQuery thumbnailQuery, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool, android.content.ContentResolver contentResolver) {
        this(list, DEFAULT_SERVICE, thumbnailQuery, arrayPool, contentResolver);
    }

    ThumbnailStreamOpener(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.data.mediastore.FileService fileService, com.bumptech.glide.load.data.mediastore.ThumbnailQuery thumbnailQuery, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool, android.content.ContentResolver contentResolver) {
        this.service = fileService;
        this.query = thumbnailQuery;
        this.byteArrayPool = arrayPool;
        this.contentResolver = contentResolver;
        this.parsers = list;
    }

    int getOrientation(android.net.Uri uri) {
        java.io.InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.contentResolver.openInputStream(uri);
                return com.bumptech.glide.load.ImageHeaderParserUtils.getOrientation(this.parsers, inputStreamOpenInputStream, this.byteArrayPool);
            } finally {
                if (0 != 0) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (java.io.IOException unused) {
                    }
                }
            }
        } catch (java.io.IOException | java.lang.NullPointerException e) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                android.util.Log.d(TAG, "Failed to open uri: " + uri, e);
            }
            if (inputStreamOpenInputStream == null) {
                return -1;
            }
            try {
                inputStreamOpenInputStream.close();
                return -1;
            } catch (java.io.IOException unused2) {
                return -1;
            }
        }
    }

    public java.io.InputStream open(android.net.Uri uri) throws java.lang.Throwable {
        java.lang.String path = getPath(uri);
        if (android.text.TextUtils.isEmpty(path)) {
            return null;
        }
        java.io.File file = this.service.get(path);
        if (!isValid(file)) {
            return null;
        }
        android.net.Uri uriFromFile = android.net.Uri.fromFile(file);
        try {
            return this.contentResolver.openInputStream(uriFromFile);
        } catch (java.lang.NullPointerException e) {
            throw ((java.io.FileNotFoundException) new java.io.FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e));
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x004a  */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0047: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:28:0x0047 */
    private java.lang.String getPath(android.net.Uri uri) throws java.lang.Throwable {
        android.database.Cursor cursorQuery;
        android.database.Cursor cursor;
        android.database.Cursor cursor2 = null;
        try {
            try {
                cursorQuery = this.query.query(uri);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            java.lang.String string = cursorQuery.getString(0);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return string;
                        }
                    } catch (java.lang.SecurityException e) {
                        e = e;
                        if (android.util.Log.isLoggable(TAG, 3)) {
                            android.util.Log.d(TAG, "Failed to query for thumbnail for Uri: " + uri, e);
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            } catch (java.lang.Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (java.lang.SecurityException e2) {
            e = e2;
            cursorQuery = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    private boolean isValid(java.io.File file) {
        return this.service.exists(file) && 0 < this.service.length(file);
    }
}
