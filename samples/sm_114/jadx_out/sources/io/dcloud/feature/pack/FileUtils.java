package io.dcloud.feature.pack;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtils {
    public static void addFileToSystem(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            android.os.StrictMode.setVmPolicy(new android.os.StrictMode.VmPolicy.Builder().build());
        }
        android.content.Intent intent = new android.content.Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            android.net.Uri uriForFile = androidx.core.content.FileProvider.getUriForFile(context, str, new java.io.File(str2));
            intent.addFlags(1);
            intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(android.net.Uri.fromFile(new java.io.File(str2)), "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }
}
