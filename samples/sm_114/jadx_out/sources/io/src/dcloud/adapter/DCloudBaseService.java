package io.src.dcloud.adapter;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCloudBaseService extends android.app.Service implements io.dcloud.common.DHInterface.IReflectAble {
    public android.app.Service that = this;

    @Override // android.app.Service
    public final android.os.IBinder onBind(android.content.Intent intent) {
        return onBindImpl(intent);
    }

    public android.os.IBinder onBindImpl(android.content.Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        onCreateImpl();
    }

    public void onCreateImpl() {
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        onDestroyImpl();
    }

    public void onDestroyImpl() {
    }

    @Override // android.app.Service
    public final int onStartCommand(android.content.Intent intent, int i, int i2) {
        return onStartCommandImpl(intent, i, i2);
    }

    public int onStartCommandImpl(android.content.Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
