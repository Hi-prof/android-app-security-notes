package com.facebook.common.references;

/* JADX INFO: loaded from: classes.dex */
public abstract class CloseableReference<T> implements java.lang.Cloneable, java.io.Closeable {
    public static final int REF_TYPE_DEFAULT = 0;
    public static final int REF_TYPE_FINALIZER = 1;
    public static final int REF_TYPE_NOOP = 3;
    public static final int REF_TYPE_REF_COUNT = 2;
    private static int sBitmapCloseableRefType;
    protected boolean mIsClosed = false;

    @javax.annotation.Nullable
    protected final com.facebook.common.references.CloseableReference.LeakHandler mLeakHandler;
    protected final com.facebook.common.references.SharedReference<T> mSharedReference;

    @javax.annotation.Nullable
    protected final java.lang.Throwable mStacktrace;
    private static java.lang.Class<com.facebook.common.references.CloseableReference> TAG = com.facebook.common.references.CloseableReference.class;
    private static final com.facebook.common.references.ResourceReleaser<java.io.Closeable> DEFAULT_CLOSEABLE_RELEASER = new com.facebook.common.references.ResourceReleaser<java.io.Closeable>() { // from class: com.facebook.common.references.CloseableReference.1
        @Override // com.facebook.common.references.ResourceReleaser
        public void release(java.io.Closeable closeable) {
            try {
                com.facebook.common.internal.Closeables.close(closeable, true);
            } catch (java.io.IOException unused) {
            }
        }
    };
    private static final com.facebook.common.references.CloseableReference.LeakHandler DEFAULT_LEAK_HANDLER = new com.facebook.common.references.CloseableReference.LeakHandler() { // from class: com.facebook.common.references.CloseableReference.2
        @Override // com.facebook.common.references.CloseableReference.LeakHandler
        public boolean requiresStacktrace() {
            return false;
        }

        @Override // com.facebook.common.references.CloseableReference.LeakHandler
        public void reportLeak(com.facebook.common.references.SharedReference<java.lang.Object> sharedReference, @javax.annotation.Nullable java.lang.Throwable th) {
            java.lang.Object obj = sharedReference.get();
            com.facebook.common.logging.FLog.w((java.lang.Class<?>) com.facebook.common.references.CloseableReference.TAG, "Finalized without closing: %x %x (type = %s)", java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)), java.lang.Integer.valueOf(java.lang.System.identityHashCode(sharedReference)), obj == null ? null : obj.getClass().getName());
        }
    };

    public @interface CloseableRefType {
    }

    public interface LeakHandler {
        void reportLeak(com.facebook.common.references.SharedReference<java.lang.Object> sharedReference, @javax.annotation.Nullable java.lang.Throwable th);

        boolean requiresStacktrace();
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract com.facebook.common.references.CloseableReference<T> mo248clone();

    public static void setDisableCloseableReferencesForBitmaps(int i) {
        sBitmapCloseableRefType = i;
    }

    protected CloseableReference(com.facebook.common.references.SharedReference<T> sharedReference, @javax.annotation.Nullable com.facebook.common.references.CloseableReference.LeakHandler leakHandler, @javax.annotation.Nullable java.lang.Throwable th) {
        this.mSharedReference = (com.facebook.common.references.SharedReference) com.facebook.common.internal.Preconditions.checkNotNull(sharedReference);
        sharedReference.addReference();
        this.mLeakHandler = leakHandler;
        this.mStacktrace = th;
    }

    protected CloseableReference(T t, @javax.annotation.Nullable com.facebook.common.references.ResourceReleaser<T> resourceReleaser, @javax.annotation.Nullable com.facebook.common.references.CloseableReference.LeakHandler leakHandler, @javax.annotation.Nullable java.lang.Throwable th, boolean z) {
        this.mSharedReference = new com.facebook.common.references.SharedReference<>(t, resourceReleaser, z);
        this.mLeakHandler = leakHandler;
        this.mStacktrace = th;
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/CloseableReference<TT;>; */
    public static com.facebook.common.references.CloseableReference of(java.io.Closeable closeable) {
        return of(closeable, DEFAULT_CLOSEABLE_RELEASER);
    }

    public static <T> com.facebook.common.references.CloseableReference<T> of(T t, com.facebook.common.references.ResourceReleaser<T> resourceReleaser) {
        return of(t, resourceReleaser, DEFAULT_LEAK_HANDLER);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;Lcom/facebook/common/references/CloseableReference$LeakHandler;)Lcom/facebook/common/references/CloseableReference<TT;>; */
    public static com.facebook.common.references.CloseableReference of(@javax.annotation.Nullable java.io.Closeable closeable, com.facebook.common.references.CloseableReference.LeakHandler leakHandler) {
        if (closeable == null) {
            return null;
        }
        return of(closeable, DEFAULT_CLOSEABLE_RELEASER, leakHandler, leakHandler.requiresStacktrace() ? new java.lang.Throwable() : null);
    }

    public static <T> com.facebook.common.references.CloseableReference<T> of(T t, com.facebook.common.references.ResourceReleaser<T> resourceReleaser, com.facebook.common.references.CloseableReference.LeakHandler leakHandler) {
        if (t == null) {
            return null;
        }
        return of(t, resourceReleaser, leakHandler, leakHandler.requiresStacktrace() ? new java.lang.Throwable() : null);
    }

    public static <T> com.facebook.common.references.CloseableReference<T> of(T t, com.facebook.common.references.ResourceReleaser<T> resourceReleaser, com.facebook.common.references.CloseableReference.LeakHandler leakHandler, @javax.annotation.Nullable java.lang.Throwable th) {
        if (t == null) {
            return null;
        }
        if ((t instanceof android.graphics.Bitmap) || (t instanceof com.facebook.common.references.HasBitmap)) {
            int i = sBitmapCloseableRefType;
            if (i == 1) {
                return new com.facebook.common.references.FinalizerCloseableReference(t, resourceReleaser, leakHandler, th);
            }
            if (i == 2) {
                return new com.facebook.common.references.RefCountCloseableReference(t, resourceReleaser, leakHandler, th);
            }
            if (i == 3) {
                return new com.facebook.common.references.NoOpCloseableReference(t);
            }
        }
        return new com.facebook.common.references.DefaultCloseableReference(t, resourceReleaser, leakHandler, th);
    }

    public synchronized T get() {
        com.facebook.common.internal.Preconditions.checkState(!this.mIsClosed);
        return (T) com.facebook.common.internal.Preconditions.checkNotNull(this.mSharedReference.get());
    }

    @javax.annotation.Nullable
    public synchronized com.facebook.common.references.CloseableReference<T> cloneOrNull() {
        if (!isValid()) {
            return null;
        }
        return mo248clone();
    }

    public synchronized boolean isValid() {
        return !this.mIsClosed;
    }

    public synchronized com.facebook.common.references.SharedReference<T> getUnderlyingReferenceTestOnly() {
        return this.mSharedReference;
    }

    public int getValueHash() {
        if (isValid()) {
            return java.lang.System.identityHashCode(this.mSharedReference.get());
        }
        return 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.mIsClosed) {
                return;
            }
            this.mIsClosed = true;
            this.mSharedReference.deleteReference();
        }
    }

    public static boolean isValid(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<?> closeableReference) {
        return closeableReference != null && closeableReference.isValid();
    }

    @javax.annotation.Nullable
    public static <T> com.facebook.common.references.CloseableReference<T> cloneOrNull(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<T> closeableReference) {
        if (closeableReference != null) {
            return closeableReference.cloneOrNull();
        }
        return null;
    }

    public static <T> java.util.List<com.facebook.common.references.CloseableReference<T>> cloneOrNull(java.util.Collection<com.facebook.common.references.CloseableReference<T>> collection) {
        if (collection == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
        java.util.Iterator<com.facebook.common.references.CloseableReference<T>> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(cloneOrNull(it.next()));
        }
        return arrayList;
    }

    public static void closeSafely(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<?> closeableReference) {
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    public static void closeSafely(@javax.annotation.Nullable java.lang.Iterable<? extends com.facebook.common.references.CloseableReference<?>> iterable) {
        if (iterable != null) {
            java.util.Iterator<? extends com.facebook.common.references.CloseableReference<?>> it = iterable.iterator();
            while (it.hasNext()) {
                closeSafely(it.next());
            }
        }
    }
}
