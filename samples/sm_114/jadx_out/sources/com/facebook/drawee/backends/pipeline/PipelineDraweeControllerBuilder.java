package com.facebook.drawee.backends.pipeline;

/* JADX INFO: loaded from: classes.dex */
public class PipelineDraweeControllerBuilder extends com.facebook.drawee.controller.AbstractDraweeControllerBuilder<com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder, com.facebook.imagepipeline.request.ImageRequest, com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>, com.facebook.imagepipeline.image.ImageInfo> {

    @javax.annotation.Nullable
    private com.facebook.common.internal.ImmutableList<com.facebook.imagepipeline.drawable.DrawableFactory> mCustomDrawableFactories;

    @javax.annotation.Nullable
    private com.facebook.drawee.backends.pipeline.info.ImageOriginListener mImageOriginListener;

    @javax.annotation.Nullable
    private com.facebook.fresco.ui.common.ImagePerfDataListener mImagePerfDataListener;
    private final com.facebook.imagepipeline.core.ImagePipeline mImagePipeline;
    private final com.facebook.drawee.backends.pipeline.PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    public PipelineDraweeControllerBuilder(android.content.Context context, com.facebook.drawee.backends.pipeline.PipelineDraweeControllerFactory pipelineDraweeControllerFactory, com.facebook.imagepipeline.core.ImagePipeline imagePipeline, java.util.Set<com.facebook.drawee.controller.ControllerListener> set, java.util.Set<com.facebook.fresco.ui.common.ControllerListener2> set2) {
        super(context, set, set2);
        this.mImagePipeline = imagePipeline;
        this.mPipelineDraweeControllerFactory = pipelineDraweeControllerFactory;
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder setUri(@javax.annotation.Nullable android.net.Uri uri) {
        if (uri == null) {
            return (com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder) super.setImageRequest(null);
        }
        return (com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder) super.setImageRequest(com.facebook.imagepipeline.request.ImageRequestBuilder.newBuilderWithSource(uri).setRotationOptions(com.facebook.imagepipeline.common.RotationOptions.autoRotateAtRenderTime()).build());
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder setUri(@javax.annotation.Nullable java.lang.String str) {
        if (str == null || str.isEmpty()) {
            return (com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder) super.setImageRequest(com.facebook.imagepipeline.request.ImageRequest.fromUri(str));
        }
        return setUri(android.net.Uri.parse(str));
    }

    public com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder setCustomDrawableFactories(@javax.annotation.Nullable com.facebook.common.internal.ImmutableList<com.facebook.imagepipeline.drawable.DrawableFactory> immutableList) {
        this.mCustomDrawableFactories = immutableList;
        return getThis();
    }

    public com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder setCustomDrawableFactories(com.facebook.imagepipeline.drawable.DrawableFactory... drawableFactoryArr) {
        com.facebook.common.internal.Preconditions.checkNotNull(drawableFactoryArr);
        return setCustomDrawableFactories(com.facebook.common.internal.ImmutableList.of((java.lang.Object[]) drawableFactoryArr));
    }

    public com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder setCustomDrawableFactory(com.facebook.imagepipeline.drawable.DrawableFactory drawableFactory) {
        com.facebook.common.internal.Preconditions.checkNotNull(drawableFactory);
        return setCustomDrawableFactories(com.facebook.common.internal.ImmutableList.of((java.lang.Object[]) new com.facebook.imagepipeline.drawable.DrawableFactory[]{drawableFactory}));
    }

    public com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder setImageOriginListener(@javax.annotation.Nullable com.facebook.drawee.backends.pipeline.info.ImageOriginListener imageOriginListener) {
        this.mImageOriginListener = imageOriginListener;
        return getThis();
    }

    public com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder setPerfDataListener(@javax.annotation.Nullable com.facebook.fresco.ui.common.ImagePerfDataListener imagePerfDataListener) {
        this.mImagePerfDataListener = imagePerfDataListener;
        return getThis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.drawee.backends.pipeline.PipelineDraweeController obtainController() {
        com.facebook.drawee.backends.pipeline.PipelineDraweeController pipelineDraweeControllerNewController;
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("PipelineDraweeControllerBuilder#obtainController");
        }
        try {
            com.facebook.drawee.interfaces.DraweeController oldController = getOldController();
            java.lang.String strGenerateUniqueControllerId = generateUniqueControllerId();
            if (oldController instanceof com.facebook.drawee.backends.pipeline.PipelineDraweeController) {
                pipelineDraweeControllerNewController = (com.facebook.drawee.backends.pipeline.PipelineDraweeController) oldController;
            } else {
                pipelineDraweeControllerNewController = this.mPipelineDraweeControllerFactory.newController();
            }
            com.facebook.drawee.backends.pipeline.PipelineDraweeController pipelineDraweeController = pipelineDraweeControllerNewController;
            pipelineDraweeController.initialize(obtainDataSourceSupplier(pipelineDraweeController, strGenerateUniqueControllerId), strGenerateUniqueControllerId, getCacheKey(), getCallerContext(), this.mCustomDrawableFactories);
            pipelineDraweeController.initializePerformanceMonitoring(this.mImagePerfDataListener, this);
            return pipelineDraweeController;
        } finally {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
        }
    }

    @javax.annotation.Nullable
    private com.facebook.cache.common.CacheKey getCacheKey() {
        com.facebook.imagepipeline.request.ImageRequest imageRequest = getImageRequest();
        com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory = this.mImagePipeline.getCacheKeyFactory();
        if (cacheKeyFactory == null || imageRequest == null) {
            return null;
        }
        if (imageRequest.getPostprocessor() != null) {
            return cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, getCallerContext());
        }
        return cacheKeyFactory.getBitmapCacheKey(imageRequest, getCallerContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getDataSourceForRequest(com.facebook.drawee.interfaces.DraweeController draweeController, java.lang.String str, com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object obj, com.facebook.drawee.controller.AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.mImagePipeline.fetchDecodedImage(imageRequest, obj, convertCacheLevelToRequestLevel(cacheLevel), getRequestListener(draweeController), str);
    }

    @javax.annotation.Nullable
    protected com.facebook.imagepipeline.listener.RequestListener getRequestListener(com.facebook.drawee.interfaces.DraweeController draweeController) {
        if (draweeController instanceof com.facebook.drawee.backends.pipeline.PipelineDraweeController) {
            return ((com.facebook.drawee.backends.pipeline.PipelineDraweeController) draweeController).getRequestListener();
        }
        return null;
    }

    /* JADX INFO: renamed from: com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$drawee$controller$AbstractDraweeControllerBuilder$CacheLevel;

        static {
            int[] iArr = new int[com.facebook.drawee.controller.AbstractDraweeControllerBuilder.CacheLevel.values().length];
            $SwitchMap$com$facebook$drawee$controller$AbstractDraweeControllerBuilder$CacheLevel = iArr;
            try {
                iArr[com.facebook.drawee.controller.AbstractDraweeControllerBuilder.CacheLevel.FULL_FETCH.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$drawee$controller$AbstractDraweeControllerBuilder$CacheLevel[com.facebook.drawee.controller.AbstractDraweeControllerBuilder.CacheLevel.DISK_CACHE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$drawee$controller$AbstractDraweeControllerBuilder$CacheLevel[com.facebook.drawee.controller.AbstractDraweeControllerBuilder.CacheLevel.BITMAP_MEMORY_CACHE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public static com.facebook.imagepipeline.request.ImageRequest.RequestLevel convertCacheLevelToRequestLevel(com.facebook.drawee.controller.AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        int i = com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder.AnonymousClass1.$SwitchMap$com$facebook$drawee$controller$AbstractDraweeControllerBuilder$CacheLevel[cacheLevel.ordinal()];
        if (i == 1) {
            return com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH;
        }
        if (i == 2) {
            return com.facebook.imagepipeline.request.ImageRequest.RequestLevel.DISK_CACHE;
        }
        if (i == 3) {
            return com.facebook.imagepipeline.request.ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE;
        }
        throw new java.lang.RuntimeException("Cache level" + cacheLevel + "is not supported. ");
    }
}
