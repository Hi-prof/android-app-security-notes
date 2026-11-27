package com.facebook.imagepipeline.datasource;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseListBitmapDataSubscriber extends com.facebook.datasource.BaseDataSubscriber<java.util.List<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> {
    protected abstract void onNewResultListImpl(@javax.annotation.Nullable java.util.List<android.graphics.Bitmap> list);

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(com.facebook.datasource.DataSource<java.util.List<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> dataSource) {
        if (dataSource.isFinished()) {
            java.util.List<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> result = dataSource.getResult();
            if (result == null) {
                onNewResultListImpl(null);
                return;
            }
            try {
                java.util.ArrayList arrayList = new java.util.ArrayList(result.size());
                for (com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference : result) {
                    if (closeableReference != null && (closeableReference.get() instanceof com.facebook.imagepipeline.image.CloseableBitmap)) {
                        arrayList.add(((com.facebook.imagepipeline.image.CloseableBitmap) closeableReference.get()).getUnderlyingBitmap());
                    } else {
                        arrayList.add(null);
                    }
                }
                onNewResultListImpl(arrayList);
            } finally {
                java.util.Iterator<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> it = result.iterator();
                while (it.hasNext()) {
                    com.facebook.common.references.CloseableReference.closeSafely(it.next());
                }
            }
        }
    }
}
