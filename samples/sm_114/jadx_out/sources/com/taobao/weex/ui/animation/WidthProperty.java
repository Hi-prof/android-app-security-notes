package com.taobao.weex.ui.animation;

/* JADX INFO: loaded from: classes.dex */
public class WidthProperty extends com.taobao.weex.ui.animation.LayoutParamsProperty {
    @Override // com.taobao.weex.ui.animation.LayoutParamsProperty
    public /* bridge */ /* synthetic */ java.lang.Integer get(android.view.View view) {
        return super.get(view);
    }

    @Override // com.taobao.weex.ui.animation.LayoutParamsProperty
    public /* bridge */ /* synthetic */ void set(android.view.View view, java.lang.Integer num) {
        super.set(view, num);
    }

    @Override // com.taobao.weex.ui.animation.LayoutParamsProperty
    protected java.lang.Integer getProperty(android.view.ViewGroup.LayoutParams layoutParams) {
        return java.lang.Integer.valueOf(layoutParams.width);
    }

    @Override // com.taobao.weex.ui.animation.LayoutParamsProperty
    protected void setProperty(android.view.ViewGroup.LayoutParams layoutParams, java.lang.Integer num) {
        layoutParams.width = num.intValue();
    }
}
