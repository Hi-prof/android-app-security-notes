package com.facebook.imagepipeline.core;

/* JADX INFO: loaded from: classes.dex */
public class CloseableReferenceFactory {
    private final com.facebook.common.references.CloseableReference.LeakHandler mLeakHandler;

    public CloseableReferenceFactory(final com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker closeableReferenceLeakTracker) {
        this.mLeakHandler = new com.facebook.common.references.CloseableReference.LeakHandler() { // from class: com.facebook.imagepipeline.core.CloseableReferenceFactory.1
            @Override // com.facebook.common.references.CloseableReference.LeakHandler
            public void reportLeak(com.facebook.common.references.SharedReference<java.lang.Object> sharedReference, @javax.annotation.Nullable java.lang.Throwable th) {
                closeableReferenceLeakTracker.trackCloseableReferenceLeak(sharedReference, th);
                java.lang.Object obj = sharedReference.get();
                com.facebook.common.logging.FLog.w("Fresco", "Finalized without closing: %x %x (type = %s).\nStack:\n%s", java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)), java.lang.Integer.valueOf(java.lang.System.identityHashCode(sharedReference)), obj != null ? obj.getClass().getName() : "<value is null>", com.facebook.imagepipeline.core.CloseableReferenceFactory.getStackTraceString(th));
            }

            @Override // com.facebook.common.references.CloseableReference.LeakHandler
            public boolean requiresStacktrace() {
                return closeableReferenceLeakTracker.isSet();
            }
        };
    }

    public <U extends java.io.Closeable> com.facebook.common.references.CloseableReference<U> create(@javax.annotation.Nullable U u) {
        return com.facebook.common.references.CloseableReference.of(u, this.mLeakHandler);
    }

    public <T> com.facebook.common.references.CloseableReference<T> create(T t, com.facebook.common.references.ResourceReleaser<T> resourceReleaser) {
        return com.facebook.common.references.CloseableReference.of(t, resourceReleaser, this.mLeakHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String getStackTraceString(@javax.annotation.Nullable java.lang.Throwable th) {
        if (th == null) {
            return "";
        }
        return android.util.Log.getStackTraceString(th);
    }
}
