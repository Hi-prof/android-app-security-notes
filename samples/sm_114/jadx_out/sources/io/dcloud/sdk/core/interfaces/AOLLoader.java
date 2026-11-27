package io.dcloud.sdk.core.interfaces;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public interface AOLLoader {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface AOLStartCallback {
        void onError(int i, java.lang.String str);

        void onSuccess();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface AdImage {
        int getHeight();

        java.lang.String getUrl();

        int getWidth();

        boolean isValid();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface AdInteractionListener {
        void onAdClicked();

        void onAdShow();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface AdVideo {
        java.lang.String getVideoUrl();

        void reportVideoAutoStart();

        void reportVideoBreak(long j);

        void reportVideoContinue(long j);

        void reportVideoError(long j, int i, int i2);

        void reportVideoFinish();

        void reportVideoPause(long j);

        void reportVideoStart();

        void reportVideoStartError(int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface AppDownloadListener {
        void onDownloadActive(long j, long j2, java.lang.String str, java.lang.String str2);

        void onDownloadFailed(long j, long j2, java.lang.String str, java.lang.String str2);

        void onDownloadFinished(long j, java.lang.String str, java.lang.String str2);

        void onDownloadPaused(long j, long j2, java.lang.String str, java.lang.String str2);

        void onIdle();

        void onInstalled(java.lang.String str, java.lang.String str2);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface AppInfo {
        java.lang.String getApkSize();

        java.lang.String getAppDownloadCount();

        java.lang.String getAppName();

        java.lang.String getAppPackageName();

        java.lang.String getAppScore();

        java.lang.String getAppVersion();

        java.lang.String getDeveloperName();

        java.lang.String getFunctionDescUrl();

        java.lang.String getPermissionInfoUrl();

        java.lang.String getPrivacyUrl();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface ContentPageVideoListener extends io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener {
        void onComplete(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem);

        void onError(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem);

        void onPause(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem);

        void onResume(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem);

        void onStart(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface DramaListener {
        void onFullDisplay(int i);

        void onNextPlaylet();

        void onPause();

        void onPlayComplete();

        void onPlayEnd();

        void onPlayError(int i, java.lang.String str);

        void onPlayStart();

        void onProgress(long j);

        void onResume();

        void onSeek(long j, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface DramaPageLoaderListener {
        void onError(int i, java.lang.String str);

        void onSuccess();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface DramaResultListener {
        void onError(int i, java.lang.String str);

        void onSuccess(java.util.List<io.dcloud.sdk.core.entry.DCDramaInfo> list, java.util.Map<java.lang.String, java.lang.Object> map);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface DramaRewardListener extends io.dcloud.sdk.core.interfaces.AOLLoader.RewVAOLInteractionListener {
        void onLoadFail(int i, java.lang.String str, org.json.JSONObject jSONObject);

        void onLoadSuccess();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface DramaUnlockListener {
        void showCustomAd(io.dcloud.sdk.core.entry.DCDramaInfo dCDramaInfo);

        void unlockEnd(io.dcloud.sdk.core.entry.DCDramaInfo dCDramaInfo, boolean z, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map);

        void unlockStart(io.dcloud.sdk.core.entry.DCDramaInfo dCDramaInfo, java.util.Map<java.lang.String, java.lang.Object> map);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface DrawAOLInteractionListener extends io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener {
        void onEnd();

        void onError();

        void onPause();

        void onResume();

        void onStart();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface FeedAOLInteractionListener {
        void onClicked();

        void onClosed(java.lang.String str);

        void onPaidGet(long j, java.lang.String str, int i);

        void onRenderFail();

        void onRenderSuccess();

        void onShow();

        void onShowError();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface GetConvertResultListener {
        void onError(int i, java.lang.String str);

        void onSuccess(io.dcloud.sdk.core.entry.DCRetryRewardEntry dCRetryRewardEntry, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface NativeAOLInteractionListener extends io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener {
        void destroy();

        android.graphics.Bitmap getAdLogo();

        io.dcloud.sdk.core.interfaces.AOLLoader.AppInfo getAppInfo();

        java.lang.String getButtonText();

        java.lang.String getDescription();

        java.lang.String getIconUrl();

        java.util.List<io.dcloud.sdk.core.interfaces.AOLLoader.AdImage> getImageList();

        int getInteractionType();

        int getMaterialType();

        java.lang.String getSource();

        java.lang.String getTitle();

        double getVideoDuration();

        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener
        android.view.View getVideoView(android.app.Activity activity);

        boolean isExpressAd();

        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener
        void setAppDownloadListener(io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener appDownloadListener);

        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener
        void setVideoAdListener(io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener videoAdListener);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface NativeAOLListener {
        void dislike(android.app.Activity activity);

        android.view.View getVideoView(android.app.Activity activity);

        void registerViewForInteraction(android.app.Activity activity, android.widget.FrameLayout frameLayout, java.util.List<android.view.View> list, java.util.List<android.view.View> list2, java.util.List<android.widget.ImageView> list3);

        void setAppDownloadListener(io.dcloud.sdk.core.interfaces.AOLLoader.AppDownloadListener appDownloadListener);

        void setVideoAdListener(io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener videoAdListener);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface RequestConvertResultListener {
        void onError(int i, java.lang.String str);

        void onSuccess();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface RewVAOLInteractionListener extends io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener {
        void onReward(org.json.JSONObject jSONObject);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface SplashAOLLoadListener {
        void onError(int i, java.lang.String str);

        void redBag(android.view.View view, android.widget.FrameLayout.LayoutParams layoutParams);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface VAOLInteractionListener {
        void onClick();

        void onClose();

        void onPaidGet(long j, java.lang.String str, int i);

        void onShow();

        void onShowError(int i, java.lang.String str);

        void onSkip();

        void onVideoPlayEnd();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface VideoAdListener {
        void onProgressUpdate(long j, long j2);

        void onVideoAdComplete();

        void onVideoAdPaused();

        void onVideoAdResume();

        void onVideoAdStartPlay();

        void onVideoError(int i, java.lang.String str);

        void onVideoLoad();
    }

    boolean getPersonalAOL(android.content.Context context);

    void setPersonalAOL(android.content.Context context, boolean z);

    void setPrivacyConfig(io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig);

    void start(io.dcloud.sdk.core.interfaces.AOLLoader.AOLStartCallback aOLStartCallback);

    void updatePrivacyConfig(android.content.Context context, org.json.JSONObject jSONObject);

    java.util.Map<java.lang.String, java.lang.Object> verify(java.util.Map<java.lang.String, java.lang.Object> map);
}
