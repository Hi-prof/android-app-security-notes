package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class MotionEventCompat {
    public static final int ACTION_HOVER_ENTER = 9;
    public static final int ACTION_HOVER_EXIT = 10;
    public static final int ACTION_HOVER_MOVE = 7;
    public static final int ACTION_MASK = 255;
    public static final int ACTION_POINTER_DOWN = 5;
    public static final int ACTION_POINTER_INDEX_MASK = 65280;
    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    public static final int ACTION_POINTER_UP = 6;
    public static final int ACTION_SCROLL = 8;
    public static final int AXIS_BRAKE = 23;
    public static final int AXIS_DISTANCE = 24;
    public static final int AXIS_GAS = 22;
    public static final int AXIS_GENERIC_1 = 32;
    public static final int AXIS_GENERIC_10 = 41;
    public static final int AXIS_GENERIC_11 = 42;
    public static final int AXIS_GENERIC_12 = 43;
    public static final int AXIS_GENERIC_13 = 44;
    public static final int AXIS_GENERIC_14 = 45;
    public static final int AXIS_GENERIC_15 = 46;
    public static final int AXIS_GENERIC_16 = 47;
    public static final int AXIS_GENERIC_2 = 33;
    public static final int AXIS_GENERIC_3 = 34;
    public static final int AXIS_GENERIC_4 = 35;
    public static final int AXIS_GENERIC_5 = 36;
    public static final int AXIS_GENERIC_6 = 37;
    public static final int AXIS_GENERIC_7 = 38;
    public static final int AXIS_GENERIC_8 = 39;
    public static final int AXIS_GENERIC_9 = 40;
    public static final int AXIS_HAT_X = 15;
    public static final int AXIS_HAT_Y = 16;
    public static final int AXIS_HSCROLL = 10;
    public static final int AXIS_LTRIGGER = 17;
    public static final int AXIS_ORIENTATION = 8;
    public static final int AXIS_PRESSURE = 2;
    public static final int AXIS_RTRIGGER = 18;
    public static final int AXIS_RUDDER = 20;
    public static final int AXIS_RX = 12;
    public static final int AXIS_RY = 13;
    public static final int AXIS_RZ = 14;
    public static final int AXIS_SIZE = 3;
    public static final int AXIS_THROTTLE = 19;
    public static final int AXIS_TILT = 25;
    public static final int AXIS_TOOL_MAJOR = 6;
    public static final int AXIS_TOOL_MINOR = 7;
    public static final int AXIS_TOUCH_MAJOR = 4;
    public static final int AXIS_TOUCH_MINOR = 5;
    public static final int AXIS_VSCROLL = 9;
    public static final int AXIS_WHEEL = 21;
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final int AXIS_Z = 11;
    static final com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl IMPL = new com.dcloud.android.v4.view.MotionEventCompat.HoneycombMr1MotionEventVersionImpl();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class BaseMotionEventVersionImpl implements com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl {
        BaseMotionEventVersionImpl() {
        }

        @Override // com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl
        public int findPointerIndex(android.view.MotionEvent motionEvent, int i) {
            return i == 0 ? 0 : -1;
        }

        @Override // com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl
        public float getAxisValue(android.view.MotionEvent motionEvent, int i) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl
        public float getAxisValue(android.view.MotionEvent motionEvent, int i, int i2) {
            return 0.0f;
        }

        @Override // com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl
        public int getPointerCount(android.view.MotionEvent motionEvent) {
            return 1;
        }

        @Override // com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl
        public int getPointerId(android.view.MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            throw new java.lang.IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        @Override // com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl
        public int getSource(android.view.MotionEvent motionEvent) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl
        public float getX(android.view.MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getX();
            }
            throw new java.lang.IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        @Override // com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl
        public float getY(android.view.MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getY();
            }
            throw new java.lang.IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class EclairMotionEventVersionImpl extends com.dcloud.android.v4.view.MotionEventCompat.BaseMotionEventVersionImpl {
        EclairMotionEventVersionImpl() {
        }

        @Override // com.dcloud.android.v4.view.MotionEventCompat.BaseMotionEventVersionImpl, com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl
        public int findPointerIndex(android.view.MotionEvent motionEvent, int i) {
            return com.dcloud.android.v4.view.MotionEventCompatEclair.findPointerIndex(motionEvent, i);
        }

        @Override // com.dcloud.android.v4.view.MotionEventCompat.BaseMotionEventVersionImpl, com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl
        public int getPointerCount(android.view.MotionEvent motionEvent) {
            return com.dcloud.android.v4.view.MotionEventCompatEclair.getPointerCount(motionEvent);
        }

        @Override // com.dcloud.android.v4.view.MotionEventCompat.BaseMotionEventVersionImpl, com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl
        public int getPointerId(android.view.MotionEvent motionEvent, int i) {
            return com.dcloud.android.v4.view.MotionEventCompatEclair.getPointerId(motionEvent, i);
        }

        @Override // com.dcloud.android.v4.view.MotionEventCompat.BaseMotionEventVersionImpl, com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl
        public float getX(android.view.MotionEvent motionEvent, int i) {
            return com.dcloud.android.v4.view.MotionEventCompatEclair.getX(motionEvent, i);
        }

        @Override // com.dcloud.android.v4.view.MotionEventCompat.BaseMotionEventVersionImpl, com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl
        public float getY(android.view.MotionEvent motionEvent, int i) {
            return com.dcloud.android.v4.view.MotionEventCompatEclair.getY(motionEvent, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class GingerbreadMotionEventVersionImpl extends com.dcloud.android.v4.view.MotionEventCompat.EclairMotionEventVersionImpl {
        GingerbreadMotionEventVersionImpl() {
        }

        @Override // com.dcloud.android.v4.view.MotionEventCompat.BaseMotionEventVersionImpl, com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl
        public int getSource(android.view.MotionEvent motionEvent) {
            return com.dcloud.android.v4.view.MotionEventCompatGingerbread.getSource(motionEvent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class HoneycombMr1MotionEventVersionImpl extends com.dcloud.android.v4.view.MotionEventCompat.GingerbreadMotionEventVersionImpl {
        HoneycombMr1MotionEventVersionImpl() {
        }

        @Override // com.dcloud.android.v4.view.MotionEventCompat.BaseMotionEventVersionImpl, com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl
        public float getAxisValue(android.view.MotionEvent motionEvent, int i) {
            return com.dcloud.android.v4.view.MotionEventCompatHoneycombMr1.getAxisValue(motionEvent, i);
        }

        @Override // com.dcloud.android.v4.view.MotionEventCompat.BaseMotionEventVersionImpl, com.dcloud.android.v4.view.MotionEventCompat.MotionEventVersionImpl
        public float getAxisValue(android.view.MotionEvent motionEvent, int i, int i2) {
            return com.dcloud.android.v4.view.MotionEventCompatHoneycombMr1.getAxisValue(motionEvent, i, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface MotionEventVersionImpl {
        int findPointerIndex(android.view.MotionEvent motionEvent, int i);

        float getAxisValue(android.view.MotionEvent motionEvent, int i);

        float getAxisValue(android.view.MotionEvent motionEvent, int i, int i2);

        int getPointerCount(android.view.MotionEvent motionEvent);

        int getPointerId(android.view.MotionEvent motionEvent, int i);

        int getSource(android.view.MotionEvent motionEvent);

        float getX(android.view.MotionEvent motionEvent, int i);

        float getY(android.view.MotionEvent motionEvent, int i);
    }

    public static int findPointerIndex(android.view.MotionEvent motionEvent, int i) {
        return IMPL.findPointerIndex(motionEvent, i);
    }

    public static int getActionIndex(android.view.MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int getActionMasked(android.view.MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static float getAxisValue(android.view.MotionEvent motionEvent, int i) {
        return IMPL.getAxisValue(motionEvent, i);
    }

    public static int getPointerCount(android.view.MotionEvent motionEvent) {
        return IMPL.getPointerCount(motionEvent);
    }

    public static int getPointerId(android.view.MotionEvent motionEvent, int i) {
        return IMPL.getPointerId(motionEvent, i);
    }

    public static int getSource(android.view.MotionEvent motionEvent) {
        return IMPL.getSource(motionEvent);
    }

    public static float getX(android.view.MotionEvent motionEvent, int i) {
        return IMPL.getX(motionEvent, i);
    }

    public static float getY(android.view.MotionEvent motionEvent, int i) {
        return IMPL.getY(motionEvent, i);
    }

    public static float getAxisValue(android.view.MotionEvent motionEvent, int i, int i2) {
        return IMPL.getAxisValue(motionEvent, i, i2);
    }
}
