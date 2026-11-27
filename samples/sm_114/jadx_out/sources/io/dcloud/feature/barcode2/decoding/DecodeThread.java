package io.dcloud.feature.barcode2.decoding;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
final class DecodeThread extends java.lang.Thread {
    public static final java.lang.String BARCODE_BITMAP = "barcode_bitmap";
    private final io.dcloud.feature.barcode2.decoding.IBarHandler activity;
    private android.os.Handler handler;
    private final java.util.concurrent.CountDownLatch handlerInitLatch = new java.util.concurrent.CountDownLatch(1);
    private final java.util.Hashtable<com.dcloud.zxing2.DecodeHintType, java.lang.Object> hints;

    DecodeThread(io.dcloud.feature.barcode2.decoding.IBarHandler iBarHandler, java.util.Vector<com.dcloud.zxing2.BarcodeFormat> vector, java.lang.String str, com.dcloud.zxing2.ResultPointCallback resultPointCallback, boolean z) {
        this.activity = iBarHandler;
        java.util.Hashtable<com.dcloud.zxing2.DecodeHintType, java.lang.Object> hashtable = new java.util.Hashtable<>(3);
        this.hints = hashtable;
        if (vector == null || vector.isEmpty()) {
            vector = new java.util.Vector<>();
            vector.addAll(io.dcloud.feature.barcode2.decoding.DecodeFormatManager.ONE_D_FORMATS);
            vector.addAll(io.dcloud.feature.barcode2.decoding.DecodeFormatManager.QR_CODE_FORMATS);
            vector.addAll(io.dcloud.feature.barcode2.decoding.DecodeFormatManager.DATA_MATRIX_FORMATS);
        }
        hashtable.put(com.dcloud.zxing2.DecodeHintType.POSSIBLE_FORMATS, vector);
        if (str != null) {
            hashtable.put(com.dcloud.zxing2.DecodeHintType.CHARACTER_SET, str);
        }
        if (z) {
            hashtable.put(com.dcloud.zxing2.DecodeHintType.autoDecodeCharset, java.lang.Boolean.TRUE);
        }
        hashtable.put(com.dcloud.zxing2.DecodeHintType.NEED_RESULT_POINT_CALLBACK, resultPointCallback);
        hashtable.put(com.dcloud.zxing2.DecodeHintType.TRY_HARDER, new java.lang.Object());
    }

    android.os.Handler getHandler() {
        try {
            this.handlerInitLatch.await();
        } catch (java.lang.InterruptedException unused) {
        }
        return this.handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        android.os.Looper.prepare();
        this.handler = new io.dcloud.feature.barcode2.decoding.DecodeHandler(this.activity, this.hints);
        this.handlerInitLatch.countDown();
        android.os.Looper.loop();
    }
}
