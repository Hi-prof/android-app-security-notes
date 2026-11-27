package com.huawei.android.hms.pps.a;

/* JADX INFO: loaded from: classes.dex */
public final class a implements android.content.ServiceConnection {
    public boolean a = false;
    public final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b = new java.util.concurrent.LinkedBlockingQueue<>(1);

    @Override // android.content.ServiceConnection
    public final native void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder);

    @Override // android.content.ServiceConnection
    public final native void onServiceDisconnected(android.content.ComponentName componentName);
}
