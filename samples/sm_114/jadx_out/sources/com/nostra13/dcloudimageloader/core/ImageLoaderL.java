package com.nostra13.dcloudimageloader.core;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ImageLoaderL extends com.nostra13.dcloudimageloader.core.ImageLoader {
    private static volatile com.nostra13.dcloudimageloader.core.ImageLoaderL instance;
    private com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration configuration;
    private final com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener emptyListener = new com.nostra13.dcloudimageloader.core.assist.SimpleImageLoadingListener();
    private com.nostra13.dcloudimageloader.core.ImageLoaderEngine engine;

    protected ImageLoaderL() {
    }

    private void checkConfiguration() {
        if (this.configuration == null) {
            throw new java.lang.IllegalStateException("ImageLoader must be init with configuration before using");
        }
    }

    public static com.nostra13.dcloudimageloader.core.ImageLoaderL getInstance() {
        if (instance == null) {
            synchronized (com.nostra13.dcloudimageloader.core.ImageLoaderL.class) {
                if (instance == null) {
                    instance = new com.nostra13.dcloudimageloader.core.ImageLoaderL();
                }
            }
        }
        return instance;
    }
}
