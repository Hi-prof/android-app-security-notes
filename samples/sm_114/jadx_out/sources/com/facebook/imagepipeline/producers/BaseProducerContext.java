package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class BaseProducerContext implements com.facebook.imagepipeline.producers.ProducerContext {
    private static final java.lang.String ORIGIN_SUBCATEGORY_DEFAULT = "default";
    private final java.util.List<com.facebook.imagepipeline.producers.ProducerContextCallbacks> mCallbacks;
    private final java.lang.Object mCallerContext;
    private final java.util.Map<java.lang.String, java.lang.Object> mExtras;
    private final java.lang.String mId;
    private final com.facebook.imagepipeline.core.ImagePipelineConfigInterface mImagePipelineConfig;
    private final com.facebook.imagepipeline.request.ImageRequest mImageRequest;
    private boolean mIsCancelled;
    private boolean mIsIntermediateResultExpected;
    private boolean mIsPrefetch;
    private final com.facebook.imagepipeline.request.ImageRequest.RequestLevel mLowestPermittedRequestLevel;
    private com.facebook.imagepipeline.common.Priority mPriority;
    private final com.facebook.imagepipeline.producers.ProducerListener2 mProducerListener;

    @javax.annotation.Nullable
    private final java.lang.String mUiComponentId;
    public static final java.util.Set<java.lang.String> INITIAL_KEYS = com.facebook.common.internal.ImmutableSet.of((java.lang.Object[]) new java.lang.String[]{"id", "uri_source"});
    public static final java.lang.Object CALLER_CONTEXT_UNSET = new java.lang.Object();

    public BaseProducerContext(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.String str, com.facebook.imagepipeline.producers.ProducerListener2 producerListener2, @javax.annotation.Nullable java.lang.Object obj, com.facebook.imagepipeline.request.ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, com.facebook.imagepipeline.common.Priority priority, com.facebook.imagepipeline.core.ImagePipelineConfigInterface imagePipelineConfigInterface) {
        this(imageRequest, str, null, null, producerListener2, obj, requestLevel, z, z2, priority, imagePipelineConfigInterface);
    }

    public BaseProducerContext(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.String str, @javax.annotation.Nullable java.lang.String str2, @javax.annotation.Nullable java.util.Map<java.lang.String, ?> map, com.facebook.imagepipeline.producers.ProducerListener2 producerListener2, @javax.annotation.Nullable java.lang.Object obj, com.facebook.imagepipeline.request.ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, com.facebook.imagepipeline.common.Priority priority, com.facebook.imagepipeline.core.ImagePipelineConfigInterface imagePipelineConfigInterface) {
        this.mImageRequest = imageRequest;
        this.mId = str;
        java.util.HashMap map2 = new java.util.HashMap();
        this.mExtras = map2;
        map2.put("id", str);
        map2.put("uri_source", imageRequest == null ? "null-request" : imageRequest.getSourceUri());
        putExtras(map);
        this.mUiComponentId = str2;
        this.mProducerListener = producerListener2;
        this.mCallerContext = obj == null ? CALLER_CONTEXT_UNSET : obj;
        this.mLowestPermittedRequestLevel = requestLevel;
        this.mIsPrefetch = z;
        this.mPriority = priority;
        this.mIsIntermediateResultExpected = z2;
        this.mIsCancelled = false;
        this.mCallbacks = new java.util.ArrayList();
        this.mImagePipelineConfig = imagePipelineConfigInterface;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public com.facebook.imagepipeline.request.ImageRequest getImageRequest() {
        return this.mImageRequest;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public java.lang.String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    @javax.annotation.Nullable
    public java.lang.String getUiComponentId() {
        return this.mUiComponentId;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public com.facebook.imagepipeline.producers.ProducerListener2 getProducerListener() {
        return this.mProducerListener;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public java.lang.Object getCallerContext() {
        return this.mCallerContext;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public com.facebook.imagepipeline.request.ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized boolean isPrefetch() {
        return this.mIsPrefetch;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized com.facebook.imagepipeline.common.Priority getPriority() {
        return this.mPriority;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized boolean isIntermediateResultExpected() {
        return this.mIsIntermediateResultExpected;
    }

    public synchronized boolean isCancelled() {
        return this.mIsCancelled;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void addCallbacks(com.facebook.imagepipeline.producers.ProducerContextCallbacks producerContextCallbacks) {
        boolean z;
        synchronized (this) {
            this.mCallbacks.add(producerContextCallbacks);
            z = this.mIsCancelled;
        }
        if (z) {
            producerContextCallbacks.onCancellationRequested();
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public com.facebook.imagepipeline.core.ImagePipelineConfigInterface getImagePipelineConfig() {
        return this.mImagePipelineConfig;
    }

    public void cancel() {
        callOnCancellationRequested(cancelNoCallbacks());
    }

    @javax.annotation.Nullable
    public synchronized java.util.List<com.facebook.imagepipeline.producers.ProducerContextCallbacks> setIsPrefetchNoCallbacks(boolean z) {
        if (z == this.mIsPrefetch) {
            return null;
        }
        this.mIsPrefetch = z;
        return new java.util.ArrayList(this.mCallbacks);
    }

    @javax.annotation.Nullable
    public synchronized java.util.List<com.facebook.imagepipeline.producers.ProducerContextCallbacks> setPriorityNoCallbacks(com.facebook.imagepipeline.common.Priority priority) {
        if (priority == this.mPriority) {
            return null;
        }
        this.mPriority = priority;
        return new java.util.ArrayList(this.mCallbacks);
    }

    @javax.annotation.Nullable
    public synchronized java.util.List<com.facebook.imagepipeline.producers.ProducerContextCallbacks> setIsIntermediateResultExpectedNoCallbacks(boolean z) {
        if (z == this.mIsIntermediateResultExpected) {
            return null;
        }
        this.mIsIntermediateResultExpected = z;
        return new java.util.ArrayList(this.mCallbacks);
    }

    @javax.annotation.Nullable
    public synchronized java.util.List<com.facebook.imagepipeline.producers.ProducerContextCallbacks> cancelNoCallbacks() {
        if (this.mIsCancelled) {
            return null;
        }
        this.mIsCancelled = true;
        return new java.util.ArrayList(this.mCallbacks);
    }

    public static void callOnCancellationRequested(@javax.annotation.Nullable java.util.List<com.facebook.imagepipeline.producers.ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        java.util.Iterator<com.facebook.imagepipeline.producers.ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().onCancellationRequested();
        }
    }

    public static void callOnIsPrefetchChanged(@javax.annotation.Nullable java.util.List<com.facebook.imagepipeline.producers.ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        java.util.Iterator<com.facebook.imagepipeline.producers.ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().onIsPrefetchChanged();
        }
    }

    public static void callOnIsIntermediateResultExpectedChanged(@javax.annotation.Nullable java.util.List<com.facebook.imagepipeline.producers.ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        java.util.Iterator<com.facebook.imagepipeline.producers.ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().onIsIntermediateResultExpectedChanged();
        }
    }

    public static void callOnPriorityChanged(@javax.annotation.Nullable java.util.List<com.facebook.imagepipeline.producers.ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        java.util.Iterator<com.facebook.imagepipeline.producers.ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().onPriorityChanged();
        }
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public void putExtra(java.lang.String str, @javax.annotation.Nullable java.lang.Object obj) {
        if (INITIAL_KEYS.contains(str)) {
            return;
        }
        this.mExtras.put(str, obj);
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public void putExtras(@javax.annotation.Nullable java.util.Map<java.lang.String, ?> map) {
        if (map == null) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, ?> entry : map.entrySet()) {
            putExtra(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    @javax.annotation.Nullable
    public <T> T getExtra(java.lang.String str) {
        return (T) this.mExtras.get(str);
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    @javax.annotation.Nullable
    public <E> E getExtra(java.lang.String str, @javax.annotation.Nullable E e) {
        E e2 = (E) this.mExtras.get(str);
        return e2 == null ? e : e2;
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public java.util.Map<java.lang.String, java.lang.Object> getExtras() {
        return this.mExtras;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void putOriginExtra(@javax.annotation.Nullable java.lang.String str, @javax.annotation.Nullable java.lang.String str2) {
        this.mExtras.put("origin", str);
        this.mExtras.put("origin_sub", str2);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void putOriginExtra(@javax.annotation.Nullable java.lang.String str) {
        putOriginExtra(str, "default");
    }
}
