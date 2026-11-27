package com.nostra13.dcloudimageloader.core;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayImageOptions {
    private final boolean cacheInMemory;
    private final boolean cacheOnDisc;
    private final boolean considerExifParams;
    private final android.graphics.BitmapFactory.Options decodingOptions;
    private final int delayBeforeLoading;
    private final com.nostra13.dcloudimageloader.core.display.BitmapDisplayer displayer;
    private final java.lang.Object extraForDownloader;
    private final android.os.Handler handler;
    private final android.graphics.drawable.Drawable imageForEmptyUri;
    private final android.graphics.drawable.Drawable imageOnFail;
    private final android.graphics.drawable.Drawable imageOnLoading;
    private final int imageResForEmptyUri;
    private final int imageResOnFail;
    private final int imageResOnLoading;
    private final com.nostra13.dcloudimageloader.core.assist.ImageScaleType imageScaleType;
    private final boolean isSyncLoading;
    private final com.nostra13.dcloudimageloader.core.process.BitmapProcessor postProcessor;
    private final com.nostra13.dcloudimageloader.core.process.BitmapProcessor preProcessor;
    private final boolean resetViewBeforeLoading;

    private DisplayImageOptions(com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder builder) {
        this.imageResOnLoading = builder.imageResOnLoading;
        this.imageResForEmptyUri = builder.imageResForEmptyUri;
        this.imageResOnFail = builder.imageResOnFail;
        this.imageOnLoading = builder.imageOnLoading;
        this.imageForEmptyUri = builder.imageForEmptyUri;
        this.imageOnFail = builder.imageOnFail;
        this.resetViewBeforeLoading = builder.resetViewBeforeLoading;
        this.cacheInMemory = builder.cacheInMemory;
        this.cacheOnDisc = builder.cacheOnDisc;
        this.imageScaleType = builder.imageScaleType;
        this.decodingOptions = builder.decodingOptions;
        this.delayBeforeLoading = builder.delayBeforeLoading;
        this.considerExifParams = builder.considerExifParams;
        this.extraForDownloader = builder.extraForDownloader;
        this.preProcessor = builder.preProcessor;
        this.postProcessor = builder.postProcessor;
        this.displayer = builder.displayer;
        this.handler = builder.handler;
        this.isSyncLoading = builder.isSyncLoading;
    }

    public boolean shouldShowImageOnLoading() {
        return (this.imageOnLoading == null && this.imageResOnLoading == 0) ? false : true;
    }

    public boolean shouldShowImageForEmptyUri() {
        return (this.imageForEmptyUri == null && this.imageResForEmptyUri == 0) ? false : true;
    }

    public boolean shouldShowImageOnFail() {
        return (this.imageOnFail == null && this.imageResOnFail == 0) ? false : true;
    }

    public boolean shouldPreProcess() {
        return this.preProcessor != null;
    }

    public boolean shouldPostProcess() {
        return this.postProcessor != null;
    }

    public boolean shouldDelayBeforeLoading() {
        return this.delayBeforeLoading > 0;
    }

    public android.graphics.drawable.Drawable getImageOnLoading(android.content.res.Resources resources) {
        int i = this.imageResOnLoading;
        return i != 0 ? resources.getDrawable(i) : this.imageOnLoading;
    }

    public android.graphics.drawable.Drawable getImageForEmptyUri(android.content.res.Resources resources) {
        int i = this.imageResForEmptyUri;
        return i != 0 ? resources.getDrawable(i) : this.imageForEmptyUri;
    }

    public android.graphics.drawable.Drawable getImageOnFail(android.content.res.Resources resources) {
        int i = this.imageResOnFail;
        return i != 0 ? resources.getDrawable(i) : this.imageOnFail;
    }

    public boolean isResetViewBeforeLoading() {
        return this.resetViewBeforeLoading;
    }

    public boolean isCacheInMemory() {
        return this.cacheInMemory;
    }

    public boolean isCacheOnDisc() {
        return this.cacheOnDisc;
    }

    public com.nostra13.dcloudimageloader.core.assist.ImageScaleType getImageScaleType() {
        return this.imageScaleType;
    }

    public android.graphics.BitmapFactory.Options getDecodingOptions() {
        return this.decodingOptions;
    }

    public int getDelayBeforeLoading() {
        return this.delayBeforeLoading;
    }

    public boolean isConsiderExifParams() {
        return this.considerExifParams;
    }

    public java.lang.Object getExtraForDownloader() {
        return this.extraForDownloader;
    }

    public com.nostra13.dcloudimageloader.core.process.BitmapProcessor getPreProcessor() {
        return this.preProcessor;
    }

    public com.nostra13.dcloudimageloader.core.process.BitmapProcessor getPostProcessor() {
        return this.postProcessor;
    }

    public com.nostra13.dcloudimageloader.core.display.BitmapDisplayer getDisplayer() {
        return this.displayer;
    }

    public android.os.Handler getHandler() {
        if (this.isSyncLoading) {
            return null;
        }
        android.os.Handler handler = this.handler;
        if (handler != null) {
            return handler;
        }
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalStateException("ImageLoader.displayImage(...) must be invoked from the main thread or from Looper thread");
        }
        return new android.os.Handler();
    }

    boolean isSyncLoading() {
        return this.isSyncLoading;
    }

    public static com.nostra13.dcloudimageloader.core.DisplayImageOptions createSimple() {
        return new com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder().build();
    }

    public static class Builder {
        private int imageResOnLoading = 0;
        private int imageResForEmptyUri = 0;
        private int imageResOnFail = 0;
        private android.graphics.drawable.Drawable imageOnLoading = null;
        private android.graphics.drawable.Drawable imageForEmptyUri = null;
        private android.graphics.drawable.Drawable imageOnFail = null;
        private boolean resetViewBeforeLoading = false;
        private boolean cacheInMemory = false;
        private boolean cacheOnDisc = false;
        private com.nostra13.dcloudimageloader.core.assist.ImageScaleType imageScaleType = com.nostra13.dcloudimageloader.core.assist.ImageScaleType.IN_SAMPLE_POWER_OF_2;
        private android.graphics.BitmapFactory.Options decodingOptions = new android.graphics.BitmapFactory.Options();
        private int delayBeforeLoading = 0;
        private boolean considerExifParams = false;
        private java.lang.Object extraForDownloader = null;
        private com.nostra13.dcloudimageloader.core.process.BitmapProcessor preProcessor = null;
        private com.nostra13.dcloudimageloader.core.process.BitmapProcessor postProcessor = null;
        private com.nostra13.dcloudimageloader.core.display.BitmapDisplayer displayer = com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.createBitmapDisplayer();
        private android.os.Handler handler = null;
        private boolean isSyncLoading = false;

        public Builder() {
            this.decodingOptions.inPurgeable = true;
            this.decodingOptions.inInputShareable = true;
        }

        @java.lang.Deprecated
        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder showStubImage(int i) {
            this.imageResOnLoading = i;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder showImageOnLoading(int i) {
            this.imageResOnLoading = i;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder showImageOnLoading(android.graphics.drawable.Drawable drawable) {
            this.imageOnLoading = drawable;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder showImageForEmptyUri(int i) {
            this.imageResForEmptyUri = i;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder showImageForEmptyUri(android.graphics.drawable.Drawable drawable) {
            this.imageForEmptyUri = drawable;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder showImageOnFail(int i) {
            this.imageResOnFail = i;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder showImageOnFail(android.graphics.drawable.Drawable drawable) {
            this.imageOnFail = drawable;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder resetViewBeforeLoading() {
            this.resetViewBeforeLoading = true;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder resetViewBeforeLoading(boolean z) {
            this.resetViewBeforeLoading = z;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder cacheInMemory() {
            this.cacheInMemory = true;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder cacheInMemory(boolean z) {
            this.cacheInMemory = z;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder cacheOnDisc() {
            this.cacheOnDisc = true;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder cacheOnDisc(boolean z) {
            this.cacheOnDisc = z;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder imageScaleType(com.nostra13.dcloudimageloader.core.assist.ImageScaleType imageScaleType) {
            this.imageScaleType = imageScaleType;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder bitmapConfig(android.graphics.Bitmap.Config config) {
            if (config == null) {
                throw new java.lang.IllegalArgumentException("bitmapConfig can't be null");
            }
            this.decodingOptions.inPreferredConfig = config;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder decodingOptions(android.graphics.BitmapFactory.Options options) {
            if (options == null) {
                throw new java.lang.IllegalArgumentException("decodingOptions can't be null");
            }
            this.decodingOptions = options;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder delayBeforeLoading(int i) {
            this.delayBeforeLoading = i;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder extraForDownloader(java.lang.Object obj) {
            this.extraForDownloader = obj;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder considerExifParams(boolean z) {
            this.considerExifParams = z;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder preProcessor(com.nostra13.dcloudimageloader.core.process.BitmapProcessor bitmapProcessor) {
            this.preProcessor = bitmapProcessor;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder postProcessor(com.nostra13.dcloudimageloader.core.process.BitmapProcessor bitmapProcessor) {
            this.postProcessor = bitmapProcessor;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder displayer(com.nostra13.dcloudimageloader.core.display.BitmapDisplayer bitmapDisplayer) {
            if (bitmapDisplayer == null) {
                throw new java.lang.IllegalArgumentException("displayer can't be null");
            }
            this.displayer = bitmapDisplayer;
            return this;
        }

        com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder syncLoading(boolean z) {
            this.isSyncLoading = z;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder handler(android.os.Handler handler) {
            this.handler = handler;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder cloneFrom(com.nostra13.dcloudimageloader.core.DisplayImageOptions displayImageOptions) {
            this.imageResOnLoading = displayImageOptions.imageResOnLoading;
            this.imageResForEmptyUri = displayImageOptions.imageResForEmptyUri;
            this.imageResOnFail = displayImageOptions.imageResOnFail;
            this.imageOnLoading = displayImageOptions.imageOnLoading;
            this.imageForEmptyUri = displayImageOptions.imageForEmptyUri;
            this.imageOnFail = displayImageOptions.imageOnFail;
            this.resetViewBeforeLoading = displayImageOptions.resetViewBeforeLoading;
            this.cacheInMemory = displayImageOptions.cacheInMemory;
            this.cacheOnDisc = displayImageOptions.cacheOnDisc;
            this.imageScaleType = displayImageOptions.imageScaleType;
            this.decodingOptions = displayImageOptions.decodingOptions;
            this.delayBeforeLoading = displayImageOptions.delayBeforeLoading;
            this.considerExifParams = displayImageOptions.considerExifParams;
            this.extraForDownloader = displayImageOptions.extraForDownloader;
            this.preProcessor = displayImageOptions.preProcessor;
            this.postProcessor = displayImageOptions.postProcessor;
            this.displayer = displayImageOptions.displayer;
            this.handler = displayImageOptions.handler;
            this.isSyncLoading = displayImageOptions.isSyncLoading;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.DisplayImageOptions build() {
            return new com.nostra13.dcloudimageloader.core.DisplayImageOptions(this);
        }
    }
}
