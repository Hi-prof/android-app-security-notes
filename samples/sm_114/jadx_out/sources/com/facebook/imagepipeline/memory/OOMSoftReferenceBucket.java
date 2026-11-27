package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
class OOMSoftReferenceBucket<V> extends com.facebook.imagepipeline.memory.Bucket<V> {
    private java.util.LinkedList<com.facebook.common.references.OOMSoftReference<V>> mSpareReferences;

    public OOMSoftReferenceBucket(int i, int i2, int i3) {
        super(i, i2, i3, false);
        this.mSpareReferences = new java.util.LinkedList<>();
    }

    @Override // com.facebook.imagepipeline.memory.Bucket
    @javax.annotation.Nullable
    public V pop() {
        com.facebook.common.references.OOMSoftReference<V> oOMSoftReference = (com.facebook.common.references.OOMSoftReference) this.mFreeList.poll();
        com.facebook.common.internal.Preconditions.checkNotNull(oOMSoftReference);
        V v = oOMSoftReference.get();
        oOMSoftReference.clear();
        this.mSpareReferences.add(oOMSoftReference);
        return v;
    }

    @Override // com.facebook.imagepipeline.memory.Bucket
    void addToFreeList(V v) {
        com.facebook.common.references.OOMSoftReference<V> oOMSoftReferencePoll = this.mSpareReferences.poll();
        if (oOMSoftReferencePoll == null) {
            oOMSoftReferencePoll = new com.facebook.common.references.OOMSoftReference<>();
        }
        oOMSoftReferencePoll.set(v);
        this.mFreeList.add(oOMSoftReferencePoll);
    }
}
