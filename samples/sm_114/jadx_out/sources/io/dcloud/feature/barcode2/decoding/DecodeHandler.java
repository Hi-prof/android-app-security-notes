package io.dcloud.feature.barcode2.decoding;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
final class DecodeHandler extends android.os.Handler {
    private static final java.lang.String TAG = "DecodeHandler";
    private static boolean mIsVerticalScreen = true;
    private final io.dcloud.feature.barcode2.decoding.IBarHandler activity;
    private final com.dcloud.zxing2.MultiFormatReader multiFormatReader;

    DecodeHandler(io.dcloud.feature.barcode2.decoding.IBarHandler iBarHandler, java.util.Hashtable<com.dcloud.zxing2.DecodeHintType, java.lang.Object> hashtable) {
        com.dcloud.zxing2.MultiFormatReader multiFormatReader = new com.dcloud.zxing2.MultiFormatReader(this);
        this.multiFormatReader = multiFormatReader;
        multiFormatReader.setHints(hashtable);
        this.activity = iBarHandler;
    }

    private void decode(byte[] bArr, int i, int i2) {
        com.dcloud.zxing2.Result resultDecodeWithState;
        io.dcloud.feature.barcode2.camera.PlanarYUVLuminanceSource planarYUVLuminanceSourceBuildLuminanceSource = io.dcloud.feature.barcode2.camera.CameraManager.get().buildLuminanceSource(bArr, i, i2);
        try {
            resultDecodeWithState = this.multiFormatReader.decodeWithState(new com.dcloud.zxing2.BinaryBitmap(new com.dcloud.zxing2.common.GlobalHistogramBinarizer(planarYUVLuminanceSourceBuildLuminanceSource)));
            this.multiFormatReader.reset();
        } catch (com.dcloud.zxing2.ReaderException unused) {
            this.multiFormatReader.reset();
            resultDecodeWithState = null;
        } catch (java.lang.Throwable th) {
            this.multiFormatReader.reset();
            throw th;
        }
        com.dcloud.zxing2.Result result = resultDecodeWithState;
        if (io.dcloud.feature.barcode2.BarcodeProxy.save) {
            android.hardware.Camera.Parameters parameters = io.dcloud.feature.barcode2.camera.CameraManager.get().getCameraHandler().getParameters();
            try {
                android.hardware.Camera.Size previewSize = parameters.getPreviewSize();
                android.graphics.YuvImage yuvImage = new android.graphics.YuvImage(bArr, parameters.getPreviewFormat(), previewSize.width, previewSize.height, null);
                yuvImage.compressToJpeg(new android.graphics.Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 90, new java.io.FileOutputStream(new java.io.File("/sdcard/1/" + java.lang.System.currentTimeMillis() + "--" + previewSize.width + "*" + previewSize.height + ".jpg")));
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
            }
            android.graphics.Bitmap bitmapRenderCroppedGreyscaleBitmap = planarYUVLuminanceSourceBuildLuminanceSource.renderCroppedGreyscaleBitmap(true);
            android.graphics.Rect framingRectInPreview = io.dcloud.feature.barcode2.camera.CameraManager.get().getFramingRectInPreview();
            io.dcloud.common.util.PdrUtil.saveBitmapToFile(bitmapRenderCroppedGreyscaleBitmap, "/sdcard/1/" + java.lang.System.currentTimeMillis() + "--" + framingRectInPreview.left + "*" + framingRectInPreview.top + ".png");
            io.dcloud.feature.barcode2.BarcodeProxy.save = false;
            android.app.Activity activity = (android.app.Activity) io.dcloud.feature.barcode2.BarcodeProxy.context;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("成功 left=");
            sb.append(framingRectInPreview.left);
            sb.append("top:");
            sb.append(framingRectInPreview.top);
            io.dcloud.common.util.PdrUtil.alert(activity, sb.toString(), bitmapRenderCroppedGreyscaleBitmap);
        }
        if (result == null) {
            android.os.Message.obtain(this.activity.getHandler(), 1001).sendToTarget();
            return;
        }
        android.os.Message messageObtain = android.os.Message.obtain(this.activity.getHandler(), 1002, result);
        android.os.Bundle bundle = new android.os.Bundle();
        android.graphics.Bitmap bitmapRenderCroppedGreyscaleBitmap2 = planarYUVLuminanceSourceBuildLuminanceSource.renderCroppedGreyscaleBitmap(true);
        if (!mIsVerticalScreen) {
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.postRotate(-90.0f);
            android.graphics.Bitmap bitmapCreateScaledBitmap = android.graphics.Bitmap.createScaledBitmap(bitmapRenderCroppedGreyscaleBitmap2, bitmapRenderCroppedGreyscaleBitmap2.getWidth(), bitmapRenderCroppedGreyscaleBitmap2.getHeight(), true);
            bitmapRenderCroppedGreyscaleBitmap2 = android.graphics.Bitmap.createBitmap(bitmapCreateScaledBitmap, 0, 0, bitmapCreateScaledBitmap.getWidth(), bitmapCreateScaledBitmap.getHeight(), matrix, true);
        }
        bundle.putParcelable(io.dcloud.feature.barcode2.decoding.DecodeThread.BARCODE_BITMAP, bitmapRenderCroppedGreyscaleBitmap2);
        messageObtain.setData(bundle);
        messageObtain.sendToTarget();
    }

    private void handleNeedZoom() {
        android.hardware.Camera.Parameters parameters = io.dcloud.feature.barcode2.camera.CameraManager.get().getCameraHandler().getParameters();
        int zoom = parameters.getZoom();
        int maxZoom = (int) (((double) parameters.getMaxZoom()) * 0.6d);
        int i = (int) (((double) maxZoom) * 0.2d);
        if (zoom < maxZoom) {
            zoom += i;
        }
        if (zoom <= maxZoom) {
            maxZoom = zoom;
        }
        parameters.setZoom(maxZoom);
        io.dcloud.feature.barcode2.camera.CameraManager.get().getCameraHandler().setParameters(parameters);
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        int i = message.what;
        if (i == 1010) {
            if (io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.isAutoZoom) {
                handleNeedZoom();
                return;
            }
            return;
        }
        switch (i) {
            case 1003:
                android.os.Looper.myLooper().quit();
                break;
            case 1004:
                decode((byte[]) message.obj, message.arg1, message.arg2);
                break;
            case io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.CODE_DECODE_portrait /* 1005 */:
                mIsVerticalScreen = true;
                decode((byte[]) message.obj, message.arg1, message.arg2);
                break;
            case 1006:
                mIsVerticalScreen = false;
                decode((byte[]) message.obj, message.arg1, message.arg2);
                break;
        }
    }

    public static com.dcloud.zxing2.Result decode(android.graphics.Bitmap bitmap, com.dcloud.zxing2.ResultPointCallback resultPointCallback, boolean z) {
        com.dcloud.zxing2.MultiFormatReader multiFormatReader = new com.dcloud.zxing2.MultiFormatReader(null);
        java.util.Hashtable hashtable = new java.util.Hashtable(4);
        java.util.Vector vector = new java.util.Vector();
        if (vector.isEmpty()) {
            vector = new java.util.Vector();
            vector.addAll(io.dcloud.feature.barcode2.decoding.DecodeFormatManager.ONE_D_FORMATS);
            vector.addAll(io.dcloud.feature.barcode2.decoding.DecodeFormatManager.QR_CODE_FORMATS);
            vector.addAll(io.dcloud.feature.barcode2.decoding.DecodeFormatManager.DATA_MATRIX_FORMATS);
        }
        hashtable.put(com.dcloud.zxing2.DecodeHintType.POSSIBLE_FORMATS, vector);
        com.dcloud.zxing2.DecodeHintType decodeHintType = com.dcloud.zxing2.DecodeHintType.TRY_HARDER;
        java.lang.Boolean bool = java.lang.Boolean.TRUE;
        hashtable.put(decodeHintType, bool);
        if (resultPointCallback != null) {
            hashtable.put(com.dcloud.zxing2.DecodeHintType.NEED_RESULT_POINT_CALLBACK, resultPointCallback);
        }
        if (z) {
            hashtable.put(com.dcloud.zxing2.DecodeHintType.autoDecodeCharset, bool);
        }
        multiFormatReader.setHints(hashtable);
        try {
            return multiFormatReader.decodeWithState(new com.dcloud.zxing2.BinaryBitmap(new com.dcloud.zxing2.common.GlobalHistogramBinarizer(new io.dcloud.feature.barcode2.decoding.BitmapLuminanceSource(bitmap))));
        } catch (com.dcloud.zxing2.NotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static com.dcloud.zxing2.Result decode(android.graphics.Bitmap bitmap, boolean z) {
        return decode(bitmap, (com.dcloud.zxing2.ResultPointCallback) null, z);
    }
}
