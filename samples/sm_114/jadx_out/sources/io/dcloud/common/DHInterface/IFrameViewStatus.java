package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IFrameViewStatus {
    public static final byte STATUS_ON_DESTROY = 4;
    public static final byte STATUS_ON_INIT = 0;
    public static final byte STATUS_ON_LOADING = 2;
    public static final byte STATUS_ON_PAGE_CHANGED = 5;
    public static final byte STATUS_ON_PRESHOW = 3;
    public static final byte STATUS_ON_PRE_LOADING = 1;

    void addFrameViewListener(io.dcloud.common.DHInterface.IEventCallback iEventCallback);

    byte obtainStatus();

    void onDestroy();

    void onInit();

    void onLoading();

    void onPreLoading();

    void onPreShow(io.dcloud.common.DHInterface.IFrameView iFrameView);

    void removeFrameViewListener(io.dcloud.common.DHInterface.IEventCallback iEventCallback);
}
