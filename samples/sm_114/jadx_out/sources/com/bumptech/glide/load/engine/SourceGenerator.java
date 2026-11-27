package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: classes.dex */
class SourceGenerator implements com.bumptech.glide.load.engine.DataFetcherGenerator, com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback {
    private static final java.lang.String TAG = "SourceGenerator";
    private final com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback cb;
    private volatile java.lang.Object dataToCache;
    private final com.bumptech.glide.load.engine.DecodeHelper<?> helper;
    private volatile com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData;
    private volatile int loadDataListIndex;
    private volatile com.bumptech.glide.load.engine.DataCacheKey originalKey;
    private volatile com.bumptech.glide.load.engine.DataCacheGenerator sourceCacheGenerator;

    SourceGenerator(com.bumptech.glide.load.engine.DecodeHelper<?> decodeHelper, com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.helper = decodeHelper;
        this.cb = fetcherReadyCallback;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        if (this.dataToCache != null) {
            java.lang.Object obj = this.dataToCache;
            this.dataToCache = null;
            try {
                if (!cacheData(obj)) {
                    return true;
                }
            } catch (java.io.IOException e) {
                if (android.util.Log.isLoggable(TAG, 3)) {
                    android.util.Log.d(TAG, "Failed to properly rewind or write data to cache", e);
                }
            }
        }
        if (this.sourceCacheGenerator != null && this.sourceCacheGenerator.startNext()) {
            return true;
        }
        this.sourceCacheGenerator = null;
        this.loadData = null;
        boolean z = false;
        while (!z && hasNextModelLoader()) {
            java.util.List<com.bumptech.glide.load.model.ModelLoader.LoadData<?>> loadData = this.helper.getLoadData();
            int i = this.loadDataListIndex;
            this.loadDataListIndex = i + 1;
            this.loadData = loadData.get(i);
            if (this.loadData != null && (this.helper.getDiskCacheStrategy().isDataCacheable(this.loadData.fetcher.getDataSource()) || this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()))) {
                startNextLoad(this.loadData);
                z = true;
            }
        }
        return z;
    }

    private void startNextLoad(final com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData) {
        this.loadData.fetcher.loadData(this.helper.getPriority(), new com.bumptech.glide.load.data.DataFetcher.DataCallback<java.lang.Object>() { // from class: com.bumptech.glide.load.engine.SourceGenerator.1
            @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
            public void onDataReady(java.lang.Object obj) {
                if (com.bumptech.glide.load.engine.SourceGenerator.this.isCurrentRequest(loadData)) {
                    com.bumptech.glide.load.engine.SourceGenerator.this.onDataReadyInternal(loadData, obj);
                }
            }

            @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
            public void onLoadFailed(java.lang.Exception exc) {
                if (com.bumptech.glide.load.engine.SourceGenerator.this.isCurrentRequest(loadData)) {
                    com.bumptech.glide.load.engine.SourceGenerator.this.onLoadFailedInternal(loadData, exc);
                }
            }
        });
    }

    boolean isCurrentRequest(com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData) {
        com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData2 = this.loadData;
        return loadData2 != null && loadData2 == loadData;
    }

    private boolean hasNextModelLoader() {
        return this.loadDataListIndex < this.helper.getLoadData().size();
    }

    private boolean cacheData(java.lang.Object obj) throws java.lang.Throwable {
        java.lang.Throwable th;
        long logTime = com.bumptech.glide.util.LogTime.getLogTime();
        boolean z = false;
        try {
            com.bumptech.glide.load.data.DataRewinder<T> rewinder = this.helper.getRewinder(obj);
            java.lang.Object objRewindAndGet = rewinder.rewindAndGet();
            com.bumptech.glide.load.Encoder<X> sourceEncoder = this.helper.getSourceEncoder(objRewindAndGet);
            com.bumptech.glide.load.engine.DataCacheWriter dataCacheWriter = new com.bumptech.glide.load.engine.DataCacheWriter(sourceEncoder, objRewindAndGet, this.helper.getOptions());
            com.bumptech.glide.load.engine.DataCacheKey dataCacheKey = new com.bumptech.glide.load.engine.DataCacheKey(this.loadData.sourceKey, this.helper.getSignature());
            com.bumptech.glide.load.engine.cache.DiskCache diskCache = this.helper.getDiskCache();
            diskCache.put(dataCacheKey, dataCacheWriter);
            if (android.util.Log.isLoggable(TAG, 2)) {
                android.util.Log.v(TAG, "Finished encoding source to cache, key: " + dataCacheKey + ", data: " + obj + ", encoder: " + sourceEncoder + ", duration: " + com.bumptech.glide.util.LogTime.getElapsedMillis(logTime));
            }
            if (diskCache.get(dataCacheKey) != null) {
                this.originalKey = dataCacheKey;
                this.sourceCacheGenerator = new com.bumptech.glide.load.engine.DataCacheGenerator(java.util.Collections.singletonList(this.loadData.sourceKey), this.helper, this);
                this.loadData.fetcher.cleanup();
                return true;
            }
            if (android.util.Log.isLoggable(TAG, 3)) {
                android.util.Log.d(TAG, "Attempt to write: " + this.originalKey + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.cb.onDataFetcherReady(this.loadData.sourceKey, rewinder.rewindAndGet(), this.loadData.fetcher, this.loadData.fetcher.getDataSource(), this.loadData.sourceKey);
                return false;
            } catch (java.lang.Throwable th2) {
                th = th2;
                z = true;
                if (z) {
                    throw th;
                }
                this.loadData.fetcher.cleanup();
                throw th;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData = this.loadData;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    void onDataReadyInternal(com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData, java.lang.Object obj) {
        com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy = this.helper.getDiskCacheStrategy();
        if (obj != null && diskCacheStrategy.isDataCacheable(loadData.fetcher.getDataSource())) {
            this.dataToCache = obj;
            this.cb.reschedule();
        } else {
            this.cb.onDataFetcherReady(loadData.sourceKey, obj, loadData.fetcher, loadData.fetcher.getDataSource(), this.originalKey);
        }
    }

    void onLoadFailedInternal(com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData, java.lang.Exception exc) {
        this.cb.onDataFetcherFailed(this.originalKey, exc, loadData.fetcher, loadData.fetcher.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(com.bumptech.glide.load.Key key, java.lang.Object obj, com.bumptech.glide.load.data.DataFetcher<?> dataFetcher, com.bumptech.glide.load.DataSource dataSource, com.bumptech.glide.load.Key key2) {
        this.cb.onDataFetcherReady(key, obj, dataFetcher, this.loadData.fetcher.getDataSource(), key);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(com.bumptech.glide.load.Key key, java.lang.Exception exc, com.bumptech.glide.load.data.DataFetcher<?> dataFetcher, com.bumptech.glide.load.DataSource dataSource) {
        this.cb.onDataFetcherFailed(key, exc, dataFetcher, this.loadData.fetcher.getDataSource());
    }
}
