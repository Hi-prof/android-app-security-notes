package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: loaded from: classes.dex */
public class BindingXTimingHandler extends com.alibaba.android.bindingx.core.internal.AbstractEventHandler implements com.alibaba.android.bindingx.core.internal.AnimationFrame.Callback {
    private boolean isFinish;
    private com.alibaba.android.bindingx.core.internal.AnimationFrame mAnimationFrame;
    private long mStartTime;

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityPause() {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityResume() {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onCreate(java.lang.String str, java.lang.String str2) {
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onStart(java.lang.String str, java.lang.String str2) {
    }

    public BindingXTimingHandler(android.content.Context context, com.alibaba.android.bindingx.core.PlatformManager platformManager, java.lang.Object... objArr) {
        super(context, platformManager, objArr);
        this.mStartTime = 0L;
        this.isFinish = false;
        com.alibaba.android.bindingx.core.internal.AnimationFrame animationFrame = this.mAnimationFrame;
        if (animationFrame == null) {
            this.mAnimationFrame = com.alibaba.android.bindingx.core.internal.AnimationFrame.newInstance();
        } else {
            animationFrame.clear();
        }
    }

    BindingXTimingHandler(android.content.Context context, com.alibaba.android.bindingx.core.PlatformManager platformManager, com.alibaba.android.bindingx.core.internal.AnimationFrame animationFrame, java.lang.Object... objArr) {
        super(context, platformManager, objArr);
        this.mStartTime = 0L;
        this.isFinish = false;
        this.mAnimationFrame = animationFrame;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onBindExpression(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list, com.alibaba.android.bindingx.core.BindingXCore.JavaScriptCallback javaScriptCallback) {
        super.onBindExpression(str, map, expressionPair, list, javaScriptCallback);
        if (this.mAnimationFrame == null) {
            this.mAnimationFrame = com.alibaba.android.bindingx.core.internal.AnimationFrame.newInstance();
        }
        fireEventByState("start", 0L, new java.lang.Object[0]);
        this.mAnimationFrame.clear();
        this.mAnimationFrame.requestAnimationFrame(this);
    }

    private void handleTimingCallback() {
        long jCurrentAnimationTimeMillis = 0;
        if (this.mStartTime == 0) {
            this.mStartTime = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            this.isFinish = false;
        } else {
            jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
        }
        try {
            if (com.alibaba.android.bindingx.core.LogProxy.sEnableLog) {
                com.alibaba.android.bindingx.core.LogProxy.d(java.lang.String.format(java.util.Locale.getDefault(), "[TimingHandler] timing elapsed. (t:%d)", java.lang.Long.valueOf(jCurrentAnimationTimeMillis)));
            }
            com.alibaba.android.bindingx.core.internal.JSMath.applyTimingValuesToScope(this.mScope, jCurrentAnimationTimeMillis);
            if (!this.isFinish) {
                consumeExpression(this.mExpressionHoldersMap, this.mScope, com.alibaba.android.bindingx.core.BindingXEventType.TYPE_TIMING);
            }
            this.isFinish = evaluateExitExpression(this.mExitExpressionPair, this.mScope);
        } catch (java.lang.Exception e) {
            com.alibaba.android.bindingx.core.LogProxy.e("runtime error", e);
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onDisable(java.lang.String str, java.lang.String str2) {
        fireEventByState("end", java.lang.System.currentTimeMillis() - this.mStartTime, new java.lang.Object[0]);
        clearExpressions();
        com.alibaba.android.bindingx.core.internal.AnimationFrame animationFrame = this.mAnimationFrame;
        if (animationFrame != null) {
            animationFrame.clear();
        }
        this.mStartTime = 0L;
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onDestroy() {
        super.onDestroy();
        clearExpressions();
        com.alibaba.android.bindingx.core.internal.AnimationFrame animationFrame = this.mAnimationFrame;
        if (animationFrame != null) {
            animationFrame.terminate();
            this.mAnimationFrame = null;
        }
        this.mStartTime = 0L;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void onExit(java.util.Map<java.lang.String, java.lang.Object> map) {
        fireEventByState(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_EXIT, (long) ((java.lang.Double) map.get("t")).doubleValue(), new java.lang.Object[0]);
        com.alibaba.android.bindingx.core.internal.AnimationFrame animationFrame = this.mAnimationFrame;
        if (animationFrame != null) {
            animationFrame.clear();
        }
        this.mStartTime = 0L;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void onUserIntercept(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        fireEventByState(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_INTERCEPTOR, (long) ((java.lang.Double) map.get("t")).doubleValue(), java.util.Collections.singletonMap(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_INTERCEPTOR, str));
    }

    private void fireEventByState(java.lang.String str, long j, java.lang.Object... objArr) {
        if (this.mCallback != null) {
            java.util.HashMap map = new java.util.HashMap();
            map.put("state", str);
            map.put("t", java.lang.Long.valueOf(j));
            map.put(com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_TOKEN, this.mToken);
            if (objArr != null && objArr.length > 0) {
                java.lang.Object obj = objArr[0];
                if (obj instanceof java.util.Map) {
                    map.putAll((java.util.Map) obj);
                }
            }
            this.mCallback.callback(map);
            com.alibaba.android.bindingx.core.LogProxy.d(">>>>>>>>>>>fire event:(" + str + "," + j + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        }
    }

    @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame.Callback
    public void doFrame() {
        handleTimingCallback();
    }
}
