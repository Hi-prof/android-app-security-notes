package com.taobao.weex.ui.component.basic;

/* JADX INFO: loaded from: classes.dex */
public abstract class WXBasicComponent<T extends android.view.View> extends io.dcloud.feature.uniapp.ui.component.AbsBasicComponent {
    public WXBasicComponent(io.dcloud.feature.uniapp.ui.action.AbsComponentData absComponentData) {
        super(absComponentData);
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsBasicComponent
    public final com.taobao.weex.dom.WXStyle getStyles() {
        return (com.taobao.weex.dom.WXStyle) super.getStyles();
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsBasicComponent
    public final com.taobao.weex.dom.WXAttr getAttrs() {
        return (com.taobao.weex.dom.WXAttr) super.getAttrs();
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsBasicComponent
    public final com.taobao.weex.dom.WXEvent getEvents() {
        return (com.taobao.weex.dom.WXEvent) super.getEvents();
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsBasicComponent
    public com.taobao.weex.ui.action.BasicComponentData getBasicComponentData() {
        return (com.taobao.weex.ui.action.BasicComponentData) super.getBasicComponentData();
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsBasicComponent
    public final com.taobao.weex.dom.CSSShorthand getBorder() {
        return (com.taobao.weex.dom.CSSShorthand) super.getBorder();
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsBasicComponent
    public final com.taobao.weex.dom.CSSShorthand getPadding() {
        return (com.taobao.weex.dom.CSSShorthand) super.getPadding();
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsBasicComponent
    public final com.taobao.weex.dom.CSSShorthand getMargin() {
        return (com.taobao.weex.dom.CSSShorthand) super.getMargin();
    }
}
