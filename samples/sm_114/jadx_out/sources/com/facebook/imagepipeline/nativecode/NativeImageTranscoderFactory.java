package com.facebook.imagepipeline.nativecode;

/* JADX INFO: compiled from: NativeImageTranscoderFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007¨\u0006\u000b"}, d2 = {"Lcom/facebook/imagepipeline/nativecode/NativeImageTranscoderFactory;", "", "<init>", "()V", "getNativeImageTranscoderFactory", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "maxBitmapSize", "", "useDownSamplingRatio", "", "ensureTranscoderLibraryLoaded", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NativeImageTranscoderFactory {
    public static final com.facebook.imagepipeline.nativecode.NativeImageTranscoderFactory INSTANCE = new com.facebook.imagepipeline.nativecode.NativeImageTranscoderFactory();

    private NativeImageTranscoderFactory() {
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imagepipeline.transcoder.ImageTranscoderFactory getNativeImageTranscoderFactory(int maxBitmapSize, boolean useDownSamplingRatio, boolean ensureTranscoderLibraryLoaded) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.facebook.imagepipeline.nativecode.NativeJpegTranscoderFactory");
            java.lang.Class<?> cls2 = java.lang.Boolean.TYPE;
            java.lang.Object objNewInstance = cls.getConstructor(java.lang.Integer.TYPE, cls2, cls2).newInstance(java.lang.Integer.valueOf(maxBitmapSize), java.lang.Boolean.valueOf(useDownSamplingRatio), java.lang.Boolean.valueOf(ensureTranscoderLibraryLoaded));
            kotlin.jvm.internal.Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.facebook.imagepipeline.transcoder.ImageTranscoderFactory");
            return (com.facebook.imagepipeline.transcoder.ImageTranscoderFactory) objNewInstance;
        } catch (java.lang.ClassNotFoundException e) {
            throw new java.lang.RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e);
        } catch (java.lang.IllegalAccessException e2) {
            throw new java.lang.RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e2);
        } catch (java.lang.IllegalArgumentException e3) {
            throw new java.lang.RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e3);
        } catch (java.lang.InstantiationException e4) {
            throw new java.lang.RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e4);
        } catch (java.lang.NoSuchMethodException e5) {
            throw new java.lang.RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e5);
        } catch (java.lang.SecurityException e6) {
            throw new java.lang.RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e6);
        } catch (java.lang.reflect.InvocationTargetException e7) {
            throw new java.lang.RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e7);
        }
    }
}
