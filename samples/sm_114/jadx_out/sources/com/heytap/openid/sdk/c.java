package com.heytap.openid.sdk;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public com.heytap.openid.a a = null;
    public java.lang.String b = null;
    public java.lang.String c = null;
    public final java.lang.Object d = new java.lang.Object();
    public android.content.ServiceConnection e = new com.heytap.openid.sdk.b(this);

    private static class a {
        public static final com.heytap.openid.sdk.c a = new com.heytap.openid.sdk.c(null);
    }

    public /* synthetic */ c(com.heytap.openid.sdk.b bVar) {
    }

    public native synchronized java.lang.String a(android.content.Context context, java.lang.String str);

    public native boolean a(android.content.Context context);

    public final native java.lang.String b(android.content.Context context, java.lang.String str);
}
