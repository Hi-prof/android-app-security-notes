package io.dcloud.sdk.core.v3.fd;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCFeedAOL implements io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener, io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener {
    private io.dcloud.p.j1 a;
    protected io.dcloud.sdk.core.v3.fd.DCFeedAOLListener b;

    public DCFeedAOL(io.dcloud.p.j1 j1Var) {
        this.a = j1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        this.a.p();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public void destroy() {
        io.dcloud.p.j1 j1Var = this.a;
        if (j1Var != null) {
            j1Var.destroy();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener
    public void dislike(android.app.Activity activity) {
        this.a.dislike(activity);
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public android.graphics.Bitmap getAdLogo() {
        return this.a.getAdLogo();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public io.dcloud.sdk.core.interfaces.AOLLoader.AppInfo getAppInfo() {
        return this.a.getAppInfo();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public java.lang.String getButtonText() {
        return this.a.getButtonText();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public java.lang.String getDescription() {
        return this.a.getDescription();
    }

    public android.view.View getFeedAOLView(android.app.Activity activity) {
        io.dcloud.p.j1 j1Var = this.a;
        if (j1Var != null) {
            return j1Var.a(activity);
        }
        return null;
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public java.lang.String getIconUrl() {
        return this.a.getIconUrl();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public java.util.List<io.dcloud.sdk.core.interfaces.AOLLoader.AdImage> getImageList() {
        return this.a.getImageList();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public int getInteractionType() {
        return this.a.getInteractionType();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public int getMaterialType() {
        return this.a.getMaterialType();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public java.lang.String getSource() {
        return this.a.getSource();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public java.lang.String getTitle() {
        return this.a.getTitle();
    }

    public java.lang.String getType() {
        io.dcloud.p.j1 j1Var = this.a;
        return j1Var != null ? j1Var.getType() : "";
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public double getVideoDuration() {
        return this.a.getVideoDuration();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener, io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener
    public android.view.View getVideoView(android.app.Activity activity) {
        if (java.lang.Thread.currentThread() == io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().getLooper().getThread()) {
            return this.a.getVideoView(activity);
        }
        throw new java.lang.RuntimeException("getVideoView must be called on the main thread");
    }

    public boolean isExpressAd() {
        return this.a.isExpressAd();
    }

    public boolean isValid() {
        io.dcloud.p.j1 j1Var = this.a;
        return j1Var != null && j1Var.c();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onClicked() {
        io.dcloud.sdk.core.v3.fd.DCFeedAOLListener dCFeedAOLListener = this.b;
        if (dCFeedAOLListener != null) {
            dCFeedAOLListener.onClick();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onClosed(java.lang.String str) {
        io.dcloud.sdk.core.v3.fd.DCFeedAOLListener dCFeedAOLListener = this.b;
        if (dCFeedAOLListener != null) {
            dCFeedAOLListener.onClosed(str);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onPaidGet(long j, java.lang.String str, int i) {
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onRenderFail() {
        io.dcloud.sdk.core.v3.fd.DCFeedAOLListener dCFeedAOLListener = this.b;
        if (dCFeedAOLListener != null) {
            dCFeedAOLListener.onRenderFail();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onRenderSuccess() {
        io.dcloud.sdk.core.v3.fd.DCFeedAOLListener dCFeedAOLListener = this.b;
        if (dCFeedAOLListener != null) {
            dCFeedAOLListener.onRenderSuccess();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onShow() {
        io.dcloud.sdk.core.v3.fd.DCFeedAOLListener dCFeedAOLListener = this.b;
        if (dCFeedAOLListener != null) {
            dCFeedAOLListener.onShow();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onShowError() {
        io.dcloud.sdk.core.v3.fd.DCFeedAOLListener dCFeedAOLListener = this.b;
        if (dCFeedAOLListener != null) {
            dCFeedAOLListener.onShowError();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener
    public void registerViewForInteraction(android.app.Activity activity, android.widget.FrameLayout frameLayout, java.util.List<android.view.View> list, java.util.List<android.view.View> list2, java.util.List<android.widget.ImageView> list3) {
        this.a.a(this);
        this.a.registerViewForInteraction(activity, frameLayout, list, list2, list3);
    }

    public void render() {
        io.dcloud.p.j1 j1Var = this.a;
        if (j1Var != null) {
            j1Var.a(this);
            io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.sdk.core.v3.fd.DCFeedAOL$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            });
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener, io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener
    public void setAppDownloadListener(io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener appDownloadListener) {
        this.a.setAppDownloadListener(appDownloadListener);
    }

    public void setFeedAOLListener(io.dcloud.sdk.core.v3.fd.DCFeedAOLListener dCFeedAOLListener) {
        this.b = dCFeedAOLListener;
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener, io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener
    public void setVideoAdListener(io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener videoAdListener) {
        this.a.setVideoAdListener(videoAdListener);
    }
}
