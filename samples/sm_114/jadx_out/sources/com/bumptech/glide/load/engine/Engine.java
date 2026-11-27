package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: classes.dex */
public class Engine implements com.bumptech.glide.load.engine.EngineJobListener, com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener, com.bumptech.glide.load.engine.EngineResource.ResourceListener {
    private static final int JOB_POOL_SIZE = 150;
    private static final java.lang.String TAG = "Engine";
    private static final boolean VERBOSE_IS_LOGGABLE = android.util.Log.isLoggable(TAG, 2);
    private final com.bumptech.glide.load.engine.ActiveResources activeResources;
    private final com.bumptech.glide.load.engine.cache.MemoryCache cache;
    private final com.bumptech.glide.load.engine.Engine.DecodeJobFactory decodeJobFactory;
    private final com.bumptech.glide.load.engine.Engine.LazyDiskCacheProvider diskCacheProvider;
    private final com.bumptech.glide.load.engine.Engine.EngineJobFactory engineJobFactory;
    private final com.bumptech.glide.load.engine.Jobs jobs;
    private final com.bumptech.glide.load.engine.EngineKeyFactory keyFactory;
    private final com.bumptech.glide.load.engine.ResourceRecycler resourceRecycler;

    public Engine(com.bumptech.glide.load.engine.cache.MemoryCache memoryCache, com.bumptech.glide.load.engine.cache.DiskCache.Factory factory, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor2, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor3, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor4, boolean z) {
        this(memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, null, null, null, null, null, null, z);
    }

    Engine(com.bumptech.glide.load.engine.cache.MemoryCache memoryCache, com.bumptech.glide.load.engine.cache.DiskCache.Factory factory, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor2, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor3, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor4, com.bumptech.glide.load.engine.Jobs jobs, com.bumptech.glide.load.engine.EngineKeyFactory engineKeyFactory, com.bumptech.glide.load.engine.ActiveResources activeResources, com.bumptech.glide.load.engine.Engine.EngineJobFactory engineJobFactory, com.bumptech.glide.load.engine.Engine.DecodeJobFactory decodeJobFactory, com.bumptech.glide.load.engine.ResourceRecycler resourceRecycler, boolean z) {
        this.cache = memoryCache;
        com.bumptech.glide.load.engine.Engine.LazyDiskCacheProvider lazyDiskCacheProvider = new com.bumptech.glide.load.engine.Engine.LazyDiskCacheProvider(factory);
        this.diskCacheProvider = lazyDiskCacheProvider;
        com.bumptech.glide.load.engine.ActiveResources activeResources2 = activeResources == null ? new com.bumptech.glide.load.engine.ActiveResources(z) : activeResources;
        this.activeResources = activeResources2;
        activeResources2.setListener(this);
        this.keyFactory = engineKeyFactory == null ? new com.bumptech.glide.load.engine.EngineKeyFactory() : engineKeyFactory;
        this.jobs = jobs == null ? new com.bumptech.glide.load.engine.Jobs() : jobs;
        this.engineJobFactory = engineJobFactory == null ? new com.bumptech.glide.load.engine.Engine.EngineJobFactory(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this, this) : engineJobFactory;
        this.decodeJobFactory = decodeJobFactory == null ? new com.bumptech.glide.load.engine.Engine.DecodeJobFactory(lazyDiskCacheProvider) : decodeJobFactory;
        this.resourceRecycler = resourceRecycler == null ? new com.bumptech.glide.load.engine.ResourceRecycler() : resourceRecycler;
        memoryCache.setResourceRemovedListener(this);
    }

    public <R> com.bumptech.glide.load.engine.Engine.LoadStatus load(com.bumptech.glide.GlideContext glideContext, java.lang.Object obj, com.bumptech.glide.load.Key key, int i, int i2, java.lang.Class<?> cls, java.lang.Class<R> cls2, com.bumptech.glide.Priority priority, com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy, java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> map, boolean z, boolean z2, com.bumptech.glide.load.Options options, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.request.ResourceCallback resourceCallback, java.util.concurrent.Executor executor) {
        long logTime = VERBOSE_IS_LOGGABLE ? com.bumptech.glide.util.LogTime.getLogTime() : 0L;
        com.bumptech.glide.load.engine.EngineKey engineKeyBuildKey = this.keyFactory.buildKey(obj, key, i, i2, map, cls, cls2, options);
        synchronized (this) {
            com.bumptech.glide.load.engine.EngineResource<?> engineResourceLoadFromMemory = loadFromMemory(engineKeyBuildKey, z3, logTime);
            if (engineResourceLoadFromMemory == null) {
                return waitForExistingOrStartNewJob(glideContext, obj, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, options, z3, z4, z5, z6, resourceCallback, executor, engineKeyBuildKey, logTime);
            }
            resourceCallback.onResourceReady(engineResourceLoadFromMemory, com.bumptech.glide.load.DataSource.MEMORY_CACHE, false);
            return null;
        }
    }

    private <R> com.bumptech.glide.load.engine.Engine.LoadStatus waitForExistingOrStartNewJob(com.bumptech.glide.GlideContext glideContext, java.lang.Object obj, com.bumptech.glide.load.Key key, int i, int i2, java.lang.Class<?> cls, java.lang.Class<R> cls2, com.bumptech.glide.Priority priority, com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy, java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> map, boolean z, boolean z2, com.bumptech.glide.load.Options options, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.request.ResourceCallback resourceCallback, java.util.concurrent.Executor executor, com.bumptech.glide.load.engine.EngineKey engineKey, long j) {
        com.bumptech.glide.load.engine.EngineJob<?> engineJob = this.jobs.get(engineKey, z6);
        if (engineJob != null) {
            engineJob.addCallback(resourceCallback, executor);
            if (VERBOSE_IS_LOGGABLE) {
                logWithTimeAndKey("Added to existing load", j, engineKey);
            }
            return new com.bumptech.glide.load.engine.Engine.LoadStatus(resourceCallback, engineJob);
        }
        com.bumptech.glide.load.engine.EngineJob<R> engineJobBuild = this.engineJobFactory.build(engineKey, z3, z4, z5, z6);
        com.bumptech.glide.load.engine.DecodeJob<R> decodeJobBuild = this.decodeJobFactory.build(glideContext, obj, engineKey, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, z6, options, engineJobBuild);
        this.jobs.put(engineKey, engineJobBuild);
        engineJobBuild.addCallback(resourceCallback, executor);
        engineJobBuild.start(decodeJobBuild);
        if (VERBOSE_IS_LOGGABLE) {
            logWithTimeAndKey("Started new load", j, engineKey);
        }
        return new com.bumptech.glide.load.engine.Engine.LoadStatus(resourceCallback, engineJobBuild);
    }

    private com.bumptech.glide.load.engine.EngineResource<?> loadFromMemory(com.bumptech.glide.load.engine.EngineKey engineKey, boolean z, long j) {
        if (!z) {
            return null;
        }
        com.bumptech.glide.load.engine.EngineResource<?> engineResourceLoadFromActiveResources = loadFromActiveResources(engineKey);
        if (engineResourceLoadFromActiveResources != null) {
            if (VERBOSE_IS_LOGGABLE) {
                logWithTimeAndKey("Loaded resource from active resources", j, engineKey);
            }
            return engineResourceLoadFromActiveResources;
        }
        com.bumptech.glide.load.engine.EngineResource<?> engineResourceLoadFromCache = loadFromCache(engineKey);
        if (engineResourceLoadFromCache == null) {
            return null;
        }
        if (VERBOSE_IS_LOGGABLE) {
            logWithTimeAndKey("Loaded resource from cache", j, engineKey);
        }
        return engineResourceLoadFromCache;
    }

    private static void logWithTimeAndKey(java.lang.String str, long j, com.bumptech.glide.load.Key key) {
        android.util.Log.v(TAG, str + " in " + com.bumptech.glide.util.LogTime.getElapsedMillis(j) + "ms, key: " + key);
    }

    private com.bumptech.glide.load.engine.EngineResource<?> loadFromActiveResources(com.bumptech.glide.load.Key key) {
        com.bumptech.glide.load.engine.EngineResource<?> engineResource = this.activeResources.get(key);
        if (engineResource != null) {
            engineResource.acquire();
        }
        return engineResource;
    }

    private com.bumptech.glide.load.engine.EngineResource<?> loadFromCache(com.bumptech.glide.load.Key key) {
        com.bumptech.glide.load.engine.EngineResource<?> engineResourceFromCache = getEngineResourceFromCache(key);
        if (engineResourceFromCache != null) {
            engineResourceFromCache.acquire();
            this.activeResources.activate(key, engineResourceFromCache);
        }
        return engineResourceFromCache;
    }

    private com.bumptech.glide.load.engine.EngineResource<?> getEngineResourceFromCache(com.bumptech.glide.load.Key key) {
        com.bumptech.glide.load.engine.Resource<?> resourceRemove = this.cache.remove(key);
        if (resourceRemove == null) {
            return null;
        }
        if (resourceRemove instanceof com.bumptech.glide.load.engine.EngineResource) {
            return (com.bumptech.glide.load.engine.EngineResource) resourceRemove;
        }
        return new com.bumptech.glide.load.engine.EngineResource<>(resourceRemove, true, true, key, this);
    }

    public void release(com.bumptech.glide.load.engine.Resource<?> resource) {
        if (resource instanceof com.bumptech.glide.load.engine.EngineResource) {
            ((com.bumptech.glide.load.engine.EngineResource) resource).release();
            return;
        }
        throw new java.lang.IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public synchronized void onEngineJobComplete(com.bumptech.glide.load.engine.EngineJob<?> engineJob, com.bumptech.glide.load.Key key, com.bumptech.glide.load.engine.EngineResource<?> engineResource) {
        if (engineResource != null) {
            if (engineResource.isMemoryCacheable()) {
                this.activeResources.activate(key, engineResource);
            }
        }
        this.jobs.removeIfCurrent(key, engineJob);
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public synchronized void onEngineJobCancelled(com.bumptech.glide.load.engine.EngineJob<?> engineJob, com.bumptech.glide.load.Key key) {
        this.jobs.removeIfCurrent(key, engineJob);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener
    public void onResourceRemoved(com.bumptech.glide.load.engine.Resource<?> resource) {
        this.resourceRecycler.recycle(resource, true);
    }

    @Override // com.bumptech.glide.load.engine.EngineResource.ResourceListener
    public void onResourceReleased(com.bumptech.glide.load.Key key, com.bumptech.glide.load.engine.EngineResource<?> engineResource) {
        this.activeResources.deactivate(key);
        if (engineResource.isMemoryCacheable()) {
            this.cache.put(key, engineResource);
        } else {
            this.resourceRecycler.recycle(engineResource, false);
        }
    }

    public void clearDiskCache() {
        this.diskCacheProvider.getDiskCache().clear();
    }

    public void shutdown() {
        this.engineJobFactory.shutdown();
        this.diskCacheProvider.clearDiskCacheIfCreated();
        this.activeResources.shutdown();
    }

    public class LoadStatus {
        private final com.bumptech.glide.request.ResourceCallback cb;
        private final com.bumptech.glide.load.engine.EngineJob<?> engineJob;

        LoadStatus(com.bumptech.glide.request.ResourceCallback resourceCallback, com.bumptech.glide.load.engine.EngineJob<?> engineJob) {
            this.cb = resourceCallback;
            this.engineJob = engineJob;
        }

        public void cancel() {
            synchronized (com.bumptech.glide.load.engine.Engine.this) {
                this.engineJob.removeCallback(this.cb);
            }
        }
    }

    private static class LazyDiskCacheProvider implements com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider {
        private volatile com.bumptech.glide.load.engine.cache.DiskCache diskCache;
        private final com.bumptech.glide.load.engine.cache.DiskCache.Factory factory;

        LazyDiskCacheProvider(com.bumptech.glide.load.engine.cache.DiskCache.Factory factory) {
            this.factory = factory;
        }

        synchronized void clearDiskCacheIfCreated() {
            if (this.diskCache == null) {
                return;
            }
            this.diskCache.clear();
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider
        public com.bumptech.glide.load.engine.cache.DiskCache getDiskCache() {
            if (this.diskCache == null) {
                synchronized (this) {
                    if (this.diskCache == null) {
                        this.diskCache = this.factory.build();
                    }
                    if (this.diskCache == null) {
                        this.diskCache = new com.bumptech.glide.load.engine.cache.DiskCacheAdapter();
                    }
                }
            }
            return this.diskCache;
        }
    }

    static class DecodeJobFactory {
        private int creationOrder;
        final com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider diskCacheProvider;
        final androidx.core.util.Pools.Pool<com.bumptech.glide.load.engine.DecodeJob<?>> pool = com.bumptech.glide.util.pool.FactoryPools.threadSafe(com.bumptech.glide.load.engine.Engine.JOB_POOL_SIZE, new com.bumptech.glide.util.pool.FactoryPools.Factory<com.bumptech.glide.load.engine.DecodeJob<?>>() { // from class: com.bumptech.glide.load.engine.Engine.DecodeJobFactory.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public com.bumptech.glide.load.engine.DecodeJob<?> create() {
                return new com.bumptech.glide.load.engine.DecodeJob<>(com.bumptech.glide.load.engine.Engine.DecodeJobFactory.this.diskCacheProvider, com.bumptech.glide.load.engine.Engine.DecodeJobFactory.this.pool);
            }
        });

        DecodeJobFactory(com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider diskCacheProvider) {
            this.diskCacheProvider = diskCacheProvider;
        }

        <R> com.bumptech.glide.load.engine.DecodeJob<R> build(com.bumptech.glide.GlideContext glideContext, java.lang.Object obj, com.bumptech.glide.load.engine.EngineKey engineKey, com.bumptech.glide.load.Key key, int i, int i2, java.lang.Class<?> cls, java.lang.Class<R> cls2, com.bumptech.glide.Priority priority, com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy, java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.Options options, com.bumptech.glide.load.engine.DecodeJob.Callback<R> callback) {
            com.bumptech.glide.load.engine.DecodeJob decodeJob = (com.bumptech.glide.load.engine.DecodeJob) com.bumptech.glide.util.Preconditions.checkNotNull(this.pool.acquire());
            int i3 = this.creationOrder;
            this.creationOrder = i3 + 1;
            return decodeJob.init(glideContext, obj, engineKey, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, z3, options, callback, i3);
        }
    }

    static class EngineJobFactory {
        final com.bumptech.glide.load.engine.executor.GlideExecutor animationExecutor;
        final com.bumptech.glide.load.engine.executor.GlideExecutor diskCacheExecutor;
        final com.bumptech.glide.load.engine.EngineJobListener engineJobListener;
        final androidx.core.util.Pools.Pool<com.bumptech.glide.load.engine.EngineJob<?>> pool = com.bumptech.glide.util.pool.FactoryPools.threadSafe(com.bumptech.glide.load.engine.Engine.JOB_POOL_SIZE, new com.bumptech.glide.util.pool.FactoryPools.Factory<com.bumptech.glide.load.engine.EngineJob<?>>() { // from class: com.bumptech.glide.load.engine.Engine.EngineJobFactory.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public com.bumptech.glide.load.engine.EngineJob<?> create() {
                return new com.bumptech.glide.load.engine.EngineJob<>(com.bumptech.glide.load.engine.Engine.EngineJobFactory.this.diskCacheExecutor, com.bumptech.glide.load.engine.Engine.EngineJobFactory.this.sourceExecutor, com.bumptech.glide.load.engine.Engine.EngineJobFactory.this.sourceUnlimitedExecutor, com.bumptech.glide.load.engine.Engine.EngineJobFactory.this.animationExecutor, com.bumptech.glide.load.engine.Engine.EngineJobFactory.this.engineJobListener, com.bumptech.glide.load.engine.Engine.EngineJobFactory.this.resourceListener, com.bumptech.glide.load.engine.Engine.EngineJobFactory.this.pool);
            }
        });
        final com.bumptech.glide.load.engine.EngineResource.ResourceListener resourceListener;
        final com.bumptech.glide.load.engine.executor.GlideExecutor sourceExecutor;
        final com.bumptech.glide.load.engine.executor.GlideExecutor sourceUnlimitedExecutor;

        EngineJobFactory(com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor2, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor3, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor4, com.bumptech.glide.load.engine.EngineJobListener engineJobListener, com.bumptech.glide.load.engine.EngineResource.ResourceListener resourceListener) {
            this.diskCacheExecutor = glideExecutor;
            this.sourceExecutor = glideExecutor2;
            this.sourceUnlimitedExecutor = glideExecutor3;
            this.animationExecutor = glideExecutor4;
            this.engineJobListener = engineJobListener;
            this.resourceListener = resourceListener;
        }

        void shutdown() {
            com.bumptech.glide.util.Executors.shutdownAndAwaitTermination(this.diskCacheExecutor);
            com.bumptech.glide.util.Executors.shutdownAndAwaitTermination(this.sourceExecutor);
            com.bumptech.glide.util.Executors.shutdownAndAwaitTermination(this.sourceUnlimitedExecutor);
            com.bumptech.glide.util.Executors.shutdownAndAwaitTermination(this.animationExecutor);
        }

        <R> com.bumptech.glide.load.engine.EngineJob<R> build(com.bumptech.glide.load.Key key, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((com.bumptech.glide.load.engine.EngineJob) com.bumptech.glide.util.Preconditions.checkNotNull(this.pool.acquire())).init(key, z, z2, z3, z4);
        }
    }
}
