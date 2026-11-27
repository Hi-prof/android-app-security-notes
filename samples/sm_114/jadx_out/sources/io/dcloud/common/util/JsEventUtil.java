package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class JsEventUtil {
    public static java.lang.String broadcastEvents_format(java.lang.String str, java.lang.String str2, boolean z, java.lang.String... strArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("{evt:'%s',args:");
        sb.append(z ? "'%s'" : "%s");
        sb.append(",callbackId:'%s'}");
        return io.dcloud.common.util.StringUtil.format(sb.toString(), str, str2, strArr);
    }

    public static java.lang.String eventListener_format(java.lang.String str, java.lang.String str2, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("{evt:'%s',args:");
        sb.append(z ? "'%s'" : "%s");
        sb.append(com.taobao.weex.el.parse.Operators.BLOCK_END_STR);
        return io.dcloud.common.util.StringUtil.format(sb.toString(), str, str2);
    }
}
