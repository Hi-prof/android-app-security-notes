package master.flame.danmaku.danmaku.loader.android;

/* JADX INFO: loaded from: classes2.dex */
public class BiliDanmakuLoader implements master.flame.danmaku.danmaku.loader.ILoader {
    private static master.flame.danmaku.danmaku.loader.android.BiliDanmakuLoader _instance;
    private master.flame.danmaku.danmaku.parser.android.AndroidFileSource dataSource;

    private BiliDanmakuLoader() {
    }

    public static master.flame.danmaku.danmaku.loader.android.BiliDanmakuLoader instance() {
        if (_instance == null) {
            _instance = new master.flame.danmaku.danmaku.loader.android.BiliDanmakuLoader();
        }
        return _instance;
    }

    @Override // master.flame.danmaku.danmaku.loader.ILoader
    public void load(java.lang.String str) throws master.flame.danmaku.danmaku.loader.IllegalDataException {
        try {
            this.dataSource = new master.flame.danmaku.danmaku.parser.android.AndroidFileSource(str);
        } catch (java.lang.Exception e) {
            throw new master.flame.danmaku.danmaku.loader.IllegalDataException(e);
        }
    }

    @Override // master.flame.danmaku.danmaku.loader.ILoader
    public void load(java.io.InputStream inputStream) {
        this.dataSource = new master.flame.danmaku.danmaku.parser.android.AndroidFileSource(inputStream);
    }

    @Override // master.flame.danmaku.danmaku.loader.ILoader
    public master.flame.danmaku.danmaku.parser.android.AndroidFileSource getDataSource() {
        return this.dataSource;
    }
}
