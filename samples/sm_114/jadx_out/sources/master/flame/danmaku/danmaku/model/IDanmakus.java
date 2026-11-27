package master.flame.danmaku.danmaku.model;

/* JADX INFO: loaded from: classes2.dex */
public interface IDanmakus {
    boolean addItem(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku);

    void clear();

    boolean contains(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku);

    master.flame.danmaku.danmaku.model.BaseDanmaku first();

    boolean isEmpty();

    master.flame.danmaku.danmaku.model.IDanmakuIterator iterator();

    master.flame.danmaku.danmaku.model.BaseDanmaku last();

    boolean removeItem(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku);

    void setSubItemsDuplicateMergingEnabled(boolean z);

    int size();

    master.flame.danmaku.danmaku.model.IDanmakus sub(long j, long j2);

    master.flame.danmaku.danmaku.model.IDanmakus subnew(long j, long j2);
}
