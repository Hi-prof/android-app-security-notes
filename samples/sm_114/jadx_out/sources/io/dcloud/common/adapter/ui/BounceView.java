package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class BounceView implements io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.OnStateChangeListener {
    static final java.lang.String STATE_CHANGED_TEMPLATE = "{status:'%s'}";
    static final java.lang.String[] keys = {"top", "left", "right", "bottom"};
    int[] changeStateHeights;
    io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State mCurState;
    io.dcloud.common.adapter.ui.AdaFrameView mFrameView;
    org.json.JSONObject mJSONObject;
    java.lang.String[] mPositions;
    boolean[] mSupports;
    io.dcloud.common.adapter.ui.AdaWebview mWebview;
    private float mWebviewScale;
    int[] maxPullHeights;

    BounceView(io.dcloud.common.adapter.ui.AdaFrameView adaFrameView, io.dcloud.common.adapter.ui.AdaWebview adaWebview) {
        java.lang.String[] strArr = keys;
        this.changeStateHeights = new int[strArr.length];
        this.maxPullHeights = new int[strArr.length];
        this.mPositions = new java.lang.String[strArr.length];
        this.mSupports = new boolean[strArr.length];
        this.mCurState = null;
        this.mFrameView = adaFrameView;
        this.mWebview = adaWebview;
        this.mWebviewScale = adaWebview.getScaleOfOpenerWebview();
    }

    public void checkOffset(io.dcloud.common.adapter.ui.AdaFrameView adaFrameView, final io.dcloud.common.adapter.ui.AdaWebViewParent.PullToRefreshWebViewExt pullToRefreshWebViewExt, org.json.JSONObject jSONObject, int i, int i2) {
        org.json.JSONObject jSONObject2 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject, "offset");
        if (jSONObject2 != null) {
            java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObject2, "top");
            java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONObject2, "left");
            java.lang.String string3 = io.dcloud.common.util.JSONUtil.getString(jSONObject2, "right");
            if (android.text.TextUtils.isEmpty(string)) {
                if (!android.text.TextUtils.isEmpty(string3) && (adaFrameView.obtainMainView() instanceof com.dcloud.android.widget.SlideLayout)) {
                    ((com.dcloud.android.widget.SlideLayout) adaFrameView.obtainMainView()).setOffset("right", string3, this.mWebview.getScale());
                    return;
                } else {
                    if (android.text.TextUtils.isEmpty(string2) || !(adaFrameView.obtainMainView() instanceof com.dcloud.android.widget.SlideLayout)) {
                        return;
                    }
                    ((com.dcloud.android.widget.SlideLayout) adaFrameView.obtainMainView()).setOffset("left", string2, this.mWebview.getScale());
                    return;
                }
            }
            io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mWebview;
            int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(string, adaWebview.mViewOptions.height, i2, adaWebview.getScale());
            if (iConvertToScreenInt < i) {
                pullToRefreshWebViewExt.smoothScrollTo(-iConvertToScreenInt);
                this.mWebview.obtainWindowView().postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.BounceView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pullToRefreshWebViewExt.smoothScrollTo(0);
                    }
                }, 250L);
            } else {
                if (iConvertToScreenInt <= i2) {
                    i2 = iConvertToScreenInt;
                }
                pullToRefreshWebViewExt.smoothScrollTo(-i2);
                pullToRefreshWebViewExt.doPullRefreshing(true, 250L);
            }
        }
    }

    public void onResize() {
        parseJsonOption(this.mJSONObject);
    }

    @Override // io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.OnStateChangeListener
    public void onStateChanged(io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state, boolean z) {
        boolean z2 = this.mCurState != state;
        this.mCurState = state;
        if (!z2 || state == io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.RESET) {
            return;
        }
        if (state == io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.PULL_TO_REFRESH) {
            io.dcloud.common.adapter.util.Logger.d("refresh", "BounceView PULL_TO_REFRESH");
            this.mWebview.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_DRAG_BOUNCE, io.dcloud.common.util.StringUtil.format(STATE_CHANGED_TEMPLATE, io.dcloud.common.constant.AbsoluteConst.BOUNCE_BEFORE_CHANGE_OFFSET));
        } else if (state == io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.RELEASE_TO_REFRESH) {
            io.dcloud.common.adapter.util.Logger.d("refresh", "BounceView RELEASE_TO_REFRESH");
            this.mWebview.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_DRAG_BOUNCE, io.dcloud.common.util.StringUtil.format(STATE_CHANGED_TEMPLATE, io.dcloud.common.constant.AbsoluteConst.BOUNCE_AFTER_CHANGE_OFFSET));
        } else if (state == io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.REFRESHING) {
            io.dcloud.common.adapter.util.Logger.d("refresh", "BounceView REFRESHING");
            this.mWebview.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_DRAG_BOUNCE, io.dcloud.common.util.StringUtil.format(STATE_CHANGED_TEMPLATE, io.dcloud.common.constant.AbsoluteConst.BOUNCE_DRAG_END_AFTER_CHANG_EOFFSET));
        }
    }

    void parseJsonOption(org.json.JSONObject jSONObject) {
        try {
            org.json.JSONObject jSONObjectCombinJSONObject = io.dcloud.common.util.JSONUtil.combinJSONObject(this.mJSONObject, jSONObject);
            this.mJSONObject = jSONObjectCombinJSONObject;
            int i = 0;
            if (!jSONObjectCombinJSONObject.isNull("position")) {
                org.json.JSONObject jSONObject2 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObjectCombinJSONObject, "position");
                int i2 = 0;
                while (true) {
                    java.lang.String[] strArr = keys;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    if (!jSONObject2.isNull(strArr[i2])) {
                        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObject2, strArr[i2]);
                        if ("none".equals(string)) {
                            this.mSupports[i2] = false;
                        } else if ("auto".equals(string)) {
                            this.mSupports[i2] = true;
                            int[] iArr = this.maxPullHeights;
                            int i3 = this.mWebview.mViewOptions.height / 3;
                            iArr[i2] = i3;
                            this.changeStateHeights[i2] = i3 / 2;
                        } else {
                            this.mSupports[i2] = true;
                            int[] iArr2 = this.maxPullHeights;
                            int i4 = this.mWebview.mViewOptions.height;
                            iArr2[i2] = io.dcloud.common.util.PdrUtil.convertToScreenInt(string, i4, i4 / 3, this.mWebviewScale);
                            this.changeStateHeights[i2] = this.maxPullHeights[i2] / 2;
                        }
                    }
                    i2++;
                }
            } else {
                this.mSupports[0] = true;
                int[] iArr3 = this.maxPullHeights;
                int i5 = this.mWebview.mViewOptions.height / 3;
                iArr3[0] = i5;
                this.changeStateHeights[0] = i5 / 2;
            }
            if (jSONObjectCombinJSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.BOUNCE_CHANGEOFFSET)) {
                this.changeStateHeights[0] = this.maxPullHeights[0] / 2;
                return;
            }
            org.json.JSONObject jSONObject3 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObjectCombinJSONObject, io.dcloud.common.constant.AbsoluteConst.BOUNCE_CHANGEOFFSET);
            while (true) {
                java.lang.String[] strArr2 = keys;
                if (i >= strArr2.length) {
                    return;
                }
                if (!jSONObject3.isNull(strArr2[i])) {
                    this.changeStateHeights[i] = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObject3, strArr2[i]), this.mWebview.mViewOptions.height, this.maxPullHeights[i] / 2, this.mWebviewScale);
                }
                i++;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
