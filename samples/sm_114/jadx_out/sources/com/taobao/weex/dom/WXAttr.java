package com.taobao.weex.dom;

/* JADX INFO: loaded from: classes.dex */
public class WXAttr extends io.dcloud.feature.uniapp.dom.AbsAttr {
    public WXAttr() {
    }

    public WXAttr(java.util.Map<java.lang.String, java.lang.Object> map) {
        super(map);
    }

    public WXAttr(java.util.Map<java.lang.String, java.lang.Object> map, int i) {
        super(map, i);
    }

    @Override // io.dcloud.feature.uniapp.dom.AbsAttr
    /* JADX INFO: renamed from: clone */
    public com.taobao.weex.dom.WXAttr mo400clone() {
        com.taobao.weex.dom.WXAttr wXAttr = new com.taobao.weex.dom.WXAttr();
        wXAttr.skipFilterPutAll(getAttr());
        if (getBindingAttrs() != null) {
            wXAttr.setBindingAttrs(new androidx.collection.ArrayMap<>(getBindingAttrs()));
        }
        if (getStatement() != null) {
            wXAttr.setStatement(new com.taobao.weex.dom.binding.WXStatement(getStatement()));
        }
        return wXAttr;
    }
}
