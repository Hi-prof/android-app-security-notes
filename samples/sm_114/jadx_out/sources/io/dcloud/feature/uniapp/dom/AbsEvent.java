package io.dcloud.feature.uniapp.dom;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsEvent extends java.util.ArrayList<java.lang.String> implements java.io.Serializable, java.lang.Cloneable {
    public static final java.lang.String EVENT_KEY_ARGS = "params";
    public static final java.lang.String EVENT_KEY_TYPE = "type";
    private static final long serialVersionUID = -8186587029452440107L;
    private androidx.collection.ArrayMap mEventBindingArgs;
    private androidx.collection.ArrayMap<java.lang.String, java.util.List<java.lang.Object>> mEventBindingArgsValues;

    @Override // java.util.ArrayList
    public abstract io.dcloud.feature.uniapp.dom.AbsEvent clone();

    public void setEventBindingArgsValues(androidx.collection.ArrayMap<java.lang.String, java.util.List<java.lang.Object>> arrayMap) {
        this.mEventBindingArgsValues = arrayMap;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        androidx.collection.ArrayMap arrayMap = this.mEventBindingArgs;
        if (arrayMap != null) {
            arrayMap.clear();
        }
        androidx.collection.ArrayMap<java.lang.String, java.util.List<java.lang.Object>> arrayMap2 = this.mEventBindingArgsValues;
        if (arrayMap2 != null) {
            arrayMap2.clear();
        }
        super.clear();
    }

    public boolean remove(java.lang.String str) {
        androidx.collection.ArrayMap arrayMap = this.mEventBindingArgs;
        if (arrayMap != null) {
            arrayMap.remove(str);
        }
        androidx.collection.ArrayMap<java.lang.String, java.util.List<java.lang.Object>> arrayMap2 = this.mEventBindingArgsValues;
        if (arrayMap2 != null) {
            arrayMap2.remove(str);
        }
        return super.remove((java.lang.Object) str);
    }

    public androidx.collection.ArrayMap getEventBindingArgs() {
        return this.mEventBindingArgs;
    }

    public androidx.collection.ArrayMap<java.lang.String, java.util.List<java.lang.Object>> getEventBindingArgsValues() {
        return this.mEventBindingArgsValues;
    }

    public void addEvent(java.lang.Object obj) {
        if (obj instanceof java.lang.CharSequence) {
            if (com.taobao.weex.dom.binding.JSONUtils.isJSON(obj.toString())) {
                addEvent(com.taobao.weex.dom.binding.JSONUtils.toJSON(obj.toString()));
                return;
            }
            java.lang.String string = obj.toString();
            if (contains(string)) {
                return;
            }
            add(string);
            return;
        }
        if (obj instanceof com.alibaba.fastjson.JSONObject) {
            addBindingEvent((com.alibaba.fastjson.JSONObject) obj);
        }
    }

    public static java.lang.String getEventName(java.lang.Object obj) {
        if (obj instanceof java.lang.CharSequence) {
            return obj.toString();
        }
        if (obj instanceof com.alibaba.fastjson.JSONObject) {
            return ((com.alibaba.fastjson.JSONObject) obj).getString("type");
        }
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public void parseStatements() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < size(); i++) {
            java.lang.String str = get(i);
            if (com.taobao.weex.dom.binding.JSONUtils.isJSON(str)) {
                set(i, addBindingEvent(com.taobao.weex.dom.binding.JSONUtils.toJSON(str)));
            }
        }
    }

    private java.lang.String addBindingEvent(com.alibaba.fastjson.JSONObject jSONObject) {
        java.lang.String string = jSONObject.getString("type");
        java.lang.Object obj = jSONObject.get("params");
        if (string != null) {
            addBindingArgsEvent(string, obj);
        }
        return string;
    }

    public void setEventBindingArgs(androidx.collection.ArrayMap arrayMap) {
        this.mEventBindingArgs = arrayMap;
    }

    private void addBindingArgsEvent(java.lang.String str, java.lang.Object obj) {
        if (!contains(str)) {
            add(str);
        }
        if (obj != null) {
            if (this.mEventBindingArgs == null) {
                this.mEventBindingArgs = new androidx.collection.ArrayMap();
            }
            this.mEventBindingArgs.put(str, com.taobao.weex.dom.binding.ELUtils.bindingBlock(obj));
        }
    }

    public void putEventBindingArgsValue(java.lang.String str, java.util.List<java.lang.Object> list) {
        if (this.mEventBindingArgsValues == null) {
            this.mEventBindingArgsValues = new androidx.collection.ArrayMap<>();
        }
        if (list == null) {
            this.mEventBindingArgsValues.remove(str);
        } else {
            this.mEventBindingArgsValues.put(str, list);
        }
    }
}
