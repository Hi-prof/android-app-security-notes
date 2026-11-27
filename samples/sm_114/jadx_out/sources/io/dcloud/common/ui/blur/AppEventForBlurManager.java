package io.dcloud.common.ui.blur;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AppEventForBlurManager {
    private static final java.lang.String TAG = "AppScrollManager";
    private static java.util.ArrayList<io.dcloud.common.ui.blur.AppEventForBlurManager.OnAppChangedCallBack> callBacks = new java.util.ArrayList<>();
    public static final boolean isBlur = true;
    private static boolean mLoop = false;
    private static long sLastChangedTime = 0;
    private static boolean sScrollStart = false;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface OnAppChangedCallBack {
        void onContentScrollEnd();

        void onContentScrollStart();

        void onSplashclosed();
    }

    public static synchronized void addEventChangedCallBack(io.dcloud.common.ui.blur.AppEventForBlurManager.OnAppChangedCallBack onAppChangedCallBack) {
        if (callBacks.contains(onAppChangedCallBack)) {
            return;
        }
        callBacks.add(onAppChangedCallBack);
    }

    public static void onScrollChanged(int i, int i2) {
        sScrollStart = true;
        sLastChangedTime = java.lang.System.currentTimeMillis();
        if (!mLoop) {
            onScrollStart();
        }
        startLoop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onScrollEnd() {
        io.dcloud.common.adapter.util.MessageHandler.post(new java.lang.Runnable() { // from class: io.dcloud.common.ui.blur.AppEventForBlurManager.3
            @Override // java.lang.Runnable
            public void run() {
                java.util.ArrayList arrayList = io.dcloud.common.ui.blur.AppEventForBlurManager.callBacks;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    java.lang.Object obj = arrayList.get(i);
                    i++;
                    ((io.dcloud.common.ui.blur.AppEventForBlurManager.OnAppChangedCallBack) obj).onContentScrollEnd();
                }
            }
        });
    }

    private static void onScrollStart() {
        io.dcloud.common.adapter.util.MessageHandler.post(new java.lang.Runnable() { // from class: io.dcloud.common.ui.blur.AppEventForBlurManager.2
            @Override // java.lang.Runnable
            public void run() {
                java.util.ArrayList arrayList = io.dcloud.common.ui.blur.AppEventForBlurManager.callBacks;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    java.lang.Object obj = arrayList.get(i);
                    i++;
                    ((io.dcloud.common.ui.blur.AppEventForBlurManager.OnAppChangedCallBack) obj).onContentScrollStart();
                }
            }
        });
    }

    public static void onSplashclosed() {
        io.dcloud.common.adapter.util.MessageHandler.post(new java.lang.Runnable() { // from class: io.dcloud.common.ui.blur.AppEventForBlurManager.4
            @Override // java.lang.Runnable
            public void run() {
                java.util.ArrayList arrayList = io.dcloud.common.ui.blur.AppEventForBlurManager.callBacks;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    java.lang.Object obj = arrayList.get(i);
                    i++;
                    ((io.dcloud.common.ui.blur.AppEventForBlurManager.OnAppChangedCallBack) obj).onSplashclosed();
                }
            }
        });
    }

    public static synchronized void removeEventChangedCallBack(io.dcloud.common.ui.blur.AppEventForBlurManager.OnAppChangedCallBack onAppChangedCallBack) {
        if (callBacks.contains(onAppChangedCallBack)) {
            callBacks.remove(onAppChangedCallBack);
        }
    }

    private static void startLoop() {
        if (mLoop) {
            return;
        }
        mLoop = true;
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.common.ui.blur.AppEventForBlurManager.1
            @Override // java.lang.Runnable
            public void run() {
                while (io.dcloud.common.ui.blur.AppEventForBlurManager.sScrollStart) {
                    boolean unused = io.dcloud.common.ui.blur.AppEventForBlurManager.mLoop = true;
                    if (java.lang.System.currentTimeMillis() - io.dcloud.common.ui.blur.AppEventForBlurManager.sLastChangedTime > 500) {
                        boolean unused2 = io.dcloud.common.ui.blur.AppEventForBlurManager.sScrollStart = false;
                        boolean unused3 = io.dcloud.common.ui.blur.AppEventForBlurManager.mLoop = false;
                        long unused4 = io.dcloud.common.ui.blur.AppEventForBlurManager.sLastChangedTime = 0L;
                        io.dcloud.common.ui.blur.AppEventForBlurManager.onScrollEnd();
                    } else {
                        try {
                            java.lang.Thread.sleep(200L);
                        } catch (java.lang.InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, true);
    }
}
