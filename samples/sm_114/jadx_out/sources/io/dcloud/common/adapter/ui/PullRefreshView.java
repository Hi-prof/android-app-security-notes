package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class PullRefreshView extends android.view.View {
    static final byte FLAG_MOVEED = 1;
    static final byte FLAG_NO_THING = -1;
    static final byte FLAG_STARTED = 0;
    static int HEIGHT = 25;
    static int MAX_FRAME_COUNT = 9;
    static final byte STATE_NO_REFRESH = 0;
    static final byte STATE_ON_MOVE_ING = 1;
    static final byte STATE_ON_OVER = 2;
    static final byte STATE_ON_REFRESH_ING = 3;
    public static final java.lang.String TAG = "PullRefreshView";
    public static final byte TYPE_PULL_DOWN_REFRESH = 1;
    public static final byte TYPE_PULL_UP_REFRESH = 0;
    static final int color_tr = 16711920;
    byte SCROLL_STATE_MAX;
    byte SCROLL_STATE_MIDDLE;
    byte SCROLL_STATE_MIN;
    int changeStateHeight;
    private int contentLeft;
    private int contentTop;
    private int contentWidth;
    private android.graphics.RectF dst;
    int fontSize;
    int icon_x;
    int icon_y;
    int index;
    float lastScrollY;
    boolean mCaptureTouchEnd;
    java.lang.String mContent_down;
    java.lang.String mContent_over;
    java.lang.String mContent_refresh;
    boolean mEnableScrollMaxHeight;
    boolean mEnableScrollMinHeight;
    byte mFlag;
    float mFontScale;
    android.graphics.Bitmap mIcon;
    io.dcloud.common.adapter.ui.AdaFrameItem mParent;
    boolean mRefreshState;
    int mScrollHeight;
    byte mScrollState;
    java.lang.String mSecInfo;
    java.lang.String mShowContent;
    byte mState;
    byte mType;
    java.util.Timer mUpdateProgressBar;
    io.dcloud.common.adapter.ui.AdaWebview mWebview;
    private float mWebviewScale;
    int maxPullHeight;
    android.graphics.Paint paint;
    int sScreenHeight;
    int sScreenWidth;
    private android.graphics.Rect src;
    float startX;
    float startY;
    boolean touch_started;

    /* JADX INFO: renamed from: io.dcloud.common.adapter.ui.PullRefreshView$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class AnonymousClass2 extends java.util.TimerTask {
        android.view.View child;
        int fromX;
        int fromY;
        android.view.ViewGroup parent;
        int timesCount;
        int toX;
        int toY;
        int vX;
        int vY;
        final /* synthetic */ java.util.Timer val$_timer;
        final /* synthetic */ android.view.ViewGroup val$pParent;
        final /* synthetic */ android.view.View val$pView;
        final /* synthetic */ int val$x;
        final /* synthetic */ int val$y;
        final int TIME = 500;
        int flagTimes = 1;

        AnonymousClass2(android.view.View view, android.view.ViewGroup viewGroup, int i, int i2, java.util.Timer timer) {
            this.val$pView = view;
            this.val$pParent = viewGroup;
            this.val$x = i;
            this.val$y = i2;
            this.val$_timer = timer;
            this.child = view;
            this.parent = viewGroup;
            this.toX = i;
            this.toY = i2;
            this.fromX = viewGroup.getScrollX();
            this.fromY = this.parent.getScrollY();
            this.timesCount = 10;
            this.vX = java.lang.Math.abs(this.toX - this.fromX) / this.timesCount;
            int iAbs = java.lang.Math.abs(this.toY - this.fromY) / this.timesCount;
            this.vY = iAbs;
            if (iAbs >= 5) {
                this.vY = 5;
                this.timesCount = java.lang.Math.abs(this.toY - this.fromY) / this.vY;
            }
            this.vX = java.lang.Math.abs(this.toX - this.fromX) / this.timesCount;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int i = this.fromX + this.vX;
            int i2 = this.fromY + this.vY;
            if (this.flagTimes == this.timesCount) {
                i = this.toX;
                i2 = this.toY;
            }
            io.dcloud.common.adapter.ui.PullRefreshView.scrollToByMessage(this.parent, i, i2);
            if (this.flagTimes == this.timesCount) {
                if (this.child != null) {
                    this.parent.post(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.PullRefreshView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            io.dcloud.common.adapter.ui.PullRefreshView.AnonymousClass2 anonymousClass2 = io.dcloud.common.adapter.ui.PullRefreshView.AnonymousClass2.this;
                            anonymousClass2.parent.removeView(anonymousClass2.child);
                        }
                    });
                }
                this.val$_timer.cancel();
            }
            this.fromX = i;
            this.fromY = i2;
            this.flagTimes++;
        }
    }

    public PullRefreshView(io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem, io.dcloud.common.adapter.ui.AdaWebview adaWebview) {
        super(adaFrameItem.getContext());
        this.mType = (byte) 1;
        this.mShowContent = null;
        this.mSecInfo = null;
        this.mIcon = null;
        this.mFontScale = 1.2f;
        this.changeStateHeight = 100;
        this.maxPullHeight = 100;
        this.paint = new android.graphics.Paint();
        this.index = 0;
        this.contentLeft = 0;
        this.contentTop = 0;
        this.contentWidth = 0;
        this.mState = (byte) 0;
        this.touch_started = false;
        this.mCaptureTouchEnd = false;
        this.mFlag = (byte) 0;
        this.mScrollHeight = 0;
        this.SCROLL_STATE_MIN = (byte) 0;
        this.SCROLL_STATE_MAX = (byte) 1;
        this.SCROLL_STATE_MIDDLE = (byte) 2;
        this.mScrollState = (byte) 0;
        this.mEnableScrollMinHeight = true;
        this.mEnableScrollMaxHeight = true;
        this.mRefreshState = false;
        this.mUpdateProgressBar = null;
        this.mParent = adaFrameItem;
        this.mWebview = adaWebview;
        this.mContent_down = getResources().getString(io.dcloud.base.R.string.dcloud_drop_down_refresh1);
        this.mContent_over = getResources().getString(io.dcloud.base.R.string.dcloud_drop_down_refresh2);
        this.mContent_refresh = getResources().getString(io.dcloud.base.R.string.dcloud_drop_down_refresh3);
        this.sScreenWidth = adaWebview.obtainApp().getInt(0);
        this.sScreenHeight = adaWebview.obtainApp().getInt(1);
        this.mWebviewScale = adaWebview.getScale();
        init(null);
        this.paint.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void scrollToByMessage(final android.view.View view, final int i, final int i2) {
        view.post(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.PullRefreshView.3
            @Override // java.lang.Runnable
            public void run() {
                view.scrollTo(i, i2);
            }
        });
    }

    static void smoothScrollTo(android.view.ViewGroup viewGroup, android.view.View view, int i, int i2, int i3) {
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new io.dcloud.common.adapter.ui.PullRefreshView.AnonymousClass2(view, viewGroup, i, i2, timer), 0L, i3);
    }

    private void startUpdateScreenTimer() {
        stopUpdateScreenTimer();
        java.util.Timer timer = new java.util.Timer();
        this.mUpdateProgressBar = timer;
        timer.schedule(new java.util.TimerTask() { // from class: io.dcloud.common.adapter.ui.PullRefreshView.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                io.dcloud.common.adapter.ui.PullRefreshView.this.updateScreen();
            }
        }, 0L, 100L);
    }

    private void stopUpdateScreenTimer() {
        java.util.Timer timer = this.mUpdateProgressBar;
        if (timer != null) {
            timer.cancel();
            this.mUpdateProgressBar = null;
        }
    }

    private boolean updateScrollState(byte b) {
        this.mScrollState = b;
        boolean z = false;
        if (b == this.SCROLL_STATE_MAX) {
            this.mScrollHeight = this.maxPullHeight;
            if (this.mEnableScrollMaxHeight) {
                this.mEnableScrollMaxHeight = false;
                z = true;
            }
            this.mEnableScrollMinHeight = true;
            return z;
        }
        if (b == this.SCROLL_STATE_MIN) {
            this.mEnableScrollMaxHeight = true;
            this.mScrollHeight = 0;
            if (this.mEnableScrollMinHeight) {
                this.mEnableScrollMinHeight = false;
                return true;
            }
        } else if (b == this.SCROLL_STATE_MIDDLE) {
            this.mEnableScrollMinHeight = true;
            this.mEnableScrollMaxHeight = true;
            return true;
        }
        return false;
    }

    public void changeStringInfo(java.lang.String str) {
        this.mShowContent = str;
        this.fontSize = (int) (io.dcloud.common.adapter.util.DeviceInfo.DEFAULT_FONT_SIZE * io.dcloud.common.adapter.util.DeviceInfo.sDensity * this.mFontScale);
        this.paint.setAntiAlias(true);
        int length = str.length();
        float[] fArr = new float[length];
        this.paint.getTextWidths(str, fArr);
        float f = 0.0f;
        for (int i = 0; i < length; i++) {
            f += fArr[i];
        }
        this.contentWidth = (int) f;
    }

    public void init(java.lang.String str) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inScaled = false;
        android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(io.dcloud.common.adapter.util.PlatformUtil.getResInputStream(io.dcloud.common.constant.AbsoluteConst.RES_PROGRASS_SNOW1), null, options);
        this.mIcon = bitmapDecodeStream;
        int height = bitmapDecodeStream.getHeight();
        HEIGHT = height;
        float f = this.sScreenWidth;
        this.contentLeft = (int) (0.43f * f);
        this.icon_x = ((int) (f * 0.41f)) - height;
        int i = HEIGHT;
        this.src = new android.graphics.Rect(0, 0, i, i);
        float f2 = HEIGHT;
        this.dst = new android.graphics.RectF(0.0f, 150.0f, f2, f2);
        MAX_FRAME_COUNT = bitmapDecodeStream.getWidth() / HEIGHT;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.mState != 0) {
            canvas.drawColor(-1907998);
            this.paint.setColor(-16777216);
            this.paint.setTextSize(this.fontSize);
            canvas.drawText(this.mShowContent, this.contentLeft, this.contentTop, this.paint);
            android.graphics.Bitmap bitmap = this.mIcon;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, this.src, this.dst, this.paint);
            }
        }
    }

    void onExecuting() {
        io.dcloud.common.adapter.util.Logger.d(TAG, "onExecuting");
        this.mState = (byte) 3;
        this.mRefreshState = true;
        this.mFlag = (byte) -1;
        io.dcloud.common.adapter.util.Logger.d(TAG, "onExecuting; mFlag = FLAG_NO_THING");
        changeStringInfo(this.mContent_refresh);
        this.mScrollHeight = this.changeStateHeight;
        smoothScrollTo((android.view.ViewGroup) this.mParent.obtainMainView(), null, 0, -this.changeStateHeight, 1);
    }

    boolean onMove(float f, float f2) {
        boolean zUpdateScrollState;
        int i = (int) (((f2 - this.lastScrollY) * this.maxPullHeight) / this.mWebview.mFrameView.mViewOptions.height);
        if (java.lang.Math.abs(i) < 1) {
            if (this.mScrollHeight > 0) {
                return true;
            }
            float f3 = i;
            if ((f3 > 0.5f || f3 < -0.5f) && this.mFlag == 0) {
                this.mFlag = (byte) 1;
            }
            return false;
        }
        int i2 = this.mScrollHeight + i;
        this.mScrollHeight = i2;
        if (i2 >= this.maxPullHeight) {
            zUpdateScrollState = updateScrollState(this.SCROLL_STATE_MAX);
        } else {
            zUpdateScrollState = i2 <= 0 ? updateScrollState(this.SCROLL_STATE_MIN) : updateScrollState(this.SCROLL_STATE_MIDDLE);
        }
        byte b = this.mState;
        if (b != 3) {
            if (b == 1 && this.mScrollHeight >= this.changeStateHeight) {
                this.mState = (byte) 2;
                changeStringInfo(this.mContent_over);
            } else if (b == 2 && this.mScrollHeight < this.changeStateHeight) {
                this.mState = (byte) 1;
                changeStringInfo(this.mContent_down);
            }
        }
        if (zUpdateScrollState) {
            if (this.mFlag == 0) {
                this.mFlag = (byte) 1;
                io.dcloud.common.adapter.util.Logger.d(TAG, "onMove; mFlag=FLAG_MOVEED");
                startUpdateScreenTimer();
            }
            this.mParent.obtainMainView().scrollBy(0, -i);
            this.lastScrollY = f2;
        }
        return zUpdateScrollState;
    }

    void onPullDown_end() {
        if (this.mScrollHeight <= this.changeStateHeight) {
            this.mState = (byte) 0;
            this.mScrollHeight = 0;
            this.mFlag = (byte) -1;
            io.dcloud.common.adapter.util.Logger.d(TAG, "onPullDown_end; mFlag = FLAG_NO_THING");
            changeStringInfo(this.mContent_down);
            java.util.Timer timer = this.mUpdateProgressBar;
            if (timer != null) {
                timer.cancel();
            }
            this.mParent.obtainMainView().scrollTo(0, 0);
            stopUpdateScreenTimer();
        } else {
            smoothScrollToStateHeight(true);
        }
        this.mRefreshState = false;
    }

    void onPullDown_start(float f, float f2) {
        if (this.touch_started) {
            return;
        }
        io.dcloud.common.adapter.util.Logger.d(TAG, "onPullDown_start");
        this.startX = f;
        this.startY = f2;
        this.lastScrollY = f2;
        if (getParent() == null) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.mParent.obtainMainView();
            int i = this.maxPullHeight;
            io.dcloud.common.adapter.util.ViewOptions viewOptions = this.mWebview.mViewOptions;
            viewGroup.addView(this, 0, new android.widget.AbsoluteLayout.LayoutParams(-1, i, viewOptions.left, viewOptions.top - i));
        }
        byte b = this.mState;
        if (b == 0) {
            this.mState = (byte) 1;
            this.mFlag = (byte) 0;
        } else if (b == 3) {
            this.mFlag = (byte) 0;
        }
        this.touch_started = true;
    }

    public void parseJsonOption(org.json.JSONObject jSONObject) {
        try {
            if (!jSONObject.isNull("height")) {
                int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONObject, "height"), this.mWebview.mFrameView.mViewOptions.height, this.changeStateHeight, this.mWebviewScale);
                this.changeStateHeight = iConvertToScreenInt;
                this.maxPullHeight = iConvertToScreenInt;
            }
            if (!jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_RANGE)) {
                this.maxPullHeight = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.getString(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_RANGE), this.mWebview.mFrameView.mViewOptions.height, this.changeStateHeight, this.mWebviewScale);
            }
            if (!jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CONTENTDOWN)) {
                changeStringInfo(io.dcloud.common.util.JSONUtil.getString(jSONObject.getJSONObject(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CONTENTDOWN), io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CAPTION));
            }
            if (!jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CONTENTOVER)) {
                this.mContent_over = io.dcloud.common.util.JSONUtil.getString(jSONObject.getJSONObject(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CONTENTOVER), io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CAPTION);
            }
            if (!jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CONTENTREFRESH)) {
                this.mContent_refresh = io.dcloud.common.util.JSONUtil.getString(jSONObject.getJSONObject(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CONTENTREFRESH), io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_CAPTION);
            }
            int iMax = java.lang.Math.max(this.maxPullHeight - this.changeStateHeight, 0);
            android.graphics.Paint.FontMetricsInt fontMetricsInt = io.dcloud.common.adapter.util.DeviceInfo.sPaint.getFontMetricsInt();
            int i = this.changeStateHeight;
            this.contentTop = (i >> 1) + iMax + ((fontMetricsInt.bottom - fontMetricsInt.top) >> 1);
            int i2 = HEIGHT;
            int i3 = iMax + ((i - i2) >> 1);
            this.icon_y = i3;
            android.graphics.RectF rectF = this.dst;
            int i4 = this.icon_x;
            rectF.set(i4, i3, i4 + i2, i3 + i2);
            io.dcloud.common.adapter.util.Logger.d(TAG, "height=" + this.changeStateHeight + ";range=" + this.maxPullHeight + ";contentdown=" + this.mShowContent);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    void setColorByParentChild(android.view.View view) {
        for (int i = 0; i != 2; i++) {
            view = (android.view.View) view.getParent();
            view.setBackgroundColor(color_tr);
        }
    }

    void smoothScrollToStateHeight(boolean z) {
        if (z) {
            this.mScrollHeight = this.changeStateHeight;
            smoothScrollTo((android.view.ViewGroup) this.mParent.obtainMainView(), null, 0, -this.changeStateHeight, 1);
        } else if (this.mScrollHeight > this.changeStateHeight) {
            smoothScrollToStateHeight(true);
        } else {
            this.mRefreshState = false;
        }
    }

    public void updateScreen() {
        int i = this.index + 1;
        this.index = i;
        if (i >= MAX_FRAME_COUNT) {
            this.index = 0;
        }
        android.graphics.Rect rect = this.src;
        int i2 = HEIGHT;
        int i3 = this.index;
        rect.set(i2 * i3, 0, (i3 + 1) * i2, i2);
        postInvalidate();
    }
}
