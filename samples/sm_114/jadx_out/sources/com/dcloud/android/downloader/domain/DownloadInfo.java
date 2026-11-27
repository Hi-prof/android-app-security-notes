package com.dcloud.android.downloader.domain;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DownloadInfo implements java.io.Serializable {
    public static final int STATUS_COMPLETED = 5;
    public static final int STATUS_DOWNLOADING = 2;
    public static final int STATUS_ERROR = 6;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_PAUSED = 4;
    public static final int STATUS_PREPARE_DOWNLOAD = 1;
    public static final int STATUS_REMOVED = 7;
    public static final int STATUS_WAIT = 3;
    private android.content.Context context;
    private long createAt;
    private transient com.dcloud.android.downloader.callback.DownloadListener downloadListener;
    private java.util.List<com.dcloud.android.downloader.domain.DownloadThreadInfo> downloadThreadInfos;
    private com.dcloud.android.downloader.exception.DownloadException exception;
    private int id;
    private java.lang.String location;
    private java.lang.String path;
    private long progress;
    private long size;
    private int status;
    private int supportRanges;
    private java.lang.Object tag;
    private java.lang.String uri;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static final class Builder {
        private static final java.lang.String DEFAULT_ENCODE = "utf-8";
        private long createAt = -1;
        private java.lang.String id;
        private java.lang.String path;
        private java.lang.String url;

        public com.dcloud.android.downloader.domain.DownloadInfo build(android.content.Context context) {
            com.dcloud.android.downloader.domain.DownloadInfo downloadInfo = new com.dcloud.android.downloader.domain.DownloadInfo(context);
            if (android.text.TextUtils.isEmpty(this.url)) {
                throw new com.dcloud.android.downloader.exception.DownloadException(0, "uri cannot be null.");
            }
            downloadInfo.setUri(this.url);
            if (android.text.TextUtils.isEmpty(this.path)) {
                throw new com.dcloud.android.downloader.exception.DownloadException(1, "path cannot be null.");
            }
            downloadInfo.setPath(this.path);
            if (this.createAt == -1) {
                setCreateAt(java.lang.System.currentTimeMillis());
            }
            downloadInfo.setId(this.url.hashCode());
            if (android.text.TextUtils.isEmpty(this.id)) {
                downloadInfo.setId(this.url.hashCode());
            }
            return downloadInfo;
        }

        public com.dcloud.android.downloader.domain.DownloadInfo.Builder setCreateAt(long j) {
            this.createAt = j;
            return this;
        }

        public void setId(java.lang.String str) {
            this.id = str;
        }

        public com.dcloud.android.downloader.domain.DownloadInfo.Builder setPath(java.lang.String str) {
            this.path = str;
            return this;
        }

        public com.dcloud.android.downloader.domain.DownloadInfo.Builder setUrl(java.lang.String str) {
            this.url = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface DownloadStatus {
    }

    public DownloadInfo(android.content.Context context) {
        this.context = context;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.id == ((com.dcloud.android.downloader.domain.DownloadInfo) obj).id;
    }

    public android.content.Context getContext() {
        return this.context;
    }

    public long getCreateAt() {
        return this.createAt;
    }

    public com.dcloud.android.downloader.callback.DownloadListener getDownloadListener() {
        return this.downloadListener;
    }

    public java.util.List<com.dcloud.android.downloader.domain.DownloadThreadInfo> getDownloadThreadInfos() {
        return this.downloadThreadInfos;
    }

    public java.lang.String getDownloadUrl() {
        return android.text.TextUtils.isEmpty(this.location) ? getUri() : this.location;
    }

    public com.dcloud.android.downloader.exception.DownloadException getException() {
        return this.exception;
    }

    public int getId() {
        return this.id;
    }

    public java.lang.String getLocation() {
        return this.location;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public long getProgress() {
        return this.progress;
    }

    public long getSize() {
        return this.size;
    }

    public int getStatus() {
        return this.status;
    }

    public int getSupportRanges() {
        return this.supportRanges;
    }

    public java.lang.Object getTag() {
        return this.tag;
    }

    public java.lang.String getUri() {
        return this.uri;
    }

    public int hashCode() {
        return this.id;
    }

    public boolean isPause() {
        int i = this.status;
        return i == 4 || i == 6 || i == 7;
    }

    public boolean isSupportRanges() {
        return this.supportRanges == 0;
    }

    public void setCreateAt(long j) {
        this.createAt = j;
    }

    public void setDownloadListener(com.dcloud.android.downloader.callback.DownloadListener downloadListener) {
        this.downloadListener = downloadListener;
    }

    public void setDownloadThreadInfos(java.util.List<com.dcloud.android.downloader.domain.DownloadThreadInfo> list) {
        this.downloadThreadInfos = list;
    }

    public void setException(com.dcloud.android.downloader.exception.DownloadException downloadException) {
        this.exception = downloadException;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLocation(java.lang.String str) {
        this.location = str;
    }

    public void setPath(java.lang.String str) {
        this.path = str;
    }

    public void setProgress(long j) {
        this.progress = j;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setSupportRanges(int i) {
        this.supportRanges = i;
    }

    public void setTag(java.lang.Object obj) {
        this.tag = obj;
    }

    public void setUri(java.lang.String str) {
        this.uri = str;
    }

    public void setSupportRanges(boolean z) {
        this.supportRanges = !z ? 1 : 0;
    }
}
