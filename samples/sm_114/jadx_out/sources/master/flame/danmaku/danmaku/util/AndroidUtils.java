package master.flame.danmaku.danmaku.util;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidUtils {
    public static int getMemoryClass(android.content.Context context) {
        return ((android.app.ActivityManager) context.getSystemService("activity")).getMemoryClass();
    }
}
