package io.dcloud.common.ui.blur;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class NativeBlurProcess {
    final java.util.concurrent.ExecutorService EXECUTOR;
    final int EXECUTOR_THREADS;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class NativeTask implements java.util.concurrent.Callable<java.lang.Void> {
        private final android.graphics.Bitmap _bitmapOut;
        private final int _coreIndex;
        private final int _radius;
        private final int _round;
        private final int _totalCores;

        public NativeTask(android.graphics.Bitmap bitmap, int i, int i2, int i3, int i4) {
            this._bitmapOut = bitmap;
            this._radius = i;
            this._totalCores = i2;
            this._coreIndex = i3;
            this._round = i4;
        }

        @Override // java.util.concurrent.Callable
        public java.lang.Void call() throws java.lang.Exception {
            io.dcloud.common.ui.blur.BlurNativeLib.blurBitmap(this._bitmapOut, this._radius, this._totalCores, this._coreIndex, this._round);
            return null;
        }
    }

    public NativeBlurProcess() {
        int iAvailableProcessors = java.lang.Runtime.getRuntime().availableProcessors();
        this.EXECUTOR_THREADS = iAvailableProcessors;
        this.EXECUTOR = java.util.concurrent.Executors.newFixedThreadPool(iAvailableProcessors);
    }

    public android.graphics.Bitmap blur(android.graphics.Bitmap bitmap, float f, boolean z) {
        if (z) {
            bitmap = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        }
        android.graphics.Bitmap bitmap2 = bitmap;
        int i = this.EXECUTOR_THREADS;
        java.util.ArrayList arrayList = new java.util.ArrayList(i);
        java.util.ArrayList arrayList2 = new java.util.ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (int) f;
            arrayList.add(new io.dcloud.common.ui.blur.NativeBlurProcess.NativeTask(bitmap2, i3, i, i2, 1));
            arrayList2.add(new io.dcloud.common.ui.blur.NativeBlurProcess.NativeTask(bitmap2, i3, i, i2, 2));
        }
        try {
            this.EXECUTOR.invokeAll(arrayList);
            this.EXECUTOR.invokeAll(arrayList2);
        } catch (java.lang.InterruptedException unused) {
        }
        return bitmap2;
    }
}
