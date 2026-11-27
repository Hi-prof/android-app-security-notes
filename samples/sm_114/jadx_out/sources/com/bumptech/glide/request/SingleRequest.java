package com.bumptech.glide.request;

/* JADX INFO: loaded from: classes.dex */
public final class SingleRequest<R> implements com.bumptech.glide.request.Request, com.bumptech.glide.request.target.SizeReadyCallback, com.bumptech.glide.request.ResourceCallback {
    private static final java.lang.String GLIDE_TAG = "Glide";
    private final com.bumptech.glide.request.transition.TransitionFactory<? super R> animationFactory;
    private final java.util.concurrent.Executor callbackExecutor;
    private final android.content.Context context;
    private int cookie;
    private volatile com.bumptech.glide.load.engine.Engine engine;
    private android.graphics.drawable.Drawable errorDrawable;
    private android.graphics.drawable.Drawable fallbackDrawable;
    private final com.bumptech.glide.GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private com.bumptech.glide.load.engine.Engine.LoadStatus loadStatus;
    private final java.lang.Object model;
    private final int overrideHeight;
    private final int overrideWidth;
    private android.graphics.drawable.Drawable placeholderDrawable;
    private final com.bumptech.glide.Priority priority;
    private final com.bumptech.glide.request.RequestCoordinator requestCoordinator;
    private final java.util.List<com.bumptech.glide.request.RequestListener<R>> requestListeners;
    private final java.lang.Object requestLock;
    private final com.bumptech.glide.request.BaseRequestOptions<?> requestOptions;
    private java.lang.RuntimeException requestOrigin;
    private com.bumptech.glide.load.engine.Resource<R> resource;
    private long startTime;
    private final com.bumptech.glide.util.pool.StateVerifier stateVerifier;
    private com.bumptech.glide.request.SingleRequest.Status status;
    private final java.lang.String tag;
    private final com.bumptech.glide.request.target.Target<R> target;
    private final com.bumptech.glide.request.RequestListener<R> targetListener;
    private final java.lang.Class<R> transcodeClass;
    private int width;
    private static final java.lang.String TAG = "GlideRequest";
    private static final boolean IS_VERBOSE_LOGGABLE = android.util.Log.isLoggable(TAG, 2);

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public static <R> com.bumptech.glide.request.SingleRequest<R> obtain(android.content.Context context, com.bumptech.glide.GlideContext glideContext, java.lang.Object obj, java.lang.Object obj2, java.lang.Class<R> cls, com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, int i, int i2, com.bumptech.glide.Priority priority, com.bumptech.glide.request.target.Target<R> target, com.bumptech.glide.request.RequestListener<R> requestListener, java.util.List<com.bumptech.glide.request.RequestListener<R>> list, com.bumptech.glide.request.RequestCoordinator requestCoordinator, com.bumptech.glide.load.engine.Engine engine, com.bumptech.glide.request.transition.TransitionFactory<? super R> transitionFactory, java.util.concurrent.Executor executor) {
        return new com.bumptech.glide.request.SingleRequest<>(context, glideContext, obj, obj2, cls, baseRequestOptions, i, i2, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
    }

    private SingleRequest(android.content.Context context, com.bumptech.glide.GlideContext glideContext, java.lang.Object obj, java.lang.Object obj2, java.lang.Class<R> cls, com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, int i, int i2, com.bumptech.glide.Priority priority, com.bumptech.glide.request.target.Target<R> target, com.bumptech.glide.request.RequestListener<R> requestListener, java.util.List<com.bumptech.glide.request.RequestListener<R>> list, com.bumptech.glide.request.RequestCoordinator requestCoordinator, com.bumptech.glide.load.engine.Engine engine, com.bumptech.glide.request.transition.TransitionFactory<? super R> transitionFactory, java.util.concurrent.Executor executor) {
        this.tag = IS_VERBOSE_LOGGABLE ? java.lang.String.valueOf(super.hashCode()) : null;
        this.stateVerifier = com.bumptech.glide.util.pool.StateVerifier.newInstance();
        this.requestLock = obj;
        this.context = context;
        this.glideContext = glideContext;
        this.model = obj2;
        this.transcodeClass = cls;
        this.requestOptions = baseRequestOptions;
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.priority = priority;
        this.target = target;
        this.targetListener = requestListener;
        this.requestListeners = list;
        this.requestCoordinator = requestCoordinator;
        this.engine = engine;
        this.animationFactory = transitionFactory;
        this.callbackExecutor = executor;
        this.status = com.bumptech.glide.request.SingleRequest.Status.PENDING;
        if (this.requestOrigin == null && glideContext.getExperiments().isEnabled(com.bumptech.glide.GlideBuilder.LogRequestOrigins.class)) {
            this.requestOrigin = new java.lang.RuntimeException("Glide request origin trace");
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        synchronized (this.requestLock) {
            assertNotCallingCallbacks();
            this.stateVerifier.throwIfRecycled();
            this.startTime = com.bumptech.glide.util.LogTime.getLogTime();
            if (this.model == null) {
                if (com.bumptech.glide.util.Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                    this.width = this.overrideWidth;
                    this.height = this.overrideHeight;
                }
                onLoadFailed(new com.bumptech.glide.load.engine.GlideException("Received null model"), getFallbackDrawable() == null ? 5 : 3);
                return;
            }
            if (this.status == com.bumptech.glide.request.SingleRequest.Status.RUNNING) {
                throw new java.lang.IllegalArgumentException("Cannot restart a running request");
            }
            if (this.status == com.bumptech.glide.request.SingleRequest.Status.COMPLETE) {
                onResourceReady(this.resource, com.bumptech.glide.load.DataSource.MEMORY_CACHE, false);
                return;
            }
            experimentalNotifyRequestStarted(this.model);
            this.cookie = com.bumptech.glide.util.pool.GlideTrace.beginSectionAsync(TAG);
            this.status = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE;
            if (com.bumptech.glide.util.Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                onSizeReady(this.overrideWidth, this.overrideHeight);
            } else {
                this.target.getSize(this);
            }
            if ((this.status == com.bumptech.glide.request.SingleRequest.Status.RUNNING || this.status == com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE) && canNotifyStatusChanged()) {
                this.target.onLoadStarted(getPlaceholderDrawable());
            }
            if (IS_VERBOSE_LOGGABLE) {
                logV("finished run method in " + com.bumptech.glide.util.LogTime.getElapsedMillis(this.startTime));
            }
        }
    }

    private void experimentalNotifyRequestStarted(java.lang.Object obj) {
        java.util.List<com.bumptech.glide.request.RequestListener<R>> list = this.requestListeners;
        if (list == null) {
            return;
        }
        for (com.bumptech.glide.request.RequestListener<R> requestListener : list) {
            if (requestListener instanceof com.bumptech.glide.request.ExperimentalRequestListener) {
                ((com.bumptech.glide.request.ExperimentalRequestListener) requestListener).onRequestStarted(obj);
            }
        }
    }

    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        com.bumptech.glide.load.engine.Engine.LoadStatus loadStatus = this.loadStatus;
        if (loadStatus != null) {
            loadStatus.cancel();
            this.loadStatus = null;
        }
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new java.lang.IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.requestLock) {
            assertNotCallingCallbacks();
            this.stateVerifier.throwIfRecycled();
            if (this.status == com.bumptech.glide.request.SingleRequest.Status.CLEARED) {
                return;
            }
            cancel();
            com.bumptech.glide.load.engine.Resource<R> resource = this.resource;
            if (resource != null) {
                this.resource = null;
            } else {
                resource = null;
            }
            if (canNotifyCleared()) {
                this.target.onLoadCleared(getPlaceholderDrawable());
            }
            com.bumptech.glide.util.pool.GlideTrace.endSectionAsync(TAG, this.cookie);
            this.status = com.bumptech.glide.request.SingleRequest.Status.CLEARED;
            if (resource != null) {
                this.engine.release(resource);
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.requestLock) {
            if (isRunning()) {
                clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == com.bumptech.glide.request.SingleRequest.Status.RUNNING || this.status == com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == com.bumptech.glide.request.SingleRequest.Status.COMPLETE;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == com.bumptech.glide.request.SingleRequest.Status.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == com.bumptech.glide.request.SingleRequest.Status.COMPLETE;
        }
        return z;
    }

    private android.graphics.drawable.Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            android.graphics.drawable.Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    private android.graphics.drawable.Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            android.graphics.drawable.Drawable placeholderDrawable = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable;
            if (placeholderDrawable == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    private android.graphics.drawable.Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            android.graphics.drawable.Drawable fallbackDrawable = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable;
            if (fallbackDrawable == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    private android.graphics.drawable.Drawable loadDrawable(int i) {
        return com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat.getDrawable(this.context, i, this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme());
    }

    private void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
            android.graphics.drawable.Drawable fallbackDrawable = this.model == null ? getFallbackDrawable() : null;
            if (fallbackDrawable == null) {
                fallbackDrawable = getErrorDrawable();
            }
            if (fallbackDrawable == null) {
                fallbackDrawable = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(fallbackDrawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bumptech.glide.request.ResourceCallback, com.bumptech.glide.request.SingleRequest] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.bumptech.glide.load.engine.Engine] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i, int i2) throws java.lang.Throwable {
        ?? r1 = this;
        r1.stateVerifier.throwIfRecycled();
        java.lang.Object obj = r1.requestLock;
        synchronized (obj) {
            try {
                try {
                    boolean z = IS_VERBOSE_LOGGABLE;
                    if (z) {
                        r1.logV("Got onSizeReady in " + com.bumptech.glide.util.LogTime.getElapsedMillis(r1.startTime));
                    }
                    if (r1.status == com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE) {
                        r1.status = com.bumptech.glide.request.SingleRequest.Status.RUNNING;
                        float sizeMultiplier = r1.requestOptions.getSizeMultiplier();
                        r1.width = maybeApplySizeMultiplier(i, sizeMultiplier);
                        r1.height = maybeApplySizeMultiplier(i2, sizeMultiplier);
                        if (z) {
                            r1.logV("finished setup for calling load in " + com.bumptech.glide.util.LogTime.getElapsedMillis(r1.startTime));
                        }
                        ?? r2 = r1.engine;
                        com.bumptech.glide.GlideContext glideContext = r1.glideContext;
                        try {
                            java.lang.Object obj2 = r1.model;
                            com.bumptech.glide.load.Key signature = r1.requestOptions.getSignature();
                            try {
                                int i3 = r1.width;
                                try {
                                    int i4 = r1.height;
                                    java.lang.Class<?> resourceClass = r1.requestOptions.getResourceClass();
                                    try {
                                        java.lang.Class<R> cls = r1.transcodeClass;
                                        try {
                                            com.bumptech.glide.Priority priority = r1.priority;
                                            com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy = r1.requestOptions.getDiskCacheStrategy();
                                            java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> transformations = r1.requestOptions.getTransformations();
                                            boolean zIsTransformationRequired = r1.requestOptions.isTransformationRequired();
                                            boolean zIsScaleOnlyOrNoTransform = r1.requestOptions.isScaleOnlyOrNoTransform();
                                            com.bumptech.glide.load.Options options = r1.requestOptions.getOptions();
                                            boolean zIsMemoryCacheable = r1.requestOptions.isMemoryCacheable();
                                            boolean useUnlimitedSourceGeneratorsPool = r1.requestOptions.getUseUnlimitedSourceGeneratorsPool();
                                            boolean useAnimationPool = r1.requestOptions.getUseAnimationPool();
                                            boolean onlyRetrieveFromCache = r1.requestOptions.getOnlyRetrieveFromCache();
                                            java.util.concurrent.Executor executor = r1.callbackExecutor;
                                            r1 = obj;
                                            try {
                                                r1.loadStatus = r2.load(glideContext, obj2, signature, i3, i4, resourceClass, cls, priority, diskCacheStrategy, transformations, zIsTransformationRequired, zIsScaleOnlyOrNoTransform, options, zIsMemoryCacheable, useUnlimitedSourceGeneratorsPool, useAnimationPool, onlyRetrieveFromCache, r1, executor);
                                                if (r1.status != com.bumptech.glide.request.SingleRequest.Status.RUNNING) {
                                                    r1.loadStatus = null;
                                                }
                                                if (z) {
                                                    r1.logV("finished onSizeReady in " + com.bumptech.glide.util.LogTime.getElapsedMillis(r1.startTime));
                                                }
                                            } catch (java.lang.Throwable th) {
                                                th = th;
                                                throw th;
                                            }
                                        } catch (java.lang.Throwable th2) {
                                            th = th2;
                                            r1 = obj;
                                        }
                                    } catch (java.lang.Throwable th3) {
                                        th = th3;
                                        r1 = obj;
                                    }
                                } catch (java.lang.Throwable th4) {
                                    th = th4;
                                    r1 = obj;
                                }
                            } catch (java.lang.Throwable th5) {
                                th = th5;
                                r1 = obj;
                            }
                        } catch (java.lang.Throwable th6) {
                            th = th6;
                            r1 = obj;
                        }
                    }
                } catch (java.lang.Throwable th7) {
                    th = th7;
                    r1 = obj;
                }
            } catch (java.lang.Throwable th8) {
                th = th8;
            }
        }
    }

    private static int maybeApplySizeMultiplier(int i, float f) {
        return i == Integer.MIN_VALUE ? i : java.lang.Math.round(f * i);
    }

    private boolean canSetResource() {
        com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    private boolean canNotifyCleared() {
        com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    private boolean canNotifyStatusChanged() {
        com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean isFirstReadyResource() {
        com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || !requestCoordinator.getRoot().isAnyResourceSet();
    }

    private void notifyRequestCoordinatorLoadSucceeded() {
        com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    private void notifyRequestCoordinatorLoadFailed() {
        com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestFailed(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
    
        if (r7 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ae, code lost:
    
        if (r7 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b1, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResourceReady(com.bumptech.glide.load.engine.Resource<?> r7, com.bumptech.glide.load.DataSource r8, boolean r9) {
        /*
            r6 = this;
            java.lang.String r0 = "Expected to receive an object of "
            java.lang.String r1 = "Expected to receive a Resource<R> with an object of "
            com.bumptech.glide.util.pool.StateVerifier r2 = r6.stateVerifier
            r2.throwIfRecycled()
            r2 = 0
            java.lang.Object r3 = r6.requestLock     // Catch: java.lang.Throwable -> Lb9
            monitor-enter(r3)     // Catch: java.lang.Throwable -> Lb9
            r6.loadStatus = r2     // Catch: java.lang.Throwable -> Lb6
            if (r7 != 0) goto L2e
            com.bumptech.glide.load.engine.GlideException r7 = new com.bumptech.glide.load.engine.GlideException     // Catch: java.lang.Throwable -> Lb6
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb6
            r8.<init>(r1)     // Catch: java.lang.Throwable -> Lb6
            java.lang.Class<R> r9 = r6.transcodeClass     // Catch: java.lang.Throwable -> Lb6
            r8.append(r9)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r9 = " inside, but instead got null."
            r8.append(r9)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> Lb6
            r7.<init>(r8)     // Catch: java.lang.Throwable -> Lb6
            r6.onLoadFailed(r7)     // Catch: java.lang.Throwable -> Lb6
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lb6
            return
        L2e:
            java.lang.Object r1 = r7.get()     // Catch: java.lang.Throwable -> Lb6
            if (r1 == 0) goto L62
            java.lang.Class<R> r4 = r6.transcodeClass     // Catch: java.lang.Throwable -> Lb6
            java.lang.Class r5 = r1.getClass()     // Catch: java.lang.Throwable -> Lb6
            boolean r4 = r4.isAssignableFrom(r5)     // Catch: java.lang.Throwable -> Lb6
            if (r4 != 0) goto L41
            goto L62
        L41:
            boolean r0 = r6.canSetResource()     // Catch: java.lang.Throwable -> Lb6
            if (r0 != 0) goto L5d
            r6.resource = r2     // Catch: java.lang.Throwable -> Lb2
            com.bumptech.glide.request.SingleRequest$Status r8 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch: java.lang.Throwable -> Lb2
            r6.status = r8     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r8 = "GlideRequest"
            int r9 = r6.cookie     // Catch: java.lang.Throwable -> Lb2
            com.bumptech.glide.util.pool.GlideTrace.endSectionAsync(r8, r9)     // Catch: java.lang.Throwable -> Lb2
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lb2
            if (r7 == 0) goto Lb1
        L57:
            com.bumptech.glide.load.engine.Engine r8 = r6.engine
            r8.release(r7)
            return
        L5d:
            r6.onResourceReady(r7, r1, r8, r9)     // Catch: java.lang.Throwable -> Lb6
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lb6
            return
        L62:
            r6.resource = r2     // Catch: java.lang.Throwable -> Lb2
            com.bumptech.glide.load.engine.GlideException r8 = new com.bumptech.glide.load.engine.GlideException     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r9.<init>(r0)     // Catch: java.lang.Throwable -> Lb2
            java.lang.Class<R> r0 = r6.transcodeClass     // Catch: java.lang.Throwable -> Lb2
            r9.append(r0)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r0 = " but instead got "
            r9.append(r0)     // Catch: java.lang.Throwable -> Lb2
            if (r1 == 0) goto L7c
            java.lang.Class r0 = r1.getClass()     // Catch: java.lang.Throwable -> Lb2
            goto L7e
        L7c:
            java.lang.String r0 = ""
        L7e:
            r9.append(r0)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r0 = "{"
            r9.append(r0)     // Catch: java.lang.Throwable -> Lb2
            r9.append(r1)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r0 = "} inside Resource{"
            r9.append(r0)     // Catch: java.lang.Throwable -> Lb2
            r9.append(r7)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r0 = "}."
            r9.append(r0)     // Catch: java.lang.Throwable -> Lb2
            if (r1 == 0) goto L9e
            java.lang.String r0 = ""
            goto La0
        L9e:
            java.lang.String r0 = " To indicate failure return a null Resource object, rather than a Resource object containing null data."
        La0:
            r9.append(r0)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lb2
            r8.<init>(r9)     // Catch: java.lang.Throwable -> Lb2
            r6.onLoadFailed(r8)     // Catch: java.lang.Throwable -> Lb2
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lb2
            if (r7 == 0) goto Lb1
            goto L57
        Lb1:
            return
        Lb2:
            r8 = move-exception
            r2 = r7
            r7 = r8
            goto Lb7
        Lb6:
            r7 = move-exception
        Lb7:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lb6
            throw r7     // Catch: java.lang.Throwable -> Lb9
        Lb9:
            r7 = move-exception
            if (r2 == 0) goto Lc1
            com.bumptech.glide.load.engine.Engine r8 = r6.engine
            r8.release(r2)
        Lc1:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.onResourceReady(com.bumptech.glide.load.engine.Resource, com.bumptech.glide.load.DataSource, boolean):void");
    }

    private void onResourceReady(com.bumptech.glide.load.engine.Resource<R> resource, R r, com.bumptech.glide.load.DataSource dataSource, boolean z) {
        boolean z2;
        boolean z3;
        boolean zIsFirstReadyResource = isFirstReadyResource();
        this.status = com.bumptech.glide.request.SingleRequest.Status.COMPLETE;
        this.resource = resource;
        if (this.glideContext.getLogLevel() <= 3) {
            android.util.Log.d(GLIDE_TAG, "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.model + " with size [" + this.width + com.taobao.weex.common.Constants.Name.X + this.height + "] in " + com.bumptech.glide.util.LogTime.getElapsedMillis(this.startTime) + " ms");
        }
        notifyRequestCoordinatorLoadSucceeded();
        boolean z4 = true;
        this.isCallingCallbacks = true;
        try {
            java.util.List<com.bumptech.glide.request.RequestListener<R>> list = this.requestListeners;
            if (list != null) {
                z2 = false;
                for (com.bumptech.glide.request.RequestListener<R> requestListener : list) {
                    R r2 = r;
                    com.bumptech.glide.load.DataSource dataSource2 = dataSource;
                    boolean zOnResourceReady = requestListener.onResourceReady(r2, this.model, this.target, dataSource2, zIsFirstReadyResource) | z2;
                    if (requestListener instanceof com.bumptech.glide.request.ExperimentalRequestListener) {
                        z3 = z;
                        zOnResourceReady |= ((com.bumptech.glide.request.ExperimentalRequestListener) requestListener).onResourceReady(r2, this.model, this.target, dataSource2, zIsFirstReadyResource, z3);
                    } else {
                        z3 = z;
                    }
                    dataSource = dataSource2;
                    z = z3;
                    z2 = zOnResourceReady;
                    r = r2;
                }
            } else {
                z2 = false;
            }
            R r3 = r;
            com.bumptech.glide.load.DataSource dataSource3 = dataSource;
            com.bumptech.glide.request.RequestListener<R> requestListener2 = this.targetListener;
            if (requestListener2 == null || !requestListener2.onResourceReady(r3, this.model, this.target, dataSource3, zIsFirstReadyResource)) {
                z4 = false;
            }
            if (!(z4 | z2)) {
                this.target.onResourceReady(r3, this.animationFactory.build(dataSource3, zIsFirstReadyResource));
            }
            this.isCallingCallbacks = false;
            com.bumptech.glide.util.pool.GlideTrace.endSectionAsync(TAG, this.cookie);
        } catch (java.lang.Throwable th) {
            this.isCallingCallbacks = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void onLoadFailed(com.bumptech.glide.load.engine.GlideException glideException) {
        onLoadFailed(glideException, 5);
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public java.lang.Object getLock() {
        this.stateVerifier.throwIfRecycled();
        return this.requestLock;
    }

    private void onLoadFailed(com.bumptech.glide.load.engine.GlideException glideException, int i) {
        boolean zOnLoadFailed;
        this.stateVerifier.throwIfRecycled();
        synchronized (this.requestLock) {
            glideException.setOrigin(this.requestOrigin);
            int logLevel = this.glideContext.getLogLevel();
            if (logLevel <= i) {
                android.util.Log.w(GLIDE_TAG, "Load failed for [" + this.model + "] with dimensions [" + this.width + com.taobao.weex.common.Constants.Name.X + this.height + com.taobao.weex.el.parse.Operators.ARRAY_END_STR, glideException);
                if (logLevel <= 4) {
                    glideException.logRootCauses(GLIDE_TAG);
                }
            }
            this.loadStatus = null;
            this.status = com.bumptech.glide.request.SingleRequest.Status.FAILED;
            notifyRequestCoordinatorLoadFailed();
            boolean z = true;
            this.isCallingCallbacks = true;
            try {
                java.util.List<com.bumptech.glide.request.RequestListener<R>> list = this.requestListeners;
                if (list != null) {
                    java.util.Iterator<com.bumptech.glide.request.RequestListener<R>> it = list.iterator();
                    zOnLoadFailed = false;
                    while (it.hasNext()) {
                        zOnLoadFailed |= it.next().onLoadFailed(glideException, this.model, this.target, isFirstReadyResource());
                    }
                } else {
                    zOnLoadFailed = false;
                }
                com.bumptech.glide.request.RequestListener<R> requestListener = this.targetListener;
                if (requestListener == null || !requestListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource())) {
                    z = false;
                }
                if (!(zOnLoadFailed | z)) {
                    setErrorPlaceholder();
                }
                this.isCallingCallbacks = false;
                com.bumptech.glide.util.pool.GlideTrace.endSectionAsync(TAG, this.cookie);
            } catch (java.lang.Throwable th) {
                this.isCallingCallbacks = false;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(com.bumptech.glide.request.Request request) {
        int i;
        int i2;
        java.lang.Object obj;
        java.lang.Class<R> cls;
        com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions;
        com.bumptech.glide.Priority priority;
        int size;
        int i3;
        int i4;
        java.lang.Object obj2;
        java.lang.Class<R> cls2;
        com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions2;
        com.bumptech.glide.Priority priority2;
        int size2;
        if (!(request instanceof com.bumptech.glide.request.SingleRequest)) {
            return false;
        }
        synchronized (this.requestLock) {
            i = this.overrideWidth;
            i2 = this.overrideHeight;
            obj = this.model;
            cls = this.transcodeClass;
            baseRequestOptions = this.requestOptions;
            priority = this.priority;
            java.util.List<com.bumptech.glide.request.RequestListener<R>> list = this.requestListeners;
            size = list != null ? list.size() : 0;
        }
        com.bumptech.glide.request.SingleRequest singleRequest = (com.bumptech.glide.request.SingleRequest) request;
        synchronized (singleRequest.requestLock) {
            i3 = singleRequest.overrideWidth;
            i4 = singleRequest.overrideHeight;
            obj2 = singleRequest.model;
            cls2 = singleRequest.transcodeClass;
            baseRequestOptions2 = singleRequest.requestOptions;
            priority2 = singleRequest.priority;
            java.util.List<com.bumptech.glide.request.RequestListener<R>> list2 = singleRequest.requestListeners;
            size2 = list2 != null ? list2.size() : 0;
        }
        return i == i3 && i2 == i4 && com.bumptech.glide.util.Util.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && com.bumptech.glide.util.Util.bothBaseRequestOptionsNullEquivalentOrEquals(baseRequestOptions, baseRequestOptions2) && priority == priority2 && size == size2;
    }

    private void logV(java.lang.String str) {
        android.util.Log.v(TAG, str + " this: " + this.tag);
    }

    public java.lang.String toString() {
        java.lang.Object obj;
        java.lang.Class<R> cls;
        synchronized (this.requestLock) {
            obj = this.model;
            cls = this.transcodeClass;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + com.taobao.weex.el.parse.Operators.ARRAY_END_STR;
    }
}
