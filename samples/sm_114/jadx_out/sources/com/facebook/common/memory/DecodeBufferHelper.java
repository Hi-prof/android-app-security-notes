package com.facebook.common.memory;

/* JADX INFO: loaded from: classes.dex */
public class DecodeBufferHelper implements androidx.core.util.Pools.Pool<java.nio.ByteBuffer> {
    private static final int DEFAULT_DECODE_BUFFER_SIZE = 16384;
    public static final com.facebook.common.memory.DecodeBufferHelper INSTANCE = new com.facebook.common.memory.DecodeBufferHelper();
    private static int sRecommendedDecodeBufferSize = 16384;
    private static final java.lang.ThreadLocal<java.nio.ByteBuffer> sBuffer = new java.lang.ThreadLocal<java.nio.ByteBuffer>() { // from class: com.facebook.common.memory.DecodeBufferHelper.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public java.nio.ByteBuffer initialValue() {
            return java.nio.ByteBuffer.allocate(com.facebook.common.memory.DecodeBufferHelper.sRecommendedDecodeBufferSize);
        }
    };

    @Override // androidx.core.util.Pools.Pool
    public boolean release(java.nio.ByteBuffer byteBuffer) {
        return true;
    }

    public static int getRecommendedDecodeBufferSize() {
        return sRecommendedDecodeBufferSize;
    }

    public static void setRecommendedDecodeBufferSize(int i) {
        sRecommendedDecodeBufferSize = i;
    }

    @Override // androidx.core.util.Pools.Pool
    public java.nio.ByteBuffer acquire() {
        return sBuffer.get();
    }
}
