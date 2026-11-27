package com.bumptech.glide.load.data.mediastore;

/* JADX INFO: loaded from: classes.dex */
public class ThumbFetcher implements com.bumptech.glide.load.data.DataFetcher<java.io.InputStream> {
    private static final java.lang.String TAG = "MediaStoreThumbFetcher";
    private java.io.InputStream inputStream;
    private final android.net.Uri mediaStoreImageUri;
    private final com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener opener;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    public static com.bumptech.glide.load.data.mediastore.ThumbFetcher buildImageFetcher(android.content.Context context, android.net.Uri uri) {
        return build(context, uri, new com.bumptech.glide.load.data.mediastore.ThumbFetcher.ImageThumbnailQuery(context.getContentResolver()));
    }

    public static com.bumptech.glide.load.data.mediastore.ThumbFetcher buildVideoFetcher(android.content.Context context, android.net.Uri uri) {
        return build(context, uri, new com.bumptech.glide.load.data.mediastore.ThumbFetcher.VideoThumbnailQuery(context.getContentResolver()));
    }

    private static com.bumptech.glide.load.data.mediastore.ThumbFetcher build(android.content.Context context, android.net.Uri uri, com.bumptech.glide.load.data.mediastore.ThumbnailQuery thumbnailQuery) {
        return new com.bumptech.glide.load.data.mediastore.ThumbFetcher(uri, new com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener(com.bumptech.glide.Glide.get(context).getRegistry().getImageHeaderParsers(), thumbnailQuery, com.bumptech.glide.Glide.get(context).getArrayPool(), context.getContentResolver()));
    }

    ThumbFetcher(android.net.Uri uri, com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener thumbnailStreamOpener) {
        this.mediaStoreImageUri = uri;
        this.opener = thumbnailStreamOpener;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(com.bumptech.glide.Priority priority, com.bumptech.glide.load.data.DataFetcher.DataCallback<? super java.io.InputStream> dataCallback) throws java.lang.Throwable {
        try {
            java.io.InputStream inputStreamOpenThumbInputStream = openThumbInputStream();
            this.inputStream = inputStreamOpenThumbInputStream;
            dataCallback.onDataReady(inputStreamOpenThumbInputStream);
        } catch (java.io.FileNotFoundException e) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                android.util.Log.d(TAG, "Failed to find thumbnail file", e);
            }
            dataCallback.onLoadFailed(e);
        }
    }

    private java.io.InputStream openThumbInputStream() throws java.lang.Throwable {
        java.io.InputStream inputStreamOpen = this.opener.open(this.mediaStoreImageUri);
        int orientation = inputStreamOpen != null ? this.opener.getOrientation(this.mediaStoreImageUri) : -1;
        return orientation != -1 ? new com.bumptech.glide.load.data.ExifOrientationStream(inputStreamOpen, orientation) : inputStreamOpen;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        java.io.InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public java.lang.Class<java.io.InputStream> getDataClass() {
        return java.io.InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public com.bumptech.glide.load.DataSource getDataSource() {
        return com.bumptech.glide.load.DataSource.LOCAL;
    }

    static class VideoThumbnailQuery implements com.bumptech.glide.load.data.mediastore.ThumbnailQuery {
        private static final java.lang.String[] PATH_PROJECTION = {"_data"};
        private static final java.lang.String PATH_SELECTION = "kind = 1 AND video_id = ?";
        private final android.content.ContentResolver contentResolver;

        VideoThumbnailQuery(android.content.ContentResolver contentResolver) {
            this.contentResolver = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public android.database.Cursor query(android.net.Uri uri) {
            return this.contentResolver.query(android.provider.MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new java.lang.String[]{uri.getLastPathSegment()}, null);
        }
    }

    static class ImageThumbnailQuery implements com.bumptech.glide.load.data.mediastore.ThumbnailQuery {
        private static final java.lang.String[] PATH_PROJECTION = {"_data"};
        private static final java.lang.String PATH_SELECTION = "kind = 1 AND image_id = ?";
        private final android.content.ContentResolver contentResolver;

        ImageThumbnailQuery(android.content.ContentResolver contentResolver) {
            this.contentResolver = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public android.database.Cursor query(android.net.Uri uri) {
            return this.contentResolver.query(android.provider.MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new java.lang.String[]{uri.getLastPathSegment()}, null);
        }
    }
}
