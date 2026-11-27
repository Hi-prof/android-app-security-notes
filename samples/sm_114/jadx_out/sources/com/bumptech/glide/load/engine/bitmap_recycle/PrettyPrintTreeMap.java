package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: classes.dex */
class PrettyPrintTreeMap<K, V> extends java.util.TreeMap<K, V> {
    PrettyPrintTreeMap() {
    }

    @Override // java.util.AbstractMap
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("( ");
        for (java.util.Map.Entry<K, V> entry : entrySet()) {
            sb.append(com.taobao.weex.el.parse.Operators.BLOCK_START);
            sb.append(entry.getKey());
            sb.append(com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE);
            sb.append(entry.getValue());
            sb.append("}, ");
        }
        if (!isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(" )");
        return sb.toString();
    }
}
