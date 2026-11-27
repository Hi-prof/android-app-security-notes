package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class RefreshView implements io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.OnStateChangeListener {
    public static final java.lang.String TAG = "RefreshView";
    private android.graphics.RectF dst;
    int fontSize;
    int icon_x;
    int icon_y;
    java.lang.String mContent_down;
    java.lang.String mContent_over;
    java.lang.String mContent_refresh;
    io.dcloud.common.adapter.ui.AdaFrameView mFrameView;
    org.json.JSONObject mJSONObject;
    io.dcloud.common.adapter.ui.AdaWebview mWebview;
    private float mWebviewScale;
    private android.graphics.Rect src;
    float startX;
    float startY;
    android.graphics.Bitmap mIcon = null;
    float mFontScale = 1.2f;
    int changeStateHeight = 100;
    int maxPullHeight = 100;
    android.graphics.Paint paint = new android.graphics.Paint();
    int index = 0;
    int MAX_FRAME_COUNT = 9;
    int HEIGHT = 25;
    java.util.Timer mUpdateProgressBar = null;
    private int contentLeft = 0;
    private int contentTop = 0;
    java.lang.String mShowContent = null;
    io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State mState = io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.RESET;

    public RefreshView(io.dcloud.common.adapter.ui.AdaFrameView adaFrameView, io.dcloud.common.adapter.ui.AdaWebview adaWebview) {
        this.mFrameView = adaFrameView;
        this.mContent_down = adaFrameView.getContext().getString(io.dcloud.base.R.string.dcloud_drop_down_refresh1);
        this.mContent_over = adaFrameView.getContext().getString(io.dcloud.base.R.string.dcloud_drop_down_refresh2);
        this.mContent_refresh = adaFrameView.getContext().getString(io.dcloud.base.R.string.dcloud_drop_down_refresh3);
        this.mWebview = adaWebview;
        this.mWebviewScale = adaWebview.getScale();
        this.paint.setAntiAlias(true);
    }

    private void computePosition(android.graphics.Paint paint) {
        android.graphics.Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i = this.changeStateHeight;
        int i2 = this.HEIGHT;
        int i3 = (i - i2) >> 1;
        this.icon_y = i3;
        this.contentTop = i3 + ((i2 - (fontMetricsInt.bottom - fontMetricsInt.top)) / 2);
        int i4 = this.mFrameView.obtainApp().getInt(0);
        float fMeasureText = paint.measureText(this.mShowContent);
        float f = i4;
        float f2 = 0.02f * f;
        float f3 = this.HEIGHT;
        int i5 = ((int) (((f - f2) - f3) - fMeasureText)) / 2;
        this.icon_x = i5;
        this.contentLeft = (int) (i5 + f2 + f3);
    }

    private void startUpdateScreenTimer() {
        stopUpdateScreenTimer();
        if (this.mFrameView.obtainMainView() != null) {
            java.util.Timer timer = new java.util.Timer();
            this.mUpdateProgressBar = timer;
            timer.schedule(new java.util.TimerTask() { // from class: io.dcloud.common.adapter.ui.RefreshView.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (io.dcloud.common.adapter.ui.RefreshView.this.mFrameView.obtainMainView() == null) {
                        cancel();
                    }
                    try {
                        io.dcloud.common.adapter.ui.RefreshView.this.updateScreen();
                        io.dcloud.common.adapter.ui.RefreshView.this.mFrameView.obtainMainView().postInvalidate(0, 0, io.dcloud.common.adapter.ui.RefreshView.this.mFrameView.obtainFrameOptions().width, io.dcloud.common.adapter.ui.RefreshView.this.maxPullHeight);
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 0L, 100L);
        }
    }

    private void stopUpdateScreenTimer() {
        java.util.Timer timer = this.mUpdateProgressBar;
        if (timer != null) {
            timer.cancel();
            this.mUpdateProgressBar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateScreen() {
        int i = this.index + 1;
        this.index = i;
        if (i >= this.MAX_FRAME_COUNT) {
            this.index = 0;
        }
        android.graphics.Rect rect = this.src;
        int i2 = this.HEIGHT;
        int i3 = this.index;
        rect.set(i2 * i3, 0, (i3 + 1) * i2, i2);
    }

    public void changeStringInfo(java.lang.String str) {
        this.mShowContent = str;
        int length = str.length();
        float[] fArr = new float[length];
        this.paint.getTextWidths(str, fArr);
        for (int i = 0; i < length; i++) {
            float f = fArr[i];
        }
        this.mFrameView.obtainMainView().postInvalidate(0, 0, this.mFrameView.obtainFrameOptions().width, this.maxPullHeight);
    }

    public void init(java.lang.String str) {
        this.fontSize = (int) (io.dcloud.common.adapter.util.DeviceInfo.DEFAULT_FONT_SIZE * io.dcloud.common.adapter.util.DeviceInfo.sDensity * this.mFontScale);
        this.paint.setAntiAlias(true);
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inScaled = false;
        android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(io.dcloud.common.adapter.util.PlatformUtil.getResInputStream(io.dcloud.common.constant.AbsoluteConst.RES_PROGRASS_SNOW1), null, options);
        this.mIcon = bitmapDecodeStream;
        this.HEIGHT = bitmapDecodeStream.getHeight();
        int i = this.HEIGHT;
        this.src = new android.graphics.Rect(0, 0, i, i);
        float f = this.HEIGHT;
        this.dst = new android.graphics.RectF(0.0f, 150.0f, f, f);
        io.dcloud.common.adapter.util.Logger.d(TAG, "height=" + this.changeStateHeight + ";range=" + this.maxPullHeight + ";contentdown=" + this.mShowContent);
        this.MAX_FRAME_COUNT = bitmapDecodeStream.getWidth() / this.HEIGHT;
    }

    void onResize() {
        parseJsonOption(this.mJSONObject);
    }

    @Override // io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.OnStateChangeListener
    public void onStateChanged(io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state, boolean z) {
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView;
        boolean z2 = this.mState != state;
        this.mState = state;
        if (z2) {
            if (state == io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.RESET) {
                io.dcloud.common.adapter.util.Logger.d("refresh", "RefreshView RESET");
                changeStringInfo(this.mContent_down);
                stopUpdateScreenTimer();
                return;
            }
            if (state == io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.PULL_TO_REFRESH) {
                io.dcloud.common.adapter.util.Logger.d("refresh", "RefreshView PULL_TO_REFRESH");
                changeStringInfo(this.mContent_down);
                return;
            }
            if (state == io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.RELEASE_TO_REFRESH) {
                io.dcloud.common.adapter.util.Logger.d("refresh", "RefreshView RELEASE_TO_REFRESH");
                changeStringInfo(this.mContent_over);
            } else if (state == io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.REFRESHING) {
                io.dcloud.common.adapter.util.Logger.d("refresh", "RefreshView REFRESHING");
                changeStringInfo(this.mContent_refresh);
                startUpdateScreenTimer();
                io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mWebview;
                if (adaWebview == null || (dCWebView = adaWebview.mWebViewImpl) == null) {
                    return;
                }
                dCWebView.onRefresh(3);
            }
        }
    }

    protected void paint(android.graphics.Canvas canvas, int i, int i2) {
        canvas.drawColor(-1907998);
        this.paint.setColor(-16777216);
        this.paint.setTextSize(this.fontSize);
        if (this.mShowContent == null || this.mIcon == null) {
            return;
        }
        computePosition(this.paint);
        io.dcloud.common.adapter.util.CanvasHelper.drawString(canvas, this.mShowContent, this.contentLeft + i, this.contentTop + i2, 17, this.paint);
        android.graphics.RectF rectF = this.dst;
        int i3 = i + this.icon_x;
        int i4 = i2 + this.icon_y;
        int i5 = this.HEIGHT;
        rectF.set(i3, i4, i3 + i5, i4 + i5);
        canvas.drawBitmap(this.mIcon, this.src, this.dst, this.paint);
    }

    public void parseJsonOption(org.json.JSONObject jSONObject) {
        try {
            org.json.JSONObject jSONObjectCombinJSONObject = io.dcloud.common.util.JSONUtil.combinJSONObject(this.mJSONObject, jSONObject);
            this.mJSONObject = jSONObjectCombinJSONObject;
            if (!jSONObjectCombinJSONObject.isNull("height")) {
                this.changeStateHeight = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObjectCombinJSONObject, "height"), this.mWebview.mFrameView.mViewOptions.height, this.changeStateHeight, this.mWebviewScale);
            }
            if (!jSONObjectCombinJSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_RANGE)) {
                this.maxPullHeight = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObjectCombinJSONObject.getString(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_RANGE), this.mWebview.mFrameView.mViewOptions.height, this.maxPullHeight, this.mWebviewScale);
            }
            if (!jSONObjectCombinJSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CONTENTDOWN)) {
                this.mContent_down = io.dcloud.common.util.JSONUtil.getString(jSONObjectCombinJSONObject.getJSONObject(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CONTENTDOWN), io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CAPTION);
            }
            if (!jSONObjectCombinJSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CONTENTOVER)) {
                this.mContent_over = io.dcloud.common.util.JSONUtil.getString(jSONObjectCombinJSONObject.getJSONObject(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CONTENTOVER), io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CAPTION);
            }
            if (!jSONObjectCombinJSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CONTENTREFRESH)) {
                this.mContent_refresh = io.dcloud.common.util.JSONUtil.getString(jSONObjectCombinJSONObject.getJSONObject(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CONTENTREFRESH), io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CAPTION);
            }
            init(null);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }
}
