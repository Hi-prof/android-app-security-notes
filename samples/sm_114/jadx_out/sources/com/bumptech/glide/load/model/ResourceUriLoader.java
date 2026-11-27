package com.bumptech.glide.load.model;

/* JADX INFO: loaded from: classes.dex */
public final class ResourceUriLoader<DataT> implements com.bumptech.glide.load.model.ModelLoader<android.net.Uri, DataT> {
    private static final int INVALID_RESOURCE_ID = 0;
    private static final java.lang.String TAG = "ResourceUriLoader";
    private final android.content.Context context;
    private final com.bumptech.glide.load.model.ModelLoader<java.lang.Integer, DataT> delegate;

    public static com.bumptech.glide.load.model.ModelLoaderFactory<android.net.Uri, java.io.InputStream> newStreamFactory(android.content.Context context) {
        return new com.bumptech.glide.load.model.ResourceUriLoader.InputStreamFactory(context);
    }

    public static com.bumptech.glide.load.model.ModelLoaderFactory<android.net.Uri, android.content.res.AssetFileDescriptor> newAssetFileDescriptorFactory(android.content.Context context) {
        return new com.bumptech.glide.load.model.ResourceUriLoader.AssetFileDescriptorFactory(context);
    }

    ResourceUriLoader(android.content.Context context, com.bumptech.glide.load.model.ModelLoader<java.lang.Integer, DataT> modelLoader) {
        this.context = context.getApplicationContext();
        this.delegate = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<DataT> buildLoadData(android.net.Uri uri, int i, int i2, com.bumptech.glide.load.Options options) {
        java.util.List<java.lang.String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 1) {
            return parseResourceIdUri(uri, i, i2, options);
        }
        if (pathSegments.size() == 2) {
            return parseResourceNameUri(uri, i, i2, options);
        }
        if (!android.util.Log.isLoggable(TAG, 5)) {
            return null;
        }
        android.util.Log.w(TAG, "Failed to parse resource uri: " + uri);
        return null;
    }

    private com.bumptech.glide.load.model.ModelLoader.LoadData<DataT> parseResourceNameUri(android.net.Uri uri, int i, int i2, com.bumptech.glide.load.Options options) {
        java.util.List<java.lang.String> pathSegments = uri.getPathSegments();
        int identifier = this.context.getResources().getIdentifier(pathSegments.get(1), pathSegments.get(0), this.context.getPackageName());
        if (identifier == 0) {
            if (!android.util.Log.isLoggable(TAG, 5)) {
                return null;
            }
            android.util.Log.w(TAG, "Failed to find resource id for: " + uri);
            return null;
        }
        return this.delegate.buildLoadData(java.lang.Integer.valueOf(identifier), i, i2, options);
    }

    private com.bumptech.glide.load.model.ModelLoader.LoadData<DataT> parseResourceIdUri(android.net.Uri uri, int i, int i2, com.bumptech.glide.load.Options options) {
        try {
            int i3 = java.lang.Integer.parseInt(uri.getPathSegments().get(0));
            if (i3 != 0) {
                return this.delegate.buildLoadData(java.lang.Integer.valueOf(i3), i, i2, options);
            }
            if (android.util.Log.isLoggable(TAG, 5)) {
                android.util.Log.w(TAG, "Failed to parse a valid non-0 resource id from: " + uri);
            }
            return null;
        } catch (java.lang.NumberFormatException e) {
            if (android.util.Log.isLoggable(TAG, 5)) {
                android.util.Log.w(TAG, "Failed to parse resource id from: " + uri, e);
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(android.net.Uri uri) {
        return com.facebook.common.util.UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(uri.getScheme()) && this.context.getPackageName().equals(uri.getAuthority());
    }

    private static final class InputStreamFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<android.net.Uri, java.io.InputStream> {
        private final android.content.Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        InputStreamFactory(android.content.Context context) {
            this.context = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public com.bumptech.glide.load.model.ModelLoader<android.net.Uri, java.io.InputStream> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.ResourceUriLoader(this.context, multiModelLoaderFactory.build(java.lang.Integer.class, java.io.InputStream.class));
        }
    }

    private static final class AssetFileDescriptorFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<android.net.Uri, android.content.res.AssetFileDescriptor> {
        private final android.content.Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        AssetFileDescriptorFactory(android.content.Context context) {
            this.context = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public com.bumptech.glide.load.model.ModelLoader<android.net.Uri, android.content.res.AssetFileDescriptor> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.ResourceUriLoader(this.context, multiModelLoaderFactory.build(java.lang.Integer.class, android.content.res.AssetFileDescriptor.class));
        }
    }
}
