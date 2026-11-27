package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: loaded from: classes.dex */
interface SensorManagerProxy {
    boolean registerListener(android.hardware.SensorEventListener sensorEventListener, int i, int i2, android.os.Handler handler);

    void unregisterListener(android.hardware.SensorEventListener sensorEventListener, int i);
}
