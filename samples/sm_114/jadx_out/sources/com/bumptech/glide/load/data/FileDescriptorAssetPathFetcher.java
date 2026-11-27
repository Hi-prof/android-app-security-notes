package com.bumptech.glide.load.data;

/* JADX INFO: loaded from: classes.dex */
public class FileDescriptorAssetPathFetcher extends com.bumptech.glide.load.data.AssetPathFetcher<android.content.res.AssetFileDescriptor> {
    public FileDescriptorAssetPathFetcher(android.content.res.AssetManager assetManager, java.lang.String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public android.content.res.AssetFileDescriptor loadResource(android.content.res.AssetManager assetManager, java.lang.String str) throws java.io.IOException {
        return assetManager.openFd(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public void close(android.content.res.AssetFileDescriptor assetFileDescriptor) throws java.io.IOException {
        assetFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public java.lang.Class<android.content.res.AssetFileDescriptor> getDataClass() {
        return android.content.res.AssetFileDescriptor.class;
    }
}
