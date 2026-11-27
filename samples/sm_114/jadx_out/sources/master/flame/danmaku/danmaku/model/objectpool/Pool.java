package master.flame.danmaku.danmaku.model.objectpool;

/* JADX INFO: loaded from: classes2.dex */
public interface Pool<T extends master.flame.danmaku.danmaku.model.objectpool.Poolable<T>> {
    T acquire();

    void release(T t);
}
