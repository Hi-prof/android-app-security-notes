package io.dcloud.feature.barcode2.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewfinderView extends android.view.View {
    private static final long ANIMATION_DELAY = 100;
    private static final int OPAQUE = 255;
    io.dcloud.feature.barcode2.decoding.IBarHandler barHandler;
    android.graphics.drawable.ShapeDrawable laserBitmap;
    int laserY;
    private java.util.Collection<com.dcloud.zxing2.ResultPoint> lastPossibleResultPoints;
    private android.graphics.Rect lastRect;
    java.util.Timer mUpdateProgressBar;
    private final android.graphics.Paint paint;
    private java.util.Collection<com.dcloud.zxing2.ResultPoint> possibleResultPoints;
    private boolean running;

    public ViewfinderView(android.content.Context context, io.dcloud.feature.barcode2.decoding.IBarHandler iBarHandler) {
        super(context);
        this.barHandler = null;
        this.lastRect = null;
        this.laserBitmap = null;
        this.laserY = -io.dcloud.feature.barcode2.view.DetectorViewConfig.LASER_WIDTH;
        this.mUpdateProgressBar = null;
        this.running = false;
        this.barHandler = iBarHandler;
        this.paint = new android.graphics.Paint();
        getResources();
        this.possibleResultPoints = new java.util.HashSet(5);
    }

    private void drawDetectorCorner(android.graphics.Canvas canvas, android.graphics.Rect rect) {
        this.paint.setColor(io.dcloud.feature.barcode2.view.DetectorViewConfig.cornerColor);
        int i = io.dcloud.feature.barcode2.view.DetectorViewConfig.CORNER_WIDTH / 2;
        int i2 = io.dcloud.feature.barcode2.view.DetectorViewConfig.CORNER_HEIGHT;
        int i3 = rect.left;
        int i4 = rect.top;
        canvas.drawRect(i3 - i, i4 - i, i3 + i2, i4 + i, this.paint);
        int i5 = rect.left;
        int i6 = rect.top;
        canvas.drawRect(i5 - i, i6, i5 + i, i6 + i2, this.paint);
        int i7 = rect.right;
        int i8 = rect.top;
        canvas.drawRect(i7 - i2, i8 - i, i7 + i, i8 + i, this.paint);
        int i9 = rect.right;
        int i10 = rect.top;
        canvas.drawRect(i9 - i, i10, i9 + i, i10 + i2, this.paint);
        int i11 = rect.left;
        int i12 = rect.bottom;
        canvas.drawRect(i11 - i, i12 - i2, i11 + i, i12, this.paint);
        int i13 = rect.left;
        int i14 = rect.bottom;
        canvas.drawRect(i13 - i, i14 - i, i13 + i2, i14 + i, this.paint);
        int i15 = rect.right;
        int i16 = rect.bottom;
        canvas.drawRect(i15 - i2, i16 - i, i15 + i, i16 + i, this.paint);
        int i17 = rect.right;
        int i18 = rect.bottom;
        canvas.drawRect(i17 - i, i18 - i2, i17 + i, i18 + i, this.paint);
    }

    private void drawLaserLine(android.graphics.Canvas canvas, android.graphics.Rect rect) {
        if (this.laserBitmap == null) {
            this.laserBitmap = new android.graphics.drawable.ShapeDrawable(new android.graphics.drawable.shapes.OvalShape());
            float fWidth = rect.width() / 2;
            float f = io.dcloud.feature.barcode2.view.DetectorViewConfig.LASER_WIDTH / 2;
            int i = io.dcloud.feature.barcode2.view.DetectorViewConfig.laserColor;
            this.laserBitmap.getPaint().setShader(new android.graphics.RadialGradient(fWidth, f, 240.0f, i, i & 16777215, android.graphics.Shader.TileMode.CLAMP));
        }
        this.paint.setAntiAlias(true);
        android.graphics.drawable.ShapeDrawable shapeDrawable = this.laserBitmap;
        int i2 = rect.left;
        shapeDrawable.setBounds(i2, this.laserY, rect.width() + i2, this.laserY + io.dcloud.feature.barcode2.view.DetectorViewConfig.LASER_WIDTH);
        this.laserBitmap.draw(canvas);
        this.paint.setShader(null);
    }

    private void drawNonDetectorArea(android.graphics.Canvas canvas, android.graphics.Rect rect, android.graphics.Rect rect2) {
        this.paint.setColor(io.dcloud.feature.barcode2.view.DetectorViewConfig.maskColor);
        canvas.drawRect(0.0f, 0.0f, rect2.right, rect.top, this.paint);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom, this.paint);
        canvas.drawRect(rect.right, rect.top, rect2.right, rect.bottom, this.paint);
        canvas.drawRect(0.0f, rect.bottom, rect2.right, rect2.bottom, this.paint);
    }

    private void drawResultPoint(android.graphics.Canvas canvas, android.graphics.Rect rect) {
        java.util.Collection<com.dcloud.zxing2.ResultPoint> collection = this.possibleResultPoints;
        java.util.Collection<com.dcloud.zxing2.ResultPoint> collection2 = this.lastPossibleResultPoints;
        if (collection.isEmpty()) {
            this.lastPossibleResultPoints = null;
        } else {
            this.possibleResultPoints = new java.util.HashSet(5);
            this.lastPossibleResultPoints = collection;
            this.paint.setAlpha(255);
            this.paint.setColor(io.dcloud.feature.barcode2.view.DetectorViewConfig.resultPointColor);
            for (com.dcloud.zxing2.ResultPoint resultPoint : collection) {
                canvas.drawCircle(rect.left + resultPoint.getX(), rect.top + resultPoint.getY(), 6.0f, this.paint);
            }
        }
        if (collection2 != null) {
            this.paint.setAlpha(kotlinx.coroutines.scheduling.WorkQueueKt.MASK);
            this.paint.setColor(io.dcloud.feature.barcode2.view.DetectorViewConfig.resultPointColor);
            for (com.dcloud.zxing2.ResultPoint resultPoint2 : collection2) {
                canvas.drawCircle(rect.left + resultPoint2.getX(), rect.top + resultPoint2.getY(), 3.0f, this.paint);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateScreen() {
        android.graphics.Rect detectorRect = io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().getDetectorRect();
        int i = this.laserY;
        if (i > detectorRect.bottom) {
            this.laserY = detectorRect.top;
        } else {
            this.laserY = i + 1;
        }
        postInvalidate();
    }

    public void addPossibleResultPoint(com.dcloud.zxing2.ResultPoint resultPoint) {
        this.possibleResultPoints.add(resultPoint);
    }

    public void drawViewfinder() {
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        android.graphics.Rect detectorRect = io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().getDetectorRect();
        android.graphics.Rect rect = io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().gatherRect;
        if (detectorRect == null) {
            return;
        }
        drawNonDetectorArea(canvas, detectorRect, rect);
        drawDetectorCorner(canvas, detectorRect);
        if (this.running) {
            drawLaserLine(canvas, detectorRect);
        } else {
            this.lastRect = detectorRect;
            drawLaserLine(canvas, detectorRect);
        }
    }

    public void startUpdateScreenTimer() {
        if (this.running) {
            return;
        }
        stopUpdateScreenTimer();
        this.laserY = io.dcloud.feature.barcode2.view.DetectorViewConfig.getInstance().getDetectorRect().top;
        java.util.Timer timer = new java.util.Timer();
        this.mUpdateProgressBar = timer;
        timer.schedule(new java.util.TimerTask() { // from class: io.dcloud.feature.barcode2.view.ViewfinderView.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                io.dcloud.feature.barcode2.view.ViewfinderView.this.updateScreen();
            }
        }, 0L, 10L);
        this.running = true;
    }

    public void stopUpdateScreenTimer() {
        if (this.running) {
            java.util.Timer timer = this.mUpdateProgressBar;
            if (timer != null) {
                timer.cancel();
                this.mUpdateProgressBar = null;
            }
            this.running = false;
            updateScreen();
        }
    }
}
