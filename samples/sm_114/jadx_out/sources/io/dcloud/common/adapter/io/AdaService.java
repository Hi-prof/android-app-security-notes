package io.dcloud.common.adapter.io;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class AdaService {
    static final java.lang.String TAG = "AdaService";
    static java.util.HashMap<java.lang.String, io.dcloud.common.adapter.io.AdaService> mServicesHandler = new java.util.HashMap<>(2);
    protected android.content.Context mContextWrapper;
    private java.lang.String mServiceName;

    protected AdaService(android.content.Context context, java.lang.String str) {
        this.mContextWrapper = context;
        this.mServiceName = str;
    }

    public static final io.dcloud.common.adapter.io.AdaService getServiceListener(java.lang.String str) {
        return mServicesHandler.get(str);
    }

    public static final void removeServiceListener(java.lang.String str) {
        mServicesHandler.remove(str);
    }

    public abstract void onDestroy();

    public abstract void onExecute();
}
