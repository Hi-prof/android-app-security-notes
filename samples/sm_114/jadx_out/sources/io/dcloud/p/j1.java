package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class j1 extends io.dcloud.p.y3 implements io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener, io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener, io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener, io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener {
    private final io.dcloud.sdk.core.module.DCBaseAOL b;
    private android.view.View c;
    private final android.app.Activity d;
    protected io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener e;
    private android.util.SparseArray f;
    private io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener g;
    private io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener h;

    public j1(io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL, android.app.Activity activity) {
        this.f = new android.util.SparseArray();
        this.b = dCBaseAOL;
        this.d = activity;
        dCBaseAOL.setFeedAdCallback(this);
        this.f = dCBaseAOL.getNativeAdInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(java.lang.String str) {
        io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.e;
        if (feedAOLInteractionListener != null) {
            feedAOLInteractionListener.onClosed(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.e;
        if (feedAOLInteractionListener != null) {
            feedAOLInteractionListener.onClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener appDownloadListener = this.g;
        if (appDownloadListener != null) {
            appDownloadListener.onIdle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.e;
        if (feedAOLInteractionListener != null) {
            feedAOLInteractionListener.onRenderFail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.e;
        if (feedAOLInteractionListener != null) {
            feedAOLInteractionListener.onRenderSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.e;
        if (feedAOLInteractionListener != null) {
            feedAOLInteractionListener.onShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.e;
        if (feedAOLInteractionListener != null) {
            feedAOLInteractionListener.onShowError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener videoAdListener = this.h;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener videoAdListener = this.h;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdPaused();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener videoAdListener = this.h;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener videoAdListener = this.h;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdStartPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener videoAdListener = this.h;
        if (videoAdListener != null) {
            videoAdListener.onVideoLoad();
        }
    }

    @Override // io.dcloud.p.y3
    protected boolean b() {
        return false;
    }

    public boolean c() {
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.b;
        return dCBaseAOL != null && dCBaseAOL.isValid();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public void destroy() {
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.b;
        if (dCBaseAOL != null) {
            dCBaseAOL.destroy();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener
    public void dislike(android.app.Activity activity) {
        java.lang.Object obj = this.b;
        if (obj instanceof io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener) obj).dislike(activity);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public android.graphics.Bitmap getAdLogo() {
        return null;
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public io.dcloud.sdk.core.interfaces.AOLLoader.AppInfo getAppInfo() {
        java.lang.Object obj = this.f.get(1006, null);
        if (obj instanceof io.dcloud.sdk.core.interfaces.AOLLoader.AppInfo) {
            return (io.dcloud.sdk.core.interfaces.AOLLoader.AppInfo) obj;
        }
        return null;
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public java.lang.String getButtonText() {
        return this.f.get(1000, "").toString();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public java.lang.String getDescription() {
        return this.f.get(1001, "").toString();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public java.lang.String getIconUrl() {
        return this.f.get(1002, "").toString();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public java.util.List getImageList() {
        return (java.util.List) this.f.get(androidx.core.view.PointerIconCompat.TYPE_VERTICAL_TEXT, java.util.Collections.EMPTY_LIST);
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public int getInteractionType() {
        return ((java.lang.Integer) this.f.get(androidx.core.view.PointerIconCompat.TYPE_CROSSHAIR, 0)).intValue();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public int getMaterialType() {
        return ((java.lang.Integer) this.f.get(androidx.core.view.PointerIconCompat.TYPE_TEXT, 0)).intValue();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public java.lang.String getSource() {
        return this.f.get(1003, "").toString();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public java.lang.String getTitle() {
        return this.f.get(1004, "").toString();
    }

    public java.lang.String getType() {
        return this.b != null ? io.dcloud.p.e.b().c(this.b.getType()) : "";
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public double getVideoDuration() {
        return java.lang.Double.parseDouble(this.f.get(1010, 0).toString());
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener, io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener
    public android.view.View getVideoView(android.app.Activity activity) {
        java.lang.Object obj = this.b;
        if (obj instanceof io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener) {
            return ((io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener) obj).getVideoView(activity);
        }
        return null;
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public boolean isExpressAd() {
        android.util.SparseArray sparseArray = this.f;
        return sparseArray == null || ((java.lang.Boolean) sparseArray.get(io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.CODE_DECODE_portrait, java.lang.Boolean.TRUE)).booleanValue();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onClicked() {
        a(this.d, this.b);
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d();
            }
        });
        android.view.View view = this.c;
        android.app.Activity activity = this.d;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("4_");
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.b;
        sb.append(dCBaseAOL != null ? dCBaseAOL.getType() : "");
        io.dcloud.p.g4.a(view, activity, sb.toString());
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onClosed(final java.lang.String str) {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(str);
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener
    public void onDownloadActive(final long j, final long j2, final java.lang.String str, final java.lang.String str2) {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(j, j2, str, str2);
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener
    public void onDownloadFailed(final long j, final long j2, final java.lang.String str, final java.lang.String str2) {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(j, j2, str, str2);
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener
    public void onDownloadFinished(final long j, final java.lang.String str, final java.lang.String str2) {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(j, str, str2);
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener
    public void onDownloadPaused(final long j, final long j2, final java.lang.String str, final java.lang.String str2) {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(j, j2, str, str2);
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener
    public void onIdle() {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener
    public void onInstalled(final java.lang.String str, final java.lang.String str2) {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(str, str2);
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onPaidGet(long j, java.lang.String str, int i) {
        a(a(), this.b, j, str, i);
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener
    public void onProgressUpdate(final long j, final long j2) {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(j, j2);
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onRenderFail() {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.f();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onRenderSuccess() {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.g();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onShow() {
        b(this.d, this.b);
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.h();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onShowError() {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.j();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener
    public void onVideoAdComplete() {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.k();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener
    public void onVideoAdPaused() {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.l();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener
    public void onVideoAdResume() {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener
    public void onVideoAdStartPlay() {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.n();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener
    public void onVideoError(final int i, final java.lang.String str) {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(i, str);
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener
    public void onVideoLoad() {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.j1$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.o();
            }
        });
    }

    public void p() {
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.b;
        if (dCBaseAOL != null) {
            dCBaseAOL.render();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener
    public void registerViewForInteraction(android.app.Activity activity, android.widget.FrameLayout frameLayout, java.util.List list, java.util.List list2, java.util.List list3) {
        this.c = frameLayout;
        java.lang.Object obj = this.b;
        if (obj instanceof io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener) obj).registerViewForInteraction(activity, frameLayout, list, list2, list3);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener, io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener
    public void setAppDownloadListener(io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener appDownloadListener) {
        java.lang.Object obj = this.b;
        if (obj instanceof io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener) obj).setAppDownloadListener(this);
            this.g = appDownloadListener;
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener, io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener
    public void setVideoAdListener(io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener videoAdListener) {
        java.lang.Object obj = this.b;
        if (obj instanceof io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener) obj).setVideoAdListener(this);
            this.h = videoAdListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(long j, long j2, java.lang.String str, java.lang.String str2) {
        io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener appDownloadListener = this.g;
        if (appDownloadListener != null) {
            appDownloadListener.onDownloadFailed(j, j2, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(long j, long j2, java.lang.String str, java.lang.String str2) {
        io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener appDownloadListener = this.g;
        if (appDownloadListener != null) {
            appDownloadListener.onDownloadPaused(j, j2, str, str2);
        }
    }

    public android.view.View a(android.app.Activity activity) {
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.b;
        android.view.View expressAdView = dCBaseAOL != null ? dCBaseAOL.getExpressAdView(activity) : null;
        this.c = expressAdView;
        return expressAdView;
    }

    @Override // io.dcloud.p.y3
    protected android.app.Activity a() {
        return this.d;
    }

    public void a(io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener) {
        this.e = feedAOLInteractionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j, long j2, java.lang.String str, java.lang.String str2) {
        io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener appDownloadListener = this.g;
        if (appDownloadListener != null) {
            appDownloadListener.onDownloadActive(j, j2, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j, java.lang.String str, java.lang.String str2) {
        io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener appDownloadListener = this.g;
        if (appDownloadListener != null) {
            appDownloadListener.onDownloadFinished(j, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(java.lang.String str, java.lang.String str2) {
        io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener appDownloadListener = this.g;
        if (appDownloadListener != null) {
            appDownloadListener.onInstalled(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, java.lang.String str) {
        io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener videoAdListener = this.h;
        if (videoAdListener != null) {
            videoAdListener.onVideoError(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j, long j2) {
        io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener videoAdListener = this.h;
        if (videoAdListener != null) {
            videoAdListener.onProgressUpdate(j, j2);
        }
    }
}
