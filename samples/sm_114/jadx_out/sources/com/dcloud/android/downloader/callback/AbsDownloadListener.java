package com.dcloud.android.downloader.callback;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbsDownloadListener implements com.dcloud.android.downloader.callback.DownloadListener {
    private java.lang.ref.SoftReference<java.lang.Object> userTag;

    public AbsDownloadListener() {
    }

    public java.lang.ref.SoftReference<java.lang.Object> getUserTag() {
        return this.userTag;
    }

    public void setUserTag(java.lang.ref.SoftReference<java.lang.Object> softReference) {
        this.userTag = softReference;
    }

    public AbsDownloadListener(java.lang.ref.SoftReference<java.lang.Object> softReference) {
        this.userTag = softReference;
    }
}
