package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: classes.dex */
public final class LruArrayPool implements com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool {
    private static final int DEFAULT_SIZE = 4194304;
    static final int MAX_OVER_SIZE_MULTIPLE = 8;
    private static final int SINGLE_ARRAY_MAX_SIZE_DIVISOR = 2;
    private final java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface<?>> adapters;
    private int currentSize;
    private final com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap<com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key, java.lang.Object> groupedMap;
    private final com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.KeyPool keyPool;
    private final int maxSize;
    private final java.util.Map<java.lang.Class<?>, java.util.NavigableMap<java.lang.Integer, java.lang.Integer>> sortedSizes;

    public LruArrayPool() {
        this.groupedMap = new com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap<>();
        this.keyPool = new com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.KeyPool();
        this.sortedSizes = new java.util.HashMap();
        this.adapters = new java.util.HashMap();
        this.maxSize = 4194304;
    }

    public LruArrayPool(int i) {
        this.groupedMap = new com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap<>();
        this.keyPool = new com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.KeyPool();
        this.sortedSizes = new java.util.HashMap();
        this.adapters = new java.util.HashMap();
        this.maxSize = i;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    @java.lang.Deprecated
    public <T> void put(T t, java.lang.Class<T> cls) {
        put(t);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> void put(T t) {
        java.lang.Class<?> cls = t.getClass();
        com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface<T> adapterFromType = getAdapterFromType(cls);
        int arrayLength = adapterFromType.getArrayLength(t);
        int elementSizeInBytes = adapterFromType.getElementSizeInBytes() * arrayLength;
        if (isSmallEnoughForReuse(elementSizeInBytes)) {
            com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key key = this.keyPool.get(arrayLength, cls);
            this.groupedMap.put(key, t);
            java.util.NavigableMap<java.lang.Integer, java.lang.Integer> sizesForAdapter = getSizesForAdapter(cls);
            java.lang.Integer num = (java.lang.Integer) sizesForAdapter.get(java.lang.Integer.valueOf(key.size));
            java.lang.Integer numValueOf = java.lang.Integer.valueOf(key.size);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            sizesForAdapter.put(numValueOf, java.lang.Integer.valueOf(iIntValue));
            this.currentSize += elementSizeInBytes;
            evict();
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T getExact(int i, java.lang.Class<T> cls) {
        return (T) getForKey(this.keyPool.get(i, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T get(int i, java.lang.Class<T> cls) {
        com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key key;
        java.lang.Integer numCeilingKey = getSizesForAdapter(cls).ceilingKey(java.lang.Integer.valueOf(i));
        if (mayFillRequest(i, numCeilingKey)) {
            key = this.keyPool.get(numCeilingKey.intValue(), cls);
        } else {
            key = this.keyPool.get(i, cls);
        }
        return (T) getForKey(key, cls);
    }

    private <T> T getForKey(com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key key, java.lang.Class<T> cls) {
        com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface<T> adapterFromType = getAdapterFromType(cls);
        T t = (T) getArrayForKey(key);
        if (t != null) {
            this.currentSize -= adapterFromType.getArrayLength(t) * adapterFromType.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromType.getArrayLength(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (android.util.Log.isLoggable(adapterFromType.getTag(), 2)) {
            android.util.Log.v(adapterFromType.getTag(), "Allocated " + key.size + " bytes");
        }
        return adapterFromType.newArray(key.size);
    }

    private <T> T getArrayForKey(com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key key) {
        return (T) this.groupedMap.get(key);
    }

    private boolean isSmallEnoughForReuse(int i) {
        return i <= this.maxSize / 2;
    }

    private boolean mayFillRequest(int i, java.lang.Integer num) {
        if (num != null) {
            return isNoMoreThanHalfFull() || num.intValue() <= i * 8;
        }
        return false;
    }

    private boolean isNoMoreThanHalfFull() {
        int i = this.currentSize;
        return i == 0 || this.maxSize / i >= 2;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void clearMemory() {
        evictToSize(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void trimMemory(int i) {
        try {
            if (i >= 40) {
                clearMemory();
            } else if (i >= 20 || i == 15) {
                evictToSize(this.maxSize / 2);
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    private void evict() {
        evictToSize(this.maxSize);
    }

    private void evictToSize(int i) {
        while (this.currentSize > i) {
            java.lang.Object objRemoveLast = this.groupedMap.removeLast();
            com.bumptech.glide.util.Preconditions.checkNotNull(objRemoveLast);
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface adapterFromObject = getAdapterFromObject(objRemoveLast);
            this.currentSize -= adapterFromObject.getArrayLength(objRemoveLast) * adapterFromObject.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromObject.getArrayLength(objRemoveLast), objRemoveLast.getClass());
            if (android.util.Log.isLoggable(adapterFromObject.getTag(), 2)) {
                android.util.Log.v(adapterFromObject.getTag(), "evicted: " + adapterFromObject.getArrayLength(objRemoveLast));
            }
        }
    }

    private void decrementArrayOfSize(int i, java.lang.Class<?> cls) {
        java.util.NavigableMap<java.lang.Integer, java.lang.Integer> sizesForAdapter = getSizesForAdapter(cls);
        java.lang.Integer num = (java.lang.Integer) sizesForAdapter.get(java.lang.Integer.valueOf(i));
        if (num == null) {
            throw new java.lang.NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        }
        if (num.intValue() == 1) {
            sizesForAdapter.remove(java.lang.Integer.valueOf(i));
        } else {
            sizesForAdapter.put(java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(num.intValue() - 1));
        }
    }

    private java.util.NavigableMap<java.lang.Integer, java.lang.Integer> getSizesForAdapter(java.lang.Class<?> cls) {
        java.util.NavigableMap<java.lang.Integer, java.lang.Integer> navigableMap = this.sortedSizes.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        java.util.TreeMap treeMap = new java.util.TreeMap();
        this.sortedSizes.put(cls, treeMap);
        return treeMap;
    }

    private <T> com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface<T> getAdapterFromObject(T t) {
        return getAdapterFromType(t.getClass());
    }

    private <T> com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface<T> getAdapterFromType(java.lang.Class<T> cls) {
        com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface<T> byteArrayAdapter;
        com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface<T> arrayAdapterInterface = (com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface) this.adapters.get(cls);
        if (arrayAdapterInterface != null) {
            return arrayAdapterInterface;
        }
        if (cls.equals(int[].class)) {
            byteArrayAdapter = new com.bumptech.glide.load.engine.bitmap_recycle.IntegerArrayAdapter();
        } else if (cls.equals(byte[].class)) {
            byteArrayAdapter = new com.bumptech.glide.load.engine.bitmap_recycle.ByteArrayAdapter();
        } else {
            throw new java.lang.IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
        }
        this.adapters.put(cls, byteArrayAdapter);
        return byteArrayAdapter;
    }

    int getCurrentSize() {
        int iIntValue = 0;
        for (java.lang.Class<?> cls : this.sortedSizes.keySet()) {
            for (java.lang.Integer num : this.sortedSizes.get(cls).keySet()) {
                iIntValue += num.intValue() * ((java.lang.Integer) this.sortedSizes.get(cls).get(num)).intValue() * getAdapterFromType(cls).getElementSizeInBytes();
            }
        }
        return iIntValue;
    }

    private static final class KeyPool extends com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool<com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key> {
        KeyPool() {
        }

        com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key get(int i, java.lang.Class<?> cls) {
            com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key key = get();
            key.init(i, cls);
            return key;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key create() {
            return new com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key(this);
        }
    }

    private static final class Key implements com.bumptech.glide.load.engine.bitmap_recycle.Poolable {
        private java.lang.Class<?> arrayClass;
        private final com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.KeyPool pool;
        int size;

        Key(com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.KeyPool keyPool) {
            this.pool = keyPool;
        }

        void init(int i, java.lang.Class<?> cls) {
            this.size = i;
            this.arrayClass = cls;
        }

        public boolean equals(java.lang.Object obj) {
            if (obj instanceof com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key) {
                com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key key = (com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key) obj;
                if (this.size == key.size && this.arrayClass == key.arrayClass) {
                    return true;
                }
            }
            return false;
        }

        public java.lang.String toString() {
            return "Key{size=" + this.size + "array=" + this.arrayClass + com.taobao.weex.el.parse.Operators.BLOCK_END;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public int hashCode() {
            int i = this.size * 31;
            java.lang.Class<?> cls = this.arrayClass;
            return i + (cls != null ? cls.hashCode() : 0);
        }
    }
}
