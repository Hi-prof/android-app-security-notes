package com.facebook.common.references;

/* JADX INFO: loaded from: classes.dex */
public class DefaultCloseableReference<T> extends com.facebook.common.references.CloseableReference<T> {
    private static final java.lang.String TAG = "DefaultCloseableReference";

    private DefaultCloseableReference(com.facebook.common.references.SharedReference<T> sharedReference, @javax.annotation.Nullable com.facebook.common.references.CloseableReference.LeakHandler leakHandler, @javax.annotation.Nullable java.lang.Throwable th) {
        super(sharedReference, leakHandler, th);
    }

    DefaultCloseableReference(T t, com.facebook.common.references.ResourceReleaser<T> resourceReleaser, com.facebook.common.references.CloseableReference.LeakHandler leakHandler, @javax.annotation.Nullable java.lang.Throwable th) {
        super(t, resourceReleaser, leakHandler, th, true);
    }

    @Override // com.facebook.common.references.CloseableReference
    /* JADX INFO: renamed from: clone */
    public com.facebook.common.references.CloseableReference<T> mo248clone() {
        com.facebook.common.internal.Preconditions.checkState(isValid());
        return new com.facebook.common.references.DefaultCloseableReference(this.mSharedReference, this.mLeakHandler, this.mStacktrace != null ? new java.lang.Throwable() : null);
    }

    protected void finalize() throws java.lang.Throwable {
        try {
            synchronized (this) {
                if (!this.mIsClosed) {
                    T t = this.mSharedReference.get();
                    com.facebook.common.logging.FLog.w(TAG, "Finalized without closing: %x %x (type = %s)", java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)), java.lang.Integer.valueOf(java.lang.System.identityHashCode(this.mSharedReference)), t == null ? null : t.getClass().getName());
                    if (this.mLeakHandler != null) {
                        this.mLeakHandler.reportLeak(this.mSharedReference, this.mStacktrace);
                    }
                    close();
                    super.finalize();
                    return;
                }
                super.finalize();
            }
        } catch (java.lang.Throwable th) {
            super.finalize();
            throw th;
        }
    }
}
