package com.bumptech.glide.load.resource.drawable;

/* JADX INFO: loaded from: classes.dex */
public final class AnimatedImageDecoder {
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool;
    private final java.util.List<com.bumptech.glide.load.ImageHeaderParser> imageHeaderParsers;

    public static com.bumptech.glide.load.ResourceDecoder<java.io.InputStream, android.graphics.drawable.Drawable> streamDecoder(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        return new com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder.StreamAnimatedImageDecoder(new com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder(list, arrayPool));
    }

    public static com.bumptech.glide.load.ResourceDecoder<java.nio.ByteBuffer, android.graphics.drawable.Drawable> byteBufferDecoder(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        return new com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder.ByteBufferAnimatedImageDecoder(new com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder(list, arrayPool));
    }

    private AnimatedImageDecoder(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        this.imageHeaderParsers = list;
        this.arrayPool = arrayPool;
    }

    boolean handles(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        return isHandled(com.bumptech.glide.load.ImageHeaderParserUtils.getType(this.imageHeaderParsers, byteBuffer));
    }

    boolean handles(java.io.InputStream inputStream) throws java.io.IOException {
        return isHandled(com.bumptech.glide.load.ImageHeaderParserUtils.getType(this.imageHeaderParsers, inputStream, this.arrayPool));
    }

    private boolean isHandled(com.bumptech.glide.load.ImageHeaderParser.ImageType imageType) {
        if (imageType != com.bumptech.glide.load.ImageHeaderParser.ImageType.ANIMATED_WEBP) {
            return android.os.Build.VERSION.SDK_INT >= 31 && imageType == com.bumptech.glide.load.ImageHeaderParser.ImageType.ANIMATED_AVIF;
        }
        return true;
    }

    com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> decode(android.graphics.ImageDecoder.Source source, int i, int i2, com.bumptech.glide.load.Options options) throws java.io.IOException {
        android.graphics.drawable.Drawable drawableDecodeDrawable = android.graphics.ImageDecoder.decodeDrawable(source, new com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener(i, i2, options));
        if (!dc.squareup.okio.Okio$$ExternalSyntheticApiModelOutline0.m$2(drawableDecodeDrawable)) {
            throw new java.io.IOException("Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
        }
        return new com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder.AnimatedImageDrawableResource(dc.squareup.okio.Okio$$ExternalSyntheticApiModelOutline0.m408m((java.lang.Object) drawableDecodeDrawable));
    }

    private static final class AnimatedImageDrawableResource implements com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> {
        private static final int ESTIMATED_NUMBER_OF_FRAMES = 2;
        private final android.graphics.drawable.AnimatedImageDrawable imageDrawable;

        AnimatedImageDrawableResource(android.graphics.drawable.AnimatedImageDrawable animatedImageDrawable) {
            this.imageDrawable = animatedImageDrawable;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public java.lang.Class<android.graphics.drawable.Drawable> getResourceClass() {
            return android.graphics.drawable.Drawable.class;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public android.graphics.drawable.Drawable get() {
            return this.imageDrawable;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public int getSize() {
            return this.imageDrawable.getIntrinsicWidth() * this.imageDrawable.getIntrinsicHeight() * com.bumptech.glide.util.Util.getBytesPerPixel(android.graphics.Bitmap.Config.ARGB_8888) * 2;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public void recycle() {
            this.imageDrawable.stop();
            this.imageDrawable.clearAnimationCallbacks();
        }
    }

    private static final class StreamAnimatedImageDecoder implements com.bumptech.glide.load.ResourceDecoder<java.io.InputStream, android.graphics.drawable.Drawable> {
        private final com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder delegate;

        StreamAnimatedImageDecoder(com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder animatedImageDecoder) {
            this.delegate = animatedImageDecoder;
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        public boolean handles(java.io.InputStream inputStream, com.bumptech.glide.load.Options options) throws java.io.IOException {
            return this.delegate.handles(inputStream);
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        public com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> decode(java.io.InputStream inputStream, int i, int i2, com.bumptech.glide.load.Options options) throws java.io.IOException {
            return this.delegate.decode(android.graphics.ImageDecoder.createSource(com.bumptech.glide.util.ByteBufferUtil.fromStream(inputStream)), i, i2, options);
        }
    }

    private static final class ByteBufferAnimatedImageDecoder implements com.bumptech.glide.load.ResourceDecoder<java.nio.ByteBuffer, android.graphics.drawable.Drawable> {
        private final com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder delegate;

        ByteBufferAnimatedImageDecoder(com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder animatedImageDecoder) {
            this.delegate = animatedImageDecoder;
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        public boolean handles(java.nio.ByteBuffer byteBuffer, com.bumptech.glide.load.Options options) throws java.io.IOException {
            return this.delegate.handles(byteBuffer);
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        public com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> decode(java.nio.ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.load.Options options) throws java.io.IOException {
            return this.delegate.decode(android.graphics.ImageDecoder.createSource(byteBuffer), i, i2, options);
        }
    }
}
