package com.facebook.imagepipeline.bitmaps;

/* JADX INFO: compiled from: HoneycombBitmapCreator.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator;", "Lcom/facebook/common/webp/BitmapCreator;", "poolFactory", "Lcom/facebook/imagepipeline/memory/PoolFactory;", "<init>", "(Lcom/facebook/imagepipeline/memory/PoolFactory;)V", "jpegGenerator", "Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;", "flexByteArrayPool", "Lcom/facebook/imagepipeline/memory/FlexByteArrayPool;", "createNakedBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HoneycombBitmapCreator implements com.facebook.common.webp.BitmapCreator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.imagepipeline.bitmaps.HoneycombBitmapCreator.Companion INSTANCE = new com.facebook.imagepipeline.bitmaps.HoneycombBitmapCreator.Companion(null);
    private final com.facebook.imagepipeline.memory.FlexByteArrayPool flexByteArrayPool;
    private final com.facebook.imagepipeline.bitmaps.EmptyJpegGenerator jpegGenerator;

    public HoneycombBitmapCreator(com.facebook.imagepipeline.memory.PoolFactory poolFactory) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        this.jpegGenerator = new com.facebook.imagepipeline.bitmaps.EmptyJpegGenerator(poolFactory.getPooledByteBufferFactory());
        com.facebook.imagepipeline.memory.FlexByteArrayPool flexByteArrayPool = poolFactory.getFlexByteArrayPool();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(flexByteArrayPool, "getFlexByteArrayPool(...)");
        this.flexByteArrayPool = flexByteArrayPool;
    }

    @Override // com.facebook.common.webp.BitmapCreator
    public android.graphics.Bitmap createNakedBitmap(int width, int height, android.graphics.Bitmap.Config bitmapConfig) throws java.lang.Throwable {
        com.facebook.imagepipeline.image.EncodedImage encodedImage;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReferenceGenerate = this.jpegGenerator.generate((short) width, (short) height);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(closeableReferenceGenerate, "generate(...)");
        try {
            encodedImage = new com.facebook.imagepipeline.image.EncodedImage(closeableReferenceGenerate);
            try {
                encodedImage.setImageFormat(com.facebook.imageformat.DefaultImageFormats.JPEG);
                android.graphics.BitmapFactory.Options bitmapFactoryOptions = INSTANCE.getBitmapFactoryOptions(encodedImage.getSampleSize(), bitmapConfig);
                int size = closeableReferenceGenerate.get().size();
                com.facebook.common.memory.PooledByteBuffer pooledByteBuffer = closeableReferenceGenerate.get();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(pooledByteBuffer, "get(...)");
                com.facebook.common.references.CloseableReference<byte[]> closeableReference = this.flexByteArrayPool.get(size + 2);
                byte[] bArr = closeableReference.get();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bArr, "get(...)");
                byte[] bArr2 = bArr;
                pooledByteBuffer.read(0, bArr2, 0, size);
                android.graphics.Bitmap bitmapDecodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArr2, 0, size, bitmapFactoryOptions);
                if (bitmapDecodeByteArray == null) {
                    throw new java.lang.IllegalStateException("Required value was null.".toString());
                }
                bitmapDecodeByteArray.setHasAlpha(true);
                bitmapDecodeByteArray.eraseColor(0);
                com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReference);
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceGenerate);
                return bitmapDecodeByteArray;
            } catch (java.lang.Throwable th) {
                th = th;
                com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) null);
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceGenerate);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            encodedImage = null;
        }
    }

    /* JADX INFO: compiled from: HoneycombBitmapCreator.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"Lcom/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator$Companion;", "", "<init>", "()V", "getBitmapFactoryOptions", "Landroid/graphics/BitmapFactory$Options;", "sampleSize", "", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final android.graphics.BitmapFactory.Options getBitmapFactoryOptions(int sampleSize, android.graphics.Bitmap.Config bitmapConfig) {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inDither = true;
            options.inPreferredConfig = bitmapConfig;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inSampleSize = sampleSize;
            options.inMutable = true;
            return options;
        }
    }
}
