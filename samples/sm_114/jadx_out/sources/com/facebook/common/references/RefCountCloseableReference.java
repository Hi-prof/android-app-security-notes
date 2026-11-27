package com.facebook.common.references;

/* JADX INFO: loaded from: classes.dex */
public class RefCountCloseableReference<T> extends com.facebook.common.references.CloseableReference<T> {
    private RefCountCloseableReference(com.facebook.common.references.SharedReference<T> sharedReference, @javax.annotation.Nullable com.facebook.common.references.CloseableReference.LeakHandler leakHandler, @javax.annotation.Nullable java.lang.Throwable th) {
        super(sharedReference, leakHandler, th);
    }

    RefCountCloseableReference(T t, com.facebook.common.references.ResourceReleaser<T> resourceReleaser, com.facebook.common.references.CloseableReference.LeakHandler leakHandler, @javax.annotation.Nullable java.lang.Throwable th) {
        super(t, resourceReleaser, leakHandler, th, false);
    }

    @Override // com.facebook.common.references.CloseableReference
    /* JADX INFO: renamed from: clone */
    public com.facebook.common.references.CloseableReference<T> mo248clone() {
        com.facebook.common.internal.Preconditions.checkState(isValid());
        return new com.facebook.common.references.RefCountCloseableReference(this.mSharedReference, this.mLeakHandler, this.mStacktrace);
    }
}
