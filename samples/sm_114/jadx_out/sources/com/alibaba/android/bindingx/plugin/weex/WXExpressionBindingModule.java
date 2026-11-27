package com.alibaba.android.bindingx.plugin.weex;

/* JADX INFO: loaded from: classes.dex */
@java.lang.Deprecated
public final class WXExpressionBindingModule extends com.taobao.weex.WXSDKEngine.DestroyableModule {
    private com.alibaba.android.bindingx.core.BindingXCore mExpressionBindingCore;
    private com.alibaba.android.bindingx.core.PlatformManager mPlatformManager;

    @com.taobao.weex.annotation.JSMethod
    @java.lang.Deprecated
    public void enableBinding(java.lang.String str, java.lang.String str2) {
        if (this.mPlatformManager == null) {
            this.mPlatformManager = com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.createPlatformManager(this.mWXSDKInstance);
        }
        if (this.mExpressionBindingCore == null) {
            com.alibaba.android.bindingx.core.BindingXCore bindingXCore = new com.alibaba.android.bindingx.core.BindingXCore(this.mPlatformManager);
            this.mExpressionBindingCore = bindingXCore;
            bindingXCore.registerEventHandler("scroll", new com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator<com.alibaba.android.bindingx.core.IEventHandler, android.content.Context, com.alibaba.android.bindingx.core.PlatformManager>() { // from class: com.alibaba.android.bindingx.plugin.weex.WXExpressionBindingModule.1
                @Override // com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator
                public com.alibaba.android.bindingx.core.IEventHandler createWith(android.content.Context context, com.alibaba.android.bindingx.core.PlatformManager platformManager, java.lang.Object... objArr) {
                    return new com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler(context, platformManager, objArr);
                }
            });
        }
    }

    @com.taobao.weex.annotation.JSMethod
    @java.lang.Deprecated
    public void createBinding(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list, final com.taobao.weex.bridge.JSCallback jSCallback) {
        enableBinding(null, null);
        this.mExpressionBindingCore.doBind(str, null, str2, null, com.alibaba.android.bindingx.core.internal.ExpressionPair.create(null, str3), list, null, new com.alibaba.android.bindingx.core.BindingXCore.JavaScriptCallback() { // from class: com.alibaba.android.bindingx.plugin.weex.WXExpressionBindingModule.2
            @Override // com.alibaba.android.bindingx.core.BindingXCore.JavaScriptCallback
            public void callback(java.lang.Object obj) {
                com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                if (jSCallback2 != null) {
                    jSCallback2.invokeAndKeepAlive(obj);
                }
            }
        }, this.mWXSDKInstance == null ? null : this.mWXSDKInstance.getContext(), this.mWXSDKInstance != null ? this.mWXSDKInstance.getInstanceId() : null, new java.lang.Object[0]);
    }

    @com.taobao.weex.annotation.JSMethod
    @java.lang.Deprecated
    public void disableBinding(java.lang.String str, java.lang.String str2) {
        com.alibaba.android.bindingx.core.BindingXCore bindingXCore = this.mExpressionBindingCore;
        if (bindingXCore != null) {
            bindingXCore.doUnbind(str, str2);
        }
    }

    @com.taobao.weex.annotation.JSMethod
    @java.lang.Deprecated
    public void disableAll() {
        com.alibaba.android.bindingx.core.BindingXCore bindingXCore = this.mExpressionBindingCore;
        if (bindingXCore != null) {
            bindingXCore.doRelease();
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        com.alibaba.android.bindingx.core.BindingXCore bindingXCore = this.mExpressionBindingCore;
        if (bindingXCore != null) {
            bindingXCore.doRelease();
            this.mExpressionBindingCore = null;
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityPause() {
        com.alibaba.android.bindingx.core.BindingXCore bindingXCore = this.mExpressionBindingCore;
        if (bindingXCore != null) {
            bindingXCore.onActivityPause();
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityResume() {
        com.alibaba.android.bindingx.core.BindingXCore bindingXCore = this.mExpressionBindingCore;
        if (bindingXCore != null) {
            bindingXCore.onActivityResume();
        }
    }
}
