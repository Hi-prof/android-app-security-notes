package com.taobao.weex.ui.view.gesture;

/* JADX INFO: loaded from: classes.dex */
public class WXGesture extends android.view.GestureDetector.SimpleOnGestureListener implements android.view.View.OnTouchListener {
    private static final int CUR_EVENT = -1;
    public static final java.lang.String DOWN = "down";
    public static final java.lang.String END = "end";
    public static final java.lang.String LEFT = "left";
    public static final java.lang.String MOVE = "move";
    public static final java.lang.String RIGHT = "right";
    public static final java.lang.String START = "start";
    private static final java.lang.String TAG = "Gesture";
    public static final java.lang.String UNKNOWN = "unknown";
    public static final java.lang.String UP = "up";
    private com.taobao.weex.ui.component.WXComponent component;
    private android.view.GestureDetector mGestureDetector;
    private int mParentOrientation;
    private int shouldBubbleInterval;
    private boolean shouldBubbleResult;
    private long swipeDownTime = -1;
    private long panDownTime = -1;
    private com.taobao.weex.ui.view.gesture.WXGestureType mPendingPan = null;
    private boolean mIsPreventMoveEvent = false;
    private boolean mIsTouchEventConsumed = false;
    private boolean requestDisallowInterceptTouchEvent = false;
    private int shouldBubbleCallRemainTimes = 0;
    private final java.util.List<android.view.View.OnTouchListener> mTouchListeners = new java.util.LinkedList();
    private android.graphics.Rect globalRect = new android.graphics.Rect();
    private android.graphics.Point globalOffset = new android.graphics.Point();
    private android.graphics.Point globalEventOffset = new android.graphics.Point();
    private android.graphics.PointF locEventOffset = new android.graphics.PointF();
    private android.graphics.PointF locLeftTop = new android.graphics.PointF();

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(android.view.MotionEvent motionEvent) {
        return true;
    }

    public WXGesture(com.taobao.weex.ui.component.WXComponent wXComponent, android.content.Context context) {
        this.mParentOrientation = -1;
        this.shouldBubbleResult = true;
        this.shouldBubbleInterval = 0;
        this.component = wXComponent;
        this.mGestureDetector = new android.view.GestureDetector(context, this, new com.taobao.weex.ui.view.gesture.WXGesture.GestureHandler());
        com.taobao.weex.ui.component.Scrollable parentScroller = wXComponent.getParentScroller();
        if (parentScroller != null) {
            this.mParentOrientation = parentScroller.getOrientation();
        }
        this.shouldBubbleResult = com.taobao.weex.utils.WXUtils.getBoolean(wXComponent.getAttrs().get(com.taobao.weex.common.Constants.Name.SHOULD_STOP_PROPAGATION_INIT_RESULT), true).booleanValue();
        this.shouldBubbleInterval = com.taobao.weex.utils.WXUtils.getNumberInt(wXComponent.getAttrs().get(com.taobao.weex.common.Constants.Name.SHOULD_STOP_PROPAGATION_INTERVAL), 0);
    }

    private boolean isParentScrollable() {
        com.taobao.weex.ui.component.Scrollable parentScroller;
        com.taobao.weex.ui.component.WXComponent wXComponent = this.component;
        return wXComponent == null || (parentScroller = wXComponent.getParentScroller()) == null || parentScroller.isScrollable();
    }

    private boolean hasSameOrientationWithParent() {
        return (this.mParentOrientation == 0 && this.component.containsGesture(com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.HORIZONTALPAN)) || (this.mParentOrientation == 1 && this.component.containsGesture(com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.VERTICALPAN));
    }

    public void setPreventMoveEvent(boolean z) {
        this.mIsPreventMoveEvent = z;
    }

    public boolean isTouchEventConsumedByAdvancedGesture() {
        return this.mIsTouchEventConsumed;
    }

    public static boolean isStopPropagation(java.lang.String str) {
        return com.taobao.weex.common.Constants.Event.STOP_PROPAGATION.equals(str) || com.taobao.weex.common.Constants.Event.STOP_PROPAGATION_RAX.equals(str);
    }

    public static boolean hasStopPropagation(com.taobao.weex.ui.component.WXComponent wXComponent) {
        com.taobao.weex.dom.WXEvent events = wXComponent.getEvents();
        if (events == null) {
            return false;
        }
        int size = events.size();
        for (int i = 0; i < size && i < events.size(); i++) {
            if (isStopPropagation((java.lang.String) events.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean shouldBubbleTouchEvent(android.view.MotionEvent motionEvent) {
        int i;
        if (!hasStopPropagation(this.component)) {
            return true;
        }
        if (this.shouldBubbleInterval > 0 && (i = this.shouldBubbleCallRemainTimes) > 0) {
            this.shouldBubbleCallRemainTimes = i - 1;
            return this.shouldBubbleResult;
        }
        java.util.Map<java.lang.String, java.lang.Object> mapCreateFireEventParam = createFireEventParam(motionEvent, -1, null);
        mapCreateFireEventParam.put("type", "touch");
        if (motionEvent.getAction() == 0) {
            mapCreateFireEventParam.put("action", "start");
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            mapCreateFireEventParam.put("action", "end");
        } else {
            mapCreateFireEventParam.put("action", MOVE);
        }
        com.taobao.weex.dom.WXEvent events = this.component.getEvents();
        java.lang.String str = com.taobao.weex.common.Constants.Event.STOP_PROPAGATION;
        if (!events.contains(com.taobao.weex.common.Constants.Event.STOP_PROPAGATION)) {
            str = com.taobao.weex.common.Constants.Event.STOP_PROPAGATION_RAX;
        }
        com.taobao.weex.bridge.EventResult eventResultFireEventWait = this.component.fireEventWait(str, mapCreateFireEventParam);
        if (eventResultFireEventWait.isSuccess() && eventResultFireEventWait.getResult() != null) {
            this.shouldBubbleResult = !com.taobao.weex.utils.WXUtils.getBoolean(eventResultFireEventWait.getResult(), java.lang.Boolean.valueOf(!this.shouldBubbleResult)).booleanValue();
        }
        this.shouldBubbleCallRemainTimes = this.shouldBubbleInterval;
        return this.shouldBubbleResult;
    }

    public void addOnTouchListener(android.view.View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            this.mTouchListeners.add(onTouchListener);
        }
    }

    public boolean removeTouchListener(android.view.View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            return this.mTouchListeners.remove(onTouchListener);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007f A[Catch: Exception -> 0x013e, TryCatch #0 {Exception -> 0x013e, blocks: (B:6:0x0008, B:8:0x0012, B:10:0x0018, B:11:0x001e, B:13:0x0024, B:14:0x0030, B:42:0x00f1, B:44:0x00f9, B:46:0x0101, B:48:0x010b, B:50:0x0113, B:51:0x011c, B:53:0x0120, B:55:0x013a, B:25:0x0047, B:27:0x005e, B:28:0x0077, B:29:0x007f, B:31:0x0096, B:32:0x00ae, B:34:0x00b6, B:36:0x00bc, B:38:0x00c8, B:39:0x00cb, B:41:0x00da), top: B:60:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0096 A[Catch: Exception -> 0x013e, TryCatch #0 {Exception -> 0x013e, blocks: (B:6:0x0008, B:8:0x0012, B:10:0x0018, B:11:0x001e, B:13:0x0024, B:14:0x0030, B:42:0x00f1, B:44:0x00f9, B:46:0x0101, B:48:0x010b, B:50:0x0113, B:51:0x011c, B:53:0x0120, B:55:0x013a, B:25:0x0047, B:27:0x005e, B:28:0x0077, B:29:0x007f, B:31:0x0096, B:32:0x00ae, B:34:0x00b6, B:36:0x00bc, B:38:0x00c8, B:39:0x00cb, B:41:0x00da), top: B:60:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00ae A[Catch: Exception -> 0x013e, TryCatch #0 {Exception -> 0x013e, blocks: (B:6:0x0008, B:8:0x0012, B:10:0x0018, B:11:0x001e, B:13:0x0024, B:14:0x0030, B:42:0x00f1, B:44:0x00f9, B:46:0x0101, B:48:0x010b, B:50:0x0113, B:51:0x011c, B:53:0x0120, B:55:0x013a, B:25:0x0047, B:27:0x005e, B:28:0x0077, B:29:0x007f, B:31:0x0096, B:32:0x00ae, B:34:0x00b6, B:36:0x00bc, B:38:0x00c8, B:39:0x00cb, B:41:0x00da), top: B:60:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00da A[Catch: Exception -> 0x013e, TryCatch #0 {Exception -> 0x013e, blocks: (B:6:0x0008, B:8:0x0012, B:10:0x0018, B:11:0x001e, B:13:0x0024, B:14:0x0030, B:42:0x00f1, B:44:0x00f9, B:46:0x0101, B:48:0x010b, B:50:0x0113, B:51:0x011c, B:53:0x0120, B:55:0x013a, B:25:0x0047, B:27:0x005e, B:28:0x0077, B:29:0x007f, B:31:0x0096, B:32:0x00ae, B:34:0x00b6, B:36:0x00bc, B:38:0x00c8, B:39:0x00cb, B:41:0x00da), top: B:60:0x0008 }] */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        android.view.ViewParent parent;
        boolean z;
        if (this.requestDisallowInterceptTouchEvent) {
            this.requestDisallowInterceptTouchEvent = false;
            return false;
        }
        try {
            boolean zOnTouchEvent = this.mGestureDetector.onTouchEvent(motionEvent);
            java.util.List<android.view.View.OnTouchListener> list = this.mTouchListeners;
            if (list != null && !list.isEmpty()) {
                java.util.Iterator<android.view.View.OnTouchListener> it = this.mTouchListeners.iterator();
                while (it.hasNext()) {
                    zOnTouchEvent |= it.next().onTouch(view, motionEvent);
                }
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.mIsTouchEventConsumed = false;
                if (hasSameOrientationWithParent() && !isParentScrollable() && (parent = this.component.getRealView().getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                zOnTouchEvent |= handleMotionEvent(com.taobao.weex.ui.view.gesture.WXGestureType.LowLevelGesture.ACTION_DOWN, motionEvent);
                if (this.component.isPreventGesture()) {
                    com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().setScrollable(this.component.getInstanceId(), false, this.component.getRef());
                }
            } else if (actionMasked == 1) {
                finishDisallowInterceptTouchEvent(view);
                zOnTouchEvent = zOnTouchEvent | handleMotionEvent(com.taobao.weex.ui.view.gesture.WXGestureType.LowLevelGesture.ACTION_UP, motionEvent) | handlePanMotionEvent(motionEvent);
                if (this.component.isPreventGesture()) {
                    com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().setScrollable(this.component.getInstanceId(), true, this.component.getRef());
                }
            } else if (actionMasked == 2) {
                zOnTouchEvent |= handleMotionEvent(com.taobao.weex.ui.view.gesture.WXGestureType.LowLevelGesture.ACTION_MOVE, motionEvent);
            } else if (actionMasked == 3) {
                finishDisallowInterceptTouchEvent(view);
                zOnTouchEvent = zOnTouchEvent | handleMotionEvent(com.taobao.weex.ui.view.gesture.WXGestureType.LowLevelGesture.ACTION_CANCEL, motionEvent) | handlePanMotionEvent(motionEvent);
                if (this.component.isPreventGesture()) {
                    com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().setScrollable(this.component.getInstanceId(), true, this.component.getRef());
                }
            } else if (actionMasked == 5) {
                this.mIsTouchEventConsumed = false;
                if (hasSameOrientationWithParent()) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                zOnTouchEvent |= handleMotionEvent(com.taobao.weex.ui.view.gesture.WXGestureType.LowLevelGesture.ACTION_DOWN, motionEvent);
                if (this.component.isPreventGesture()) {
                    com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().setScrollable(this.component.getInstanceId(), false, this.component.getRef());
                }
            } else if (actionMasked == 6) {
                finishDisallowInterceptTouchEvent(view);
                zOnTouchEvent = zOnTouchEvent | handleMotionEvent(com.taobao.weex.ui.view.gesture.WXGestureType.LowLevelGesture.ACTION_UP, motionEvent) | handlePanMotionEvent(motionEvent);
                if (this.component.isPreventGesture()) {
                    com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().setScrollable(this.component.getInstanceId(), true, this.component.getRef());
                }
            }
            if (hasStopPropagation(this.component)) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
                if (viewGroup != null) {
                    z = !shouldBubbleTouchEvent(motionEvent);
                    viewGroup.requestDisallowInterceptTouchEvent(z);
                } else {
                    z = false;
                }
                if (this.component.getParent() != null) {
                    this.component.getParent().requestDisallowInterceptTouchEvent(z);
                }
                if (this.mIsTouchEventConsumed && com.taobao.weex.utils.WXUtils.getBoolean(this.component.getAttrs().get("cancelTouchOnConsume"), false).booleanValue()) {
                    motionEvent.setAction(3);
                }
            }
            return zOnTouchEvent;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("Gesture RunTime Error ", e);
            return false;
        }
    }

    private java.lang.String getPanEventAction(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            return "start";
        }
        if (action == 1) {
            return "end";
        }
        if (action != 2) {
            return action != 3 ? "unknown" : "end";
        }
        return MOVE;
    }

    private void finishDisallowInterceptTouchEvent(android.view.View view) {
        if (view.getParent() != null) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    private boolean handlePanMotionEvent(android.view.MotionEvent motionEvent) {
        com.taobao.weex.ui.view.gesture.WXGestureType wXGestureType = this.mPendingPan;
        if (wXGestureType == null) {
            return false;
        }
        java.lang.String panEventAction = (wXGestureType == com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.HORIZONTALPAN || this.mPendingPan == com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.VERTICALPAN) ? getPanEventAction(motionEvent) : null;
        if (!this.component.containsGesture(this.mPendingPan)) {
            return false;
        }
        if (this.mIsPreventMoveEvent && MOVE.equals(panEventAction)) {
            return true;
        }
        java.util.Iterator<java.util.Map<java.lang.String, java.lang.Object>> it = createMultipleFireEventParam(motionEvent, panEventAction).iterator();
        while (it.hasNext()) {
            this.component.fireEvent(this.mPendingPan.toString(), it.next());
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.mPendingPan = null;
        }
        return true;
    }

    private boolean handleMotionEvent(com.taobao.weex.ui.view.gesture.WXGestureType wXGestureType, android.view.MotionEvent motionEvent) {
        if (this.component.getHover() != null) {
            this.component.getHover().handleMotionEvent(wXGestureType, motionEvent);
        }
        if (!this.component.containsGesture(wXGestureType)) {
            return false;
        }
        java.util.Iterator<java.util.Map<java.lang.String, java.lang.Object>> it = createMultipleFireEventParam(motionEvent, null).iterator();
        while (it.hasNext()) {
            this.component.fireEvent(wXGestureType.toString(), it.next());
        }
        return true;
    }

    private java.util.List<java.util.Map<java.lang.String, java.lang.Object>> createMultipleFireEventParam(android.view.MotionEvent motionEvent, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList(motionEvent.getHistorySize() + 1);
        arrayList.add(createFireEventParam(motionEvent, -1, str));
        return arrayList;
    }

    private java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getHistoricalEvents(android.view.MotionEvent motionEvent) {
        java.util.ArrayList arrayList = new java.util.ArrayList(motionEvent.getHistorySize());
        if (motionEvent.getActionMasked() == 2) {
            for (int i = 0; i < motionEvent.getHistorySize(); i++) {
                arrayList.add(createFireEventParam(motionEvent, i, null));
            }
        }
        return arrayList;
    }

    private java.util.Map<java.lang.String, java.lang.Object> createFireEventParam(android.view.MotionEvent motionEvent, int i, java.lang.String str) {
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray(motionEvent.getPointerCount());
        if (motionEvent.getActionMasked() == 2) {
            for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
                jSONArray.add(createJSONObject(motionEvent, i, i2));
            }
        } else if (isPointerNumChanged(motionEvent)) {
            jSONArray.add(createJSONObject(motionEvent, -1, motionEvent.getActionIndex()));
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.taobao.weex.ui.view.gesture.WXGestureType.GestureInfo.HISTORICAL_XY, jSONArray);
        if (str != null) {
            map.put("state", str);
        }
        return map;
    }

    private boolean isPointerNumChanged(android.view.MotionEvent motionEvent) {
        return motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 5 || motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 6 || motionEvent.getActionMasked() == 3;
    }

    private boolean containsSimplePan() {
        return this.component.containsGesture(com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.PAN_START) || this.component.containsGesture(com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.PAN_MOVE) || this.component.containsGesture(com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.PAN_END);
    }

    private com.alibaba.fastjson.JSONObject createJSONObject(android.view.MotionEvent motionEvent, int i, int i2) {
        android.graphics.PointF eventLocInScreenCoordinate;
        android.graphics.PointF eventLocInPageCoordinate;
        if (i == -1) {
            eventLocInPageCoordinate = getEventLocInPageCoordinate(motionEvent, i2);
            eventLocInScreenCoordinate = getEventLocInScreenCoordinate(motionEvent, i2);
        } else {
            android.graphics.PointF eventLocInPageCoordinate2 = getEventLocInPageCoordinate(motionEvent, i2, i);
            eventLocInScreenCoordinate = getEventLocInScreenCoordinate(motionEvent, i2, i);
            eventLocInPageCoordinate = eventLocInPageCoordinate2;
        }
        com.alibaba.fastjson.JSONObject jSONObjectCreateJSONObject = createJSONObject(eventLocInScreenCoordinate, eventLocInPageCoordinate, motionEvent.getPointerId(i2));
        float pressure = motionEvent.getPressure();
        if (pressure > 0.0f && pressure < 1.0f) {
            jSONObjectCreateJSONObject.put(io.dcloud.common.constant.AbsoluteConst.INSTALL_OPTIONS_FORCE, (java.lang.Object) java.lang.Float.valueOf(motionEvent.getPressure()));
        }
        return jSONObjectCreateJSONObject;
    }

    private com.alibaba.fastjson.JSONObject createJSONObject(android.graphics.PointF pointF, android.graphics.PointF pointF2, float f) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.taobao.weex.ui.view.gesture.WXGestureType.GestureInfo.PAGE_X, (java.lang.Object) java.lang.Float.valueOf(pointF2.x));
        jSONObject.put(com.taobao.weex.ui.view.gesture.WXGestureType.GestureInfo.PAGE_Y, (java.lang.Object) java.lang.Float.valueOf(pointF2.y));
        jSONObject.put(com.taobao.weex.ui.view.gesture.WXGestureType.GestureInfo.SCREEN_X, (java.lang.Object) java.lang.Float.valueOf(pointF.x));
        jSONObject.put(com.taobao.weex.ui.view.gesture.WXGestureType.GestureInfo.SCREEN_Y, (java.lang.Object) java.lang.Float.valueOf(pointF.y));
        jSONObject.put(com.taobao.weex.ui.view.gesture.WXGestureType.GestureInfo.POINTER_ID, (java.lang.Object) java.lang.Float.valueOf(f));
        return jSONObject;
    }

    private android.graphics.PointF getEventLocInScreenCoordinate(android.view.MotionEvent motionEvent, int i) {
        return getEventLocInScreenCoordinate(motionEvent, i, -1);
    }

    private android.graphics.PointF getEventLocInScreenCoordinate(android.view.MotionEvent motionEvent, int i, int i2) {
        float historicalY;
        float x;
        if (i2 == -1) {
            x = motionEvent.getX(i);
            historicalY = motionEvent.getY(i);
        } else {
            float historicalX = motionEvent.getHistoricalX(i, i2);
            historicalY = motionEvent.getHistoricalY(i, i2);
            x = historicalX;
        }
        return getEventLocInScreenCoordinate(x, historicalY);
    }

    private android.graphics.PointF getEventLocInScreenCoordinate(float f, float f2) {
        this.globalRect.set(0, 0, 0, 0);
        this.globalOffset.set(0, 0);
        this.globalEventOffset.set((int) f, (int) f2);
        this.component.getRealView().getGlobalVisibleRect(this.globalRect, this.globalOffset);
        this.globalEventOffset.offset(this.globalOffset.x, this.globalOffset.y);
        return new android.graphics.PointF(com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(this.globalEventOffset.x, this.component.getInstance().getInstanceViewPortWidthWithFloat()), com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(this.globalEventOffset.y, this.component.getInstance().getInstanceViewPortWidthWithFloat()));
    }

    private android.graphics.PointF getEventLocInPageCoordinate(android.view.MotionEvent motionEvent, int i) {
        return getEventLocInPageCoordinate(motionEvent, i, -1);
    }

    private android.graphics.PointF getEventLocInPageCoordinate(android.view.MotionEvent motionEvent, int i, int i2) {
        float historicalY;
        float x;
        if (i2 == -1) {
            x = motionEvent.getX(i);
            historicalY = motionEvent.getY(i);
        } else {
            float historicalX = motionEvent.getHistoricalX(i, i2);
            historicalY = motionEvent.getHistoricalY(i, i2);
            x = historicalX;
        }
        return getEventLocInPageCoordinate(x, historicalY);
    }

    private android.graphics.PointF getEventLocInPageCoordinate(float f, float f2) {
        this.locEventOffset.set(f, f2);
        this.locLeftTop.set(0.0f, 0.0f);
        this.component.computeVisiblePointInViewCoordinate(this.locLeftTop);
        this.locEventOffset.offset(this.locLeftTop.x, this.locLeftTop.y);
        return new android.graphics.PointF(com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(this.locEventOffset.x, this.component.getInstance().getInstanceViewPortWidthWithFloat()), com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(this.locEventOffset.y, this.component.getInstance().getInstanceViewPortWidthWithFloat()));
    }

    private static class GestureHandler extends android.os.Handler {
        public GestureHandler() {
            super(android.os.Looper.getMainLooper());
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(android.view.MotionEvent motionEvent) {
        if (this.component.containsGesture(com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.LONG_PRESS)) {
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> listCreateMultipleFireEventParam = createMultipleFireEventParam(motionEvent, null);
            this.component.getInstance().fireEvent(this.component.getRef(), com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.LONG_PRESS.toString(), listCreateMultipleFireEventParam.get(listCreateMultipleFireEventParam.size() - 1));
            this.mIsTouchEventConsumed = true;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
        com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture highLevelGesture;
        boolean zHandlePanMotionEvent;
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        if (java.lang.Math.abs(motionEvent2.getX() - motionEvent.getX()) > java.lang.Math.abs(motionEvent2.getY() - motionEvent.getY())) {
            highLevelGesture = com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.HORIZONTALPAN;
        } else {
            highLevelGesture = com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.VERTICALPAN;
        }
        if (this.mPendingPan == com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.HORIZONTALPAN || this.mPendingPan == com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.VERTICALPAN) {
            zHandlePanMotionEvent = handlePanMotionEvent(motionEvent2);
        } else {
            if (this.component.containsGesture(highLevelGesture)) {
                android.view.ViewParent parent = this.component.getRealView().getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                com.taobao.weex.ui.view.gesture.WXGestureType wXGestureType = this.mPendingPan;
                if (wXGestureType != null) {
                    handleMotionEvent(wXGestureType, motionEvent2);
                }
                this.mPendingPan = highLevelGesture;
                this.component.fireEvent(highLevelGesture.toString(), createFireEventParam(motionEvent2, -1, "start"));
            } else if (containsSimplePan()) {
                if (this.panDownTime != motionEvent.getEventTime()) {
                    this.panDownTime = motionEvent.getEventTime();
                    this.mPendingPan = com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.PAN_END;
                    this.component.fireEvent(com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.PAN_START.toString(), createFireEventParam(motionEvent, -1, null));
                } else {
                    this.component.fireEvent(com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.PAN_MOVE.toString(), createFireEventParam(motionEvent2, -1, null));
                }
            } else if (!this.component.containsGesture(com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.SWIPE) || this.swipeDownTime == motionEvent.getEventTime()) {
                zHandlePanMotionEvent = false;
            } else {
                this.swipeDownTime = motionEvent.getEventTime();
                java.util.List<java.util.Map<java.lang.String, java.lang.Object>> listCreateMultipleFireEventParam = createMultipleFireEventParam(motionEvent2, null);
                java.util.Map<java.lang.String, java.lang.Object> map = listCreateMultipleFireEventParam.get(listCreateMultipleFireEventParam.size() - 1);
                if (java.lang.Math.abs(f) > java.lang.Math.abs(f2)) {
                    map.put("direction", f > 0.0f ? "left" : "right");
                } else {
                    map.put("direction", f2 > 0.0f ? "up" : "down");
                }
                this.component.getInstance().fireEvent(this.component.getRef(), com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.SWIPE.toString(), map);
            }
            zHandlePanMotionEvent = true;
        }
        this.mIsTouchEventConsumed = this.mIsTouchEventConsumed || zHandlePanMotionEvent;
        return zHandlePanMotionEvent;
    }

    public boolean isRequestDisallowInterceptTouchEvent() {
        return this.requestDisallowInterceptTouchEvent;
    }

    public void setRequestDisallowInterceptTouchEvent(boolean z) {
        this.requestDisallowInterceptTouchEvent = z;
    }
}
