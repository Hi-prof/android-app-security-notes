package com.heytap.openid.sdk;

/* JADX INFO: loaded from: classes.dex */
public class b implements android.content.ServiceConnection {
    public final /* synthetic */ com.heytap.openid.sdk.c a;

    public b(com.heytap.openid.sdk.c cVar) {
        this.a = cVar;
    }

    @Override // android.content.ServiceConnection
    public native void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder);

    @Override // android.content.ServiceConnection
    public native void onServiceDisconnected(android.content.ComponentName componentName);
}
