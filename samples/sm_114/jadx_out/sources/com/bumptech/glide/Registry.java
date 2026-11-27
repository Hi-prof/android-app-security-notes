package com.bumptech.glide;

/* JADX INFO: loaded from: classes.dex */
public class Registry {
    public static final java.lang.String BUCKET_ANIMATION = "Animation";
    private static final java.lang.String BUCKET_APPEND_ALL = "legacy_append";
    public static final java.lang.String BUCKET_BITMAP = "Bitmap";
    public static final java.lang.String BUCKET_BITMAP_DRAWABLE = "BitmapDrawable";

    @java.lang.Deprecated
    public static final java.lang.String BUCKET_GIF = "Animation";
    private static final java.lang.String BUCKET_PREPEND_ALL = "legacy_prepend_all";
    private final com.bumptech.glide.load.data.DataRewinderRegistry dataRewinderRegistry;
    private final com.bumptech.glide.provider.ResourceDecoderRegistry decoderRegistry;
    private final com.bumptech.glide.provider.EncoderRegistry encoderRegistry;
    private final com.bumptech.glide.provider.ImageHeaderParserRegistry imageHeaderParserRegistry;
    private final com.bumptech.glide.load.model.ModelLoaderRegistry modelLoaderRegistry;
    private final com.bumptech.glide.provider.ResourceEncoderRegistry resourceEncoderRegistry;
    private final androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> throwableListPool;
    private final com.bumptech.glide.load.resource.transcode.TranscoderRegistry transcoderRegistry;
    private final com.bumptech.glide.provider.ModelToResourceClassCache modelToResourceClassCache = new com.bumptech.glide.provider.ModelToResourceClassCache();
    private final com.bumptech.glide.provider.LoadPathCache loadPathCache = new com.bumptech.glide.provider.LoadPathCache();

    public Registry() {
        androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> poolThreadSafeList = com.bumptech.glide.util.pool.FactoryPools.threadSafeList();
        this.throwableListPool = poolThreadSafeList;
        this.modelLoaderRegistry = new com.bumptech.glide.load.model.ModelLoaderRegistry(poolThreadSafeList);
        this.encoderRegistry = new com.bumptech.glide.provider.EncoderRegistry();
        this.decoderRegistry = new com.bumptech.glide.provider.ResourceDecoderRegistry();
        this.resourceEncoderRegistry = new com.bumptech.glide.provider.ResourceEncoderRegistry();
        this.dataRewinderRegistry = new com.bumptech.glide.load.data.DataRewinderRegistry();
        this.transcoderRegistry = new com.bumptech.glide.load.resource.transcode.TranscoderRegistry();
        this.imageHeaderParserRegistry = new com.bumptech.glide.provider.ImageHeaderParserRegistry();
        setResourceDecoderBucketPriorityList(java.util.Arrays.asList("Animation", BUCKET_BITMAP, BUCKET_BITMAP_DRAWABLE));
    }

    @java.lang.Deprecated
    public <Data> com.bumptech.glide.Registry register(java.lang.Class<Data> cls, com.bumptech.glide.load.Encoder<Data> encoder) {
        return append(cls, encoder);
    }

    public <Data> com.bumptech.glide.Registry append(java.lang.Class<Data> cls, com.bumptech.glide.load.Encoder<Data> encoder) {
        this.encoderRegistry.append(cls, encoder);
        return this;
    }

    public <Data> com.bumptech.glide.Registry prepend(java.lang.Class<Data> cls, com.bumptech.glide.load.Encoder<Data> encoder) {
        this.encoderRegistry.prepend(cls, encoder);
        return this;
    }

    public <Data, TResource> com.bumptech.glide.Registry append(java.lang.Class<Data> cls, java.lang.Class<TResource> cls2, com.bumptech.glide.load.ResourceDecoder<Data, TResource> resourceDecoder) {
        append(BUCKET_APPEND_ALL, cls, cls2, resourceDecoder);
        return this;
    }

    public <Data, TResource> com.bumptech.glide.Registry append(java.lang.String str, java.lang.Class<Data> cls, java.lang.Class<TResource> cls2, com.bumptech.glide.load.ResourceDecoder<Data, TResource> resourceDecoder) {
        this.decoderRegistry.append(str, resourceDecoder, cls, cls2);
        return this;
    }

    public <Data, TResource> com.bumptech.glide.Registry prepend(java.lang.Class<Data> cls, java.lang.Class<TResource> cls2, com.bumptech.glide.load.ResourceDecoder<Data, TResource> resourceDecoder) {
        prepend(BUCKET_PREPEND_ALL, cls, cls2, resourceDecoder);
        return this;
    }

    public <Data, TResource> com.bumptech.glide.Registry prepend(java.lang.String str, java.lang.Class<Data> cls, java.lang.Class<TResource> cls2, com.bumptech.glide.load.ResourceDecoder<Data, TResource> resourceDecoder) {
        this.decoderRegistry.prepend(str, resourceDecoder, cls, cls2);
        return this;
    }

    public final com.bumptech.glide.Registry setResourceDecoderBucketPriorityList(java.util.List<java.lang.String> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        arrayList.add(BUCKET_PREPEND_ALL);
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add(BUCKET_APPEND_ALL);
        this.decoderRegistry.setBucketPriorityList(arrayList);
        return this;
    }

    @java.lang.Deprecated
    public <TResource> com.bumptech.glide.Registry register(java.lang.Class<TResource> cls, com.bumptech.glide.load.ResourceEncoder<TResource> resourceEncoder) {
        return append((java.lang.Class) cls, (com.bumptech.glide.load.ResourceEncoder) resourceEncoder);
    }

    public <TResource> com.bumptech.glide.Registry append(java.lang.Class<TResource> cls, com.bumptech.glide.load.ResourceEncoder<TResource> resourceEncoder) {
        this.resourceEncoderRegistry.append(cls, resourceEncoder);
        return this;
    }

    public <TResource> com.bumptech.glide.Registry prepend(java.lang.Class<TResource> cls, com.bumptech.glide.load.ResourceEncoder<TResource> resourceEncoder) {
        this.resourceEncoderRegistry.prepend(cls, resourceEncoder);
        return this;
    }

    public com.bumptech.glide.Registry register(com.bumptech.glide.load.data.DataRewinder.Factory<?> factory) {
        this.dataRewinderRegistry.register(factory);
        return this;
    }

    public <TResource, Transcode> com.bumptech.glide.Registry register(java.lang.Class<TResource> cls, java.lang.Class<Transcode> cls2, com.bumptech.glide.load.resource.transcode.ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.transcoderRegistry.register(cls, cls2, resourceTranscoder);
        return this;
    }

    public com.bumptech.glide.Registry register(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) {
        this.imageHeaderParserRegistry.add(imageHeaderParser);
        return this;
    }

    public <Model, Data> com.bumptech.glide.Registry append(java.lang.Class<Model> cls, java.lang.Class<Data> cls2, com.bumptech.glide.load.model.ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.modelLoaderRegistry.append(cls, cls2, modelLoaderFactory);
        return this;
    }

    public <Model, Data> com.bumptech.glide.Registry prepend(java.lang.Class<Model> cls, java.lang.Class<Data> cls2, com.bumptech.glide.load.model.ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.modelLoaderRegistry.prepend(cls, cls2, modelLoaderFactory);
        return this;
    }

    public <Model, Data> com.bumptech.glide.Registry replace(java.lang.Class<Model> cls, java.lang.Class<Data> cls2, com.bumptech.glide.load.model.ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.modelLoaderRegistry.replace(cls, cls2, modelLoaderFactory);
        return this;
    }

    public <Data, TResource, Transcode> com.bumptech.glide.load.engine.LoadPath<Data, TResource, Transcode> getLoadPath(java.lang.Class<Data> cls, java.lang.Class<TResource> cls2, java.lang.Class<Transcode> cls3) {
        java.lang.Class<Data> cls4;
        java.lang.Class<TResource> cls5;
        java.lang.Class<Transcode> cls6;
        com.bumptech.glide.load.engine.LoadPath<Data, TResource, Transcode> loadPath = this.loadPathCache.get(cls, cls2, cls3);
        com.bumptech.glide.load.engine.LoadPath<Data, TResource, Transcode> loadPath2 = null;
        if (this.loadPathCache.isEmptyLoadPath(loadPath)) {
            return null;
        }
        if (loadPath != null) {
            return loadPath;
        }
        java.util.List<com.bumptech.glide.load.engine.DecodePath<Data, TResource, Transcode>> decodePaths = getDecodePaths(cls, cls2, cls3);
        if (decodePaths.isEmpty()) {
            cls4 = cls;
            cls5 = cls2;
            cls6 = cls3;
        } else {
            cls4 = cls;
            cls5 = cls2;
            cls6 = cls3;
            loadPath2 = new com.bumptech.glide.load.engine.LoadPath<>(cls4, cls5, cls6, decodePaths, this.throwableListPool);
        }
        this.loadPathCache.put(cls4, cls5, cls6, loadPath2);
        return loadPath2;
    }

    private <Data, TResource, Transcode> java.util.List<com.bumptech.glide.load.engine.DecodePath<Data, TResource, Transcode>> getDecodePaths(java.lang.Class<Data> cls, java.lang.Class<TResource> cls2, java.lang.Class<Transcode> cls3) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Class cls4 : this.decoderRegistry.getResourceClasses(cls, cls2)) {
            for (java.lang.Class cls5 : this.transcoderRegistry.getTranscodeClasses(cls4, cls3)) {
                arrayList.add(new com.bumptech.glide.load.engine.DecodePath(cls, cls4, cls5, this.decoderRegistry.getDecoders(cls, cls4), this.transcoderRegistry.get(cls4, cls5), this.throwableListPool));
            }
        }
        return arrayList;
    }

    public <Model, TResource, Transcode> java.util.List<java.lang.Class<?>> getRegisteredResourceClasses(java.lang.Class<Model> cls, java.lang.Class<TResource> cls2, java.lang.Class<Transcode> cls3) {
        java.util.List<java.lang.Class<?>> arrayList = this.modelToResourceClassCache.get(cls, cls2, cls3);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
            java.util.Iterator<java.lang.Class<?>> it = this.modelLoaderRegistry.getDataClasses(cls).iterator();
            while (it.hasNext()) {
                for (java.lang.Class<?> cls4 : this.decoderRegistry.getResourceClasses(it.next(), cls2)) {
                    if (!this.transcoderRegistry.getTranscodeClasses(cls4, cls3).isEmpty() && !arrayList.contains(cls4)) {
                        arrayList.add(cls4);
                    }
                }
            }
            this.modelToResourceClassCache.put(cls, cls2, cls3, java.util.Collections.unmodifiableList(arrayList));
        }
        return arrayList;
    }

    public boolean isResourceEncoderAvailable(com.bumptech.glide.load.engine.Resource<?> resource) {
        return this.resourceEncoderRegistry.get(resource.getResourceClass()) != null;
    }

    public <X> com.bumptech.glide.load.ResourceEncoder<X> getResultEncoder(com.bumptech.glide.load.engine.Resource<X> resource) throws com.bumptech.glide.Registry.NoResultEncoderAvailableException {
        com.bumptech.glide.load.ResourceEncoder<X> resourceEncoder = this.resourceEncoderRegistry.get(resource.getResourceClass());
        if (resourceEncoder != null) {
            return resourceEncoder;
        }
        throw new com.bumptech.glide.Registry.NoResultEncoderAvailableException(resource.getResourceClass());
    }

    public <X> com.bumptech.glide.load.Encoder<X> getSourceEncoder(X x) throws com.bumptech.glide.Registry.NoSourceEncoderAvailableException {
        com.bumptech.glide.load.Encoder<X> encoder = this.encoderRegistry.getEncoder(x.getClass());
        if (encoder != null) {
            return encoder;
        }
        throw new com.bumptech.glide.Registry.NoSourceEncoderAvailableException(x.getClass());
    }

    public <X> com.bumptech.glide.load.data.DataRewinder<X> getRewinder(X x) {
        return this.dataRewinderRegistry.build(x);
    }

    public <Model> java.util.List<com.bumptech.glide.load.model.ModelLoader<Model, ?>> getModelLoaders(Model model) {
        return this.modelLoaderRegistry.getModelLoaders(model);
    }

    public java.util.List<com.bumptech.glide.load.ImageHeaderParser> getImageHeaderParsers() {
        java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers = this.imageHeaderParserRegistry.getParsers();
        if (parsers.isEmpty()) {
            throw new com.bumptech.glide.Registry.NoImageHeaderParserException();
        }
        return parsers;
    }

    public static class NoModelLoaderAvailableException extends com.bumptech.glide.Registry.MissingComponentException {
        public NoModelLoaderAvailableException(java.lang.Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(M m, java.util.List<com.bumptech.glide.load.model.ModelLoader<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }

        public NoModelLoaderAvailableException(java.lang.Class<?> cls, java.lang.Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends com.bumptech.glide.Registry.MissingComponentException {
        public NoResultEncoderAvailableException(java.lang.Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends com.bumptech.glide.Registry.MissingComponentException {
        public NoSourceEncoderAvailableException(java.lang.Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public static class MissingComponentException extends java.lang.RuntimeException {
        public MissingComponentException(java.lang.String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends com.bumptech.glide.Registry.MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }
}
