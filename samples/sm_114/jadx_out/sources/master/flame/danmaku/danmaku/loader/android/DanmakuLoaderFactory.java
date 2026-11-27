package master.flame.danmaku.danmaku.loader.android;

/* JADX INFO: loaded from: classes2.dex */
public class DanmakuLoaderFactory {
    public static java.lang.String TAG_ACFUN = "acfun";
    public static java.lang.String TAG_BILI = "bili";

    public static master.flame.danmaku.danmaku.loader.ILoader create(java.lang.String str) {
        if (TAG_BILI.equalsIgnoreCase(str)) {
            return master.flame.danmaku.danmaku.loader.android.BiliDanmakuLoader.instance();
        }
        if (TAG_ACFUN.equalsIgnoreCase(str)) {
            return master.flame.danmaku.danmaku.loader.android.AcFunDanmakuLoader.instance();
        }
        return null;
    }
}
