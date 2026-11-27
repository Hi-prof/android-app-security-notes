package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class MotionEventCompatEclair {
    MotionEventCompatEclair() {
    }

    public static int findPointerIndex(android.view.MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int getPointerCount(android.view.MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    public static int getPointerId(android.view.MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float getX(android.view.MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float getY(android.view.MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }
}
