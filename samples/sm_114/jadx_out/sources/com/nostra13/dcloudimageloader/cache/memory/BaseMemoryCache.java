package com.nostra13.dcloudimageloader.cache.memory;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseMemoryCache implements com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware {
    private final java.util.Map<java.lang.String, java.lang.ref.Reference<android.graphics.Bitmap>> softMap = java.util.Collections.synchronizedMap(new java.util.HashMap());

    protected abstract java.lang.ref.Reference<android.graphics.Bitmap> createReference(android.graphics.Bitmap bitmap);

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public android.graphics.Bitmap get(java.lang.String str) {
        java.lang.ref.Reference<android.graphics.Bitmap> reference = this.softMap.get(str);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public boolean put(java.lang.String str, android.graphics.Bitmap bitmap) {
        this.softMap.put(str, createReference(bitmap));
        return true;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public android.graphics.Bitmap remove(java.lang.String str) {
        java.lang.ref.Reference<android.graphics.Bitmap> referenceRemove = this.softMap.remove(str);
        if (referenceRemove == null) {
            return null;
        }
        return referenceRemove.get();
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public java.util.Collection<java.lang.String> keys() {
        java.util.HashSet hashSet;
        synchronized (this.softMap) {
            hashSet = new java.util.HashSet(this.softMap.keySet());
        }
        return hashSet;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.softMap.clear();
    }
}
