package com.taobao.weex.ui.flat;

/* JADX INFO: loaded from: classes.dex */
public class FlatGUIContext implements com.taobao.weex.common.Destroyable {
    private java.util.Map<com.taobao.weex.ui.component.WXComponent, com.taobao.weex.ui.flat.WidgetContainer> mWidgetRegistry = new androidx.collection.ArrayMap();
    private java.util.Map<com.taobao.weex.ui.component.WXComponent, com.taobao.weex.ui.flat.widget.AndroidViewWidget> mViewWidgetRegistry = new androidx.collection.ArrayMap();
    private java.util.Map<com.taobao.weex.ui.flat.widget.Widget, com.taobao.weex.ui.component.WXComponent> widgetToComponent = new androidx.collection.ArrayMap();

    public boolean isFlatUIEnabled(com.taobao.weex.ui.component.WXComponent wXComponent) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void register(com.taobao.weex.ui.component.WXComponent wXComponent, com.taobao.weex.ui.flat.WidgetContainer widgetContainer) {
        if (!(widgetContainer instanceof com.taobao.weex.ui.flat.FlatComponent) || ((com.taobao.weex.ui.flat.FlatComponent) widgetContainer).promoteToView(true)) {
            this.mWidgetRegistry.put(wXComponent, widgetContainer);
        }
    }

    public void register(com.taobao.weex.ui.component.WXComponent wXComponent, com.taobao.weex.ui.flat.widget.AndroidViewWidget androidViewWidget) {
        this.mViewWidgetRegistry.put(wXComponent, androidViewWidget);
    }

    public void register(com.taobao.weex.ui.flat.widget.Widget widget, com.taobao.weex.ui.component.WXComponent wXComponent) {
        this.widgetToComponent.put(widget, wXComponent);
    }

    public com.taobao.weex.ui.flat.WidgetContainer getFlatComponentAncestor(com.taobao.weex.ui.component.WXComponent wXComponent) {
        return this.mWidgetRegistry.get(wXComponent);
    }

    public com.taobao.weex.ui.flat.widget.AndroidViewWidget getAndroidViewWidget(com.taobao.weex.ui.component.WXComponent wXComponent) {
        return this.mViewWidgetRegistry.get(wXComponent);
    }

    public boolean promoteToView(com.taobao.weex.ui.component.WXComponent wXComponent, boolean z, java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent<?>> cls) {
        if (isFlatUIEnabled(wXComponent) && cls.equals(wXComponent.getClass()) && !android.text.TextUtils.equals(wXComponent.getRef(), com.taobao.weex.ui.component.WXComponent.ROOT)) {
            return (z && getFlatComponentAncestor(wXComponent) == null) || checkComponent(wXComponent);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [android.view.View] */
    public android.view.View getWidgetContainerView(com.taobao.weex.ui.flat.widget.Widget widget) {
        com.taobao.weex.ui.flat.WidgetContainer flatComponentAncestor;
        com.taobao.weex.ui.component.WXComponent component = getComponent(widget);
        if (component == null || (flatComponentAncestor = getFlatComponentAncestor(component)) == null) {
            return null;
        }
        return flatComponentAncestor.getHostView();
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        this.widgetToComponent.clear();
        java.util.Iterator<java.util.Map.Entry<com.taobao.weex.ui.component.WXComponent, com.taobao.weex.ui.flat.widget.AndroidViewWidget>> it = this.mViewWidgetRegistry.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().destroy();
        }
        this.mViewWidgetRegistry.clear();
        java.util.Iterator<java.util.Map.Entry<com.taobao.weex.ui.component.WXComponent, com.taobao.weex.ui.flat.WidgetContainer>> it2 = this.mWidgetRegistry.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().unmountFlatGUI();
        }
        this.mWidgetRegistry.clear();
    }

    private com.taobao.weex.ui.component.WXComponent getComponent(com.taobao.weex.ui.flat.widget.Widget widget) {
        return this.widgetToComponent.get(widget);
    }

    private boolean checkComponent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (wXComponent == null) {
            return false;
        }
        com.taobao.weex.dom.WXStyle styles = wXComponent.getStyles();
        com.taobao.weex.dom.WXAttr attrs = wXComponent.getAttrs();
        return styles.containsKey("opacity") || styles.containsKey("transform") || styles.containsKey(com.taobao.weex.common.Constants.Name.VISIBILITY) || attrs.containsKey(com.taobao.weex.common.Constants.Name.ELEVATION) || attrs.containsKey(com.taobao.weex.common.Constants.Name.ARIA_HIDDEN) || attrs.containsKey(com.taobao.weex.common.Constants.Name.ARIA_LABEL) || attrs.containsKey(com.taobao.weex.ui.component.WXComponent.PROP_FIXED_SIZE) || attrs.containsKey(com.taobao.weex.common.Constants.Name.DISABLED) || styles.isFixed() || styles.isSticky() || !styles.getPesudoStyles().isEmpty() || wXComponent.getEvents().size() > 0;
    }
}
