package com.bumptech.glide.load.resource.gif;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferGifDecoder implements com.bumptech.glide.load.ResourceDecoder<java.nio.ByteBuffer, com.bumptech.glide.load.resource.gif.GifDrawable> {
    private static final com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifDecoderFactory GIF_DECODER_FACTORY = new com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifDecoderFactory();
    private static final com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifHeaderParserPool PARSER_POOL = new com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifHeaderParserPool();
    private static final java.lang.String TAG = "BufferGifDecoder";
    private final android.content.Context context;
    private final com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifDecoderFactory gifDecoderFactory;
    private final com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifHeaderParserPool parserPool;
    private final java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers;
    private final com.bumptech.glide.load.resource.gif.GifBitmapProvider provider;

    public ByteBufferGifDecoder(android.content.Context context) {
        this(context, com.bumptech.glide.Glide.get(context).getRegistry().getImageHeaderParsers(), com.bumptech.glide.Glide.get(context).getBitmapPool(), com.bumptech.glide.Glide.get(context).getArrayPool());
    }

    public ByteBufferGifDecoder(android.content.Context context, java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, PARSER_POOL, GIF_DECODER_FACTORY);
    }

    ByteBufferGifDecoder(android.content.Context context, java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool, com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifHeaderParserPool gifHeaderParserPool, com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifDecoderFactory gifDecoderFactory) {
        this.context = context.getApplicationContext();
        this.parsers = list;
        this.gifDecoderFactory = gifDecoderFactory;
        this.provider = new com.bumptech.glide.load.resource.gif.GifBitmapProvider(bitmapPool, arrayPool);
        this.parserPool = gifHeaderParserPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(java.nio.ByteBuffer byteBuffer, com.bumptech.glide.load.Options options) throws java.io.IOException {
        return !((java.lang.Boolean) options.get(com.bumptech.glide.load.resource.gif.GifOptions.DISABLE_ANIMATION)).booleanValue() && com.bumptech.glide.load.ImageHeaderParserUtils.getType(this.parsers, byteBuffer) == com.bumptech.glide.load.ImageHeaderParser.ImageType.GIF;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.resource.gif.GifDrawableResource decode(java.nio.ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.load.Options options) {
        com.bumptech.glide.gifdecoder.GifHeaderParser gifHeaderParserObtain = this.parserPool.obtain(byteBuffer);
        try {
            return decode(byteBuffer, i, i2, gifHeaderParserObtain, options);
        } finally {
            this.parserPool.release(gifHeaderParserObtain);
        }
    }

    private com.bumptech.glide.load.resource.gif.GifDrawableResource decode(java.nio.ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.gifdecoder.GifHeaderParser gifHeaderParser, com.bumptech.glide.load.Options options) {
        java.lang.StringBuilder sb;
        long logTime = com.bumptech.glide.util.LogTime.getLogTime();
        try {
            com.bumptech.glide.gifdecoder.GifHeader header = gifHeaderParser.parseHeader();
            if (header.getNumFrames() > 0 && header.getStatus() == 0) {
                android.graphics.Bitmap.Config config = options.get(com.bumptech.glide.load.resource.gif.GifOptions.DECODE_FORMAT) == com.bumptech.glide.load.DecodeFormat.PREFER_RGB_565 ? android.graphics.Bitmap.Config.RGB_565 : android.graphics.Bitmap.Config.ARGB_8888;
                com.bumptech.glide.gifdecoder.GifDecoder gifDecoderBuild = this.gifDecoderFactory.build(this.provider, header, byteBuffer, getSampleSize(header, i, i2));
                gifDecoderBuild.setDefaultBitmapConfig(config);
                gifDecoderBuild.advance();
                android.graphics.Bitmap nextFrame = gifDecoderBuild.getNextFrame();
                if (nextFrame == null) {
                    if (android.util.Log.isLoggable(TAG, 2)) {
                        sb = new java.lang.StringBuilder("Decoded GIF from stream in ");
                    }
                    return null;
                }
                com.bumptech.glide.load.resource.gif.GifDrawableResource gifDrawableResource = new com.bumptech.glide.load.resource.gif.GifDrawableResource(new com.bumptech.glide.load.resource.gif.GifDrawable(this.context, gifDecoderBuild, com.bumptech.glide.load.resource.UnitTransformation.get(), i, i2, nextFrame));
                if (android.util.Log.isLoggable(TAG, 2)) {
                    android.util.Log.v(TAG, "Decoded GIF from stream in " + com.bumptech.glide.util.LogTime.getElapsedMillis(logTime));
                }
                return gifDrawableResource;
            }
            if (!android.util.Log.isLoggable(TAG, 2)) {
                return null;
            }
            sb = new java.lang.StringBuilder("Decoded GIF from stream in ");
            sb.append(com.bumptech.glide.util.LogTime.getElapsedMillis(logTime));
            android.util.Log.v(TAG, sb.toString());
            return null;
        } catch (java.lang.Throwable th) {
            if (android.util.Log.isLoggable(TAG, 2)) {
                android.util.Log.v(TAG, "Decoded GIF from stream in " + com.bumptech.glide.util.LogTime.getElapsedMillis(logTime));
            }
            throw th;
        }
    }

    private static int getSampleSize(com.bumptech.glide.gifdecoder.GifHeader gifHeader, int i, int i2) {
        int iMin = java.lang.Math.min(gifHeader.getHeight() / i2, gifHeader.getWidth() / i);
        int iMax = java.lang.Math.max(1, iMin == 0 ? 0 : java.lang.Integer.highestOneBit(iMin));
        if (android.util.Log.isLoggable(TAG, 2) && iMax > 1) {
            android.util.Log.v(TAG, "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + com.taobao.weex.common.Constants.Name.X + i2 + "], actual dimens: [" + gifHeader.getWidth() + com.taobao.weex.common.Constants.Name.X + gifHeader.getHeight() + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        }
        return iMax;
    }

    static class GifDecoderFactory {
        GifDecoderFactory() {
        }

        com.bumptech.glide.gifdecoder.GifDecoder build(com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider bitmapProvider, com.bumptech.glide.gifdecoder.GifHeader gifHeader, java.nio.ByteBuffer byteBuffer, int i) {
            return new com.bumptech.glide.gifdecoder.StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i);
        }
    }

    static class GifHeaderParserPool {
        private final java.util.Queue<com.bumptech.glide.gifdecoder.GifHeaderParser> pool = com.bumptech.glide.util.Util.createQueue(0);

        GifHeaderParserPool() {
        }

        synchronized com.bumptech.glide.gifdecoder.GifHeaderParser obtain(java.nio.ByteBuffer byteBuffer) {
            com.bumptech.glide.gifdecoder.GifHeaderParser gifHeaderParserPoll;
            gifHeaderParserPoll = this.pool.poll();
            if (gifHeaderParserPoll == null) {
                gifHeaderParserPoll = new com.bumptech.glide.gifdecoder.GifHeaderParser();
            }
            return gifHeaderParserPoll.setData(byteBuffer);
        }

        synchronized void release(com.bumptech.glide.gifdecoder.GifHeaderParser gifHeaderParser) {
            gifHeaderParser.clear();
            this.pool.offer(gifHeaderParser);
        }
    }
}
