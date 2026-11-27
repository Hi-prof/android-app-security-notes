package com.bumptech.glide;

/* JADX INFO: loaded from: classes.dex */
final class RegistryFactory {
    private RegistryFactory() {
    }

    static com.bumptech.glide.util.GlideSuppliers.GlideSupplier<com.bumptech.glide.Registry> lazilyCreateAndInitializeRegistry(final com.bumptech.glide.Glide glide, final java.util.List<com.bumptech.glide.module.GlideModule> list, final com.bumptech.glide.module.AppGlideModule appGlideModule) {
        return new com.bumptech.glide.util.GlideSuppliers.GlideSupplier<com.bumptech.glide.Registry>() { // from class: com.bumptech.glide.RegistryFactory.1
            private boolean isInitializing;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
            public com.bumptech.glide.Registry get() {
                if (this.isInitializing) {
                    throw new java.lang.IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
                }
                androidx.tracing.Trace.beginSection("Glide registry");
                this.isInitializing = true;
                try {
                    return com.bumptech.glide.RegistryFactory.createAndInitRegistry(glide, list, appGlideModule);
                } finally {
                    this.isInitializing = false;
                    androidx.tracing.Trace.endSection();
                }
            }
        };
    }

    static com.bumptech.glide.Registry createAndInitRegistry(com.bumptech.glide.Glide glide, java.util.List<com.bumptech.glide.module.GlideModule> list, com.bumptech.glide.module.AppGlideModule appGlideModule) {
        com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool = glide.getBitmapPool();
        com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool = glide.getArrayPool();
        android.content.Context applicationContext = glide.getGlideContext().getApplicationContext();
        com.bumptech.glide.GlideExperiments experiments = glide.getGlideContext().getExperiments();
        com.bumptech.glide.Registry registry = new com.bumptech.glide.Registry();
        initializeDefaults(applicationContext, registry, bitmapPool, arrayPool, experiments);
        initializeModules(applicationContext, glide, registry, list, appGlideModule);
        return registry;
    }

    private static void initializeDefaults(android.content.Context context, com.bumptech.glide.Registry registry, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool, com.bumptech.glide.GlideExperiments glideExperiments) {
        com.bumptech.glide.load.ResourceDecoder byteBufferBitmapDecoder;
        com.bumptech.glide.load.ResourceDecoder streamBitmapDecoder;
        registry.register(new com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser());
        if (android.os.Build.VERSION.SDK_INT >= 27) {
            registry.register(new com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser());
        }
        android.content.res.Resources resources = context.getResources();
        java.util.List<com.bumptech.glide.load.ImageHeaderParser> imageHeaderParsers = registry.getImageHeaderParsers();
        com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder byteBufferGifDecoder = new com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder(context, imageHeaderParsers, bitmapPool, arrayPool);
        com.bumptech.glide.load.ResourceDecoder<android.os.ParcelFileDescriptor, android.graphics.Bitmap> resourceDecoderParcel = com.bumptech.glide.load.resource.bitmap.VideoDecoder.parcel(bitmapPool);
        com.bumptech.glide.load.resource.bitmap.Downsampler downsampler = new com.bumptech.glide.load.resource.bitmap.Downsampler(registry.getImageHeaderParsers(), resources.getDisplayMetrics(), bitmapPool, arrayPool);
        if (android.os.Build.VERSION.SDK_INT >= 28 && glideExperiments.isEnabled(com.bumptech.glide.GlideBuilder.EnableImageDecoderForBitmaps.class)) {
            streamBitmapDecoder = new com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder();
            byteBufferBitmapDecoder = new com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder();
        } else {
            byteBufferBitmapDecoder = new com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder(downsampler);
            streamBitmapDecoder = new com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder(downsampler, arrayPool);
        }
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            registry.append("Animation", java.io.InputStream.class, android.graphics.drawable.Drawable.class, com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder.streamDecoder(imageHeaderParsers, arrayPool));
            registry.append("Animation", java.nio.ByteBuffer.class, android.graphics.drawable.Drawable.class, com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder.byteBufferDecoder(imageHeaderParsers, arrayPool));
        }
        com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder resourceDrawableDecoder = new com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder(context);
        com.bumptech.glide.load.resource.bitmap.BitmapEncoder bitmapEncoder = new com.bumptech.glide.load.resource.bitmap.BitmapEncoder(arrayPool);
        com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder bitmapBytesTranscoder = new com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder();
        com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder();
        android.content.ContentResolver contentResolver = context.getContentResolver();
        registry.append(java.nio.ByteBuffer.class, new com.bumptech.glide.load.model.ByteBufferEncoder()).append(java.io.InputStream.class, new com.bumptech.glide.load.model.StreamEncoder(arrayPool)).append(com.bumptech.glide.Registry.BUCKET_BITMAP, java.nio.ByteBuffer.class, android.graphics.Bitmap.class, byteBufferBitmapDecoder).append(com.bumptech.glide.Registry.BUCKET_BITMAP, java.io.InputStream.class, android.graphics.Bitmap.class, streamBitmapDecoder);
        if (com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.isSupported()) {
            registry.append(com.bumptech.glide.Registry.BUCKET_BITMAP, android.os.ParcelFileDescriptor.class, android.graphics.Bitmap.class, new com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder(downsampler));
        }
        registry.append(com.bumptech.glide.Registry.BUCKET_BITMAP, android.content.res.AssetFileDescriptor.class, android.graphics.Bitmap.class, com.bumptech.glide.load.resource.bitmap.VideoDecoder.asset(bitmapPool));
        registry.append(com.bumptech.glide.Registry.BUCKET_BITMAP, android.os.ParcelFileDescriptor.class, android.graphics.Bitmap.class, resourceDecoderParcel).append(android.graphics.Bitmap.class, android.graphics.Bitmap.class, com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()).append(com.bumptech.glide.Registry.BUCKET_BITMAP, android.graphics.Bitmap.class, android.graphics.Bitmap.class, new com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder()).append(android.graphics.Bitmap.class, (com.bumptech.glide.load.ResourceEncoder) bitmapEncoder).append(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, java.nio.ByteBuffer.class, android.graphics.drawable.BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder(resources, byteBufferBitmapDecoder)).append(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, java.io.InputStream.class, android.graphics.drawable.BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder(resources, streamBitmapDecoder)).append(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, android.os.ParcelFileDescriptor.class, android.graphics.drawable.BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder(resources, resourceDecoderParcel)).append(android.graphics.drawable.BitmapDrawable.class, (com.bumptech.glide.load.ResourceEncoder) new com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder(bitmapPool, bitmapEncoder)).append("Animation", java.io.InputStream.class, com.bumptech.glide.load.resource.gif.GifDrawable.class, new com.bumptech.glide.load.resource.gif.StreamGifDecoder(imageHeaderParsers, byteBufferGifDecoder, arrayPool)).append("Animation", java.nio.ByteBuffer.class, com.bumptech.glide.load.resource.gif.GifDrawable.class, byteBufferGifDecoder).append(com.bumptech.glide.load.resource.gif.GifDrawable.class, (com.bumptech.glide.load.ResourceEncoder) new com.bumptech.glide.load.resource.gif.GifDrawableEncoder()).append(com.bumptech.glide.gifdecoder.GifDecoder.class, com.bumptech.glide.gifdecoder.GifDecoder.class, com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()).append(com.bumptech.glide.Registry.BUCKET_BITMAP, com.bumptech.glide.gifdecoder.GifDecoder.class, android.graphics.Bitmap.class, new com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder(bitmapPool)).append(android.net.Uri.class, android.graphics.drawable.Drawable.class, resourceDrawableDecoder).append(android.net.Uri.class, android.graphics.Bitmap.class, new com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder(resourceDrawableDecoder, bitmapPool)).register(new com.bumptech.glide.load.resource.bytes.ByteBufferRewinder.Factory()).append(java.io.File.class, java.nio.ByteBuffer.class, new com.bumptech.glide.load.model.ByteBufferFileLoader.Factory()).append(java.io.File.class, java.io.InputStream.class, new com.bumptech.glide.load.model.FileLoader.StreamFactory()).append(java.io.File.class, java.io.File.class, new com.bumptech.glide.load.resource.file.FileDecoder()).append(java.io.File.class, android.os.ParcelFileDescriptor.class, new com.bumptech.glide.load.model.FileLoader.FileDescriptorFactory()).append(java.io.File.class, java.io.File.class, com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()).register(new com.bumptech.glide.load.data.InputStreamRewinder.Factory(arrayPool));
        if (com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.isSupported()) {
            registry.register(new com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.Factory());
        }
        com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.Integer, java.io.InputStream> modelLoaderFactoryInputStreamFactory = com.bumptech.glide.load.model.DirectResourceLoader.inputStreamFactory(context);
        com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.Integer, android.content.res.AssetFileDescriptor> modelLoaderFactoryAssetFileDescriptorFactory = com.bumptech.glide.load.model.DirectResourceLoader.assetFileDescriptorFactory(context);
        com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.Integer, android.graphics.drawable.Drawable> modelLoaderFactoryDrawableFactory = com.bumptech.glide.load.model.DirectResourceLoader.drawableFactory(context);
        registry.append(java.lang.Integer.TYPE, java.io.InputStream.class, modelLoaderFactoryInputStreamFactory).append(java.lang.Integer.class, java.io.InputStream.class, modelLoaderFactoryInputStreamFactory).append(java.lang.Integer.TYPE, android.content.res.AssetFileDescriptor.class, modelLoaderFactoryAssetFileDescriptorFactory).append(java.lang.Integer.class, android.content.res.AssetFileDescriptor.class, modelLoaderFactoryAssetFileDescriptorFactory).append(java.lang.Integer.TYPE, android.graphics.drawable.Drawable.class, modelLoaderFactoryDrawableFactory).append(java.lang.Integer.class, android.graphics.drawable.Drawable.class, modelLoaderFactoryDrawableFactory).append(android.net.Uri.class, java.io.InputStream.class, com.bumptech.glide.load.model.ResourceUriLoader.newStreamFactory(context)).append(android.net.Uri.class, android.content.res.AssetFileDescriptor.class, com.bumptech.glide.load.model.ResourceUriLoader.newAssetFileDescriptorFactory(context));
        com.bumptech.glide.load.model.ResourceLoader.UriFactory uriFactory = new com.bumptech.glide.load.model.ResourceLoader.UriFactory(resources);
        com.bumptech.glide.load.model.ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new com.bumptech.glide.load.model.ResourceLoader.AssetFileDescriptorFactory(resources);
        com.bumptech.glide.load.model.ResourceLoader.StreamFactory streamFactory = new com.bumptech.glide.load.model.ResourceLoader.StreamFactory(resources);
        registry.append(java.lang.Integer.class, android.net.Uri.class, uriFactory).append(java.lang.Integer.TYPE, android.net.Uri.class, uriFactory).append(java.lang.Integer.class, android.content.res.AssetFileDescriptor.class, assetFileDescriptorFactory).append(java.lang.Integer.TYPE, android.content.res.AssetFileDescriptor.class, assetFileDescriptorFactory).append(java.lang.Integer.class, java.io.InputStream.class, streamFactory).append(java.lang.Integer.TYPE, java.io.InputStream.class, streamFactory);
        registry.append(java.lang.String.class, java.io.InputStream.class, new com.bumptech.glide.load.model.DataUrlLoader.StreamFactory()).append(android.net.Uri.class, java.io.InputStream.class, new com.bumptech.glide.load.model.DataUrlLoader.StreamFactory()).append(java.lang.String.class, java.io.InputStream.class, new com.bumptech.glide.load.model.StringLoader.StreamFactory()).append(java.lang.String.class, android.os.ParcelFileDescriptor.class, new com.bumptech.glide.load.model.StringLoader.FileDescriptorFactory()).append(java.lang.String.class, android.content.res.AssetFileDescriptor.class, new com.bumptech.glide.load.model.StringLoader.AssetFileDescriptorFactory()).append(android.net.Uri.class, java.io.InputStream.class, new com.bumptech.glide.load.model.AssetUriLoader.StreamFactory(context.getAssets())).append(android.net.Uri.class, android.content.res.AssetFileDescriptor.class, new com.bumptech.glide.load.model.AssetUriLoader.FileDescriptorFactory(context.getAssets())).append(android.net.Uri.class, java.io.InputStream.class, new com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader.Factory(context)).append(android.net.Uri.class, java.io.InputStream.class, new com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader.Factory(context));
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            registry.append(android.net.Uri.class, java.io.InputStream.class, new com.bumptech.glide.load.model.stream.QMediaStoreUriLoader.InputStreamFactory(context));
            registry.append(android.net.Uri.class, android.os.ParcelFileDescriptor.class, new com.bumptech.glide.load.model.stream.QMediaStoreUriLoader.FileDescriptorFactory(context));
        }
        registry.append(android.net.Uri.class, java.io.InputStream.class, new com.bumptech.glide.load.model.UriLoader.StreamFactory(contentResolver)).append(android.net.Uri.class, android.os.ParcelFileDescriptor.class, new com.bumptech.glide.load.model.UriLoader.FileDescriptorFactory(contentResolver)).append(android.net.Uri.class, android.content.res.AssetFileDescriptor.class, new com.bumptech.glide.load.model.UriLoader.AssetFileDescriptorFactory(contentResolver)).append(android.net.Uri.class, java.io.InputStream.class, new com.bumptech.glide.load.model.UrlUriLoader.StreamFactory()).append(java.net.URL.class, java.io.InputStream.class, new com.bumptech.glide.load.model.stream.UrlLoader.StreamFactory()).append(android.net.Uri.class, java.io.File.class, new com.bumptech.glide.load.model.MediaStoreFileLoader.Factory(context)).append(com.bumptech.glide.load.model.GlideUrl.class, java.io.InputStream.class, new com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Factory()).append(byte[].class, java.nio.ByteBuffer.class, new com.bumptech.glide.load.model.ByteArrayLoader.ByteBufferFactory()).append(byte[].class, java.io.InputStream.class, new com.bumptech.glide.load.model.ByteArrayLoader.StreamFactory()).append(android.net.Uri.class, android.net.Uri.class, com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()).append(android.graphics.drawable.Drawable.class, android.graphics.drawable.Drawable.class, com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()).append(android.graphics.drawable.Drawable.class, android.graphics.drawable.Drawable.class, new com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder()).register(android.graphics.Bitmap.class, android.graphics.drawable.BitmapDrawable.class, new com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder(resources)).register(android.graphics.Bitmap.class, byte[].class, bitmapBytesTranscoder).register(android.graphics.drawable.Drawable.class, byte[].class, new com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder(bitmapPool, bitmapBytesTranscoder, gifDrawableBytesTranscoder)).register(com.bumptech.glide.load.resource.gif.GifDrawable.class, byte[].class, gifDrawableBytesTranscoder);
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            com.bumptech.glide.load.ResourceDecoder<java.nio.ByteBuffer, android.graphics.Bitmap> resourceDecoderByteBuffer = com.bumptech.glide.load.resource.bitmap.VideoDecoder.byteBuffer(bitmapPool);
            registry.append(java.nio.ByteBuffer.class, android.graphics.Bitmap.class, resourceDecoderByteBuffer);
            registry.append(java.nio.ByteBuffer.class, android.graphics.drawable.BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder(resources, resourceDecoderByteBuffer));
        }
    }

    private static void initializeModules(android.content.Context context, com.bumptech.glide.Glide glide, com.bumptech.glide.Registry registry, java.util.List<com.bumptech.glide.module.GlideModule> list, com.bumptech.glide.module.AppGlideModule appGlideModule) {
        for (com.bumptech.glide.module.GlideModule glideModule : list) {
            try {
                glideModule.registerComponents(context, glide, registry);
            } catch (java.lang.AbstractMethodError e) {
                throw new java.lang.IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + glideModule.getClass().getName(), e);
            }
        }
        if (appGlideModule != null) {
            appGlideModule.registerComponents(context, glide, registry);
        }
    }
}
