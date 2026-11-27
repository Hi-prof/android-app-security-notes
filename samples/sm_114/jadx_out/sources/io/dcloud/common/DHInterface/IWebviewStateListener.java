package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IWebviewStateListener extends io.dcloud.common.DHInterface.ICallBack {
    public static final int ON_LOAD_RESOURCE = 2;
    public static final int ON_PAGE_FINISHED = 1;
    public static final int ON_PAGE_STARTED = 0;
    public static final int ON_PROGRESS_CHANGED = 3;
    public static final int ON_RECEIVED_ERROR = 5;
    public static final int ON_RECEIVED_TITLE = 4;
    public static final int ON_WEBVIEW_READY = -1;
    public static final int ON_WEBVIEW_RENDERING = 6;
}
