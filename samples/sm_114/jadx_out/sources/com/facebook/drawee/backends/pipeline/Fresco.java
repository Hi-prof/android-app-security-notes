package com.facebook.drawee.backends.pipeline;

/* JADX INFO: loaded from: classes.dex */
public class Fresco {
    private static final java.lang.Class<?> TAG = com.facebook.drawee.backends.pipeline.Fresco.class;

    @javax.annotation.Nullable
    private static com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier sDraweeControllerBuilderSupplier = null;
    private static volatile boolean sIsInitialized = false;

    private Fresco() {
    }

    public static void initialize(android.content.Context context) {
        initialize(context, null, null);
    }

    public static void initialize(android.content.Context context, @javax.annotation.Nullable com.facebook.imagepipeline.core.ImagePipelineConfig imagePipelineConfig) {
        initialize(context, imagePipelineConfig, null);
    }

    public static void initialize(android.content.Context context, @javax.annotation.Nullable com.facebook.imagepipeline.core.ImagePipelineConfig imagePipelineConfig, @javax.annotation.Nullable com.facebook.drawee.backends.pipeline.DraweeConfig draweeConfig) {
        initialize(context, imagePipelineConfig, draweeConfig, true);
    }

    public static void initialize(android.content.Context context, @javax.annotation.Nullable com.facebook.imagepipeline.core.ImagePipelineConfig imagePipelineConfig, @javax.annotation.Nullable com.facebook.drawee.backends.pipeline.DraweeConfig draweeConfig, boolean z) {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("Fresco#initialize");
        }
        if (sIsInitialized) {
            com.facebook.common.logging.FLog.w(TAG, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            sIsInitialized = true;
        }
        com.facebook.imagepipeline.core.NativeCodeSetup.setUseNativeCode(z);
        if (!com.facebook.soloader.nativeloader.NativeLoader.isInitialized()) {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("Fresco.initialize->SoLoader.init");
            }
            try {
                java.lang.Class.forName("com.facebook.imagepipeline.nativecode.NativeCodeInitializer").getMethod("init", android.content.Context.class).invoke(null, context);
            } catch (java.lang.NoSuchMethodException unused) {
                com.facebook.soloader.nativeloader.NativeLoader.initIfUninitialized(new com.facebook.soloader.nativeloader.SystemDelegate());
            } catch (java.lang.reflect.InvocationTargetException unused2) {
                com.facebook.soloader.nativeloader.NativeLoader.initIfUninitialized(new com.facebook.soloader.nativeloader.SystemDelegate());
            } catch (java.lang.ClassNotFoundException unused3) {
                com.facebook.soloader.nativeloader.NativeLoader.initIfUninitialized(new com.facebook.soloader.nativeloader.SystemDelegate());
            } catch (java.lang.IllegalAccessException unused4) {
                com.facebook.soloader.nativeloader.NativeLoader.initIfUninitialized(new com.facebook.soloader.nativeloader.SystemDelegate());
            } finally {
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                }
            }
        }
        android.content.Context applicationContext = context.getApplicationContext();
        if (imagePipelineConfig == null) {
            com.facebook.imagepipeline.core.ImagePipelineFactory.initialize(applicationContext);
        } else {
            com.facebook.imagepipeline.core.ImagePipelineFactory.initialize(imagePipelineConfig);
        }
        initializeDrawee(applicationContext, draweeConfig);
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    private static void initializeDrawee(android.content.Context context, @javax.annotation.Nullable com.facebook.drawee.backends.pipeline.DraweeConfig draweeConfig) {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("Fresco.initializeDrawee");
        }
        com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier pipelineDraweeControllerBuilderSupplier = new com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier(context, draweeConfig);
        sDraweeControllerBuilderSupplier = pipelineDraweeControllerBuilderSupplier;
        com.facebook.drawee.view.SimpleDraweeView.initialize(pipelineDraweeControllerBuilderSupplier);
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    public static com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier getDraweeControllerBuilderSupplier() {
        return sDraweeControllerBuilderSupplier;
    }

    public static com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder newDraweeControllerBuilder() {
        return sDraweeControllerBuilderSupplier.get();
    }

    public static com.facebook.imagepipeline.core.ImagePipelineFactory getImagePipelineFactory() {
        return com.facebook.imagepipeline.core.ImagePipelineFactory.getInstance();
    }

    public static com.facebook.imagepipeline.core.ImagePipeline getImagePipeline() {
        return getImagePipelineFactory().getImagePipeline();
    }

    public static void shutDown() {
        sDraweeControllerBuilderSupplier = null;
        com.facebook.drawee.view.SimpleDraweeView.shutDown();
        com.facebook.imagepipeline.core.ImagePipelineFactory.shutDown();
    }

    public static boolean hasBeenInitialized() {
        return sIsInitialized;
    }
}
