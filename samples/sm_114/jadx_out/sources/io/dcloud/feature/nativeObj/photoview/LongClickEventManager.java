package io.dcloud.feature.nativeObj.photoview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class LongClickEventManager {
    private static io.dcloud.feature.nativeObj.photoview.LongClickEventManager instance;
    private java.util.Map<java.lang.String, io.dcloud.feature.nativeObj.photoview.LongClickEventManager.OnLongClickListener> clicks = new java.util.HashMap();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static abstract class OnLongClickListener {
        java.lang.String callbackIds;
        io.dcloud.common.DHInterface.IWebview pwebview;

        protected OnLongClickListener(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.pwebview = iWebview;
            this.callbackIds = str;
        }

        public java.lang.String getCallbackIds() {
            return this.callbackIds;
        }

        public io.dcloud.common.DHInterface.IWebview getPwebview() {
            return this.pwebview;
        }

        public abstract void onLongClickListener(org.json.JSONObject jSONObject);
    }

    public static io.dcloud.feature.nativeObj.photoview.LongClickEventManager getInstance() {
        if (instance == null) {
            synchronized (io.dcloud.feature.nativeObj.photoview.LongClickEventManager.class) {
                if (instance == null) {
                    instance = new io.dcloud.feature.nativeObj.photoview.LongClickEventManager();
                }
            }
        }
        return instance;
    }

    public void addOnlongClickListener(java.lang.String str, io.dcloud.feature.nativeObj.photoview.LongClickEventManager.OnLongClickListener onLongClickListener) {
        this.clicks.put(str, onLongClickListener);
    }

    public void fireEvent(org.json.JSONObject jSONObject) {
        java.util.Iterator<java.lang.String> it = this.clicks.keySet().iterator();
        while (it.hasNext()) {
            io.dcloud.feature.nativeObj.photoview.LongClickEventManager.OnLongClickListener onLongClickListener = this.clicks.get(it.next());
            if (onLongClickListener != null) {
                onLongClickListener.onLongClickListener(jSONObject);
            }
        }
    }

    public void removeOnLongClickListener(java.lang.String str) {
        this.clicks.remove(str);
    }
}
