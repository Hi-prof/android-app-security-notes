package io.dcloud.js.geolocation;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GeoManagerBase implements io.dcloud.common.DHInterface.IReflectAble {
    protected java.util.ArrayList<java.lang.String> keySet;
    protected android.content.Context mContext;

    public GeoManagerBase(android.content.Context context) {
        this.keySet = null;
        this.mContext = context;
        this.keySet = new java.util.ArrayList<>();
    }

    public abstract java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr);

    public boolean hasKey(java.lang.String str) {
        return this.keySet.contains(str);
    }

    public abstract void onDestroy();
}
