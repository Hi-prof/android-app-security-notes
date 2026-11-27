package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class CreateShortResultReceiver extends android.content.BroadcastReceiver {
    public static final java.lang.String KEY_APPID = "appid";
    public static final java.lang.String KEY_NAME = "name";
    public static final java.lang.String KEY_SF = "sf";
    public static final java.lang.String KEY_SFD = "sfd";
    public static final java.lang.String KEY_VERSIONNAME = "v";
    private static final java.lang.String TAG = "CreateShortResultReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        android.util.Log.e(TAG, "onReceive: intent==" + intent);
    }
}
