package com.facebook.imagepipeline.nativecode;

/* JADX INFO: loaded from: classes.dex */
public class ImagePipelineNativeLoader {
    public static final java.util.List<java.lang.String> DEPENDENCIES = java.util.Collections.unmodifiableList(new java.util.ArrayList());
    public static final java.lang.String DSO_NAME = "imagepipeline";

    public static void load() {
        com.facebook.soloader.nativeloader.NativeLoader.loadLibrary(DSO_NAME);
    }
}
