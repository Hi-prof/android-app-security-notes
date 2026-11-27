package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public class WXHashMap<K, V> extends java.util.HashMap<K, V> {
    private static final long serialVersionUID = 4294272345728974369L;
    private java.util.Stack<java.lang.String> instancesStack = new java.util.Stack<>();
    private java.lang.String mTag;

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null && k.toString() != null) {
            if (this.instancesStack.contains(k)) {
                this.instancesStack.remove(k);
            }
            this.instancesStack.push(k.toString());
        }
        return (V) super.put(k, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(java.lang.Object obj) {
        return (V) super.remove(obj);
    }

    public V removeFromMapAndStack(java.lang.Object obj) {
        this.instancesStack.remove(obj);
        return (V) super.remove(obj);
    }

    public java.lang.String getStackTopInstanceId() {
        return this.instancesStack.isEmpty() ? "" : this.instancesStack.pop();
    }

    public void setStackTopInstance(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.instancesStack.remove(str);
        this.instancesStack.push(str);
    }

    public java.util.Stack<java.lang.String> getInstanceStack() {
        return this.instancesStack;
    }

    public java.lang.String getTag() {
        return this.mTag;
    }

    public void setTag(java.lang.String str) {
        this.mTag = str;
    }
}
