package com.taobao.weex.ui.animation;

/* JADX INFO: loaded from: classes.dex */
class CameraDistanceProperty extends android.util.Property<android.view.View, java.lang.Float> {
    private static final java.lang.String TAG = "CameraDistance";
    private static com.taobao.weex.ui.animation.CameraDistanceProperty instance;

    static android.util.Property<android.view.View, java.lang.Float> getInstance() {
        return instance;
    }

    private CameraDistanceProperty() {
        super(java.lang.Float.class, TAG);
    }

    @Override // android.util.Property
    public java.lang.Float get(android.view.View view) {
        return java.lang.Float.valueOf(view.getCameraDistance());
    }

    @Override // android.util.Property
    public void set(android.view.View view, java.lang.Float f) {
        view.setCameraDistance(f.floatValue());
    }
}
