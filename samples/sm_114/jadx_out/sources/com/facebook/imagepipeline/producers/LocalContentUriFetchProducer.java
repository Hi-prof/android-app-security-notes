package com.facebook.imagepipeline.producers;

/* JADX INFO: compiled from: LocalContentUriFetchProducer.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;", "Lcom/facebook/imagepipeline/producers/LocalFetchProducer;", "executor", "Ljava/util/concurrent/Executor;", "pooledByteBufferFactory", "Lcom/facebook/common/memory/PooledByteBufferFactory;", "contentResolver", "Landroid/content/ContentResolver;", "<init>", "(Ljava/util/concurrent/Executor;Lcom/facebook/common/memory/PooledByteBufferFactory;Landroid/content/ContentResolver;)V", "getEncodedImage", "Lcom/facebook/imagepipeline/image/EncodedImage;", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "getCameraImage", "uri", "Landroid/net/Uri;", "getProducerName", "", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocalContentUriFetchProducer extends com.facebook.imagepipeline.producers.LocalFetchProducer {
    public static final java.lang.String PRODUCER_NAME = "LocalContentUriFetchProducer";
    private final android.content.ContentResolver contentResolver;
    private static final java.lang.String[] PROJECTION = {"_id", "_data"};

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalContentUriFetchProducer(java.util.concurrent.Executor executor, com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory, android.content.ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(executor, "executor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.contentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected com.facebook.imagepipeline.image.EncodedImage getEncodedImage(com.facebook.imagepipeline.request.ImageRequest imageRequest) throws java.io.IOException {
        com.facebook.imagepipeline.image.EncodedImage cameraImage;
        java.io.FileInputStream fileInputStreamCreateInputStream;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        android.net.Uri sourceUri = imageRequest.getSourceUri();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
        if (com.facebook.common.util.UriUtil.isLocalContactUri(sourceUri)) {
            java.lang.String string = sourceUri.toString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (kotlin.text.StringsKt.endsWith$default(string, "/photo", false, 2, (java.lang.Object) null)) {
                fileInputStreamCreateInputStream = this.contentResolver.openInputStream(sourceUri);
            } else {
                java.lang.String string2 = sourceUri.toString();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                if (kotlin.text.StringsKt.endsWith$default(string2, "/display_photo", false, 2, (java.lang.Object) null)) {
                    try {
                        android.content.res.AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.contentResolver.openAssetFileDescriptor(sourceUri, "r");
                        if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                            throw new java.lang.IllegalStateException("Required value was null.".toString());
                        }
                        fileInputStreamCreateInputStream = assetFileDescriptorOpenAssetFileDescriptor.createInputStream();
                    } catch (java.io.IOException unused) {
                        throw new java.io.IOException("Contact photo does not exist: " + sourceUri);
                    }
                } else {
                    java.io.InputStream inputStreamOpenContactPhotoInputStream = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(this.contentResolver, sourceUri);
                    if (inputStreamOpenContactPhotoInputStream == null) {
                        throw new java.io.IOException("Contact photo does not exist: " + sourceUri);
                    }
                    fileInputStreamCreateInputStream = inputStreamOpenContactPhotoInputStream;
                }
            }
            if (fileInputStreamCreateInputStream == null) {
                throw new java.lang.IllegalStateException("Required value was null.".toString());
            }
            return getEncodedImage(fileInputStreamCreateInputStream, -1);
        }
        if (com.facebook.common.util.UriUtil.isLocalCameraUri(sourceUri) && (cameraImage = getCameraImage(sourceUri)) != null) {
            return cameraImage;
        }
        java.io.InputStream inputStreamOpenInputStream = this.contentResolver.openInputStream(sourceUri);
        if (inputStreamOpenInputStream != null) {
            return getEncodedImage(inputStreamOpenInputStream, -1);
        }
        throw new java.lang.IllegalStateException("Required value was null.".toString());
    }

    private final com.facebook.imagepipeline.image.EncodedImage getCameraImage(android.net.Uri uri) throws java.io.IOException {
        try {
            android.os.ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.contentResolver.openFileDescriptor(uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                throw new java.lang.IllegalStateException("Required value was null.".toString());
            }
            com.facebook.imagepipeline.image.EncodedImage encodedImage = getEncodedImage(new java.io.FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()), (int) parcelFileDescriptorOpenFileDescriptor.getStatSize());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(encodedImage, "getEncodedImage(...)");
            parcelFileDescriptorOpenFileDescriptor.close();
            return encodedImage;
        } catch (java.io.FileNotFoundException unused) {
            return null;
        }
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected java.lang.String getProducerName() {
        return PRODUCER_NAME;
    }
}
