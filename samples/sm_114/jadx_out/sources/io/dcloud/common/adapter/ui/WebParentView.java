package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class WebParentView extends android.widget.FrameLayout {
    private boolean mIsBeingDragged;
    float mLastMotionX;
    float mLastMotionY;
    io.dcloud.common.adapter.ui.AdaWebview mWebView;

    public WebParentView(android.content.Context context) {
        super(context);
        this.mIsBeingDragged = true;
    }

    private boolean isCanCircleRefresh() {
        return this.mWebView.obtainFrameView() != null && ((io.dcloud.common.adapter.ui.AdaFrameView) this.mWebView.obtainFrameView()).getCircleRefreshView() != null && ((io.dcloud.common.adapter.ui.AdaFrameView) this.mWebView.obtainFrameView()).getCircleRefreshView().isRefreshEnable() && this.mWebView.getDCWebView().getWebViewScrollY() <= 0;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mWebView;
        if (adaWebview instanceof io.dcloud.common.adapter.ui.AdaUniWebView) {
            ((io.dcloud.common.adapter.ui.AdaUniWebView) this.mWebView).fireEvent(new io.dcloud.common.adapter.util.EventActionInfo(io.dcloud.common.constant.AbsoluteConst.EVENTS_PLUS_ORIENTATI_ONCHANGE));
        } else {
            adaWebview.executeScript(io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.EVENTS_DOCUMENT_EXECUTE_TEMPLATE, io.dcloud.common.constant.AbsoluteConst.EVENTS_PLUS_ORIENTATI_ONCHANGE));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (!isCanCircleRefresh()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastMotionY = rawY;
            this.mLastMotionX = rawX;
            this.mIsBeingDragged = false;
        } else if (action == 2) {
            float f = rawX - this.mLastMotionX;
            float f2 = rawY - this.mLastMotionY;
            if (f2 > 20.0f && java.lang.Math.abs(f2) > java.lang.Math.abs(f)) {
                this.mIsBeingDragged = true;
                motionEvent.setAction(0);
                onTouchEvent(motionEvent);
            }
        }
        return this.mIsBeingDragged;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mWebView != null) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("width", i / this.mWebView.getScale());
                jSONObject.put("height", i2 / this.mWebView.getScale());
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            this.mWebView.mFrameView.dispatchFrameViewEvents("resize", jSONObject.toString());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        boolean zIsCanCircleRefresh = isCanCircleRefresh();
        if (zIsCanCircleRefresh && ((io.dcloud.common.adapter.ui.AdaFrameView) this.mWebView.obtainFrameView()).getCircleRefreshView().onSelfTouchEvent(motionEvent)) {
            return true;
        }
        if (zIsCanCircleRefresh) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setWebView(io.dcloud.common.adapter.ui.AdaWebview adaWebview) {
        this.mWebView = adaWebview;
    }
}
