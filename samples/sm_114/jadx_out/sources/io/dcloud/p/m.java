package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m {
    public static int a(android.content.Context context) {
        return (int) (context.getResources().getDisplayMetrics().heightPixels * 0.8f);
    }

    public static int b(android.content.Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str2)) {
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("[\\w\\.]+[\\.](avi|mpeg|3gp|mp3|mp4|wav|jpeg|gif|jpg|png|apk|exe|pdf|rar|zip|docx|doc)").matcher(str);
            if (matcher.find()) {
                return matcher.group();
            }
            if (android.text.TextUtils.isEmpty(str3)) {
                return java.lang.String.valueOf(java.lang.System.currentTimeMillis()) + ".dat";
            }
        } else {
            java.lang.String lastPathSegment = android.net.Uri.parse(str).getLastPathSegment();
            if (lastPathSegment != null && lastPathSegment.contains(str2)) {
                return lastPathSegment;
            }
            if (android.text.TextUtils.isEmpty(str3)) {
                return java.lang.String.valueOf(java.lang.System.currentTimeMillis()) + str2;
            }
        }
        return str3;
    }
}
