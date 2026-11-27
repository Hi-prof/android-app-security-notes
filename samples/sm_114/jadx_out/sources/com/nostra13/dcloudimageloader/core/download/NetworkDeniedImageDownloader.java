package com.nostra13.dcloudimageloader.core.download;

/* JADX INFO: loaded from: classes.dex */
public class NetworkDeniedImageDownloader implements com.nostra13.dcloudimageloader.core.download.ImageDownloader {
    private final com.nostra13.dcloudimageloader.core.download.ImageDownloader wrappedDownloader;

    public NetworkDeniedImageDownloader(com.nostra13.dcloudimageloader.core.download.ImageDownloader imageDownloader) {
        this.wrappedDownloader = imageDownloader;
    }

    @Override // com.nostra13.dcloudimageloader.core.download.ImageDownloader
    public java.io.InputStream getStream(java.lang.String str, java.lang.Object obj) throws java.io.IOException {
        int iOrdinal = com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.ofUri(str).ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            throw new java.lang.IllegalStateException();
        }
        return this.wrappedDownloader.getStream(str, obj);
    }
}
