package com.alibaba.android.bindingx.plugin.weex;

/* JADX INFO: loaded from: classes.dex */
public class BindingXGestureHandler extends com.alibaba.android.bindingx.core.internal.BindingXTouchHandler {
    private boolean experimental;
    private com.taobao.weex.ui.view.gesture.WXGesture mWeexGestureHandler;

    public BindingXGestureHandler(android.content.Context context, com.alibaba.android.bindingx.core.PlatformManager platformManager, java.lang.Object... objArr) {
        super(context, platformManager, objArr);
        this.experimental = false;
        this.mWeexGestureHandler = null;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void setGlobalConfig(java.util.Map<java.lang.String, java.lang.Object> map) {
        super.setGlobalConfig(map);
        if (map != null) {
            this.experimental = com.taobao.weex.utils.WXUtils.getBoolean(map.get("experimentalGestureFeatures"), false).booleanValue();
        }
    }

    @Override // com.alibaba.android.bindingx.core.internal.BindingXTouchHandler, com.alibaba.android.bindingx.core.IEventHandler
    public boolean onCreate(java.lang.String str, java.lang.String str2) {
        if (!this.experimental) {
            return super.onCreate(str, str2);
        }
        com.taobao.weex.ui.component.WXComponent wXComponentFindComponentByRef = com.alibaba.android.bindingx.plugin.weex.WXModuleUtils.findComponentByRef(android.text.TextUtils.isEmpty(this.mAnchorInstanceId) ? this.mInstanceId : this.mAnchorInstanceId, str);
        if (wXComponentFindComponentByRef == null) {
            return super.onCreate(str, str2);
        }
        android.view.KeyEvent.Callback hostView = wXComponentFindComponentByRef.getHostView();
        if (!(hostView instanceof android.view.ViewGroup) || !(hostView instanceof com.taobao.weex.ui.view.gesture.WXGestureObservable)) {
            return super.onCreate(str, str2);
        }
        try {
            com.taobao.weex.ui.view.gesture.WXGesture gestureListener = ((com.taobao.weex.ui.view.gesture.WXGestureObservable) hostView).getGestureListener();
            this.mWeexGestureHandler = gestureListener;
            if (gestureListener != null) {
                gestureListener.addOnTouchListener(this);
                com.alibaba.android.bindingx.core.LogProxy.d("[ExpressionGestureHandler] onCreate success. {source:" + str + ",type:" + str2 + com.taobao.weex.el.parse.Operators.BLOCK_END_STR);
                return true;
            }
            return super.onCreate(str, str2);
        } catch (java.lang.Throwable th) {
            com.alibaba.android.bindingx.core.LogProxy.e("experimental gesture features open failed." + th.getMessage());
            return super.onCreate(str, str2);
        }
    }

    @Override // com.alibaba.android.bindingx.core.internal.BindingXTouchHandler, com.alibaba.android.bindingx.core.IEventHandler
    public boolean onDisable(java.lang.String str, java.lang.String str2) {
        com.taobao.weex.ui.view.gesture.WXGesture wXGesture;
        boolean zOnDisable = super.onDisable(str, str2);
        if (this.experimental && (wXGesture = this.mWeexGestureHandler) != null) {
            try {
                return zOnDisable | wXGesture.removeTouchListener(this);
            } catch (java.lang.Throwable th) {
                com.alibaba.android.bindingx.core.LogProxy.e("[ExpressionGestureHandler]  disabled failed." + th.getMessage());
            }
        }
        return zOnDisable;
    }
}
