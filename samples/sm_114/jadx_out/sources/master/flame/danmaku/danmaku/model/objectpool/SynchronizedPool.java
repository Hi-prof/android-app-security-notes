package master.flame.danmaku.danmaku.model.objectpool;

/* JADX INFO: loaded from: classes2.dex */
class SynchronizedPool<T extends master.flame.danmaku.danmaku.model.objectpool.Poolable<T>> implements master.flame.danmaku.danmaku.model.objectpool.Pool<T> {
    private final java.lang.Object mLock;
    private final master.flame.danmaku.danmaku.model.objectpool.Pool<T> mPool;

    public SynchronizedPool(master.flame.danmaku.danmaku.model.objectpool.Pool<T> pool) {
        this.mPool = pool;
        this.mLock = this;
    }

    public SynchronizedPool(master.flame.danmaku.danmaku.model.objectpool.Pool<T> pool, java.lang.Object obj) {
        this.mPool = pool;
        this.mLock = obj;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.Pool
    public T acquire() {
        T t;
        synchronized (this.mLock) {
            t = (T) this.mPool.acquire();
        }
        return t;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.Pool
    public void release(T t) {
        synchronized (this.mLock) {
            this.mPool.release(t);
        }
    }
}
