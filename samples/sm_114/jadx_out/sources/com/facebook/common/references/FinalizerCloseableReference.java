package com.facebook.common.references;

/* JADX INFO: loaded from: classes.dex */
public class FinalizerCloseableReference<T> extends com.facebook.common.references.CloseableReference<T> {
    private static final java.lang.String TAG = "FinalizerCloseableReference";

    @Override // com.facebook.common.references.CloseableReference
    /* JADX INFO: renamed from: clone */
    public com.facebook.common.references.CloseableReference<T> mo248clone() {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    FinalizerCloseableReference(T t, com.facebook.common.references.ResourceReleaser<T> resourceReleaser, com.facebook.common.references.CloseableReference.LeakHandler leakHandler, @javax.annotation.Nullable java.lang.Throwable th) {
        super(t, resourceReleaser, leakHandler, th, true);
    }

    protected void finalize() throws java.lang.Throwable {
        try {
            synchronized (this) {
                if (!this.mIsClosed) {
                    T t = this.mSharedReference.get();
                    com.facebook.common.logging.FLog.w(TAG, "Finalized without closing: %x %x (type = %s)", java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)), java.lang.Integer.valueOf(java.lang.System.identityHashCode(this.mSharedReference)), t == null ? null : t.getClass().getName());
                    this.mSharedReference.deleteReference();
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
