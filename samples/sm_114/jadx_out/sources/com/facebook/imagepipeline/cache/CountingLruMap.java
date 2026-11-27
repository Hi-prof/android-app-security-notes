package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes.dex */
public class CountingLruMap<K, V> {
    private final java.util.LinkedHashMap<K, V> mMap = new java.util.LinkedHashMap<>();
    private int mSizeInBytes = 0;
    private final com.facebook.imagepipeline.cache.ValueDescriptor<V> mValueDescriptor;

    public CountingLruMap(com.facebook.imagepipeline.cache.ValueDescriptor<V> valueDescriptor) {
        this.mValueDescriptor = valueDescriptor;
    }

    synchronized java.util.ArrayList<K> getKeys() {
        return new java.util.ArrayList<>(this.mMap.keySet());
    }

    synchronized java.util.ArrayList<V> getValues() {
        return new java.util.ArrayList<>(this.mMap.values());
    }

    public synchronized int getCount() {
        return this.mMap.size();
    }

    public synchronized int getSizeInBytes() {
        return this.mSizeInBytes;
    }

    @javax.annotation.Nullable
    public synchronized K getFirstKey() {
        return this.mMap.isEmpty() ? null : this.mMap.keySet().iterator().next();
    }

    public synchronized java.util.ArrayList<java.util.Map.Entry<K, V>> getMatchingEntries(@javax.annotation.Nullable com.facebook.common.internal.Predicate<K> predicate) {
        java.util.ArrayList<java.util.Map.Entry<K, V>> arrayList;
        arrayList = new java.util.ArrayList<>(this.mMap.entrySet().size());
        for (java.util.Map.Entry<K, V> entry : this.mMap.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.mMap.containsKey(k);
    }

    @javax.annotation.Nullable
    public synchronized V get(K k) {
        return this.mMap.get(k);
    }

    @javax.annotation.Nullable
    public synchronized V put(K k, V v) {
        V vRemove;
        vRemove = this.mMap.remove(k);
        this.mSizeInBytes -= getValueSizeInBytes(vRemove);
        this.mMap.put(k, v);
        this.mSizeInBytes += getValueSizeInBytes(v);
        return vRemove;
    }

    @javax.annotation.Nullable
    public synchronized V remove(K k) {
        V vRemove;
        vRemove = this.mMap.remove(k);
        this.mSizeInBytes -= getValueSizeInBytes(vRemove);
        return vRemove;
    }

    public synchronized java.util.ArrayList<V> removeAll(@javax.annotation.Nullable com.facebook.common.internal.Predicate<K> predicate) {
        java.util.ArrayList<V> arrayList;
        arrayList = new java.util.ArrayList<>();
        java.util.Iterator<java.util.Map.Entry<K, V>> it = this.mMap.entrySet().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry<K, V> next = it.next();
            if (predicate == null || predicate.apply(next.getKey())) {
                arrayList.add(next.getValue());
                this.mSizeInBytes -= getValueSizeInBytes(next.getValue());
                it.remove();
            }
        }
        return arrayList;
    }

    public synchronized java.util.ArrayList<V> clear() {
        java.util.ArrayList<V> arrayList;
        arrayList = new java.util.ArrayList<>((java.util.Collection<? extends V>) this.mMap.values());
        this.mMap.clear();
        this.mSizeInBytes = 0;
        return arrayList;
    }

    public synchronized void resetSize() {
        if (this.mMap.isEmpty()) {
            this.mSizeInBytes = 0;
        }
    }

    private int getValueSizeInBytes(@javax.annotation.Nullable V v) {
        if (v == null) {
            return 0;
        }
        return this.mValueDescriptor.getSizeInBytes(v);
    }
}
