package io.dcloud.api.custom.type.feed;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class UniAdCustomNativeAdLoader extends io.dcloud.api.custom.type.UniAdCustomBaseLoader {
    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void destroy() {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final boolean isReady() {
        return false;
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onAdClicked() {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onAdClosed() {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onAdPlayEnd() {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onAdPlayError(int i, java.lang.String str) {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onAdShow() {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onAdSkip() {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onLoadFail(int i, java.lang.String str) {
        super.onLoadFail(i, str);
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onLoadSuccess(java.util.List<? extends io.dcloud.api.custom.type.feed.UniAdCustomNativeAd> list) {
        super.onLoadSuccess(list);
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void setBidPrice(int i) {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void show(java.lang.Object obj) {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onLoadSuccess() {
        throw new java.lang.RuntimeException("should call method 'onLoadSuccess(List ads)'.");
    }
}
