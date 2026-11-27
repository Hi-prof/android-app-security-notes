package com.bumptech.glide.load.engine.cache;

/* JADX INFO: loaded from: classes.dex */
final class DiskCacheWriteLocker {
    private final java.util.Map<java.lang.String, com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock> locks = new java.util.HashMap();
    private final com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLockPool writeLockPool = new com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLockPool();

    DiskCacheWriteLocker() {
    }

    void acquire(java.lang.String str) {
        com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock writeLockObtain;
        synchronized (this) {
            writeLockObtain = this.locks.get(str);
            if (writeLockObtain == null) {
                writeLockObtain = this.writeLockPool.obtain();
                this.locks.put(str, writeLockObtain);
            }
            writeLockObtain.interestedThreads++;
        }
        writeLockObtain.lock.lock();
    }

    void release(java.lang.String str) {
        com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock writeLock;
        synchronized (this) {
            writeLock = (com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock) com.bumptech.glide.util.Preconditions.checkNotNull(this.locks.get(str));
            if (writeLock.interestedThreads < 1) {
                throw new java.lang.IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + writeLock.interestedThreads);
            }
            writeLock.interestedThreads--;
            if (writeLock.interestedThreads == 0) {
                com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock writeLockRemove = this.locks.remove(str);
                if (!writeLockRemove.equals(writeLock)) {
                    throw new java.lang.IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + writeLockRemove + ", safeKey: " + str);
                }
                this.writeLockPool.offer(writeLockRemove);
            }
        }
        writeLock.lock.unlock();
    }

    private static class WriteLock {
        int interestedThreads;
        final java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();

        WriteLock() {
        }
    }

    private static class WriteLockPool {
        private static final int MAX_POOL_SIZE = 10;
        private final java.util.Queue<com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock> pool = new java.util.ArrayDeque();

        WriteLockPool() {
        }

        com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock obtain() {
            com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock writeLockPoll;
            synchronized (this.pool) {
                writeLockPoll = this.pool.poll();
            }
            return writeLockPoll == null ? new com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock() : writeLockPoll;
        }

        void offer(com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock writeLock) {
            synchronized (this.pool) {
                if (this.pool.size() < 10) {
                    this.pool.offer(writeLock);
                }
            }
        }
    }
}
