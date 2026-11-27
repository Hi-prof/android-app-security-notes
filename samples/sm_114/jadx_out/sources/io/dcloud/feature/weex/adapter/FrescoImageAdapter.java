package io.dcloud.feature.weex.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class FrescoImageAdapter implements com.taobao.weex.adapter.IWXImgLoaderAdapter {
    @Override // com.taobao.weex.adapter.IWXImgLoaderAdapter
    public void setImage(final java.lang.String str, final android.widget.ImageView imageView, final com.taobao.weex.dom.WXImageQuality wXImageQuality, final com.taobao.weex.common.WXImageStrategy wXImageStrategy) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            if (imageView != null) {
                imageView.setImageBitmap(null);
            }
        } else if (wXImageStrategy != null && wXImageStrategy.placeHolder != null) {
            io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.adapter.FrescoImageAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    android.graphics.Bitmap bitmapDecodeStream;
                    io.dcloud.common.adapter.util.Logger.d("FrescoImage", "Thread_setImage--" + str);
                    try {
                        if (wXImageStrategy.placeHolder.startsWith("file")) {
                            bitmapDecodeStream = android.graphics.BitmapFactory.decodeFile(wXImageStrategy.placeHolder.replaceFirst(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, ""));
                        } else {
                            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(wXImageStrategy.placeHolder).openConnection();
                            httpURLConnection.connect();
                            bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                        }
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                        bitmapDecodeStream = null;
                    }
                    final android.graphics.drawable.BitmapDrawable bitmapDrawable = new android.graphics.drawable.BitmapDrawable(bitmapDecodeStream);
                    com.taobao.weex.WXSDKManager.getInstance().postOnUiThread(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.adapter.FrescoImageAdapter.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            io.dcloud.feature.weex.adapter.FrescoImageAdapter.setImage(str, imageView, wXImageQuality, wXImageStrategy, bitmapDrawable);
                        }
                    }, 0L);
                }
            }, true);
        } else {
            com.taobao.weex.WXSDKManager.getInstance().postOnUiThread(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.adapter.FrescoImageAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    io.dcloud.feature.weex.adapter.FrescoImageAdapter.setImage(str, imageView, wXImageQuality, wXImageStrategy, null);
                }
            }, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setImage(final java.lang.String str, final android.widget.ImageView imageView, com.taobao.weex.dom.WXImageQuality wXImageQuality, final com.taobao.weex.common.WXImageStrategy wXImageStrategy, android.graphics.drawable.Drawable drawable) {
        java.lang.String str2;
        if (imageView == null || imageView.getLayoutParams() == null) {
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            imageView.setImageBitmap(null);
            return;
        }
        if (str.startsWith("//")) {
            str2 = "http:" + str;
        } else {
            str2 = str;
        }
        com.facebook.imagepipeline.request.ImageRequestBuilder progressiveRenderingEnabled = com.facebook.imagepipeline.request.ImageRequestBuilder.newBuilderWithSource(android.net.Uri.parse(str2)).setImageDecodeOptions(com.facebook.imagepipeline.common.ImageDecodeOptions.newBuilder().build()).setAutoRotateEnabled(true).setLocalThumbnailPreviewsEnabled(true).setLowestPermittedRequestLevel(com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH).setProgressiveRenderingEnabled(false);
        if (!wXImageStrategy.isAutoCompression()) {
            progressiveRenderingEnabled.setResizeOptions(new com.facebook.imagepipeline.common.ResizeOptions(Integer.MAX_VALUE, Integer.MAX_VALUE));
        }
        com.facebook.imagepipeline.request.ImageRequest imageRequestBuild = progressiveRenderingEnabled.build();
        if (imageView instanceof com.facebook.drawee.view.DraweeView) {
            com.facebook.drawee.controller.AbstractDraweeController abstractDraweeControllerBuild = com.facebook.drawee.backends.pipeline.Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setControllerListener(new com.facebook.drawee.controller.BaseControllerListener<com.facebook.imagepipeline.image.ImageInfo>() { // from class: io.dcloud.feature.weex.adapter.FrescoImageAdapter.3
                @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
                public void onFinalImageSet(java.lang.String str3, com.facebook.imagepipeline.image.ImageInfo imageInfo, android.graphics.drawable.Animatable animatable) {
                    com.taobao.weex.common.WXImageStrategy wXImageStrategy2;
                    if (imageInfo == null || (wXImageStrategy2 = wXImageStrategy) == null || wXImageStrategy2.getImageListener() == null) {
                        return;
                    }
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("width", java.lang.Integer.valueOf(imageInfo.getWidth()));
                    map.put("height", java.lang.Integer.valueOf(imageInfo.getHeight()));
                    if (imageInfo.getWidth() > 0) {
                        wXImageStrategy.getImageListener().onImageFinish(str, imageView, true, map);
                    } else {
                        wXImageStrategy.getImageListener().onImageFinish(str, imageView, false, map);
                    }
                }

                @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
                public void onIntermediateImageSet(java.lang.String str3, com.facebook.imagepipeline.image.ImageInfo imageInfo) {
                    com.facebook.common.logging.FLog.d("", "Intermediate image received");
                }

                @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
                public void onFailure(java.lang.String str3, java.lang.Throwable th) {
                    com.facebook.common.logging.FLog.e(getClass(), th, "Error loading %s", str3);
                    com.taobao.weex.common.WXImageStrategy wXImageStrategy2 = wXImageStrategy;
                    if (wXImageStrategy2 == null || wXImageStrategy2.getImageListener() == null) {
                        return;
                    }
                    wXImageStrategy.getImageListener().onImageFinish(str, imageView, false, null);
                }
            }).setImageRequest(imageRequestBuild).build();
            if (drawable != null) {
                ((io.dcloud.feature.weex.adapter.FrescoImageView) imageView).getHierarchy().setPlaceholderImage(drawable);
            }
            ((com.facebook.drawee.view.DraweeView) imageView).setController(abstractDraweeControllerBuild);
            return;
        }
        com.facebook.drawee.backends.pipeline.Fresco.getImagePipeline().fetchDecodedImage(imageRequestBuild, new java.lang.Object()).subscribe(new com.facebook.datasource.BaseDataSubscriber<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>() { // from class: io.dcloud.feature.weex.adapter.FrescoImageAdapter.4
            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onNewResultImpl(com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> dataSource) {
                com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> result = dataSource.getResult();
                if (result != null) {
                    try {
                        com.facebook.common.internal.Preconditions.checkState(com.facebook.common.references.CloseableReference.isValid(result));
                        com.facebook.imagepipeline.image.CloseableImage closeableImage = result.get();
                        if (closeableImage instanceof com.facebook.imagepipeline.image.CloseableStaticBitmap) {
                            imageView.setImageBitmap(((com.facebook.imagepipeline.image.CloseableStaticBitmap) closeableImage).getUnderlyingBitmap());
                        }
                        com.taobao.weex.common.WXImageStrategy wXImageStrategy2 = wXImageStrategy;
                        if (wXImageStrategy2 != null && wXImageStrategy2.getImageListener() != null) {
                            wXImageStrategy.getImageListener().onImageFinish(str, imageView, true, null);
                        }
                    } finally {
                        result.close();
                    }
                }
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onFailureImpl(com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> dataSource) {
                com.taobao.weex.common.WXImageStrategy wXImageStrategy2 = wXImageStrategy;
                if (wXImageStrategy2 == null || wXImageStrategy2.getImageListener() == null) {
                    return;
                }
                wXImageStrategy.getImageListener().onImageFinish(str, imageView, false, null);
            }
        }, com.facebook.common.executors.UiThreadImmediateExecutorService.getInstance());
    }
}
