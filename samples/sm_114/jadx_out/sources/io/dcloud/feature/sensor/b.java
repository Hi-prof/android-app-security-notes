package io.dcloud.feature.sensor;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class b implements io.dcloud.common.DHInterface.IEventCallback {
    private java.util.HashMap a = new java.util.HashMap();
    android.content.Context b;
    private android.hardware.SensorManager c;
    private android.hardware.Sensor d;

    public b(android.content.Context context) {
        this.b = context;
        android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) context.getSystemService("sensor");
        this.c = sensorManager;
        this.d = sensorManager.getDefaultSensor(1);
    }

    @Override // io.dcloud.common.DHInterface.IEventCallback
    public java.lang.Object onCallBack(java.lang.String str, java.lang.Object obj) {
        if ((!io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_WINDOW_CLOSE) && !io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE)) || !(obj instanceof io.dcloud.common.DHInterface.IWebview)) {
            return null;
        }
        io.dcloud.common.DHInterface.IWebview iWebview = (io.dcloud.common.DHInterface.IWebview) obj;
        a(iWebview);
        ((io.dcloud.common.adapter.ui.AdaFrameView) iWebview.obtainFrameView()).removeFrameViewListener(this);
        return null;
    }

    public java.lang.String a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        if (!str.equals("start")) {
            if (str.equals(com.taobao.weex.common.Constants.Value.STOP)) {
                a(iWebview);
            }
            return "";
        }
        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = (io.dcloud.common.adapter.ui.AdaFrameView) iWebview.obtainFrameView();
        io.dcloud.common.adapter.util.Logger.d("AccelerometerManager.execute start listen frameView=" + adaFrameView);
        adaFrameView.addFrameViewListener(this);
        a(iWebview, strArr[0], strArr[1]);
        return "";
    }

    private void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        io.dcloud.feature.sensor.a aVar = (io.dcloud.feature.sensor.a) this.a.get(iWebview);
        if (aVar == null) {
            aVar = new io.dcloud.feature.sensor.a(this, iWebview, str);
            this.a.put(iWebview, aVar);
        }
        int i = io.dcloud.common.util.PdrUtil.parseInt(str2, 500);
        this.c.registerListener(aVar, this.d, (i >= 0 ? i : 500) * 1000);
    }

    void a(io.dcloud.common.DHInterface.IWebview iWebview) {
        io.dcloud.feature.sensor.a aVar = (io.dcloud.feature.sensor.a) this.a.remove(iWebview);
        if (aVar != null) {
            io.dcloud.common.adapter.util.Logger.d("AccelerometerManager stop pWebViewImpl=" + iWebview);
            this.c.unregisterListener(aVar);
        }
    }

    void a(java.lang.String str) {
        java.util.Collection collectionValues = this.a.values();
        if (!collectionValues.isEmpty()) {
            java.util.Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                this.c.unregisterListener((io.dcloud.feature.sensor.a) it.next());
            }
        }
        this.a.clear();
    }
}
