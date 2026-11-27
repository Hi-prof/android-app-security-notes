package com.taobao.weex.ui.flat;

/* JADX INFO: loaded from: classes.dex */
public abstract class WidgetContainer<T extends android.view.ViewGroup> extends com.taobao.weex.ui.component.WXVContainer<T> {
    protected java.util.List<com.taobao.weex.ui.flat.widget.Widget> widgets;

    public boolean intendToBeFlatContainer() {
        return false;
    }

    protected abstract void mountFlatGUI();

    protected abstract void unmountFlatGUI();

    public WidgetContainer(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void createChildViewAt(int i) {
        com.taobao.weex.ui.flat.widget.Widget orCreateFlatWidget;
        if (intendToBeFlatContainer()) {
            android.util.Pair<com.taobao.weex.ui.component.WXComponent, java.lang.Integer> pairRearrangeIndexAndGetChild = rearrangeIndexAndGetChild(i);
            if (pairRearrangeIndexAndGetChild.first != null) {
                com.taobao.weex.ui.component.WXComponent wXComponent = (com.taobao.weex.ui.component.WXComponent) pairRearrangeIndexAndGetChild.first;
                com.taobao.weex.ui.flat.FlatGUIContext flatUIContext = getInstance().getFlatUIContext();
                com.taobao.weex.ui.flat.WidgetContainer flatComponentAncestor = flatUIContext.getFlatComponentAncestor(this);
                if (flatComponentAncestor == null || flatUIContext.getAndroidViewWidget(this) != null) {
                    flatComponentAncestor = this;
                }
                flatUIContext.register(wXComponent, flatComponentAncestor);
                if (wXComponent instanceof com.taobao.weex.ui.flat.FlatComponent) {
                    com.taobao.weex.ui.flat.FlatComponent flatComponent = (com.taobao.weex.ui.flat.FlatComponent) wXComponent;
                    if (!flatComponent.promoteToView(false)) {
                        orCreateFlatWidget = flatComponent.getOrCreateFlatWidget();
                    } else {
                        com.taobao.weex.ui.flat.widget.AndroidViewWidget androidViewWidget = new com.taobao.weex.ui.flat.widget.AndroidViewWidget(flatUIContext);
                        flatUIContext.register(wXComponent, androidViewWidget);
                        wXComponent.createView();
                        androidViewWidget.setContentView(wXComponent.getHostView());
                        flatComponentAncestor.addSubView(wXComponent.getHostView(), -1);
                        orCreateFlatWidget = androidViewWidget;
                    }
                } else {
                    com.taobao.weex.ui.flat.widget.AndroidViewWidget androidViewWidget2 = new com.taobao.weex.ui.flat.widget.AndroidViewWidget(flatUIContext);
                    flatUIContext.register(wXComponent, androidViewWidget2);
                    wXComponent.createView();
                    androidViewWidget2.setContentView(wXComponent.getHostView());
                    flatComponentAncestor.addSubView(wXComponent.getHostView(), -1);
                    orCreateFlatWidget = androidViewWidget2;
                }
                flatUIContext.register(orCreateFlatWidget, wXComponent);
                addFlatChild(orCreateFlatWidget, ((java.lang.Integer) pairRearrangeIndexAndGetChild.second).intValue());
                return;
            }
            return;
        }
        super.createChildViewAt(i);
    }

    private void addFlatChild(com.taobao.weex.ui.flat.widget.Widget widget, int i) {
        if (this.widgets == null) {
            this.widgets = new java.util.LinkedList();
        }
        if (i >= this.widgets.size()) {
            this.widgets.add(widget);
        } else {
            this.widgets.add(i, widget);
        }
        mountFlatGUI();
    }
}
