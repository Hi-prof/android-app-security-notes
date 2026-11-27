package com.bumptech.glide.load.model;

/* JADX INFO: loaded from: classes.dex */
public final class DirectResourceLoader<DataT> implements com.bumptech.glide.load.model.ModelLoader<java.lang.Integer, DataT> {
    private final android.content.Context context;
    private final com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener<DataT> resourceOpener;

    private interface ResourceOpener<DataT> {
        void close(DataT datat) throws java.io.IOException;

        java.lang.Class<DataT> getDataClass();

        DataT open(android.content.res.Resources.Theme theme, android.content.res.Resources resources, int i);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(java.lang.Integer num) {
        return true;
    }

    public static com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.Integer, java.io.InputStream> inputStreamFactory(android.content.Context context) {
        return new com.bumptech.glide.load.model.DirectResourceLoader.InputStreamFactory(context);
    }

    public static com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.Integer, android.content.res.AssetFileDescriptor> assetFileDescriptorFactory(android.content.Context context) {
        return new com.bumptech.glide.load.model.DirectResourceLoader.AssetFileDescriptorFactory(context);
    }

    public static com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.Integer, android.graphics.drawable.Drawable> drawableFactory(android.content.Context context) {
        return new com.bumptech.glide.load.model.DirectResourceLoader.DrawableFactory(context);
    }

    DirectResourceLoader(android.content.Context context, com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener<DataT> resourceOpener) {
        this.context = context.getApplicationContext();
        this.resourceOpener = resourceOpener;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<DataT> buildLoadData(java.lang.Integer num, int i, int i2, com.bumptech.glide.load.Options options) {
        android.content.res.Resources resources;
        android.content.res.Resources.Theme theme = (android.content.res.Resources.Theme) options.get(com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder.THEME);
        if (theme != null) {
            resources = theme.getResources();
        } else {
            resources = this.context.getResources();
        }
        return new com.bumptech.glide.load.model.ModelLoader.LoadData<>(new com.bumptech.glide.signature.ObjectKey(num), new com.bumptech.glide.load.model.DirectResourceLoader.ResourceDataFetcher(theme, resources, this.resourceOpener, num.intValue()));
    }

    private static final class AssetFileDescriptorFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.Integer, android.content.res.AssetFileDescriptor>, com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener<android.content.res.AssetFileDescriptor> {
        private final android.content.Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        AssetFileDescriptorFactory(android.content.Context context) {
            this.context = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public android.content.res.AssetFileDescriptor open(android.content.res.Resources.Theme theme, android.content.res.Resources resources, int i) {
            return resources.openRawResourceFd(i);
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public void close(android.content.res.AssetFileDescriptor assetFileDescriptor) throws java.io.IOException {
            assetFileDescriptor.close();
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public java.lang.Class<android.content.res.AssetFileDescriptor> getDataClass() {
            return android.content.res.AssetFileDescriptor.class;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public com.bumptech.glide.load.model.ModelLoader<java.lang.Integer, android.content.res.AssetFileDescriptor> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.DirectResourceLoader(this.context, this);
        }
    }

    private static final class InputStreamFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.Integer, java.io.InputStream>, com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener<java.io.InputStream> {
        private final android.content.Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        InputStreamFactory(android.content.Context context) {
            this.context = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public com.bumptech.glide.load.model.ModelLoader<java.lang.Integer, java.io.InputStream> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.DirectResourceLoader(this.context, this);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public java.io.InputStream open(android.content.res.Resources.Theme theme, android.content.res.Resources resources, int i) {
            return resources.openRawResource(i);
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public void close(java.io.InputStream inputStream) throws java.io.IOException {
            inputStream.close();
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public java.lang.Class<java.io.InputStream> getDataClass() {
            return java.io.InputStream.class;
        }
    }

    private static final class DrawableFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.Integer, android.graphics.drawable.Drawable>, com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener<android.graphics.drawable.Drawable> {
        private final android.content.Context context;

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public void close(android.graphics.drawable.Drawable drawable) throws java.io.IOException {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        DrawableFactory(android.content.Context context) {
            this.context = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public android.graphics.drawable.Drawable open(android.content.res.Resources.Theme theme, android.content.res.Resources resources, int i) {
            return com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat.getDrawable(this.context, i, theme);
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public java.lang.Class<android.graphics.drawable.Drawable> getDataClass() {
            return android.graphics.drawable.Drawable.class;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public com.bumptech.glide.load.model.ModelLoader<java.lang.Integer, android.graphics.drawable.Drawable> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.DirectResourceLoader(this.context, this);
        }
    }

    private static final class ResourceDataFetcher<DataT> implements com.bumptech.glide.load.data.DataFetcher<DataT> {
        private DataT data;
        private final int resourceId;
        private final com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener<DataT> resourceOpener;
        private final android.content.res.Resources resources;
        private final android.content.res.Resources.Theme theme;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        ResourceDataFetcher(android.content.res.Resources.Theme theme, android.content.res.Resources resources, com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener<DataT> resourceOpener, int i) {
            this.theme = theme;
            this.resources = resources;
            this.resourceOpener = resourceOpener;
            this.resourceId = i;
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [DataT, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(com.bumptech.glide.Priority priority, com.bumptech.glide.load.data.DataFetcher.DataCallback<? super DataT> dataCallback) {
            try {
                DataT datatOpen = this.resourceOpener.open(this.theme, this.resources, this.resourceId);
                this.data = datatOpen;
                dataCallback.onDataReady(datatOpen);
            } catch (android.content.res.Resources.NotFoundException e) {
                dataCallback.onLoadFailed(e);
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            DataT datat = this.data;
            if (datat != null) {
                try {
                    this.resourceOpener.close(datat);
                } catch (java.io.IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public java.lang.Class<DataT> getDataClass() {
            return this.resourceOpener.getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public com.bumptech.glide.load.DataSource getDataSource() {
            return com.bumptech.glide.load.DataSource.LOCAL;
        }
    }
}
