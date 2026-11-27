package master.flame.danmaku.controller;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateThread extends java.lang.Thread {
    volatile boolean mIsQuited;

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
    }

    public UpdateThread(java.lang.String str) {
        super(str);
    }

    public void quit() {
        this.mIsQuited = true;
    }

    public boolean isQuited() {
        return this.mIsQuited;
    }
}
