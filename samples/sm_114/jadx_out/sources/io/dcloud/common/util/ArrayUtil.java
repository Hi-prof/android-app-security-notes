package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ArrayUtil {
    public static java.lang.String[] riseArray(java.lang.String[] strArr, java.lang.String str) {
        java.lang.String[] strArr2;
        if (strArr == null) {
            strArr2 = new java.lang.String[1];
        } else {
            int length = strArr.length;
            java.lang.String[] strArr3 = new java.lang.String[length + 1];
            java.lang.System.arraycopy(strArr, 0, strArr3, 0, length);
            strArr2 = strArr3;
        }
        strArr2[strArr2.length] = str;
        return strArr2;
    }
}
