package com.nostra13.dcloudimageloader.core.download;

/* JADX INFO: loaded from: classes.dex */
public class SlowNetworkImageDownloader implements com.nostra13.dcloudimageloader.core.download.ImageDownloader {
    private final com.nostra13.dcloudimageloader.core.download.ImageDownloader wrappedDownloader;

    public SlowNetworkImageDownloader(com.nostra13.dcloudimageloader.core.download.ImageDownloader imageDownloader) {
        this.wrappedDownloader = imageDownloader;
    }

    @Override // com.nostra13.dcloudimageloader.core.download.ImageDownloader
    public java.io.InputStream getStream(java.lang.String str, java.lang.Object obj) throws java.io.IOException {
        java.io.InputStream stream = this.wrappedDownloader.getStream(str, obj);
        int iOrdinal = com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.ofUri(str).ordinal();
        return (iOrdinal == 1 || iOrdinal == 2) ? new com.nostra13.dcloudimageloader.core.assist.FlushedInputStream(stream) : stream;
    }
}
