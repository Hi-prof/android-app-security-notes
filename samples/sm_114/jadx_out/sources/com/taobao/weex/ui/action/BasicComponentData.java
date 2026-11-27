package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class BasicComponentData<T extends android.view.View> extends io.dcloud.feature.uniapp.ui.action.AbsComponentData {
    public BasicComponentData(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super(str, str2, str3);
    }

    @Override // io.dcloud.feature.uniapp.ui.action.AbsComponentData
    public com.taobao.weex.dom.WXStyle getStyles() {
        return (com.taobao.weex.dom.WXStyle) super.getStyles();
    }

    @Override // io.dcloud.feature.uniapp.ui.action.AbsComponentData
    public com.taobao.weex.dom.WXAttr getAttrs() {
        return (com.taobao.weex.dom.WXAttr) super.getAttrs();
    }

    @Override // io.dcloud.feature.uniapp.ui.action.AbsComponentData
    public com.taobao.weex.dom.WXEvent getEvents() {
        return (com.taobao.weex.dom.WXEvent) super.getEvents();
    }

    @Override // io.dcloud.feature.uniapp.ui.action.AbsComponentData
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.taobao.weex.ui.action.BasicComponentData mo403clone() throws java.lang.CloneNotSupportedException {
        com.taobao.weex.ui.action.BasicComponentData basicComponentData = new com.taobao.weex.ui.action.BasicComponentData(this.mRef, this.mComponentType, this.mParentRef);
        basicComponentData.setBorders(getBorder().mo399clone());
        basicComponentData.setMargins(getMargin().mo399clone());
        basicComponentData.setPaddings(getPadding().mo399clone());
        com.taobao.weex.dom.WXAttr attrs = getAttrs();
        if (attrs != null) {
            basicComponentData.mAttributes = attrs.mo400clone();
        }
        if (this.mStyles != null) {
            basicComponentData.mStyles = this.mStyles.mo401clone();
        }
        if (this.mEvents != null) {
            basicComponentData.mEvents = this.mEvents.clone();
        }
        if (this.renderObjectPr != 0) {
            basicComponentData.setRenderObjectPr(com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils.nativeCopyRenderObject(this.renderObjectPr));
        }
        return basicComponentData;
    }

    @Override // io.dcloud.feature.uniapp.ui.action.AbsComponentData
    public com.taobao.weex.dom.CSSShorthand getBorder() {
        return (com.taobao.weex.dom.CSSShorthand) super.getBorder();
    }

    @Override // io.dcloud.feature.uniapp.ui.action.AbsComponentData
    public com.taobao.weex.dom.CSSShorthand getMargin() {
        return (com.taobao.weex.dom.CSSShorthand) super.getMargin();
    }

    @Override // io.dcloud.feature.uniapp.ui.action.AbsComponentData
    public com.taobao.weex.dom.CSSShorthand getPadding() {
        return (com.taobao.weex.dom.CSSShorthand) super.getPadding();
    }
}
