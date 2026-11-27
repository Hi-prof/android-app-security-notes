package master.flame.danmaku.danmaku.model.objectpool;

/* JADX INFO: loaded from: classes2.dex */
class FinitePool<T extends master.flame.danmaku.danmaku.model.objectpool.Poolable<T>> implements master.flame.danmaku.danmaku.model.objectpool.Pool<T> {
    private final boolean mInfinite;
    private final int mLimit;
    private final master.flame.danmaku.danmaku.model.objectpool.PoolableManager<T> mManager;
    private int mPoolCount;
    private T mRoot;

    FinitePool(master.flame.danmaku.danmaku.model.objectpool.PoolableManager<T> poolableManager) {
        this.mManager = poolableManager;
        this.mLimit = 0;
        this.mInfinite = true;
    }

    FinitePool(master.flame.danmaku.danmaku.model.objectpool.PoolableManager<T> poolableManager, int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("The pool limit must be > 0");
        }
        this.mManager = poolableManager;
        this.mLimit = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.Pool
    public T acquire() {
        T t = this.mRoot;
        if (t != null) {
            this.mRoot = (T) t.getNextPoolable();
            this.mPoolCount--;
        } else {
            t = (T) this.mManager.newInstance();
        }
        if (t != null) {
            t.setNextPoolable(null);
            t.setPooled(false);
            this.mManager.onAcquired(t);
        }
        return t;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.Pool
    public void release(T t) {
        if (!t.isPooled()) {
            if (this.mInfinite || this.mPoolCount < this.mLimit) {
                this.mPoolCount++;
                t.setNextPoolable(this.mRoot);
                t.setPooled(true);
                this.mRoot = t;
            }
            this.mManager.onReleased(t);
            return;
        }
        java.lang.System.out.print("[FinitePool] Element is already in pool: " + t);
    }
}
