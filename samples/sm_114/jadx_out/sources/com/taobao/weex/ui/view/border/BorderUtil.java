package com.taobao.weex.ui.view.border;

/* JADX INFO: loaded from: classes.dex */
class BorderUtil {
    BorderUtil() {
    }

    static int fetchFromSparseArray(android.util.SparseIntArray sparseIntArray, int i, int i2) {
        return sparseIntArray == null ? i2 : sparseIntArray.get(i, sparseIntArray.get(com.taobao.weex.dom.CSSShorthand.EDGE.ALL.ordinal()));
    }

    static void updateSparseArray(android.util.SparseIntArray sparseIntArray, int i, int i2) {
        if (i == com.taobao.weex.dom.CSSShorthand.EDGE.ALL.ordinal()) {
            sparseIntArray.put(com.taobao.weex.dom.CSSShorthand.EDGE.ALL.ordinal(), i2);
            sparseIntArray.put(com.taobao.weex.dom.CSSShorthand.EDGE.TOP.ordinal(), i2);
            sparseIntArray.put(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT.ordinal(), i2);
            sparseIntArray.put(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT.ordinal(), i2);
            sparseIntArray.put(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM.ordinal(), i2);
            return;
        }
        sparseIntArray.put(i, i2);
    }
}
