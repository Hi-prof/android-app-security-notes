package master.flame.danmaku.danmaku.model.objectpool;

/* JADX INFO: loaded from: classes2.dex */
public class Pools {
    private Pools() {
    }

    public static <T extends master.flame.danmaku.danmaku.model.objectpool.Poolable<T>> master.flame.danmaku.danmaku.model.objectpool.Pool<T> simplePool(master.flame.danmaku.danmaku.model.objectpool.PoolableManager<T> poolableManager) {
        return new master.flame.danmaku.danmaku.model.objectpool.FinitePool(poolableManager);
    }

    public static <T extends master.flame.danmaku.danmaku.model.objectpool.Poolable<T>> master.flame.danmaku.danmaku.model.objectpool.Pool<T> finitePool(master.flame.danmaku.danmaku.model.objectpool.PoolableManager<T> poolableManager, int i) {
        return new master.flame.danmaku.danmaku.model.objectpool.FinitePool(poolableManager, i);
    }

    public static <T extends master.flame.danmaku.danmaku.model.objectpool.Poolable<T>> master.flame.danmaku.danmaku.model.objectpool.Pool<T> synchronizedPool(master.flame.danmaku.danmaku.model.objectpool.Pool<T> pool) {
        return new master.flame.danmaku.danmaku.model.objectpool.SynchronizedPool(pool);
    }

    public static <T extends master.flame.danmaku.danmaku.model.objectpool.Poolable<T>> master.flame.danmaku.danmaku.model.objectpool.Pool<T> synchronizedPool(master.flame.danmaku.danmaku.model.objectpool.Pool<T> pool, java.lang.Object obj) {
        return new master.flame.danmaku.danmaku.model.objectpool.SynchronizedPool(pool, obj);
    }
}
