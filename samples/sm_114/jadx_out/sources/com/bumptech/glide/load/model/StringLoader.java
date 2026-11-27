package com.bumptech.glide.load.model;

/* JADX INFO: loaded from: classes.dex */
public class StringLoader<Data> implements com.bumptech.glide.load.model.ModelLoader<java.lang.String, Data> {
    private final com.bumptech.glide.load.model.ModelLoader<android.net.Uri, Data> uriLoader;

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(java.lang.String str) {
        return true;
    }

    public StringLoader(com.bumptech.glide.load.model.ModelLoader<android.net.Uri, Data> modelLoader) {
        this.uriLoader = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<Data> buildLoadData(java.lang.String str, int i, int i2, com.bumptech.glide.load.Options options) {
        android.net.Uri uri = parseUri(str);
        if (uri == null || !this.uriLoader.handles(uri)) {
            return null;
        }
        return this.uriLoader.buildLoadData(uri, i, i2, options);
    }

    private static android.net.Uri parseUri(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return toFileUri(str);
        }
        android.net.Uri uri = android.net.Uri.parse(str);
        return uri.getScheme() == null ? toFileUri(str) : uri;
    }

    private static android.net.Uri toFileUri(java.lang.String str) {
        return android.net.Uri.fromFile(new java.io.File(str));
    }

    public static class StreamFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.String, java.io.InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public com.bumptech.glide.load.model.ModelLoader<java.lang.String, java.io.InputStream> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.StringLoader(multiModelLoaderFactory.build(android.net.Uri.class, java.io.InputStream.class));
        }
    }

    public static class FileDescriptorFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.String, android.os.ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public com.bumptech.glide.load.model.ModelLoader<java.lang.String, android.os.ParcelFileDescriptor> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.StringLoader(multiModelLoaderFactory.build(android.net.Uri.class, android.os.ParcelFileDescriptor.class));
        }
    }

    public static final class AssetFileDescriptorFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.String, android.content.res.AssetFileDescriptor> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public com.bumptech.glide.load.model.ModelLoader<java.lang.String, android.content.res.AssetFileDescriptor> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.StringLoader(multiModelLoaderFactory.build(android.net.Uri.class, android.content.res.AssetFileDescriptor.class));
        }
    }
}
