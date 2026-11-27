package io.dcloud.feature.weex.config;

/* JADX INFO: loaded from: classes2.dex */
public class UniPathParser {
    public static java.lang.String getAndroidPath(java.lang.String str) {
        java.lang.String str2 = io.dcloud.common.util.BaseInfo.sCacheFsAppsPath;
        java.lang.String str3 = io.dcloud.common.util.BaseInfo.sDefaultBootApp + "/www/" + str;
        java.io.File file = new java.io.File(str2 + str3);
        if (file.exists()) {
            return file.getPath();
        }
        return "file:///android_asset/apps/" + str3;
    }
}
