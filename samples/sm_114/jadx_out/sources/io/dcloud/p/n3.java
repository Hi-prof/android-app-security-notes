package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class n3 implements android.hardware.SensorEventListener {
    java.lang.String a;
    io.dcloud.common.DHInterface.IWebview b;
    private android.hardware.SensorManager c;
    private android.hardware.Sensor d;
    private android.hardware.Sensor e;
    private android.hardware.Sensor f;
    private boolean k = false;
    private float[] g = new float[3];
    private float[] h = new float[3];
    private float[] i = new float[3];
    private float[] j = new float[9];

    n3(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        this.a = str;
        this.b = iWebview;
        android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) iWebview.getContext().getSystemService("sensor");
        this.c = sensorManager;
        this.d = sensorManager.getDefaultSensor(2);
        this.e = this.c.getDefaultSensor(1);
        this.f = this.c.getDefaultSensor(3);
    }

    public void a() {
        this.c.registerListener(this, this.d, 1);
        this.c.registerListener(this, this.e, 1);
        this.c.registerListener(this, this.f, 1);
    }

    public void b() {
        this.c.unregisterListener(this);
        this.d = null;
        this.e = null;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type != 1) {
            if (type == 2) {
                if (this.k) {
                    return;
                }
                this.g = (float[]) sensorEvent.values.clone();
                return;
            } else {
                if (type != 3) {
                    return;
                }
                float[] fArr = sensorEvent.values;
                if (fArr == null) {
                    a(0, "NO Accelerometer Message");
                    return;
                }
                float fRound = java.lang.Math.round(fArr[0] * 100.0f) / 100.0f;
                float fRound2 = java.lang.Math.round(sensorEvent.values[1] * 100.0f) / 100.0f;
                float fRound3 = java.lang.Math.round(sensorEvent.values[2] * 100.0f) / 100.0f;
                this.k = true;
                a(fRound, fRound2, fRound3);
                return;
            }
        }
        if (this.k) {
            return;
        }
        float[] fArr2 = (float[]) sensorEvent.values.clone();
        this.h = fArr2;
        float[] fArr3 = this.g;
        if (fArr3 == null) {
            return;
        }
        android.hardware.SensorManager.getRotationMatrix(this.j, null, fArr2, fArr3);
        android.hardware.SensorManager.getOrientation(this.j, this.i);
        float[] fArr4 = this.i;
        if (fArr4 == null) {
            a(0, "NO Accelerometer Message");
            return;
        }
        float degrees = (float) java.lang.Math.toDegrees(fArr4[0]);
        if (degrees < 0.0f) {
            degrees += 360.0f;
        }
        float degrees2 = (float) java.lang.Math.toDegrees(this.i[1]);
        float f = -((float) java.lang.Math.toDegrees(this.i[2]));
        if (degrees == 0.0f || degrees2 == 0.0f) {
            return;
        }
        a(degrees, degrees2, f);
    }

    void a(float f, float f2, float f3) {
        io.dcloud.common.util.Deprecated_JSUtil.excCallbackSuccess(this.b, this.a, java.lang.String.format(java.util.Locale.ENGLISH, "{alpha:%f,beta:%f,gamma:%f,magneticHeading:%f,trueHeading:%f,headingAccuracy:%f}", java.lang.Float.valueOf(f), java.lang.Float.valueOf(-f2), java.lang.Float.valueOf(-f3), java.lang.Float.valueOf(f), java.lang.Float.valueOf(f), java.lang.Float.valueOf(0.0f)), true, true);
    }

    void a(int i, java.lang.String str) {
        b();
        io.dcloud.common.util.Deprecated_JSUtil.excCallbackError(this.b, this.a, io.dcloud.common.constant.DOMException.toJSON(i, str), true);
    }
}
