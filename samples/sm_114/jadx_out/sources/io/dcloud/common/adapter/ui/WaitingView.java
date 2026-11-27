package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class WaitingView {
    java.lang.String mOncloseFunId;
    android.widget.PopupWindow mWaitingWin;
    io.dcloud.common.DHInterface.IWebview mWebview;
    public java.lang.String uuid;
    io.dcloud.common.adapter.ui.WaitingView.WaitingViewImpl waitingViewImpl;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class PopupWindowImpl extends android.widget.PopupWindow implements android.view.View.OnTouchListener, android.widget.PopupWindow.OnDismissListener {
        private boolean modal;

        PopupWindowImpl(android.content.Context context) {
            super(context);
            this.modal = false;
            setTouchInterceptor(this);
            setOnDismissListener(this);
            setBackgroundDrawable(new android.graphics.drawable.BitmapDrawable(android.graphics.Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ALPHA_8)));
        }

        void init(boolean z) {
            this.modal = z;
            setFocusable(z);
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            io.dcloud.common.adapter.ui.WaitingView.this.mWaitingWin = null;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 1 && io.dcloud.common.adapter.ui.WaitingView.isInRect(x, y, io.dcloud.common.adapter.ui.WaitingView.this.waitingViewImpl.mAbsRect)) {
                io.dcloud.common.adapter.ui.WaitingView waitingView = io.dcloud.common.adapter.ui.WaitingView.this;
                if (waitingView.waitingViewImpl.padlock) {
                    waitingView.close();
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class WaitingViewImpl extends android.view.ViewGroup {
        int backgroundColor;
        int height;
        android.graphics.Rect mAbsRect;
        android.widget.ProgressBar mProgressBar;
        android.graphics.RectF mRectF;
        java.lang.String mTextAligin;
        java.lang.String mTextColor;
        android.widget.TextView mTitleView;
        public boolean padlock;
        android.graphics.Paint paint;
        android.widget.PopupWindow pw;
        float round;
        int width;

        public WaitingViewImpl(android.content.Context context, android.widget.PopupWindow popupWindow, java.lang.String str) {
            super(context);
            this.mProgressBar = null;
            this.mTextAligin = null;
            this.mTextColor = null;
            this.mTitleView = null;
            this.round = 10.0f;
            this.paint = new android.graphics.Paint();
            this.mRectF = null;
            this.mAbsRect = null;
            this.backgroundColor = 0;
            this.pw = popupWindow;
            setPadding(10, 10, 10, 10);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(android.graphics.Canvas canvas) {
            this.paint.setColor(this.backgroundColor);
            this.paint.setAntiAlias(true);
            android.graphics.RectF rectF = this.mRectF;
            float f = this.round;
            canvas.drawRoundRect(rectF, f, f, this.paint);
            super.dispatchDraw(canvas);
        }

        public void initBackground(int i) {
            this.backgroundColor = i;
        }

        void initProgressBar(java.lang.String str, int i) {
            android.widget.ProgressBar progressBar = (android.widget.ProgressBar) ((android.view.LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(io.dcloud.PdrR.LAYOUT_SNOW_BLACK_PROGRESS, (android.view.ViewGroup) null).findViewById(io.dcloud.PdrR.ID_PROGRESSBAR);
            this.mProgressBar = progressBar;
            if (progressBar.getParent() != null) {
                ((android.view.ViewGroup) this.mProgressBar.getParent()).removeView(this.mProgressBar);
            }
            addView(this.mProgressBar);
        }

        void initProgressBar1(int i) {
            android.widget.ProgressBar progressBar = new android.widget.ProgressBar(getContext());
            this.mProgressBar = progressBar;
            addView(progressBar);
        }

        void initTitleView(java.lang.String str) {
            this.mTitleView = new android.widget.TextView(getContext()) { // from class: io.dcloud.common.adapter.ui.WaitingView.WaitingViewImpl.1
                @Override // android.widget.TextView, android.view.View
                protected void onMeasure(int i, int i2) {
                    int i3;
                    java.lang.String string = getText().toString();
                    int i4 = 0;
                    if (android.text.TextUtils.isEmpty(string)) {
                        i3 = 0;
                    } else {
                        java.lang.String[] strArrSplit = string.split("\n");
                        int length = strArrSplit.length;
                        android.text.TextPaint paint = getPaint();
                        i3 = 0;
                        int i5 = 0;
                        while (i4 < length) {
                            float fCeil = (float) java.lang.Math.ceil(android.text.Layout.getDesiredWidth(strArrSplit[i4], paint));
                            android.graphics.Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                            i3 += fontMetricsInt.bottom - fontMetricsInt.top;
                            if (fCeil > i5) {
                                i5 = (int) fCeil;
                            }
                            i4++;
                        }
                        i4 = i5;
                    }
                    setMeasuredDimension(i4, i3);
                }
            };
            io.dcloud.common.adapter.ui.WaitingView.this.waitingViewImpl.mTitleView.setTextColor(-1);
            java.lang.String str2 = this.mTextAligin;
            if (str2 == null) {
                io.dcloud.common.adapter.ui.WaitingView.this.waitingViewImpl.mTitleView.setGravity(17);
            } else if ("left".equals(str2)) {
                io.dcloud.common.adapter.ui.WaitingView.this.waitingViewImpl.mTitleView.setGravity(3);
            } else if ("right".equals(this.mTextAligin)) {
                io.dcloud.common.adapter.ui.WaitingView.this.waitingViewImpl.mTitleView.setGravity(5);
            } else {
                io.dcloud.common.adapter.ui.WaitingView.this.waitingViewImpl.mTitleView.setGravity(17);
            }
            this.mTitleView.setText(str);
            addView(this.mTitleView);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int childCount = getChildCount();
            getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int i5 = i3 - i;
            int i6 = i4 - i2;
            int i7 = i2 + paddingTop;
            int measuredHeight = this.mProgressBar.getMeasuredHeight();
            android.widget.TextView textView = this.mTitleView;
            int measuredHeight2 = measuredHeight + (textView != null ? textView.getMeasuredHeight() + paddingTop : 0);
            int i8 = (i6 - paddingTop) - paddingBottom;
            int i9 = i7 + (i8 > measuredHeight2 ? (i8 - measuredHeight2) >> 1 : 0);
            for (int i10 = 0; i10 < childCount; i10++) {
                android.view.View childAt = getChildAt(i10);
                int measuredWidth = (i5 - childAt.getMeasuredWidth()) >> 1;
                int iMin = java.lang.Math.min(childAt.getMeasuredWidth() + measuredWidth, i3 - paddingRight);
                int iMin2 = java.lang.Math.min(childAt.getMeasuredHeight() + i9, i4 - paddingBottom);
                childAt.layout(measuredWidth, i9, iMin, iMin2);
                i9 = iMin2 + paddingTop;
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            int childCount = getChildCount();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            measureChildren(i, i2);
            int i3 = paddingTop;
            int i4 = 0;
            int iMax = 0;
            while (i4 < childCount) {
                android.view.View childAt = getChildAt(i4);
                if (childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    iMax = java.lang.Math.max(iMax, measuredWidth);
                    i3 += measuredHeight + (i4 == childCount + (-1) ? 0 : paddingTop);
                }
                i4++;
            }
            int i5 = iMax + paddingLeft + paddingRight;
            int i6 = i3 + paddingBottom;
            int i7 = this.width;
            if (i7 != -2) {
                i5 = i7;
            }
            int i8 = this.height;
            if (i8 != -2) {
                i6 = i8;
            }
            setMeasuredDimension(i5, i6);
            this.mRectF = new android.graphics.RectF(0.0f, 0.0f, i5, i6);
            this.mAbsRect = new android.graphics.Rect(0, 0, i5, i6);
            this.pw.update(i5, i6);
        }
    }

    public WaitingView(io.dcloud.common.DHInterface.IWebview iWebview) {
        this(iWebview, null, null, null);
    }

    static boolean isInRect(int i, int i2, android.graphics.Rect rect) {
        return i > rect.left && i < rect.right && i2 > rect.top && i2 < rect.bottom;
    }

    public void close() {
        android.widget.PopupWindow popupWindow = this.mWaitingWin;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    void updateTitle(java.lang.String str) {
        io.dcloud.common.adapter.ui.WaitingView.WaitingViewImpl waitingViewImpl = this.waitingViewImpl;
        android.widget.TextView textView = waitingViewImpl.mTitleView;
        if (textView == null) {
            waitingViewImpl.initTitleView(str);
        } else {
            textView.setText(str);
        }
    }

    WaitingView(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2) {
        this.mWaitingWin = null;
        this.waitingViewImpl = null;
        this.mWebview = iWebview;
        this.mOncloseFunId = str2;
        android.content.Context context = iWebview.getContext();
        io.dcloud.common.adapter.ui.WaitingView.PopupWindowImpl popupWindowImpl = new io.dcloud.common.adapter.ui.WaitingView.PopupWindowImpl(context);
        popupWindowImpl.init(false);
        popupWindowImpl.setOutsideTouchable(false);
        io.dcloud.common.adapter.ui.WaitingView.WaitingViewImpl waitingViewImpl = new io.dcloud.common.adapter.ui.WaitingView.WaitingViewImpl(context, popupWindowImpl, "");
        this.waitingViewImpl = waitingViewImpl;
        waitingViewImpl.initProgressBar(null, -872415232);
        if (str != null) {
            this.waitingViewImpl.initTitleView(str);
        }
        popupWindowImpl.setContentView(this.waitingViewImpl);
        io.dcloud.common.adapter.ui.WaitingView.WaitingViewImpl waitingViewImpl2 = this.waitingViewImpl;
        waitingViewImpl2.width = -2;
        waitingViewImpl2.height = -2;
        popupWindowImpl.setWindowLayoutMode(-2, -2);
        this.mWaitingWin = popupWindowImpl;
        popupWindowImpl.showAtLocation(iWebview.obtainWindowView(), 17, 0, 0);
    }
}
