package com.taobao.weex.dom;

/* JADX INFO: loaded from: classes.dex */
public class WXStyle extends io.dcloud.feature.uniapp.dom.AbsStyle {
    public WXStyle() {
    }

    public WXStyle(java.util.Map<java.lang.String, java.lang.Object> map) {
        super(map);
    }

    public WXStyle(java.util.Map<java.lang.String, java.lang.Object> map, boolean z) {
        super(map, z);
    }

    @Override // io.dcloud.feature.uniapp.dom.AbsStyle
    /* JADX INFO: renamed from: clone */
    public com.taobao.weex.dom.WXStyle mo401clone() {
        com.taobao.weex.dom.WXStyle wXStyle = new com.taobao.weex.dom.WXStyle();
        wXStyle.mStyles.putAll(this.mStyles);
        if (this.mBindingStyle != null) {
            wXStyle.mBindingStyle = new androidx.collection.ArrayMap<>(this.mBindingStyle);
        }
        if (this.mPesudoStyleMap != null) {
            wXStyle.mPesudoStyleMap = new androidx.collection.ArrayMap();
            for (java.util.Map.Entry<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> entry : this.mPesudoStyleMap.entrySet()) {
                androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap();
                arrayMap.putAll(entry.getValue());
                wXStyle.mPesudoStyleMap.put(entry.getKey(), arrayMap);
            }
        }
        if (this.mPesudoResetStyleMap != null) {
            wXStyle.mPesudoResetStyleMap = new androidx.collection.ArrayMap();
            wXStyle.mPesudoResetStyleMap.putAll(this.mPesudoResetStyleMap);
        }
        return wXStyle;
    }
}
