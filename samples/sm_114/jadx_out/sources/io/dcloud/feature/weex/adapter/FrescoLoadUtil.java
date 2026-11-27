package io.dcloud.feature.weex.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class FrescoLoadUtil implements io.dcloud.feature.uniapp.adapter.UniImageLoadAdapter {
    private static io.dcloud.feature.weex.adapter.FrescoLoadUtil inst;
    android.os.Handler mHandler = new android.os.Handler(android.os.Looper.getMainLooper());

    public static io.dcloud.feature.uniapp.adapter.UniImageLoadAdapter getInstance() {
        if (inst == null) {
            inst = new io.dcloud.feature.weex.adapter.FrescoLoadUtil();
        }
        return inst;
    }

    @Override // io.dcloud.feature.uniapp.adapter.UniImageLoadAdapter
    public final void loadImageBitmap(android.content.Context context, java.lang.String str, io.dcloud.feature.uniapp.utils.bitmap.BitmapLoadCallback<android.graphics.Bitmap> bitmapLoadCallback) {
        loadImageBitmap(context, str, 0, 0, bitmapLoadCallback);
    }

    @Override // io.dcloud.feature.uniapp.adapter.UniImageLoadAdapter
    public final void loadImageBitmap(android.content.Context context, java.lang.String str, int i, int i2, io.dcloud.feature.uniapp.utils.bitmap.BitmapLoadCallback<android.graphics.Bitmap> bitmapLoadCallback) {
        java.lang.String str2;
        io.dcloud.feature.uniapp.utils.bitmap.BitmapLoadCallback<android.graphics.Bitmap> bitmapLoadCallback2;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("//")) {
            str2 = "http:" + str;
        } else {
            str2 = str;
        }
        try {
            bitmapLoadCallback2 = bitmapLoadCallback;
            try {
                fetch(context, android.net.Uri.parse(str2), i, i2, bitmapLoadCallback2);
            } catch (java.lang.Exception e) {
                e = e;
                java.lang.Exception exc = e;
                exc.printStackTrace();
                bitmapLoadCallback2.onFailure(str, exc);
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            bitmapLoadCallback2 = bitmapLoadCallback;
        }
    }

    private void fetch(final android.content.Context context, final android.net.Uri uri, final int i, final int i2, final io.dcloud.feature.uniapp.utils.bitmap.BitmapLoadCallback<android.graphics.Bitmap> bitmapLoadCallback) {
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.adapter.FrescoLoadUtil.1
            @Override // java.lang.Runnable
            public void run() {
                com.facebook.imagepipeline.request.ImageRequestBuilder progressiveRenderingEnabled = com.facebook.imagepipeline.request.ImageRequestBuilder.newBuilderWithSource(uri).setProgressiveRenderingEnabled(false);
                progressiveRenderingEnabled.setPostprocessor(new com.facebook.imagepipeline.request.Postprocessor() { // from class: io.dcloud.feature.weex.adapter.FrescoLoadUtil.1.1
                    @Override // com.facebook.imagepipeline.request.Postprocessor
                    public java.lang.String getName() {
                        return null;
                    }

                    @Override // com.facebook.imagepipeline.request.Postprocessor
                    public com.facebook.cache.common.CacheKey getPostprocessorCacheKey() {
                        return null;
                    }

                    @Override // com.facebook.imagepipeline.request.Postprocessor
                    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> process(android.graphics.Bitmap bitmap, com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory) {
                        if (i2 > 0 && i2 > 0) {
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            android.graphics.Matrix matrix = new android.graphics.Matrix();
                            matrix.postScale(i / width, i2 / height);
                            return platformBitmapFactory.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                        }
                        return platformBitmapFactory.createBitmap(bitmap);
                    }
                });
                com.facebook.drawee.backends.pipeline.Fresco.getImagePipeline().fetchDecodedImage(progressiveRenderingEnabled.build(), context).subscribe(new com.facebook.datasource.BaseDataSubscriber<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>() { // from class: io.dcloud.feature.weex.adapter.FrescoLoadUtil.1.2
                    @Override // com.facebook.datasource.BaseDataSubscriber
                    protected void onNewResultImpl(com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> dataSource) {
                        com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> result;
                        if (dataSource.isFinished() && (result = dataSource.getResult()) != null) {
                            try {
                                android.graphics.Bitmap underlyingBitmap = result.get() instanceof com.facebook.imagepipeline.image.CloseableBitmap ? ((com.facebook.imagepipeline.image.CloseableBitmap) result.get()).getUnderlyingBitmap() : null;
                                if (underlyingBitmap != null && !underlyingBitmap.isRecycled()) {
                                    java.lang.ref.SoftReference softReference = new java.lang.ref.SoftReference(android.graphics.Bitmap.createBitmap(underlyingBitmap));
                                    if (bitmapLoadCallback != null) {
                                        bitmapLoadCallback.onSuccess(uri.toString(), (android.graphics.Bitmap) softReference.get());
                                    }
                                }
                            } finally {
                                result.close();
                                dataSource.close();
                            }
                        }
                    }

                    @Override // com.facebook.datasource.BaseDataSubscriber
                    protected void onFailureImpl(com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> dataSource) {
                        if (bitmapLoadCallback != null) {
                            bitmapLoadCallback.onSuccess(uri.toString(), null);
                        }
                    }
                }, com.facebook.common.executors.UiThreadImmediateExecutorService.getInstance());
            }
        }, true);
    }
}
