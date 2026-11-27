package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: loaded from: classes.dex */
final class ExpressionHolder {
    java.util.Map<java.lang.String, java.lang.Object> config;
    java.lang.String eventType;
    com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair;
    java.lang.String prop;
    java.lang.String targetInstanceId;
    java.lang.String targetRef;

    ExpressionHolder(java.lang.String str, java.lang.String str2, com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair, java.lang.String str3, java.lang.String str4, java.util.Map<java.lang.String, java.lang.Object> map) {
        this.targetRef = str;
        this.targetInstanceId = str2;
        this.expressionPair = expressionPair;
        this.prop = str3;
        this.eventType = str4;
        if (map == null) {
            this.config = java.util.Collections.EMPTY_MAP;
        } else {
            this.config = java.util.Collections.unmodifiableMap(map);
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            com.alibaba.android.bindingx.core.internal.ExpressionHolder expressionHolder = (com.alibaba.android.bindingx.core.internal.ExpressionHolder) obj;
            java.lang.String str = this.targetRef;
            if (str == null ? expressionHolder.targetRef != null : !str.equals(expressionHolder.targetRef)) {
                return false;
            }
            com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair = this.expressionPair;
            if (expressionPair == null ? expressionHolder.expressionPair != null : !expressionPair.equals(expressionHolder.expressionPair)) {
                return false;
            }
            java.lang.String str2 = this.prop;
            if (str2 == null ? expressionHolder.prop != null : !str2.equals(expressionHolder.prop)) {
                return false;
            }
            java.lang.String str3 = this.eventType;
            if (str3 == null ? expressionHolder.eventType != null : !str3.equals(expressionHolder.eventType)) {
                return false;
            }
            java.util.Map<java.lang.String, java.lang.Object> map = this.config;
            java.util.Map<java.lang.String, java.lang.Object> map2 = expressionHolder.config;
            if (map != null) {
                return map.equals(map2);
            }
            if (map2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        java.lang.String str = this.targetRef;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair = this.expressionPair;
        int iHashCode2 = (iHashCode + (expressionPair != null ? expressionPair.hashCode() : 0)) * 31;
        java.lang.String str2 = this.prop;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.eventType;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        java.util.Map<java.lang.String, java.lang.Object> map = this.config;
        return iHashCode4 + (map != null ? map.hashCode() : 0);
    }
}
