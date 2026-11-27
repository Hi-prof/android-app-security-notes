package io.dcloud.feature.audio.recorder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class RecorderUtil {
    private static android.content.Context context;
    private static boolean isDebug;
    private static android.os.Handler mainHandler;

    public static android.content.Context getContext() {
        return context;
    }

    static android.os.Handler getMainHandler() {
        if (mainHandler == null) {
            mainHandler = new android.os.Handler(android.os.Looper.getMainLooper());
        }
        return mainHandler;
    }

    public static void init(android.content.Context context2, boolean z) {
        context = context2;
        isDebug = z;
        mainHandler = getMainHandler();
    }

    public static boolean isContainMp3() {
        return io.dcloud.common.adapter.util.PlatformUtil.checkClass("io.dcloud.feature.audio.mp3.mp3Impl");
    }

    static boolean isDebug() {
        return isDebug;
    }

    static void postTaskSafely(java.lang.Runnable runnable) {
        getMainHandler().post(runnable);
    }

    static void showDebugToast(final java.lang.String str) {
        if (isDebug) {
            getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.feature.audio.recorder.RecorderUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    com.dcloud.android.widget.toast.ToastCompat.makeText(io.dcloud.feature.audio.recorder.RecorderUtil.context, (java.lang.CharSequence) str, 0).show();
                }
            });
        }
    }
}
