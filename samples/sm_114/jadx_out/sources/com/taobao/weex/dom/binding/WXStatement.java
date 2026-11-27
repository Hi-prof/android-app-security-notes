package com.taobao.weex.dom.binding;

/* JADX INFO: loaded from: classes.dex */
public class WXStatement extends androidx.collection.ArrayMap<java.lang.String, java.lang.Object> implements java.lang.Cloneable {
    public static final java.lang.String WX_FOR = "[[repeat]]";
    public static final java.lang.String WX_FOR_INDEX = "@index";
    public static final java.lang.String WX_FOR_ITEM = "@alias";
    public static final java.lang.String WX_FOR_LIST = "@expression";
    public static final java.lang.String WX_IF = "[[match]]";
    public static final java.lang.String WX_ONCE = "[[once]]";

    public WXStatement() {
    }

    public WXStatement(androidx.collection.SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.taobao.weex.dom.binding.WXStatement m402clone() {
        return new com.taobao.weex.dom.binding.WXStatement(this);
    }
}
