package io.dcloud.feature.barcode2.decoding;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public final class InactivityTimer {
    private static final int INACTIVITY_DELAY_SECONDS = 300;
    private final android.app.Activity activity;
    private final java.util.concurrent.ScheduledExecutorService inactivityTimer = java.util.concurrent.Executors.newSingleThreadScheduledExecutor(new io.dcloud.feature.barcode2.decoding.InactivityTimer.DaemonThreadFactory());
    private java.util.concurrent.ScheduledFuture<?> inactivityFuture = null;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static final class DaemonThreadFactory implements java.util.concurrent.ThreadFactory {
        private DaemonThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    }

    public InactivityTimer(android.app.Activity activity) {
        this.activity = activity;
        onActivity();
    }

    private void cancel() {
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.inactivityFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.inactivityFuture = null;
        }
    }

    public void onActivity() {
        cancel();
        this.inactivityFuture = this.inactivityTimer.schedule(new io.dcloud.feature.barcode2.decoding.FinishListener(this.activity), 300L, java.util.concurrent.TimeUnit.SECONDS);
    }

    public void shutdown() {
        cancel();
        this.inactivityTimer.shutdown();
    }
}
