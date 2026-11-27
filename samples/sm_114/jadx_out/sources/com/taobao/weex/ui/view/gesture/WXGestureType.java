package com.taobao.weex.ui.view.gesture;

/* JADX INFO: loaded from: classes.dex */
public interface WXGestureType {

    public static class GestureInfo {
        public static final java.lang.String DIRECTION = "direction";
        public static final java.lang.String HISTORICAL_XY = "changedTouches";
        public static final java.lang.String PAGE_X = "pageX";
        public static final java.lang.String PAGE_Y = "pageY";
        public static final java.lang.String POINTER_ID = "identifier";
        public static final java.lang.String SCREEN_X = "screenX";
        public static final java.lang.String SCREEN_Y = "screenY";
        public static final java.lang.String STATE = "state";
    }

    public enum LowLevelGesture implements com.taobao.weex.ui.view.gesture.WXGestureType {
        ACTION_DOWN(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBVIEW_ONTOUCH_START),
        ACTION_MOVE("touchmove"),
        ACTION_UP("touchend"),
        ACTION_CANCEL("touchcancel");

        private java.lang.String description;

        LowLevelGesture(java.lang.String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return this.description;
        }
    }

    public enum HighLevelGesture implements com.taobao.weex.ui.view.gesture.WXGestureType {
        SWIPE("swipe"),
        LONG_PRESS(com.taobao.weex.ui.component.list.BasicListComponent.DragTriggerType.LONG_PRESS),
        PAN_START("panstart"),
        PAN_MOVE("panmove"),
        PAN_END("panend"),
        HORIZONTALPAN("horizontalpan"),
        VERTICALPAN("verticalpan");

        private java.lang.String description;

        HighLevelGesture(java.lang.String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return this.description;
        }
    }
}
