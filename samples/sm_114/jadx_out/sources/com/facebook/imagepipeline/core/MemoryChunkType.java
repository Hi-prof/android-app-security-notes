package com.facebook.imagepipeline.core;

/* JADX INFO: loaded from: classes.dex */
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
public @interface MemoryChunkType {
    public static final int ASHMEM_MEMORY = 2;
    public static final int BUFFER_MEMORY = 1;
    public static final int NATIVE_MEMORY = 0;
}
