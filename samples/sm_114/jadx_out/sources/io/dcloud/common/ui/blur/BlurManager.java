package io.dcloud.common.ui.blur;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class BlurManager {
    private static io.dcloud.common.ui.blur.BlurManager sInstance;
    private io.dcloud.common.ui.blur.NativeBlurProcess nativeBlurProcess;

    private BlurManager() {
        if (this.nativeBlurProcess == null) {
            this.nativeBlurProcess = new io.dcloud.common.ui.blur.NativeBlurProcess();
        }
    }

    public static io.dcloud.common.ui.blur.BlurManager getInstance() {
        if (sInstance == null) {
            sInstance = new io.dcloud.common.ui.blur.BlurManager();
        }
        return sInstance;
    }

    public android.graphics.Bitmap processNatively(android.graphics.Bitmap bitmap, int i, boolean z) {
        if (this.nativeBlurProcess == null) {
            this.nativeBlurProcess = new io.dcloud.common.ui.blur.NativeBlurProcess();
        }
        if (bitmap == null) {
            return null;
        }
        return this.nativeBlurProcess.blur(bitmap, i, z);
    }
}
