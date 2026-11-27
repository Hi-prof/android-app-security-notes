package io.dcloud.common.ui.blur;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class BlurNativeLib {
    static {
        java.lang.System.loadLibrary("dcblur");
    }

    public static native void blurBitmap(android.graphics.Bitmap bitmap, int i, int i2, int i3, int i4);
}
