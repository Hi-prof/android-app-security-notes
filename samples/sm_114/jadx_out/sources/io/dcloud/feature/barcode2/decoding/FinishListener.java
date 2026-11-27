package io.dcloud.feature.barcode2.decoding;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public final class FinishListener implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnCancelListener, java.lang.Runnable {
    private final android.app.Activity activityToFinish;

    public FinishListener(android.app.Activity activity) {
        this.activityToFinish = activity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(android.content.DialogInterface dialogInterface) {
        run();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        run();
    }

    @Override // java.lang.Runnable
    public void run() {
    }
}
