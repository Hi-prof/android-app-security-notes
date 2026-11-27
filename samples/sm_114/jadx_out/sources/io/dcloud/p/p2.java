package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class p2 {
    private static final android.graphics.Matrix d = new android.graphics.Matrix();
    private android.view.View a;
    private float b;
    private float c;

    public p2(android.view.View view) {
        this.a = view;
    }

    public boolean a(android.view.View view, android.view.MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.b = motionEvent.getX();
            this.c = motionEvent.getY();
            android.graphics.Matrix matrix = d;
            matrix.reset();
            matrix.setRotate(view.getRotation());
            return true;
        }
        if (actionMasked != 2) {
            return false;
        }
        float[] fArr = {motionEvent.getX() - this.b, motionEvent.getY() - this.c};
        d.mapPoints(fArr);
        view.setTranslationX(this.a.getTranslationX() + fArr[0]);
        view.setTranslationY(this.a.getTranslationY() + fArr[1]);
        return true;
    }
}
