package io.dcloud.feature.barcode2.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DetectorViewConfig implements io.dcloud.common.DHInterface.IReflectAble {
    public static int CORNER_HEIGHT = 40;
    public static int CORNER_WIDTH = 8;
    public static final int F_CORNER_COLOR = -65536;
    public static final int F_LASER_COLOR = -65536;
    public static int LASER_WIDTH = 8;
    private static final int MAX_FRAME_HEIGHT = 360;
    private static final int MAX_FRAME_WIDTH = 640;
    private static final int MIN_FRAME_HEIGHT = 240;
    private static final int MIN_FRAME_WIDTH = 240;
    public static int cornerColor = -65536;
    public static int detectorRectOffestLeft = 0;
    public static int detectorRectOffestTop = 0;
    private static io.dcloud.feature.barcode2.view.DetectorViewConfig instance = null;
    public static int laserColor = -65536;
    public static int maskColor = 1610612736;
    public static int resultPointColor = -1056964864;
    public android.graphics.Rect surfaceViewRect = null;
    public android.graphics.Rect gatherRect = new android.graphics.Rect();
    private android.graphics.Rect detectorRect = null;
    private boolean retry = false;

    private DetectorViewConfig() {
    }

    public static void clearData() {
        instance = null;
    }

    public static io.dcloud.feature.barcode2.view.DetectorViewConfig getInstance() {
        if (instance == null) {
            instance = new io.dcloud.feature.barcode2.view.DetectorViewConfig();
        }
        return instance;
    }

    public android.graphics.Rect getDetectorRect() {
        if (this.retry || this.detectorRect == null) {
            int iWidth = this.gatherRect.width();
            int iHeight = this.gatherRect.height();
            int i = ((iWidth < iHeight ? iWidth : iHeight) * 6) / 10;
            this.retry = i < 0;
            if (i < 240) {
                i = org.mozilla.universalchardet.prober.HebrewProber.NORMAL_NUN;
            } else if (i > MAX_FRAME_WIDTH) {
                i = MAX_FRAME_WIDTH;
            }
            CORNER_HEIGHT = (i * 10) / 100;
            int i2 = (iWidth - i) / 2;
            int i3 = (iHeight - i) / 2;
            this.detectorRect = new android.graphics.Rect(i2, i3, i2 + i, i + i3);
        }
        return this.detectorRect;
    }

    public void initSurfaceViewRect(int i, int i2, int i3, int i4) {
        this.surfaceViewRect = new android.graphics.Rect(i, i2, i3 + i, i4 + i2);
    }
}
