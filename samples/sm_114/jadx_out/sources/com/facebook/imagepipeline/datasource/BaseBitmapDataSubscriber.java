package com.facebook.imagepipeline.datasource;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseBitmapDataSubscriber extends com.facebook.datasource.BaseDataSubscriber<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
    protected abstract void onNewResultImpl(@javax.annotation.Nullable android.graphics.Bitmap bitmap);

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> dataSource) {
        if (dataSource.isFinished()) {
            com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> result = dataSource.getResult();
            try {
                onNewResultImpl((result == null || !(result.get() instanceof com.facebook.imagepipeline.image.CloseableBitmap)) ? null : ((com.facebook.imagepipeline.image.CloseableBitmap) result.get()).getUnderlyingBitmap());
            } finally {
                com.facebook.common.references.CloseableReference.closeSafely(result);
            }
        }
    }
}
