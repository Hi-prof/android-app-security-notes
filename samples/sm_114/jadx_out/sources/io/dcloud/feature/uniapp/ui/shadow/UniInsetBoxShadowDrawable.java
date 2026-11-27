package io.dcloud.feature.uniapp.ui.shadow;

/* JADX INFO: loaded from: classes2.dex */
public class UniInsetBoxShadowDrawable extends android.graphics.drawable.Drawable {
    private static final int BOTTOM_TO_TOP = 3;
    private static final int LEFT_TO_RIGHT = 0;
    private static final int RIGHT_TO_LEFT = 2;
    private static final int TOP_TO_BOTTOM = 1;
    private float blurRadius;
    private float height;
    private android.graphics.Paint paint;
    private float[] radii;
    private int shadowColor;
    private float shadowXSize;
    private float shadowYSize;
    private float width;
    private android.graphics.Shader[] shades = new android.graphics.Shader[4];
    private android.graphics.Path[] paths = new android.graphics.Path[4];

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
    }

    public UniInsetBoxShadowDrawable(int i, int i2, float f, float f2, float f3, float f4, int i3, float[] fArr) {
        this.blurRadius = f3;
        this.shadowColor = i3;
        this.width = i + (f * 2.0f);
        this.height = i2 + (2.0f * f2);
        this.shadowXSize = f + f4;
        this.shadowYSize = f2 + f4;
        this.radii = fArr;
        setBounds(0, 0, i, i2);
        prepare();
    }

    private void prepare() {
        android.graphics.PointF pointF = new android.graphics.PointF(0.0f, 0.0f);
        android.graphics.PointF pointF2 = new android.graphics.PointF(this.width, 0.0f);
        android.graphics.PointF pointF3 = new android.graphics.PointF(pointF2.x, this.height);
        android.graphics.PointF pointF4 = new android.graphics.PointF(pointF.x, pointF3.y);
        android.graphics.PointF pointF5 = new android.graphics.PointF(this.shadowXSize, this.shadowYSize);
        android.graphics.PointF pointF6 = new android.graphics.PointF(pointF2.x - this.shadowXSize, pointF5.y);
        android.graphics.PointF pointF7 = new android.graphics.PointF(pointF6.x, pointF3.y - this.shadowYSize);
        android.graphics.PointF pointF8 = new android.graphics.PointF(pointF5.x, pointF7.y);
        android.graphics.LinearGradient linearGradient = new android.graphics.LinearGradient(pointF5.x - this.blurRadius, pointF5.y, pointF5.x, pointF5.y, this.shadowColor, 0, android.graphics.Shader.TileMode.CLAMP);
        android.graphics.LinearGradient linearGradient2 = new android.graphics.LinearGradient(pointF5.x, pointF5.y - this.blurRadius, pointF5.x, pointF5.y, this.shadowColor, 0, android.graphics.Shader.TileMode.CLAMP);
        android.graphics.LinearGradient linearGradient3 = new android.graphics.LinearGradient(pointF7.x + this.blurRadius, pointF7.y, pointF7.x, pointF7.y, this.shadowColor, 0, android.graphics.Shader.TileMode.CLAMP);
        android.graphics.LinearGradient linearGradient4 = new android.graphics.LinearGradient(pointF7.x, pointF7.y + this.blurRadius, pointF7.x, pointF7.y, this.shadowColor, 0, android.graphics.Shader.TileMode.CLAMP);
        android.graphics.Shader[] shaderArr = this.shades;
        shaderArr[0] = linearGradient;
        shaderArr[1] = linearGradient2;
        shaderArr[2] = linearGradient3;
        shaderArr[3] = linearGradient4;
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(pointF.x, pointF.y);
        path.lineTo(pointF5.x, pointF5.y);
        path.lineTo(pointF8.x, pointF8.y);
        path.lineTo(pointF4.x, pointF4.y);
        path.close();
        android.graphics.Path path2 = new android.graphics.Path();
        path2.moveTo(pointF.x, pointF.y);
        path2.lineTo(pointF2.x, pointF2.y);
        path2.lineTo(pointF6.x, pointF6.y);
        path2.lineTo(pointF5.x, pointF5.y);
        path2.close();
        android.graphics.Path path3 = new android.graphics.Path();
        path3.moveTo(pointF2.x, pointF2.y);
        path3.lineTo(pointF3.x, pointF3.y);
        path3.lineTo(pointF7.x, pointF7.y);
        path3.lineTo(pointF6.x, pointF6.y);
        path3.close();
        android.graphics.Path path4 = new android.graphics.Path();
        path4.moveTo(pointF4.x, pointF4.y);
        path4.lineTo(pointF3.x, pointF3.y);
        path4.lineTo(pointF7.x, pointF7.y);
        path4.lineTo(pointF8.x, pointF8.y);
        path4.close();
        android.graphics.Path[] pathArr = this.paths;
        pathArr[0] = path;
        pathArr[1] = path2;
        pathArr[2] = path3;
        pathArr[3] = path4;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setStyle(android.graphics.Paint.Style.FILL);
        this.paint.setColor(this.shadowColor);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        android.graphics.Rect clipBounds = canvas.getClipBounds();
        android.graphics.Path path = new android.graphics.Path();
        path.addRoundRect(new android.graphics.RectF(clipBounds), this.radii, android.graphics.Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.translate(clipBounds.left, clipBounds.top);
        for (int i = 0; i < 4; i++) {
            android.graphics.Shader shader = this.shades[i];
            android.graphics.Path path2 = this.paths[i];
            this.paint.setShader(shader);
            canvas.drawPath(path2, this.paint);
        }
    }
}
