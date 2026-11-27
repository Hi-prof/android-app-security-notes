package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractScrollEventHandler extends com.alibaba.android.bindingx.core.internal.AbstractEventHandler {
    private boolean isStart;
    protected int mContentOffsetX;
    protected int mContentOffsetY;

    public AbstractScrollEventHandler(android.content.Context context, com.alibaba.android.bindingx.core.PlatformManager platformManager, java.lang.Object... objArr) {
        super(context, platformManager, objArr);
        this.isStart = false;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onDisable(java.lang.String str, java.lang.String str2) {
        clearExpressions();
        this.isStart = false;
        fireEventByState("end", this.mContentOffsetX, this.mContentOffsetY, 0.0d, 0.0d, 0.0d, 0.0d, new java.lang.Object[0]);
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void onExit(java.util.Map<java.lang.String, java.lang.Object> map) {
        fireEventByState(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_EXIT, ((java.lang.Double) map.get("internal_x")).doubleValue(), ((java.lang.Double) map.get("internal_y")).doubleValue(), 0.0d, 0.0d, 0.0d, 0.0d, new java.lang.Object[0]);
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void onUserIntercept(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        fireEventByState(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_INTERCEPTOR, ((java.lang.Double) map.get("internal_x")).doubleValue(), ((java.lang.Double) map.get("internal_y")).doubleValue(), ((java.lang.Double) map.get("dx")).doubleValue(), ((java.lang.Double) map.get(com.taobao.weex.common.Constants.Name.DISTANCE_Y)).doubleValue(), ((java.lang.Double) map.get("tdx")).doubleValue(), ((java.lang.Double) map.get("tdy")).doubleValue(), java.util.Collections.singletonMap(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_INTERCEPTOR, str));
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onDestroy() {
        super.onDestroy();
        this.isStart = false;
    }

    protected void handleScrollEvent(int i, int i2, int i3, int i4, int i5, int i6) {
        if (com.alibaba.android.bindingx.core.LogProxy.sEnableLog) {
            com.alibaba.android.bindingx.core.LogProxy.d(java.lang.String.format(java.util.Locale.getDefault(), "[ScrollHandler] scroll changed. (contentOffsetX:%d,contentOffsetY:%d,dx:%d,dy:%d,tdx:%d,tdy:%d)", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf(i5), java.lang.Integer.valueOf(i6)));
        }
        this.mContentOffsetX = i;
        this.mContentOffsetY = i2;
        if (!this.isStart) {
            this.isStart = true;
            fireEventByState("start", i, i2, i3, i4, i5, i6, new java.lang.Object[0]);
        }
        try {
            com.alibaba.android.bindingx.core.internal.JSMath.applyScrollValuesToScope(this.mScope, i, i2, i3, i4, i5, i6, this.mPlatformManager.getResolutionTranslator());
            if (evaluateExitExpression(this.mExitExpressionPair, this.mScope)) {
                return;
            }
            consumeExpression(this.mExpressionHoldersMap, this.mScope, "scroll");
        } catch (java.lang.Exception e) {
            com.alibaba.android.bindingx.core.LogProxy.e("runtime error", e);
        }
    }

    protected void fireEventByState(java.lang.String str, double d, double d2, double d3, double d4, double d5, double d6, java.lang.Object... objArr) {
        if (this.mCallback != null) {
            java.util.HashMap map = new java.util.HashMap();
            map.put("state", str);
            double dNativeToWeb = this.mPlatformManager.getResolutionTranslator().nativeToWeb(d, new java.lang.Object[0]);
            double dNativeToWeb2 = this.mPlatformManager.getResolutionTranslator().nativeToWeb(d2, new java.lang.Object[0]);
            map.put(com.taobao.weex.common.Constants.Name.X, java.lang.Double.valueOf(dNativeToWeb));
            map.put(com.taobao.weex.common.Constants.Name.Y, java.lang.Double.valueOf(dNativeToWeb2));
            double dNativeToWeb3 = this.mPlatformManager.getResolutionTranslator().nativeToWeb(d3, new java.lang.Object[0]);
            double dNativeToWeb4 = this.mPlatformManager.getResolutionTranslator().nativeToWeb(d4, new java.lang.Object[0]);
            map.put("dx", java.lang.Double.valueOf(dNativeToWeb3));
            map.put(com.taobao.weex.common.Constants.Name.DISTANCE_Y, java.lang.Double.valueOf(dNativeToWeb4));
            double dNativeToWeb5 = this.mPlatformManager.getResolutionTranslator().nativeToWeb(d5, new java.lang.Object[0]);
            double dNativeToWeb6 = this.mPlatformManager.getResolutionTranslator().nativeToWeb(d6, new java.lang.Object[0]);
            map.put("tdx", java.lang.Double.valueOf(dNativeToWeb5));
            map.put("tdy", java.lang.Double.valueOf(dNativeToWeb6));
            map.put(com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_TOKEN, this.mToken);
            if (objArr != null && objArr.length > 0) {
                java.lang.Object obj = objArr[0];
                if (obj instanceof java.util.Map) {
                    map.putAll((java.util.Map) obj);
                }
            }
            this.mCallback.callback(map);
            com.alibaba.android.bindingx.core.LogProxy.d(">>>>>>>>>>>fire event:(" + str + "," + dNativeToWeb + "," + dNativeToWeb2 + "," + dNativeToWeb3 + "," + dNativeToWeb4 + "," + dNativeToWeb5 + "," + dNativeToWeb6 + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        }
    }
}
