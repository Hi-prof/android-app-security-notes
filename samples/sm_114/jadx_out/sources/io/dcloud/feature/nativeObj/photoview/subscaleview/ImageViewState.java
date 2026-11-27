package io.dcloud.feature.nativeObj.photoview.subscaleview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ImageViewState implements java.io.Serializable {
    private final float centerX;
    private final float centerY;
    private final int orientation;
    private final float scale;

    public ImageViewState(float f, android.graphics.PointF pointF, int i) {
        this.scale = f;
        this.centerX = pointF.x;
        this.centerY = pointF.y;
        this.orientation = i;
    }

    public android.graphics.PointF getCenter() {
        return new android.graphics.PointF(this.centerX, this.centerY);
    }

    public int getOrientation() {
        return this.orientation;
    }

    public float getScale() {
        return this.scale;
    }
}
