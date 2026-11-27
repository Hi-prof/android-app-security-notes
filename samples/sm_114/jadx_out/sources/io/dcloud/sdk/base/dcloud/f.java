package io.dcloud.sdk.base.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class f extends android.view.View {
    android.graphics.Bitmap a;
    int b;
    int c;
    io.dcloud.sdk.base.dcloud.ADHandler.e d;
    android.graphics.Paint e;
    android.graphics.Rect f;
    android.graphics.RectF g;
    android.graphics.Bitmap h;
    android.graphics.RectF i;

    public f(android.content.Context context, android.graphics.Bitmap bitmap, io.dcloud.sdk.base.dcloud.ADHandler.e eVar) {
        super(context);
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = new android.graphics.Paint();
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.a = bitmap;
        this.d = eVar;
    }

    private void a(android.graphics.Canvas canvas) {
        float height = this.a.getHeight();
        float width = this.a.getWidth();
        float height2 = getHeight() > 0 ? getHeight() : canvas.getHeight();
        float width2 = getWidth() > 0 ? getWidth() : canvas.getWidth();
        float f = height / width;
        float f2 = (height2 / width2) - f;
        if (f2 <= 0.15d) {
            this.g = new android.graphics.RectF(0.0f, 0.0f, width2, height2);
            return;
        }
        float f3 = (height2 - (f * width2)) / 2.0f;
        this.g = new android.graphics.RectF(0.0f, f3, width2, height2 - f3);
        if (this.i == null) {
            int i = (int) width;
            int i2 = (int) height;
            this.h = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas2 = new android.graphics.Canvas(this.h);
            canvas2.drawBitmap(this.a, new android.graphics.Rect(0, 0, i, i2), new android.graphics.Rect(0, 0, i, i2), new android.graphics.Paint());
            canvas2.drawColor(b(this.a) >= 128 ? 1711276032 : 1728053247);
            float f4 = (f2 * width) / 2.0f;
            this.i = new android.graphics.RectF(-f4, 0.0f, width2 + f4, height2);
            a(this.h);
        }
    }

    public int b(android.graphics.Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < width; i3++) {
            for (int i4 = 0; i4 < height; i4++) {
                i2++;
                int pixel = bitmap.getPixel(i3, i4);
                i = (int) (((double) i) + (((double) ((((-16711681) | pixel) >> 16) & 255)) * 0.299d) + (((double) ((((-65281) | pixel) >> 8) & 255)) * 0.587d) + (((double) ((pixel | (-256)) & 255)) * 0.114d));
            }
        }
        return i / i2;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.h = null;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        android.graphics.Bitmap bitmap = this.a;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        a(canvas);
        android.graphics.Bitmap bitmap2 = this.h;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, this.f, this.i, this.e);
        }
        canvas.drawBitmap(this.a, this.f, this.g, this.e);
    }

    private void a(android.graphics.Bitmap bitmap) {
        android.renderscript.RenderScript renderScriptCreate = android.renderscript.RenderScript.create(getContext());
        android.renderscript.Allocation allocationCreateFromBitmap = android.renderscript.Allocation.createFromBitmap(renderScriptCreate, bitmap);
        android.renderscript.ScriptIntrinsicBlur scriptIntrinsicBlurCreate = android.renderscript.ScriptIntrinsicBlur.create(renderScriptCreate, allocationCreateFromBitmap.getElement());
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.setRadius(20.0f);
        scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap);
        allocationCreateFromBitmap.copyTo(bitmap);
        renderScriptCreate.destroy();
    }
}
