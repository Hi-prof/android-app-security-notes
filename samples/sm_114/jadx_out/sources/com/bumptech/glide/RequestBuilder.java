package com.bumptech.glide;

/* JADX INFO: loaded from: classes.dex */
public class RequestBuilder<TranscodeType> extends com.bumptech.glide.request.BaseRequestOptions<com.bumptech.glide.RequestBuilder<TranscodeType>> implements java.lang.Cloneable, com.bumptech.glide.ModelTypes<com.bumptech.glide.RequestBuilder<TranscodeType>> {
    protected static final com.bumptech.glide.request.RequestOptions DOWNLOAD_ONLY_OPTIONS = new com.bumptech.glide.request.RequestOptions().diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.DATA).priority(com.bumptech.glide.Priority.LOW).skipMemoryCache(true);
    private final android.content.Context context;
    private com.bumptech.glide.RequestBuilder<TranscodeType> errorBuilder;
    private final com.bumptech.glide.Glide glide;
    private final com.bumptech.glide.GlideContext glideContext;
    private boolean isDefaultTransitionOptionsSet;
    private boolean isModelSet;
    private boolean isThumbnailBuilt;
    private java.lang.Object model;
    private java.util.List<com.bumptech.glide.request.RequestListener<TranscodeType>> requestListeners;
    private final com.bumptech.glide.RequestManager requestManager;
    private java.lang.Float thumbSizeMultiplier;
    private com.bumptech.glide.RequestBuilder<TranscodeType> thumbnailBuilder;
    private final java.lang.Class<TranscodeType> transcodeClass;
    private com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> transitionOptions;

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.BaseRequestOptions apply(com.bumptech.glide.request.BaseRequestOptions baseRequestOptions) {
        return apply((com.bumptech.glide.request.BaseRequestOptions<?>) baseRequestOptions);
    }

    protected RequestBuilder(com.bumptech.glide.Glide glide, com.bumptech.glide.RequestManager requestManager, java.lang.Class<TranscodeType> cls, android.content.Context context) {
        this.isDefaultTransitionOptionsSet = true;
        this.glide = glide;
        this.requestManager = requestManager;
        this.transcodeClass = cls;
        this.context = context;
        this.transitionOptions = requestManager.getDefaultTransitionOptions(cls);
        this.glideContext = glide.getGlideContext();
        initRequestListeners(requestManager.getDefaultRequestListeners());
        apply((com.bumptech.glide.request.BaseRequestOptions<?>) requestManager.getDefaultRequestOptions());
    }

    com.bumptech.glide.RequestManager getRequestManager() {
        return this.requestManager;
    }

    protected RequestBuilder(java.lang.Class<TranscodeType> cls, com.bumptech.glide.RequestBuilder<?> requestBuilder) {
        this(requestBuilder.glide, requestBuilder.requestManager, cls, requestBuilder.context);
        this.model = requestBuilder.model;
        this.isModelSet = requestBuilder.isModelSet;
        apply((com.bumptech.glide.request.BaseRequestOptions<?>) requestBuilder);
    }

    private void initRequestListeners(java.util.List<com.bumptech.glide.request.RequestListener<java.lang.Object>> list) {
        java.util.Iterator<com.bumptech.glide.request.RequestListener<java.lang.Object>> it = list.iterator();
        while (it.hasNext()) {
            addListener((com.bumptech.glide.request.RequestListener) it.next());
        }
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public com.bumptech.glide.RequestBuilder<TranscodeType> apply(com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions) {
        com.bumptech.glide.util.Preconditions.checkNotNull(baseRequestOptions);
        return (com.bumptech.glide.RequestBuilder) super.apply(baseRequestOptions);
    }

    public com.bumptech.glide.RequestBuilder<TranscodeType> transition(com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        if (isAutoCloneEnabled()) {
            return mo206clone().transition(transitionOptions);
        }
        this.transitionOptions = (com.bumptech.glide.TransitionOptions) com.bumptech.glide.util.Preconditions.checkNotNull(transitionOptions);
        this.isDefaultTransitionOptionsSet = false;
        return selfOrThrowIfLocked();
    }

    public com.bumptech.glide.RequestBuilder<TranscodeType> listener(com.bumptech.glide.request.RequestListener<TranscodeType> requestListener) {
        if (isAutoCloneEnabled()) {
            return mo206clone().listener(requestListener);
        }
        this.requestListeners = null;
        return addListener(requestListener);
    }

    public com.bumptech.glide.RequestBuilder<TranscodeType> addListener(com.bumptech.glide.request.RequestListener<TranscodeType> requestListener) {
        if (isAutoCloneEnabled()) {
            return mo206clone().addListener(requestListener);
        }
        if (requestListener != null) {
            if (this.requestListeners == null) {
                this.requestListeners = new java.util.ArrayList();
            }
            this.requestListeners.add(requestListener);
        }
        return selfOrThrowIfLocked();
    }

    public com.bumptech.glide.RequestBuilder<TranscodeType> error(com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder) {
        if (isAutoCloneEnabled()) {
            return mo206clone().error((com.bumptech.glide.RequestBuilder) requestBuilder);
        }
        this.errorBuilder = requestBuilder;
        return selfOrThrowIfLocked();
    }

    public com.bumptech.glide.RequestBuilder<TranscodeType> error(java.lang.Object obj) {
        if (obj == null) {
            return error((com.bumptech.glide.RequestBuilder) null);
        }
        return error((com.bumptech.glide.RequestBuilder) cloneWithNullErrorAndThumbnail().load(obj));
    }

    private com.bumptech.glide.RequestBuilder<TranscodeType> cloneWithNullErrorAndThumbnail() {
        return mo206clone().error((com.bumptech.glide.RequestBuilder) null).thumbnail((com.bumptech.glide.RequestBuilder) null);
    }

    public com.bumptech.glide.RequestBuilder<TranscodeType> thumbnail(com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder) {
        if (isAutoCloneEnabled()) {
            return mo206clone().thumbnail(requestBuilder);
        }
        this.thumbnailBuilder = requestBuilder;
        return selfOrThrowIfLocked();
    }

    public com.bumptech.glide.RequestBuilder<TranscodeType> thumbnail(com.bumptech.glide.RequestBuilder<TranscodeType>... requestBuilderArr) {
        if (requestBuilderArr == null || requestBuilderArr.length == 0) {
            return thumbnail((com.bumptech.glide.RequestBuilder) null);
        }
        return thumbnail(java.util.Arrays.asList(requestBuilderArr));
    }

    public com.bumptech.glide.RequestBuilder<TranscodeType> thumbnail(java.util.List<com.bumptech.glide.RequestBuilder<TranscodeType>> list) {
        com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilderThumbnail = null;
        if (list == null || list.isEmpty()) {
            return thumbnail((com.bumptech.glide.RequestBuilder) null);
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder = list.get(size);
            if (requestBuilder != null) {
                requestBuilderThumbnail = requestBuilderThumbnail == null ? requestBuilder : requestBuilder.thumbnail(requestBuilderThumbnail);
            }
        }
        return thumbnail(requestBuilderThumbnail);
    }

    @java.lang.Deprecated
    public com.bumptech.glide.RequestBuilder<TranscodeType> thumbnail(float f) {
        if (isAutoCloneEnabled()) {
            return mo206clone().thumbnail(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new java.lang.IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.thumbSizeMultiplier = java.lang.Float.valueOf(f);
        return selfOrThrowIfLocked();
    }

    @Override // com.bumptech.glide.ModelTypes
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(java.lang.Object obj) {
        return loadGeneric(obj);
    }

    private com.bumptech.glide.RequestBuilder<TranscodeType> loadGeneric(java.lang.Object obj) {
        if (isAutoCloneEnabled()) {
            return mo206clone().loadGeneric(obj);
        }
        this.model = obj;
        this.isModelSet = true;
        return selfOrThrowIfLocked();
    }

    @Override // com.bumptech.glide.ModelTypes
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(android.graphics.Bitmap bitmap) {
        return loadGeneric(bitmap).apply((com.bumptech.glide.request.BaseRequestOptions<?>) com.bumptech.glide.request.RequestOptions.diskCacheStrategyOf(com.bumptech.glide.load.engine.DiskCacheStrategy.NONE));
    }

    @Override // com.bumptech.glide.ModelTypes
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(android.graphics.drawable.Drawable drawable) {
        return loadGeneric(drawable).apply((com.bumptech.glide.request.BaseRequestOptions<?>) com.bumptech.glide.request.RequestOptions.diskCacheStrategyOf(com.bumptech.glide.load.engine.DiskCacheStrategy.NONE));
    }

    @Override // com.bumptech.glide.ModelTypes
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(java.lang.String str) {
        return loadGeneric(str);
    }

    @Override // com.bumptech.glide.ModelTypes
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(android.net.Uri uri) {
        return maybeApplyOptionsResourceUri(uri, loadGeneric(uri));
    }

    private com.bumptech.glide.RequestBuilder<TranscodeType> maybeApplyOptionsResourceUri(android.net.Uri uri, com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder) {
        return (uri == null || !com.facebook.common.util.UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(uri.getScheme())) ? requestBuilder : applyResourceThemeAndSignature(requestBuilder);
    }

    private com.bumptech.glide.RequestBuilder<TranscodeType> applyResourceThemeAndSignature(com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder) {
        return requestBuilder.theme(this.context.getTheme()).signature(com.bumptech.glide.signature.AndroidResourceSignature.obtain(this.context));
    }

    @Override // com.bumptech.glide.ModelTypes
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(java.io.File file) {
        return loadGeneric(file);
    }

    @Override // com.bumptech.glide.ModelTypes
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(java.lang.Integer num) {
        return applyResourceThemeAndSignature(loadGeneric(num));
    }

    @Override // com.bumptech.glide.ModelTypes
    @java.lang.Deprecated
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(java.net.URL url) {
        return loadGeneric(url);
    }

    @Override // com.bumptech.glide.ModelTypes
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(byte[] bArr) {
        com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilderLoadGeneric = loadGeneric(bArr);
        if (!requestBuilderLoadGeneric.isDiskCacheStrategySet()) {
            requestBuilderLoadGeneric = requestBuilderLoadGeneric.apply((com.bumptech.glide.request.BaseRequestOptions<?>) com.bumptech.glide.request.RequestOptions.diskCacheStrategyOf(com.bumptech.glide.load.engine.DiskCacheStrategy.NONE));
        }
        return !requestBuilderLoadGeneric.isSkipMemoryCacheSet() ? requestBuilderLoadGeneric.apply((com.bumptech.glide.request.BaseRequestOptions<?>) com.bumptech.glide.request.RequestOptions.skipMemoryCacheOf(true)) : requestBuilderLoadGeneric;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* JADX INFO: renamed from: clone */
    public com.bumptech.glide.RequestBuilder<TranscodeType> mo206clone() {
        com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder = (com.bumptech.glide.RequestBuilder) super.mo206clone();
        requestBuilder.transitionOptions = requestBuilder.transitionOptions.m207clone();
        if (requestBuilder.requestListeners != null) {
            requestBuilder.requestListeners = new java.util.ArrayList(requestBuilder.requestListeners);
        }
        com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder2 = requestBuilder.thumbnailBuilder;
        if (requestBuilder2 != null) {
            requestBuilder.thumbnailBuilder = requestBuilder2.mo206clone();
        }
        com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder3 = requestBuilder.errorBuilder;
        if (requestBuilder3 != null) {
            requestBuilder.errorBuilder = requestBuilder3.mo206clone();
        }
        return requestBuilder;
    }

    public <Y extends com.bumptech.glide.request.target.Target<TranscodeType>> Y into(Y y) {
        return (Y) into(y, null, com.bumptech.glide.util.Executors.mainThreadExecutor());
    }

    <Y extends com.bumptech.glide.request.target.Target<TranscodeType>> Y into(Y y, com.bumptech.glide.request.RequestListener<TranscodeType> requestListener, java.util.concurrent.Executor executor) {
        return (Y) into(y, requestListener, this, executor);
    }

    private <Y extends com.bumptech.glide.request.target.Target<TranscodeType>> Y into(Y y, com.bumptech.glide.request.RequestListener<TranscodeType> requestListener, com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, java.util.concurrent.Executor executor) {
        com.bumptech.glide.util.Preconditions.checkNotNull(y);
        if (!this.isModelSet) {
            throw new java.lang.IllegalArgumentException("You must call #load() before calling #into()");
        }
        com.bumptech.glide.request.Request requestBuildRequest = buildRequest(y, requestListener, baseRequestOptions, executor);
        com.bumptech.glide.request.Request request = y.getRequest();
        if (requestBuildRequest.isEquivalentTo(request) && !isSkipMemoryCacheWithCompletePreviousRequest(baseRequestOptions, request)) {
            if (!((com.bumptech.glide.request.Request) com.bumptech.glide.util.Preconditions.checkNotNull(request)).isRunning()) {
                request.begin();
            }
            return y;
        }
        this.requestManager.clear((com.bumptech.glide.request.target.Target<?>) y);
        y.setRequest(requestBuildRequest);
        this.requestManager.track(y, requestBuildRequest);
        return y;
    }

    private boolean isSkipMemoryCacheWithCompletePreviousRequest(com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, com.bumptech.glide.request.Request request) {
        return !baseRequestOptions.isMemoryCacheable() && request.isComplete();
    }

    public com.bumptech.glide.request.target.ViewTarget<android.widget.ImageView, TranscodeType> into(android.widget.ImageView imageView) {
        com.bumptech.glide.request.BaseRequestOptions baseRequestOptionsOptionalCenterCrop;
        com.bumptech.glide.util.Util.assertMainThread();
        com.bumptech.glide.util.Preconditions.checkNotNull(imageView);
        if (!isTransformationSet() && isTransformationAllowed() && imageView.getScaleType() != null) {
            switch (com.bumptech.glide.RequestBuilder.AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()]) {
                case 1:
                    baseRequestOptionsOptionalCenterCrop = mo206clone().optionalCenterCrop();
                    break;
                case 2:
                    baseRequestOptionsOptionalCenterCrop = mo206clone().optionalCenterInside();
                    break;
                case 3:
                case 4:
                case 5:
                    baseRequestOptionsOptionalCenterCrop = mo206clone().optionalFitCenter();
                    break;
                case 6:
                    baseRequestOptionsOptionalCenterCrop = mo206clone().optionalCenterInside();
                    break;
                default:
                    baseRequestOptionsOptionalCenterCrop = this;
                    break;
            }
        } else {
            baseRequestOptionsOptionalCenterCrop = this;
        }
        return (com.bumptech.glide.request.target.ViewTarget) into(this.glideContext.buildImageViewTarget(imageView, this.transcodeClass), null, baseRequestOptionsOptionalCenterCrop, com.bumptech.glide.util.Executors.mainThreadExecutor());
    }

    @java.lang.Deprecated
    public com.bumptech.glide.request.FutureTarget<TranscodeType> into(int i, int i2) {
        return submit(i, i2);
    }

    public com.bumptech.glide.request.FutureTarget<TranscodeType> submit() {
        return submit(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public com.bumptech.glide.request.FutureTarget<TranscodeType> submit(int i, int i2) {
        com.bumptech.glide.request.RequestFutureTarget requestFutureTarget = new com.bumptech.glide.request.RequestFutureTarget(i, i2);
        return (com.bumptech.glide.request.FutureTarget) into(requestFutureTarget, requestFutureTarget, com.bumptech.glide.util.Executors.directExecutor());
    }

    public com.bumptech.glide.request.target.Target<TranscodeType> preload(int i, int i2) {
        return into(com.bumptech.glide.request.target.PreloadTarget.obtain(this.requestManager, i, i2));
    }

    public com.bumptech.glide.request.target.Target<TranscodeType> preload() {
        return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @java.lang.Deprecated
    public <Y extends com.bumptech.glide.request.target.Target<java.io.File>> Y downloadOnly(Y y) {
        return (Y) getDownloadOnlyRequest().into(y);
    }

    @java.lang.Deprecated
    public com.bumptech.glide.request.FutureTarget<java.io.File> downloadOnly(int i, int i2) {
        return getDownloadOnlyRequest().submit(i, i2);
    }

    protected com.bumptech.glide.RequestBuilder<java.io.File> getDownloadOnlyRequest() {
        return new com.bumptech.glide.RequestBuilder(java.io.File.class, this).apply((com.bumptech.glide.request.BaseRequestOptions<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    /* JADX INFO: renamed from: com.bumptech.glide.RequestBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$Priority;

        static {
            int[] iArr = new int[com.bumptech.glide.Priority.values().length];
            $SwitchMap$com$bumptech$glide$Priority = iArr;
            try {
                iArr[com.bumptech.glide.Priority.LOW.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bumptech$glide$Priority[com.bumptech.glide.Priority.NORMAL.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bumptech$glide$Priority[com.bumptech.glide.Priority.HIGH.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bumptech$glide$Priority[com.bumptech.glide.Priority.IMMEDIATE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[android.widget.ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr2;
            try {
                iArr2[android.widget.ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
        }
    }

    private com.bumptech.glide.Priority getThumbnailPriority(com.bumptech.glide.Priority priority) {
        int i = com.bumptech.glide.RequestBuilder.AnonymousClass1.$SwitchMap$com$bumptech$glide$Priority[priority.ordinal()];
        if (i == 1) {
            return com.bumptech.glide.Priority.NORMAL;
        }
        if (i == 2) {
            return com.bumptech.glide.Priority.HIGH;
        }
        if (i == 3 || i == 4) {
            return com.bumptech.glide.Priority.IMMEDIATE;
        }
        throw new java.lang.IllegalArgumentException("unknown priority: " + getPriority());
    }

    private com.bumptech.glide.request.Request buildRequest(com.bumptech.glide.request.target.Target<TranscodeType> target, com.bumptech.glide.request.RequestListener<TranscodeType> requestListener, com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, java.util.concurrent.Executor executor) {
        return buildRequestRecursive(new java.lang.Object(), target, requestListener, null, this.transitionOptions, baseRequestOptions.getPriority(), baseRequestOptions.getOverrideWidth(), baseRequestOptions.getOverrideHeight(), baseRequestOptions, executor);
    }

    private com.bumptech.glide.request.Request buildRequestRecursive(java.lang.Object obj, com.bumptech.glide.request.target.Target<TranscodeType> target, com.bumptech.glide.request.RequestListener<TranscodeType> requestListener, com.bumptech.glide.request.RequestCoordinator requestCoordinator, com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> transitionOptions, com.bumptech.glide.Priority priority, int i, int i2, com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, java.util.concurrent.Executor executor) {
        com.bumptech.glide.request.ErrorRequestCoordinator errorRequestCoordinator;
        com.bumptech.glide.request.RequestCoordinator requestCoordinator2;
        if (this.errorBuilder != null) {
            errorRequestCoordinator = new com.bumptech.glide.request.ErrorRequestCoordinator(obj, requestCoordinator);
            requestCoordinator2 = errorRequestCoordinator;
        } else {
            errorRequestCoordinator = null;
            requestCoordinator2 = requestCoordinator;
        }
        com.bumptech.glide.request.Request requestBuildThumbnailRequestRecursive = buildThumbnailRequestRecursive(obj, target, requestListener, requestCoordinator2, transitionOptions, priority, i, i2, baseRequestOptions, executor);
        if (errorRequestCoordinator == null) {
            return requestBuildThumbnailRequestRecursive;
        }
        int overrideWidth = this.errorBuilder.getOverrideWidth();
        int overrideHeight = this.errorBuilder.getOverrideHeight();
        if (com.bumptech.glide.util.Util.isValidDimensions(i, i2) && !this.errorBuilder.isValidOverride()) {
            overrideWidth = baseRequestOptions.getOverrideWidth();
            overrideHeight = baseRequestOptions.getOverrideHeight();
        }
        com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder = this.errorBuilder;
        com.bumptech.glide.request.ErrorRequestCoordinator errorRequestCoordinator2 = errorRequestCoordinator;
        errorRequestCoordinator2.setRequests(requestBuildThumbnailRequestRecursive, requestBuilder.buildRequestRecursive(obj, target, requestListener, errorRequestCoordinator2, requestBuilder.transitionOptions, requestBuilder.getPriority(), overrideWidth, overrideHeight, this.errorBuilder, executor));
        return errorRequestCoordinator2;
    }

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
    private com.bumptech.glide.request.Request buildThumbnailRequestRecursive(java.lang.Object obj, com.bumptech.glide.request.target.Target<TranscodeType> target, com.bumptech.glide.request.RequestListener<TranscodeType> requestListener, com.bumptech.glide.request.RequestCoordinator requestCoordinator, com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> transitionOptions, com.bumptech.glide.Priority priority, int i, int i2, com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, java.util.concurrent.Executor executor) {
        com.bumptech.glide.Priority thumbnailPriority;
        com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder = this.thumbnailBuilder;
        if (requestBuilder != null) {
            if (this.isThumbnailBuilt) {
                throw new java.lang.IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> transitionOptions2 = requestBuilder.isDefaultTransitionOptionsSet ? transitionOptions : requestBuilder.transitionOptions;
            if (requestBuilder.isPrioritySet()) {
                thumbnailPriority = this.thumbnailBuilder.getPriority();
            } else {
                thumbnailPriority = getThumbnailPriority(priority);
            }
            com.bumptech.glide.Priority priority2 = thumbnailPriority;
            int overrideWidth = this.thumbnailBuilder.getOverrideWidth();
            int overrideHeight = this.thumbnailBuilder.getOverrideHeight();
            if (com.bumptech.glide.util.Util.isValidDimensions(i, i2) && !this.thumbnailBuilder.isValidOverride()) {
                overrideWidth = baseRequestOptions.getOverrideWidth();
                overrideHeight = baseRequestOptions.getOverrideHeight();
            }
            com.bumptech.glide.request.ThumbnailRequestCoordinator thumbnailRequestCoordinator = new com.bumptech.glide.request.ThumbnailRequestCoordinator(obj, requestCoordinator);
            com.bumptech.glide.request.Request requestObtainRequest = obtainRequest(obj, target, requestListener, baseRequestOptions, thumbnailRequestCoordinator, transitionOptions, priority, i, i2, executor);
            this.isThumbnailBuilt = true;
            com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder2 = this.thumbnailBuilder;
            com.bumptech.glide.request.Request requestBuildRequestRecursive = requestBuilder2.buildRequestRecursive(obj, target, requestListener, thumbnailRequestCoordinator, transitionOptions2, priority2, overrideWidth, overrideHeight, requestBuilder2, executor);
            this.isThumbnailBuilt = false;
            thumbnailRequestCoordinator.setRequests(requestObtainRequest, requestBuildRequestRecursive);
            return thumbnailRequestCoordinator;
        }
        if (this.thumbSizeMultiplier != null) {
            com.bumptech.glide.request.ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new com.bumptech.glide.request.ThumbnailRequestCoordinator(obj, requestCoordinator);
            thumbnailRequestCoordinator2.setRequests(obtainRequest(obj, target, requestListener, baseRequestOptions, thumbnailRequestCoordinator2, transitionOptions, priority, i, i2, executor), obtainRequest(obj, target, requestListener, baseRequestOptions.mo206clone().sizeMultiplier(this.thumbSizeMultiplier.floatValue()), thumbnailRequestCoordinator2, transitionOptions, getThumbnailPriority(priority), i, i2, executor));
            return thumbnailRequestCoordinator2;
        }
        return obtainRequest(obj, target, requestListener, baseRequestOptions, requestCoordinator, transitionOptions, priority, i, i2, executor);
    }

    private com.bumptech.glide.request.Request obtainRequest(java.lang.Object obj, com.bumptech.glide.request.target.Target<TranscodeType> target, com.bumptech.glide.request.RequestListener<TranscodeType> requestListener, com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, com.bumptech.glide.request.RequestCoordinator requestCoordinator, com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> transitionOptions, com.bumptech.glide.Priority priority, int i, int i2, java.util.concurrent.Executor executor) {
        android.content.Context context = this.context;
        com.bumptech.glide.GlideContext glideContext = this.glideContext;
        return com.bumptech.glide.request.SingleRequest.obtain(context, glideContext, obj, this.model, this.transcodeClass, baseRequestOptions, i, i2, priority, target, requestListener, this.requestListeners, requestCoordinator, glideContext.getEngine(), transitionOptions.getTransitionFactory(), executor);
    }

    java.lang.Object getModel() {
        return this.model;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.bumptech.glide.RequestBuilder) {
            com.bumptech.glide.RequestBuilder requestBuilder = (com.bumptech.glide.RequestBuilder) obj;
            if (super.equals(requestBuilder) && java.util.Objects.equals(this.transcodeClass, requestBuilder.transcodeClass) && this.transitionOptions.equals(requestBuilder.transitionOptions) && java.util.Objects.equals(this.model, requestBuilder.model) && java.util.Objects.equals(this.requestListeners, requestBuilder.requestListeners) && java.util.Objects.equals(this.thumbnailBuilder, requestBuilder.thumbnailBuilder) && java.util.Objects.equals(this.errorBuilder, requestBuilder.errorBuilder) && java.util.Objects.equals(this.thumbSizeMultiplier, requestBuilder.thumbSizeMultiplier) && this.isDefaultTransitionOptionsSet == requestBuilder.isDefaultTransitionOptionsSet && this.isModelSet == requestBuilder.isModelSet) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public int hashCode() {
        return com.bumptech.glide.util.Util.hashCode(this.isModelSet, com.bumptech.glide.util.Util.hashCode(this.isDefaultTransitionOptionsSet, com.bumptech.glide.util.Util.hashCode(this.thumbSizeMultiplier, com.bumptech.glide.util.Util.hashCode(this.errorBuilder, com.bumptech.glide.util.Util.hashCode(this.thumbnailBuilder, com.bumptech.glide.util.Util.hashCode(this.requestListeners, com.bumptech.glide.util.Util.hashCode(this.model, com.bumptech.glide.util.Util.hashCode(this.transitionOptions, com.bumptech.glide.util.Util.hashCode(this.transcodeClass, super.hashCode())))))))));
    }
}
