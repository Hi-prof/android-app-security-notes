package com.facebook.drawee.backends.pipeline;

/* JADX INFO: loaded from: classes.dex */
public class PipelineDraweeControllerBuilderSupplier implements com.facebook.common.internal.Supplier<com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder> {
    private final java.util.Set<com.facebook.drawee.controller.ControllerListener> mBoundControllerListeners;
    private final java.util.Set<com.facebook.fresco.ui.common.ControllerListener2> mBoundControllerListeners2;
    private final android.content.Context mContext;

    @javax.annotation.Nullable
    private final com.facebook.fresco.ui.common.ImagePerfDataListener mDefaultImagePerfDataListener;
    private final com.facebook.imagepipeline.core.ImagePipeline mImagePipeline;
    private final com.facebook.drawee.backends.pipeline.PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    public PipelineDraweeControllerBuilderSupplier(android.content.Context context) {
        this(context, null);
    }

    public PipelineDraweeControllerBuilderSupplier(android.content.Context context, @javax.annotation.Nullable com.facebook.drawee.backends.pipeline.DraweeConfig draweeConfig) {
        this(context, com.facebook.imagepipeline.core.ImagePipelineFactory.getInstance(), draweeConfig);
    }

    public PipelineDraweeControllerBuilderSupplier(android.content.Context context, com.facebook.imagepipeline.core.ImagePipelineFactory imagePipelineFactory, @javax.annotation.Nullable com.facebook.drawee.backends.pipeline.DraweeConfig draweeConfig) {
        this(context, imagePipelineFactory, null, null, draweeConfig);
    }

    public PipelineDraweeControllerBuilderSupplier(android.content.Context context, com.facebook.imagepipeline.core.ImagePipelineFactory imagePipelineFactory, java.util.Set<com.facebook.drawee.controller.ControllerListener> set, java.util.Set<com.facebook.fresco.ui.common.ControllerListener2> set2, @javax.annotation.Nullable com.facebook.drawee.backends.pipeline.DraweeConfig draweeConfig) {
        this.mContext = context;
        com.facebook.imagepipeline.core.ImagePipeline imagePipeline = imagePipelineFactory.getImagePipeline();
        this.mImagePipeline = imagePipeline;
        if (draweeConfig != null && draweeConfig.getPipelineDraweeControllerFactory() != null) {
            this.mPipelineDraweeControllerFactory = draweeConfig.getPipelineDraweeControllerFactory();
        } else {
            this.mPipelineDraweeControllerFactory = new com.facebook.drawee.backends.pipeline.PipelineDraweeControllerFactory();
        }
        this.mPipelineDraweeControllerFactory.init(context.getResources(), com.facebook.drawee.components.DeferredReleaser.getInstance(), imagePipelineFactory.getAnimatedDrawableFactory(context), com.facebook.common.executors.UiThreadImmediateExecutorService.getInstance(), imagePipeline.getBitmapMemoryCache(), draweeConfig != null ? draweeConfig.getCustomDrawableFactories() : null, draweeConfig != null ? draweeConfig.getDebugOverlayEnabledSupplier() : null);
        this.mBoundControllerListeners = set;
        this.mBoundControllerListeners2 = set2;
        this.mDefaultImagePerfDataListener = draweeConfig != null ? draweeConfig.getImagePerfDataListener() : null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.internal.Supplier
    public com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder get() {
        return new com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder(this.mContext, this.mPipelineDraweeControllerFactory, this.mImagePipeline, this.mBoundControllerListeners, this.mBoundControllerListeners2).setPerfDataListener(this.mDefaultImagePerfDataListener);
    }
}
