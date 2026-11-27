package com.taobao.weex.dom;

/* JADX INFO: loaded from: classes.dex */
public class CSSShorthand<T extends java.lang.Enum<? extends com.taobao.weex.dom.CSSShorthand.WXCSSProperty>> extends io.dcloud.feature.uniapp.dom.AbsCSSShorthand {

    public enum CORNER implements com.taobao.weex.dom.CSSShorthand.WXCSSProperty {
        BORDER_TOP_LEFT,
        BORDER_TOP_RIGHT,
        BORDER_BOTTOM_RIGHT,
        BORDER_BOTTOM_LEFT,
        ALL
    }

    public enum EDGE implements com.taobao.weex.dom.CSSShorthand.WXCSSProperty {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        ALL
    }

    interface WXCSSProperty extends io.dcloud.feature.uniapp.dom.AbsCSSShorthand.CSSProperty {
    }

    public CSSShorthand(float[] fArr) {
        super(fArr);
    }

    public CSSShorthand() {
    }

    @Override // io.dcloud.feature.uniapp.dom.AbsCSSShorthand
    /* JADX INFO: renamed from: clone */
    public com.taobao.weex.dom.CSSShorthand mo399clone() throws java.lang.CloneNotSupportedException {
        return (com.taobao.weex.dom.CSSShorthand) super.mo399clone();
    }
}
