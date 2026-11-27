package com.taobao.weex.ui;

/* JADX INFO: loaded from: classes.dex */
class RenderContextImpl implements com.taobao.weex.dom.RenderContext {
    private com.taobao.weex.WXSDKInstance mWXSDKInstance;
    private java.util.Map<java.lang.String, com.taobao.weex.ui.component.WXComponent> mRegistry = new java.util.concurrent.ConcurrentHashMap();
    private java.util.List<com.taobao.weex.ui.component.DCWXScroller> mScrollers = new java.util.concurrent.CopyOnWriteArrayList();
    private java.util.Map<java.lang.String, com.taobao.weex.ui.component.WXComponent> mIdComponent = new java.util.concurrent.ConcurrentHashMap();

    public RenderContextImpl(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        this.mWXSDKInstance = wXSDKInstance;
    }

    public void destroy() {
        this.mWXSDKInstance = null;
        try {
            this.mRegistry.clear();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public com.taobao.weex.WXSDKInstance getWXSDKInstance() {
        return this.mWXSDKInstance;
    }

    @Override // com.taobao.weex.dom.RenderContext
    public com.taobao.weex.WXSDKInstance getInstance() {
        return this.mWXSDKInstance;
    }

    @Override // com.taobao.weex.dom.RenderContext
    public com.taobao.weex.ui.component.WXComponent getComponent(java.lang.String str) {
        return this.mRegistry.get(str);
    }

    public com.taobao.weex.ui.component.WXComponent getComponentById(java.lang.String str) {
        return this.mIdComponent.get(str);
    }

    public void registerComponent(java.lang.String str, com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (wXComponent instanceof com.taobao.weex.ui.component.DCWXScroller) {
            this.mScrollers.add((com.taobao.weex.ui.component.DCWXScroller) wXComponent);
        }
        if (wXComponent.getAttrs().containsKey("id")) {
            java.lang.String str2 = (java.lang.String) wXComponent.getAttrs().get("id");
            if (!android.text.TextUtils.isEmpty(str2)) {
                this.mIdComponent.put(str2, wXComponent);
            }
        }
        this.mRegistry.put(str, wXComponent);
    }

    @Override // com.taobao.weex.dom.RenderContext
    public com.taobao.weex.ui.component.WXComponent unregisterComponent(java.lang.String str) {
        return this.mRegistry.remove(str);
    }

    public void setAllScrollerScrollable(boolean z, java.lang.String str) {
        if (this.mScrollers.size() > 0) {
            java.lang.Object parentScroller = getComponent(str).getParentScroller();
            while (parentScroller != null) {
                if (parentScroller instanceof com.taobao.weex.ui.component.DCWXScroller) {
                    com.taobao.weex.ui.component.DCWXScroller dCWXScroller = (com.taobao.weex.ui.component.DCWXScroller) parentScroller;
                    android.view.ViewGroup innerView = dCWXScroller.getInnerView();
                    if (innerView instanceof io.dcloud.feature.weex_scroller.view.DCWXScrollView) {
                        ((io.dcloud.feature.weex_scroller.view.DCWXScrollView) innerView).setScrollable(z);
                    }
                    parentScroller = dCWXScroller.getParentScroller();
                } else {
                    parentScroller = ((com.taobao.weex.ui.component.WXComponent) parentScroller).getParentScroller();
                }
            }
        }
    }

    public int getComponentCount() {
        return this.mRegistry.size();
    }
}
