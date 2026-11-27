package pl.droidsonroids.gif.transforms;

/* JADX INFO: loaded from: classes2.dex */
public interface Transform {
    void onBoundsChange(android.graphics.Rect rect);

    void onDraw(android.graphics.Canvas canvas, android.graphics.Paint paint, android.graphics.Bitmap bitmap);
}
