package io.dcloud.common.constant;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class StringConst extends io.dcloud.common.adapter.util.AndroidResources implements io.dcloud.common.constant.AbsoluteConst {
    private static long sChangeTime;

    public static int getIntSF(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return 1;
        }
        if ("barcode".equals(str)) {
            return 2;
        }
        if ("scheme".equals(str)) {
            return 3;
        }
        if (io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_STREAM.equals(str)) {
            return 6;
        }
        if (io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SHORTCUT.equals(str)) {
            return 5;
        }
        if ("push".equals(str)) {
            return 4;
        }
        if ("myapp".equals(str)) {
            return 7;
        }
        if ("browser".equals(str)) {
            return 8;
        }
        if (str.indexOf("third:") == 0) {
            return 9;
        }
        if ("favorite".equals(str)) {
            return 10;
        }
        if ("engines".equals(str)) {
            return 11;
        }
        if ("apush".equals(str)) {
            return 40;
        }
        return "speech".equals(str) ? 30 : 1;
    }
}
