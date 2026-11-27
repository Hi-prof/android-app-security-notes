package io.dcloud.feature.barcode2.camera;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public final class CameraManager {
    private static final int MAX_FRAME_HEIGHT = 640;
    private static final int MAX_FRAME_WIDTH = 640;
    private static final int MIN_FRAME_HEIGHT = 240;
    private static final int MIN_FRAME_WIDTH = 240;
    static final int SDK_INT;
    private static final java.lang.String TAG = "CameraManager";
    private static io.dcloud.feature.barcode2.camera.CameraManager cameraManager;
    private static boolean mIsVerticalScreen;
    private static android.hardware.Camera.Parameters parameters;
    public static int sScreenAllHeight;
    public static int sScreenWidth;
    private final io.dcloud.feature.barcode2.camera.AutoFocusCallback autoFocusCallback;
    private android.hardware.Camera camera;
    private final io.dcloud.feature.barcode2.camera.CameraConfigurationManager configManager;
    private final android.content.Context context;
    private android.graphics.Rect framingRect;
    private boolean horizontalOrientation = false;
    private boolean initialized;
    private final io.dcloud.feature.barcode2.camera.PreviewCallback previewCallback;
    private boolean previewing;
    private boolean useOneShotPreviewCallback;

    static {
        int i;
        try {
            i = java.lang.Integer.parseInt(android.os.Build.VERSION.SDK);
        } catch (java.lang.NumberFormatException unused) {
            i = io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH;
        }
        SDK_INT = i;
        mIsVerticalScreen = true;
        parameters = null;
    }

    private CameraManager(android.content.Context context) {
        this.context = context;
        io.dcloud.feature.barcode2.camera.CameraConfigurationManager cameraConfigurationManager = new io.dcloud.feature.barcode2.camera.CameraConfigurationManager(context);
        this.configManager = cameraConfigurationManager;
        this.useOneShotPreviewCallback = java.lang.Integer.parseInt(android.os.Build.VERSION.SDK) > 3;
        this.previewCallback = new io.dcloud.feature.barcode2.camera.PreviewCallback(cameraConfigurationManager, this.useOneShotPreviewCallback);
        this.useOneShotPreviewCallback = false;
        this.autoFocusCallback = new io.dcloud.feature.barcode2.camera.AutoFocusCallback();
    }

    public static io.dcloud.feature.barcode2.camera.CameraManager get() {
        return cameraManager;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x004b  */
    public static android.graphics.Point getCR(int i, int i2) {
        android.hardware.Camera cameraOpen;
        android.graphics.Point cameraResolution;
        android.hardware.Camera camera = null;
        try {
            cameraOpen = android.hardware.Camera.open();
            try {
                if (parameters == null) {
                    parameters = cameraOpen.getParameters();
                }
                android.graphics.Point cameraResolution2 = io.dcloud.feature.barcode2.camera.CameraConfigurationManager.getCameraResolution(parameters, new android.graphics.Point(i, i2));
                try {
                    cameraOpen.release();
                    return cameraResolution2;
                } catch (java.lang.Exception e) {
                    cameraResolution = cameraResolution2;
                    e = e;
                    android.graphics.Point point = new android.graphics.Point(i, i2);
                    android.hardware.Camera.Parameters parameters2 = parameters;
                    if (parameters2 == null) {
                        if (cameraOpen != null) {
                            try {
                                android.hardware.Camera.Parameters parameters3 = cameraOpen.getParameters();
                                parameters = parameters3;
                                cameraResolution = io.dcloud.feature.barcode2.camera.CameraConfigurationManager.getCameraResolution(parameters3, point);
                                cameraOpen.release();
                            } catch (java.lang.Exception unused) {
                                camera = cameraOpen;
                                if (camera != null) {
                                    camera.release();
                                }
                                e.printStackTrace();
                                return cameraResolution;
                            }
                        }
                        if (camera != null) {
                            camera.release();
                        }
                        e.printStackTrace();
                        return cameraResolution;
                    }
                    cameraResolution = io.dcloud.feature.barcode2.camera.CameraConfigurationManager.getCameraResolution(parameters2, point);
                    camera = cameraOpen;
                    if (camera != null) {
                        camera.release();
                    }
                    e.printStackTrace();
                    return cameraResolution;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                cameraResolution = null;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            cameraOpen = null;
            cameraResolution = null;
        }
    }

    public static void init(android.content.Context context) {
        if (cameraManager == null) {
            cameraManager = new io.dcloud.feature.barcode2.camera.CameraManager(context);
        }
    }

    public io.dcloud.feature.barcode2.camera.PlanarYUVLuminanceSource buildLuminanceSource(byte[] bArr, int i, int i2) {
        android.graphics.Rect framingRectInPreview = getFramingRectInPreview();
        int previewFormat = this.configManager.getPreviewFormat();
        java.lang.String previewFormatString = this.configManager.getPreviewFormatString();
        if (previewFormat == 16 || previewFormat == 17) {
            return new io.dcloud.feature.barcode2.camera.PlanarYUVLuminanceSource(bArr, i, i2, framingRectInPreview.left, framingRectInPreview.top, framingRectInPreview.width(), framingRectInPreview.height());
        }
        if ("yuv420p".equals(previewFormatString)) {
            return new io.dcloud.feature.barcode2.camera.PlanarYUVLuminanceSource(bArr, i, i2, framingRectInPreview.left, framingRectInPreview.top, framingRectInPreview.width(), framingRectInPreview.height());
        }
        throw new java.lang.IllegalArgumentException("Unsupported picture format: " + previewFormat + '/' + previewFormatString);
    }

    public void clearLastBitmapData() {
        io.dcloud.feature.barcode2.camera.PreviewCallback previewCallback = this.previewCallback;
        if (previewCallback != null) {
            previewCallback.setLastBitmapData(null);
        }
    }

    public void closeDriver() {
        if (this.camera != null) {
            io.dcloud.feature.barcode2.camera.FlashlightManager.disableFlashlight();
            this.camera.setPreviewCallback(null);
            this.camera.release();
            this.camera = null;
        }
    }

    public io.dcloud.feature.barcode2.camera.AutoFocusCallback getAutoFocusCallback() {
        return this.autoFocusCallback;
    }

    public android.hardware.Camera getCameraHandler() {
        return this.camera;
    }

    public android.graphics.Rect getFramingRectInPreview() {
        return mIsVerticalScreen ? getPortraitFramingRectInPreview() : getLandscapeFramingRectInPreview();
    }

    public android.graphics.Rect getLandscapeFramingRectInPreview() {
        android.graphics.Point cameraResolution = this.configManager.getCameraResolution();
        android.graphics.Rect detectorRect = io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().getDetectorRect();
        android.graphics.Rect rect = io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().surfaceViewRect;
        int iWidth = rect.width() / cameraResolution.y;
        int iWidth2 = ((detectorRect.left - io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestLeft) * cameraResolution.x) / rect.width();
        int iHeight = ((detectorRect.height() * cameraResolution.y) / rect.height()) + iWidth2;
        int iHeight2 = ((rect.bottom - detectorRect.bottom) * cameraResolution.y) / rect.height();
        return new android.graphics.Rect(iWidth2, iHeight2, iHeight, ((detectorRect.width() * cameraResolution.y) / rect.height()) + iHeight2);
    }

    public byte[] getLastBitmapData() {
        io.dcloud.feature.barcode2.camera.PreviewCallback previewCallback = this.previewCallback;
        if (previewCallback == null) {
            return null;
        }
        return previewCallback.getLastBitmapData();
    }

    public android.graphics.Rect getPortraitFramingRectInPreview() {
        android.graphics.Point cameraResolution = this.configManager.getCameraResolution();
        android.graphics.Rect detectorRect = io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().getDetectorRect();
        android.graphics.Rect rect = io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().surfaceViewRect;
        int iWidth = rect.width() / cameraResolution.y;
        int iHeight = ((detectorRect.top - io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestTop) * cameraResolution.x) / rect.height();
        int iHeight2 = ((detectorRect.height() * cameraResolution.x) / rect.height()) + iHeight;
        int iWidth2 = ((rect.right - detectorRect.right) * cameraResolution.y) / rect.width();
        return new android.graphics.Rect(iHeight, iWidth2, iHeight2, ((detectorRect.width() * cameraResolution.x) / rect.height()) + iWidth2);
    }

    public void openDriver(android.graphics.SurfaceTexture surfaceTexture) throws java.io.IOException, java.lang.RuntimeException {
        if (this.camera == null) {
            try {
                android.hardware.Camera cameraOpen = android.hardware.Camera.open();
                this.camera = cameraOpen;
                if (cameraOpen == null) {
                    throw new java.io.IOException();
                }
                cameraOpen.setPreviewTexture(surfaceTexture);
                if (mIsVerticalScreen) {
                    this.camera.setDisplayOrientation(90);
                } else {
                    this.camera.setDisplayOrientation(this.horizontalOrientation ? 180 : 0);
                }
                this.configManager.initFromCameraParameters(this.camera);
                this.configManager.setDesiredCameraParameters(this.camera);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeAutoFocus() {
        android.hardware.Camera camera = this.camera;
        if (camera != null) {
            try {
                camera.cancelAutoFocus();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public void requestAutoFocus(android.os.Handler handler, int i) {
        if (this.camera == null || !this.previewing) {
            return;
        }
        this.autoFocusCallback.setHandler(handler, i);
        try {
            this.camera.autoFocus(this.autoFocusCallback);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void requestPreviewFrame(io.dcloud.feature.barcode2.decoding.IBarHandler iBarHandler, android.os.Handler handler, int i) {
        if (this.camera == null || !this.previewing) {
            return;
        }
        this.previewCallback.setHandler(iBarHandler, handler, i, mIsVerticalScreen);
        if (this.useOneShotPreviewCallback) {
            this.camera.setOneShotPreviewCallback(this.previewCallback);
        } else {
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    public void setFlashlight(boolean z) {
        if (z) {
            io.dcloud.feature.barcode2.camera.FlashlightManager.enableFlashlight();
        } else {
            io.dcloud.feature.barcode2.camera.FlashlightManager.disableFlashlight();
        }
    }

    public void setHorizontalOrientation(boolean z) {
        this.horizontalOrientation = z;
    }

    public void startPreview() {
        try {
            android.hardware.Camera camera = this.camera;
            if (camera == null || this.previewing) {
                return;
            }
            camera.startPreview();
            this.previewing = true;
        } catch (java.lang.Exception unused) {
        }
    }

    public void stopPreview() {
        try {
            android.hardware.Camera camera = this.camera;
            if (camera == null || !this.previewing) {
                return;
            }
            if (!this.useOneShotPreviewCallback) {
                camera.setPreviewCallback(null);
            }
            this.camera.stopPreview();
            this.previewCallback.setHandler(null, null, 0, mIsVerticalScreen);
            this.autoFocusCallback.setHandler(null, 0);
            this.previewing = false;
        } catch (java.lang.Exception unused) {
        }
    }

    public static void init(android.content.Context context, boolean z) {
        mIsVerticalScreen = z;
        init(context);
    }
}
