package com.dcloud.android.widget;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AbsoluteLayout extends com.dcloud.android.widget.SlideLayout {
    static final java.lang.String STATE_CHANGED_TEMPLATE = "{status:'%s',offset:'%s'}";
    boolean canDoMaskClickEvent;
    float downX;
    float downY;
    private boolean isAnimate;
    private boolean isCanDrag;
    io.dcloud.common.DHInterface.IApp mAppHandler;
    java.lang.String mCallBackID;
    io.dcloud.common.core.ui.g mDrag;
    io.dcloud.common.adapter.ui.AdaFrameView mFrameView;
    private int mRegionBottom;
    private int mRegionLeft;
    private android.graphics.RectF mRegionRect;
    private int mRegionRight;
    private int mRegionTop;
    io.dcloud.common.adapter.util.ViewOptions mViewOptions;

    public AbsoluteLayout(android.content.Context context, io.dcloud.common.adapter.ui.AdaFrameView adaFrameView, io.dcloud.common.DHInterface.IApp iApp) {
        super(context);
        this.mFrameView = null;
        this.mViewOptions = null;
        this.mAppHandler = null;
        this.isCanDrag = false;
        this.canDoMaskClickEvent = true;
        this.mDrag = new io.dcloud.common.core.ui.g(adaFrameView, context);
        this.mFrameView = adaFrameView;
        this.mAppHandler = iApp;
        this.mViewOptions = adaFrameView.obtainFrameOptions();
        setOnStateChangeListener(new com.dcloud.android.widget.SlideLayout.OnStateChangeListener() { // from class: com.dcloud.android.widget.AbsoluteLayout.1
            @Override // com.dcloud.android.widget.SlideLayout.OnStateChangeListener
            public void onStateChanged(java.lang.String str, java.lang.String str2) {
                com.dcloud.android.widget.AbsoluteLayout.this.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_SLIDE_BOUNCE, io.dcloud.common.util.StringUtil.format(com.dcloud.android.widget.AbsoluteLayout.STATE_CHANGED_TEMPLATE, str, str2));
            }
        });
    }

    private void doClickEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.canDoMaskClickEvent = true;
            this.downX = motionEvent.getX();
            this.downY = motionEvent.getY();
            return;
        }
        if (motionEvent.getAction() == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.canDoMaskClickEvent) {
                float f = 10;
                if (java.lang.Math.abs(this.downX - x) > f || java.lang.Math.abs(this.downY - y) > f) {
                    return;
                }
                this.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_MASK_CLICK, null);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 2) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (this.canDoMaskClickEvent) {
                float f2 = 10;
                if (java.lang.Math.abs(this.downX - x2) <= f2 || java.lang.Math.abs(this.downY - y2) <= f2) {
                    return;
                }
                this.canDoMaskClickEvent = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endAnimatecallback(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, null, io.dcloud.common.util.JSUtil.OK, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runDrawRectF(final io.dcloud.common.DHInterface.IWebview iWebview, final java.lang.String str, final int i, final int i2, final int i3, final int i4, final int i5, final int i6, final int i7, final int i8, final int i9) {
        if (!this.isAnimate) {
            endAnimatecallback(iWebview, str);
            return;
        }
        if (this.mRegionRect == null) {
            this.mRegionRect = new android.graphics.RectF();
        }
        android.graphics.RectF rectF = this.mRegionRect;
        rectF.left = i;
        rectF.right = this.mViewOptions.width - i2;
        rectF.top = i3;
        if (i9 == i7) {
            rectF.bottom = (i6 * i9) + i3 + i8;
        } else {
            rectF.bottom = (i6 * i9) + i3;
        }
        postDelayed(new java.lang.Runnable() { // from class: com.dcloud.android.widget.AbsoluteLayout.2
            @Override // java.lang.Runnable
            public void run() {
                com.dcloud.android.widget.AbsoluteLayout.this.invalidate();
                int i10 = i9;
                int i11 = i7;
                if (i10 == i11) {
                    com.dcloud.android.widget.AbsoluteLayout.this.endAnimatecallback(iWebview, str);
                } else {
                    com.dcloud.android.widget.AbsoluteLayout.this.runDrawRectF(iWebview, str, i, i2, i3, i4, i5, i6, i11, i8, i10 + 1);
                }
            }
        }, i5);
    }

    public void animate(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        if (this.mViewOptions == null) {
            endAnimatecallback(iWebview, str2);
            return;
        }
        this.mCallBackID = str2;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.lang.String strOptString = jSONObject.optString("type");
            int iOptInt = jSONObject.optInt("duration", 200);
            int iOptInt2 = jSONObject.optInt("frames", 12);
            org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("region");
            if (jSONObjectOptJSONObject != null) {
                java.lang.String strOptString2 = jSONObjectOptJSONObject.optString("left");
                io.dcloud.common.adapter.util.ViewOptions viewOptions = this.mViewOptions;
                this.mRegionLeft = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString2, viewOptions.width, 0, viewOptions.mWebviewScale);
                java.lang.String strOptString3 = jSONObjectOptJSONObject.optString("right");
                io.dcloud.common.adapter.util.ViewOptions viewOptions2 = this.mViewOptions;
                this.mRegionRight = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString3, viewOptions2.width, 0, viewOptions2.mWebviewScale);
                java.lang.String strOptString4 = jSONObjectOptJSONObject.optString("top");
                io.dcloud.common.adapter.util.ViewOptions viewOptions3 = this.mViewOptions;
                this.mRegionTop = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString4, viewOptions3.height, 0, viewOptions3.mWebviewScale);
                java.lang.String strOptString5 = jSONObjectOptJSONObject.optString("bottom");
                io.dcloud.common.adapter.util.ViewOptions viewOptions4 = this.mViewOptions;
                this.mRegionBottom = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString5, viewOptions4.height, 0, viewOptions4.mWebviewScale);
            }
            int i = iOptInt / iOptInt2;
            io.dcloud.common.adapter.util.ViewOptions viewOptions5 = this.mViewOptions;
            int i2 = viewOptions5.height - ((this.mRegionTop + viewOptions5.top) + this.mRegionBottom);
            int i3 = i2 / iOptInt2;
            int i4 = i2 - (i3 * iOptInt2);
            if (android.text.TextUtils.isEmpty(strOptString) || !strOptString.equals("shrink")) {
                return;
            }
            this.isAnimate = true;
            int i5 = this.mRegionLeft;
            int i6 = this.mRegionRight;
            int i7 = this.mRegionTop;
            io.dcloud.common.adapter.util.ViewOptions viewOptions6 = this.mViewOptions;
            runDrawRectF(iWebview, str2, i5, i6, i7 + viewOptions6.top, viewOptions6.height - this.mRegionBottom, i, i3, iOptInt2, i4, 1);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            endAnimatecallback(iWebview, str2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        canvas.save();
        android.graphics.RectF rectF = this.mRegionRect;
        if (rectF != null) {
            canvas.clipRect(rectF, android.graphics.Region.Op.DIFFERENCE);
        }
        io.dcloud.common.adapter.util.ViewOptions viewOptions = this.mViewOptions;
        if (viewOptions != null && !viewOptions.isTabHasBg() && !this.mViewOptions.hasBackground() && !this.mViewOptions.isTransparent() && !this.mViewOptions.hasMask() && this.mViewOptions.mUniNViewJson != null) {
            canvas.drawColor(-1);
        }
        this.mFrameView.paint(canvas);
        try {
            super.dispatchDraw(canvas);
            canvas.restore();
            io.dcloud.common.adapter.util.ViewOptions viewOptions2 = this.mViewOptions;
            if (viewOptions2 != null && viewOptions2.hasMask()) {
                canvas.drawColor(this.mViewOptions.maskColor);
            }
            this.mFrameView.onDrawAfter(canvas);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        try {
            if (!this.mFrameView.interceptTouchEvent) {
                return false;
            }
            io.dcloud.common.adapter.util.ViewOptions viewOptions = this.mViewOptions;
            if (viewOptions == null || !viewOptions.hasMask()) {
                io.dcloud.common.adapter.util.ViewOptions viewOptions2 = this.mViewOptions;
                if (viewOptions2 == null || !viewOptions2.hasBackground()) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                super.dispatchTouchEvent(motionEvent);
                return true;
            }
            doClickEvent(motionEvent);
            if (motionEvent.getAction() == 0) {
                this.isCanDrag = false;
            }
            if (!this.isCanDrag) {
                this.isCanDrag = this.mDrag.a(motionEvent);
            }
            if (this.isCanDrag) {
                onTouchEvent(motionEvent);
            }
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public io.dcloud.common.core.ui.g getDrag() {
        return this.mDrag;
    }

    public io.dcloud.common.adapter.ui.AdaFrameView getFrameView() {
        return this.mFrameView;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFrameView.onConfigurationChanged();
        if (this.isAnimate) {
            this.isAnimate = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.mRegionRect != null) {
            canvas.save();
            io.dcloud.common.adapter.util.ViewOptions viewOptions = this.mViewOptions;
            int i = viewOptions.left;
            int i2 = viewOptions.top;
            canvas.clipRect(i, i2, viewOptions.width + i, viewOptions.height + i2);
            canvas.restore();
        }
        super.onDraw(canvas);
    }

    @Override // com.dcloud.android.widget.SlideLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.mDrag.a(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.dcloud.android.widget.SlideLayout, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        boolean zC = this.mDrag.c(motionEvent);
        if (this.mViewOptions.isTransparent()) {
            return super.onTouchEvent(motionEvent);
        }
        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = this.mFrameView;
        if ((adaFrameView == null || !adaFrameView.isTouchEvent) && !zC) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void restore() {
        this.isAnimate = false;
        this.mRegionRect = null;
        invalidate();
    }

    @Override // android.view.View
    public java.lang.String toString() {
        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = this.mFrameView;
        return adaFrameView != null ? adaFrameView.toString() : super.toString();
    }
}
