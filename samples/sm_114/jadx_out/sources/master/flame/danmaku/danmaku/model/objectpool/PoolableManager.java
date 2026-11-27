package master.flame.danmaku.danmaku.model.objectpool;

/* JADX INFO: loaded from: classes2.dex */
public interface PoolableManager<T extends master.flame.danmaku.danmaku.model.objectpool.Poolable<T>> {
    T newInstance();

    void onAcquired(T t);

    void onReleased(T t);
}
