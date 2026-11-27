package io.dcloud.feature.sensor;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class a implements android.hardware.SensorEventListener {
    java.lang.String a;
    io.dcloud.common.DHInterface.IWebview b;
    io.dcloud.feature.sensor.b c;

    a(io.dcloud.feature.sensor.b bVar, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        this.c = bVar;
        this.a = str;
        this.b = iWebview;
    }

    void a(float f, float f2, float f3) {
        io.dcloud.common.util.Deprecated_JSUtil.excCallbackSuccess(this.b, this.a, java.lang.String.format(java.util.Locale.ENGLISH, "{x:%f,y:%f,z:%f}", java.lang.Float.valueOf(f), java.lang.Float.valueOf(f2), java.lang.Float.valueOf(f3)), true, true);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            if (fArr != null) {
                a(fArr[0], fArr[1], fArr[2]);
            } else {
                a(0, "NO Accelerometer Message");
            }
            io.dcloud.common.adapter.util.Logger.d("accelerometer", "accelerometer-   x= " + fArr[0] + ";y=" + fArr[1] + ";z=" + fArr[2] + " at " + this.b);
        }
    }

    void a(int i, java.lang.String str) {
        this.c.a(this.b);
        io.dcloud.common.util.Deprecated_JSUtil.excCallbackError(this.b, this.a, io.dcloud.common.constant.DOMException.toJSON(i, str), true);
    }
}
