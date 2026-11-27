package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
class Bucket<V> {
    private static final java.lang.String TAG = "BUCKET";
    private final boolean mFixBucketsReinitialization;
    final java.util.Queue mFreeList;
    private int mInUseLength;
    public final int mItemSize;
    public final int mMaxLength;

    public Bucket(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.Preconditions.checkState(i > 0);
        com.facebook.common.internal.Preconditions.checkState(i2 >= 0);
        com.facebook.common.internal.Preconditions.checkState(i3 >= 0);
        this.mItemSize = i;
        this.mMaxLength = i2;
        this.mFreeList = new java.util.LinkedList();
        this.mInUseLength = i3;
        this.mFixBucketsReinitialization = z;
    }

    public boolean isMaxLengthExceeded() {
        return this.mInUseLength + getFreeListSize() > this.mMaxLength;
    }

    int getFreeListSize() {
        return this.mFreeList.size();
    }

    @javax.annotation.Nullable
    @java.lang.Deprecated
    public V get() {
        V vPop = pop();
        if (vPop != null) {
            this.mInUseLength++;
        }
        return vPop;
    }

    @javax.annotation.Nullable
    public V pop() {
        return (V) this.mFreeList.poll();
    }

    public void incrementInUseCount() {
        this.mInUseLength++;
    }

    public void release(V v) {
        com.facebook.common.internal.Preconditions.checkNotNull(v);
        if (this.mFixBucketsReinitialization) {
            com.facebook.common.internal.Preconditions.checkState(this.mInUseLength > 0);
            this.mInUseLength--;
            addToFreeList(v);
        } else {
            int i = this.mInUseLength;
            if (i > 0) {
                this.mInUseLength = i - 1;
                addToFreeList(v);
            } else {
                com.facebook.common.logging.FLog.e(TAG, "Tried to release value %s from an empty bucket!", v);
            }
        }
    }

    void addToFreeList(V v) {
        this.mFreeList.add(v);
    }

    public void decrementInUseCount() {
        com.facebook.common.internal.Preconditions.checkState(this.mInUseLength > 0);
        this.mInUseLength--;
    }

    public int getInUseCount() {
        return this.mInUseLength;
    }
}
