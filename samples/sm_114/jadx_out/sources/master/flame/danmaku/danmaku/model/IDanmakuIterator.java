package master.flame.danmaku.danmaku.model;

/* JADX INFO: loaded from: classes2.dex */
public interface IDanmakuIterator {
    boolean hasNext();

    master.flame.danmaku.danmaku.model.BaseDanmaku next();

    void remove();

    void reset();
}
