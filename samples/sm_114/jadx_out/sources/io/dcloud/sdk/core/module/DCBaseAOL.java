package io.dcloud.sdk.core.module;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DCBaseAOL {
    private int acpt;
    private java.lang.String appId;
    private java.lang.String appKey;
    protected io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener feedAdCallback;
    private int feedType;
    private boolean isEnd;
    private java.lang.String loadId;
    private final android.app.Activity mActivity;
    private java.lang.String miniRequestType;
    private int miniType;
    private org.json.JSONObject params;
    private java.lang.String path;
    protected java.lang.String plat;
    private final io.dcloud.sdk.core.entry.DCloudAOLSlot slot;
    private java.lang.String slotId;
    private io.dcloud.sdk.core.module.DCBaseAOL subAd;
    protected int type;
    protected io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener videoAdCallback;
    private int ECpm = -1;
    protected int showSort = -1;
    protected int level = -1;
    private boolean isSlotSupportBidding = false;
    private int intersType = 1;
    private boolean isExpressAd = true;
    private java.util.Map<java.lang.Integer, java.lang.Object> extraData = new java.util.HashMap();

    public DCBaseAOL(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, android.app.Activity activity) {
        this.slot = dCloudAOLSlot;
        this.mActivity = activity;
    }

    public void biddingFail(int i, int i2, int i3) {
        io.dcloud.p.c3.b("uniAd", "bidding fail:" + getType() + ",Win:" + i + ",second:" + i2 + ",slot:" + getSlotId());
    }

    public void biddingSuccess(int i, int i2) {
        io.dcloud.p.c3.b("uniAd", "bidding success:" + getType() + ",Win:" + i + ",second:" + i2 + ",slot:" + getSlotId());
    }

    public abstract void destroy();

    public int getAcpt() {
        return this.acpt;
    }

    public android.app.Activity getActivity() {
        return this.mActivity;
    }

    public int getAdStatus() {
        return -1;
    }

    public int getAdType() {
        return this.type;
    }

    public java.lang.String getAppId() {
        return this.appId;
    }

    protected java.lang.String getAppKey() {
        return this.appKey;
    }

    public int getBiddingECPM() {
        return this.ECpm;
    }

    public java.lang.String getDCloudId() {
        return this.slot.getAdpid();
    }

    public java.lang.String getEI() {
        return this.slot.getEI();
    }

    public android.view.View getExpressAdView(android.app.Activity activity) {
        return null;
    }

    public java.util.Map<java.lang.Integer, java.lang.Object> getExtraData() {
        return this.extraData;
    }

    public io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener getFeedAdCallback() {
        return this.feedAdCallback;
    }

    public int getFeedType() {
        return this.feedType;
    }

    public int getIntersType() {
        return this.intersType;
    }

    public java.lang.String getLoadId() {
        return this.loadId;
    }

    public java.lang.String getMiniRequestType() {
        return this.miniRequestType;
    }

    public int getMiniType() {
        return this.miniType;
    }

    public android.util.SparseArray<java.lang.Object> getNativeAdInfo() {
        return null;
    }

    public org.json.JSONObject getParams() {
        return this.params;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public void getRetryRewardResult(io.dcloud.sdk.core.interfaces.AOLLoader.GetConvertResultListener getConvertResultListener) {
        if (getConvertResultListener != null) {
            getConvertResultListener.onError(-5100, "type:" + getType() + ";code:-1;message:暂无缓存任务");
        }
    }

    public int getShowSort() {
        return this.showSort;
    }

    public io.dcloud.sdk.core.entry.DCloudAOLSlot getSlot() {
        return this.slot;
    }

    public java.lang.String getSlotId() {
        return this.slotId;
    }

    public io.dcloud.sdk.core.module.DCBaseAOL getSubAd() {
        return this.subAd;
    }

    public java.lang.String getTid() {
        return io.dcloud.sdk.core.util.TidUtil.getTid(getType(), getAdType());
    }

    public java.lang.String getType() {
        return this.plat;
    }

    public io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener getVideoAdCallback() {
        return this.videoAdCallback;
    }

    public boolean isCustom() {
        return false;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

    public boolean isExpressAd() {
        return this.isExpressAd;
    }

    public final boolean isPlatformSupportBidding() {
        return io.dcloud.sdk.core.util.Const.TYPE_GDT.equals(getType()) || io.dcloud.sdk.core.util.Const.TYPE_BD.equals(getType()) || io.dcloud.sdk.core.util.Const.TYPE_KS.equals(getType());
    }

    public boolean isSlotSupportBidding() {
        return this.isSlotSupportBidding;
    }

    public abstract boolean isValid();

    public void render() {
    }

    public void requestRetryRewardConvert(io.dcloud.sdk.core.interfaces.AOLLoader.RequestConvertResultListener requestConvertResultListener) {
        if (requestConvertResultListener != null) {
            requestConvertResultListener.onError(-5100, "type:" + getType() + ";code:-1;message:暂无缓存任务");
        }
    }

    public void setAcpt(int i) {
        this.acpt = i;
    }

    public final void setAppId(java.lang.String str) {
        this.appId = str;
    }

    public void setAppKey(java.lang.String str) {
        this.appKey = str;
    }

    public final void setBiddingECPM(int i) {
        if (i > 0) {
            io.dcloud.p.c3.c(getType() + " current cpm:" + i);
            this.ECpm = i;
        }
    }

    public void setEnd(boolean z) {
        this.isEnd = z;
    }

    public void setExpressAd(boolean z) {
        this.isExpressAd = z;
    }

    public void setExtraData(java.util.Map<java.lang.Integer, java.lang.Object> map) {
        this.extraData = map;
    }

    public final void setFeedAdCallback(io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener) {
        this.feedAdCallback = feedAOLInteractionListener;
    }

    public void setFeedType(int i) {
        this.feedType = i;
    }

    public void setIntersType(int i) {
        this.intersType = i;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setLoadId(java.lang.String str) {
        this.loadId = str;
    }

    public void setMiniRequestType(java.lang.String str) {
        this.miniRequestType = str;
    }

    public void setMiniType(int i) {
        this.miniType = i;
    }

    public void setParams(org.json.JSONObject jSONObject) {
        this.params = jSONObject;
    }

    public void setPath(java.lang.String str) {
        this.path = str;
    }

    public void setShowSort(int i) {
        this.showSort = i;
    }

    public final void setSlot(java.lang.String str) {
        this.slotId = str;
    }

    public void setSlotSupportBidding(boolean z) {
        this.isSlotSupportBidding = z;
    }

    public void setSubAd(io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL) {
        this.subAd = dCBaseAOL;
    }

    public final void setVideoAdCallback(io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener vAOLInteractionListener) {
        this.videoAdCallback = vAOLInteractionListener;
    }

    public void startLoadTime() {
    }
}
