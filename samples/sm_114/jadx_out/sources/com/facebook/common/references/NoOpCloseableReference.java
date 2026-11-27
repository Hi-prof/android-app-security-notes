package com.facebook.common.references;

/* JADX INFO: loaded from: classes.dex */
public class NoOpCloseableReference<T> extends com.facebook.common.references.CloseableReference<T> {
    @Override // com.facebook.common.references.CloseableReference
    /* JADX INFO: renamed from: clone */
    public com.facebook.common.references.CloseableReference<T> mo248clone() {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference
    public com.facebook.common.references.CloseableReference<T> cloneOrNull() {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.facebook.common.references.CloseableReference
    public boolean isValid() {
        return true;
    }

    NoOpCloseableReference(T t) {
        super(t, null, null, null, false);
    }
}
