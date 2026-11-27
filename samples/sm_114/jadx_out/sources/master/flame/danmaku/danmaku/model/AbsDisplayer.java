package master.flame.danmaku.danmaku.model;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsDisplayer<T, F> implements master.flame.danmaku.danmaku.model.IDisplayer {
    public abstract void clearTextHeightCache();

    public abstract void drawDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, T t, float f, float f2, boolean z);

    public abstract master.flame.danmaku.danmaku.model.android.BaseCacheStuffer getCacheStuffer();

    public abstract T getExtraData();

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    public boolean isHardwareAccelerated() {
        return false;
    }

    public abstract void setCacheStuffer(master.flame.danmaku.danmaku.model.android.BaseCacheStuffer baseCacheStuffer);

    public abstract void setExtraData(T t);

    public abstract void setFakeBoldText(boolean z);

    public abstract void setScaleTextSizeFactor(float f);

    public abstract void setTransparency(int i);

    public abstract void setTypeFace(F f);
}
