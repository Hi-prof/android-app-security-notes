package com.taobao.weex.ui.animation;

/* JADX INFO: loaded from: classes.dex */
abstract class LayoutParamsProperty extends android.util.Property<android.view.View, java.lang.Integer> {
    protected abstract java.lang.Integer getProperty(android.view.ViewGroup.LayoutParams layoutParams);

    protected abstract void setProperty(android.view.ViewGroup.LayoutParams layoutParams, java.lang.Integer num);

    LayoutParamsProperty() {
        super(java.lang.Integer.class, "layoutParams");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public java.lang.Integer get(android.view.View view) {
        android.view.ViewGroup.LayoutParams layoutParams;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            return getProperty(layoutParams);
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public void set(android.view.View view, java.lang.Integer num) {
        android.view.ViewGroup.LayoutParams layoutParams;
        com.taobao.weex.ui.component.WXComponent component;
        if (view == 0 || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        setProperty(layoutParams, num);
        if ((view instanceof com.taobao.weex.ui.view.IRenderResult) && (component = ((com.taobao.weex.ui.view.IRenderResult) view).getComponent()) != null) {
            component.notifyNativeSizeChanged(layoutParams.width, layoutParams.height);
        }
        view.requestLayout();
    }
}
