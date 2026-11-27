package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: loaded from: classes.dex */
public class BindingXTouchHandler extends com.alibaba.android.bindingx.core.internal.AbstractEventHandler implements android.view.View.OnTouchListener, android.view.GestureDetector.OnGestureListener {
    private long downTimeMillis;
    private float downX;
    private float downY;
    private boolean isFlickGestureAvailable;
    private boolean isPanGestureAvailable;
    private float mDownX;
    private float mDownY;
    private double mDx;
    private double mDy;
    private android.view.GestureDetector mGestureDetector;
    private int movetime;
    private int touchTime;
    private float upX;
    private float upY;

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityPause() {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityResume() {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(android.view.MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(android.view.MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(android.view.MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        return false;
    }

    public BindingXTouchHandler(android.content.Context context, com.alibaba.android.bindingx.core.PlatformManager platformManager, java.lang.Object... objArr) {
        super(context, platformManager, objArr);
        this.downTimeMillis = 0L;
        this.downX = 0.0f;
        this.downY = 0.0f;
        this.upX = 0.0f;
        this.upY = 0.0f;
        this.touchTime = 0;
        this.movetime = 0;
        this.mGestureDetector = new android.view.GestureDetector(context, this, new android.os.Handler(android.os.Looper.myLooper() == null ? android.os.Looper.getMainLooper() : android.os.Looper.myLooper()));
    }

    void setPanGestureAvailable(boolean z) {
        this.isPanGestureAvailable = z;
    }

    void setFlickGestureAvailable(boolean z) {
        this.isFlickGestureAvailable = z;
    }

    boolean isPanGestureAvailable() {
        return this.isPanGestureAvailable;
    }

    boolean isFlickGestureAvailable() {
        return this.isFlickGestureAvailable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        try {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.mDownX = motionEvent.getRawX();
                this.mDownY = motionEvent.getRawY();
                fireEventByState("start", 0.0d, 0.0d, new java.lang.Object[0]);
                this.downTimeMillis = java.lang.System.currentTimeMillis();
                this.downX = motionEvent.getRawX();
                this.downY = motionEvent.getRawY();
            } else if (actionMasked == 1) {
                this.mDownX = 0.0f;
                this.mDownY = 0.0f;
                this.upX = motionEvent.getRawX();
                this.upY = motionEvent.getRawY();
                clearExpressions();
                fireEventByState("end", this.mDx, this.mDy, new java.lang.Object[0]);
                this.mDx = 0.0d;
                this.mDy = 0.0d;
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    this.mDownX = 0.0f;
                    this.mDownY = 0.0f;
                    clearExpressions();
                    fireEventByState(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_CANCEL, this.mDx, this.mDy, new java.lang.Object[0]);
                }
            } else if (this.mDownX == 0.0f && this.mDownY == 0.0f) {
                this.mDownX = motionEvent.getRawX();
                this.mDownY = motionEvent.getRawY();
                fireEventByState("start", 0.0d, 0.0d, new java.lang.Object[0]);
            } else {
                this.mDx = motionEvent.getRawX() - this.mDownX;
                this.mDy = motionEvent.getRawY() - this.mDownY;
            }
        } catch (java.lang.Exception e) {
            com.alibaba.android.bindingx.core.LogProxy.e("runtime error ", e);
        }
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
        float rawY;
        float f3;
        this.movetime++;
        if (!this.isPanGestureAvailable) {
            com.alibaba.android.bindingx.core.LogProxy.d("pan gesture is not enabled");
            return false;
        }
        if (motionEvent == null) {
            f3 = this.mDownX;
            rawY = this.mDownY;
        } else {
            float rawX = motionEvent.getRawX();
            rawY = motionEvent.getRawY();
            f3 = rawX;
        }
        if (motionEvent2 == null) {
            return false;
        }
        float rawX2 = motionEvent2.getRawX() - f3;
        float rawY2 = motionEvent2.getRawY() - rawY;
        try {
            if (com.alibaba.android.bindingx.core.LogProxy.sEnableLog) {
                com.alibaba.android.bindingx.core.LogProxy.d(java.lang.String.format(java.util.Locale.getDefault(), "[TouchHandler] pan moved. (x:%f,y:%f)", java.lang.Float.valueOf(rawX2), java.lang.Float.valueOf(rawY2)));
            }
            com.alibaba.android.bindingx.core.internal.JSMath.applyXYToScope(this.mScope, rawX2, rawY2, this.mPlatformManager.getResolutionTranslator());
            if (!evaluateExitExpression(this.mExitExpressionPair, this.mScope)) {
                consumeExpression(this.mExpressionHoldersMap, this.mScope, "pan");
            }
        } catch (java.lang.Exception e) {
            com.alibaba.android.bindingx.core.LogProxy.e("runtime error", e);
        }
        return false;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onCreate(java.lang.String str, java.lang.String str2) {
        android.view.View viewFindViewBy = this.mPlatformManager.getViewFinder().findViewBy(str, android.text.TextUtils.isEmpty(this.mAnchorInstanceId) ? this.mInstanceId : this.mAnchorInstanceId);
        if (viewFindViewBy == null) {
            com.alibaba.android.bindingx.core.LogProxy.e("[ExpressionTouchHandler] onCreate failed. sourceView not found:" + str);
            return false;
        }
        this.movetime = 0;
        viewFindViewBy.setOnTouchListener(this);
        try {
            java.lang.reflect.Method declaredMethod = viewFindViewBy.getClass().getDeclaredMethod("addPan", java.lang.Object.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(viewFindViewBy, this);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.alibaba.android.bindingx.core.LogProxy.d("[ExpressionTouchHandler] onCreate success. {source:" + str + ",type:" + str2 + com.taobao.weex.el.parse.Operators.BLOCK_END_STR);
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onStart(java.lang.String str, java.lang.String str2) {
        str2.hashCode();
        if (str2.equals("pan")) {
            setPanGestureAvailable(true);
        } else if (str2.equals(com.alibaba.android.bindingx.core.BindingXEventType.TYPE_FLICK)) {
            setFlickGestureAvailable(true);
        }
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onBindExpression(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list, com.alibaba.android.bindingx.core.BindingXCore.JavaScriptCallback javaScriptCallback) {
        super.onBindExpression(str, map, expressionPair, list, javaScriptCallback);
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onDisable(java.lang.String str, java.lang.String str2) {
        str2.hashCode();
        if (str2.equals("pan")) {
            setPanGestureAvailable(false);
        } else if (str2.equals(com.alibaba.android.bindingx.core.BindingXEventType.TYPE_FLICK)) {
            setFlickGestureAvailable(false);
        }
        if (isPanGestureAvailable() || isFlickGestureAvailable()) {
            return false;
        }
        android.view.View viewFindViewBy = this.mPlatformManager.getViewFinder().findViewBy(str, android.text.TextUtils.isEmpty(this.mAnchorInstanceId) ? this.mInstanceId : this.mAnchorInstanceId);
        if (viewFindViewBy != null) {
            viewFindViewBy.setOnTouchListener(null);
            this.movetime = 0;
            try {
                java.lang.reflect.Method declaredMethod = viewFindViewBy.getClass().getDeclaredMethod("removePan", null);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(viewFindViewBy, null);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        com.alibaba.android.bindingx.core.LogProxy.d("remove touch listener success.[" + str + "," + str2 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onDestroy() {
        super.onDestroy();
        if (this.mExpressionHoldersMap != null) {
            this.mExpressionHoldersMap.clear();
            this.mExpressionHoldersMap = null;
        }
        this.mExitExpressionPair = null;
        this.mCallback = null;
        this.isFlickGestureAvailable = false;
        this.isPanGestureAvailable = false;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void onExit(java.util.Map<java.lang.String, java.lang.Object> map) {
        fireEventByState(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_EXIT, ((java.lang.Double) map.get("internal_x")).doubleValue(), ((java.lang.Double) map.get("internal_y")).doubleValue(), new java.lang.Object[0]);
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void onUserIntercept(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        fireEventByState(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_INTERCEPTOR, ((java.lang.Double) map.get("internal_x")).doubleValue(), ((java.lang.Double) map.get("internal_y")).doubleValue(), java.util.Collections.singletonMap(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_INTERCEPTOR, str));
    }

    private void fireEventByState(java.lang.String str, double d, double d2, java.lang.Object... objArr) {
        if (this.mCallback != null) {
            java.util.HashMap map = new java.util.HashMap();
            map.put("state", str);
            double dNativeToWeb = this.mPlatformManager.getResolutionTranslator().nativeToWeb(d, new java.lang.Object[0]);
            double dNativeToWeb2 = this.mPlatformManager.getResolutionTranslator().nativeToWeb(d2, new java.lang.Object[0]);
            map.put("deltaX", java.lang.Double.valueOf(dNativeToWeb));
            map.put("deltaY", java.lang.Double.valueOf(dNativeToWeb2));
            map.put(com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_TOKEN, this.mToken);
            if (objArr != null && objArr.length > 0) {
                java.lang.Object obj = objArr[0];
                if (obj instanceof java.util.Map) {
                    map.putAll((java.util.Map) obj);
                }
            }
            this.mCallback.callback(map);
            com.alibaba.android.bindingx.core.LogProxy.d(">>>>>>>>>>>fire event:(" + str + "," + dNativeToWeb + "," + dNativeToWeb2 + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        }
    }
}
