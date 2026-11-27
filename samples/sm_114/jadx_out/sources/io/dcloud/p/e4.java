package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e4 {
    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        editorEdit.putString(str2, str3);
        editorEdit.apply();
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, "");
        } catch (java.lang.Exception unused) {
            return "";
        }
    }
}
