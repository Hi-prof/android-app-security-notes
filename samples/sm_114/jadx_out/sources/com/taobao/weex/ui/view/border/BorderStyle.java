package com.taobao.weex.ui.view.border;

/* JADX INFO: loaded from: classes.dex */
enum BorderStyle {
    SOLID,
    DASHED,
    DOTTED;

    /* JADX INFO: renamed from: com.taobao.weex.ui.view.border.BorderStyle$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$taobao$weex$ui$view$border$BorderStyle;

        static {
            int[] iArr = new int[com.taobao.weex.ui.view.border.BorderStyle.values().length];
            $SwitchMap$com$taobao$weex$ui$view$border$BorderStyle = iArr;
            try {
                iArr[com.taobao.weex.ui.view.border.BorderStyle.DOTTED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$taobao$weex$ui$view$border$BorderStyle[com.taobao.weex.ui.view.border.BorderStyle.DASHED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    android.graphics.Shader getLineShader(float f, int i, com.taobao.weex.dom.CSSShorthand.EDGE edge) {
        int i2 = com.taobao.weex.ui.view.border.BorderStyle.AnonymousClass1.$SwitchMap$com$taobao$weex$ui$view$border$BorderStyle[ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return null;
            }
        } else {
            if (edge == com.taobao.weex.dom.CSSShorthand.EDGE.LEFT || edge == com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT) {
                return new android.graphics.LinearGradient(0.0f, 0.0f, 0.0f, f * 2.0f, new int[]{i, 0}, new float[]{0.5f, 0.5f}, android.graphics.Shader.TileMode.REPEAT);
            }
            if (edge == com.taobao.weex.dom.CSSShorthand.EDGE.TOP || edge == com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM) {
                return new android.graphics.LinearGradient(0.0f, 0.0f, f * 2.0f, 0.0f, new int[]{i, 0}, new float[]{0.5f, 0.5f}, android.graphics.Shader.TileMode.REPEAT);
            }
        }
        if (edge == com.taobao.weex.dom.CSSShorthand.EDGE.LEFT || edge == com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT) {
            return new android.graphics.LinearGradient(0.0f, 0.0f, 0.0f, f * 6.0f, new int[]{i, 0}, new float[]{0.5f, 0.5f}, android.graphics.Shader.TileMode.REPEAT);
        }
        if (edge == com.taobao.weex.dom.CSSShorthand.EDGE.TOP || edge == com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM) {
            return new android.graphics.LinearGradient(0.0f, 0.0f, f * 6.0f, 0.0f, new int[]{i, 0}, new float[]{0.5f, 0.5f}, android.graphics.Shader.TileMode.REPEAT);
        }
        return null;
    }
}
