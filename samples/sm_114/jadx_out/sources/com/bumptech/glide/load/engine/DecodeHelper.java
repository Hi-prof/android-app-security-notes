package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: classes.dex */
final class DecodeHelper<Transcode> {
    private com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider diskCacheProvider;
    private com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy;
    private com.bumptech.glide.GlideContext glideContext;
    private int height;
    private boolean isCacheKeysSet;
    private boolean isLoadDataSet;
    private boolean isScaleOnlyOrNoTransform;
    private boolean isTransformationRequired;
    private java.lang.Object model;
    private com.bumptech.glide.load.Options options;
    private com.bumptech.glide.Priority priority;
    private java.lang.Class<?> resourceClass;
    private com.bumptech.glide.load.Key signature;
    private java.lang.Class<Transcode> transcodeClass;
    private java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> transformations;
    private int width;
    private final java.util.List<com.bumptech.glide.load.model.ModelLoader.LoadData<?>> loadData = new java.util.ArrayList();
    private final java.util.List<com.bumptech.glide.load.Key> cacheKeys = new java.util.ArrayList();

    DecodeHelper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> void init(com.bumptech.glide.GlideContext glideContext, java.lang.Object obj, com.bumptech.glide.load.Key key, int i, int i2, com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy, java.lang.Class<?> cls, java.lang.Class<R> cls2, com.bumptech.glide.Priority priority, com.bumptech.glide.load.Options options, java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> map, boolean z, boolean z2, com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider diskCacheProvider) {
        this.glideContext = glideContext;
        this.model = obj;
        this.signature = key;
        this.width = i;
        this.height = i2;
        this.diskCacheStrategy = diskCacheStrategy;
        this.resourceClass = cls;
        this.diskCacheProvider = diskCacheProvider;
        this.transcodeClass = cls2;
        this.priority = priority;
        this.options = options;
        this.transformations = map;
        this.isTransformationRequired = z;
        this.isScaleOnlyOrNoTransform = z2;
    }

    void clear() {
        this.glideContext = null;
        this.model = null;
        this.signature = null;
        this.resourceClass = null;
        this.transcodeClass = null;
        this.options = null;
        this.priority = null;
        this.transformations = null;
        this.diskCacheStrategy = null;
        this.loadData.clear();
        this.isLoadDataSet = false;
        this.cacheKeys.clear();
        this.isCacheKeysSet = false;
    }

    com.bumptech.glide.load.engine.cache.DiskCache getDiskCache() {
        return this.diskCacheProvider.getDiskCache();
    }

    com.bumptech.glide.load.engine.DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    <T> com.bumptech.glide.load.data.DataRewinder<T> getRewinder(T t) {
        return this.glideContext.getRegistry().getRewinder(t);
    }

    com.bumptech.glide.Priority getPriority() {
        return this.priority;
    }

    com.bumptech.glide.load.Options getOptions() {
        return this.options;
    }

    com.bumptech.glide.load.Key getSignature() {
        return this.signature;
    }

    int getWidth() {
        return this.width;
    }

    int getHeight() {
        return this.height;
    }

    com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool getArrayPool() {
        return this.glideContext.getArrayPool();
    }

    java.lang.Class<?> getTranscodeClass() {
        return this.transcodeClass;
    }

    java.lang.Class<?> getModelClass() {
        return this.model.getClass();
    }

    java.util.List<java.lang.Class<?>> getRegisteredResourceClasses() {
        return this.glideContext.getRegistry().getRegisteredResourceClasses(this.model.getClass(), this.resourceClass, this.transcodeClass);
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean hasLoadPath(java.lang.Class<?> cls) {
        return getLoadPath(cls) != null;
    }

    <Data> com.bumptech.glide.load.engine.LoadPath<Data, ?, Transcode> getLoadPath(java.lang.Class<Data> cls) {
        return this.glideContext.getRegistry().getLoadPath(cls, this.resourceClass, this.transcodeClass);
    }

    boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    <Z> com.bumptech.glide.load.Transformation<Z> getTransformation(java.lang.Class<Z> cls) {
        com.bumptech.glide.load.Transformation<Z> transformation = (com.bumptech.glide.load.Transformation) this.transformations.get(cls);
        if (transformation == null) {
            for (java.util.Map.Entry<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> entry : this.transformations.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    transformation = (com.bumptech.glide.load.Transformation) entry.getValue();
                    break;
                }
            }
        }
        if (transformation != null) {
            return transformation;
        }
        if (this.transformations.isEmpty() && this.isTransformationRequired) {
            throw new java.lang.IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
        }
        return com.bumptech.glide.load.resource.UnitTransformation.get();
    }

    boolean isResourceEncoderAvailable(com.bumptech.glide.load.engine.Resource<?> resource) {
        return this.glideContext.getRegistry().isResourceEncoderAvailable(resource);
    }

    <Z> com.bumptech.glide.load.ResourceEncoder<Z> getResultEncoder(com.bumptech.glide.load.engine.Resource<Z> resource) {
        return this.glideContext.getRegistry().getResultEncoder(resource);
    }

    java.util.List<com.bumptech.glide.load.model.ModelLoader<java.io.File, ?>> getModelLoaders(java.io.File file) throws com.bumptech.glide.Registry.NoModelLoaderAvailableException {
        return this.glideContext.getRegistry().getModelLoaders(file);
    }

    boolean isSourceKey(com.bumptech.glide.load.Key key) {
        java.util.List<com.bumptech.glide.load.model.ModelLoader.LoadData<?>> loadData = getLoadData();
        int size = loadData.size();
        for (int i = 0; i < size; i++) {
            if (loadData.get(i).sourceKey.equals(key)) {
                return true;
            }
        }
        return false;
    }

    java.util.List<com.bumptech.glide.load.model.ModelLoader.LoadData<?>> getLoadData() {
        if (!this.isLoadDataSet) {
            this.isLoadDataSet = true;
            this.loadData.clear();
            java.util.List modelLoaders = this.glideContext.getRegistry().getModelLoaders(this.model);
            int size = modelLoaders.size();
            for (int i = 0; i < size; i++) {
                com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadDataBuildLoadData = ((com.bumptech.glide.load.model.ModelLoader) modelLoaders.get(i)).buildLoadData(this.model, this.width, this.height, this.options);
                if (loadDataBuildLoadData != null) {
                    this.loadData.add(loadDataBuildLoadData);
                }
            }
        }
        return this.loadData;
    }

    java.util.List<com.bumptech.glide.load.Key> getCacheKeys() {
        if (!this.isCacheKeysSet) {
            this.isCacheKeysSet = true;
            this.cacheKeys.clear();
            java.util.List<com.bumptech.glide.load.model.ModelLoader.LoadData<?>> loadData = getLoadData();
            int size = loadData.size();
            for (int i = 0; i < size; i++) {
                com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData2 = loadData.get(i);
                if (!this.cacheKeys.contains(loadData2.sourceKey)) {
                    this.cacheKeys.add(loadData2.sourceKey);
                }
                for (int i2 = 0; i2 < loadData2.alternateKeys.size(); i2++) {
                    if (!this.cacheKeys.contains(loadData2.alternateKeys.get(i2))) {
                        this.cacheKeys.add(loadData2.alternateKeys.get(i2));
                    }
                }
            }
        }
        return this.cacheKeys;
    }

    <X> com.bumptech.glide.load.Encoder<X> getSourceEncoder(X x) throws com.bumptech.glide.Registry.NoSourceEncoderAvailableException {
        return this.glideContext.getRegistry().getSourceEncoder(x);
    }
}
