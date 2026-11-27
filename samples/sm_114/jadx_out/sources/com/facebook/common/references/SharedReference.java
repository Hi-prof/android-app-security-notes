package com.facebook.common.references;

/* JADX INFO: loaded from: classes.dex */
public class SharedReference<T> {
    private static final java.util.Map<java.lang.Object, java.lang.Integer> sLiveObjects = new java.util.IdentityHashMap();
    private int mRefCount;

    @javax.annotation.Nullable
    private final com.facebook.common.references.ResourceReleaser<T> mResourceReleaser;

    @javax.annotation.Nullable
    private T mValue;

    public SharedReference(T t, @javax.annotation.Nullable com.facebook.common.references.ResourceReleaser<T> resourceReleaser, boolean z) {
        this.mValue = (T) com.facebook.common.internal.Preconditions.checkNotNull(t);
        this.mResourceReleaser = resourceReleaser;
        this.mRefCount = 1;
        if (z) {
            addLiveReference(t);
        }
    }

    public SharedReference(T t, com.facebook.common.references.ResourceReleaser<T> resourceReleaser) {
        this(t, resourceReleaser, false);
    }

    private static void addLiveReference(java.lang.Object obj) {
        java.util.Map<java.lang.Object, java.lang.Integer> map = sLiveObjects;
        synchronized (map) {
            java.lang.Integer num = map.get(obj);
            if (num == null) {
                map.put(obj, 1);
            } else {
                map.put(obj, java.lang.Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void removeLiveReference(java.lang.Object obj) {
        java.util.Map<java.lang.Object, java.lang.Integer> map = sLiveObjects;
        synchronized (map) {
            java.lang.Integer num = map.get(obj);
            if (num == null) {
                com.facebook.common.logging.FLog.wtf("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                map.remove(obj);
            } else {
                map.put(obj, java.lang.Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    @javax.annotation.Nullable
    public synchronized T get() {
        return this.mValue;
    }

    public synchronized boolean isValid() {
        return this.mRefCount > 0;
    }

    public static boolean isValid(@javax.annotation.Nullable com.facebook.common.references.SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void addReference() {
        ensureValid();
        this.mRefCount++;
    }

    public synchronized boolean addReferenceIfValid() {
        if (!isValid()) {
            return false;
        }
        addReference();
        return true;
    }

    public synchronized boolean deleteReferenceIfValid() {
        if (!isValid()) {
            return false;
        }
        deleteReference();
        return true;
    }

    public void deleteReference() {
        T t;
        if (decreaseRefCount() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            if (t != null) {
                com.facebook.common.references.ResourceReleaser<T> resourceReleaser = this.mResourceReleaser;
                if (resourceReleaser != null) {
                    resourceReleaser.release(t);
                }
                removeLiveReference(t);
            }
        }
    }

    private synchronized int decreaseRefCount() {
        int i;
        ensureValid();
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(this.mRefCount > 0));
        i = this.mRefCount - 1;
        this.mRefCount = i;
        return i;
    }

    private void ensureValid() {
        if (!isValid(this)) {
            throw new com.facebook.common.references.SharedReference.NullReferenceException();
        }
    }

    public synchronized int getRefCountTestOnly() {
        return this.mRefCount;
    }

    public static class NullReferenceException extends java.lang.RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }

    public static java.lang.String reportData() {
        return com.facebook.common.internal.Objects.toStringHelper("SharedReference").add("live_objects_count", sLiveObjects.size()).toString();
    }
}
