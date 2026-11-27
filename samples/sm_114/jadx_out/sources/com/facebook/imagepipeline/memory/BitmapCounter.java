package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public class BitmapCounter {
    private int mCount;
    private final int mMaxCount;
    private final int mMaxSize;
    private long mSize;
    private final com.facebook.common.references.ResourceReleaser<android.graphics.Bitmap> mUnpooledBitmapsReleaser;

    public BitmapCounter(int i, int i2) {
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i > 0));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i2 > 0));
        this.mMaxCount = i;
        this.mMaxSize = i2;
        this.mUnpooledBitmapsReleaser = new com.facebook.common.references.ResourceReleaser<android.graphics.Bitmap>() { // from class: com.facebook.imagepipeline.memory.BitmapCounter.1
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(android.graphics.Bitmap bitmap) {
                try {
                    com.facebook.imagepipeline.memory.BitmapCounter.this.decrease(bitmap);
                } finally {
                    bitmap.recycle();
                }
            }
        };
    }

    public synchronized boolean increase(android.graphics.Bitmap bitmap) {
        int sizeInBytes = com.facebook.imageutils.BitmapUtil.getSizeInBytes(bitmap);
        int i = this.mCount;
        if (i < this.mMaxCount) {
            long j = this.mSize;
            long j2 = sizeInBytes;
            if (j + j2 <= this.mMaxSize) {
                this.mCount = i + 1;
                this.mSize = j + j2;
                return true;
            }
        }
        return false;
    }

    public synchronized void decrease(android.graphics.Bitmap bitmap) {
        int sizeInBytes = com.facebook.imageutils.BitmapUtil.getSizeInBytes(bitmap);
        com.facebook.common.internal.Preconditions.checkArgument(this.mCount > 0, "No bitmaps registered.");
        long j = sizeInBytes;
        com.facebook.common.internal.Preconditions.checkArgument(j <= this.mSize, "Bitmap size bigger than the total registered size: %d, %d", java.lang.Integer.valueOf(sizeInBytes), java.lang.Long.valueOf(this.mSize));
        this.mSize -= j;
        this.mCount--;
    }

    public synchronized int getCount() {
        return this.mCount;
    }

    public synchronized long getSize() {
        return this.mSize;
    }

    public synchronized int getMaxCount() {
        return this.mMaxCount;
    }

    public synchronized int getMaxSize() {
        return this.mMaxSize;
    }

    public com.facebook.common.references.ResourceReleaser<android.graphics.Bitmap> getReleaser() {
        return this.mUnpooledBitmapsReleaser;
    }
}
