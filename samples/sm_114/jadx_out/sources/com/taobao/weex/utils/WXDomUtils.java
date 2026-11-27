package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class WXDomUtils {
    public static float getContentWidth(com.taobao.weex.ui.component.WXComponent wXComponent) {
        float layoutWidth = wXComponent.getLayoutWidth();
        com.taobao.weex.dom.CSSShorthand padding = wXComponent.getPadding();
        com.taobao.weex.dom.CSSShorthand border = wXComponent.getBorder();
        float f = padding.get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT);
        if (!com.taobao.weex.dom.CSSConstants.isUndefined(f)) {
            layoutWidth -= f;
        }
        float f2 = padding.get(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT);
        if (!com.taobao.weex.dom.CSSConstants.isUndefined(f2)) {
            layoutWidth -= f2;
        }
        float f3 = border.get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT);
        if (!com.taobao.weex.dom.CSSConstants.isUndefined(f3)) {
            layoutWidth -= f3;
        }
        float f4 = border.get(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT);
        return !com.taobao.weex.dom.CSSConstants.isUndefined(f4) ? layoutWidth - f4 : layoutWidth;
    }

    public static float getContentHeight(com.taobao.weex.ui.component.WXComponent wXComponent) {
        float layoutHeight = wXComponent.getLayoutHeight();
        com.taobao.weex.dom.CSSShorthand padding = wXComponent.getPadding();
        com.taobao.weex.dom.CSSShorthand border = wXComponent.getBorder();
        float f = padding.get(com.taobao.weex.dom.CSSShorthand.EDGE.TOP);
        if (!com.taobao.weex.dom.CSSConstants.isUndefined(f)) {
            layoutHeight -= f;
        }
        float f2 = padding.get(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM);
        if (!com.taobao.weex.dom.CSSConstants.isUndefined(f2)) {
            layoutHeight -= f2;
        }
        float f3 = border.get(com.taobao.weex.dom.CSSShorthand.EDGE.TOP);
        if (!com.taobao.weex.dom.CSSConstants.isUndefined(f3)) {
            layoutHeight -= f3;
        }
        float f4 = border.get(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM);
        return !com.taobao.weex.dom.CSSConstants.isUndefined(f4) ? layoutHeight - f4 : layoutHeight;
    }

    public static float getContentWidth(com.taobao.weex.dom.CSSShorthand cSSShorthand, com.taobao.weex.dom.CSSShorthand cSSShorthand2, float f) {
        float f2 = cSSShorthand.get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT);
        if (!com.taobao.weex.dom.CSSConstants.isUndefined(f2)) {
            f -= f2;
        }
        float f3 = cSSShorthand.get(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT);
        if (!com.taobao.weex.dom.CSSConstants.isUndefined(f3)) {
            f -= f3;
        }
        float f4 = cSSShorthand2.get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT);
        if (!com.taobao.weex.dom.CSSConstants.isUndefined(f4)) {
            f -= f4;
        }
        float f5 = cSSShorthand2.get(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT);
        return !com.taobao.weex.dom.CSSConstants.isUndefined(f5) ? f - f5 : f;
    }
}
