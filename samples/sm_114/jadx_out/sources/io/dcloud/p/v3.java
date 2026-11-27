package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class v3 implements android.hardware.SensorEventListener {
    android.hardware.SensorManager a;
    io.dcloud.common.DHInterface.IWebview b;
    private android.hardware.Sensor c;
    java.lang.String d = null;
    java.lang.String e = null;

    v3(io.dcloud.common.DHInterface.IWebview iWebview) {
        this.b = iWebview;
        android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) iWebview.getContext().getSystemService("sensor");
        this.a = sensorManager;
        this.c = sensorManager.getDefaultSensor(8);
    }

    void a(float f) {
        java.lang.String str = this.d;
        if (str != null) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.b, str, java.lang.String.valueOf(f), io.dcloud.common.util.JSUtil.OK, true, true);
            if (this.e == null) {
                b();
            }
            this.d = null;
        }
        java.lang.String str2 = this.e;
        if (str2 != null) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.b, str2, java.lang.String.valueOf(f), io.dcloud.common.util.JSUtil.OK, true, true);
        }
    }

    public void b() {
        this.a.unregisterListener(this);
        this.d = null;
        this.e = null;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 8) {
            float[] fArr = sensorEvent.values;
            if (fArr != null) {
                a(fArr[0]);
            } else {
                a(0, "NO Proximity Message");
            }
        }
    }

    void a(int i, java.lang.String str) {
        b();
        java.lang.String str2 = this.d;
        if (str2 != null) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.b, str2, io.dcloud.common.constant.DOMException.toJSON(i, str), io.dcloud.common.util.JSUtil.ERROR, true, true);
            if (this.e == null) {
                b();
            }
            this.d = null;
        }
        java.lang.String str3 = this.e;
        if (str3 != null) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.b, str3, io.dcloud.common.constant.DOMException.toJSON(i, str), io.dcloud.common.util.JSUtil.ERROR, true, true);
        }
    }

    public void a() {
        this.a.registerListener(this, this.c, 500000);
    }
}
