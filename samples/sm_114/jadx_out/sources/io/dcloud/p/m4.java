package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class m4 extends android.graphics.drawable.Drawable {
    android.graphics.Paint a = new android.graphics.Paint();
    android.graphics.RectF b = null;
    android.graphics.Bitmap c = null;
    android.graphics.RectF d = null;
    android.graphics.Bitmap e;
    android.content.Context f;

    public m4(android.graphics.Bitmap bitmap, android.content.Context context) {
        this.e = bitmap;
        this.f = context;
    }

    private void a() {
        android.graphics.Rect bounds = getBounds();
        float height = this.e.getHeight();
        float width = this.e.getWidth();
        float fHeight = bounds.height();
        float fWidth = bounds.width();
        float f = height / width;
        float f2 = (fHeight / fWidth) - f;
        if (f2 <= 0.15d) {
            this.b = new android.graphics.RectF(0.0f, 0.0f, fWidth, fHeight);
            return;
        }
        float f3 = (fHeight - (f * fWidth)) / 2.0f;
        this.b = new android.graphics.RectF(0.0f, f3, fWidth, fHeight - f3);
        if (this.d == null) {
            this.c = this.e.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
            android.graphics.Canvas canvas = new android.graphics.Canvas(this.c);
            canvas.scale(0.25f, 0.25f, width / 2.0f, height / 2.0f);
            canvas.drawColor(1711276032);
            float f4 = (f2 * width) / 2.0f;
            this.d = new android.graphics.RectF(-f4, 0.0f, fWidth + f4, fHeight);
            a(this.c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        android.graphics.Bitmap bitmap = this.e;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        if (this.c == null) {
            a();
        }
        android.graphics.Bitmap bitmap2 = this.c;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, (android.graphics.Rect) null, this.d, this.a);
        }
        canvas.drawBitmap(this.e, (android.graphics.Rect) null, this.b, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
    }

    private void a(android.graphics.Bitmap bitmap) {
        android.renderscript.RenderScript renderScriptCreate = android.renderscript.RenderScript.create(this.f);
        android.renderscript.Allocation allocationCreateFromBitmap = android.renderscript.Allocation.createFromBitmap(renderScriptCreate, bitmap);
        android.renderscript.ScriptIntrinsicBlur scriptIntrinsicBlurCreate = android.renderscript.ScriptIntrinsicBlur.create(renderScriptCreate, allocationCreateFromBitmap.getElement());
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.setRadius(20.0f);
        scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap);
        allocationCreateFromBitmap.copyTo(bitmap);
        renderScriptCreate.destroy();
    }
}
