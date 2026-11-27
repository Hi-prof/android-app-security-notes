package com.facebook.imagepipeline.datasource;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseBitmapReferenceDataSubscriber extends com.facebook.datasource.BaseDataSubscriber<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
    protected abstract void onNewResultImpl(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference);

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> dataSource) {
        if (dataSource.isFinished()) {
            com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> result = dataSource.getResult();
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCloneUnderlyingBitmapReference = (result == null || !(result.get() instanceof com.facebook.imagepipeline.image.CloseableStaticBitmap)) ? null : ((com.facebook.imagepipeline.image.CloseableStaticBitmap) result.get()).cloneUnderlyingBitmapReference();
            try {
                onNewResultImpl(closeableReferenceCloneUnderlyingBitmapReference);
            } finally {
                com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceCloneUnderlyingBitmapReference);
                com.facebook.common.references.CloseableReference.closeSafely(result);
            }
        }
    }
}
