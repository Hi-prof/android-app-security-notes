package io.dcloud.feature.weex.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class GlideImageAdapter {
    public static void setImage(final java.lang.String str, final android.widget.ImageView imageView, com.taobao.weex.dom.WXImageQuality wXImageQuality, final com.taobao.weex.common.WXImageStrategy wXImageStrategy) {
        java.lang.Runnable runnable = new java.lang.Runnable() { // from class: io.dcloud.feature.weex.adapter.GlideImageAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                android.widget.ImageView imageView2 = imageView;
                if (imageView2 == null || imageView2.getLayoutParams() == null) {
                    return;
                }
                if (android.text.TextUtils.isEmpty(str)) {
                    imageView.setImageBitmap(null);
                    return;
                }
                java.lang.String str2 = str;
                if (str2.startsWith("//")) {
                    str2 = "http:" + str;
                }
                if (imageView.getLayoutParams().width <= 0) {
                    return;
                }
                com.bumptech.glide.request.RequestOptions requestOptions = new com.bumptech.glide.request.RequestOptions();
                android.util.DisplayMetrics displayMetrics = imageView.getResources().getDisplayMetrics();
                requestOptions.override(displayMetrics.widthPixels, displayMetrics.heightPixels);
                android.content.Context context = imageView.getContext();
                if (str2.contains(".gif")) {
                    com.bumptech.glide.Glide.with(context).asGif().load(str2).apply((com.bumptech.glide.request.BaseRequestOptions<?>) requestOptions).listener(new com.bumptech.glide.request.RequestListener<com.bumptech.glide.load.resource.gif.GifDrawable>() { // from class: io.dcloud.feature.weex.adapter.GlideImageAdapter.1.1
                        @Override // com.bumptech.glide.request.RequestListener
                        public boolean onLoadFailed(com.bumptech.glide.load.engine.GlideException glideException, java.lang.Object obj, com.bumptech.glide.request.target.Target<com.bumptech.glide.load.resource.gif.GifDrawable> target, boolean z) {
                            java.util.HashMap map = new java.util.HashMap();
                            map.put("errorMessage", glideException.getMessage());
                            io.dcloud.feature.weex.adapter.GlideImageAdapter.onImageFinish(wXImageStrategy, str, imageView, false, map);
                            return false;
                        }

                        @Override // com.bumptech.glide.request.RequestListener
                        public boolean onResourceReady(com.bumptech.glide.load.resource.gif.GifDrawable gifDrawable, java.lang.Object obj, com.bumptech.glide.request.target.Target<com.bumptech.glide.load.resource.gif.GifDrawable> target, com.bumptech.glide.load.DataSource dataSource, boolean z) {
                            java.util.HashMap map = new java.util.HashMap();
                            map.put("width", java.lang.Integer.valueOf(gifDrawable.getIntrinsicWidth()));
                            map.put("height", java.lang.Integer.valueOf(gifDrawable.getIntrinsicHeight()));
                            io.dcloud.feature.weex.adapter.GlideImageAdapter.onImageFinish(wXImageStrategy, str, imageView, true, map);
                            return false;
                        }
                    }).into(imageView);
                } else {
                    com.bumptech.glide.Glide.with(context).load(str2).apply((com.bumptech.glide.request.BaseRequestOptions<?>) requestOptions).listener(new com.bumptech.glide.request.RequestListener<android.graphics.drawable.Drawable>() { // from class: io.dcloud.feature.weex.adapter.GlideImageAdapter.1.2
                        @Override // com.bumptech.glide.request.RequestListener
                        public boolean onLoadFailed(com.bumptech.glide.load.engine.GlideException glideException, java.lang.Object obj, com.bumptech.glide.request.target.Target<android.graphics.drawable.Drawable> target, boolean z) {
                            java.util.HashMap map = new java.util.HashMap();
                            map.put("errorMessage", glideException.getMessage());
                            io.dcloud.feature.weex.adapter.GlideImageAdapter.onImageFinish(wXImageStrategy, str, imageView, false, map);
                            return false;
                        }

                        @Override // com.bumptech.glide.request.RequestListener
                        public boolean onResourceReady(android.graphics.drawable.Drawable drawable, java.lang.Object obj, com.bumptech.glide.request.target.Target<android.graphics.drawable.Drawable> target, com.bumptech.glide.load.DataSource dataSource, boolean z) {
                            java.util.HashMap map = new java.util.HashMap();
                            map.put("width", java.lang.Integer.valueOf(drawable.getIntrinsicWidth()));
                            map.put("height", java.lang.Integer.valueOf(drawable.getIntrinsicHeight()));
                            io.dcloud.feature.weex.adapter.GlideImageAdapter.onImageFinish(wXImageStrategy, str, imageView, true, map);
                            return false;
                        }
                    }).into(imageView);
                }
            }
        };
        if (java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            com.taobao.weex.WXSDKManager.getInstance().postOnUiThread(runnable, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onImageFinish(com.taobao.weex.common.WXImageStrategy wXImageStrategy, java.lang.String str, android.widget.ImageView imageView, boolean z, java.util.Map map) {
        if (wXImageStrategy == null || wXImageStrategy.getImageListener() == null) {
            return;
        }
        wXImageStrategy.getImageListener().onImageFinish(str, imageView, z, map);
    }
}
