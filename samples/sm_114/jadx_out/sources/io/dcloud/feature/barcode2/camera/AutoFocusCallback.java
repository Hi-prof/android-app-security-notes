package io.dcloud.feature.barcode2.camera;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
final class AutoFocusCallback implements android.hardware.Camera.AutoFocusCallback {
    private static final long AUTOFOCUS_INTERVAL_MS = 200;
    private static final java.lang.String TAG = "AutoFocusCallback";
    private android.os.Handler autoFocusHandler;
    private int autoFocusMessage;

    AutoFocusCallback() {
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z, android.hardware.Camera camera) {
        android.os.Handler handler = this.autoFocusHandler;
        if (handler == null) {
            android.util.Log.d(TAG, "Got auto-focus callback, but no handler for it");
            return;
        }
        this.autoFocusHandler.sendMessageDelayed(handler.obtainMessage(this.autoFocusMessage, java.lang.Boolean.valueOf(z)), AUTOFOCUS_INTERVAL_MS);
        this.autoFocusHandler = null;
    }

    void setHandler(android.os.Handler handler, int i) {
        this.autoFocusHandler = handler;
        this.autoFocusMessage = i;
    }
}
