package master.flame.danmaku.danmaku.model;

/* JADX INFO: loaded from: classes2.dex */
public class Danmaku extends master.flame.danmaku.danmaku.model.BaseDanmaku {
    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    public float getBottom() {
        return 0.0f;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    public float getLeft() {
        return 0.0f;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    public float[] getRectAtTime(master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, long j) {
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    public float getRight() {
        return 0.0f;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    public float getTop() {
        return 0.0f;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    public int getType() {
        return 0;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    public boolean isShown() {
        return false;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    public void layout(master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, float f, float f2) {
    }

    public Danmaku(java.lang.CharSequence charSequence) {
        master.flame.danmaku.danmaku.util.DanmakuUtils.fillText(this, charSequence);
    }
}
