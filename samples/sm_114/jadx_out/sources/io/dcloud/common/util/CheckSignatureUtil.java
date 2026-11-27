package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class CheckSignatureUtil {
    public static boolean check(java.lang.String str) {
        java.lang.String signature = getSignature(str);
        if (android.text.TextUtils.isEmpty(signature)) {
            return true;
        }
        java.lang.String appSignatureMd5 = io.dcloud.common.util.LoadAppUtils.getAppSignatureMd5(io.dcloud.application.DCLoudApplicationImpl.self().getContext().getApplicationContext(), io.dcloud.application.DCLoudApplicationImpl.self().getContext().getPackageName());
        return android.text.TextUtils.isEmpty(appSignatureMd5) || appSignatureMd5.equalsIgnoreCase(signature);
    }

    public static java.lang.String getSignature(java.lang.String str) {
        java.lang.String[] apkFileSignatureAndPackageName = io.dcloud.common.util.LoadAppUtils.getApkFileSignatureAndPackageName(io.dcloud.application.DCLoudApplicationImpl.self().getContext().getApplicationContext(), str);
        return (apkFileSignatureAndPackageName == null || apkFileSignatureAndPackageName.length <= 0) ? "" : apkFileSignatureAndPackageName[0];
    }
}
