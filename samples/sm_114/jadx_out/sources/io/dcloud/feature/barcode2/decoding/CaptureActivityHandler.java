package io.dcloud.feature.barcode2.decoding;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public final class CaptureActivityHandler extends android.os.Handler {
    public static final int CODE_AUTO_FOCUS = 1000;
    public static final int CODE_DECODE = 1004;
    public static final int CODE_DECODE_FAILED = 1001;
    public static final int CODE_DECODE_NEED_ZOOM = 1010;
    public static final int CODE_DECODE_SUCCEEDED = 1002;
    public static final int CODE_DECODE_landscape = 1006;
    public static final int CODE_DECODE_portrait = 1005;
    public static final int CODE_QUIT = 1003;
    private static final java.lang.String TAG = "CaptureActivityHandler";
    public static boolean isAutoZoom = true;
    private final io.dcloud.feature.barcode2.decoding.IBarHandler activity;
    private final io.dcloud.feature.barcode2.decoding.DecodeThread decodeThread;
    private io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.State state;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public CaptureActivityHandler(io.dcloud.feature.barcode2.decoding.IBarHandler iBarHandler, java.util.Vector<com.dcloud.zxing2.BarcodeFormat> vector, java.lang.String str, boolean z) {
        this.activity = iBarHandler;
        io.dcloud.feature.barcode2.decoding.DecodeThread decodeThread = new io.dcloud.feature.barcode2.decoding.DecodeThread(iBarHandler, vector, str, new io.dcloud.feature.barcode2.view.ViewfinderResultPointCallback(iBarHandler.getViewfinderView()), z);
        this.decodeThread = decodeThread;
        decodeThread.start();
        this.state = io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.State.SUCCESS;
        resume();
    }

    public static android.graphics.Bitmap convertToBMW(android.graphics.Bitmap bitmap, int i, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i4 = 0; i4 < height; i4++) {
            for (int i5 = 0; i5 < width; i5++) {
                int i6 = (width * i4) + i5;
                int i7 = iArr[i6];
                int i8 = (i7 & (-16777216)) >> 24;
                int i9 = (16711680 & i7) >> 16;
                int i10 = (65280 & i7) >> 8;
                int i11 = ((i7 & 255) > i3 ? 255 : 0) | (i8 << 24) | ((i9 > i3 ? 255 : 0) << 16) | ((i10 <= i3 ? 0 : 255) << 8);
                iArr[i6] = i11;
                if (i11 == -1) {
                    iArr[i6] = -1;
                } else {
                    iArr[i6] = -16777216;
                }
            }
        }
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return android.media.ThumbnailUtils.extractThumbnail(bitmapCreateBitmap, i, i2);
    }

    public static com.dcloud.zxing2.Result decode(android.graphics.Bitmap bitmap, boolean z) {
        com.dcloud.zxing2.Result resultDecode = io.dcloud.feature.barcode2.decoding.DecodeHandler.decode(bitmap, z);
        if (resultDecode != null) {
            return resultDecode;
        }
        com.dcloud.zxing2.Result resultTrySmallerBitmap = trySmallerBitmap(bitmap, true, z);
        return resultTrySmallerBitmap != null ? resultTrySmallerBitmap : tryBiggerBitmap(bitmap, z);
    }

    public static com.dcloud.zxing2.Result tryBiggerBitmap(android.graphics.Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < 1200 && height < 1200) {
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(width + 200, height + 200, android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
            canvas.drawColor(-1);
            canvas.drawBitmap(bitmap, 100.0f, 100.0f, new android.graphics.Paint());
            bitmap = bitmapCreateBitmap;
        }
        return io.dcloud.feature.barcode2.decoding.DecodeHandler.decode(convertToBMW(bitmap, bitmap.getWidth(), bitmap.getHeight(), 180), z);
    }

    public static com.dcloud.zxing2.Result trySmallerBitmap(android.graphics.Bitmap bitmap, boolean z, boolean z2) {
        int size;
        android.graphics.Bitmap bitmapCreateBitmap;
        int size2;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width >= 200 && height >= 200) {
            boolean z3 = width <= height;
            android.graphics.Bitmap bitmapCreateBitmap2 = z3 ? android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width, height / 2) : android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width / 2, height);
            final java.util.ArrayList arrayList = new java.util.ArrayList();
            com.dcloud.zxing2.Result resultDecode = z ? io.dcloud.feature.barcode2.decoding.DecodeHandler.decode(bitmapCreateBitmap2, new com.dcloud.zxing2.ResultPointCallback() { // from class: io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.1
                @Override // com.dcloud.zxing2.ResultPointCallback
                public void foundPossibleResultPoint(com.dcloud.zxing2.ResultPoint resultPoint) {
                    arrayList.add(resultPoint);
                }
            }, z2) : io.dcloud.feature.barcode2.decoding.DecodeHandler.decode(bitmapCreateBitmap2, z2);
            if (resultDecode != null) {
                return resultDecode;
            }
            if (z) {
                size = arrayList.size();
                arrayList.clear();
            } else {
                size = 0;
            }
            if (z3) {
                int i = height / 2;
                bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, i, width, i);
            } else {
                int i2 = width / 2;
                bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap, i2, 0, i2, height);
            }
            com.dcloud.zxing2.Result resultDecode2 = z ? io.dcloud.feature.barcode2.decoding.DecodeHandler.decode(bitmapCreateBitmap, new com.dcloud.zxing2.ResultPointCallback() { // from class: io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.2
                @Override // com.dcloud.zxing2.ResultPointCallback
                public void foundPossibleResultPoint(com.dcloud.zxing2.ResultPoint resultPoint) {
                    arrayList.add(resultPoint);
                }
            }, z2) : io.dcloud.feature.barcode2.decoding.DecodeHandler.decode(bitmapCreateBitmap, z2);
            if (resultDecode2 != null) {
                return resultDecode2;
            }
            if (z) {
                size2 = arrayList.size();
                arrayList.clear();
            } else {
                size2 = 0;
            }
            android.graphics.Bitmap bitmapCreateBitmap3 = z3 ? android.graphics.Bitmap.createBitmap(bitmap, 0, height / 8, width, (height / 4) * 3) : android.graphics.Bitmap.createBitmap(bitmap, width / 8, 0, (width / 4) * 3, height);
            com.dcloud.zxing2.Result resultDecode3 = z ? io.dcloud.feature.barcode2.decoding.DecodeHandler.decode(bitmapCreateBitmap3, new com.dcloud.zxing2.ResultPointCallback() { // from class: io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.3
                @Override // com.dcloud.zxing2.ResultPointCallback
                public void foundPossibleResultPoint(com.dcloud.zxing2.ResultPoint resultPoint) {
                    arrayList.add(resultPoint);
                }
            }, z2) : io.dcloud.feature.barcode2.decoding.DecodeHandler.decode(bitmapCreateBitmap3, z2);
            if (resultDecode3 != null) {
                return resultDecode3;
            }
            if (z) {
                int size3 = arrayList.size();
                arrayList.clear();
                if (size > size3 && size > size2) {
                    return trySmallerBitmap(bitmapCreateBitmap2, false, z2);
                }
                if (size3 > size2 && size3 > size) {
                    return trySmallerBitmap(bitmapCreateBitmap3, false, z2);
                }
                if (size2 > size3 && size2 > size) {
                    return trySmallerBitmap(bitmapCreateBitmap, false, z2);
                }
            }
        }
        return null;
    }

    public void autoFocus() {
        io.dcloud.feature.barcode2.camera.CameraManager.get().requestAutoFocus(this, 1000);
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        switch (message.what) {
            case 1000:
                android.util.Log.d(TAG, "Got auto-focus message");
                if (this.state == io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.State.PREVIEW) {
                    io.dcloud.feature.barcode2.camera.CameraManager.get().requestAutoFocus(this, 1000);
                }
                break;
            case 1001:
                android.util.Log.d(TAG, "CODE_DECODE_FAILED");
                this.state = io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.State.PREVIEW;
                io.dcloud.feature.barcode2.camera.CameraManager.get().requestPreviewFrame(this.activity, this.decodeThread.getHandler(), 1004);
                break;
            case 1002:
                android.util.Log.d(TAG, "Got decode succeeded message");
                this.state = io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.State.SUCCESS;
                android.os.Bundle data = message.getData();
                android.graphics.Bitmap bitmap = data == null ? null : (android.graphics.Bitmap) data.getParcelable(io.dcloud.feature.barcode2.decoding.DecodeThread.BARCODE_BITMAP);
                this.activity.handleDecode((com.dcloud.zxing2.Result) message.obj, bitmap);
                if (bitmap != null) {
                    bitmap.recycle();
                    java.lang.System.out.println("barcode.recycle");
                }
                break;
        }
    }

    public void quitSynchronously() {
        this.state = io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.State.DONE;
        io.dcloud.feature.barcode2.camera.CameraManager.get().stopPreview();
        android.os.Message.obtain(this.decodeThread.getHandler(), 1003).sendToTarget();
        try {
            this.decodeThread.join();
        } catch (java.lang.InterruptedException unused) {
        }
        stopDecode();
    }

    public void restartPreviewAndDecode() {
        if (this.state == io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.State.SUCCESS) {
            this.state = io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.State.PREVIEW;
            io.dcloud.feature.barcode2.camera.CameraManager.get().requestPreviewFrame(this.activity, this.decodeThread.getHandler(), 1004);
            autoFocus();
        }
    }

    public void resume() {
        io.dcloud.feature.barcode2.camera.CameraManager.get().startPreview();
        this.activity.drawViewfinder();
        restartPreviewAndDecode();
    }

    public void stopDecode() {
        removeMessages(1002);
        removeMessages(1001);
        io.dcloud.feature.barcode2.camera.CameraManager.get().removeAutoFocus();
        this.state = io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.State.SUCCESS;
    }
}
