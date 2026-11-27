package io.dcloud.feature.weex_barcode;

/* JADX INFO: loaded from: classes2.dex */
public class BarcodeView extends android.widget.AbsoluteLayout implements io.dcloud.feature.barcode2.decoding.IBarHandler, android.view.TextureView.SurfaceTextureListener {
    static final int AZTEC = 3;
    private static final float BEEP_VOLUME = 0.8f;
    static final int CODABAR = 7;
    static final int CODE128 = 10;
    static final int CODE39 = 8;
    static final int CODE93 = 9;
    static final int DATAMATRIX = 4;
    static final int EAN13 = 1;
    static final int EAN8 = 2;
    private static final int ID_ADD_VIEW = 201;
    private static final int ID_START_SCAN = 203;
    private static final int ID_UPDATE_VIEW = 202;
    static final int ITF = 11;
    static final int MAXICODE = 12;
    static final int PDF417 = 13;
    static final int QR = 0;
    static final int RSS14 = 14;
    static final int RSSEXPANDED = 15;
    static final int UNKOWN = -1000;
    static final int UPCA = 5;
    static final int UPCE = 6;
    private static final long VIBRATE_DURATION = 200;
    public boolean autoDecodeCharset;
    private final android.media.MediaPlayer.OnCompletionListener beepListener;
    private java.lang.String characterSet;
    private com.taobao.weex.ui.component.WXComponent component;
    private android.content.Context context;
    private java.util.Vector<com.dcloud.zxing2.BarcodeFormat> decodeFormats;
    public java.lang.String errorMsg;
    private io.dcloud.feature.barcode2.decoding.CaptureActivityHandler handler;
    private boolean hasSurface;
    private io.dcloud.feature.barcode2.decoding.InactivityTimer inactivityTimer;
    private boolean isCancelScan;
    private boolean isSurfaceAvaliable;
    private boolean isVerticalScreen;
    private android.graphics.Bitmap lastBiptmap;
    private boolean mConserve;
    private java.lang.String mFilename;
    android.os.Handler mHandler;
    private com.taobao.weex.WXSDKInstance mInstance;
    int mOrientationState;
    private boolean mRunning;
    private android.media.MediaPlayer mediaPlayer;
    private boolean nopermission;
    private boolean playBeep;
    private android.view.TextureView surfaceView;
    private boolean vibrate;
    private int viewHeight;
    private int viewWidth;
    private io.dcloud.feature.barcode2.view.ViewfinderView viewfinderView;

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0081  */
    public BarcodeView(android.content.Context context, com.taobao.weex.ui.component.WXComponent wXComponent, com.taobao.weex.WXSDKInstance wXSDKInstance) {
        super(context);
        this.hasSurface = false;
        this.errorMsg = null;
        this.mConserve = false;
        this.isSurfaceAvaliable = false;
        this.isVerticalScreen = false;
        this.autoDecodeCharset = false;
        this.mHandler = new android.os.Handler() { // from class: io.dcloud.feature.weex_barcode.BarcodeView.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                super.handleMessage(message);
                if (message.what == 201) {
                    android.widget.AbsoluteLayout.LayoutParams layoutParams = (android.widget.AbsoluteLayout.LayoutParams) message.obj;
                    if (io.dcloud.feature.weex_barcode.BarcodeView.this.surfaceView != null) {
                        if (io.dcloud.feature.weex_barcode.BarcodeView.this.surfaceView.getParent() != null) {
                            ((android.view.ViewGroup) io.dcloud.feature.weex_barcode.BarcodeView.this.surfaceView.getParent()).removeView(io.dcloud.feature.weex_barcode.BarcodeView.this.surfaceView);
                        }
                        io.dcloud.feature.weex_barcode.BarcodeView barcodeView = io.dcloud.feature.weex_barcode.BarcodeView.this;
                        barcodeView.addView(barcodeView.surfaceView, layoutParams);
                    }
                    io.dcloud.feature.weex_barcode.BarcodeView barcodeView2 = io.dcloud.feature.weex_barcode.BarcodeView.this;
                    barcodeView2.addView(barcodeView2.viewfinderView);
                    return;
                }
                if (message.what == io.dcloud.feature.weex_barcode.BarcodeView.ID_UPDATE_VIEW) {
                    if (io.dcloud.feature.weex_barcode.BarcodeView.this.surfaceView == null || io.dcloud.feature.weex_barcode.BarcodeView.this.surfaceView.getParent() == null) {
                        return;
                    }
                    io.dcloud.feature.weex_barcode.BarcodeView.this.surfaceView.setLayoutParams((android.widget.AbsoluteLayout.LayoutParams) message.obj);
                    io.dcloud.feature.weex_barcode.BarcodeView.this.viewfinderView.drawViewfinder();
                    return;
                }
                if (message.what != io.dcloud.feature.weex_barcode.BarcodeView.ID_START_SCAN || io.dcloud.feature.weex_barcode.BarcodeView.this.surfaceView == null || io.dcloud.feature.weex_barcode.BarcodeView.this.surfaceView.getParent() == null) {
                    return;
                }
                io.dcloud.feature.weex_barcode.BarcodeView.this.surfaceView.setLayoutParams((android.widget.AbsoluteLayout.LayoutParams) message.obj);
                io.dcloud.feature.weex_barcode.BarcodeView.this.viewfinderView.drawViewfinder();
                io.dcloud.feature.weex_barcode.BarcodeView.this.startP();
            }
        };
        this.isCancelScan = false;
        this.mRunning = false;
        this.beepListener = new android.media.MediaPlayer.OnCompletionListener() { // from class: io.dcloud.feature.weex_barcode.BarcodeView.5
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(android.media.MediaPlayer mediaPlayer) {
                mediaPlayer.seekTo(0);
            }
        };
        this.component = wXComponent;
        this.mInstance = wXSDKInstance;
        this.surfaceView = new android.view.TextureView(context);
        this.viewfinderView = new io.dcloud.feature.barcode2.view.ViewfinderView(context, this);
        android.app.Activity activity = (android.app.Activity) context;
        this.inactivityTimer = new io.dcloud.feature.barcode2.decoding.InactivityTimer(activity);
        this.context = context;
        saveOrientationState();
        io.dcloud.feature.barcode2.camera.CameraManager.init(this.context, false);
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0) {
            ((android.app.Activity) this.context).setRequestedOrientation(7);
            io.dcloud.feature.barcode2.camera.CameraManager.init(context, true);
            this.isVerticalScreen = true;
        } else if (rotation == 1) {
            io.dcloud.feature.barcode2.camera.CameraManager.get().setHorizontalOrientation(false);
            ((android.app.Activity) this.context).setRequestedOrientation(0);
        } else if (rotation == 2) {
            ((android.app.Activity) this.context).setRequestedOrientation(7);
            io.dcloud.feature.barcode2.camera.CameraManager.init(context, true);
            this.isVerticalScreen = true;
        } else if (rotation == 3) {
            io.dcloud.feature.barcode2.camera.CameraManager.get().setHorizontalOrientation(true);
            ((android.app.Activity) this.context).setRequestedOrientation(8);
        }
        onResume(false);
        this.hasSurface = false;
    }

    private void saveOrientationState() {
        this.mOrientationState = ((android.app.Activity) this.context).getRequestedOrientation();
    }

    private void resumeOrientationState() {
        ((android.app.Activity) this.context).setRequestedOrientation(this.mOrientationState);
    }

    public void initBarcodeView(int i, int i2) {
        this.viewWidth = i;
        this.viewHeight = i2;
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.feature.weex_barcode.BarcodeView.2
            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.feature.weex_barcode.BarcodeView.this.addBarcodeView();
            }
        });
    }

    public void updateStyles(int i, int i2) {
        if (this.viewHeight == i2 && this.viewWidth == i) {
            return;
        }
        this.viewWidth = i;
        this.viewHeight = i2;
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.feature.weex_barcode.BarcodeView.3
            @Override // java.lang.Runnable
            public void run() {
                android.widget.AbsoluteLayout.LayoutParams layoutParams = io.dcloud.feature.weex_barcode.BarcodeView.this.setLayoutParams();
                if (layoutParams == null) {
                    return;
                }
                android.os.Message message = new android.os.Message();
                message.what = io.dcloud.feature.weex_barcode.BarcodeView.ID_UPDATE_VIEW;
                message.obj = layoutParams;
                io.dcloud.feature.weex_barcode.BarcodeView.this.mHandler.sendMessage(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBarcodeView() {
        android.widget.AbsoluteLayout.LayoutParams layoutParams = setLayoutParams();
        if (layoutParams == null) {
            return;
        }
        android.os.Message message = new android.os.Message();
        message.what = 201;
        message.obj = layoutParams;
        this.mHandler.sendMessage(message);
    }

    private void initCamera() {
        try {
            io.dcloud.feature.barcode2.camera.CameraManager.get().openDriver(this.surfaceView.getSurfaceTexture());
            io.dcloud.feature.barcode2.decoding.CaptureActivityHandler captureActivityHandler = this.handler;
            if (captureActivityHandler == null) {
                io.dcloud.feature.barcode2.decoding.CaptureActivityHandler captureActivityHandler2 = new io.dcloud.feature.barcode2.decoding.CaptureActivityHandler(this, this.decodeFormats, this.characterSet, this.autoDecodeCharset);
                this.handler = captureActivityHandler2;
                if (this.mRunning) {
                    captureActivityHandler2.restartPreviewAndDecode();
                    return;
                }
                return;
            }
            captureActivityHandler.resume();
        } catch (java.io.IOException e) {
            this.errorMsg = e.getMessage();
        }
    }

    public void setFrameColor(int i) {
        if (i == -1) {
            i = io.dcloud.feature.barcode2.view.DetectorViewConfig.laserColor;
        }
        io.dcloud.feature.barcode2.view.DetectorViewConfig.cornerColor = i;
    }

    public void setAutoDecodeCharset(boolean z) {
        this.autoDecodeCharset = z;
    }

    public void setAutoZoom(boolean z) {
        io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.isAutoZoom = z;
    }

    public void setBackground(int i) {
        if (i == -1) {
            i = io.dcloud.feature.barcode2.view.DetectorViewConfig.laserColor;
        }
        setBackgroundColor(i);
    }

    public void setScanBarColor(int i) {
        if (i == -1) {
            i = io.dcloud.feature.barcode2.view.DetectorViewConfig.laserColor;
        }
        io.dcloud.feature.barcode2.view.DetectorViewConfig.laserColor = i;
    }

    public void setPlayBeep(boolean z) {
        this.playBeep = z;
    }

    public void setVibrate(boolean z) {
        this.vibrate = z;
    }

    public void setConserve(boolean z) {
        this.mConserve = z;
    }

    public void setFilename(java.lang.String str) {
        this.mFilename = str;
    }

    public void setFlash(boolean z) {
        io.dcloud.feature.barcode2.camera.CameraManager.get().setFlashlight(z);
    }

    public void cancelScan() {
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
                this.lastBiptmap = byte2bitmap(lastBitmapData, cameraHandler);
            }
            io.dcloud.feature.barcode2.camera.CameraManager.get().closeDriver();
            this.mRunning = false;
            this.isCancelScan = true;
        }
    }

    public void closeScan() {
        onPause();
        io.dcloud.feature.barcode2.camera.CameraManager.get().closeDriver();
        io.dcloud.feature.barcode2.view.DetectorViewConfig.clearData();
        this.surfaceView = null;
        android.graphics.Bitmap bitmap = this.lastBiptmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.lastBiptmap.recycle();
            this.lastBiptmap = null;
        }
        io.dcloud.feature.barcode2.camera.CameraManager.get().clearLastBitmapData();
        java.lang.System.gc();
    }

    public void onPause() {
        io.dcloud.feature.barcode2.decoding.CaptureActivityHandler captureActivityHandler = this.handler;
        if (captureActivityHandler != null) {
            captureActivityHandler.quitSynchronously();
            this.handler = null;
        }
        if (!this.nopermission) {
            io.dcloud.feature.barcode2.camera.CameraManager.get().closeDriver();
        }
        boolean z = this.mRunning;
        cancel();
        this.mRunning = z;
    }

    public void onDestory() {
        resumeOrientationState();
        this.inactivityTimer.shutdown();
        this.hasSurface = false;
        this.decodeFormats = null;
        this.characterSet = null;
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

    public void start() {
        io.dcloud.common.adapter.util.PermissionUtil.useSystemPermissions((android.app.Activity) this.context, new java.lang.String[]{com.hjq.permissions.Permission.CAMERA}, new io.dcloud.common.adapter.util.PermissionUtil.Request() { // from class: io.dcloud.feature.weex_barcode.BarcodeView.4
            @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
            public void onGranted(java.lang.String str) {
                io.dcloud.feature.weex_barcode.BarcodeView.this.postDelayed(new java.lang.Runnable() { // from class: io.dcloud.feature.weex_barcode.BarcodeView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (io.dcloud.feature.weex_barcode.BarcodeView.this.isSurfaceAvaliable) {
                            android.widget.AbsoluteLayout.LayoutParams layoutParams = io.dcloud.feature.weex_barcode.BarcodeView.this.setLayoutParams();
                            if (layoutParams == null) {
                                return;
                            }
                            android.os.Message message = new android.os.Message();
                            message.what = io.dcloud.feature.weex_barcode.BarcodeView.ID_START_SCAN;
                            message.obj = layoutParams;
                            io.dcloud.feature.weex_barcode.BarcodeView.this.mHandler.sendMessage(message);
                            return;
                        }
                        io.dcloud.feature.weex_barcode.BarcodeView.this.postDelayed(this, 100L);
                    }
                }, io.dcloud.feature.weex_barcode.BarcodeView.this.isSurfaceAvaliable ? 0L : io.dcloud.feature.weex_barcode.BarcodeView.VIBRATE_DURATION);
            }

            @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
            public void onDenied(java.lang.String str) {
                io.dcloud.feature.weex_barcode.BarcodeView.this.nopermission = true;
                io.dcloud.feature.weex_barcode.BarcodeView.this.setBackground(-16777216);
                io.dcloud.feature.weex_barcode.BarcodeView.this.invalidate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startP() {
        initCamera();
        if (this.decodeFormats == null) {
            initDecodeFormats(null);
        }
        if (!android.text.TextUtils.isEmpty(this.errorMsg)) {
            java.util.HashMap map = new java.util.HashMap();
            map.put("code", 8);
            map.put("message", this.errorMsg);
            map.put("type", com.taobao.weex.common.Constants.Event.FAIL);
            fireEvent("error", map);
            return;
        }
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
            this.surfaceView.setBackgroundDrawable(null);
            android.graphics.Bitmap bitmap = this.lastBiptmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.lastBiptmap.recycle();
                this.lastBiptmap = null;
            }
            io.dcloud.feature.barcode2.camera.CameraManager.get().clearLastBitmapData();
            this.surfaceView.postInvalidate();
            initCamera();
        }
        this.mRunning = true;
        this.isCancelScan = false;
    }

    public void onResume(boolean z) {
        if (this.lastBiptmap != null && this.isCancelScan && z) {
            this.surfaceView.setBackgroundDrawable(new android.graphics.drawable.BitmapDrawable(this.context.getResources(), this.lastBiptmap));
        }
        if (!this.hasSurface) {
            this.surfaceView.setSurfaceTextureListener(this);
        }
        if (((android.media.AudioManager) this.context.getSystemService("audio")).getRingerMode() != 2) {
            this.playBeep = false;
        }
        initBeepSound();
        if (z && this.mRunning) {
            this.mRunning = false;
            start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.widget.AbsoluteLayout.LayoutParams setLayoutParams() {
        android.graphics.Point cr;
        int i;
        int i2;
        int i3;
        int i4;
        io.dcloud.feature.barcode2.camera.CameraManager.sScreenWidth = this.context.getResources().getDisplayMetrics().widthPixels;
        io.dcloud.feature.barcode2.camera.CameraManager.sScreenAllHeight = this.context.getResources().getDisplayMetrics().heightPixels;
        android.graphics.Rect rect = io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().gatherRect;
        int i5 = 0;
        rect.left = 0;
        rect.top = 0;
        rect.right = this.viewWidth;
        rect.bottom = this.viewHeight;
        if (this.isVerticalScreen) {
            cr = io.dcloud.feature.barcode2.camera.CameraManager.getCR(rect.height(), rect.width());
        } else {
            cr = io.dcloud.feature.barcode2.camera.CameraManager.getCR(rect.width(), rect.height());
        }
        if (cr == null) {
            cr = new android.graphics.Point(this.viewWidth, this.viewHeight);
        }
        if (this.isVerticalScreen) {
            i2 = this.viewWidth;
            int i6 = (cr.x * i2) / cr.y;
            i = this.viewHeight;
            if (i6 < i) {
                i2 = (cr.y * i) / cr.x;
                i3 = (this.viewWidth - i2) / 2;
                io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestLeft = i3;
                io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestTop = 0;
                i5 = i3;
                i4 = 0;
            } else {
                i = (cr.x * i2) / cr.y;
                i4 = (this.viewHeight - i) / 2;
                io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestTop = i4;
                io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestLeft = 0;
            }
        } else {
            i = this.viewHeight;
            int i7 = (cr.x * i) / cr.y;
            int i8 = this.viewWidth;
            if (i7 < i8) {
                i = (cr.y * i8) / cr.x;
                i4 = (this.viewHeight - i) / 2;
                io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestTop = i4;
                io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestLeft = 0;
                i2 = i8;
            } else {
                i2 = (cr.x * i) / cr.y;
                i3 = (this.viewWidth - i2) / 2;
                io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestLeft = i3;
                io.dcloud.feature.barcode2.view.DetectorViewConfig.detectorRectOffestTop = 0;
                i5 = i3;
                i4 = 0;
            }
        }
        android.widget.AbsoluteLayout.LayoutParams layoutParams = new android.widget.AbsoluteLayout.LayoutParams(i2, i, i5, i4);
        io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().initSurfaceViewRect(i5, i4, i2, i);
        return layoutParams;
    }

    public void initDecodeFormats(com.alibaba.fastjson.JSONArray jSONArray) {
        int iIntValue;
        this.decodeFormats = new java.util.Vector<>();
        if (jSONArray == null || jSONArray.size() == 0) {
            this.decodeFormats.add(com.dcloud.zxing2.BarcodeFormat.EAN_13);
            this.decodeFormats.add(com.dcloud.zxing2.BarcodeFormat.EAN_8);
            this.decodeFormats.add(com.dcloud.zxing2.BarcodeFormat.QR_CODE);
            return;
        }
        int size = jSONArray.size();
        for (int i = 0; i < size; i++) {
            try {
                iIntValue = jSONArray.getInteger(i).intValue();
            } catch (com.alibaba.fastjson.JSONException e) {
                e.printStackTrace();
                iIntValue = -1;
            }
            if (iIntValue != -1) {
                this.decodeFormats.add(convertNumToBarcodeFormat(iIntValue));
            }
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

    private int convertTypestrToNum(com.dcloud.zxing2.BarcodeFormat barcodeFormat) {
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

    @Override // io.dcloud.feature.barcode2.decoding.IBarHandler
    public io.dcloud.feature.barcode2.view.ViewfinderView getViewfinderView() {
        return this.viewfinderView;
    }

    @Override // io.dcloud.feature.barcode2.decoding.IBarHandler
    public void autoFocus() {
        this.handler.autoFocus();
    }

    @Override // io.dcloud.feature.barcode2.decoding.IBarHandler
    public void handleDecode(com.dcloud.zxing2.Result result, android.graphics.Bitmap bitmap) {
        boolean zSaveBitmapToFile;
        java.lang.String path;
        this.inactivityTimer.onActivity();
        playBeepSoundAndVibrate();
        if (this.mConserve) {
            if (!io.dcloud.common.util.PdrUtil.isEmpty(this.mFilename) && !io.dcloud.common.util.PdrUtil.isDeviceRootDir(this.mFilename) && !this.mFilename.startsWith(io.dcloud.common.util.BaseInfo.REL_PRIVATE_DOC_DIR)) {
                this.mFilename = io.dcloud.common.util.BaseInfo.REL_PRIVATE_DOC_DIR + this.mFilename;
            }
            path = this.mInstance.rewriteUri(android.net.Uri.parse(this.mFilename), "image").getPath();
            zSaveBitmapToFile = io.dcloud.common.util.PdrUtil.saveBitmapToFile(bitmap, path);
        } else {
            zSaveBitmapToFile = false;
            path = null;
        }
        int iConvertTypestrToNum = convertTypestrToNum(result.getBarcodeFormat());
        java.util.Map<java.lang.String, java.lang.Object> map = new java.util.HashMap<>();
        map.put("code", java.lang.Integer.valueOf(iConvertTypestrToNum));
        map.put("message", result.getText());
        if (zSaveBitmapToFile && !io.dcloud.common.util.PdrUtil.isEmpty(path)) {
            map.put("file", path);
        }
        map.put("type", com.taobao.weex.ui.component.WXImage.SUCCEED);
        map.put("charSet", result.textCharset);
        fireEvent("marked", map);
        cancelScan();
    }

    private void cancel() {
        if (this.mRunning) {
            io.dcloud.feature.barcode2.decoding.CaptureActivityHandler captureActivityHandler = this.handler;
            if (captureActivityHandler != null) {
                captureActivityHandler.stopDecode();
            }
            getViewfinderView().stopUpdateScreenTimer();
            this.mRunning = false;
        }
    }

    private void initBeepSound() {
        if (this.mediaPlayer == null) {
            ((android.app.Activity) this.context).setVolumeControlStream(3);
            android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.mediaPlayer.setOnCompletionListener(this.beepListener);
            try {
                android.content.res.AssetFileDescriptor assetFileDescriptorOpenFd = this.context.getResources().getAssets().openFd(io.dcloud.common.constant.AbsoluteConst.RES_BEEP);
                this.mediaPlayer.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                assetFileDescriptorOpenFd.close();
                this.mediaPlayer.setVolume(BEEP_VOLUME, BEEP_VOLUME);
                this.mediaPlayer.prepare();
            } catch (java.io.IOException unused) {
                this.mediaPlayer = null;
            }
        }
    }

    private void playBeepSoundAndVibrate() {
        android.media.MediaPlayer mediaPlayer;
        if (this.playBeep && (mediaPlayer = this.mediaPlayer) != null) {
            mediaPlayer.start();
        }
        if (this.vibrate) {
            try {
                ((android.os.Vibrator) this.context.getSystemService("vibrator")).vibrate(VIBRATE_DURATION);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // io.dcloud.feature.barcode2.decoding.IBarHandler
    public void drawViewfinder() {
        this.viewfinderView.drawViewfinder();
    }

    @Override // io.dcloud.feature.barcode2.decoding.IBarHandler
    public boolean isRunning() {
        return this.mRunning;
    }

    @Override // android.view.View, io.dcloud.feature.barcode2.decoding.IBarHandler
    public android.os.Handler getHandler() {
        return this.handler;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        this.isSurfaceAvaliable = true;
        if (this.hasSurface) {
            return;
        }
        this.hasSurface = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        this.hasSurface = false;
        return false;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        java.lang.String language;
        super.onDraw(canvas);
        if (this.nopermission) {
            android.text.TextPaint textPaint = new android.text.TextPaint();
            textPaint.setColor(-1);
            textPaint.setTextSize(io.dcloud.common.util.PdrUtil.pxFromDp(18.0f, this.context.getResources().getDisplayMetrics()));
            textPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
            android.graphics.Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            int i = (int) (((this.viewHeight / 2.0f) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f));
            int i2 = this.viewWidth / 2;
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                language = getResources().getConfiguration().getLocales().get(0).getLanguage();
                getResources().getConfiguration().getLocales().get(0).getScript();
            } else {
                language = getResources().getConfiguration().locale.getLanguage();
                getResources().getConfiguration().getLocales().get(0).getScript();
            }
            java.lang.String string = getResources().getString(io.dcloud.base.R.string.dcloud_scan_no_permission_text);
            if (language.equalsIgnoreCase("ja")) {
                canvas.drawText("カメラ権限がありません", i2, i, textPaint);
            } else if (language.equalsIgnoreCase("ru")) {
                canvas.drawText("Требуется разрешение камеры.", i2, i, textPaint);
            } else {
                canvas.drawText(string, i2, i, textPaint);
            }
        }
    }

    private void fireEvent(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (this.component.containsEvent(str)) {
            java.util.HashMap map2 = new java.util.HashMap();
            map2.put("detail", map);
            this.component.fireEvent(str, map2);
        }
    }
}
