package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DisplayManagerChangeListener implements android.hardware.display.DisplayManager.DisplayListener {
    private final android.app.Activity activity;
    private final android.hardware.display.DisplayManager displayManager;
    private final io.dcloud.EntryProxy mEntryProxy;

    public DisplayManagerChangeListener(android.hardware.display.DisplayManager displayManager, android.app.Activity activity, io.dcloud.EntryProxy entryProxy) {
        this.displayManager = displayManager;
        this.activity = activity;
        this.mEntryProxy = entryProxy;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int i) {
        io.dcloud.EntryProxy entryProxy;
        if (i == 0) {
            int rotation = this.activity.getWindowManager().getDefaultDisplay().getRotation();
            if ((rotation == 3 || rotation == 1) && (entryProxy = this.mEntryProxy) != null) {
                entryProxy.onConfigurationChanged(this.activity, rotation);
            }
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int i) {
    }

    public void register() {
        if (android.os.Build.VERSION.SDK_INT < 36 || io.dcloud.common.adapter.util.AndroidResources.sAppTargetSdkVersion < 36) {
            return;
        }
        this.displayManager.registerDisplayListener(this, null);
    }

    public void unregister() {
        if (android.os.Build.VERSION.SDK_INT < 36 || io.dcloud.common.adapter.util.AndroidResources.sAppTargetSdkVersion < 36) {
            return;
        }
        this.displayManager.unregisterDisplayListener(this);
    }
}
