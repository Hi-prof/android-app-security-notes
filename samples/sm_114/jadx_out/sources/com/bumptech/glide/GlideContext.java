package com.bumptech.glide;

/* JADX INFO: loaded from: classes.dex */
public class GlideContext extends android.content.ContextWrapper {
    static final com.bumptech.glide.TransitionOptions<?, ?> DEFAULT_TRANSITION_OPTIONS = new com.bumptech.glide.GenericTransitionOptions();
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool;
    private final java.util.List<com.bumptech.glide.request.RequestListener<java.lang.Object>> defaultRequestListeners;
    private com.bumptech.glide.request.RequestOptions defaultRequestOptions;
    private final com.bumptech.glide.Glide.RequestOptionsFactory defaultRequestOptionsFactory;
    private final java.util.Map<java.lang.Class<?>, com.bumptech.glide.TransitionOptions<?, ?>> defaultTransitionOptions;
    private final com.bumptech.glide.load.engine.Engine engine;
    private final com.bumptech.glide.GlideExperiments experiments;
    private final com.bumptech.glide.request.target.ImageViewTargetFactory imageViewTargetFactory;
    private final int logLevel;
    private final com.bumptech.glide.util.GlideSuppliers.GlideSupplier<com.bumptech.glide.Registry> registry;

    public GlideContext(android.content.Context context, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool, com.bumptech.glide.util.GlideSuppliers.GlideSupplier<com.bumptech.glide.Registry> glideSupplier, com.bumptech.glide.request.target.ImageViewTargetFactory imageViewTargetFactory, com.bumptech.glide.Glide.RequestOptionsFactory requestOptionsFactory, java.util.Map<java.lang.Class<?>, com.bumptech.glide.TransitionOptions<?, ?>> map, java.util.List<com.bumptech.glide.request.RequestListener<java.lang.Object>> list, com.bumptech.glide.load.engine.Engine engine, com.bumptech.glide.GlideExperiments glideExperiments, int i) {
        super(context.getApplicationContext());
        this.arrayPool = arrayPool;
        this.imageViewTargetFactory = imageViewTargetFactory;
        this.defaultRequestOptionsFactory = requestOptionsFactory;
        this.defaultRequestListeners = list;
        this.defaultTransitionOptions = map;
        this.engine = engine;
        this.experiments = glideExperiments;
        this.logLevel = i;
        this.registry = com.bumptech.glide.util.GlideSuppliers.memorize(glideSupplier);
    }

    public java.util.List<com.bumptech.glide.request.RequestListener<java.lang.Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    public synchronized com.bumptech.glide.request.RequestOptions getDefaultRequestOptions() {
        if (this.defaultRequestOptions == null) {
            this.defaultRequestOptions = this.defaultRequestOptionsFactory.build().lock();
        }
        return this.defaultRequestOptions;
    }

    public <T> com.bumptech.glide.TransitionOptions<?, T> getDefaultTransitionOptions(java.lang.Class<T> cls) {
        com.bumptech.glide.TransitionOptions<?, T> transitionOptions = (com.bumptech.glide.TransitionOptions) this.defaultTransitionOptions.get(cls);
        if (transitionOptions == null) {
            for (java.util.Map.Entry<java.lang.Class<?>, com.bumptech.glide.TransitionOptions<?, ?>> entry : this.defaultTransitionOptions.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    transitionOptions = (com.bumptech.glide.TransitionOptions) entry.getValue();
                }
            }
        }
        return transitionOptions == null ? (com.bumptech.glide.TransitionOptions<?, T>) DEFAULT_TRANSITION_OPTIONS : transitionOptions;
    }

    public <X> com.bumptech.glide.request.target.ViewTarget<android.widget.ImageView, X> buildImageViewTarget(android.widget.ImageView imageView, java.lang.Class<X> cls) {
        return this.imageViewTargetFactory.buildTarget(imageView, cls);
    }

    public com.bumptech.glide.load.engine.Engine getEngine() {
        return this.engine;
    }

    public com.bumptech.glide.Registry getRegistry() {
        return this.registry.get();
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    public com.bumptech.glide.GlideExperiments getExperiments() {
        return this.experiments;
    }
}
