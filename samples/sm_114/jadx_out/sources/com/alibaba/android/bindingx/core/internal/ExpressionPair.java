package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: loaded from: classes.dex */
public class ExpressionPair {
    public final java.lang.String origin;
    public final java.lang.String transformed;

    public ExpressionPair(java.lang.String str, java.lang.String str2) {
        this.origin = str;
        this.transformed = str2;
    }

    public static com.alibaba.android.bindingx.core.internal.ExpressionPair create(java.lang.String str, java.lang.String str2) {
        return new com.alibaba.android.bindingx.core.internal.ExpressionPair(str, str2);
    }

    public static boolean isValid(com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair) {
        return (expressionPair == null || android.text.TextUtils.isEmpty(expressionPair.transformed) || "{}".equals(expressionPair.transformed)) ? false : true;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair = (com.alibaba.android.bindingx.core.internal.ExpressionPair) obj;
            java.lang.String str = this.origin;
            if (str == null ? expressionPair.origin != null : !str.equals(expressionPair.origin)) {
                return false;
            }
            java.lang.String str2 = this.transformed;
            java.lang.String str3 = expressionPair.transformed;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        java.lang.String str = this.origin;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        java.lang.String str2 = this.transformed;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }
}
