package master.flame.danmaku.danmaku.loader.android;

/* JADX INFO: loaded from: classes2.dex */
public class AcFunDanmakuLoader implements master.flame.danmaku.danmaku.loader.ILoader {
    private static volatile master.flame.danmaku.danmaku.loader.android.AcFunDanmakuLoader instance;
    private master.flame.danmaku.danmaku.parser.android.JSONSource dataSource;

    private AcFunDanmakuLoader() {
    }

    public static master.flame.danmaku.danmaku.loader.ILoader instance() {
        if (instance == null) {
            synchronized (master.flame.danmaku.danmaku.loader.android.AcFunDanmakuLoader.class) {
                if (instance == null) {
                    instance = new master.flame.danmaku.danmaku.loader.android.AcFunDanmakuLoader();
                }
            }
        }
        return instance;
    }

    @Override // master.flame.danmaku.danmaku.loader.ILoader
    public master.flame.danmaku.danmaku.parser.android.JSONSource getDataSource() {
        return this.dataSource;
    }

    @Override // master.flame.danmaku.danmaku.loader.ILoader
    public void load(java.lang.String str) throws master.flame.danmaku.danmaku.loader.IllegalDataException {
        try {
            this.dataSource = new master.flame.danmaku.danmaku.parser.android.JSONSource(android.net.Uri.parse(str));
        } catch (java.lang.Exception e) {
            throw new master.flame.danmaku.danmaku.loader.IllegalDataException(e);
        }
    }

    @Override // master.flame.danmaku.danmaku.loader.ILoader
    public void load(java.io.InputStream inputStream) throws master.flame.danmaku.danmaku.loader.IllegalDataException {
        try {
            this.dataSource = new master.flame.danmaku.danmaku.parser.android.JSONSource(inputStream);
        } catch (java.lang.Exception e) {
            throw new master.flame.danmaku.danmaku.loader.IllegalDataException(e);
        }
    }
}
