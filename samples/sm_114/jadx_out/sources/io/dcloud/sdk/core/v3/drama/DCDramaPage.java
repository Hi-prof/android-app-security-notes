package io.dcloud.sdk.core.v3.drama;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public interface DCDramaPage {
    void destroy();

    androidx.fragment.app.Fragment getFragment();

    void setDramaAdListener(io.dcloud.sdk.core.v3.drama.DCDramaAdListener dCDramaAdListener);

    void setDramaListener(io.dcloud.sdk.core.v3.drama.DCDramaListener dCDramaListener);

    void setDramaUnlockListener(io.dcloud.sdk.core.v3.drama.DCDramaUnlockListener dCDramaUnlockListener);

    void setHideBack(boolean z);

    void setLoadListener(io.dcloud.sdk.core.v3.drama.DCDramaPageLoaderListener dCDramaPageLoaderListener);
}
