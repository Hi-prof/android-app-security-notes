package com.bumptech.glide;

/* JADX INFO: loaded from: classes.dex */
final class GeneratedRequestManagerFactory implements com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory {
    GeneratedRequestManagerFactory() {
    }

    @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
    public com.bumptech.glide.RequestManager build(com.bumptech.glide.Glide glide, com.bumptech.glide.manager.Lifecycle lifecycle, com.bumptech.glide.manager.RequestManagerTreeNode requestManagerTreeNode, android.content.Context context) {
        return new io.dcloud.glide.GlideRequests(glide, lifecycle, requestManagerTreeNode, context);
    }
}
