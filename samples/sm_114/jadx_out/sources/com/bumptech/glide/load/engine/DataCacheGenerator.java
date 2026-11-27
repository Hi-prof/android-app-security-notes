package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: classes.dex */
class DataCacheGenerator implements com.bumptech.glide.load.engine.DataFetcherGenerator, com.bumptech.glide.load.data.DataFetcher.DataCallback<java.lang.Object> {
    private java.io.File cacheFile;
    private final java.util.List<com.bumptech.glide.load.Key> cacheKeys;
    private final com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback cb;
    private final com.bumptech.glide.load.engine.DecodeHelper<?> helper;
    private volatile com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private java.util.List<com.bumptech.glide.load.model.ModelLoader<java.io.File, ?>> modelLoaders;
    private int sourceIdIndex;
    private com.bumptech.glide.load.Key sourceKey;

    DataCacheGenerator(com.bumptech.glide.load.engine.DecodeHelper<?> decodeHelper, com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(decodeHelper.getCacheKeys(), decodeHelper, fetcherReadyCallback);
    }

    DataCacheGenerator(java.util.List<com.bumptech.glide.load.Key> list, com.bumptech.glide.load.engine.DecodeHelper<?> decodeHelper, com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.sourceIdIndex = -1;
        this.cacheKeys = list;
        this.helper = decodeHelper;
        this.cb = fetcherReadyCallback;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        com.bumptech.glide.util.pool.GlideTrace.beginSection("DataCacheGenerator.startNext");
        while (true) {
            try {
                boolean z = false;
                if (this.modelLoaders != null && hasNextModelLoader()) {
                    this.loadData = null;
                    while (!z && hasNextModelLoader()) {
                        java.util.List<com.bumptech.glide.load.model.ModelLoader<java.io.File, ?>> list = this.modelLoaders;
                        int i = this.modelLoaderIndex;
                        this.modelLoaderIndex = i + 1;
                        this.loadData = list.get(i).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
                        if (this.loadData != null && this.helper.hasLoadPath(this.loadData.fetcher.getDataClass())) {
                            this.loadData.fetcher.loadData(this.helper.getPriority(), this);
                            z = true;
                        }
                    }
                    com.bumptech.glide.util.pool.GlideTrace.endSection();
                    return z;
                }
                int i2 = this.sourceIdIndex + 1;
                this.sourceIdIndex = i2;
                if (i2 < this.cacheKeys.size()) {
                    com.bumptech.glide.load.Key key = this.cacheKeys.get(this.sourceIdIndex);
                    java.io.File file = this.helper.getDiskCache().get(new com.bumptech.glide.load.engine.DataCacheKey(key, this.helper.getSignature()));
                    this.cacheFile = file;
                    if (file != null) {
                        this.sourceKey = key;
                        this.modelLoaders = this.helper.getModelLoaders(file);
                        this.modelLoaderIndex = 0;
                    }
                } else {
                    com.bumptech.glide.util.pool.GlideTrace.endSection();
                    return false;
                }
            } catch (java.lang.Throwable th) {
                com.bumptech.glide.util.pool.GlideTrace.endSection();
                throw th;
            }
        }
    }

    private boolean hasNextModelLoader() {
        return this.modelLoaderIndex < this.modelLoaders.size();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData = this.loadData;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(java.lang.Object obj) {
        this.cb.onDataFetcherReady(this.sourceKey, obj, this.loadData.fetcher, com.bumptech.glide.load.DataSource.DATA_DISK_CACHE, this.sourceKey);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(java.lang.Exception exc) {
        this.cb.onDataFetcherFailed(this.sourceKey, exc, this.loadData.fetcher, com.bumptech.glide.load.DataSource.DATA_DISK_CACHE);
    }
}
