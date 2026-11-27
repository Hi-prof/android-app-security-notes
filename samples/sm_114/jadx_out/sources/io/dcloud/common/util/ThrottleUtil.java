package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ThrottleUtil {
    private final android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
    private java.lang.Runnable readyToRun;

    public void throttlePost(final java.lang.Runnable runnable, long j) {
        java.lang.Runnable runnable2 = this.readyToRun;
        if (runnable2 != null) {
            this.handler.removeCallbacks(runnable2);
        }
        java.lang.Runnable runnable3 = new java.lang.Runnable() { // from class: io.dcloud.common.util.ThrottleUtil.1
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        };
        this.readyToRun = runnable3;
        this.handler.postDelayed(runnable3, j);
    }
}
