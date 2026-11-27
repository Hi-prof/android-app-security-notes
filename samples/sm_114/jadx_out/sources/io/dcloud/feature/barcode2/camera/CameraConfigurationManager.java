package io.dcloud.feature.barcode2.camera;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
final class CameraConfigurationManager {
    private static final java.util.regex.Pattern COMMA_PATTERN = java.util.regex.Pattern.compile(",");
    private static final int DESIRED_SHARPNESS = 30;
    private static final java.lang.String TAG = "CameraConfigurationManager";
    private static final int TEN_DESIRED_ZOOM = 27;
    private android.graphics.Point cameraResolution;
    private final android.content.Context context;
    private android.hardware.Camera.Parameters parameters;
    private int previewFormat;
    private java.lang.String previewFormatString;

    CameraConfigurationManager(android.content.Context context) {
        this.context = context;
    }

    private static int findBestMotZoomValue(java.lang.CharSequence charSequence, int i) {
        int i2 = 0;
        for (java.lang.String str : COMMA_PATTERN.split(charSequence)) {
            try {
                double d = java.lang.Double.parseDouble(str.trim());
                int i3 = (int) (10.0d * d);
                if (java.lang.Math.abs(((double) i) - d) < java.lang.Math.abs(i - i2)) {
                    i2 = i3;
                }
            } catch (java.lang.NumberFormatException unused) {
                return i;
            }
        }
        return i2;
    }

    private static android.graphics.Point findBestPreviewSizeValue(java.lang.CharSequence charSequence, android.graphics.Point point) {
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        int i3 = 0;
        for (java.lang.String str : COMMA_PATTERN.split(charSequence)) {
            java.lang.String strTrim = str.trim();
            int iIndexOf = strTrim.indexOf(120);
            if (iIndexOf < 0) {
                android.util.Log.w(TAG, "Bad preview-size: " + strTrim);
            } else {
                try {
                    int i4 = java.lang.Integer.parseInt(strTrim.substring(0, iIndexOf));
                    int i5 = java.lang.Integer.parseInt(strTrim.substring(iIndexOf + 1));
                    if (i4 >= i5) {
                        int iAbs = java.lang.Math.abs(i4 - point.x) + java.lang.Math.abs(i5 - point.y);
                        if (iAbs == 0) {
                            i3 = i5;
                            i2 = i4;
                            break;
                        }
                        if (iAbs < i) {
                            i3 = i5;
                            i = iAbs;
                            i2 = i4;
                        }
                    } else {
                        continue;
                    }
                } catch (java.lang.NumberFormatException unused) {
                    android.util.Log.w(TAG, "Bad preview-size: " + strTrim);
                }
            }
        }
        if (i2 <= 0 || i3 <= 0) {
            return null;
        }
        return new android.graphics.Point(i2, i3);
    }

    private static android.graphics.Point findBestPreviewSizeValue0(java.lang.CharSequence charSequence, android.graphics.Point point) {
        java.lang.String[] strArrSplit = COMMA_PATTERN.split(charSequence);
        int i = 0;
        byte b = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < strArrSplit.length) {
            java.lang.String strTrim = ((b == 0 || b == 1) ? strArrSplit[i] : strArrSplit[(strArrSplit.length - 1) - i]).trim();
            int iIndexOf = strTrim.indexOf(120);
            if (iIndexOf < 0) {
                android.util.Log.w(TAG, "Bad preview-size: " + strTrim);
            } else {
                try {
                    int i4 = java.lang.Integer.parseInt(strTrim.substring(0, iIndexOf));
                    i3 = java.lang.Integer.parseInt(strTrim.substring(iIndexOf + 1));
                    if (b != 0) {
                        if (i2 > 0 && i4 <= point.y && i3 <= point.x) {
                            i2 = i4;
                            break;
                        }
                    } else if (i2 != 0) {
                        i = -1;
                        b = i4 > i2 ? (byte) -1 : (byte) 1;
                        i2 = 0;
                        i3 = 0;
                    }
                    i2 = i4;
                } catch (java.lang.NumberFormatException unused) {
                    android.util.Log.w(TAG, "Bad preview-size: " + strTrim);
                }
            }
            i++;
        }
        if (i2 <= 0 || i3 <= 0) {
            return null;
        }
        return new android.graphics.Point(i2, i3);
    }

    private void setFlash(android.hardware.Camera.Parameters parameters) {
        if (android.os.Build.MODEL.contains("Behold II") && io.dcloud.feature.barcode2.camera.CameraManager.SDK_INT == 3) {
            parameters.set("flash-value", 1);
        } else {
            parameters.set("flash-value", 2);
        }
        parameters.set("flash-mode", kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF);
    }

    private void setSharpness(android.hardware.Camera.Parameters parameters) {
        java.lang.String str = parameters.get("sharpness-max");
        int i = 30;
        if (str != null) {
            try {
                int i2 = java.lang.Integer.parseInt(str);
                if (30 > i2) {
                    i = i2;
                }
            } catch (java.lang.NumberFormatException unused) {
                android.util.Log.w(TAG, "Bad sharpness-max: " + str);
            }
        }
        parameters.set("sharpness", i);
    }

    private void setZoom(android.hardware.Camera.Parameters parameters) {
        java.lang.String str = parameters.get("zoom-supported");
        if (str == null || java.lang.Boolean.parseBoolean(str)) {
            java.lang.String str2 = parameters.get("max-zoom");
            int iFindBestMotZoomValue = 27;
            if (str2 != null) {
                try {
                    int i = (int) (java.lang.Double.parseDouble(str2) * 10.0d);
                    if (27 > i) {
                        iFindBestMotZoomValue = i;
                    }
                } catch (java.lang.NumberFormatException unused) {
                    android.util.Log.w(TAG, "Bad max-zoom: " + str2);
                }
            }
            java.lang.String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    int i2 = java.lang.Integer.parseInt(str3);
                    if (iFindBestMotZoomValue > i2) {
                        iFindBestMotZoomValue = i2;
                    }
                } catch (java.lang.NumberFormatException unused2) {
                    android.util.Log.w(TAG, "Bad taking-picture-zoom-max: " + str3);
                }
            }
            java.lang.String str4 = parameters.get("mot-zoom-values");
            if (str4 != null) {
                iFindBestMotZoomValue = findBestMotZoomValue(str4, iFindBestMotZoomValue);
            }
            java.lang.String str5 = parameters.get("mot-zoom-step");
            if (str5 != null) {
                try {
                    int i3 = (int) (java.lang.Double.parseDouble(str5.trim()) * 10.0d);
                    if (i3 > 1) {
                        iFindBestMotZoomValue -= iFindBestMotZoomValue % i3;
                    }
                } catch (java.lang.NumberFormatException unused3) {
                }
            }
            if (str2 != null || str4 != null) {
                parameters.set("zoom", java.lang.String.valueOf(((double) iFindBestMotZoomValue) / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", iFindBestMotZoomValue);
            }
        }
    }

    android.graphics.Point getCameraResolution() {
        return this.cameraResolution;
    }

    int getPreviewFormat() {
        return this.previewFormat;
    }

    java.lang.String getPreviewFormatString() {
        return this.previewFormatString;
    }

    void initFromCameraParameters(android.hardware.Camera camera) {
        if (this.parameters == null) {
            this.parameters = camera.getParameters();
        }
        this.previewFormat = this.parameters.getPreviewFormat();
        this.previewFormatString = this.parameters.get("preview-format");
        android.util.Log.d(TAG, "Default preview format: " + this.previewFormat + '/' + this.previewFormatString);
        android.graphics.Rect rect = io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().gatherRect;
        int iWidth = rect.width();
        int iHeight = rect.height();
        if (this.context.getResources().getConfiguration().orientation == 1) {
            this.cameraResolution = getCameraResolution(this.parameters, new android.graphics.Point(iHeight, iWidth));
        } else {
            this.cameraResolution = getCameraResolution(this.parameters, new android.graphics.Point(iWidth, iHeight));
        }
    }

    void setDesiredCameraParameters(android.hardware.Camera camera) {
        if (this.parameters == null) {
            this.parameters = camera.getParameters();
        }
        android.util.Log.d(TAG, "Setting preview size: " + this.cameraResolution);
        android.hardware.Camera.Parameters parameters = this.parameters;
        android.graphics.Point point = this.cameraResolution;
        parameters.setPreviewSize(point.x, point.y);
        setFlash(this.parameters);
        setZoom(this.parameters);
        try {
            camera.setParameters(this.parameters);
        } catch (java.lang.Exception unused) {
        }
    }

    public static android.graphics.Point getCameraResolution(android.hardware.Camera.Parameters parameters, android.graphics.Point point) {
        android.graphics.Point pointFindBestPreviewSizeValue;
        java.lang.String str = parameters.get("preview-size-values");
        if (str == null) {
            str = parameters.get("preview-size-value");
        }
        if (str != null) {
            io.dcloud.common.adapter.util.Logger.i(TAG, "preview-size-values parameter: " + str);
            pointFindBestPreviewSizeValue = findBestPreviewSizeValue(str, point);
        } else {
            pointFindBestPreviewSizeValue = null;
        }
        return pointFindBestPreviewSizeValue == null ? new android.graphics.Point((point.x >> 3) << 3, (point.y >> 3) << 3) : pointFindBestPreviewSizeValue;
    }
}
