package io.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
abstract class b extends io.src.dcloud.adapter.DCloudBaseActivity implements io.dcloud.common.DHInterface.IActivityHandler, io.dcloud.common.DHInterface.IReflectAble {
    private int a = 0;
    private java.util.HashMap b = new java.util.HashMap();
    private java.util.HashMap c = new java.util.HashMap();

    b() {
    }

    private void g() {
        java.util.Iterator it = this.b.values().iterator();
        while (it.hasNext()) {
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this).unregisterReceiver((io.dcloud.c) it.next());
        }
        this.b.clear();
        java.util.Iterator it2 = this.c.values().iterator();
        while (it2.hasNext()) {
            unregisterReceiver((io.dcloud.c) it2.next());
        }
        this.c.clear();
    }

    public void callBack(java.lang.String str, android.os.Bundle bundle) {
    }

    public int getActivityState() {
        return this.a;
    }

    public android.content.Context getContext() {
        return this.that;
    }

    public java.lang.String getUrlByFilePath(java.lang.String str, java.lang.String str2) {
        return "";
    }

    public boolean isMultiProcessMode() {
        return false;
    }

    public void onAsyncStartAppEnd(java.lang.String str, java.lang.Object obj) {
    }

    public java.lang.Object onAsyncStartAppStart(java.lang.String str) {
        return null;
    }

    @Override // io.src.dcloud.adapter.DCloudBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        this.a = 1;
        super.onCreate(bundle);
        io.dcloud.common.adapter.util.AndroidResources.initAndroidResources(this.that);
    }

    @Override // io.src.dcloud.adapter.DCloudBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.a = 0;
        super.onDestroy();
        try {
            g();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.a = 2;
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        this.a = 1;
        super.onResume();
    }

    public void registerLocalReceiver(io.dcloud.feature.internal.reflect.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter) {
        io.dcloud.c cVar = new io.dcloud.c(broadcastReceiver, intentFilter);
        try {
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this).registerReceiver(cVar, intentFilter);
            this.b.put(broadcastReceiver.toString(), cVar);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public android.content.Intent registerReceiver(io.dcloud.feature.internal.reflect.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter, java.lang.String str, android.os.Handler handler) {
        android.content.Intent intentRegisterReceiver;
        io.dcloud.c cVar = new io.dcloud.c(broadcastReceiver, intentFilter);
        try {
            intentRegisterReceiver = registerReceiver(cVar, intentFilter, str, handler);
            try {
                this.c.put(broadcastReceiver.toString(), cVar);
                return intentRegisterReceiver;
            } catch (java.lang.Exception e) {
                e = e;
                e.printStackTrace();
                return intentRegisterReceiver;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            intentRegisterReceiver = null;
        }
    }

    public void sendLocalBroadcast(android.content.Intent intent) {
        androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public void unregisterReceiver(io.dcloud.feature.internal.reflect.BroadcastReceiver broadcastReceiver) {
        io.dcloud.c cVar = (io.dcloud.c) this.b.remove(broadcastReceiver.toString());
        if (cVar != null) {
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this).unregisterReceiver(cVar);
        }
        io.dcloud.c cVar2 = (io.dcloud.c) this.c.remove(broadcastReceiver.toString());
        if (cVar2 != null) {
            unregisterReceiver(cVar2);
        }
    }

    public void registerReceiver(io.dcloud.feature.internal.reflect.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter) {
        io.dcloud.c cVar = new io.dcloud.c(broadcastReceiver, intentFilter);
        try {
            registerReceiver(cVar, intentFilter);
            this.c.put(broadcastReceiver.toString(), cVar);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
