package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXDiv extends com.taobao.weex.ui.flat.WidgetContainer<com.taobao.weex.ui.view.WXFrameLayout> implements com.taobao.weex.ui.flat.FlatComponent<com.taobao.weex.ui.flat.widget.WidgetGroup> {
    private com.taobao.weex.ui.flat.widget.WidgetGroup mWidgetGroup;

    public static class Ceator implements com.taobao.weex.ui.ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public com.taobao.weex.ui.component.WXComponent createInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
            return new com.taobao.weex.ui.component.WXDiv(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    @java.lang.Deprecated
    public WXDiv(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, basicComponentData);
    }

    public WXDiv(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public com.taobao.weex.ui.view.WXFrameLayout initComponentHostView(android.content.Context context) {
        com.taobao.weex.ui.view.WXFrameLayout wXFrameLayout = new com.taobao.weex.ui.view.WXFrameLayout(context);
        wXFrameLayout.holdComponent(this);
        return wXFrameLayout;
    }

    @Override // com.taobao.weex.ui.flat.FlatComponent
    public boolean promoteToView(boolean z) {
        if (getInstance().getFlatUIContext() != null) {
            return !intendToBeFlatContainer() || getInstance().getFlatUIContext().promoteToView(this, z, com.taobao.weex.ui.component.WXDiv.class);
        }
        return false;
    }

    @Override // com.taobao.weex.ui.flat.FlatComponent
    public com.taobao.weex.ui.flat.widget.WidgetGroup getOrCreateFlatWidget() {
        if (this.mWidgetGroup == null) {
            this.mWidgetGroup = new com.taobao.weex.ui.flat.widget.WidgetGroup(getInstance().getFlatUIContext());
            for (int i = 0; i < getChildCount(); i++) {
                createChildViewAt(i);
            }
            mountFlatGUI();
        }
        return this.mWidgetGroup;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.flat.WidgetContainer
    protected void mountFlatGUI() {
        if (this.widgets == null) {
            this.widgets = new java.util.LinkedList();
        }
        if (promoteToView(true)) {
            if (getHostView() != 0) {
                ((com.taobao.weex.ui.view.WXFrameLayout) getHostView()).mountFlatGUI(this.widgets);
                return;
            }
            return;
        }
        this.mWidgetGroup.replaceAll(this.widgets);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.flat.WidgetContainer
    public void unmountFlatGUI() {
        if (getHostView() != 0) {
            ((com.taobao.weex.ui.view.WXFrameLayout) getHostView()).unmountFlatGUI();
        }
    }

    @Override // com.taobao.weex.ui.flat.WidgetContainer
    public boolean intendToBeFlatContainer() {
        return getInstance().getFlatUIContext().isFlatUIEnabled(this) && com.taobao.weex.ui.component.WXDiv.class.equals(getClass());
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean isVirtualComponent() {
        return true ^ promoteToView(true);
    }
}
