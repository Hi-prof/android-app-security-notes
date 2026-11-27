package io.dcloud.feature.barcode2.camera;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
final class PreviewCallback implements android.hardware.Camera.PreviewCallback {
    private static final java.lang.String TAG = "PreviewCallback";
    private static boolean mIsVerticalScreen = true;
    private final io.dcloud.feature.barcode2.camera.CameraConfigurationManager configManager;
    private byte[] lastBitmapData = null;
    private io.dcloud.feature.barcode2.decoding.IBarHandler mBarHandler;
    private android.os.Handler previewHandler;
    private int previewMessage;
    private final boolean useOneShotPreviewCallback;

    PreviewCallback(io.dcloud.feature.barcode2.camera.CameraConfigurationManager cameraConfigurationManager, boolean z) {
        this.configManager = cameraConfigurationManager;
        this.useOneShotPreviewCallback = z;
    }

    public byte[] getLastBitmapData() {
        return this.lastBitmapData;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, android.hardware.Camera camera) {
        android.os.Message messageObtainMessage;
        io.dcloud.feature.barcode2.decoding.IBarHandler iBarHandler = this.mBarHandler;
        if (iBarHandler == null || !iBarHandler.isRunning()) {
            return;
        }
        android.graphics.Point cameraResolution = this.configManager.getCameraResolution();
        if (!this.useOneShotPreviewCallback) {
            camera.setPreviewCallback(null);
        }
        android.os.Handler handler = this.previewHandler;
        if (handler != null) {
            int i = this.previewMessage;
            if (i == 1004) {
                messageObtainMessage = mIsVerticalScreen ? handler.obtainMessage(io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.CODE_DECODE_portrait, cameraResolution.x, cameraResolution.y, bArr) : handler.obtainMessage(1006, cameraResolution.x, cameraResolution.y, bArr);
            } else {
                messageObtainMessage = handler.obtainMessage(i, cameraResolution.x, cameraResolution.y, bArr);
            }
            messageObtainMessage.sendToTarget();
            this.previewHandler = null;
        } else {
            android.util.Log.d(TAG, "Got preview callback, but no handler for it");
        }
        this.lastBitmapData = bArr;
    }

    void setHandler(io.dcloud.feature.barcode2.decoding.IBarHandler iBarHandler, android.os.Handler handler, int i, boolean z) {
        this.mBarHandler = iBarHandler;
        this.previewHandler = handler;
        this.previewMessage = i;
        mIsVerticalScreen = z;
    }

    public void setLastBitmapData(byte[] bArr) {
        this.lastBitmapData = bArr;
    }
}
