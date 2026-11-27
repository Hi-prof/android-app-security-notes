package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXSlider extends com.taobao.weex.ui.component.WXVContainer<android.widget.FrameLayout> {
    public static final java.lang.String INDEX = "index";
    public static final java.lang.String INFINITE = "infinite";
    private int initIndex;
    private java.lang.Runnable initRunnable;
    private boolean isInfinite;
    private boolean keepIndex;
    protected com.taobao.weex.ui.view.WXCirclePageAdapter mAdapter;
    protected com.taobao.weex.ui.component.WXIndicator mIndicator;
    protected androidx.viewpager.widget.ViewPager.OnPageChangeListener mPageChangeListener;
    protected boolean mShowIndicators;
    com.taobao.weex.ui.view.WXCircleViewPager mViewPager;
    private float offsetXAccuracy;
    java.util.Map<java.lang.String, java.lang.Object> params;

    public static class Creator implements com.taobao.weex.ui.ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public com.taobao.weex.ui.component.WXComponent createInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
            return new com.taobao.weex.ui.component.WXSlider(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    @java.lang.Deprecated
    public WXSlider(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, basicComponentData);
    }

    public WXSlider(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.isInfinite = true;
        this.params = new java.util.HashMap();
        this.offsetXAccuracy = 0.1f;
        this.initIndex = -1;
        this.keepIndex = false;
        this.mPageChangeListener = new com.taobao.weex.ui.component.WXSlider.SliderPageChangeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public com.taobao.weex.ui.view.BaseFrameLayout initComponentHostView(android.content.Context context) {
        com.taobao.weex.ui.view.BaseFrameLayout baseFrameLayout = new com.taobao.weex.ui.view.BaseFrameLayout(context);
        if (getAttrs() != null) {
            this.isInfinite = com.taobao.weex.utils.WXUtils.getBoolean(getAttrs().get("infinite"), true).booleanValue();
        }
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        com.taobao.weex.ui.view.WXCircleViewPager wXCircleViewPager = new com.taobao.weex.ui.view.WXCircleViewPager(context);
        this.mViewPager = wXCircleViewPager;
        wXCircleViewPager.setCircle(this.isInfinite);
        this.mViewPager.setLayoutParams(layoutParams);
        com.taobao.weex.ui.view.WXCirclePageAdapter wXCirclePageAdapter = new com.taobao.weex.ui.view.WXCirclePageAdapter(this.isInfinite);
        this.mAdapter = wXCirclePageAdapter;
        this.mViewPager.setAdapter(wXCirclePageAdapter);
        baseFrameLayout.addView(this.mViewPager);
        this.mViewPager.addOnPageChangeListener(this.mPageChangeListener);
        registerActivityStateListener();
        return baseFrameLayout;
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public android.view.ViewGroup.LayoutParams getChildLayoutParams(com.taobao.weex.ui.component.WXComponent wXComponent, android.view.View view, int i, int i2, int i3, int i4, int i5, int i6) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new android.widget.FrameLayout.LayoutParams(i, i2);
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
            if (wXComponent instanceof com.taobao.weex.ui.component.WXIndicator) {
                setMarginsSupportRTL((android.view.ViewGroup.MarginLayoutParams) layoutParams, i3, i5, i4, i6);
                return layoutParams;
            }
            setMarginsSupportRTL((android.view.ViewGroup.MarginLayoutParams) layoutParams, 0, 0, 0, 0);
        }
        return layoutParams;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(java.lang.String str) {
        com.taobao.weex.ui.view.WXCircleViewPager wXCircleViewPager;
        super.addEvent(str);
        if (!"scroll".equals(str) || (wXCircleViewPager = this.mViewPager) == null) {
            return;
        }
        wXCircleViewPager.addOnPageChangeListener(new com.taobao.weex.ui.component.WXSlider.SliderOnScrollListener(this));
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean containsGesture(com.taobao.weex.ui.view.gesture.WXGestureType wXGestureType) {
        return super.containsGesture(wXGestureType);
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent
    public android.view.ViewGroup getRealView() {
        return this.mViewPager;
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void addSubView(android.view.View view, int i) {
        com.taobao.weex.ui.view.WXCirclePageAdapter wXCirclePageAdapter;
        if (view == null || (wXCirclePageAdapter = this.mAdapter) == null || (view instanceof com.taobao.weex.ui.view.WXCircleIndicator)) {
            return;
        }
        wXCirclePageAdapter.addPageView(view);
        hackTwoItemsInfiniteScroll();
        if (this.initIndex != -1 && this.mAdapter.getRealCount() > this.initIndex) {
            if (this.initRunnable == null) {
                this.initRunnable = new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.WXSlider.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.taobao.weex.ui.component.WXSlider wXSlider = com.taobao.weex.ui.component.WXSlider.this;
                        wXSlider.initIndex = wXSlider.getInitIndex();
                        com.taobao.weex.ui.view.WXCircleViewPager wXCircleViewPager = com.taobao.weex.ui.component.WXSlider.this.mViewPager;
                        com.taobao.weex.ui.component.WXSlider wXSlider2 = com.taobao.weex.ui.component.WXSlider.this;
                        wXCircleViewPager.setCurrentItem(wXSlider2.getRealIndex(wXSlider2.initIndex));
                        com.taobao.weex.ui.component.WXSlider.this.initIndex = -1;
                        com.taobao.weex.ui.component.WXSlider.this.initRunnable = null;
                    }
                };
            }
            this.mViewPager.removeCallbacks(this.initRunnable);
            this.mViewPager.postDelayed(this.initRunnable, 50L);
        } else if (!this.keepIndex) {
            this.mViewPager.setCurrentItem(getRealIndex(0));
        }
        com.taobao.weex.ui.component.WXIndicator wXIndicator = this.mIndicator;
        if (wXIndicator != null) {
            wXIndicator.getHostView().forceLayout();
            this.mIndicator.getHostView().requestLayout();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void setLayout(com.taobao.weex.ui.component.WXComponent wXComponent) {
        com.taobao.weex.ui.view.WXCirclePageAdapter wXCirclePageAdapter = this.mAdapter;
        if (wXCirclePageAdapter != null) {
            wXCirclePageAdapter.setLayoutDirectionRTL(isLayoutRTL());
        }
        super.setLayout(wXComponent);
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void remove(com.taobao.weex.ui.component.WXComponent wXComponent, boolean z) {
        com.taobao.weex.ui.view.WXCirclePageAdapter wXCirclePageAdapter;
        if (wXComponent == null || wXComponent.getHostView() == null || (wXCirclePageAdapter = this.mAdapter) == null) {
            return;
        }
        wXCirclePageAdapter.removePageView(wXComponent.getHostView());
        hackTwoItemsInfiniteScroll();
        super.remove(wXComponent, z);
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        com.taobao.weex.ui.view.WXCircleViewPager wXCircleViewPager = this.mViewPager;
        if (wXCircleViewPager != null) {
            wXCircleViewPager.stopAutoScroll();
            this.mViewPager.removeAllViews();
            this.mViewPager.destory();
        }
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityResume() {
        super.onActivityResume();
        com.taobao.weex.ui.view.WXCircleViewPager wXCircleViewPager = this.mViewPager;
        if (wXCircleViewPager == null || !wXCircleViewPager.isAutoScroll()) {
            return;
        }
        this.mViewPager.startAutoScroll();
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityStop() {
        super.onActivityStop();
        com.taobao.weex.ui.view.WXCircleViewPager wXCircleViewPager = this.mViewPager;
        if (wXCircleViewPager != null) {
            wXCircleViewPager.pauseAutoScroll();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addIndicator(com.taobao.weex.ui.component.WXIndicator wXIndicator) {
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) getHostView();
        if (frameLayout == null) {
            return;
        }
        this.mIndicator = wXIndicator;
        com.taobao.weex.ui.view.WXCircleIndicator hostView = wXIndicator.getHostView();
        if (hostView != null) {
            hostView.setCircleViewPager(this.mViewPager);
            frameLayout.addView(hostView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getInitIndex() {
        int iIntValue = com.taobao.weex.utils.WXUtils.getInteger(getAttrs().get("index"), java.lang.Integer.valueOf(this.initIndex)).intValue();
        com.taobao.weex.ui.view.WXCirclePageAdapter wXCirclePageAdapter = this.mAdapter;
        if (wXCirclePageAdapter == null || wXCirclePageAdapter.getCount() == 0) {
            return 0;
        }
        return iIntValue >= this.mAdapter.getRealCount() ? iIntValue % this.mAdapter.getRealCount() : iIntValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealIndex(int i) {
        if (this.mAdapter.getRealCount() <= 0) {
            return i;
        }
        if (i >= this.mAdapter.getRealCount()) {
            i = this.mAdapter.getRealCount() - 1;
        }
        return isLayoutRTL() ? (this.mAdapter.getRealCount() - 1) - i : i;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
            case "keepIndex":
                this.keepIndex = com.taobao.weex.utils.WXUtils.getBoolean(obj, false).booleanValue();
                return true;
            case "scrollable":
                setScrollable(com.taobao.weex.utils.WXUtils.getBoolean(obj, true).booleanValue());
                return true;
            case "index":
                java.lang.Integer integer = com.taobao.weex.utils.WXUtils.getInteger(obj, null);
                if (integer != null) {
                    setIndex(integer.intValue());
                }
                return true;
            case "value":
                java.lang.String string = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string != null) {
                    setValue(string);
                }
                return true;
            case "interval":
                java.lang.Integer integer2 = com.taobao.weex.utils.WXUtils.getInteger(obj, null);
                if (integer2 != null) {
                    setInterval(integer2.intValue());
                }
                return true;
            case "showIndicators":
                java.lang.String string2 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string2 != null) {
                    setShowIndicators(string2);
                }
                return true;
            case "autoPlay":
                java.lang.String string3 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string3 != null) {
                    setAutoPlay(string3);
                }
                return true;
            case "offsetXAccuracy":
                java.lang.Float f = com.taobao.weex.utils.WXUtils.getFloat(obj, java.lang.Float.valueOf(0.1f));
                if (f.floatValue() != 0.0f) {
                    setOffsetXAccuracy(f.floatValue());
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "value")
    @java.lang.Deprecated
    public void setValue(java.lang.String str) {
        if (str == null || getHostView() == 0) {
            return;
        }
        try {
            setIndex(java.lang.Integer.parseInt(str));
        } catch (java.lang.NumberFormatException e) {
            com.taobao.weex.utils.WXLogUtils.e("", e);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.AUTO_PLAY)
    public void setAutoPlay(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || str.equals(io.dcloud.common.constant.AbsoluteConst.FALSE)) {
            this.mViewPager.stopAutoScroll();
        } else {
            this.mViewPager.stopAutoScroll();
            this.mViewPager.startAutoScroll();
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SHOW_INDICATORS)
    public void setShowIndicators(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || str.equals(io.dcloud.common.constant.AbsoluteConst.FALSE)) {
            this.mShowIndicators = false;
        } else {
            this.mShowIndicators = true;
        }
        com.taobao.weex.ui.component.WXIndicator wXIndicator = this.mIndicator;
        if (wXIndicator == null) {
            return;
        }
        wXIndicator.setShowIndicators(this.mShowIndicators);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "interval")
    public void setInterval(int i) {
        com.taobao.weex.ui.view.WXCircleViewPager wXCircleViewPager = this.mViewPager;
        if (wXCircleViewPager == null || i <= 0) {
            return;
        }
        wXCircleViewPager.setIntervalTime(i);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "index")
    public void setIndex(int i) {
        com.taobao.weex.ui.view.WXCirclePageAdapter wXCirclePageAdapter;
        com.taobao.weex.ui.view.WXCirclePageAdapter wXCirclePageAdapter2;
        if (this.mViewPager == null || (wXCirclePageAdapter = this.mAdapter) == null) {
            return;
        }
        if (i >= wXCirclePageAdapter.getRealCount() || i < 0) {
            this.initIndex = i;
            return;
        }
        int realIndex = getRealIndex(i);
        this.mViewPager.setCurrentItem(realIndex);
        com.taobao.weex.ui.component.WXIndicator wXIndicator = this.mIndicator;
        if (wXIndicator == null || wXIndicator.getHostView() == null || this.mIndicator.getHostView().getRealCurrentItem() == realIndex) {
            return;
        }
        com.taobao.weex.utils.WXLogUtils.d("setIndex >>>> correction indicator to " + realIndex);
        this.mIndicator.getHostView().setRealCurrentItem(realIndex);
        this.mIndicator.getHostView().invalidate();
        androidx.viewpager.widget.ViewPager.OnPageChangeListener onPageChangeListener = this.mPageChangeListener;
        if (onPageChangeListener == null || (wXCirclePageAdapter2 = this.mAdapter) == null) {
            return;
        }
        onPageChangeListener.onPageSelected(wXCirclePageAdapter2.getFirst() + realIndex);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SCROLLABLE)
    public void setScrollable(boolean z) {
        com.taobao.weex.ui.view.WXCircleViewPager wXCircleViewPager = this.mViewPager;
        if (wXCircleViewPager == null || this.mAdapter == null) {
            return;
        }
        wXCircleViewPager.setScrollable(z);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.OFFSET_X_ACCURACY)
    public void setOffsetXAccuracy(float f) {
        this.offsetXAccuracy = f;
    }

    protected class SliderPageChangeListener implements androidx.viewpager.widget.ViewPager.OnPageChangeListener {
        private int lastPos = -1;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        protected SliderPageChangeListener() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v13, types: [android.view.View] */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (com.taobao.weex.ui.component.WXSlider.this.mAdapter.getRealPosition(i) == this.lastPos) {
                return;
            }
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("onPageSelected >>>>" + com.taobao.weex.ui.component.WXSlider.this.mAdapter.getRealPosition(i) + " lastPos: " + this.lastPos);
            }
            if (com.taobao.weex.ui.component.WXSlider.this.mAdapter == null || com.taobao.weex.ui.component.WXSlider.this.mAdapter.getRealCount() == 0) {
                return;
            }
            int realPosition = com.taobao.weex.ui.component.WXSlider.this.mAdapter.getRealPosition(i);
            if (com.taobao.weex.ui.component.WXSlider.this.mChildren == null || realPosition >= com.taobao.weex.ui.component.WXSlider.this.mChildren.size() || com.taobao.weex.ui.component.WXSlider.this.getEvents().size() == 0) {
                return;
            }
            com.taobao.weex.dom.WXEvent events = com.taobao.weex.ui.component.WXSlider.this.getEvents();
            java.lang.String ref = com.taobao.weex.ui.component.WXSlider.this.getRef();
            if (events.contains(com.taobao.weex.common.Constants.Event.CHANGE) && com.taobao.weex.utils.WXViewUtils.onScreenArea(com.taobao.weex.ui.component.WXSlider.this.getHostView())) {
                com.taobao.weex.ui.component.WXSlider.this.params.put("index", java.lang.Integer.valueOf(realPosition));
                java.util.HashMap map = new java.util.HashMap();
                java.util.HashMap map2 = new java.util.HashMap();
                map2.put("index", java.lang.Integer.valueOf(realPosition));
                map.put(com.taobao.weex.ui.component.list.template.TemplateDom.KEY_ATTRS, map2);
                com.taobao.weex.WXSDKManager.getInstance().fireEvent(com.taobao.weex.ui.component.WXSlider.this.getInstanceId(), ref, com.taobao.weex.common.Constants.Event.CHANGE, com.taobao.weex.ui.component.WXSlider.this.params, map);
            }
            com.taobao.weex.ui.component.WXSlider.this.mViewPager.requestLayout();
            ((android.widget.FrameLayout) com.taobao.weex.ui.component.WXSlider.this.getHostView()).invalidate();
            this.lastPos = com.taobao.weex.ui.component.WXSlider.this.mAdapter.getRealPosition(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) com.taobao.weex.ui.component.WXSlider.this.getHostView();
            if (frameLayout != null) {
                frameLayout.invalidate();
            }
        }
    }

    protected static class SliderOnScrollListener implements androidx.viewpager.widget.ViewPager.OnPageChangeListener {
        private float lastPositionOffset = 99.0f;
        private int selectedPosition;
        private com.taobao.weex.ui.component.WXSlider target;

        public SliderOnScrollListener(com.taobao.weex.ui.component.WXSlider wXSlider) {
            this.target = wXSlider;
            this.selectedPosition = wXSlider.mViewPager.superGetCurrentItem();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            float f2 = this.lastPositionOffset;
            if (f2 == 99.0f) {
                this.lastPositionOffset = f;
                return;
            }
            if (java.lang.Math.abs(f - f2) >= this.target.offsetXAccuracy) {
                int i3 = this.selectedPosition;
                if (i == i3) {
                    java.util.HashMap map = new java.util.HashMap(1);
                    map.put(com.taobao.weex.common.Constants.Name.OFFSET_X_RATIO, java.lang.Float.valueOf(-f));
                    this.target.fireEvent("scroll", map);
                } else if (i < i3) {
                    java.util.HashMap map2 = new java.util.HashMap(1);
                    map2.put(com.taobao.weex.common.Constants.Name.OFFSET_X_RATIO, java.lang.Float.valueOf(1.0f - f));
                    this.target.fireEvent("scroll", map2);
                }
                this.lastPositionOffset = f;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            this.selectedPosition = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                this.lastPositionOffset = 99.0f;
                this.target.fireEvent(com.taobao.weex.common.Constants.Event.SCROLL_END);
            } else {
                if (i != 1) {
                    return;
                }
                this.target.fireEvent(com.taobao.weex.common.Constants.Event.SCROLL_START);
            }
        }
    }

    private void hackTwoItemsInfiniteScroll() {
        com.taobao.weex.ui.view.WXCirclePageAdapter wXCirclePageAdapter;
        if (this.mViewPager == null || (wXCirclePageAdapter = this.mAdapter) == null || !this.isInfinite) {
            return;
        }
        if (wXCirclePageAdapter.getRealCount() == 2) {
            final android.view.GestureDetector gestureDetector = new android.view.GestureDetector(getContext(), new com.taobao.weex.ui.component.WXSlider.FlingGestureListener(this.mViewPager));
            this.mViewPager.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.taobao.weex.ui.component.WXSlider.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
            });
        } else {
            this.mViewPager.setOnTouchListener(null);
        }
    }

    private static class FlingGestureListener extends android.view.GestureDetector.SimpleOnGestureListener {
        private java.lang.ref.WeakReference<com.taobao.weex.ui.view.WXCircleViewPager> pagerRef;
        private static final int SWIPE_MIN_DISTANCE = com.taobao.weex.utils.WXViewUtils.dip2px(50.0f);
        private static final int SWIPE_MAX_OFF_PATH = com.taobao.weex.utils.WXViewUtils.dip2px(250.0f);
        private static final int SWIPE_THRESHOLD_VELOCITY = com.taobao.weex.utils.WXViewUtils.dip2px(200.0f);

        FlingGestureListener(com.taobao.weex.ui.view.WXCircleViewPager wXCircleViewPager) {
            this.pagerRef = new java.lang.ref.WeakReference<>(wXCircleViewPager);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
            com.taobao.weex.ui.view.WXCircleViewPager wXCircleViewPager = this.pagerRef.get();
            if (wXCircleViewPager == null) {
                return false;
            }
            try {
                if (java.lang.Math.abs(motionEvent.getY() - motionEvent2.getY()) > SWIPE_MAX_OFF_PATH) {
                    return false;
                }
                float x = motionEvent.getX() - motionEvent2.getX();
                int i = SWIPE_MIN_DISTANCE;
                if (x > i && java.lang.Math.abs(f) > SWIPE_THRESHOLD_VELOCITY && wXCircleViewPager.superGetCurrentItem() == 1) {
                    wXCircleViewPager.setCurrentItem(0, false);
                    return true;
                }
                if (motionEvent2.getX() - motionEvent.getX() > i && java.lang.Math.abs(f) > SWIPE_THRESHOLD_VELOCITY && wXCircleViewPager.superGetCurrentItem() == 0) {
                    wXCircleViewPager.setCurrentItem(1, false);
                    return true;
                }
                return false;
            } catch (java.lang.Exception unused) {
            }
        }
    }
}
