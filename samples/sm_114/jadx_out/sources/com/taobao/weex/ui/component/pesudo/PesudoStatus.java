package com.taobao.weex.ui.component.pesudo;

/* JADX INFO: loaded from: classes.dex */
public class PesudoStatus {
    static final int CLASS_ACTIVE = 0;
    static final int CLASS_DISABLED = 3;
    static final int CLASS_ENABLED = 2;
    static final int CLASS_FOCUS = 1;
    private static final int SET = 1;
    private static final int UNSET = 0;
    private int[] mStatuses = new int[4];

    public PesudoStatus() {
        int i = 0;
        while (true) {
            int[] iArr = this.mStatuses;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public void setStatus(java.lang.String str, boolean z) {
        str.hashCode();
        switch (str) {
            case ":active":
                setStatus(0, z);
                break;
            case ":disabled":
                setStatus(3, z);
                break;
            case ":enabled":
                setStatus(2, z);
                break;
            case ":focus":
                setStatus(1, z);
                break;
        }
    }

    void setStatus(int i, boolean z) {
        this.mStatuses[i] = z ? 1 : 0;
    }

    public boolean isSet(int i) {
        return this.mStatuses[i] == 1;
    }

    public java.lang.String getStatuses() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (isSet(0)) {
            sb.append(com.taobao.weex.common.Constants.PSEUDO.ACTIVE);
        }
        if (isSet(3)) {
            sb.append(com.taobao.weex.common.Constants.PSEUDO.DISABLED);
        }
        if (isSet(1) && !isSet(3)) {
            sb.append(com.taobao.weex.common.Constants.PSEUDO.FOCUS);
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    public java.util.Map<java.lang.String, java.lang.Object> updateStatusAndGetUpdateStyles(java.lang.String str, boolean z, java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        java.lang.String statuses = getStatuses();
        setStatus(str, z);
        java.util.Map<java.lang.String, java.lang.Object> map3 = map.get(getStatuses());
        java.util.Map<java.lang.String, java.lang.Object> map4 = map.get(statuses);
        androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap();
        if (map4 != null) {
            arrayMap.putAll(map4);
        }
        for (K k : arrayMap.keySet()) {
            arrayMap.put(k, map2.containsKey(k) ? map2.get(k) : "");
        }
        if (map3 != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : map3.entrySet()) {
                arrayMap.put(entry.getKey(), entry.getValue());
            }
        }
        return arrayMap;
    }
}
