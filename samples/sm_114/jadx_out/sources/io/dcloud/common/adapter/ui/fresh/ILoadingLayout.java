package io.dcloud.common.adapter.ui.fresh;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface ILoadingLayout {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public enum State {
        NONE,
        RESET,
        PULL_TO_REFRESH,
        RELEASE_TO_REFRESH,
        REFRESHING,
        LOADING,
        NO_MORE_DATA
    }

    int getContentSize();

    io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State getState();

    void onPull(float f);

    void setState(io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state);
}
