package master.flame.danmaku.controller;

/* JADX INFO: loaded from: classes2.dex */
public class DrawHelper {
    public static android.graphics.Paint PAINT = null;
    public static android.graphics.Paint PAINT_FPS = null;
    public static android.graphics.RectF RECT = null;
    private static boolean USE_DRAWCOLOR_MODE_CLEAR = true;
    private static boolean USE_DRAWCOLOR_TO_CLEAR_CANVAS = true;

    static {
        android.graphics.Paint paint = new android.graphics.Paint();
        PAINT = paint;
        paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        PAINT.setColor(0);
        RECT = new android.graphics.RectF();
    }

    public static void useDrawColorToClearCanvas(boolean z, boolean z2) {
        USE_DRAWCOLOR_TO_CLEAR_CANVAS = z;
        USE_DRAWCOLOR_MODE_CLEAR = z2;
    }

    public static void drawFPS(android.graphics.Canvas canvas, java.lang.String str) {
        if (PAINT_FPS == null) {
            android.graphics.Paint paint = new android.graphics.Paint();
            PAINT_FPS = paint;
            paint.setColor(-65536);
            PAINT_FPS.setTextSize(30.0f);
        }
        int height = canvas.getHeight();
        clearCanvas(canvas, 10.0f, height - 100, (int) (PAINT_FPS.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height - 50, PAINT_FPS);
    }

    public static void clearCanvas(android.graphics.Canvas canvas) {
        if (USE_DRAWCOLOR_TO_CLEAR_CANVAS) {
            if (USE_DRAWCOLOR_MODE_CLEAR) {
                canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        RECT.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        clearCanvas(canvas, RECT);
    }

    public static void fillTransparent(android.graphics.Canvas canvas) {
        canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
    }

    public static void clearCanvas(android.graphics.Canvas canvas, float f, float f2, float f3, float f4) {
        RECT.set(f, f2, f3, f4);
        clearCanvas(canvas, RECT);
    }

    private static void clearCanvas(android.graphics.Canvas canvas, android.graphics.RectF rectF) {
        if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
            return;
        }
        canvas.drawRect(rectF, PAINT);
    }
}
