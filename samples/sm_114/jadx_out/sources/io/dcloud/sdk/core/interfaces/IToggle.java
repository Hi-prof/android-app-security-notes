package io.dcloud.sdk.core.interfaces;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public interface IToggle {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface CADLoadListener {
        void onLoadFail(int i, java.lang.String str);

        void onLoadSuccess(java.util.List<? extends io.dcloud.sdk.core.module.DCBaseAOL> list);
    }

    java.util.List<io.dcloud.sdk.core.module.DCBaseAOL> getSuccessAds();

    boolean isLoading();

    void setCADLoadListener(io.dcloud.sdk.core.interfaces.IToggle.CADLoadListener cADLoadListener);
}
