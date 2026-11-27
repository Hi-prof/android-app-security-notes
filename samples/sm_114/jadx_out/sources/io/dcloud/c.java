package io.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class c extends android.content.BroadcastReceiver {
    io.dcloud.feature.internal.reflect.BroadcastReceiver a;
    android.content.IntentFilter b;

    c(io.dcloud.feature.internal.reflect.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter) {
        this.a = broadcastReceiver;
        this.b = intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        android.content.IntentFilter intentFilter;
        if (this.a == null || (intentFilter = this.b) == null || !intentFilter.hasAction(intent.getAction())) {
            return;
        }
        this.a.onReceive(context, intent);
    }
}
