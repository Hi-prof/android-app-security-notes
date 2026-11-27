package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public class BucketMap<T> {

    @javax.annotation.Nullable
    com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<T> mHead;
    protected final android.util.SparseArray<com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<T>> mMap = new android.util.SparseArray<>();

    @javax.annotation.Nullable
    com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<T> mTail;

    static class LinkedEntry<I> {
        int key;

        @javax.annotation.Nullable
        com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<I> next;

        @javax.annotation.Nullable
        com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<I> prev;
        java.util.LinkedList<I> value;

        private LinkedEntry(@javax.annotation.Nullable com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<I> linkedEntry, int i, java.util.LinkedList<I> linkedList, @javax.annotation.Nullable com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<I> linkedEntry2) {
            this.prev = linkedEntry;
            this.key = i;
            this.value = linkedList;
            this.next = linkedEntry2;
        }

        public java.lang.String toString() {
            return "LinkedEntry(key: " + this.key + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
        }
    }

    @javax.annotation.Nullable
    public synchronized T acquire(int i) {
        com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<T> linkedEntry = this.mMap.get(i);
        if (linkedEntry == null) {
            return null;
        }
        T tPollFirst = linkedEntry.value.pollFirst();
        moveToFront(linkedEntry);
        return tPollFirst;
    }

    public synchronized void release(int i, T t) {
        com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<T> linkedEntry = this.mMap.get(i);
        if (linkedEntry == null) {
            com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<T> linkedEntry2 = new com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<>(null, i, new java.util.LinkedList(), null);
            this.mMap.put(i, linkedEntry2);
            linkedEntry = linkedEntry2;
        }
        linkedEntry.value.addLast(t);
        moveToFront(linkedEntry);
    }

    synchronized int valueCount() {
        int size;
        size = 0;
        for (com.facebook.imagepipeline.memory.BucketMap.LinkedEntry linkedEntry = this.mHead; linkedEntry != null; linkedEntry = linkedEntry.next) {
            if (linkedEntry.value != null) {
                size += linkedEntry.value.size();
            }
        }
        return size;
    }

    private synchronized void prune(com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<T> linkedEntry) {
        com.facebook.imagepipeline.memory.BucketMap.LinkedEntry linkedEntry2 = (com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<T>) linkedEntry.prev;
        com.facebook.imagepipeline.memory.BucketMap.LinkedEntry linkedEntry3 = (com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<T>) linkedEntry.next;
        if (linkedEntry2 != null) {
            linkedEntry2.next = linkedEntry3;
        }
        if (linkedEntry3 != null) {
            linkedEntry3.prev = linkedEntry2;
        }
        linkedEntry.prev = null;
        linkedEntry.next = null;
        if (linkedEntry == this.mHead) {
            this.mHead = linkedEntry3;
        }
        if (linkedEntry == this.mTail) {
            this.mTail = linkedEntry2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void moveToFront(com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<T> linkedEntry) {
        if (this.mHead == linkedEntry) {
            return;
        }
        prune(linkedEntry);
        com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<T> linkedEntry2 = this.mHead;
        if (linkedEntry2 == 0) {
            this.mHead = linkedEntry;
            this.mTail = linkedEntry;
        } else {
            linkedEntry.next = linkedEntry2;
            this.mHead.prev = linkedEntry;
            this.mHead = linkedEntry;
        }
    }

    @javax.annotation.Nullable
    public synchronized T removeFromEnd() {
        com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<T> linkedEntry = this.mTail;
        if (linkedEntry == null) {
            return null;
        }
        T tPollLast = linkedEntry.value.pollLast();
        maybePrune(linkedEntry);
        return tPollLast;
    }

    private void maybePrune(com.facebook.imagepipeline.memory.BucketMap.LinkedEntry<T> linkedEntry) {
        if (linkedEntry == null || !linkedEntry.value.isEmpty()) {
            return;
        }
        prune(linkedEntry);
        this.mMap.remove(linkedEntry.key);
    }
}
