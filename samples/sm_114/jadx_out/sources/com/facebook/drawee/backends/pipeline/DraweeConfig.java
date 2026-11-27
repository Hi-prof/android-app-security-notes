package com.facebook.drawee.backends.pipeline;

/* JADX INFO: loaded from: classes.dex */
public class DraweeConfig {

    @javax.annotation.Nullable
    private final com.facebook.common.internal.ImmutableList<com.facebook.imagepipeline.drawable.DrawableFactory> mCustomDrawableFactories;
    private final com.facebook.common.internal.Supplier<java.lang.Boolean> mDebugOverlayEnabledSupplier;

    @javax.annotation.Nullable
    private final com.facebook.fresco.ui.common.ImagePerfDataListener mImagePerfDataListener;

    @javax.annotation.Nullable
    private final com.facebook.drawee.backends.pipeline.PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    private DraweeConfig(com.facebook.drawee.backends.pipeline.DraweeConfig.Builder builder) {
        com.facebook.common.internal.Supplier<java.lang.Boolean> supplierOf;
        this.mCustomDrawableFactories = builder.mCustomDrawableFactories != null ? com.facebook.common.internal.ImmutableList.copyOf(builder.mCustomDrawableFactories) : null;
        if (builder.mDebugOverlayEnabledSupplier != null) {
            supplierOf = builder.mDebugOverlayEnabledSupplier;
        } else {
            supplierOf = com.facebook.common.internal.Suppliers.of(false);
        }
        this.mDebugOverlayEnabledSupplier = supplierOf;
        this.mPipelineDraweeControllerFactory = builder.mPipelineDraweeControllerFactory;
        this.mImagePerfDataListener = builder.mImagePerfDataListener;
    }

    @javax.annotation.Nullable
    public com.facebook.common.internal.ImmutableList<com.facebook.imagepipeline.drawable.DrawableFactory> getCustomDrawableFactories() {
        return this.mCustomDrawableFactories;
    }

    @javax.annotation.Nullable
    public com.facebook.drawee.backends.pipeline.PipelineDraweeControllerFactory getPipelineDraweeControllerFactory() {
        return this.mPipelineDraweeControllerFactory;
    }

    @javax.annotation.Nullable
    public com.facebook.fresco.ui.common.ImagePerfDataListener getImagePerfDataListener() {
        return this.mImagePerfDataListener;
    }

    public static com.facebook.drawee.backends.pipeline.DraweeConfig.Builder newBuilder() {
        return new com.facebook.drawee.backends.pipeline.DraweeConfig.Builder();
    }

    public com.facebook.common.internal.Supplier<java.lang.Boolean> getDebugOverlayEnabledSupplier() {
        return this.mDebugOverlayEnabledSupplier;
    }

    public static final class Builder {

        @javax.annotation.Nullable
        private java.util.List<com.facebook.imagepipeline.drawable.DrawableFactory> mCustomDrawableFactories;

        @javax.annotation.Nullable
        private com.facebook.common.internal.Supplier<java.lang.Boolean> mDebugOverlayEnabledSupplier;

        @javax.annotation.Nullable
        private com.facebook.fresco.ui.common.ImagePerfDataListener mImagePerfDataListener;

        @javax.annotation.Nullable
        private com.facebook.drawee.backends.pipeline.PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

        public com.facebook.drawee.backends.pipeline.DraweeConfig.Builder addCustomDrawableFactory(com.facebook.imagepipeline.drawable.DrawableFactory drawableFactory) {
            if (this.mCustomDrawableFactories == null) {
                this.mCustomDrawableFactories = new java.util.ArrayList();
            }
            this.mCustomDrawableFactories.add(drawableFactory);
            return this;
        }

        public com.facebook.drawee.backends.pipeline.DraweeConfig.Builder setDrawDebugOverlay(boolean z) {
            return setDebugOverlayEnabledSupplier(com.facebook.common.internal.Suppliers.of(java.lang.Boolean.valueOf(z)));
        }

        public com.facebook.drawee.backends.pipeline.DraweeConfig.Builder setDebugOverlayEnabledSupplier(com.facebook.common.internal.Supplier<java.lang.Boolean> supplier) {
            com.facebook.common.internal.Preconditions.checkNotNull(supplier);
            this.mDebugOverlayEnabledSupplier = supplier;
            return this;
        }

        public com.facebook.drawee.backends.pipeline.DraweeConfig.Builder setPipelineDraweeControllerFactory(com.facebook.drawee.backends.pipeline.PipelineDraweeControllerFactory pipelineDraweeControllerFactory) {
            this.mPipelineDraweeControllerFactory = pipelineDraweeControllerFactory;
            return this;
        }

        public com.facebook.drawee.backends.pipeline.DraweeConfig.Builder setImagePerfDataListener(@javax.annotation.Nullable com.facebook.fresco.ui.common.ImagePerfDataListener imagePerfDataListener) {
            this.mImagePerfDataListener = imagePerfDataListener;
            return this;
        }

        public com.facebook.drawee.backends.pipeline.DraweeConfig build() {
            return new com.facebook.drawee.backends.pipeline.DraweeConfig(this);
        }
    }
}
