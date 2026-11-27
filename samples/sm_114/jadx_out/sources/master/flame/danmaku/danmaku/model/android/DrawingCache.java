package master.flame.danmaku.danmaku.model.android;

/* JADX INFO: loaded from: classes2.dex */
public class DrawingCache implements master.flame.danmaku.danmaku.model.IDrawingCache<master.flame.danmaku.danmaku.model.android.DrawingCacheHolder>, master.flame.danmaku.danmaku.model.objectpool.Poolable<master.flame.danmaku.danmaku.model.android.DrawingCache> {
    private boolean mIsPooled;
    private master.flame.danmaku.danmaku.model.android.DrawingCache mNextElement;
    private int mSize = 0;
    private int referenceCount = 0;
    private final master.flame.danmaku.danmaku.model.android.DrawingCacheHolder mHolder = new master.flame.danmaku.danmaku.model.android.DrawingCacheHolder();

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    public void build(int i, int i2, int i3, boolean z) {
        this.mHolder.buildCache(i, i2, i3, z);
        this.mSize = this.mHolder.bitmap.getRowBytes() * this.mHolder.bitmap.getHeight();
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    public void erase() {
        this.mHolder.erase();
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    public master.flame.danmaku.danmaku.model.android.DrawingCacheHolder get() {
        if (this.mHolder.bitmap == null) {
            return null;
        }
        return this.mHolder;
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    public void destroy() {
        master.flame.danmaku.danmaku.model.android.DrawingCacheHolder drawingCacheHolder = this.mHolder;
        if (drawingCacheHolder != null) {
            drawingCacheHolder.recycle();
        }
        this.mSize = 0;
        this.referenceCount = 0;
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.Poolable
    public void setNextPoolable(master.flame.danmaku.danmaku.model.android.DrawingCache drawingCache) {
        this.mNextElement = drawingCache;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.Poolable
    public master.flame.danmaku.danmaku.model.android.DrawingCache getNextPoolable() {
        return this.mNextElement;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.Poolable
    public boolean isPooled() {
        return this.mIsPooled;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.Poolable
    public void setPooled(boolean z) {
        this.mIsPooled = z;
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    public synchronized boolean hasReferences() {
        return this.referenceCount > 0;
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    public synchronized void increaseReference() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    public synchronized void decreaseReference() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    public int width() {
        return this.mHolder.width;
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    public int height() {
        return this.mHolder.height;
    }
}
