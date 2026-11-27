package io.dcloud.feature.nativeObj;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NativeView extends android.widget.FrameLayout implements io.dcloud.common.DHInterface.IWaiter, io.dcloud.common.DHInterface.INativeView, io.dcloud.common.DHInterface.IReflectAble {
    static final java.lang.String T = "{clientX:%d,clientY:%d,pageX:%d,pageY:%d,screenX:%d,screenY:%d}";
    private boolean isAnimate;
    protected boolean isImmersed;
    public boolean isLayoutAdapt;
    public boolean isStatusBar;
    boolean isWebAnimationRuning;
    io.dcloud.common.DHInterface.IApp mApp;
    public int mAppScreenHeight;
    public int mAppScreenWidth;
    boolean mAttached;
    protected int mBackGroundColor;
    protected java.lang.String mBackgroundImageSrc;
    public io.dcloud.feature.nativeObj.NativeView.NativeCanvasView mCanvasView;
    java.util.HashMap<java.lang.String, io.dcloud.feature.nativeObj.INativeViewChildView> mChildViewMaps;
    public float mCreateScale;
    io.dcloud.common.DHInterface.IFrameView mFrameViewParent;
    private android.os.Handler mHandler;
    java.lang.String mID;
    io.dcloud.common.DHInterface.IEventCallback mIEventCallback;
    protected int mInnerBottom;
    public int mInnerHeight;
    public int mInnerLeft;
    protected int mInnerRight;
    public int mInnerTop;
    public int mInnerWidth;
    boolean mIntercept;
    public int mMarginBottom;
    public int mMarginTop;
    java.util.HashMap<java.lang.String, java.lang.Integer> mOverlayMaps;
    java.util.ArrayList<io.dcloud.feature.nativeObj.NativeView.Overlay> mOverlays;
    android.graphics.Paint mPaint;
    private int mRegionBottom;
    private org.json.JSONObject mRegionJson;
    private int mRegionLeft;
    private android.graphics.RectF mRegionRect;
    private int mRegionRight;
    private int mRegionTop;
    boolean mShow;
    public int mStatusColor;
    protected android.view.View mStatusbarView;
    public org.json.JSONObject mStyle;
    java.lang.String mTouchRectJson;
    java.util.ArrayList<android.graphics.RectF> mTouchRects;
    float mTouchX;
    float mTouchY;
    public java.lang.String mUUID;
    protected io.dcloud.common.DHInterface.IWebview mWebView;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class NativeCanvasView extends android.view.View implements android.view.View.OnClickListener {
        private java.lang.Runnable clickEventRunnable;
        java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, io.dcloud.common.DHInterface.IWebview>> doEventListenerMap;
        boolean isAddDoubleClickEvent;
        boolean isTouchDown;
        long mCurClickTime;
        long mLastClickTime;

        public NativeCanvasView(android.content.Context context) {
            super(context);
            this.doEventListenerMap = new java.util.HashMap<>(2);
            this.mCurClickTime = 0L;
            this.mLastClickTime = 0L;
            this.isAddDoubleClickEvent = false;
            this.clickEventRunnable = null;
            this.isTouchDown = false;
            setOnClickListener(this);
            setClickable(false);
        }

        private void drawRect(android.graphics.Canvas canvas, int i, int i2, int i3, int i4, io.dcloud.feature.nativeObj.NativeView.Overlay overlay) {
            io.dcloud.feature.nativeObj.NativeView.this.mPaint.reset();
            io.dcloud.feature.nativeObj.NativeView.this.mPaint.setAntiAlias(true);
            android.graphics.RectF rectF = new android.graphics.RectF(i, i2, i3, i4);
            if (overlay.borderWidth <= 0.0f) {
                io.dcloud.feature.nativeObj.NativeView.this.mPaint.setColor(overlay.mRectColor);
                canvas.drawRoundRect(rectF, overlay.radius, overlay.radius, io.dcloud.feature.nativeObj.NativeView.this.mPaint);
                return;
            }
            int i5 = overlay.mRectColor;
            if (((-16777216) & i5) == 0) {
                io.dcloud.feature.nativeObj.NativeView.this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
                io.dcloud.feature.nativeObj.NativeView.this.mPaint.setStrokeWidth(overlay.borderWidth);
                io.dcloud.feature.nativeObj.NativeView.this.mPaint.setColor(overlay.borderColor);
                canvas.drawRoundRect(rectF, overlay.radius, overlay.radius, io.dcloud.feature.nativeObj.NativeView.this.mPaint);
                return;
            }
            io.dcloud.feature.nativeObj.NativeView.this.mPaint.setColor(i5);
            io.dcloud.feature.nativeObj.NativeView.this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawRoundRect(rectF, overlay.radius, overlay.radius, io.dcloud.feature.nativeObj.NativeView.this.mPaint);
            io.dcloud.feature.nativeObj.NativeView.this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            io.dcloud.feature.nativeObj.NativeView.this.mPaint.setStrokeWidth(overlay.borderWidth);
            io.dcloud.feature.nativeObj.NativeView.this.mPaint.setColor(overlay.borderColor);
            canvas.drawRoundRect(rectF, overlay.radius, overlay.radius, io.dcloud.feature.nativeObj.NativeView.this.mPaint);
        }

        private void initAuto(io.dcloud.feature.nativeObj.NativeView.Overlay overlay) {
            android.graphics.Rect rect = overlay.mDestRect;
            if (rect.left == Integer.MIN_VALUE) {
                io.dcloud.feature.nativeObj.NativeView nativeView = io.dcloud.feature.nativeObj.NativeView.this;
                int i = nativeView.mInnerLeft;
                int i2 = nativeView.mInnerWidth;
                int i3 = rect.right;
                int i4 = i + ((i2 - i3) / 2);
                rect.left = i4;
                rect.right = i3 + i4;
            }
            if (rect.top == Integer.MIN_VALUE) {
                io.dcloud.feature.nativeObj.NativeView nativeView2 = io.dcloud.feature.nativeObj.NativeView.this;
                int i5 = nativeView2.mInnerTop;
                int i6 = nativeView2.mInnerHeight;
                int i7 = rect.bottom;
                int i8 = i5 + ((i6 - i7) / 2);
                rect.top = i8;
                rect.bottom = i7 + i8;
            }
        }

        private void postDelayedClickEvent() {
            if (this.clickEventRunnable == null) {
                this.clickEventRunnable = new java.lang.Runnable() { // from class: io.dcloud.feature.nativeObj.NativeView.NativeCanvasView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        io.dcloud.feature.nativeObj.NativeView.NativeCanvasView.this.doTypeEvent(com.taobao.weex.common.Constants.Event.CLICK);
                        io.dcloud.feature.nativeObj.NativeView.NativeCanvasView.this.clickEventRunnable = null;
                    }
                };
            }
            postDelayed(this.clickEventRunnable, 300L);
        }

        void addEventListener(java.lang.String str, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str2) {
            java.util.HashMap<java.lang.String, io.dcloud.common.DHInterface.IWebview> map = this.doEventListenerMap.get(str);
            if (map == null) {
                map = new java.util.HashMap<>(2);
                this.doEventListenerMap.put(str, map);
            }
            if (android.text.TextUtils.equals(str, com.taobao.weex.common.Constants.Event.CLICK)) {
                setClickable(true);
            }
            if (android.text.TextUtils.equals(str, "doubleclick")) {
                this.isAddDoubleClickEvent = true;
            }
            for (java.lang.String str3 : this.doEventListenerMap.keySet()) {
                java.util.HashMap<java.lang.String, io.dcloud.common.DHInterface.IWebview> map2 = this.doEventListenerMap.get(str3);
                if (str3 != null && map2.containsValue(iWebview)) {
                    map.put(str2, iWebview);
                }
            }
            iWebview.obtainFrameView().addFrameViewListener(new io.dcloud.common.DHInterface.IEventCallback() { // from class: io.dcloud.feature.nativeObj.NativeView.NativeCanvasView.2
                @Override // io.dcloud.common.DHInterface.IEventCallback
                public java.lang.Object onCallBack(java.lang.String str4, java.lang.Object obj) {
                    if (str4 != io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE && str4 != io.dcloud.common.constant.AbsoluteConst.EVENTS_WINDOW_CLOSE) {
                        return null;
                    }
                    for (java.lang.String str5 : io.dcloud.feature.nativeObj.NativeView.NativeCanvasView.this.doEventListenerMap.keySet()) {
                        java.util.HashMap<java.lang.String, io.dcloud.common.DHInterface.IWebview> map3 = io.dcloud.feature.nativeObj.NativeView.NativeCanvasView.this.doEventListenerMap.get(str5);
                        if (!map3.isEmpty()) {
                            java.util.Set<java.lang.String> setKeySet = map3.keySet();
                            int size = setKeySet.size();
                            java.lang.String[] strArr = new java.lang.String[size];
                            setKeySet.toArray(strArr);
                            for (int i = size - 1; i >= 0; i--) {
                                java.lang.String str6 = strArr[i];
                                if (map3.get(str6) == obj) {
                                    map3.remove(str6);
                                }
                            }
                        }
                        if (map3.isEmpty() && android.text.TextUtils.equals(str5, com.taobao.weex.common.Constants.Event.CLICK)) {
                            io.dcloud.feature.nativeObj.NativeView.NativeCanvasView.this.setClickable(false);
                        }
                    }
                    ((io.dcloud.common.DHInterface.IWebview) obj).obtainFrameView().removeFrameViewListener(this);
                    return null;
                }
            });
            map.put(str2, iWebview);
        }

        public boolean doTypeEvent(java.lang.String str) {
            java.util.HashMap<java.lang.String, io.dcloud.common.DHInterface.IWebview> map = this.doEventListenerMap.get(str);
            boolean z = false;
            if (map != null) {
                for (java.lang.String str2 : map.keySet()) {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(map.get(str2), str2, io.dcloud.feature.nativeObj.NativeView.this.getEventJSON(), io.dcloud.common.util.JSUtil.OK, true, true);
                    z = true;
                }
            }
            return z;
        }

        public boolean listenClick() {
            java.util.HashMap<java.lang.String, io.dcloud.common.DHInterface.IWebview> map = this.doEventListenerMap.get(com.taobao.weex.common.Constants.Event.CLICK);
            return (map == null || map.isEmpty()) ? false : true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            io.dcloud.feature.nativeObj.NativeView nativeView = io.dcloud.feature.nativeObj.NativeView.this;
            if (nativeView.checkTouchRectsContains(nativeView.mTouchX, nativeView.mTouchY)) {
                this.mLastClickTime = this.mCurClickTime;
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                this.mCurClickTime = jCurrentTimeMillis;
                boolean z = this.isAddDoubleClickEvent;
                if (!z || jCurrentTimeMillis - this.mLastClickTime >= 300) {
                    if (z) {
                        postDelayedClickEvent();
                        return;
                    } else {
                        doTypeEvent(com.taobao.weex.common.Constants.Event.CLICK);
                        return;
                    }
                }
                java.lang.Runnable runnable = this.clickEventRunnable;
                if (runnable != null) {
                    removeCallbacks(runnable);
                }
                doTypeEvent("doubleclick");
            }
        }

        @Override // android.view.View
        protected void onDraw(android.graphics.Canvas canvas) {
            int i;
            int i2;
            int i3;
            android.graphics.Typeface typefaceCreate;
            io.dcloud.feature.nativeObj.NativeView.NativeCanvasView nativeCanvasView = this;
            android.graphics.Canvas canvas2 = canvas;
            canvas2.save();
            int i4 = 0;
            canvas2.setDrawFilter(new android.graphics.PaintFlagsDrawFilter(0, 3));
            io.dcloud.feature.nativeObj.NativeView nativeView = io.dcloud.feature.nativeObj.NativeView.this;
            canvas2.clipRect(nativeView.mInnerLeft, nativeView.mInnerTop, nativeView.mInnerRight, nativeView.mInnerBottom);
            if (io.dcloud.feature.nativeObj.NativeView.this.getViewType().equals(io.dcloud.common.constant.AbsoluteConst.NATIVE_NVIEW)) {
                canvas2.drawColor(io.dcloud.feature.nativeObj.NativeView.this.mBackGroundColor);
            }
            if (io.dcloud.feature.nativeObj.NativeView.this.mRegionRect != null) {
                canvas2.clipRect(io.dcloud.feature.nativeObj.NativeView.this.mRegionRect, android.graphics.Region.Op.DIFFERENCE);
            }
            java.util.ArrayList<io.dcloud.feature.nativeObj.NativeView.Overlay> arrayList = io.dcloud.feature.nativeObj.NativeView.this.mOverlays;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                io.dcloud.feature.nativeObj.NativeView.Overlay overlay = arrayList.get(i5);
                i5++;
                io.dcloud.feature.nativeObj.NativeView.Overlay overlay2 = overlay;
                if (overlay2.type.equals("clear")) {
                    canvas2.clipRect(overlay2.mDestRect, android.graphics.Region.Op.DIFFERENCE);
                }
            }
            java.util.ArrayList<io.dcloud.feature.nativeObj.NativeView.Overlay> arrayList2 = io.dcloud.feature.nativeObj.NativeView.this.mOverlays;
            int size2 = arrayList2.size();
            int i6 = 0;
            while (i6 < size2) {
                int i7 = i6 + 1;
                io.dcloud.feature.nativeObj.NativeView.Overlay overlay3 = arrayList2.get(i6);
                io.dcloud.feature.nativeObj.NativeView.this.mPaint.reset();
                canvas2.save();
                io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap = overlay3.mNativeBitmap;
                if (nativeBitmap != null && nativeBitmap.getBitmap() != null && !overlay3.mNativeBitmap.isRecycled() && !overlay3.mNativeBitmap.isGif()) {
                    android.graphics.Rect rect = overlay3.mDestRect;
                    if (rect.left == Integer.MIN_VALUE || rect.top == Integer.MIN_VALUE) {
                        nativeCanvasView.initAuto(overlay3);
                        canvas2.drawBitmap(overlay3.mNativeBitmap.getBitmap(), overlay3.mSrcRect, overlay3.mDestRect, io.dcloud.feature.nativeObj.NativeView.this.mPaint);
                    } else {
                        canvas2.clipRect(rect);
                        canvas2.drawBitmap(overlay3.mNativeBitmap.getBitmap(), overlay3.mSrcRect, overlay3.mDestRect, io.dcloud.feature.nativeObj.NativeView.this.mPaint);
                    }
                } else if (overlay3.mText != null) {
                    nativeCanvasView.initAuto(overlay3);
                    canvas2.clipRect(overlay3.mDestRect);
                    io.dcloud.feature.nativeObj.NativeView.this.mPaint.reset();
                    io.dcloud.feature.nativeObj.NativeView.this.mPaint.setAntiAlias(true);
                    int i8 = overlay3.mFontColor;
                    if (i8 != 0) {
                        io.dcloud.feature.nativeObj.NativeView.this.mPaint.setColor(i8);
                    }
                    if (overlay3.mFontColor == 0) {
                        io.dcloud.feature.nativeObj.NativeView.this.mPaint.setColor(i4);
                    }
                    float f = overlay3.mFontSize;
                    if (f != 0.0f) {
                        io.dcloud.feature.nativeObj.NativeView.this.mPaint.setTextSize(f);
                    }
                    if (!android.text.TextUtils.isEmpty(overlay3.textTTFPh)) {
                        android.graphics.Typeface typeface = io.dcloud.feature.nativeObj.NativeTypefaceFactory.getTypeface(io.dcloud.feature.nativeObj.NativeView.this.mApp, overlay3.textTTFPh);
                        if (typeface != null) {
                            io.dcloud.feature.nativeObj.NativeView.this.mPaint.setTypeface(typeface);
                        }
                    } else if (!android.text.TextUtils.isEmpty(overlay3.textFamily) && (typefaceCreate = android.graphics.Typeface.create(overlay3.textFamily, i4)) != null) {
                        io.dcloud.feature.nativeObj.NativeView.this.mPaint.setTypeface(typefaceCreate);
                    }
                    io.dcloud.feature.nativeObj.NativeView.this.mPaint.setFakeBoldText(overlay3.textWeight.equals(io.dcloud.common.adapter.ui.FrameBitmapView.BOLD));
                    if (overlay3.textStyle.equals(io.dcloud.common.adapter.ui.FrameBitmapView.ITALIC)) {
                        io.dcloud.feature.nativeObj.NativeView.this.mPaint.setTextSkewX(-0.5f);
                    }
                    io.dcloud.feature.nativeObj.NativeView.this.mPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
                    int iCenterX = overlay3.mDestRect.centerX();
                    if (overlay3.textAlign.equals("right")) {
                        io.dcloud.feature.nativeObj.NativeView.this.mPaint.setTextAlign(android.graphics.Paint.Align.RIGHT);
                        iCenterX = overlay3.mDestRect.right;
                    } else if (overlay3.textAlign.equals("left")) {
                        io.dcloud.feature.nativeObj.NativeView.this.mPaint.setTextAlign(android.graphics.Paint.Align.LEFT);
                        iCenterX = overlay3.mDestRect.left;
                    }
                    java.lang.String string = overlay3.mText;
                    if (overlay3.textDecoration.equals("underline")) {
                        io.dcloud.feature.nativeObj.NativeView.this.mPaint.setUnderlineText(true);
                    } else if (overlay3.textDecoration.equals("line-through")) {
                        io.dcloud.feature.nativeObj.NativeView.this.mPaint.setFlags(16);
                    }
                    android.text.TextPaint textPaint = new android.text.TextPaint();
                    textPaint.set(io.dcloud.feature.nativeObj.NativeView.this.mPaint);
                    if (overlay3.textWhiteSpace.equals("normal")) {
                        int iWidth = overlay3.mDestRect.width();
                        android.text.Layout.Alignment alignment = android.text.Layout.Alignment.ALIGN_NORMAL;
                        android.text.StaticLayout staticLayout = new android.text.StaticLayout(string, textPaint, iWidth, alignment, overlay3.textLineSpacing + 0.9f, 0.0f, true);
                        if (!overlay3.textAdapt && staticLayout.getHeight() > overlay3.mDestRect.height()) {
                            int lineEnd = staticLayout.getLineEnd((overlay3.mDestRect.height() / (staticLayout.getHeight() / staticLayout.getLineCount())) - 1);
                            java.lang.String str = overlay3.textOverflow.equals(com.taobao.weex.common.Constants.Name.ELLIPSIS) ? "…" : "";
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            if (!android.text.TextUtils.isEmpty(str)) {
                                lineEnd--;
                            }
                            sb.append(string.substring(0, lineEnd));
                            sb.append(str);
                            staticLayout = new android.text.StaticLayout(sb.toString(), textPaint, overlay3.mDestRect.width(), alignment, overlay3.textLineSpacing + 0.9f, 0.0f, false);
                        }
                        int iHeight = (overlay3.mDestRect.height() - staticLayout.getHeight()) / 2;
                        if (overlay3.textVerticalAligin.equals("top")) {
                            iHeight = 0;
                        } else if (overlay3.textVerticalAligin.equals("bottom")) {
                            iHeight = overlay3.mDestRect.height() - staticLayout.getHeight();
                        }
                        int i9 = iHeight + overlay3.mDestRect.top;
                        canvas2.save();
                        canvas2.translate(iCenterX, i9);
                        staticLayout.draw(canvas2);
                        canvas2.restore();
                    } else {
                        if (overlay3.textOverflow.equals(com.taobao.weex.common.Constants.Name.ELLIPSIS)) {
                            string = android.text.TextUtils.ellipsize(string, textPaint, overlay3.mDestRect.width(), android.text.TextUtils.TruncateAt.END).toString();
                        }
                        android.graphics.Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
                        float f2 = fontMetrics.top;
                        float f3 = fontMetrics.bottom;
                        int iCenterY = (int) ((overlay3.mDestRect.centerY() - (f2 / 2.0f)) - (f3 / 2.0f));
                        if (overlay3.textVerticalAligin.equals("top")) {
                            iCenterY = (int) (overlay3.mDestRect.top - f2);
                        } else if (overlay3.textVerticalAligin.equals("bottom")) {
                            iCenterY = (int) (overlay3.mDestRect.bottom - f3);
                        }
                        canvas2.drawText(string, iCenterX, iCenterY, textPaint);
                    }
                } else if (overlay3.type.equals("rect")) {
                    canvas2.save();
                    android.graphics.Rect rect2 = overlay3.mDestRect;
                    int i10 = rect2.left;
                    if (i10 == Integer.MIN_VALUE || (i3 = rect2.top) == Integer.MIN_VALUE) {
                        int i11 = rect2.top;
                        int i12 = rect2.right;
                        int i13 = rect2.bottom;
                        if (i10 == Integer.MIN_VALUE) {
                            io.dcloud.feature.nativeObj.NativeView nativeView2 = io.dcloud.feature.nativeObj.NativeView.this;
                            int i14 = (nativeView2.mInnerWidth - (i12 - nativeView2.mInnerLeft)) / 2;
                            i = i12 + i14;
                            i2 = i14;
                        } else {
                            i = i12;
                        }
                        if (i11 == Integer.MIN_VALUE) {
                            i2 = i10;
                            io.dcloud.feature.nativeObj.NativeView nativeView3 = io.dcloud.feature.nativeObj.NativeView.this;
                            i11 = (nativeView3.mInnerHeight - (i13 - nativeView3.mInnerTop)) / 2;
                            i13 += i11;
                        }
                        i2 = i10;
                        nativeCanvasView.drawRect(canvas, i2, i11, i, i13, overlay3);
                    } else {
                        nativeCanvasView.drawRect(canvas2, i10, i3, rect2.right, rect2.bottom, overlay3);
                    }
                    canvas.restore();
                }
                canvas.restore();
                nativeCanvasView = this;
                canvas2 = canvas;
                i6 = i7;
                i4 = 0;
            }
            canvas.restore();
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int size = android.view.View.MeasureSpec.getSize(i);
            int size2 = android.view.View.MeasureSpec.getSize(i2);
            io.dcloud.feature.nativeObj.NativeView nativeView = io.dcloud.feature.nativeObj.NativeView.this;
            if (size != nativeView.mAppScreenWidth || size2 != nativeView.mAppScreenHeight) {
                nativeView.mAppScreenWidth = size;
                nativeView.mAppScreenHeight = size2;
                nativeView.init();
                io.dcloud.common.adapter.util.Logger.e("NativeView", io.dcloud.feature.nativeObj.NativeView.this.mAppScreenWidth + ";onMeasure;" + io.dcloud.feature.nativeObj.NativeView.this.mAppScreenHeight);
            }
            io.dcloud.feature.nativeObj.NativeView nativeView2 = io.dcloud.feature.nativeObj.NativeView.this;
            int i3 = nativeView2.mInnerHeight + nativeView2.mInnerTop;
            int i4 = nativeView2.mAppScreenHeight;
            if (i3 <= i4) {
                i3 = i4;
            }
            nativeView2.mAppScreenHeight = i3;
            int i5 = 0;
            nativeView2.measureFitViewParent(false);
            io.dcloud.common.DHInterface.IWebview iWebview = io.dcloud.feature.nativeObj.NativeView.this.mWebView;
            if (iWebview != null && iWebview.obtainApp() != null) {
                java.util.ArrayList<io.dcloud.feature.nativeObj.NativeView.Overlay> arrayList = io.dcloud.feature.nativeObj.NativeView.this.mOverlays;
                int size3 = arrayList.size();
                while (i5 < size3) {
                    io.dcloud.feature.nativeObj.NativeView.Overlay overlay = arrayList.get(i5);
                    i5++;
                    overlay.parseJson(io.dcloud.feature.nativeObj.NativeView.this.mWebView);
                }
            }
            io.dcloud.feature.nativeObj.NativeView nativeView3 = io.dcloud.feature.nativeObj.NativeView.this;
            setMeasuredDimension(nativeView3.mAppScreenWidth, nativeView3.mAppScreenHeight);
        }

        @Override // android.view.View
        public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            io.dcloud.feature.nativeObj.NativeView.this.mTouchX = motionEvent.getX();
            io.dcloud.feature.nativeObj.NativeView.this.mTouchY = motionEvent.getY();
            io.dcloud.feature.nativeObj.NativeView nativeView = io.dcloud.feature.nativeObj.NativeView.this;
            if (!nativeView.mIntercept) {
                return false;
            }
            boolean zCheckTouchRectsContains = nativeView.checkTouchRectsContains(nativeView.mTouchX, nativeView.mTouchY);
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    this.isTouchDown = false;
                    if (zCheckTouchRectsContains) {
                        doTypeEvent("touchend");
                    }
                } else if (actionMasked != 2) {
                    if (actionMasked == 3) {
                        this.isTouchDown = false;
                        if (zCheckTouchRectsContains) {
                            doTypeEvent("touchcancel");
                        }
                    }
                } else if (this.isTouchDown) {
                    doTypeEvent("touchmove");
                }
            } else if (zCheckTouchRectsContains) {
                this.isTouchDown = true;
                doTypeEvent(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBVIEW_ONTOUCH_START);
            }
            if (zCheckTouchRectsContains) {
                if (io.dcloud.feature.nativeObj.NativeView.this.mIntercept) {
                    return listenClick() ? super.onTouchEvent(motionEvent) : io.dcloud.feature.nativeObj.NativeView.this.mIntercept;
                }
                return false;
            }
            if (listenClick()) {
                return false;
            }
            return super.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class Overlay {
        private int borderColor;
        private int borderRadius;
        private float borderWidth;
        java.lang.String callBackId;
        int inputBackgroundColor;
        java.lang.String inputOnBlurCallBackId;
        java.lang.String inputOnFocusCallBackId;
        java.lang.String inputType;
        org.json.JSONObject mDestJson;
        android.graphics.Rect mDestRect;
        int mFontColor = -16777216;
        float mFontSize;
        io.dcloud.feature.nativeObj.NativeBitmap mNativeBitmap;
        io.dcloud.feature.nativeObj.NativeView mNativeView;
        int mRectColor;
        org.json.JSONObject mSrcJson;
        android.graphics.Rect mSrcRect;
        org.json.JSONObject mStyleJson;
        java.lang.String mText;
        int margin;
        java.lang.String placeholder;
        int placeholderColor;
        private float radius;
        boolean textAdapt;
        java.lang.String textAlign;
        java.lang.String textDecoration;
        java.lang.String textFamily;
        float textLineSpacing;
        java.lang.String textOverflow;
        java.lang.String textStyle;
        java.lang.String textTTFPh;
        java.lang.String textVerticalAligin;
        java.lang.String textWeight;
        java.lang.String textWhiteSpace;
        java.lang.String type;
        io.dcloud.common.DHInterface.IWebview webview;

        Overlay() {
            java.lang.String str = io.dcloud.common.adapter.ui.FrameBitmapView.NORMAL;
            this.textWeight = str;
            this.textStyle = str;
            this.textFamily = "";
            this.textAlign = "center";
            this.textTTFPh = null;
            this.textOverflow = "clip";
            this.textDecoration = "none";
            this.textWhiteSpace = "nowrap";
            this.textVerticalAligin = "middle";
            this.textLineSpacing = 0.2f;
            this.textAdapt = false;
            this.margin = 0;
            this.borderWidth = -1.0f;
            this.borderColor = -1;
            this.borderRadius = 0;
            this.radius = 0.0f;
            this.inputType = "text";
            this.inputBackgroundColor = 0;
            this.placeholder = "";
        }

        void parseJson(io.dcloud.common.DHInterface.IWebview iWebview) {
            int i;
            io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap = this.mNativeBitmap;
            if (nativeBitmap != null) {
                this.mSrcRect = io.dcloud.feature.nativeObj.NativeView.makeBitmapSrcRect(this.mNativeView, this.mSrcJson, nativeBitmap);
                if (this.mNativeBitmap.isNetWorkBitmap()) {
                    this.mNativeBitmap.initNetworkBitmap(new com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener() { // from class: io.dcloud.feature.nativeObj.NativeView.Overlay.1
                        @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                        public void onLoadingCancelled(java.lang.String str, android.view.View view) {
                        }

                        @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                        public void onLoadingComplete(java.lang.String str, android.view.View view, android.graphics.Bitmap bitmap) {
                            io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap2 = io.dcloud.feature.nativeObj.NativeView.Overlay.this.mNativeBitmap;
                            if (nativeBitmap2 != null) {
                                nativeBitmap2.setBitmap(bitmap);
                                io.dcloud.feature.nativeObj.NativeView.Overlay.this.mNativeBitmap.setNetWorkBitmapDownload(true);
                            }
                            io.dcloud.feature.nativeObj.NativeView nativeView = io.dcloud.feature.nativeObj.NativeView.Overlay.this.mNativeView;
                            if (nativeView == null || nativeView.getParent() == null) {
                                return;
                            }
                            io.dcloud.feature.nativeObj.NativeView.Overlay overlay = io.dcloud.feature.nativeObj.NativeView.Overlay.this;
                            io.dcloud.feature.nativeObj.NativeView nativeView2 = overlay.mNativeView;
                            if (nativeView2.mCanvasView != null) {
                                overlay.mSrcRect = io.dcloud.feature.nativeObj.NativeView.makeBitmapSrcRect(nativeView2, overlay.mSrcJson, overlay.mNativeBitmap);
                                io.dcloud.feature.nativeObj.NativeView.Overlay overlay2 = io.dcloud.feature.nativeObj.NativeView.Overlay.this;
                                overlay2.mDestRect = io.dcloud.feature.nativeObj.NativeView.this.makeRect(overlay2.mNativeView, overlay2.mDestJson, this);
                                if (io.dcloud.feature.nativeObj.NativeView.Overlay.this.mNativeBitmap.isGif()) {
                                    io.dcloud.feature.nativeObj.NativeView.this.addGifImagview(this);
                                } else {
                                    io.dcloud.feature.nativeObj.NativeView.Overlay.this.mNativeView.mCanvasView.invalidate();
                                }
                            }
                        }

                        @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                        public void onLoadingFailed(java.lang.String str, android.view.View view, com.nostra13.dcloudimageloader.core.assist.FailReason failReason) {
                        }

                        @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                        public void onLoadingStarted(java.lang.String str, android.view.View view) {
                        }
                    });
                }
            }
            org.json.JSONObject jSONObject = this.mStyleJson;
            if (jSONObject != null) {
                java.lang.String strOptString = jSONObject.optString("color");
                if (!android.text.TextUtils.isEmpty(strOptString) && !strOptString.equals("null")) {
                    try {
                        this.mFontColor = android.graphics.Color.parseColor(strOptString);
                    } catch (java.lang.Exception unused) {
                        this.mFontColor = io.dcloud.common.util.PdrUtil.stringToColor(strOptString);
                    }
                }
                java.lang.String strOptString2 = this.mStyleJson.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE);
                if (android.text.TextUtils.isEmpty(strOptString2)) {
                    strOptString2 = "16px";
                }
                io.dcloud.feature.nativeObj.NativeView nativeView = this.mNativeView;
                this.mFontSize = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString2, nativeView.mInnerWidth, 0, nativeView.mCreateScale);
                this.textWeight = this.mStyleJson.optString("weight", this.textWeight);
                this.textStyle = this.mStyleJson.optString("style", this.textStyle);
                this.textFamily = this.mStyleJson.optString(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY, this.textFamily);
                this.textAlign = this.mStyleJson.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ALIGN, this.textAlign);
                this.textOverflow = this.mStyleJson.optString(com.taobao.weex.common.Constants.Name.OVERFLOW, this.textOverflow);
                this.textDecoration = this.mStyleJson.optString("decoration", this.textDecoration);
                this.textWhiteSpace = this.mStyleJson.optString("whiteSpace", this.textWhiteSpace);
                this.textVerticalAligin = this.mStyleJson.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_VERTICAL_ALIGN, this.textVerticalAligin);
                java.lang.String str = "0px";
                if (this.mStyleJson.has(com.taobao.weex.common.Constants.Name.BORDER_WIDTH)) {
                    java.lang.String strOptString3 = this.mStyleJson.optString(com.taobao.weex.common.Constants.Name.BORDER_WIDTH);
                    if (android.text.TextUtils.isEmpty(strOptString3)) {
                        strOptString3 = "0px";
                    }
                    io.dcloud.feature.nativeObj.NativeView nativeView2 = this.mNativeView;
                    this.borderWidth = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString3, nativeView2.mInnerWidth, 0, nativeView2.mCreateScale);
                }
                this.borderColor = this.mRectColor;
                if (this.mStyleJson.has(com.taobao.weex.common.Constants.Name.BORDER_COLOR)) {
                    this.borderColor = io.dcloud.common.util.PdrUtil.stringToColor(this.mStyleJson.optString(com.taobao.weex.common.Constants.Name.BORDER_COLOR));
                }
                if (this.mStyleJson.has("radius")) {
                    java.lang.String strOptString4 = this.mStyleJson.optString("radius");
                    if (android.text.TextUtils.isEmpty(strOptString4)) {
                        strOptString4 = "0px";
                    }
                    io.dcloud.feature.nativeObj.NativeView nativeView3 = this.mNativeView;
                    this.radius = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString4, nativeView3.mInnerWidth, 0, nativeView3.mCreateScale);
                }
                if (this.mStyleJson.has("lineSpacing")) {
                    this.textLineSpacing = io.dcloud.common.util.PdrUtil.convertToScreenInt(this.mStyleJson.optString("lineSpacing"), (int) this.mFontSize, 0, this.mNativeView.mCreateScale) / this.mFontSize;
                }
                if (this.mStyleJson.has("fontSrc")) {
                    java.lang.String strOptString5 = this.mStyleJson.optString("fontSrc", "");
                    if (strOptString5.contains("__wap2app.ttf")) {
                        java.lang.String str2 = io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__wap2app.ttf";
                        if (new java.io.File(str2).exists()) {
                            this.textTTFPh = str2;
                        } else {
                            this.textTTFPh = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), strOptString5);
                        }
                    } else {
                        this.textTTFPh = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), strOptString5);
                    }
                }
                java.lang.String strOptString6 = this.mStyleJson.optString("margin", "0px");
                io.dcloud.feature.nativeObj.NativeView nativeView4 = this.mNativeView;
                this.margin = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString6, nativeView4.mInnerWidth, 0, nativeView4.mCreateScale);
                if ("input".equals(this.type)) {
                    this.inputType = "text";
                    if (this.mStyleJson.has("type")) {
                        java.lang.String strOptString7 = this.mStyleJson.optString("type");
                        if (!android.text.TextUtils.isEmpty(strOptString7)) {
                            this.inputType = strOptString7;
                        }
                    }
                    this.placeholderColor = -7829368;
                    this.placeholder = "";
                    if (this.mStyleJson.has(com.taobao.weex.common.Constants.Name.PLACEHOLDER)) {
                        this.placeholder = this.mStyleJson.optString(com.taobao.weex.common.Constants.Name.PLACEHOLDER);
                    }
                    if (this.mStyleJson.has(com.taobao.weex.common.Constants.Name.FONT_SIZE)) {
                        java.lang.String strOptString8 = this.mStyleJson.optString(com.taobao.weex.common.Constants.Name.FONT_SIZE);
                        java.lang.String str3 = android.text.TextUtils.isEmpty(strOptString8) ? "16px" : strOptString8;
                        io.dcloud.feature.nativeObj.NativeView nativeView5 = this.mNativeView;
                        this.mFontSize = io.dcloud.common.util.PdrUtil.convertToScreenInt(str3, nativeView5.mInnerWidth, 0, nativeView5.mCreateScale);
                    }
                    this.mFontColor = -16777216;
                    if (this.mStyleJson.has("fontColor")) {
                        java.lang.String strOptString9 = this.mStyleJson.optString("fontColor");
                        if (!android.text.TextUtils.isEmpty(strOptString9)) {
                            if (java.util.regex.Pattern.compile("^#[0-9a-fA-F]{6}$").matcher(strOptString9).matches()) {
                                this.mFontSize = io.dcloud.common.util.PdrUtil.stringToColor(strOptString9);
                            }
                            if (java.util.regex.Pattern.compile("^rgba\\(((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\,){3}([0-1]{1}|0\\.[1-9]{1})\\)$").matcher(strOptString9).matches()) {
                                this.mFontSize = io.dcloud.common.util.PdrUtil.stringToColor(strOptString9);
                            }
                        }
                    }
                    this.inputBackgroundColor = 0;
                    if (this.mStyleJson.has("backgroundColor")) {
                        java.lang.String strOptString10 = this.mStyleJson.optString("backgroundColor");
                        if (!android.text.TextUtils.isEmpty(strOptString10)) {
                            if (java.util.regex.Pattern.compile("^#[0-9a-fA-F]{6}$").matcher(strOptString10).matches()) {
                                this.inputBackgroundColor = io.dcloud.common.util.PdrUtil.stringToColor(strOptString10);
                            }
                            if (java.util.regex.Pattern.compile("^rgba\\(((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\,){3}([0-1]{1}|0\\.[1-9]{1})\\)$").matcher(strOptString10).matches()) {
                                this.inputBackgroundColor = io.dcloud.common.util.PdrUtil.stringToColor(strOptString10);
                            }
                        }
                    }
                    this.borderColor = -16777216;
                    if (this.mStyleJson.has(com.taobao.weex.common.Constants.Name.BORDER_COLOR)) {
                        java.lang.String strOptString11 = this.mStyleJson.optString(com.taobao.weex.common.Constants.Name.BORDER_COLOR);
                        if (!android.text.TextUtils.isEmpty(strOptString11) && java.util.regex.Pattern.compile("^#[0-9a-fA-F]{6}$").matcher(strOptString11).matches()) {
                            this.borderColor = io.dcloud.common.util.PdrUtil.stringToColor(strOptString11);
                        }
                    }
                    io.dcloud.feature.nativeObj.NativeView nativeView6 = this.mNativeView;
                    java.lang.String str4 = "1px";
                    this.borderWidth = io.dcloud.common.util.PdrUtil.convertToScreenInt("1px", nativeView6.mInnerWidth, 0, nativeView6.mCreateScale);
                    if (this.mStyleJson.has(com.taobao.weex.common.Constants.Name.BORDER_WIDTH)) {
                        java.lang.String strOptString12 = this.mStyleJson.optString(com.taobao.weex.common.Constants.Name.BORDER_WIDTH);
                        if (!android.text.TextUtils.isEmpty(strOptString12) && java.util.regex.Pattern.compile("^[1-9]\\d*px$").matcher(strOptString12).matches()) {
                            try {
                                if (!android.text.TextUtils.isEmpty(strOptString12)) {
                                    str4 = strOptString12;
                                }
                                io.dcloud.feature.nativeObj.NativeView nativeView7 = this.mNativeView;
                                this.borderWidth = io.dcloud.common.util.PdrUtil.convertToScreenInt(str4, nativeView7.mInnerWidth, 0, nativeView7.mCreateScale);
                            } catch (java.lang.Exception unused2) {
                            }
                        }
                    }
                    this.borderRadius = 0;
                    if (this.mStyleJson.has(com.taobao.weex.common.Constants.Name.BORDER_RADIUS)) {
                        java.lang.String strOptString13 = this.mStyleJson.optString(com.taobao.weex.common.Constants.Name.BORDER_RADIUS);
                        if (!android.text.TextUtils.isEmpty(strOptString13) && java.util.regex.Pattern.compile("^[1-9]\\d*px$").matcher(strOptString13).matches()) {
                            try {
                                if (!android.text.TextUtils.isEmpty(strOptString13)) {
                                    str = strOptString13;
                                }
                                io.dcloud.feature.nativeObj.NativeView nativeView8 = this.mNativeView;
                                this.borderRadius = io.dcloud.common.util.PdrUtil.convertToScreenInt(str, nativeView8.mInnerWidth, 0, nativeView8.mCreateScale);
                            } catch (java.lang.Exception unused3) {
                            }
                        }
                    }
                    if (this.mStyleJson.has("__onCompleteCallBackId__")) {
                        this.callBackId = this.mStyleJson.optString("__onCompleteCallBackId__");
                        this.mStyleJson.remove("__onCompleteCallBackId__");
                    } else if (this.mStyleJson.has("onComplete")) {
                        java.lang.String strOptString14 = this.mStyleJson.optString("onComplete");
                        if (strOptString14.startsWith(io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT) || strOptString14.startsWith("javaScript:")) {
                            this.callBackId = strOptString14;
                        }
                    }
                    if (this.mStyleJson.has("__onFocusCallBackId__")) {
                        this.inputOnFocusCallBackId = this.mStyleJson.optString("__onFocusCallBackId__");
                        this.mStyleJson.remove("__onFocusCallBackId__");
                    } else if (this.mStyleJson.has("onFocus")) {
                        java.lang.String strOptString15 = this.mStyleJson.optString("onFocus");
                        if (strOptString15.startsWith(io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT) || strOptString15.startsWith("javaScript:")) {
                            this.inputOnFocusCallBackId = strOptString15;
                        }
                    }
                    if (this.mStyleJson.has("__onBlurCallBackId__")) {
                        this.inputOnBlurCallBackId = this.mStyleJson.optString("__onBlurCallBackId__");
                        this.mStyleJson.remove("__onBlurCallBackId__");
                    } else if (this.mStyleJson.has("onBlur")) {
                        java.lang.String strOptString16 = this.mStyleJson.optString("onBlur");
                        if (strOptString16.startsWith(io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT) || strOptString16.startsWith("javaScript:")) {
                            this.inputOnBlurCallBackId = strOptString16;
                        }
                    }
                }
            }
            android.graphics.Rect rectMakeRect = io.dcloud.feature.nativeObj.NativeView.this.makeRect(this.mNativeView, this.mDestJson, this);
            this.mDestRect = rectMakeRect;
            if (rectMakeRect == null || (i = this.margin) == 0) {
                return;
            }
            rectMakeRect.left += i;
            rectMakeRect.top += i;
            rectMakeRect.right -= i;
            rectMakeRect.bottom -= i;
        }
    }

    public NativeView(android.content.Context context, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
        super(context);
        this.mShow = false;
        this.mID = null;
        this.mUUID = null;
        this.mStyle = null;
        this.mApp = null;
        this.mPaint = new android.graphics.Paint();
        this.mOverlays = new java.util.ArrayList<>();
        this.mOverlayMaps = new java.util.HashMap<>();
        this.mChildViewMaps = new java.util.HashMap<>();
        this.mMarginTop = 0;
        this.mMarginBottom = 0;
        this.mCreateScale = 1.0f;
        this.mIntercept = true;
        this.isAnimate = false;
        this.mTouchRects = new java.util.ArrayList<>();
        this.mTouchRectJson = null;
        this.mBackGroundColor = 0;
        this.mBackgroundImageSrc = null;
        this.isWebAnimationRuning = false;
        this.mHandler = new android.os.Handler();
        this.isStatusBar = false;
        this.mCanvasView = null;
        this.mStatusbarView = null;
        this.isImmersed = false;
        this.isLayoutAdapt = false;
        this.mAttached = false;
        this.mFrameViewParent = null;
        this.mIEventCallback = null;
        this.mCanvasView = new io.dcloud.feature.nativeObj.NativeView.NativeCanvasView(context);
        setWillNotDraw(false);
        io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainApp();
        this.mApp = iAppObtainApp;
        int statusBarDefaultColor = iAppObtainApp.obtainStatusBarMgr().getStatusBarDefaultColor();
        if (statusBarDefaultColor != 0) {
            this.mStatusColor = statusBarDefaultColor;
        }
        this.mWebView = iWebview;
        this.mCreateScale = iWebview.getScale();
        this.mUUID = str;
        this.mID = str2;
        this.mStyle = jSONObject;
        this.isImmersed = this.mApp.obtainStatusBarMgr().checkImmersedStatusBar(this.mApp.getActivity(), java.lang.Boolean.valueOf(this.mApp.obtainConfigProperty(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED)).booleanValue());
        setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        attachCanvasView();
        initScreenData();
        try {
            setAlpha((float) jSONObject.optDouble("opacity", 1.0d));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UpdateRegionData() {
        if (this.mRegionRect != null) {
            askRegionJson();
            android.graphics.RectF rectF = this.mRegionRect;
            rectF.left = this.mRegionLeft;
            rectF.right = this.mAppScreenWidth - this.mRegionRight;
            rectF.top = this.mRegionTop + this.mInnerTop;
            rectF.bottom = this.mInnerBottom - this.mRegionBottom;
        }
    }

    private void askRegionJson() {
        org.json.JSONObject jSONObject = this.mRegionJson;
        if (jSONObject != null) {
            this.mRegionLeft = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("left"), this.mInnerWidth, 0, this.mCreateScale);
            this.mRegionRight = io.dcloud.common.util.PdrUtil.convertToScreenInt(this.mRegionJson.optString("right"), this.mInnerWidth, 0, this.mCreateScale);
            this.mRegionTop = io.dcloud.common.util.PdrUtil.convertToScreenInt(this.mRegionJson.optString("top"), this.mInnerHeight, 0, this.mCreateScale);
            this.mRegionBottom = io.dcloud.common.util.PdrUtil.convertToScreenInt(this.mRegionJson.optString("bottom"), this.mInnerHeight, 0, this.mCreateScale);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkTouchRectsContains(float f, float f2) {
        java.util.ArrayList<android.graphics.RectF> arrayList = this.mTouchRects;
        int i = 0;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        java.util.ArrayList<android.graphics.RectF> arrayList2 = this.mTouchRects;
        int size = arrayList2.size();
        boolean z = false;
        while (i < size) {
            android.graphics.RectF rectF = arrayList2.get(i);
            i++;
            if (rectF.contains(f, f2)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endAnimatecallback(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, null, io.dcloud.common.util.JSUtil.OK, false, false);
    }

    private int getDrawLeft(int i) {
        return this.mInnerLeft + i;
    }

    private int getDrawTop(int i) {
        return this.mInnerTop + i;
    }

    private android.widget.EditText getInputById(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            android.view.View childAt = getChildAt(childCount);
            if (childAt != null && (childAt instanceof android.widget.EditText) && childAt.getTag() != null && childAt.getTag().toString().equals(str)) {
                return (android.widget.EditText) childAt;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x007b  */
    private void initScreenData() {
        int i;
        int iIntValue;
        io.dcloud.common.DHInterface.IApp iApp = this.mApp;
        if (iApp != null) {
            android.view.View viewObtainMainView = iApp.obtainWebAppRootView() != null ? this.mApp.obtainWebAppRootView().obtainMainView() : null;
            if (viewObtainMainView == null) {
                java.lang.Object objInvokeMethod = io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.appstream.actionbar.StreamAppActionBarUtil", "isTitlebarVisible", null, new java.lang.Class[]{android.app.Activity.class, java.lang.String.class}, new java.lang.Object[]{this.mApp.getActivity(), this.mApp.obtainAppId()});
                if (objInvokeMethod instanceof java.lang.Boolean ? java.lang.Boolean.valueOf(objInvokeMethod.toString()).booleanValue() : false) {
                    java.lang.Object objInvokeMethod2 = io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.appstream.actionbar.StreamAppActionBarUtil", "getTitlebarHeightPx", null, new java.lang.Class[]{android.app.Activity.class}, new java.lang.Object[]{this.mApp.getActivity()});
                    if (objInvokeMethod2 instanceof java.lang.Integer) {
                        iIntValue = java.lang.Integer.valueOf(objInvokeMethod2.toString()).intValue();
                    } else {
                        iIntValue = 0;
                    }
                } else {
                    iIntValue = 0;
                }
                i = iIntValue;
                viewObtainMainView = this.mApp.getActivity().getWindow().getDecorView().findViewById(android.R.id.content);
            } else {
                i = 0;
            }
            if (viewObtainMainView != null) {
                this.mApp.getActivity().getWindowManager();
                int i2 = this.mApp.getInt(0);
                this.mAppScreenHeight = this.mApp.getInt(1) - i;
                this.mAppScreenWidth = i2 - i;
                init();
            }
        }
    }

    static android.graphics.Rect makeBitmapSrcRect(io.dcloud.feature.nativeObj.NativeView nativeView, org.json.JSONObject jSONObject, io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap) {
        android.graphics.Rect rect = new android.graphics.Rect();
        if (nativeBitmap.getBitmap() == null) {
            return rect;
        }
        int width = nativeBitmap.getBitmap().getWidth();
        int height = nativeBitmap.getBitmap().getHeight();
        if (jSONObject == null) {
            rect.left = 0;
            rect.top = 0;
            rect.right = width;
            rect.bottom = height;
            return rect;
        }
        int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("bottom"), height, 0, 1.0f);
        int iConvertToScreenInt2 = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("right"), width, 0, 1.0f);
        int iConvertToScreenInt3 = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("left"), width, 0, 1.0f);
        int iConvertToScreenInt4 = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("top"), height, 0, 1.0f);
        if (iConvertToScreenInt2 == 0 || (jSONObject.has("width") && jSONObject.has("left"))) {
            rect.left = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("left"), width, iConvertToScreenInt3, 1.0f);
            int iConvertToScreenInt5 = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("width"), width, width, 1.0f) + rect.left;
            rect.right = iConvertToScreenInt5;
            if (iConvertToScreenInt5 <= width) {
                width = iConvertToScreenInt5;
            }
            rect.right = width;
        } else {
            rect.right = width - iConvertToScreenInt2;
            if (jSONObject.has("width")) {
                rect.left = rect.right - io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("width"), width, width, 1.0f);
            } else if (jSONObject.has("left")) {
                rect.left = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("left"), width, iConvertToScreenInt3, 1.0f);
            } else {
                rect.left = iConvertToScreenInt3;
            }
        }
        if (iConvertToScreenInt == 0 || (jSONObject.has("height") && jSONObject.has("top"))) {
            rect.top = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("top"), height, iConvertToScreenInt4, 1.0f);
            int iConvertToScreenInt6 = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("height"), height, height, 1.0f) + rect.top;
            rect.bottom = iConvertToScreenInt6;
            if (iConvertToScreenInt6 <= height) {
                height = iConvertToScreenInt6;
            }
            rect.bottom = height;
            return rect;
        }
        rect.bottom = height - iConvertToScreenInt;
        if (jSONObject.has("height")) {
            rect.top = iConvertToScreenInt - io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("height"), height, height, 1.0f);
            return rect;
        }
        if (jSONObject.has("top")) {
            rect.top = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("top"), height, iConvertToScreenInt4, 1.0f);
            return rect;
        }
        rect.top = iConvertToScreenInt4;
        return rect;
    }

    private void measureGifImageview(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            android.view.View childAt = getChildAt(i2);
            if (childAt instanceof pl.droidsonroids.gif.GifImageView) {
                pl.droidsonroids.gif.GifImageView gifImageView = (pl.droidsonroids.gif.GifImageView) childAt;
                if (gifImageView.getTag() != null) {
                    io.dcloud.feature.nativeObj.NativeView.Overlay overlay = (io.dcloud.feature.nativeObj.NativeView.Overlay) gifImageView.getTag();
                    android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) gifImageView.getLayoutParams();
                    android.graphics.Rect rect = overlay.mDestRect;
                    int i3 = rect.top;
                    if (i3 != Integer.MIN_VALUE) {
                        layoutParams.topMargin = i3 + i;
                    } else {
                        int i4 = rect.bottom;
                        layoutParams.height = i4;
                        layoutParams.topMargin = ((this.mInnerHeight - i4) + this.mInnerTop) / 2;
                    }
                }
            }
        }
    }

    private int pxFromDp(int i) {
        return (int) android.util.TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
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
        rectF.right = this.mAppScreenWidth - i2;
        float f = i3;
        rectF.top = f;
        if (i9 == i7) {
            rectF.bottom = (i6 * i9) + i3 + i8;
        } else {
            rectF.bottom = (i6 * i9) + i3;
        }
        if (this.isStatusBar) {
            float f2 = io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
            rectF.top = f + f2;
            rectF.bottom += f2;
        }
        postDelayed(new java.lang.Runnable() { // from class: io.dcloud.feature.nativeObj.NativeView.4
            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.feature.nativeObj.NativeView.this.invalidate();
                int i10 = i9;
                int i11 = i7;
                if (i10 == i11) {
                    io.dcloud.feature.nativeObj.NativeView.this.endAnimatecallback(iWebview, str);
                } else {
                    io.dcloud.feature.nativeObj.NativeView.this.runDrawRectF(iWebview, str, i, i2, i3, i4, i5, i6, i11, i8, i10 + 1);
                }
            }
        }, i5);
    }

    private void viewPostResize(final android.view.View view, final android.view.ViewGroup.LayoutParams layoutParams, final int i, final int i2, final int i3, final int i4) {
        view.post(new java.lang.Runnable() { // from class: io.dcloud.feature.nativeObj.NativeView.3
            @Override // java.lang.Runnable
            public void run() {
                android.view.ViewGroup.LayoutParams layoutParams2 = layoutParams;
                layoutParams2.height = i2;
                layoutParams2.width = i;
                view.setLayoutParams(layoutParams2);
                io.dcloud.nineoldandroids.view.ViewHelper.setY(view, i4);
                io.dcloud.nineoldandroids.view.ViewHelper.setX(view, i3);
            }
        });
    }

    public void StartAnimate(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        if (this.isWebAnimationRuning || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (getParent() == null) {
            endAnimatecallback(iWebview, str2);
            return;
        }
        this.isAnimate = true;
        org.json.JSONObject jSONObject = new org.json.JSONObject(str);
        java.lang.String strOptString = jSONObject.optString("type");
        int iOptInt = jSONObject.optInt("duration", 200);
        int iOptInt2 = jSONObject.optInt("frames", 12);
        this.mRegionJson = jSONObject.optJSONObject("region");
        askRegionJson();
        int i = iOptInt / iOptInt2;
        int i2 = this.mInnerBottom - ((this.mRegionTop + this.mInnerTop) + this.mRegionBottom);
        int i3 = i2 / iOptInt2;
        int i4 = i2 - (i3 * iOptInt2);
        if (android.text.TextUtils.isEmpty(strOptString) || !strOptString.equals("shrink")) {
            return;
        }
        runDrawRectF(iWebview, str2, this.mRegionLeft, this.mRegionRight, this.mRegionTop + this.mInnerTop, this.mInnerBottom - this.mRegionBottom, i, i3, iOptInt2, i4, 1);
    }

    public void addEventListener(java.lang.String str, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str2) {
        this.mCanvasView.addEventListener(str, iWebview, str2);
    }

    public void addGifImagview(io.dcloud.feature.nativeObj.NativeView.Overlay overlay) {
        pl.droidsonroids.gif.GifDrawable gifDrawable = overlay.mNativeBitmap.getGifDrawable();
        if (gifDrawable != null) {
            pl.droidsonroids.gif.GifImageView gifImageView = new pl.droidsonroids.gif.GifImageView(this.mApp.getActivity());
            gifImageView.setImageDrawable(gifDrawable);
            gifImageView.setTag(overlay);
            int i = this.isStatusBar ? io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight / 2 : 0;
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(overlay.mDestRect.width(), overlay.mDestRect.height());
            android.graphics.Rect rect = overlay.mDestRect;
            int i2 = rect.left;
            if (i2 != Integer.MIN_VALUE) {
                layoutParams.leftMargin = i2;
            } else {
                int i3 = rect.right;
                layoutParams.width = i3;
                layoutParams.leftMargin = ((this.mInnerWidth - i3) + this.mInnerLeft) / 2;
            }
            int i4 = rect.top;
            if (i4 != Integer.MIN_VALUE) {
                layoutParams.topMargin = i4 + i;
            } else {
                int i5 = rect.bottom;
                layoutParams.height = i5;
                layoutParams.topMargin = ((this.mInnerHeight - i5) + this.mInnerTop) / 2;
            }
            addView(gifImageView, layoutParams);
            requestLayout();
            invalidate();
            io.dcloud.feature.nativeObj.NativeView.NativeCanvasView nativeCanvasView = this.mCanvasView;
            if (nativeCanvasView != null) {
                nativeCanvasView.requestLayout();
                this.mCanvasView.invalidate();
            }
        }
    }

    public void addInput(final io.dcloud.feature.nativeObj.NativeView.Overlay overlay, final java.lang.String str) {
        android.widget.EditText inputById = getInputById(str);
        if (inputById == null) {
            inputById = new android.widget.EditText(this.mApp.getActivity());
            inputById.setTag(str);
            inputById.setGravity(8388627);
            inputById.setSingleLine();
        }
        int i = 1;
        inputById.setImeOptions(1);
        if (!"text".equals(overlay.inputType)) {
            if ("email".equals(overlay.inputType)) {
                i = 33;
            } else if ("number".equals(overlay.inputType)) {
                i = 2;
            } else if ("search".equals(overlay.inputType)) {
                inputById.setImeOptions(3);
            } else if (com.taobao.weex.common.Constants.Value.TEL.equals(overlay.inputType)) {
                i = 3;
            } else if ("url".equals(overlay.inputType)) {
                inputById.setImeOptions(2);
                i = 17;
            }
        }
        inputById.setInputType(i);
        inputById.getPaint().setTextSize(overlay.mFontSize);
        inputById.setTextColor(overlay.mFontColor);
        inputById.setHint(overlay.placeholder);
        inputById.setHintTextColor(overlay.placeholderColor);
        int i2 = (int) overlay.borderWidth;
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setColor(overlay.inputBackgroundColor);
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(i2, overlay.borderColor);
        gradientDrawable.setCornerRadius(overlay.borderRadius);
        int i3 = overlay.borderRadius + i2;
        inputById.setPadding(i3, i2, i3, i2);
        inputById.setBackground(gradientDrawable);
        inputById.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() { // from class: io.dcloud.feature.nativeObj.NativeView.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(android.widget.TextView textView, int i4, android.view.KeyEvent keyEvent) {
                java.lang.String str2;
                io.dcloud.common.DHInterface.IFrameView iFrameView;
                if ((i4 == 4 || i4 == 6 || i4 == 3 || i4 == 2 || (keyEvent != null && 66 == keyEvent.getKeyCode() && keyEvent.getAction() == 0)) && !android.text.TextUtils.isEmpty(overlay.callBackId)) {
                    if (overlay.callBackId.toLowerCase(java.util.Locale.ENGLISH).startsWith(io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT)) {
                        java.lang.String strObtainAppId = io.dcloud.feature.nativeObj.NativeView.this.mApp.obtainAppId();
                        io.dcloud.common.DHInterface.IWebview iWebview = io.dcloud.feature.nativeObj.NativeView.this.mWebView;
                        io.dcloud.common.DHInterface.AbsMgr absMgrObtainWindowMgr = (iWebview == null || iWebview.obtainFrameView() == null) ? null : io.dcloud.feature.nativeObj.NativeView.this.mWebView.obtainFrameView().obtainWindowMgr();
                        if (absMgrObtainWindowMgr == null && (iFrameView = io.dcloud.feature.nativeObj.NativeView.this.mFrameViewParent) != null) {
                            absMgrObtainWindowMgr = iFrameView.obtainWindowMgr();
                        }
                        if (absMgrObtainWindowMgr != null) {
                            java.lang.Object objProcessEvent = absMgrObtainWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 47, strObtainAppId);
                            if (objProcessEvent instanceof io.dcloud.common.DHInterface.IFrameView) {
                                io.dcloud.common.DHInterface.IFrameView iFrameView2 = (io.dcloud.common.DHInterface.IFrameView) objProcessEvent;
                                if (iFrameView2.obtainWebView() != null && iFrameView2.obtainWebView().obtainWindowView() != null) {
                                    iFrameView2.obtainWebView().loadUrl(overlay.callBackId);
                                    return true;
                                }
                            }
                        }
                        io.dcloud.common.DHInterface.IWebview iWebview2 = overlay.webview;
                        if (iWebview2 != null && iWebview2.obtainWindowView() != null) {
                            io.dcloud.feature.nativeObj.NativeView.Overlay overlay2 = overlay;
                            overlay2.webview.loadUrl(overlay2.callBackId);
                            return true;
                        }
                        io.dcloud.common.DHInterface.IWebview iWebview3 = io.dcloud.feature.nativeObj.NativeView.this.mWebView;
                        if (iWebview3 != null && iWebview3.obtainWindowView() != null) {
                            io.dcloud.feature.nativeObj.NativeView.this.mWebView.loadUrl(overlay.callBackId);
                            return true;
                        }
                    }
                    if (overlay.webview != null) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder("{\"text\":\"");
                        sb.append((java.lang.Object) textView.getText());
                        sb.append("\",\"id\":");
                        if (android.text.TextUtils.isEmpty(str)) {
                            str2 = "\"\"";
                        } else {
                            str2 = io.dcloud.common.util.JSUtil.QUOTE + str + io.dcloud.common.util.JSUtil.QUOTE;
                        }
                        sb.append(str2);
                        sb.append(com.taobao.weex.el.parse.Operators.BLOCK_END_STR);
                        java.lang.String string = sb.toString();
                        io.dcloud.feature.nativeObj.NativeView.Overlay overlay3 = overlay;
                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(overlay3.webview, overlay3.callBackId, string, io.dcloud.common.util.JSUtil.OK, true, true);
                        if (overlay.webview.getOpener() != null) {
                            io.dcloud.common.util.Deprecated_JSUtil.execCallback(overlay.webview.getOpener(), overlay.callBackId, string, io.dcloud.common.util.JSUtil.OK, true, true);
                        }
                    }
                }
                return true;
            }
        });
        inputById.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: io.dcloud.feature.nativeObj.NativeView.7
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(android.view.View view, boolean z) {
                java.lang.String str2;
                io.dcloud.common.DHInterface.IFrameView iFrameView;
                java.lang.StringBuilder sb = new java.lang.StringBuilder("{\"id\":");
                if (android.text.TextUtils.isEmpty(str)) {
                    str2 = "\"\"";
                } else {
                    str2 = io.dcloud.common.util.JSUtil.QUOTE + str + io.dcloud.common.util.JSUtil.QUOTE;
                }
                sb.append(str2);
                sb.append(com.taobao.weex.el.parse.Operators.BLOCK_END_STR);
                java.lang.String string = sb.toString();
                java.lang.String str3 = z ? overlay.inputOnFocusCallBackId : overlay.inputOnBlurCallBackId;
                if (android.text.TextUtils.isEmpty(str3)) {
                    return;
                }
                if (str3.toLowerCase(java.util.Locale.ENGLISH).startsWith(io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT)) {
                    java.lang.String strObtainAppId = io.dcloud.feature.nativeObj.NativeView.this.mApp.obtainAppId();
                    io.dcloud.common.DHInterface.IWebview iWebview = io.dcloud.feature.nativeObj.NativeView.this.mWebView;
                    io.dcloud.common.DHInterface.AbsMgr absMgrObtainWindowMgr = (iWebview == null || iWebview.obtainFrameView() == null) ? null : io.dcloud.feature.nativeObj.NativeView.this.mWebView.obtainFrameView().obtainWindowMgr();
                    if (absMgrObtainWindowMgr == null && (iFrameView = io.dcloud.feature.nativeObj.NativeView.this.mFrameViewParent) != null) {
                        absMgrObtainWindowMgr = iFrameView.obtainWindowMgr();
                    }
                    if (absMgrObtainWindowMgr != null) {
                        java.lang.Object objProcessEvent = absMgrObtainWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 47, strObtainAppId);
                        if (objProcessEvent instanceof io.dcloud.common.DHInterface.IFrameView) {
                            io.dcloud.common.DHInterface.IFrameView iFrameView2 = (io.dcloud.common.DHInterface.IFrameView) objProcessEvent;
                            if (iFrameView2.obtainWebView() != null && iFrameView2.obtainWebView().obtainWindowView() != null) {
                                iFrameView2.obtainWebView().loadUrl(str3);
                                return;
                            }
                        }
                    }
                    io.dcloud.common.DHInterface.IWebview iWebview2 = overlay.webview;
                    if (iWebview2 != null && iWebview2.obtainWindowView() != null) {
                        overlay.webview.loadUrl(str3);
                        return;
                    }
                    io.dcloud.common.DHInterface.IWebview iWebview3 = io.dcloud.feature.nativeObj.NativeView.this.mWebView;
                    if (iWebview3 != null && iWebview3.obtainWindowView() != null) {
                        io.dcloud.feature.nativeObj.NativeView.this.mWebView.loadUrl(str3);
                        return;
                    }
                }
                io.dcloud.common.DHInterface.IWebview iWebview4 = overlay.webview;
                if (iWebview4 != null) {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview4, str3, string, io.dcloud.common.util.JSUtil.OK, true, true);
                    if (overlay.webview.getOpener() != null) {
                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(overlay.webview.getOpener(), str3, string, io.dcloud.common.util.JSUtil.OK, true, true);
                    }
                }
            }
        });
        int i4 = this.isStatusBar ? io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight : 0;
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(overlay.mDestRect.width(), overlay.mDestRect.height());
        android.graphics.Rect rect = overlay.mDestRect;
        int i5 = rect.left;
        if (i5 != Integer.MIN_VALUE) {
            layoutParams.leftMargin = i5;
        } else {
            int i6 = rect.right;
            layoutParams.width = i6;
            layoutParams.leftMargin = ((this.mInnerWidth - i6) + this.mInnerLeft) / 2;
        }
        int i7 = rect.top;
        if (i7 != Integer.MIN_VALUE) {
            layoutParams.topMargin = i7 + i4;
        } else {
            int i8 = rect.bottom;
            layoutParams.height = i8;
            layoutParams.topMargin = ((this.mInnerHeight - i8) + this.mInnerTop) / 2;
        }
        addView(inputById, layoutParams);
        requestLayout();
        invalidate();
        io.dcloud.feature.nativeObj.NativeView.NativeCanvasView nativeCanvasView = this.mCanvasView;
        if (nativeCanvasView != null) {
            nativeCanvasView.requestLayout();
            this.mCanvasView.invalidate();
        }
    }

    protected void attachCanvasView() {
        if (this.mCanvasView.getParent() != null) {
            ((android.view.ViewGroup) this.mCanvasView.getParent()).removeView(this.mCanvasView);
        }
        addView(this.mCanvasView, new android.widget.FrameLayout.LayoutParams(-1, -2));
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public void attachToViewGroup(io.dcloud.common.DHInterface.IFrameView iFrameView) {
        if (this.mAttached) {
            return;
        }
        this.mFrameViewParent = iFrameView;
        if (iFrameView instanceof io.dcloud.common.adapter.ui.AdaFrameView) {
            ((io.dcloud.common.adapter.ui.AdaFrameView) iFrameView).addNativeViewChild(this);
        }
        final java.lang.String strObtainAppId = iFrameView.obtainApp().obtainAppId();
        io.dcloud.common.DHInterface.IEventCallback iEventCallback = new io.dcloud.common.DHInterface.IEventCallback() { // from class: io.dcloud.feature.nativeObj.NativeView.2
            @Override // io.dcloud.common.DHInterface.IEventCallback
            public java.lang.Object onCallBack(java.lang.String str, java.lang.Object obj) {
                if (android.text.TextUtils.equals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE)) {
                    io.dcloud.feature.nativeObj.FeatureImpl.destroyNativeView(strObtainAppId, io.dcloud.feature.nativeObj.NativeView.this);
                    io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.ad.AdFlowFeatureImpl", "destroyNativeView", null, new java.lang.Class[]{java.lang.String.class, io.dcloud.feature.nativeObj.NativeView.class}, new java.lang.Object[]{strObtainAppId, io.dcloud.feature.nativeObj.NativeView.this});
                } else {
                    android.text.TextUtils.equals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_FRAME_ONRESIZE);
                }
                return null;
            }
        };
        this.mIEventCallback = iEventCallback;
        iFrameView.addFrameViewListener(iEventCallback);
        android.view.ViewParent parent = getParent();
        if (parent != null) {
            ((android.view.ViewGroup) parent).removeView(this);
            setVisibility(0);
        }
        measureFitViewParent(true);
        this.mShow = true;
        this.mAttached = true;
    }

    public void clearAnimate() {
        this.isAnimate = false;
        this.mRegionRect = null;
        this.mRegionJson = null;
        invalidate();
        io.dcloud.feature.nativeObj.NativeView.NativeCanvasView nativeCanvasView = this.mCanvasView;
        if (nativeCanvasView != null) {
            nativeCanvasView.requestLayout();
            this.mCanvasView.invalidate();
        }
    }

    public void clearNativeViewData() {
        io.dcloud.common.DHInterface.IFrameView iFrameView = this.mFrameViewParent;
        if (iFrameView != null && (iFrameView instanceof io.dcloud.common.adapter.ui.AdaFrameView)) {
            ((io.dcloud.common.adapter.ui.AdaFrameView) iFrameView).removeNativeViewChild(this);
        }
        postDelayed(new java.lang.Runnable() { // from class: io.dcloud.feature.nativeObj.NativeView.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    io.dcloud.feature.nativeObj.NativeView.this.setVisibility(8);
                    if (io.dcloud.feature.nativeObj.NativeView.this.getParent() != null) {
                        ((android.view.ViewGroup) io.dcloud.feature.nativeObj.NativeView.this.getParent()).removeView(io.dcloud.feature.nativeObj.NativeView.this);
                    }
                    io.dcloud.feature.nativeObj.NativeView.this.clearViewData();
                    io.dcloud.feature.nativeObj.NativeView.this.mFrameViewParent = null;
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }, 200);
    }

    public void clearViewData() {
        io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap;
        java.util.ArrayList<io.dcloud.feature.nativeObj.NativeView.Overlay> arrayList = this.mOverlays;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            io.dcloud.feature.nativeObj.NativeView.Overlay overlay = arrayList.get(i);
            i++;
            io.dcloud.feature.nativeObj.NativeView.Overlay overlay2 = overlay;
            if (overlay2.type.equals(com.taobao.weex.ui.component.WXBasicComponentType.IMG) && (nativeBitmap = overlay2.mNativeBitmap) != null && nativeBitmap.getBitmap() != null && !overlay2.mNativeBitmap.isRecycled()) {
                overlay2.mNativeBitmap.recycle(true);
            }
        }
        this.mOverlays.clear();
        this.mOverlayMaps.clear();
        this.mChildViewMaps.clear();
    }

    protected void configurationCange() {
    }

    android.graphics.RectF createTouchRect(org.json.JSONObject jSONObject) {
        android.graphics.RectF rectF = new android.graphics.RectF(makeRect(this, jSONObject, null));
        float f = rectF.left;
        if (f != -2.1474836E9f && rectF.top != -2.1474836E9f) {
            return rectF;
        }
        float f2 = rectF.top;
        float f3 = rectF.right;
        float f4 = rectF.bottom;
        if (f == -2.1474836E9f) {
            float f5 = this.mInnerWidth;
            float f6 = this.mInnerLeft;
            f = ((f5 - (f3 - f6)) / 2.0f) + f6;
            f3 += f;
        }
        if (f2 == -2.1474836E9f) {
            float f7 = this.mInnerHeight;
            float f8 = this.mInnerTop;
            f2 = ((f7 - (f4 - f8)) / 2.0f) + f8;
            f4 += f2;
        }
        return new android.graphics.RectF(f, f2, f3, f4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        android.graphics.RectF rectF = this.mRegionRect;
        if (rectF != null) {
            canvas.clipRect(rectF, android.graphics.Region.Op.DIFFERENCE);
        }
        java.util.ArrayList<io.dcloud.feature.nativeObj.NativeView.Overlay> arrayList = this.mOverlays;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            io.dcloud.feature.nativeObj.NativeView.Overlay overlay = arrayList.get(i);
            i++;
            io.dcloud.feature.nativeObj.NativeView.Overlay overlay2 = overlay;
            if (overlay2.type.equals("clear")) {
                canvas.clipRect(overlay2.mDestRect, android.graphics.Region.Op.DIFFERENCE);
            }
        }
        super.dispatchDraw(canvas);
    }

    public java.lang.Object doForFeature(java.lang.String str, java.lang.Object obj) {
        if (str.equals("clearAnimate")) {
            clearAnimate();
            return null;
        }
        if (!str.equals("checkTouch")) {
            return null;
        }
        android.view.MotionEvent motionEvent = (android.view.MotionEvent) obj;
        return checkTouchRectsContains(motionEvent.getX(), motionEvent.getY()) ? java.lang.Boolean.valueOf(this.mIntercept) : java.lang.Boolean.FALSE;
    }

    java.lang.String getEventJSON() {
        return java.lang.String.format(java.util.Locale.ENGLISH, T, java.lang.Integer.valueOf((int) ((this.mTouchX - this.mInnerLeft) / this.mCreateScale)), java.lang.Integer.valueOf((int) ((this.mTouchY - this.mInnerTop) / this.mCreateScale)), java.lang.Integer.valueOf((int) (this.mTouchX / this.mCreateScale)), java.lang.Integer.valueOf((int) (this.mTouchY / this.mCreateScale)), java.lang.Integer.valueOf((int) (this.mTouchX / this.mCreateScale)), java.lang.Integer.valueOf((int) (this.mTouchY / this.mCreateScale)));
    }

    public int getInnerBottom() {
        return this.mInnerBottom;
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public int getInnerHeight() {
        return this.mInnerHeight;
    }

    public boolean getInputFocusById(java.lang.String str) {
        android.widget.EditText inputById = getInputById(str);
        if (inputById != null) {
            return inputById.hasFocus();
        }
        return false;
    }

    public java.lang.String getInputValueById(java.lang.String str) {
        android.widget.EditText inputById;
        if (android.text.TextUtils.isEmpty(str) || (inputById = getInputById(str)) == null || inputById.getText() == null) {
            return null;
        }
        return inputById.getText().toString();
    }

    protected int getNViewContentHeight() {
        java.util.ArrayList<io.dcloud.feature.nativeObj.NativeView.Overlay> arrayList = this.mOverlays;
        if (arrayList == null) {
            return this.mAppScreenHeight;
        }
        this.mInnerHeight = this.mAppScreenHeight;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            io.dcloud.feature.nativeObj.NativeView.Overlay overlay = arrayList.get(i);
            i++;
            io.dcloud.feature.nativeObj.NativeView.Overlay overlay2 = overlay;
            int i3 = makeRect(this, overlay2.mDestJson, overlay2).bottom;
            if (i3 > i2) {
                i2 = i3;
            }
        }
        return i2;
    }

    public int getRectHeightForBitmap(io.dcloud.feature.nativeObj.NativeView nativeView, org.json.JSONObject jSONObject, android.graphics.Rect rect, io.dcloud.feature.nativeObj.NativeView.Overlay overlay, int i) {
        if (overlay == null) {
            java.lang.String strOptString = jSONObject.optString("height");
            int i2 = nativeView.mInnerHeight;
            return io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString, i2, i2, nativeView.mCreateScale);
        }
        overlay.textAdapt = false;
        if (jSONObject.has("height") && "auto".equals(jSONObject.optString("height")) && rect != null) {
            if (jSONObject.has("width") && "auto".equals(jSONObject.optString("width"))) {
                return rect.height();
            }
            if (jSONObject.has("width")) {
                java.lang.String strOptString2 = jSONObject.optString("width");
                int i3 = nativeView.mInnerWidth;
                return (int) (rect.height() * (io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString2, i3, i3, nativeView.mCreateScale) / rect.width()));
            }
        } else if (jSONObject.has("height") && "wrap_content".equals(jSONObject.optString("height")) && io.dcloud.common.util.PdrUtil.isEquals(overlay.type, io.dcloud.feature.uniapp.adapter.AbsURIAdapter.FONT)) {
            overlay.textAdapt = true;
            if (!io.dcloud.common.util.PdrUtil.isEquals(overlay.textWhiteSpace, "normal")) {
                return (int) (overlay.mFontSize + (overlay.margin * 2));
            }
            this.mPaint.reset();
            this.mPaint.setTextSize(overlay.mFontSize);
            return new android.text.StaticLayout(overlay.mText, new android.text.TextPaint(this.mPaint), i - (overlay.margin * 2), android.text.Layout.Alignment.ALIGN_NORMAL, overlay.textLineSpacing + 0.9f, 0.0f, false).getHeight() + (overlay.margin * 2);
        }
        java.lang.String strOptString3 = jSONObject.optString("height");
        int i4 = nativeView.mInnerHeight;
        return io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString3, i4, i4, nativeView.mCreateScale);
    }

    public int getRectWidthForBitmap(io.dcloud.feature.nativeObj.NativeView nativeView, org.json.JSONObject jSONObject, android.graphics.Rect rect) {
        if (jSONObject.has("width") && "auto".equals(jSONObject.optString("width")) && rect != null) {
            if (jSONObject.has("height") && "auto".equals(jSONObject.optString("height"))) {
                return rect.width();
            }
            if (jSONObject.has("height")) {
                java.lang.String strOptString = jSONObject.optString("height");
                int i = nativeView.mInnerHeight;
                return (int) (rect.width() * (io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString, i, i, nativeView.mCreateScale) / rect.height()));
            }
        }
        java.lang.String strOptString2 = jSONObject.optString("width");
        int i2 = nativeView.mInnerWidth;
        return io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString2, i2, i2, nativeView.mCreateScale);
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public java.lang.String getStyleBackgroundColor() {
        org.json.JSONObject jSONObject = this.mStyle;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.has("backgroudColor")) {
            return this.mStyle.optString("backgroudColor");
        }
        if (this.mStyle.has("backgroundColor")) {
            return this.mStyle.optString("backgroundColor");
        }
        return null;
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public int getStyleLeft() {
        return io.dcloud.common.util.PdrUtil.convertToScreenInt(this.mStyle.optString("left"), this.mAppScreenWidth, 0, this.mCreateScale);
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public int getStyleWidth() {
        return this.mInnerWidth;
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public java.lang.String getViewId() {
        return this.mID;
    }

    public java.lang.String getViewType() {
        return io.dcloud.common.constant.AbsoluteConst.NATIVE_NVIEW;
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public java.lang.String getViewUUId() {
        return this.mUUID;
    }

    protected void init() {
        java.lang.String strOptString;
        int i;
        java.lang.String str;
        org.json.JSONObject jSONObject = this.mStyle;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("backgroudColor")) {
                    strOptString = this.mStyle.optString("backgroudColor");
                } else {
                    strOptString = this.mStyle.has("backgroundColor") ? this.mStyle.optString("backgroundColor") : null;
                }
                if (!android.text.TextUtils.isEmpty(strOptString)) {
                    try {
                        this.mBackGroundColor = android.graphics.Color.parseColor(strOptString);
                    } catch (java.lang.Exception unused) {
                        this.mBackGroundColor = io.dcloud.common.util.PdrUtil.stringToColor(strOptString);
                    }
                } else if (android.text.TextUtils.equals(io.dcloud.common.constant.AbsoluteConst.NATIVE_IMAGESLIDER, getViewType())) {
                    this.mBackGroundColor = -1118482;
                }
                java.lang.String strOptString2 = this.mStyle.has(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE) ? this.mStyle.optString(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE) : null;
                if (strOptString2 != null && ((str = this.mBackgroundImageSrc) == null || !str.equalsIgnoreCase(strOptString2))) {
                    this.mBackgroundImageSrc = strOptString2;
                }
                if (this.mStyle.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR) && io.dcloud.common.util.BaseInfo.isImmersive) {
                    this.isStatusBar = true;
                    org.json.JSONObject jSONObjectOptJSONObject = this.mStyle.optJSONObject(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR);
                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("background")) {
                        java.lang.String strOptString3 = jSONObjectOptJSONObject.optString("background");
                        if (io.dcloud.common.util.PdrUtil.checkStatusbarColor(io.dcloud.common.util.PdrUtil.stringToColor(strOptString3))) {
                            this.mStatusColor = io.dcloud.common.util.PdrUtil.stringToColor(strOptString3);
                        }
                    }
                    if (io.dcloud.common.constant.AbsoluteConst.NATIVE_TITLE_N_VIEW.equals(getViewType()) && (i = this.mBackGroundColor) != 0 && this.mStatusColor != i && io.dcloud.common.util.PdrUtil.checkStatusbarColor(i)) {
                        this.mStatusColor = this.mBackGroundColor;
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        initStatusBarView(io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight);
        this.mInnerLeft = io.dcloud.common.util.PdrUtil.convertToScreenInt(this.mStyle.optString("left"), this.mAppScreenWidth, 0, this.mCreateScale);
        int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(this.mStyle.optString("top"), this.mAppScreenHeight, 0, this.mCreateScale);
        this.mMarginTop = iConvertToScreenInt;
        this.mInnerTop = iConvertToScreenInt;
        java.lang.String strOptString4 = this.mStyle.optString("width");
        int i2 = this.mAppScreenWidth;
        this.mInnerRight = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString4, i2, i2, this.mCreateScale) + this.mInnerLeft;
        java.lang.String strOptString5 = this.mStyle.optString("height");
        if (android.text.TextUtils.isEmpty(strOptString5) || !strOptString5.equals("wrap_content")) {
            this.isLayoutAdapt = false;
        } else {
            this.isLayoutAdapt = true;
        }
        if (!this.mStyle.has("bottom") || this.isLayoutAdapt) {
            if (this.isLayoutAdapt) {
                this.mInnerHeight = getNViewContentHeight();
            } else {
                int i3 = this.mAppScreenHeight;
                this.mInnerHeight = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString5, i3, i3, this.mCreateScale);
            }
            int i4 = this.mInnerHeight;
            if (i4 >= this.mAppScreenHeight || this.isLayoutAdapt) {
                this.mInnerBottom = i4;
            } else {
                this.mInnerBottom = i4 + this.mInnerTop;
            }
        } else {
            java.lang.String strOptString6 = this.mStyle.optString("bottom");
            int i5 = this.mAppScreenHeight;
            int iConvertToScreenInt2 = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString6, i5, i5, this.mCreateScale);
            this.mMarginBottom = iConvertToScreenInt2;
            this.mInnerBottom = this.mAppScreenHeight - iConvertToScreenInt2;
            if (this.mStyle.has("height") && !this.mStyle.has("top")) {
                int i6 = this.mAppScreenHeight;
                int iConvertToScreenInt3 = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString5, i6, i6, this.mCreateScale);
                this.mInnerHeight = iConvertToScreenInt3;
                int i7 = this.mInnerBottom - iConvertToScreenInt3;
                this.mInnerTop = i7;
                if (i7 < 0) {
                    this.mInnerTop = 0;
                }
            } else if (this.mStyle.has("height")) {
                int i8 = this.mAppScreenHeight;
                this.mInnerHeight = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString5, i8, i8, this.mCreateScale);
            } else {
                this.mInnerHeight = this.mInnerBottom - this.mInnerTop;
            }
        }
        this.mInnerWidth = this.mInnerRight - this.mInnerLeft;
        initJsonTouchRect();
    }

    void initJsonTouchRect() {
        this.mTouchRects.clear();
        org.json.JSONObject jSONObject = null;
        org.json.JSONArray jSONArray = null;
        if (android.text.TextUtils.isEmpty(this.mTouchRectJson) || !this.mTouchRectJson.startsWith(com.taobao.weex.el.parse.Operators.ARRAY_START_STR)) {
            try {
                jSONObject = new org.json.JSONObject(this.mTouchRectJson);
            } catch (java.lang.Exception unused) {
            }
            this.mTouchRects.add(createTouchRect(jSONObject));
            return;
        }
        try {
            jSONArray = new org.json.JSONArray(this.mTouchRectJson);
        } catch (java.lang.Exception unused2) {
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    this.mTouchRects.add(createTouchRect(jSONObjectOptJSONObject));
                }
            } catch (java.lang.Exception unused3) {
            }
        }
    }

    void initStatusBarView(int i) {
        if (-1 == indexOfChild(this.mCanvasView)) {
            attachCanvasView();
        }
        if (this.isStatusBar) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                android.view.View childAt = getChildAt(i2);
                if (childAt.getTag() != null && childAt.getTag().equals("StatusBar")) {
                    childAt.setBackgroundColor(this.mStatusColor);
                    return;
                }
            }
            android.view.View view = new android.view.View(getContext());
            this.mStatusbarView = view;
            view.setTag("StatusBar");
            this.mStatusbarView.setBackgroundColor(this.mStatusColor);
            this.mStatusbarView.setVisibility(0);
            this.mStatusbarView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, i));
            addView(this.mStatusbarView);
            this.mStatusbarView.bringToFront();
            measureFitViewParent(false);
        }
    }

    void interceptTouchEvent(boolean z) {
        this.mIntercept = z;
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public boolean isAnimate() {
        return this.mRegionRect != null;
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public boolean isDock() {
        return android.text.TextUtils.equals(this.mStyle.optString("position", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE), "dock");
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public boolean isDockTop() {
        return android.text.TextUtils.equals(this.mStyle.optString("position", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE), "dock") && android.text.TextUtils.equals(this.mStyle.optString("dock"), "top");
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public boolean isStatusBar() {
        return this.isStatusBar;
    }

    io.dcloud.feature.nativeObj.NativeView.Overlay makeOverlay(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap, java.lang.String str, int i, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, org.json.JSONObject jSONObject3, java.lang.String str2, java.lang.String str3, boolean z) {
        return makeOverlay(iWebview, nativeBitmap, str, i, jSONObject, jSONObject2, jSONObject3, str2, str3, true, z);
    }

    android.graphics.Rect makeRect(io.dcloud.feature.nativeObj.NativeView nativeView, org.json.JSONObject jSONObject, io.dcloud.feature.nativeObj.NativeView.Overlay overlay) {
        android.graphics.Rect rect = new android.graphics.Rect();
        android.graphics.Rect rect2 = overlay != null ? overlay.mSrcRect : null;
        if (jSONObject == null) {
            rect.left = nativeView.mInnerLeft;
            rect.top = nativeView.mInnerTop;
            rect.right = nativeView.mInnerRight;
            rect.bottom = nativeView.mInnerBottom;
            return rect;
        }
        if (jSONObject.has("right") && (!jSONObject.has("left") || !jSONObject.has("width"))) {
            rect.right = nativeView.mInnerWidth - io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("right"), nativeView.mInnerWidth, 0, nativeView.mCreateScale);
            if (jSONObject.has("width")) {
                rect.left = rect.right - getRectWidthForBitmap(nativeView, jSONObject, rect2);
            } else if (!jSONObject.has("left") || "auto".equals(jSONObject.optString("left"))) {
                rect.left = nativeView.getDrawLeft(0);
            } else {
                rect.left = nativeView.getDrawLeft(io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("left"), nativeView.mInnerWidth, 0, nativeView.mCreateScale));
            }
        } else if ("auto".equals(jSONObject.optString("left"))) {
            rect.left = Integer.MIN_VALUE;
            rect.right = getRectWidthForBitmap(nativeView, jSONObject, rect2);
        } else {
            rect.left = nativeView.getDrawLeft(io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("left"), nativeView.mInnerWidth, 0, nativeView.mCreateScale));
            rect.right = getRectWidthForBitmap(nativeView, jSONObject, rect2) + rect.left;
        }
        if (!jSONObject.has("bottom") || (jSONObject.has("top") && jSONObject.has("height"))) {
            if ("auto".equals(jSONObject.optString("top"))) {
                rect.top = Integer.MIN_VALUE;
                rect.bottom = getRectHeightForBitmap(nativeView, jSONObject, rect2, overlay, rect.width());
                return rect;
            }
            rect.top = nativeView.getDrawTop(io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("top"), nativeView.mInnerHeight, 0, nativeView.mCreateScale));
            rect.bottom = getRectHeightForBitmap(nativeView, jSONObject, rect2, overlay, rect.width()) + rect.top;
            return rect;
        }
        rect.bottom = nativeView.mInnerBottom - io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("bottom"), nativeView.mInnerWidth, 0, nativeView.mCreateScale);
        if (jSONObject.has("height")) {
            rect.top = rect.bottom - getRectHeightForBitmap(nativeView, jSONObject, rect2, overlay, rect.width());
            return rect;
        }
        if (!jSONObject.has("top") || "auto".equals(jSONObject.optString("top"))) {
            rect.top = nativeView.getDrawTop(0);
            return rect;
        }
        rect.top = nativeView.getDrawTop(io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("top"), nativeView.mInnerHeight, 0, nativeView.mCreateScale));
        return rect;
    }

    public void makeRichText(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, java.lang.String str2) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str2)) {
            str2 = "richtext_" + java.lang.System.currentTimeMillis();
        }
        java.lang.String str3 = str2;
        io.dcloud.feature.nativeObj.INativeViewChildView iNativeViewChildView = this.mChildViewMaps.get(str3);
        if (iNativeViewChildView != null) {
            io.dcloud.feature.nativeObj.richtext.RichTextLayout.makeRichText((io.dcloud.feature.nativeObj.richtext.RichTextLayout.RichTextLayoutHolder) iNativeViewChildView, str, jSONObject, jSONObject2);
            return;
        }
        io.dcloud.feature.nativeObj.richtext.RichTextLayout.RichTextLayoutHolder richTextLayoutHolderMakeRichText = io.dcloud.feature.nativeObj.richtext.RichTextLayout.makeRichText(getContext(), iWebview, this, str, jSONObject, jSONObject2, str3);
        addView(richTextLayoutHolderMakeRichText);
        this.mChildViewMaps.put(str3, richTextLayoutHolderMakeRichText);
    }

    public void makeWeexView(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONObject jSONObject, java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            str = "weexview_" + java.lang.System.currentTimeMillis();
        }
        if (this.mChildViewMaps.get(str) == null) {
            java.lang.Object obj = (io.dcloud.feature.nativeObj.INativeViewChildView) iWebview.obtainFrameView().obtainWindowMgr().processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebview.obtainApp(), "weex,io.dcloud.feature.weex.WeexFeature", "createWeexWindow", new java.lang.Object[]{iWebview, this, jSONObject, str}});
            addView((android.view.View) obj);
            this.mChildViewMaps.put(str, (io.dcloud.feature.nativeObj.INativeViewChildView) obj);
        }
    }

    protected void measureChildViewToTop(int i) {
        measureGifImageview(i);
    }

    protected void measureFitViewParent(boolean z) {
        android.view.View viewObtainMainView;
        android.view.ViewGroup viewGroup;
        int i;
        if (this.mFrameViewParent == null) {
            return;
        }
        java.lang.String strOptString = this.mStyle.optString("position", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE);
        if (android.text.TextUtils.equals(strOptString, "dock")) {
            android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) ((io.dcloud.common.adapter.ui.AdaFrameItem) this.mFrameViewParent).obtainMainView();
            android.view.ViewGroup viewGroup3 = (android.view.ViewGroup) this.mFrameViewParent.obtainWebviewParent().obtainMainView();
            android.view.ViewGroup.LayoutParams layoutParams = viewGroup3.getLayoutParams();
            io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = ((io.dcloud.common.adapter.ui.AdaFrameItem) this.mFrameViewParent).obtainFrameOptions();
            int left = z ? viewOptionsObtainFrameOptions.left : viewGroup3.getLeft();
            if (getTag() != null && "titleNView".equals(getTag().toString())) {
                left = 0;
            }
            int y = z ? viewOptionsObtainFrameOptions.top : (int) io.dcloud.nineoldandroids.view.ViewHelper.getY(viewGroup3);
            int i2 = viewOptionsObtainFrameOptions.width;
            int i3 = this.mApp.getInt(1);
            int i4 = this.mAppScreenHeight;
            if (i3 >= i4) {
                i4 = this.mApp.getInt(1);
            }
            int i5 = i4 - viewOptionsObtainFrameOptions.bottom;
            java.lang.String strOptString2 = this.mStyle.optString("dock", "top");
            android.view.ViewGroup viewGroup4 = (android.view.ViewGroup) this.mFrameViewParent.obtainMainView();
            if (android.text.TextUtils.equals(strOptString2, "left")) {
                left = this.mInnerWidth;
                this.mInnerRight = left;
                this.mInnerLeft = 0;
                i2 -= left;
                viewGroup = viewGroup3;
            } else if (android.text.TextUtils.equals(strOptString2, "top")) {
                this.mInnerBottom = this.mInnerHeight;
                this.mInnerTop = 0;
                int iIndexOfChild = viewGroup4.indexOfChild(this);
                int i6 = 0;
                int height = 0;
                int innerBottom = 0;
                int innerHeight = 0;
                while (i6 < viewGroup4.getChildCount()) {
                    android.view.View childAt = viewGroup4.getChildAt(i6);
                    android.view.ViewGroup viewGroup5 = viewGroup3;
                    if (childAt instanceof com.dcloud.android.widget.StatusBarView) {
                        i = iIndexOfChild;
                    } else {
                        if (childAt != null && (childAt instanceof io.dcloud.feature.nativeObj.NativeView) && childAt != this) {
                            boolean z2 = childAt instanceof io.dcloud.feature.nativeObj.TitleNView;
                            io.dcloud.feature.nativeObj.NativeView nativeView = (io.dcloud.feature.nativeObj.NativeView) childAt;
                            if (nativeView.isDock()) {
                                if (z2) {
                                    innerHeight += nativeView.getInnerHeight();
                                }
                                if (nativeView.isDockTop()) {
                                    innerBottom += nativeView.getInnerBottom();
                                    if (!z2 && (i6 < iIndexOfChild || iIndexOfChild == -1)) {
                                        innerHeight += nativeView.getInnerHeight();
                                    }
                                }
                                height += nativeView.getInnerHeight();
                            }
                        } else if (childAt instanceof com.dcloud.android.widget.AbsoluteLayout) {
                            com.dcloud.android.widget.AbsoluteLayout absoluteLayout = (com.dcloud.android.widget.AbsoluteLayout) childAt;
                            if (absoluteLayout.getFrameView() != null) {
                                i = iIndexOfChild;
                                if (absoluteLayout.getFrameView().mPosition == io.dcloud.common.adapter.util.ViewRect.DOCK_BOTTOM) {
                                    height += childAt.getHeight();
                                }
                            }
                        }
                        i = iIndexOfChild;
                    }
                    i6++;
                    viewGroup3 = viewGroup5;
                    iIndexOfChild = i;
                }
                viewGroup = viewGroup3;
                int i7 = this.mInnerHeight;
                int i8 = innerBottom + i7;
                int i9 = height + i7;
                if (viewOptionsObtainFrameOptions.isStatusbar || (this.isImmersed && io.dcloud.common.util.TitleNViewUtil.isTitleTypeForDef(viewOptionsObtainFrameOptions.titleNView))) {
                    int i10 = io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                    int i11 = i9 + i10;
                    innerHeight += i10;
                    y = i8 + i10;
                    i8 = i11;
                } else {
                    if (this.isStatusBar) {
                        i8 += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                    }
                    y = i8;
                }
                int i12 = innerHeight;
                ((android.widget.FrameLayout.LayoutParams) this.mCanvasView.getLayoutParams()).topMargin = i12;
                measureChildViewToTop(i12);
                i5 -= i8;
            } else {
                viewGroup = viewGroup3;
                if (android.text.TextUtils.equals(strOptString2, "right")) {
                    int right = viewGroup2.getRight();
                    this.mInnerRight = right;
                    int i13 = this.mInnerWidth;
                    this.mInnerLeft = right - i13;
                    i2 -= i13;
                } else {
                    int i14 = this.mAppScreenHeight;
                    this.mInnerBottom = i14;
                    if (i14 == 0) {
                        this.mInnerBottom = viewOptionsObtainFrameOptions.top + viewOptionsObtainFrameOptions.height;
                    }
                    int innerHeight2 = 0;
                    int innerBottom2 = 0;
                    for (int i15 = 0; i15 < viewGroup4.getChildCount(); i15++) {
                        android.view.View childAt2 = viewGroup4.getChildAt(i15);
                        if (childAt2 != null && (childAt2 instanceof io.dcloud.feature.nativeObj.NativeView) && childAt2 != this && (childAt2.getTag() == null || !childAt2.getTag().equals("StatusBar"))) {
                            io.dcloud.feature.nativeObj.NativeView nativeView2 = (io.dcloud.feature.nativeObj.NativeView) childAt2;
                            if (nativeView2.isDock()) {
                                if ((childAt2 instanceof io.dcloud.feature.nativeObj.TitleNView) && io.dcloud.common.util.TitleNViewUtil.isTitleTypeForDef(nativeView2.mStyle)) {
                                    innerHeight2 = nativeView2.getInnerHeight();
                                }
                                if (nativeView2.isDockTop()) {
                                    innerBottom2 += nativeView2.getInnerBottom();
                                }
                            }
                        }
                    }
                    this.mInnerTop = this.mInnerBottom - this.mInnerHeight;
                    android.widget.FrameLayout.LayoutParams layoutParams2 = (android.widget.FrameLayout.LayoutParams) this.mCanvasView.getLayoutParams();
                    if (this.isImmersed && (viewOptionsObtainFrameOptions.isStatusbar || io.dcloud.common.util.TitleNViewUtil.isTitleTypeForDef(viewOptionsObtainFrameOptions.titleNView))) {
                        innerHeight2 += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                    }
                    layoutParams2.topMargin = innerHeight2;
                    measureChildViewToTop(innerHeight2);
                    if (viewOptionsObtainFrameOptions.isStatusbar || this.isStatusBar) {
                        int i16 = io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                        innerBottom2 += i16;
                    }
                    y = innerBottom2;
                    i5 -= this.mInnerHeight + y;
                }
            }
            int i17 = i2;
            int i18 = i5;
            if (z) {
                viewGroup2.addView(this);
                if (viewOptionsObtainFrameOptions.titleNView != null) {
                    for (int i19 = 0; i19 < viewGroup2.getChildCount(); i19++) {
                        android.view.View childAt3 = viewGroup2.getChildAt(i19);
                        if (childAt3 instanceof io.dcloud.feature.nativeObj.TitleNView) {
                            childAt3.bringToFront();
                            break;
                        }
                    }
                }
            }
            viewPostResize(viewGroup, layoutParams, i17, i18, left, y);
        } else if (android.text.TextUtils.equals(strOptString, "static")) {
            if (z) {
                this.mFrameViewParent.obtainWebView().obtainWindowView().addView(this);
            }
        } else if (android.text.TextUtils.equals(strOptString, io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE)) {
            io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions2 = ((io.dcloud.common.adapter.ui.AdaFrameItem) this.mFrameViewParent).obtainFrameOptions();
            android.view.ViewGroup viewGroup6 = (android.view.ViewGroup) ((io.dcloud.common.adapter.ui.AdaFrameItem) this.mFrameViewParent).obtainMainView();
            int innerHeight3 = 0;
            for (int i20 = 0; i20 < viewGroup6.getChildCount(); i20++) {
                android.view.View childAt4 = viewGroup6.getChildAt(i20);
                if (childAt4 instanceof io.dcloud.feature.nativeObj.NativeView) {
                    io.dcloud.feature.nativeObj.NativeView nativeView3 = (io.dcloud.feature.nativeObj.NativeView) childAt4;
                    if (nativeView3.isDockTop() && nativeView3 != this) {
                        innerHeight3 += nativeView3.getInnerHeight();
                    }
                }
            }
            if (this.isImmersed && (viewOptionsObtainFrameOptions2.isStatusbar || io.dcloud.common.util.TitleNViewUtil.isTitleTypeForDef(viewOptionsObtainFrameOptions2.titleNView))) {
                innerHeight3 += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
            }
            if (this.isImmersed && !viewOptionsObtainFrameOptions2.isStatusbar && (this instanceof io.dcloud.feature.nativeObj.TitleNView)) {
                innerHeight3 += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
            }
            for (int i21 = 0; i21 < getChildCount(); i21++) {
                android.view.KeyEvent.Callback childAt5 = getChildAt(i21);
                io.dcloud.feature.nativeObj.NativeView.NativeCanvasView nativeCanvasView = this.mCanvasView;
                if (childAt5 == nativeCanvasView) {
                    ((android.widget.FrameLayout.LayoutParams) nativeCanvasView.getLayoutParams()).topMargin = innerHeight3;
                    measureChildViewToTop(innerHeight3);
                } else if ((childAt5 instanceof io.dcloud.feature.nativeObj.INativeViewChildView) && (viewObtainMainView = ((io.dcloud.feature.nativeObj.INativeViewChildView) childAt5).obtainMainView()) != null) {
                    android.view.ViewGroup.LayoutParams layoutParams3 = viewObtainMainView.getLayoutParams();
                    if (layoutParams3 instanceof android.view.ViewGroup.MarginLayoutParams) {
                        ((android.view.ViewGroup.MarginLayoutParams) layoutParams3).topMargin = innerHeight3;
                    }
                }
            }
            if (z) {
                viewGroup6.addView(this);
            }
        }
        if (this.mInnerHeight > this.mAppScreenHeight) {
            getLayoutParams().height = this.mInnerHeight;
        } else if (android.text.TextUtils.equals(strOptString, "static")) {
            getLayoutParams().height = this.mAppScreenHeight;
        } else {
            getLayoutParams().height = -1;
        }
        initJsonTouchRect();
        java.util.Collection<io.dcloud.feature.nativeObj.INativeViewChildView> collectionValues = this.mChildViewMaps.values();
        if (collectionValues != null) {
            java.util.Iterator<io.dcloud.feature.nativeObj.INativeViewChildView> it = collectionValues.iterator();
            while (it.hasNext()) {
                it.next().updateLayout();
            }
        }
    }

    public void nativeInvalidate(boolean z) {
        if (this.mShow) {
            if (z) {
                requestLayout();
            }
            postInvalidate();
            io.dcloud.feature.nativeObj.NativeView.NativeCanvasView nativeCanvasView = this.mCanvasView;
            if (nativeCanvasView != null) {
                if (z) {
                    nativeCanvasView.requestLayout();
                }
                this.mCanvasView.invalidate();
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public android.view.View obtanMainView() {
        return this;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.isAnimate) {
            this.isAnimate = false;
        }
        postDelayed(new java.lang.Runnable() { // from class: io.dcloud.feature.nativeObj.NativeView.1
            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.feature.nativeObj.NativeView nativeView = io.dcloud.feature.nativeObj.NativeView.this;
                nativeView.mAppScreenWidth = nativeView.mApp.getInt(0);
                io.dcloud.feature.nativeObj.NativeView nativeView2 = io.dcloud.feature.nativeObj.NativeView.this;
                nativeView2.mAppScreenHeight = nativeView2.mApp.getInt(1);
                io.dcloud.common.DHInterface.IWebview iWebview = io.dcloud.feature.nativeObj.NativeView.this.mWebView;
                if (iWebview != null && iWebview.obtainFrameView() != null) {
                    io.dcloud.feature.nativeObj.NativeView.this.init();
                    io.dcloud.feature.nativeObj.NativeView.this.UpdateRegionData();
                    io.dcloud.feature.nativeObj.NativeView.this.configurationCange();
                    io.dcloud.feature.nativeObj.NativeView.this.requestLayout();
                    io.dcloud.feature.nativeObj.NativeView.this.invalidate();
                }
                io.dcloud.feature.nativeObj.NativeView.NativeCanvasView nativeCanvasView = io.dcloud.feature.nativeObj.NativeView.this.mCanvasView;
                if (nativeCanvasView != null) {
                    nativeCanvasView.requestLayout();
                    io.dcloud.feature.nativeObj.NativeView.this.mCanvasView.invalidate();
                }
            }
        }, 100L);
    }

    void removeFromViewGroup() {
        android.view.ViewGroup viewGroupObtainWindowView;
        if (!this.mAttached) {
            if (getParent() != null) {
                ((android.view.ViewGroup) getParent()).removeView(this);
            }
            clearViewData();
            return;
        }
        io.dcloud.common.DHInterface.IFrameView iFrameView = this.mFrameViewParent;
        if (iFrameView == null) {
            return;
        }
        iFrameView.removeFrameViewListener(this.mIEventCallback);
        java.lang.String strOptString = this.mStyle.optString("position", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE);
        if (android.text.TextUtils.equals(strOptString, "dock")) {
            viewGroupObtainWindowView = (android.view.ViewGroup) ((io.dcloud.common.adapter.ui.AdaFrameItem) this.mFrameViewParent).obtainMainView();
        } else if (android.text.TextUtils.equals(strOptString, "static")) {
            viewGroupObtainWindowView = this.mFrameViewParent.obtainWebView().obtainWindowView();
        } else {
            viewGroupObtainWindowView = android.text.TextUtils.equals(strOptString, io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE) ? (android.view.ViewGroup) ((io.dcloud.common.adapter.ui.AdaFrameItem) this.mFrameViewParent).obtainMainView() : null;
        }
        if (viewGroupObtainWindowView != null) {
            viewGroupObtainWindowView.removeView(this);
        } else {
            android.view.ViewParent parent = getParent();
            if (parent != null) {
                ((android.view.ViewGroup) parent).removeView(this);
            }
        }
        if (this instanceof io.dcloud.feature.nativeObj.TitleNView) {
            ((io.dcloud.common.adapter.ui.AdaFrameView) this.mFrameViewParent).obtainFrameOptions().titleNView = null;
        }
        ((io.dcloud.common.adapter.ui.AdaFrameView) this.mFrameViewParent).changeWebParentViewRect();
        this.mAttached = false;
        this.mFrameViewParent = null;
        clearViewData();
    }

    public void resetNativeView() {
        clearViewData();
        clearAnimate();
    }

    public void setInputFocusById(java.lang.String str, boolean z) {
        android.widget.EditText inputById = getInputById(str);
        if (inputById != null) {
            if (z) {
                inputById.requestFocus();
                android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) inputById.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    try {
                        inputMethodManager.showSoftInput(inputById, 0);
                        return;
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            }
            inputById.clearFocus();
            android.view.inputmethod.InputMethodManager inputMethodManager2 = (android.view.inputmethod.InputMethodManager) inputById.getContext().getSystemService("input_method");
            if (inputMethodManager2 != null) {
                try {
                    inputMethodManager2.hideSoftInputFromWindow(inputById.getApplicationWindowToken(), 0);
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public void setNativeShowType(boolean z) {
        this.mShow = z;
    }

    public void setStyle(org.json.JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            try {
                org.json.JSONObject jSONObject2 = this.mStyle;
                if (jSONObject2 == null) {
                    this.mStyle = jSONObject;
                } else {
                    this.mStyle = io.dcloud.common.util.JSONUtil.combinJSONObject(jSONObject2, jSONObject);
                }
                if (z) {
                    init();
                    requestLayout();
                    invalidate();
                    io.dcloud.feature.nativeObj.NativeView.NativeCanvasView nativeCanvasView = this.mCanvasView;
                    if (nativeCanvasView != null) {
                        nativeCanvasView.requestLayout();
                        this.mCanvasView.invalidate();
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public void setStyleBackgroundColor(java.lang.String str) {
        int iStringToColor;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = this.mStyle;
            if (jSONObject != null) {
                if (jSONObject.has("backgroudColor")) {
                    this.mStyle.put("backgroudColor", str);
                } else if (this.mStyle.has("backgroundColor")) {
                    this.mStyle.put("backgroundColor", str);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        try {
            iStringToColor = android.graphics.Color.parseColor(str);
        } catch (java.lang.Exception unused) {
            iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(str);
        }
        setStyleBackgroundColor(iStringToColor);
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public void setStyleLeft(int i) {
        try {
            this.mStyle.put("left", (java.lang.Float.valueOf(java.lang.String.valueOf(i)).floatValue() / this.mCreateScale) + "px");
            requestLayout();
            invalidate();
            io.dcloud.feature.nativeObj.NativeView.NativeCanvasView nativeCanvasView = this.mCanvasView;
            if (nativeCanvasView != null) {
                nativeCanvasView.requestLayout();
                this.mCanvasView.invalidate();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    void setTouchEventRect(java.lang.String str) {
        this.mTouchRectJson = str;
        initJsonTouchRect();
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public void setWebAnimationRuning(boolean z) {
        this.isWebAnimationRuning = z;
    }

    @Override // io.dcloud.common.DHInterface.INativeView
    public org.json.JSONObject toJSON() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("id", this.mID);
            jSONObject.put("uuid", this.mUUID);
            jSONObject.put("type", getViewType());
            org.json.JSONObject jSONObject2 = this.mStyle;
            if (jSONObject2 != null) {
                jSONObject.put("styles", jSONObject2.toString());
            }
            return jSONObject;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public io.dcloud.feature.nativeObj.NativeView.Overlay makeOverlay(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap, java.lang.String str, int i, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, org.json.JSONObject jSONObject3, java.lang.String str2, java.lang.String str3, boolean z, boolean z2) {
        io.dcloud.feature.nativeObj.NativeView.Overlay overlay = new io.dcloud.feature.nativeObj.NativeView.Overlay();
        this.mWebView = iWebview;
        overlay.mNativeView = this;
        overlay.mSrcJson = jSONObject;
        overlay.mDestJson = jSONObject2;
        overlay.mStyleJson = jSONObject3;
        overlay.mNativeBitmap = nativeBitmap;
        overlay.mText = str;
        overlay.mRectColor = i;
        overlay.type = str3;
        if (io.dcloud.common.util.PdrUtil.isEmpty(str2)) {
            this.mOverlays.add(overlay);
        } else if (this.mOverlayMaps.containsKey(str2)) {
            this.mOverlays.set(this.mOverlayMaps.get(str2).intValue(), overlay);
        } else {
            this.mOverlays.add(overlay);
            this.mOverlayMaps.put(str2, java.lang.Integer.valueOf(this.mOverlays.indexOf(overlay)));
        }
        overlay.parseJson(this.mWebView);
        if (str3.equals(com.taobao.weex.ui.component.WXBasicComponentType.IMG) && nativeBitmap != null && nativeBitmap.isGif()) {
            addGifImagview(overlay);
        }
        if (str3.equals("input")) {
            overlay.webview = iWebview;
            addInput(overlay, str2);
        }
        if (z) {
            nativeInvalidate(z2);
        }
        return overlay;
    }

    public void setStyleBackgroundColor(int i) {
        this.mBackGroundColor = i;
        io.dcloud.feature.nativeObj.NativeView.NativeCanvasView nativeCanvasView = this.mCanvasView;
        if (nativeCanvasView != null) {
            nativeCanvasView.invalidate();
        }
    }
}
