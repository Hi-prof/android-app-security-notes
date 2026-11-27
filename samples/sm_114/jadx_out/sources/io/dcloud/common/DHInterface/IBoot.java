package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IBoot extends io.dcloud.common.DHInterface.ISysEventListener {
    void onPause();

    void onRestart(android.content.Context context);

    void onResume();

    void onStart(android.content.Context context, android.os.Bundle bundle, java.lang.String[] strArr);

    void onStop();
}
