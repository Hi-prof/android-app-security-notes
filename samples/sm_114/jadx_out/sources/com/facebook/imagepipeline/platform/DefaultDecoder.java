package com.facebook.imagepipeline.platform;

/* JADX INFO: loaded from: classes.dex */
public abstract class DefaultDecoder implements com.facebook.imagepipeline.platform.PlatformDecoder {
    private boolean mAvoidPoolGet;
    private boolean mAvoidPoolRelease;
    private final com.facebook.imagepipeline.memory.BitmapPool mBitmapPool;
    final androidx.core.util.Pools.Pool<java.nio.ByteBuffer> mDecodeBuffers;

    @javax.annotation.Nullable
    private final com.facebook.imagepipeline.platform.PreverificationHelper mPreverificationHelper;
    private static final java.lang.Class<?> TAG = com.facebook.imagepipeline.platform.DefaultDecoder.class;
    private static final byte[] EOI_TAIL = {-1, -39};

    public abstract int getBitmapSize(int i, int i2, android.graphics.BitmapFactory.Options options);

    public DefaultDecoder(com.facebook.imagepipeline.memory.BitmapPool bitmapPool, androidx.core.util.Pools.Pool<java.nio.ByteBuffer> pool, com.facebook.imagepipeline.platform.PlatformDecoderOptions platformDecoderOptions) {
        this.mPreverificationHelper = android.os.Build.VERSION.SDK_INT >= 26 ? new com.facebook.imagepipeline.platform.PreverificationHelper() : null;
        this.mBitmapPool = bitmapPool;
        if (bitmapPool instanceof com.facebook.imagepipeline.memory.DummyBitmapPool) {
            this.mAvoidPoolGet = platformDecoderOptions.getAvoidPoolGet();
            this.mAvoidPoolRelease = platformDecoderOptions.getAvoidPoolRelease();
        }
        this.mDecodeBuffers = pool;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeFromEncodedImage(com.facebook.imagepipeline.image.EncodedImage encodedImage, android.graphics.Bitmap.Config config, @javax.annotation.Nullable android.graphics.Rect rect) {
        return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, null);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeJPEGFromEncodedImage(com.facebook.imagepipeline.image.EncodedImage encodedImage, android.graphics.Bitmap.Config config, @javax.annotation.Nullable android.graphics.Rect rect, int i) {
        return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i, null);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeFromEncodedImageWithColorSpace(com.facebook.imagepipeline.image.EncodedImage encodedImage, android.graphics.Bitmap.Config config, @javax.annotation.Nullable android.graphics.Rect rect, @javax.annotation.Nullable android.graphics.ColorSpace colorSpace) {
        android.graphics.BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config, this.mAvoidPoolGet);
        boolean z = decodeOptionsForStream.inPreferredConfig != android.graphics.Bitmap.Config.ARGB_8888;
        try {
            return decodeFromStream((java.io.InputStream) com.facebook.common.internal.Preconditions.checkNotNull(encodedImage.getInputStream()), decodeOptionsForStream, rect, colorSpace);
        } catch (java.lang.RuntimeException e) {
            if (z) {
                return decodeFromEncodedImageWithColorSpace(encodedImage, android.graphics.Bitmap.Config.ARGB_8888, rect, colorSpace);
            }
            throw e;
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeJPEGFromEncodedImageWithColorSpace(com.facebook.imagepipeline.image.EncodedImage encodedImage, android.graphics.Bitmap.Config config, @javax.annotation.Nullable android.graphics.Rect rect, int i, @javax.annotation.Nullable android.graphics.ColorSpace colorSpace) {
        boolean zIsCompleteAt = encodedImage.isCompleteAt(i);
        android.graphics.BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config, this.mAvoidPoolGet);
        java.io.InputStream inputStream = encodedImage.getInputStream();
        com.facebook.common.internal.Preconditions.checkNotNull(inputStream);
        if (encodedImage.getSize() > i) {
            inputStream = new com.facebook.common.streams.LimitedInputStream(inputStream, i);
        }
        if (!zIsCompleteAt) {
            inputStream = new com.facebook.common.streams.TailAppendingInputStream(inputStream, EOI_TAIL);
        }
        boolean z = decodeOptionsForStream.inPreferredConfig != android.graphics.Bitmap.Config.ARGB_8888;
        try {
            try {
                com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceDecodeFromStream = decodeFromStream(inputStream, decodeOptionsForStream, rect, colorSpace);
                try {
                    inputStream.close();
                    return closeableReferenceDecodeFromStream;
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                    return closeableReferenceDecodeFromStream;
                }
            } catch (java.lang.Throwable th) {
                try {
                    inputStream.close();
                    throw th;
                } catch (java.io.IOException e2) {
                    e2.printStackTrace();
                    throw th;
                }
            }
        } catch (java.lang.RuntimeException e3) {
            if (z) {
                com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace = decodeJPEGFromEncodedImageWithColorSpace(encodedImage, android.graphics.Bitmap.Config.ARGB_8888, rect, i, colorSpace);
                try {
                    inputStream.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
                return closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace;
            }
            throw e3;
        }
    }

    @javax.annotation.Nullable
    protected com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeStaticImageFromStream(java.io.InputStream inputStream, android.graphics.BitmapFactory.Options options, @javax.annotation.Nullable android.graphics.Rect rect) {
        return decodeFromStream(inputStream, options, rect, null);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0060 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bc A[Catch: all -> 0x00f4, RuntimeException -> 0x00f6, IllegalArgumentException -> 0x00ff, TryCatch #8 {IllegalArgumentException -> 0x00ff, RuntimeException -> 0x00f6, blocks: (B:36:0x007f, B:39:0x0089, B:47:0x00a0, B:62:0x00c3, B:54:0x00b4, B:58:0x00bc, B:59:0x00bf), top: B:98:0x007f, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c3 A[Catch: all -> 0x00f4, RuntimeException -> 0x00f6, IllegalArgumentException -> 0x00ff, TRY_LEAVE, TryCatch #8 {IllegalArgumentException -> 0x00ff, RuntimeException -> 0x00f6, blocks: (B:36:0x007f, B:39:0x0089, B:47:0x00a0, B:62:0x00c3, B:54:0x00b4, B:58:0x00bc, B:59:0x00bf), top: B:98:0x007f, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00ce A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:73:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ed  */
    @javax.annotation.Nullable
    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeFromStream(java.io.InputStream inputStream, android.graphics.BitmapFactory.Options options, @javax.annotation.Nullable android.graphics.Rect rect, @javax.annotation.Nullable android.graphics.ColorSpace colorSpace) {
        android.graphics.Bitmap bitmap;
        java.nio.ByteBuffer byteBufferAcquire;
        android.graphics.Bitmap bitmapDecodeStream;
        android.graphics.BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        com.facebook.imagepipeline.platform.PreverificationHelper preverificationHelper;
        com.facebook.common.internal.Preconditions.checkNotNull(inputStream);
        int iWidth = options.outWidth;
        int iHeight = options.outHeight;
        if (rect != null) {
            iWidth = rect.width() / options.inSampleSize;
            iHeight = rect.height() / options.inSampleSize;
        }
        boolean z = android.os.Build.VERSION.SDK_INT >= 26 && (preverificationHelper = this.mPreverificationHelper) != null && preverificationHelper.shouldUseHardwareBitmapConfig(options.inPreferredConfig);
        android.graphics.BitmapRegionDecoder bitmapRegionDecoder = null;
        try {
            try {
                if (rect == null && z) {
                    options.inMutable = false;
                } else {
                    if (rect != null && z) {
                        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
                    }
                    if (!this.mAvoidPoolGet) {
                        bitmap = this.mBitmapPool.get(getBitmapSize(iWidth, iHeight, options));
                        if (bitmap == null) {
                            throw new java.lang.NullPointerException("BitmapPool.get returned null");
                        }
                    }
                    options.inBitmap = bitmap;
                    if (android.os.Build.VERSION.SDK_INT >= 26) {
                        if (colorSpace == null) {
                            colorSpace = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.SRGB);
                        }
                        options.inPreferredColorSpace = colorSpace;
                    }
                    byteBufferAcquire = this.mDecodeBuffers.acquire();
                    if (byteBufferAcquire == null) {
                        byteBufferAcquire = java.nio.ByteBuffer.allocate(com.facebook.common.memory.DecodeBufferHelper.getRecommendedDecodeBufferSize());
                    }
                    options.inTempStorage = byteBufferAcquire.array();
                    if (rect != null || bitmap == null || options.inPreferredConfig == null) {
                        bitmapDecodeStream = null;
                    } else {
                        try {
                            bitmap.reconfigure(iWidth, iHeight, options.inPreferredConfig);
                            bitmapRegionDecoderNewInstance = android.graphics.BitmapRegionDecoder.newInstance(inputStream, true);
                            if (bitmapRegionDecoderNewInstance != null) {
                                try {
                                    try {
                                        bitmapDecodeStream = bitmapRegionDecoderNewInstance.decodeRegion(rect, options);
                                    } catch (java.io.IOException unused) {
                                        com.facebook.common.logging.FLog.e(TAG, "Could not decode region %s, decoding full bitmap instead.", rect);
                                        if (bitmapRegionDecoderNewInstance != null) {
                                            bitmapRegionDecoderNewInstance.recycle();
                                        }
                                        bitmapDecodeStream = null;
                                        if (bitmapDecodeStream == null) {
                                            bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(inputStream, null, options);
                                        }
                                        this.mDecodeBuffers.release(byteBufferAcquire);
                                        if (bitmap == null) {
                                        }
                                        if (this.mAvoidPoolRelease) {
                                            return com.facebook.common.references.CloseableReference.of(bitmapDecodeStream, com.facebook.imagepipeline.platform.DefaultDecoder.NoOpResourceReleaser.INSTANCE);
                                        }
                                        return com.facebook.common.references.CloseableReference.of(bitmapDecodeStream, this.mBitmapPool);
                                    }
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    bitmapRegionDecoder = bitmapRegionDecoderNewInstance;
                                    if (bitmapRegionDecoder != null) {
                                        bitmapRegionDecoder.recycle();
                                    }
                                    throw th;
                                }
                            } else {
                                bitmapDecodeStream = null;
                            }
                            if (bitmapRegionDecoderNewInstance != null) {
                                bitmapRegionDecoderNewInstance.recycle();
                            }
                        } catch (java.io.IOException unused2) {
                            bitmapRegionDecoderNewInstance = null;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            if (bitmapRegionDecoder != null) {
                                bitmapRegionDecoder.recycle();
                            }
                            throw th;
                        }
                    }
                    if (bitmapDecodeStream == null) {
                        bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(inputStream, null, options);
                    }
                    this.mDecodeBuffers.release(byteBufferAcquire);
                    if (bitmap == null && bitmap != bitmapDecodeStream) {
                        this.mBitmapPool.release(bitmap);
                        if (bitmapDecodeStream != null) {
                            bitmapDecodeStream.recycle();
                        }
                        throw new java.lang.IllegalStateException();
                    }
                    if (this.mAvoidPoolRelease) {
                        return com.facebook.common.references.CloseableReference.of(bitmapDecodeStream, com.facebook.imagepipeline.platform.DefaultDecoder.NoOpResourceReleaser.INSTANCE);
                    }
                    return com.facebook.common.references.CloseableReference.of(bitmapDecodeStream, this.mBitmapPool);
                }
                options.inTempStorage = byteBufferAcquire.array();
                if (rect != null) {
                    bitmapDecodeStream = null;
                } else {
                    bitmapDecodeStream = null;
                }
                if (bitmapDecodeStream == null) {
                    bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(inputStream, null, options);
                }
                this.mDecodeBuffers.release(byteBufferAcquire);
                if (bitmap == null) {
                }
                if (this.mAvoidPoolRelease) {
                    return com.facebook.common.references.CloseableReference.of(bitmapDecodeStream, com.facebook.imagepipeline.platform.DefaultDecoder.NoOpResourceReleaser.INSTANCE);
                }
                return com.facebook.common.references.CloseableReference.of(bitmapDecodeStream, this.mBitmapPool);
            } catch (java.lang.Throwable th3) {
                this.mDecodeBuffers.release(byteBufferAcquire);
                throw th3;
            }
        } catch (java.lang.IllegalArgumentException e) {
            if (bitmap != null) {
                this.mBitmapPool.release(bitmap);
            }
            try {
                inputStream.reset();
                android.graphics.Bitmap bitmapDecodeStream2 = android.graphics.BitmapFactory.decodeStream(inputStream);
                if (bitmapDecodeStream2 == null) {
                    throw e;
                }
                com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceOf = com.facebook.common.references.CloseableReference.of(bitmapDecodeStream2, com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.getInstance());
                this.mDecodeBuffers.release(byteBufferAcquire);
                return closeableReferenceOf;
            } catch (java.io.IOException unused3) {
                throw e;
            }
        } catch (java.lang.RuntimeException e2) {
            if (bitmap != null) {
                this.mBitmapPool.release(bitmap);
            }
            throw e2;
        }
        bitmap = null;
        options.inBitmap = bitmap;
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            if (colorSpace == null) {
                colorSpace = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.SRGB);
            }
            options.inPreferredColorSpace = colorSpace;
        }
        byteBufferAcquire = this.mDecodeBuffers.acquire();
        if (byteBufferAcquire == null) {
            byteBufferAcquire = java.nio.ByteBuffer.allocate(com.facebook.common.memory.DecodeBufferHelper.getRecommendedDecodeBufferSize());
        }
    }

    private static android.graphics.BitmapFactory.Options getDecodeOptionsForStream(com.facebook.imagepipeline.image.EncodedImage encodedImage, android.graphics.Bitmap.Config config, boolean z) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inSampleSize = encodedImage.getSampleSize();
        options.inJustDecodeBounds = true;
        options.inDither = true;
        boolean z2 = android.os.Build.VERSION.SDK_INT >= 26 && config == android.graphics.Bitmap.Config.HARDWARE;
        if (!z2) {
            options.inPreferredConfig = config;
        }
        options.inMutable = true;
        if (!z) {
            android.graphics.BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
            if (options.outWidth == -1 || options.outHeight == -1) {
                throw new java.lang.IllegalArgumentException();
            }
        }
        if (z2) {
            options.inPreferredConfig = config;
        }
        options.inJustDecodeBounds = false;
        return options;
    }

    private static final class NoOpResourceReleaser implements com.facebook.common.references.ResourceReleaser<android.graphics.Bitmap> {
        private static final com.facebook.imagepipeline.platform.DefaultDecoder.NoOpResourceReleaser INSTANCE = new com.facebook.imagepipeline.platform.DefaultDecoder.NoOpResourceReleaser();

        @Override // com.facebook.common.references.ResourceReleaser
        public void release(android.graphics.Bitmap bitmap) {
        }

        private NoOpResourceReleaser() {
        }
    }
}
