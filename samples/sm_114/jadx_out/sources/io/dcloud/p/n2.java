package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class n2 implements android.view.View.OnTouchListener {
    private android.view.View a;
    private io.dcloud.feature.gallery.imageedit.view.IMGStickerView b;
    private float c;
    private float d;
    private double e;
    private double f;
    private android.graphics.Matrix g = new android.graphics.Matrix();

    public n2(io.dcloud.feature.gallery.imageedit.view.IMGStickerView iMGStickerView, android.view.View view) {
        this.a = view;
        this.b = iMGStickerView;
        view.setOnTouchListener(this);
    }

    private static double a(float f, float f2) {
        return java.lang.Math.toDegrees(java.lang.Math.atan2(f, f2));
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.d = 0.0f;
            this.c = 0.0f;
            float x2 = (this.a.getX() + x) - this.b.getPivotX();
            float y2 = (this.a.getY() + y) - this.b.getPivotY();
            android.util.Log.d("IMGStickerAdjustHelper", io.dcloud.common.util.StringUtil.format("X=%f,Y=%f", java.lang.Float.valueOf(x2), java.lang.Float.valueOf(y2)));
            this.e = a(0.0f, 0.0f, x2, y2);
            this.f = a(y2, x2);
            this.g.setTranslate(x2 - x, y2 - y);
            android.util.Log.d("IMGStickerAdjustHelper", io.dcloud.common.util.StringUtil.format("degrees=%f", java.lang.Double.valueOf(a(y2, x2))));
            this.g.postRotate((float) (-a(y2, x2)), this.c, this.d);
            return true;
        }
        if (action != 2) {
            return false;
        }
        float[] fArr = {motionEvent.getX(), motionEvent.getY()};
        float x3 = (this.a.getX() + fArr[0]) - this.b.getPivotX();
        float y3 = (this.a.getY() + fArr[1]) - this.b.getPivotY();
        android.util.Log.d("IMGStickerAdjustHelper", io.dcloud.common.util.StringUtil.format("X=%f,Y=%f", java.lang.Float.valueOf(x3), java.lang.Float.valueOf(y3)));
        double dA = a(0.0f, 0.0f, x3, y3);
        double dA2 = a(y3, x3);
        this.b.a((float) (dA / this.e));
        android.util.Log.d("IMGStickerAdjustHelper", "    D   = " + (dA2 - this.f));
        io.dcloud.feature.gallery.imageedit.view.IMGStickerView iMGStickerView = this.b;
        iMGStickerView.setRotation((float) ((((double) iMGStickerView.getRotation()) + dA2) - this.f));
        this.e = dA;
        return true;
    }

    private static double a(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return java.lang.Math.sqrt((f5 * f5) + (f6 * f6));
    }
}
