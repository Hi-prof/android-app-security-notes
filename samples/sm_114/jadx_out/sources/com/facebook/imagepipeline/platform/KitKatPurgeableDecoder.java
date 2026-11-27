package com.facebook.imagepipeline.platform;

/* JADX INFO: loaded from: classes.dex */
public class KitKatPurgeableDecoder extends com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder {
    private final com.facebook.imagepipeline.memory.FlexByteArrayPool mFlexByteArrayPool;

    public KitKatPurgeableDecoder(com.facebook.imagepipeline.memory.FlexByteArrayPool flexByteArrayPool) {
        this.mFlexByteArrayPool = flexByteArrayPool;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    protected android.graphics.Bitmap decodeByteArrayAsPurgeable(com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReference, android.graphics.BitmapFactory.Options options) {
        com.facebook.common.memory.PooledByteBuffer pooledByteBuffer = closeableReference.get();
        int size = pooledByteBuffer.size();
        com.facebook.common.references.CloseableReference<byte[]> closeableReference2 = this.mFlexByteArrayPool.get(size);
        try {
            byte[] bArr = closeableReference2.get();
            pooledByteBuffer.read(0, bArr, 0, size);
            return (android.graphics.Bitmap) com.facebook.common.internal.Preconditions.checkNotNull(android.graphics.BitmapFactory.decodeByteArray(bArr, 0, size, options), "BitmapFactory returned null");
        } finally {
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReference2);
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    protected android.graphics.Bitmap decodeJPEGByteArrayAsPurgeable(com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReference, int i, android.graphics.BitmapFactory.Options options) {
        byte[] bArr = endsWithEOI(closeableReference, i) ? null : EOI;
        com.facebook.common.memory.PooledByteBuffer pooledByteBuffer = closeableReference.get();
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i <= pooledByteBuffer.size()));
        int i2 = i + 2;
        com.facebook.common.references.CloseableReference<byte[]> closeableReference2 = this.mFlexByteArrayPool.get(i2);
        try {
            byte[] bArr2 = closeableReference2.get();
            pooledByteBuffer.read(0, bArr2, 0, i);
            if (bArr != null) {
                putEOI(bArr2, i);
                i = i2;
            }
            return (android.graphics.Bitmap) com.facebook.common.internal.Preconditions.checkNotNull(android.graphics.BitmapFactory.decodeByteArray(bArr2, 0, i, options), "BitmapFactory returned null");
        } finally {
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReference2);
        }
    }

    private static void putEOI(byte[] bArr, int i) {
        bArr[i] = -1;
        bArr[i + 1] = -39;
    }
}
