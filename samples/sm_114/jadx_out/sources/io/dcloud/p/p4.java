package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class p4 {
    public static int a(android.content.Context context) {
        try {
            if (android.os.Build.VERSION.SDK_INT < 29) {
                java.lang.Class<?> cls = java.lang.Class.forName("com.android.internal.R$dimen");
                return context.getResources().getDimensionPixelSize(java.lang.Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            }
            android.content.res.Resources resources = context.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", com.taobao.weex.WXEnvironment.OS);
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return -1;
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }
}
