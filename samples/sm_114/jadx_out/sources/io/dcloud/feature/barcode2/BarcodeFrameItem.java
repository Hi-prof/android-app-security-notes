package io.dcloud.feature.barcode2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
class BarcodeFrameItem extends io.dcloud.common.adapter.ui.AdaFrameItem implements android.view.TextureView.SurfaceTextureListener, io.dcloud.feature.barcode2.decoding.IBarHandler {
    static final int AZTEC = 3;
    private static final float BEEP_VOLUME = 0.8f;
    static final int CODABAR = 7;
    static final int CODE128 = 10;
    static final int CODE39 = 8;
    static final int CODE93 = 9;
    static final int DATAMATRIX = 4;
    static final int EAN13 = 1;
    static final int EAN8 = 2;
    static final int ITF = 11;
    static final int MAXICODE = 12;
    static final int PDF417 = 13;
    static final int QR = 0;
    static final int RSS14 = 14;
    static final int RSSEXPANDED = 15;
    public static final java.lang.String TAG = "BarcodeFrameItem";
    static final int UNKOWN = -1000;
    static final int UPCA = 5;
    static final int UPCE = 6;
    private static final long VIBRATE_DURATION = 200;
    static io.dcloud.feature.barcode2.BarcodeFrameItem sBarcodeFrameItem;
    public boolean autoDecodeCharset;
    private final android.media.MediaPlayer.OnCompletionListener beepListener;
    private java.lang.String characterSet;
    private java.util.Vector<com.dcloud.zxing2.BarcodeFormat> decodeFormats;
    public java.lang.String errorMsg;
    private io.dcloud.feature.barcode2.decoding.CaptureActivityHandler handler;
    private boolean hasSurface;
    private io.dcloud.feature.barcode2.decoding.InactivityTimer inactivityTimer;
    private boolean isCancelScan;
    boolean isVerticalScreen;
    private android.graphics.Bitmap lastBitmap;
    private android.content.Context mAct;
    private io.dcloud.common.DHInterface.IApp mAppHandler;
    java.util.Map<java.lang.String, java.lang.String> mCallbackIds;
    boolean mConserve;
    private io.dcloud.common.DHInterface.IWebview mContainerWebview;
    org.json.JSONArray mDivRectJson;
    java.lang.String mFilename;
    org.json.JSONArray mFilters;
    int mOrientationState;
    private java.lang.String mPosition;
    io.dcloud.feature.barcode2.BarcodeProxy mProxy;
    private boolean mRunning;
    org.json.JSONObject mStyles;
    public java.lang.String mUuid;
    private io.dcloud.common.DHInterface.IWebview mWebViewImpl;
    private android.media.MediaPlayer mediaPlayer;
    boolean noPermission;
    boolean playBeep;
    android.view.TextureView surfaceView;
    boolean vibrate;
    private io.dcloud.feature.barcode2.view.ViewfinderView viewfinderView;

    public BarcodeFrameItem(io.dcloud.feature.barcode2.BarcodeProxy barcodeProxy, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONArray jSONArray, org.json.JSONArray jSONArray2, org.json.JSONObject jSONObject) {
        super(iWebview.getContext());
        this.playBeep = true;
        this.vibrate = true;
        this.mCallbackIds = null;
        this.mRunning = false;
        this.errorMsg = null;
        this.mConserve = false;
        this.mFilename = null;
        this.noPermission = false;
        this.mPosition = "static";
        this.autoDecodeCharset = false;
        this.isVerticalScreen = true;
        this.isCancelScan = false;
        this.lastBitmap = null;
        this.beepListener = new android.media.MediaPlayer.OnCompletionListener() { // from class: io.dcloud.feature.barcode2.BarcodeFrameItem.6
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(android.media.MediaPlayer mediaPlayer) {
                mediaPlayer.seekTo(0);
            }
        };
        sBarcodeFrameItem = this;
        this.mProxy = barcodeProxy;
        this.mUuid = str;
        this.mCallbackIds = new java.util.HashMap();
        this.mAct = iWebview.getContext();
        this.mWebViewImpl = iWebview;
        this.mContainerWebview = iWebview;
        this.mAppHandler = iWebview.obtainApp();
        this.mDivRectJson = jSONArray;
        this.mStyles = jSONObject;
        this.mFilters = jSONArray2;
        final android.widget.AbsoluteLayout.LayoutParams frameLayoutParam = getFrameLayoutParam(jSONArray, jSONObject);
        android.widget.AbsoluteLayout absoluteLayout = new android.widget.AbsoluteLayout(this.mAct) { // from class: io.dcloud.feature.barcode2.BarcodeFrameItem.1
            android.graphics.Paint paint = new android.graphics.Paint();

            @Override // android.view.View
            protected void onDraw(android.graphics.Canvas canvas) {
                super.onDraw(canvas);
                if (io.dcloud.feature.barcode2.BarcodeFrameItem.this.noPermission) {
                    this.paint.setColor(-1);
                    this.paint.setTextSize(io.dcloud.common.adapter.util.CanvasHelper.dip2px(io.dcloud.feature.barcode2.BarcodeFrameItem.this.mAct, 18.0f));
                    this.paint.setTextAlign(android.graphics.Paint.Align.CENTER);
                    android.graphics.Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
                    float f = fontMetrics.top;
                    float f2 = fontMetrics.bottom;
                    android.widget.AbsoluteLayout.LayoutParams layoutParams = frameLayoutParam;
                    if (layoutParams != null) {
                        canvas.drawText(io.dcloud.application.DCLoudApplicationImpl.self().getContext().getString(io.dcloud.base.R.string.dcloud_feature_barcode2_no_camera_permission), layoutParams.width / 2, (int) (((layoutParams.height / 2) - (f / 2.0f)) - (f2 / 2.0f)), this.paint);
                    }
                }
            }
        };
        setMainView(absoluteLayout);
        if (jSONObject != null) {
            initStyles(jSONObject, absoluteLayout);
        }
        initDecodeFormats(jSONArray2);
    }

    private android.graphics.Bitmap byte2bitmap(byte[] bArr, android.hardware.Camera camera) {
        java.lang.Exception exc;
        android.graphics.Bitmap bitmap = null;
        try {
            android.hardware.Camera.Size previewSize = camera.getParameters().getPreviewSize();
            android.graphics.YuvImage yuvImage = new android.graphics.YuvImage(bArr, 17, previewSize.width, previewSize.height, null);
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            yuvImage.compressToJpeg(new android.graphics.Rect(0, 0, previewSize.width, previewSize.height), 80, byteArrayOutputStream);
            android.graphics.Bitmap bitmapDecodeByteArray = android.graphics.BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            try {
                byteArrayOutputStream.close();
                android.graphics.Matrix matrix = new android.graphics.Matrix();
                matrix.postRotate(90.0f);
                return android.graphics.Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, true);
            } catch (java.lang.Exception e) {
                exc = e;
                bitmap = bitmapDecodeByteArray;
                exc.printStackTrace();
                return bitmap;
            }
        } catch (java.lang.Exception e2) {
            exc = e2;
        }
    }

    private com.dcloud.zxing2.BarcodeFormat convertNumToBarcodeFormat(int i) {
        switch (i) {
            case 0:
                return com.dcloud.zxing2.BarcodeFormat.QR_CODE;
            case 1:
                return com.dcloud.zxing2.BarcodeFormat.EAN_13;
            case 2:
                return com.dcloud.zxing2.BarcodeFormat.EAN_8;
            case 3:
                return com.dcloud.zxing2.BarcodeFormat.AZTEC;
            case 4:
                return com.dcloud.zxing2.BarcodeFormat.DATA_MATRIX;
            case 5:
                return com.dcloud.zxing2.BarcodeFormat.UPC_A;
            case 6:
                return com.dcloud.zxing2.BarcodeFormat.UPC_E;
            case 7:
                return com.dcloud.zxing2.BarcodeFormat.CODABAR;
            case 8:
                return com.dcloud.zxing2.BarcodeFormat.CODE_39;
            case 9:
                return com.dcloud.zxing2.BarcodeFormat.CODE_93;
            case 10:
                return com.dcloud.zxing2.BarcodeFormat.CODE_128;
            case 11:
                return com.dcloud.zxing2.BarcodeFormat.ITF;
            case 12:
                return com.dcloud.zxing2.BarcodeFormat.MAXICODE;
            case 13:
                return com.dcloud.zxing2.BarcodeFormat.PDF_417;
            case 14:
                return com.dcloud.zxing2.BarcodeFormat.RSS_14;
            case 15:
                return com.dcloud.zxing2.BarcodeFormat.RSS_EXPANDED;
            default:
                return null;
        }
    }

    static int convertTypestrToNum(com.dcloud.zxing2.BarcodeFormat barcodeFormat) {
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.QR_CODE) {
            return 0;
        }
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.EAN_13) {
            return 1;
        }
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.EAN_8) {
            return 2;
        }
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.AZTEC) {
            return 3;
        }
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.DATA_MATRIX) {
            return 4;
        }
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.UPC_A) {
            return 5;
        }
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.UPC_E) {
            return 6;
        }
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.CODABAR) {
            return 7;
        }
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.CODE_39) {
            return 8;
        }
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.CODE_93) {
            return 9;
        }
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.CODE_128) {
            return 10;
        }
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.ITF) {
            return 11;
        }
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.MAXICODE) {
            return 12;
        }
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.PDF_417) {
            return 13;
        }
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.RSS_14) {
            return 14;
        }
        return barcodeFormat == com.dcloud.zxing2.BarcodeFormat.RSS_EXPANDED ? 15 : -1000;
    }

    private android.widget.AbsoluteLayout.LayoutParams getFrameLayoutParam(org.json.JSONArray jSONArray, org.json.JSONObject jSONObject) {
        float scale = this.mContainerWebview.getScale();
        if (jSONArray.length() > 3) {
            android.graphics.Rect rect = io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().gatherRect;
            rect.left = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONArray, 0), 0);
            rect.top = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONArray, 1), 0);
            rect.right = rect.left + io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONArray, 2), 0);
            int i = rect.top + io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONArray, 3), 0);
            rect.left = (int) (rect.left * scale);
            rect.top = (int) (rect.top * scale);
            rect.right = (int) (rect.right * scale);
            rect.bottom = (int) (i * scale);
            if (rect.width() == 0 || rect.height() == 0) {
                return null;
            }
            return (android.widget.AbsoluteLayout.LayoutParams) io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.createLayoutParams(rect.left, rect.top, rect.width(), rect.height());
        }
        if (jSONObject == null) {
            return null;
        }
        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = (io.dcloud.common.adapter.ui.AdaFrameView) this.mContainerWebview.obtainFrameView();
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = adaFrameView.obtainFrameOptions();
        int height = this.mPosition.equals(io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE) ? viewOptionsObtainFrameOptions.height : 0;
        if (height == 0 && (height = ((android.view.ViewGroup) adaFrameView.obtainWebviewParent().obtainMainView()).getHeight()) == 0) {
            height = viewOptionsObtainFrameOptions.height;
        }
        int width = viewOptionsObtainFrameOptions.width;
        if (width == 0) {
            width = ((android.view.ViewGroup) adaFrameView.obtainWebviewParent().obtainMainView()).getWidth();
        }
        int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObject, "left"), width, 0, scale);
        int iConvertToScreenInt2 = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObject, "top"), height, 0, scale);
        int iConvertToScreenInt3 = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObject, "width"), width, width, scale);
        int iConvertToScreenInt4 = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObject, "height"), height, height, scale);
        android.graphics.Rect rect2 = io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().gatherRect;
        rect2.left = iConvertToScreenInt;
        rect2.top = iConvertToScreenInt2;
        rect2.right = iConvertToScreenInt + iConvertToScreenInt3;
        rect2.bottom = iConvertToScreenInt2 + iConvertToScreenInt4;
        if (rect2.width() == 0 || rect2.height() == 0) {
            return null;
        }
        return (android.widget.AbsoluteLayout.LayoutParams) io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.createLayoutParams(rect2.left, rect2.top, rect2.width(), rect2.height());
    }

    private void initBeepSound() {
        if (this.mediaPlayer == null) {
            getActivity().setVolumeControlStream(3);
            android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.mediaPlayer.setOnCompletionListener(this.beepListener);
            try {
                android.content.res.AssetFileDescriptor assetFileDescriptorOpenFd = this.mAct.getResources().getAssets().openFd(io.dcloud.common.constant.AbsoluteConst.RES_BEEP);
                this.mediaPlayer.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                assetFileDescriptorOpenFd.close();
                this.mediaPlayer.setVolume(BEEP_VOLUME, BEEP_VOLUME);
                this.mediaPlayer.prepare();
            } catch (java.io.IOException unused) {
                this.mediaPlayer = null;
            }
        }
    }

    private void initCamera(android.graphics.SurfaceTexture surfaceTexture) {
        try {
            io.dcloud.feature.barcode2.camera.CameraManager.get().openDriver(surfaceTexture);
            io.dcloud.feature.barcode2.decoding.CaptureActivityHandler captureActivityHandler = this.handler;
            if (captureActivityHandler != null) {
                captureActivityHandler.resume();
                return;
            }
            io.dcloud.feature.barcode2.decoding.CaptureActivityHandler captureActivityHandler2 = new io.dcloud.feature.barcode2.decoding.CaptureActivityHandler(this, this.decodeFormats, this.characterSet, this.autoDecodeCharset);
            this.handler = captureActivityHandler2;
            if (this.mRunning) {
                captureActivityHandler2.restartPreviewAndDecode();
            }
        } catch (java.io.IOException e) {
            this.errorMsg = e.getMessage();
        } catch (java.lang.RuntimeException e2) {
            this.errorMsg = e2.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCameraView(android.widget.AbsoluteLayout.LayoutParams layoutParams, android.widget.AbsoluteLayout absoluteLayout) {
        io.dcloud.feature.barcode2.camera.CameraManager.init(getActivity().getApplication(), this.mAppHandler.isVerticalScreen());
        io.dcloud.feature.barcode2.camera.CameraManager.sScreenWidth = this.mAppHandler.getInt(0);
        io.dcloud.feature.barcode2.camera.CameraManager.sScreenAllHeight = this.mAppHandler.getInt(2);
        if (getActivity().getResources().getConfiguration().orientation == 1) {
            initPortraitCameraView(layoutParams, absoluteLayout);
        } else {
            initLandScapeCameraView(layoutParams, absoluteLayout);
        }
    }

    private void initDecodeFormats(org.json.JSONArray jSONArray) {
        int i;
        this.decodeFormats = new java.util.Vector<>();
        if (jSONArray == null || jSONArray.length() == 0) {
            this.decodeFormats.add(com.dcloud.zxing2.BarcodeFormat.EAN_13);
            this.decodeFormats.add(com.dcloud.zxing2.BarcodeFormat.EAN_8);
            this.decodeFormats.add(com.dcloud.zxing2.BarcodeFormat.QR_CODE);
            return;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                i = jSONArray.getInt(i2);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                i = -1;
            }
            if (i != -1) {
                this.decodeFormats.add(convertNumToBarcodeFormat(i));
            }
        }
    }

    private void initLandScapeCameraView(android.widget.AbsoluteLayout.LayoutParams layoutParams, final android.widget.AbsoluteLayout absoluteLayout) {
        int i;
        int i2;
        android.graphics.Rect rect = io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().gatherRect;
        android.graphics.Point cr = io.dcloud.feature.barcode2.camera.CameraManager.getCR(rect.width(), rect.height());
        if (cr == null) {
            this.noPermission = true;
            io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.feature.barcode2.BarcodeFrameItem.4
                @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
                public void execute(java.lang.Object obj) {
                    absoluteLayout.setBackgroundColor(-16777216);
                    absoluteLayout.invalidate();
                }
            }, null);
            return;
        }
        int i3 = layoutParams.height;
        int i4 = cr.x;
        int i5 = cr.y;
        int i6 = (i3 * i4) / i5;
        int i7 = layoutParams.width;
        if (i6 < i7) {
            int i8 = (i5 * i7) / i4;
            int i9 = (i3 - i8) / 2;
            io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestTop = i9;
            io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestLeft = 0;
            i3 = i8;
            i2 = i9;
            i6 = i7;
            i = 0;
        } else {
            i = (i7 - i6) / 2;
            io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestLeft = i;
            io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestTop = 0;
            i2 = 0;
        }
        this.surfaceView.setClickable(false);
        absoluteLayout.addView(this.surfaceView, new android.widget.AbsoluteLayout.LayoutParams(i6, i3, i, i2));
        io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().initSurfaceViewRect(i, i2, i6, i3);
        absoluteLayout.addView(this.viewfinderView);
    }

    private void initPortraitCameraView(android.widget.AbsoluteLayout.LayoutParams layoutParams, final android.widget.AbsoluteLayout absoluteLayout) {
        int i;
        int i2;
        android.graphics.Rect rect = io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().gatherRect;
        android.graphics.Point cr = io.dcloud.feature.barcode2.camera.CameraManager.getCR(rect.height(), rect.width());
        if (cr == null) {
            this.noPermission = true;
            io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.feature.barcode2.BarcodeFrameItem.3
                @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
                public void execute(java.lang.Object obj) {
                    absoluteLayout.setBackgroundColor(-16777216);
                    absoluteLayout.invalidate();
                }
            }, null);
            return;
        }
        int i3 = layoutParams.width;
        int i4 = cr.x;
        int i5 = cr.y;
        int i6 = (i3 * i4) / i5;
        int i7 = layoutParams.height;
        if (i6 < i7) {
            int i8 = (i5 * i7) / i4;
            int i9 = (i3 - i8) / 2;
            io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestLeft = i9;
            io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestTop = 0;
            i3 = i8;
            i2 = i9;
            i6 = i7;
            i = 0;
        } else {
            i = (i7 - i6) / 2;
            io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestTop = i;
            io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestLeft = 0;
            i2 = 0;
        }
        this.surfaceView.setClickable(false);
        absoluteLayout.addView(this.surfaceView, new android.widget.AbsoluteLayout.LayoutParams(i3, i6, i2, i));
        io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().initSurfaceViewRect(i2, i, i3, i6);
        absoluteLayout.addView(this.viewfinderView);
    }

    private void initStyles(org.json.JSONObject jSONObject, android.view.View view) {
        this.mStyles = jSONObject;
        io.dcloud.feature.barcode2.view.DetectorViewConfig.laserColor = -65536;
        io.dcloud.feature.barcode2.view.DetectorViewConfig.cornerColor = -65536;
        if (jSONObject.has("position")) {
            this.mPosition = jSONObject.optString("position");
        }
        if (!android.text.TextUtils.isEmpty(jSONObject.optString("scanbarColor"))) {
            int iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(jSONObject.optString("scanbarColor"));
            if (iStringToColor == -1) {
                iStringToColor = io.dcloud.feature.barcode2.view.DetectorViewConfig.laserColor;
            }
            io.dcloud.feature.barcode2.view.DetectorViewConfig.laserColor = iStringToColor;
        }
        if (!android.text.TextUtils.isEmpty(jSONObject.optString("frameColor"))) {
            int iStringToColor2 = io.dcloud.common.util.PdrUtil.stringToColor(jSONObject.optString("frameColor"));
            if (iStringToColor2 == -1) {
                iStringToColor2 = io.dcloud.feature.barcode2.view.DetectorViewConfig.laserColor;
            }
            io.dcloud.feature.barcode2.view.DetectorViewConfig.cornerColor = iStringToColor2;
        }
        if (!android.text.TextUtils.isEmpty(jSONObject.optString("background"))) {
            int iStringToColor3 = io.dcloud.common.util.PdrUtil.stringToColor(jSONObject.optString("background"));
            if (iStringToColor3 == -1) {
                iStringToColor3 = io.dcloud.feature.barcode2.view.DetectorViewConfig.laserColor;
            }
            view.setBackgroundColor(iStringToColor3);
        }
        if (jSONObject.has("autoZoom")) {
            io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.isAutoZoom = jSONObject.optBoolean("autoZoom", true);
        }
    }

    private void listenHideAndShow(io.dcloud.common.DHInterface.IWebview iWebview) {
        iWebview.obtainFrameView().addFrameViewListener(new io.dcloud.common.DHInterface.IEventCallback() { // from class: io.dcloud.feature.barcode2.BarcodeFrameItem.5
            @Override // io.dcloud.common.DHInterface.IEventCallback
            public java.lang.Object onCallBack(java.lang.String str, java.lang.Object obj) {
                if (io.dcloud.common.util.PdrUtil.isEquals(str, "hide") || io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_WINDOW_CLOSE)) {
                    io.dcloud.feature.barcode2.BarcodeFrameItem.this.onPause();
                    return null;
                }
                if (!io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_SHOW_ANIMATION_END)) {
                    return null;
                }
                io.dcloud.feature.barcode2.BarcodeFrameItem.this.onResume(true);
                return null;
            }
        });
    }

    private void playBeepSoundAndVibrate() {
        android.media.MediaPlayer mediaPlayer;
        if (this.playBeep && (mediaPlayer = this.mediaPlayer) != null) {
            mediaPlayer.start();
        }
        if (this.vibrate) {
            try {
                ((android.os.Vibrator) this.mAct.getSystemService("vibrator")).vibrate(VIBRATE_DURATION);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void resumeOrientationState() {
        this.mAppHandler.setRequestedOrientation(this.mOrientationState);
    }

    private void saveOrientationState() {
        this.mOrientationState = this.mAppHandler.getRequestedOrientation();
    }

    public void addCallBackId(java.lang.String str, java.lang.String str2) {
        if (this.mCallbackIds.containsKey(str)) {
            return;
        }
        this.mCallbackIds.put(str, str2);
    }

    public void appendToFrameView(io.dcloud.common.adapter.ui.AdaFrameView adaFrameView) {
        if (obtainMainView() != null && obtainMainView().getParent() != null) {
            removeMapFrameItem(this.mContainerWebview);
        }
        this.mContainerWebview = adaFrameView.obtainWebView();
        toFrameView();
    }

    @Override // io.dcloud.feature.barcode2.decoding.IBarHandler
    public void autoFocus() {
        this.handler.autoFocus();
    }

    protected void cancel() {
        if (this.mRunning) {
            io.dcloud.feature.barcode2.decoding.CaptureActivityHandler captureActivityHandler = this.handler;
            if (captureActivityHandler != null) {
                captureActivityHandler.stopDecode();
            }
            getViewfinderView().stopUpdateScreenTimer();
            this.mRunning = false;
        }
    }

    protected void cancel_scan() {
        if (this.mRunning) {
            io.dcloud.feature.barcode2.decoding.CaptureActivityHandler captureActivityHandler = this.handler;
            if (captureActivityHandler != null) {
                captureActivityHandler.quitSynchronously();
                this.handler = null;
            }
            getViewfinderView().stopUpdateScreenTimer();
            io.dcloud.feature.barcode2.camera.CameraManager.get().removeAutoFocus();
            io.dcloud.feature.barcode2.camera.CameraManager.get().stopPreview();
            byte[] lastBitmapData = io.dcloud.feature.barcode2.camera.CameraManager.get().getLastBitmapData();
            android.hardware.Camera cameraHandler = io.dcloud.feature.barcode2.camera.CameraManager.get().getCameraHandler();
            if (lastBitmapData != null && cameraHandler != null) {
                this.lastBitmap = byte2bitmap(lastBitmapData, cameraHandler);
            }
            io.dcloud.feature.barcode2.camera.CameraManager.get().closeDriver();
            this.mRunning = false;
            this.isCancelScan = true;
        }
    }

    protected void close_scan() {
        dispose();
        setMainView(null);
        java.lang.System.gc();
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameItem
    public void dispose() {
        super.dispose();
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.DHInterface.IFeature.F_BARCODE, "dispose");
        onPause();
        io.dcloud.feature.barcode2.view.DetectorViewConfig.clearData();
        this.mProxy.mBarcodeView = null;
        this.surfaceView = null;
        android.graphics.Bitmap bitmap = this.lastBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.lastBitmap.recycle();
            this.lastBitmap = null;
        }
        io.dcloud.feature.barcode2.camera.CameraManager.get().clearLastBitmapData();
        resumeOrientationState();
        io.dcloud.feature.barcode2.BarcodeProxyMgr.getBarcodeProxyMgr().removeBarcodeProxy(this.mUuid);
    }

    @Override // io.dcloud.feature.barcode2.decoding.IBarHandler
    public void drawViewfinder() {
        this.viewfinderView.drawViewfinder();
    }

    @Override // io.dcloud.feature.barcode2.decoding.IBarHandler
    public android.os.Handler getHandler() {
        return this.handler;
    }

    public org.json.JSONObject getJsBarcode() {
        if (obtainMainView() == null) {
            return null;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            jSONObject.put("filters", this.mFilters);
            jSONObject.put("options", this.mStyles);
            jSONObject.put("autoDecodeCharset", this.autoDecodeCharset);
            return jSONObject;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    @Override // io.dcloud.feature.barcode2.decoding.IBarHandler
    public io.dcloud.feature.barcode2.view.ViewfinderView getViewfinderView() {
        return this.viewfinderView;
    }

    @Override // io.dcloud.feature.barcode2.decoding.IBarHandler
    public void handleDecode(com.dcloud.zxing2.Result result, android.graphics.Bitmap bitmap) {
        java.lang.String str;
        this.inactivityTimer.onActivity();
        playBeepSoundAndVibrate();
        boolean zSaveBitmapToFile = this.mConserve ? io.dcloud.common.util.PdrUtil.saveBitmapToFile(bitmap, this.mFilename) : false;
        int iConvertTypestrToNum = convertTypestrToNum(result.getBarcodeFormat());
        if (zSaveBitmapToFile) {
            java.lang.String strObtainAppDocPath = this.mWebViewImpl.obtainFrameView().obtainApp().obtainAppDocPath();
            io.dcloud.common.adapter.util.Logger.d("doc:" + strObtainAppDocPath);
            if (this.mFilename.startsWith(strObtainAppDocPath)) {
                this.mFilename = io.dcloud.common.util.BaseInfo.REL_PRIVATE_DOC_DIR + this.mFilename.substring(strObtainAppDocPath.length() - 1);
            }
            java.lang.String strConvert2RelPath = this.mWebViewImpl.obtainFrameView().obtainApp().convert2RelPath(this.mFilename);
            io.dcloud.common.adapter.util.Logger.d("Filename:" + this.mFilename + ";relPath:" + strConvert2RelPath);
            str = io.dcloud.common.util.StringUtil.format("{type:%d,message:%s,file:'%s',charSet:'%s'}", java.lang.Integer.valueOf(iConvertTypestrToNum), io.dcloud.common.util.JSONUtil.toJSONableString(result.getText()), strConvert2RelPath, result.textCharset);
        } else {
            str = io.dcloud.common.util.StringUtil.format("{type:%d,message:%s,charSet:'%s'}", java.lang.Integer.valueOf(iConvertTypestrToNum), io.dcloud.common.util.JSONUtil.toJSONableString(result.getText()), result.textCharset);
        }
        runJsCallBack(str, io.dcloud.common.util.JSUtil.OK, true, true);
        cancel();
    }

    @Override // io.dcloud.feature.barcode2.decoding.IBarHandler
    public boolean isRunning() {
        return this.mRunning;
    }

    protected void onDestroy() {
        this.inactivityTimer.shutdown();
        this.hasSurface = false;
        this.decodeFormats = null;
        this.characterSet = null;
        this.mCallbackIds.clear();
    }

    protected void onPause() {
        io.dcloud.feature.barcode2.decoding.CaptureActivityHandler captureActivityHandler = this.handler;
        if (captureActivityHandler != null) {
            captureActivityHandler.quitSynchronously();
            this.handler = null;
        }
        if (!this.noPermission) {
            io.dcloud.feature.barcode2.camera.CameraManager.get().closeDriver();
        }
        boolean z = this.mRunning;
        cancel();
        this.mRunning = z;
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameItem
    public void onPopFromStack(boolean z) {
        super.onPopFromStack(z);
        if (z) {
            onPause();
        }
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameItem
    public void onPushToStack(boolean z) {
        super.onPushToStack(z);
        if (z) {
            onResume(false);
        }
    }

    protected void onResume(boolean z) {
        android.graphics.SurfaceTexture surfaceTexture = this.surfaceView.getSurfaceTexture();
        if (this.lastBitmap != null && this.isCancelScan && z) {
            this.surfaceView.setBackground(new android.graphics.drawable.BitmapDrawable(this.mAct.getResources(), this.lastBitmap));
        }
        if (this.hasSurface) {
            initCamera(surfaceTexture);
        } else {
            this.surfaceView.setSurfaceTextureListener(this);
        }
        if (((android.media.AudioManager) this.mAct.getSystemService("audio")).getRingerMode() != 2) {
            this.playBeep = false;
        }
        initBeepSound();
        if (z && this.mRunning) {
            this.mRunning = false;
            start();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.hasSurface) {
            return;
        }
        this.hasSurface = true;
        if (this.isCancelScan) {
            return;
        }
        try {
            initCamera(surfaceTexture);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        this.hasSurface = false;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
    }

    public void removeMapFrameItem(io.dcloud.common.DHInterface.IWebview iWebview) {
        if (this.mPosition.equals(io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE)) {
            iWebview.obtainFrameView().removeFrameItem(this);
        } else {
            iWebview.removeFrameItem(this);
        }
    }

    public void runJsCallBack(java.lang.String str, int i, boolean z, boolean z2) {
        for (java.lang.String str2 : this.mCallbackIds.keySet()) {
            io.dcloud.common.DHInterface.IWebview iWebviewFindWebviewByUuid = io.dcloud.feature.barcode2.BarcodeProxyMgr.getBarcodeProxyMgr().findWebviewByUuid(this.mWebViewImpl, this.mCallbackIds.get(str2));
            if (iWebviewFindWebviewByUuid != null) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebviewFindWebviewByUuid, str2, str, i, z, z2);
            }
        }
    }

    public void setFlash(boolean z) {
        io.dcloud.feature.barcode2.camera.CameraManager.get().setFlashlight(z);
    }

    protected void start() {
        if (this.mRunning) {
            return;
        }
        getViewfinderView().startUpdateScreenTimer();
        io.dcloud.feature.barcode2.decoding.CaptureActivityHandler captureActivityHandler = this.handler;
        if (captureActivityHandler != null) {
            captureActivityHandler.restartPreviewAndDecode();
        } else {
            onResume(false);
        }
        if (this.isCancelScan) {
            this.surfaceView.setBackground(null);
            android.graphics.Bitmap bitmap = this.lastBitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.lastBitmap.recycle();
                this.lastBitmap = null;
            }
            io.dcloud.feature.barcode2.camera.CameraManager.get().clearLastBitmapData();
            this.surfaceView.postInvalidate();
            initCamera(this.surfaceView.getSurfaceTexture());
        }
        this.mRunning = true;
        this.isCancelScan = false;
    }

    public void toFrameView() {
        final android.widget.AbsoluteLayout absoluteLayout = (android.widget.AbsoluteLayout) obtainMainView();
        final android.widget.AbsoluteLayout.LayoutParams frameLayoutParam = getFrameLayoutParam(this.mDivRectJson, this.mStyles);
        if (frameLayoutParam == null) {
            return;
        }
        this.surfaceView = new android.view.TextureView(this.mAct);
        this.viewfinderView = new io.dcloud.feature.barcode2.view.ViewfinderView(this.mAct, this);
        this.hasSurface = false;
        this.inactivityTimer = new io.dcloud.feature.barcode2.decoding.InactivityTimer(getActivity());
        io.dcloud.common.adapter.util.PermissionUtil.usePermission(this.mContainerWebview.getActivity(), "barcode", io.dcloud.common.adapter.util.PermissionUtil.PMS_CAMERA, 2, new io.dcloud.common.adapter.util.PermissionUtil.StreamPermissionRequest(this.mContainerWebview.obtainApp()) { // from class: io.dcloud.feature.barcode2.BarcodeFrameItem.2
            @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
            public void onDenied(java.lang.String str) {
                io.dcloud.feature.barcode2.BarcodeFrameItem.this.noPermission = true;
                io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.feature.barcode2.BarcodeFrameItem.2.1
                    @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
                    public void execute(java.lang.Object obj) {
                        absoluteLayout.setBackgroundColor(-16777216);
                        absoluteLayout.invalidate();
                    }
                }, null);
            }

            @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
            public void onGranted(java.lang.String str) {
                io.dcloud.feature.barcode2.BarcodeFrameItem.this.initCameraView(frameLayoutParam, absoluteLayout);
            }
        });
        onResume(false);
        saveOrientationState();
        boolean zIsVerticalScreen = this.mAppHandler.isVerticalScreen();
        this.isVerticalScreen = zIsVerticalScreen;
        if (zIsVerticalScreen) {
            this.mAppHandler.setRequestedOrientation("portrait");
        } else {
            this.mAppHandler.setRequestedOrientation("landscape");
        }
        listenHideAndShow(this.mContainerWebview);
        if (this.mPosition.equals(io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE)) {
            this.mContainerWebview.obtainFrameView().addFrameItem(this, frameLayoutParam);
        } else {
            this.mContainerWebview.addFrameItem(this, frameLayoutParam);
        }
    }

    public void upateStyles(org.json.JSONObject jSONObject) {
        android.widget.AbsoluteLayout.LayoutParams frameLayoutParam;
        io.dcloud.common.util.JSONUtil.combinJSONObject(this.mStyles, jSONObject);
        if ((jSONObject.has("top") || jSONObject.has("left") || jSONObject.has("width") || jSONObject.has("height") || jSONObject.has("position")) && (frameLayoutParam = getFrameLayoutParam(this.mDivRectJson, this.mStyles)) != null) {
            if (!jSONObject.has("position")) {
                obtainMainView().setLayoutParams(frameLayoutParam);
                return;
            }
            java.lang.String strOptString = jSONObject.optString("position");
            if (strOptString.equals(this.mPosition)) {
                return;
            }
            if (this.mPosition.equals(io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE)) {
                this.mContainerWebview.obtainFrameView().removeFrameItem(this);
                this.mContainerWebview.addFrameItem(this, frameLayoutParam);
            } else {
                this.mContainerWebview.removeFrameItem(this);
                this.mContainerWebview.obtainFrameView().addFrameItem(this, frameLayoutParam);
            }
            this.mPosition = strOptString;
        }
    }
}
