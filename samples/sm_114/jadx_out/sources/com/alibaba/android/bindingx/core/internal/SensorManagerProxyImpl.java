package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: loaded from: classes.dex */
class SensorManagerProxyImpl implements com.alibaba.android.bindingx.core.internal.SensorManagerProxy {
    private final android.hardware.SensorManager mSensorManager;

    SensorManagerProxyImpl(android.hardware.SensorManager sensorManager) {
        this.mSensorManager = sensorManager;
    }

    @Override // com.alibaba.android.bindingx.core.internal.SensorManagerProxy
    public boolean registerListener(android.hardware.SensorEventListener sensorEventListener, int i, int i2, android.os.Handler handler) {
        java.util.List<android.hardware.Sensor> sensorList = this.mSensorManager.getSensorList(i);
        if (sensorList.isEmpty()) {
            return false;
        }
        return this.mSensorManager.registerListener(sensorEventListener, sensorList.get(0), i2, handler);
    }

    @Override // com.alibaba.android.bindingx.core.internal.SensorManagerProxy
    public void unregisterListener(android.hardware.SensorEventListener sensorEventListener, int i) {
        java.util.List<android.hardware.Sensor> sensorList = this.mSensorManager.getSensorList(i);
        if (sensorList.isEmpty()) {
            return;
        }
        try {
            this.mSensorManager.unregisterListener(sensorEventListener, sensorList.get(0));
        } catch (java.lang.Throwable unused) {
            com.alibaba.android.bindingx.core.LogProxy.w("Failed to unregister device sensor " + sensorList.get(0).getName());
        }
    }
}
