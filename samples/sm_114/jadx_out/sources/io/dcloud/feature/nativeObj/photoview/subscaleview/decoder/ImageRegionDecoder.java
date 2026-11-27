package io.dcloud.feature.nativeObj.photoview.subscaleview.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public interface ImageRegionDecoder {
    android.graphics.Bitmap decodeRegion(android.graphics.Rect rect, int i);

    android.graphics.Point init(android.content.Context context, android.net.Uri uri) throws java.lang.Exception;

    boolean isReady();

    void recycle();
}
