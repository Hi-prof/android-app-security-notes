package com.bumptech.glide;

/* JADX INFO: loaded from: classes.dex */
public class Glide implements android.content.ComponentCallbacks2 {
    private static final java.lang.String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    private static final java.lang.String DESTROYED_ACTIVITY_WARNING = "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).";
    private static final java.lang.String TAG = "Glide";
    private static volatile com.bumptech.glide.Glide glide;
    private static volatile boolean isInitializing;
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool;
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private com.bumptech.glide.load.engine.prefill.BitmapPreFiller bitmapPreFiller;
    private final com.bumptech.glide.manager.ConnectivityMonitorFactory connectivityMonitorFactory;
    private final com.bumptech.glide.Glide.RequestOptionsFactory defaultRequestOptionsFactory;
    private final com.bumptech.glide.load.engine.Engine engine;
    private final com.bumptech.glide.GlideContext glideContext;
    private final com.bumptech.glide.load.engine.cache.MemoryCache memoryCache;
    private final com.bumptech.glide.manager.RequestManagerRetriever requestManagerRetriever;
    private final java.util.List<com.bumptech.glide.RequestManager> managers = new java.util.ArrayList();
    private com.bumptech.glide.MemoryCategory memoryCategory = com.bumptech.glide.MemoryCategory.NORMAL;

    public interface RequestOptionsFactory {
        com.bumptech.glide.request.RequestOptions build();
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
    }

    public static java.io.File getPhotoCacheDir(android.content.Context context) {
        return getPhotoCacheDir(context, "image_manager_disk_cache");
    }

    public static java.io.File getPhotoCacheDir(android.content.Context context, java.lang.String str) {
        java.io.File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            java.io.File file = new java.io.File(cacheDir, str);
            if (file.isDirectory() || file.mkdirs()) {
                return file;
            }
            return null;
        }
        if (android.util.Log.isLoggable(TAG, 6)) {
            android.util.Log.e(TAG, "default disk cache dir is null");
        }
        return null;
    }

    public static com.bumptech.glide.Glide get(android.content.Context context) {
        if (glide == null) {
            com.bumptech.glide.GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules(context.getApplicationContext());
            synchronized (com.bumptech.glide.Glide.class) {
                if (glide == null) {
                    checkAndInitializeGlide(context, annotationGeneratedGlideModules);
                }
            }
        }
        return glide;
    }

    static void checkAndInitializeGlide(android.content.Context context, com.bumptech.glide.GeneratedAppGlideModule generatedAppGlideModule) {
        if (isInitializing) {
            throw new java.lang.IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
        }
        isInitializing = true;
        try {
            initializeGlide(context, generatedAppGlideModule);
        } finally {
            isInitializing = false;
        }
    }

    @java.lang.Deprecated
    public static synchronized void init(com.bumptech.glide.Glide glide2) {
        if (glide != null) {
            tearDown();
        }
        glide = glide2;
    }

    public static void init(android.content.Context context, com.bumptech.glide.GlideBuilder glideBuilder) {
        com.bumptech.glide.GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules(context);
        synchronized (com.bumptech.glide.Glide.class) {
            if (glide != null) {
                tearDown();
            }
            initializeGlide(context, glideBuilder, annotationGeneratedGlideModules);
        }
    }

    public static synchronized boolean isInitialized() {
        return glide != null;
    }

    public static void enableHardwareBitmaps() {
        com.bumptech.glide.load.resource.bitmap.HardwareConfigState.getInstance().unblockHardwareBitmaps();
    }

    public static void tearDown() {
        synchronized (com.bumptech.glide.Glide.class) {
            if (glide != null) {
                glide.getContext().getApplicationContext().unregisterComponentCallbacks(glide);
                glide.engine.shutdown();
            }
            glide = null;
        }
    }

    private static void initializeGlide(android.content.Context context, com.bumptech.glide.GeneratedAppGlideModule generatedAppGlideModule) {
        initializeGlide(context, new com.bumptech.glide.GlideBuilder(), generatedAppGlideModule);
    }

    private static void initializeGlide(android.content.Context context, com.bumptech.glide.GlideBuilder glideBuilder, com.bumptech.glide.GeneratedAppGlideModule generatedAppGlideModule) {
        android.content.Context applicationContext = context.getApplicationContext();
        java.util.List<com.bumptech.glide.module.GlideModule> list = java.util.Collections.EMPTY_LIST;
        if (generatedAppGlideModule == null || generatedAppGlideModule.isManifestParsingEnabled()) {
            list = new com.bumptech.glide.module.ManifestParser(applicationContext).parse();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.getExcludedModuleClasses().isEmpty()) {
            java.util.Set<java.lang.Class<?>> excludedModuleClasses = generatedAppGlideModule.getExcludedModuleClasses();
            java.util.Iterator<com.bumptech.glide.module.GlideModule> it = list.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.module.GlideModule next = it.next();
                if (excludedModuleClasses.contains(next.getClass())) {
                    if (android.util.Log.isLoggable(TAG, 3)) {
                        android.util.Log.d(TAG, "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (android.util.Log.isLoggable(TAG, 3)) {
            java.util.Iterator<com.bumptech.glide.module.GlideModule> it2 = list.iterator();
            while (it2.hasNext()) {
                android.util.Log.d(TAG, "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        glideBuilder.setRequestManagerFactory(generatedAppGlideModule != null ? generatedAppGlideModule.getRequestManagerFactory() : null);
        java.util.Iterator<com.bumptech.glide.module.GlideModule> it3 = list.iterator();
        while (it3.hasNext()) {
            it3.next().applyOptions(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.applyOptions(applicationContext, glideBuilder);
        }
        com.bumptech.glide.Glide glideBuild = glideBuilder.build(applicationContext, list, generatedAppGlideModule);
        applicationContext.registerComponentCallbacks(glideBuild);
        glide = glideBuild;
    }

    private static com.bumptech.glide.GeneratedAppGlideModule getAnnotationGeneratedGlideModules(android.content.Context context) {
        try {
            return (com.bumptech.glide.GeneratedAppGlideModule) java.lang.Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(android.content.Context.class).newInstance(context.getApplicationContext());
        } catch (java.lang.ClassNotFoundException unused) {
            if (!android.util.Log.isLoggable(TAG, 5)) {
                return null;
            }
            android.util.Log.w(TAG, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            return null;
        } catch (java.lang.IllegalAccessException e) {
            throwIncorrectGlideModule(e);
            return null;
        } catch (java.lang.InstantiationException e2) {
            throwIncorrectGlideModule(e2);
            return null;
        } catch (java.lang.NoSuchMethodException e3) {
            throwIncorrectGlideModule(e3);
            return null;
        } catch (java.lang.reflect.InvocationTargetException e4) {
            throwIncorrectGlideModule(e4);
            return null;
        }
    }

    private static void throwIncorrectGlideModule(java.lang.Exception exc) {
        throw new java.lang.IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    Glide(android.content.Context context, com.bumptech.glide.load.engine.Engine engine, com.bumptech.glide.load.engine.cache.MemoryCache memoryCache, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool, com.bumptech.glide.manager.RequestManagerRetriever requestManagerRetriever, com.bumptech.glide.manager.ConnectivityMonitorFactory connectivityMonitorFactory, int i, com.bumptech.glide.Glide.RequestOptionsFactory requestOptionsFactory, java.util.Map<java.lang.Class<?>, com.bumptech.glide.TransitionOptions<?, ?>> map, java.util.List<com.bumptech.glide.request.RequestListener<java.lang.Object>> list, java.util.List<com.bumptech.glide.module.GlideModule> list2, com.bumptech.glide.module.AppGlideModule appGlideModule, com.bumptech.glide.GlideExperiments glideExperiments) {
        this.engine = engine;
        this.bitmapPool = bitmapPool;
        this.arrayPool = arrayPool;
        this.memoryCache = memoryCache;
        this.requestManagerRetriever = requestManagerRetriever;
        this.connectivityMonitorFactory = connectivityMonitorFactory;
        this.defaultRequestOptionsFactory = requestOptionsFactory;
        this.glideContext = new com.bumptech.glide.GlideContext(context, arrayPool, com.bumptech.glide.RegistryFactory.lazilyCreateAndInitializeRegistry(this, list2, appGlideModule), new com.bumptech.glide.request.target.ImageViewTargetFactory(), requestOptionsFactory, map, list, engine, glideExperiments, i);
    }

    public com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    public com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    public android.content.Context getContext() {
        return this.glideContext.getBaseContext();
    }

    com.bumptech.glide.manager.ConnectivityMonitorFactory getConnectivityMonitorFactory() {
        return this.connectivityMonitorFactory;
    }

    com.bumptech.glide.GlideContext getGlideContext() {
        return this.glideContext;
    }

    public synchronized void preFillBitmapPool(com.bumptech.glide.load.engine.prefill.PreFillType.Builder... builderArr) {
        if (this.bitmapPreFiller == null) {
            this.bitmapPreFiller = new com.bumptech.glide.load.engine.prefill.BitmapPreFiller(this.memoryCache, this.bitmapPool, (com.bumptech.glide.load.DecodeFormat) this.defaultRequestOptionsFactory.build().getOptions().get(com.bumptech.glide.load.resource.bitmap.Downsampler.DECODE_FORMAT));
        }
        this.bitmapPreFiller.preFill(builderArr);
    }

    public void clearMemory() {
        com.bumptech.glide.util.Util.assertMainThread();
        this.memoryCache.clearMemory();
        this.bitmapPool.clearMemory();
        this.arrayPool.clearMemory();
    }

    public void trimMemory(int i) {
        com.bumptech.glide.util.Util.assertMainThread();
        synchronized (this.managers) {
            java.util.Iterator<com.bumptech.glide.RequestManager> it = this.managers.iterator();
            while (it.hasNext()) {
                it.next().onTrimMemory(i);
            }
        }
        this.memoryCache.trimMemory(i);
        this.bitmapPool.trimMemory(i);
        this.arrayPool.trimMemory(i);
    }

    public void clearDiskCache() {
        com.bumptech.glide.util.Util.assertBackgroundThread();
        this.engine.clearDiskCache();
    }

    public com.bumptech.glide.manager.RequestManagerRetriever getRequestManagerRetriever() {
        return this.requestManagerRetriever;
    }

    public com.bumptech.glide.MemoryCategory setMemoryCategory(com.bumptech.glide.MemoryCategory memoryCategory) {
        com.bumptech.glide.util.Util.assertMainThread();
        this.memoryCache.setSizeMultiplier(memoryCategory.getMultiplier());
        this.bitmapPool.setSizeMultiplier(memoryCategory.getMultiplier());
        com.bumptech.glide.MemoryCategory memoryCategory2 = this.memoryCategory;
        this.memoryCategory = memoryCategory;
        return memoryCategory2;
    }

    private static com.bumptech.glide.manager.RequestManagerRetriever getRetriever(android.content.Context context) {
        com.bumptech.glide.util.Preconditions.checkNotNull(context, DESTROYED_ACTIVITY_WARNING);
        return get(context).getRequestManagerRetriever();
    }

    public static com.bumptech.glide.RequestManager with(android.content.Context context) {
        return getRetriever(context).get(context);
    }

    @java.lang.Deprecated
    public static com.bumptech.glide.RequestManager with(android.app.Activity activity) {
        return with(activity.getApplicationContext());
    }

    public static com.bumptech.glide.RequestManager with(androidx.fragment.app.FragmentActivity fragmentActivity) {
        return getRetriever(fragmentActivity).get(fragmentActivity);
    }

    public static com.bumptech.glide.RequestManager with(androidx.fragment.app.Fragment fragment) {
        return getRetriever(fragment.getContext()).get(fragment);
    }

    @java.lang.Deprecated
    public static com.bumptech.glide.RequestManager with(android.app.Fragment fragment) {
        android.app.Activity activity = fragment.getActivity();
        com.bumptech.glide.util.Preconditions.checkNotNull(activity, DESTROYED_ACTIVITY_WARNING);
        return with(activity.getApplicationContext());
    }

    public static com.bumptech.glide.RequestManager with(android.view.View view) {
        return getRetriever(view.getContext()).get(view);
    }

    public com.bumptech.glide.Registry getRegistry() {
        return this.glideContext.getRegistry();
    }

    boolean removeFromManagers(com.bumptech.glide.request.target.Target<?> target) {
        synchronized (this.managers) {
            java.util.Iterator<com.bumptech.glide.RequestManager> it = this.managers.iterator();
            while (it.hasNext()) {
                if (it.next().untrack(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    void registerRequestManager(com.bumptech.glide.RequestManager requestManager) {
        synchronized (this.managers) {
            if (this.managers.contains(requestManager)) {
                throw new java.lang.IllegalStateException("Cannot register already registered manager");
            }
            this.managers.add(requestManager);
        }
    }

    void unregisterRequestManager(com.bumptech.glide.RequestManager requestManager) {
        synchronized (this.managers) {
            if (!this.managers.contains(requestManager)) {
                throw new java.lang.IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.managers.remove(requestManager);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        trimMemory(i);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        clearMemory();
    }
}
