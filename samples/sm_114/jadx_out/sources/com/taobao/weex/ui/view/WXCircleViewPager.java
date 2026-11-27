package com.taobao.weex.ui.view;

/* JADX INFO: loaded from: classes.dex */
public class WXCircleViewPager extends androidx.viewpager.widget.ViewPager implements com.taobao.weex.ui.view.gesture.WXGestureObservable {
    private final int SCROLL_TO_NEXT;
    private long intervalTime;
    private boolean isAutoScroll;
    private android.os.Handler mAutoScrollHandler;
    private com.taobao.weex.ui.view.WXSmoothScroller mScroller;
    private int mState;
    private boolean needLoop;
    private boolean scrollable;
    private com.taobao.weex.ui.view.gesture.WXGesture wxGesture;

    public WXCircleViewPager(android.content.Context context) {
        super(context);
        this.SCROLL_TO_NEXT = 1;
        this.intervalTime = 3000L;
        this.needLoop = true;
        this.scrollable = true;
        this.mState = 0;
        this.mAutoScrollHandler = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.taobao.weex.ui.view.WXCircleViewPager.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what == 1) {
                    com.taobao.weex.utils.WXLogUtils.d("[CircleViewPager] trigger auto play action");
                    com.taobao.weex.ui.view.WXCircleViewPager.this.showNextItem();
                    sendEmptyMessageDelayed(1, com.taobao.weex.ui.view.WXCircleViewPager.this.intervalTime);
                    return;
                }
                super.handleMessage(message);
            }
        };
        init();
    }

    private void init() {
        setOverScrollMode(2);
        addOnPageChangeListener(new androidx.viewpager.widget.ViewPager.OnPageChangeListener() { // from class: com.taobao.weex.ui.view.WXCircleViewPager.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.taobao.weex.ui.view.WXCircleViewPager.this.mState = i;
                com.taobao.weex.ui.view.WXCirclePageAdapter circlePageAdapter = com.taobao.weex.ui.view.WXCircleViewPager.this.getCirclePageAdapter();
                int currentItem = com.taobao.weex.ui.view.WXCircleViewPager.super.getCurrentItem();
                if (com.taobao.weex.ui.view.WXCircleViewPager.this.needLoop && i == 0 && circlePageAdapter.getCount() > 1) {
                    if (currentItem == circlePageAdapter.getCount() - 1) {
                        com.taobao.weex.ui.view.WXCircleViewPager.this.superSetCurrentItem(1, false);
                        circlePageAdapter.getViews().get(0).setTranslationY(0.0f);
                        circlePageAdapter.getViews().get(0).setTranslationX(0.0f);
                    } else if (currentItem == 0) {
                        com.taobao.weex.ui.view.WXCircleViewPager.this.superSetCurrentItem(circlePageAdapter.getCount() - 2, false);
                        try {
                            circlePageAdapter.getViews().get(circlePageAdapter.getCount() - 3).setTranslationY(0.0f);
                            circlePageAdapter.getViews().get(circlePageAdapter.getCount() - 3).setTranslationX(0.0f);
                        } catch (java.lang.Exception unused) {
                        }
                    }
                }
            }
        });
        postInitViewPager();
    }

    private void postInitViewPager() {
        if (isInEditMode()) {
            return;
        }
        try {
            java.lang.reflect.Field declaredField = androidx.viewpager.widget.ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            java.lang.reflect.Field declaredField2 = androidx.viewpager.widget.ViewPager.class.getDeclaredField("sInterpolator");
            declaredField2.setAccessible(true);
            com.taobao.weex.ui.view.WXSmoothScroller wXSmoothScroller = new com.taobao.weex.ui.view.WXSmoothScroller(getContext(), (android.view.animation.Interpolator) declaredField2.get(null));
            this.mScroller = wXSmoothScroller;
            declaredField.set(this, wXSmoothScroller);
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[CircleViewPager] postInitViewPager: ", e);
        }
    }

    public com.taobao.weex.ui.view.WXSmoothScroller getmScroller() {
        return this.mScroller;
    }

    public WXCircleViewPager(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.SCROLL_TO_NEXT = 1;
        this.intervalTime = 3000L;
        this.needLoop = true;
        this.scrollable = true;
        this.mState = 0;
        this.mAutoScrollHandler = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.taobao.weex.ui.view.WXCircleViewPager.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what == 1) {
                    com.taobao.weex.utils.WXLogUtils.d("[CircleViewPager] trigger auto play action");
                    com.taobao.weex.ui.view.WXCircleViewPager.this.showNextItem();
                    sendEmptyMessageDelayed(1, com.taobao.weex.ui.view.WXCircleViewPager.this.intervalTime);
                    return;
                }
                super.handleMessage(message);
            }
        };
        init();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        return getRealCurrentItem();
    }

    public int superGetCurrentItem() {
        return super.getCurrentItem();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        try {
            return this.scrollable && super.onInterceptTouchEvent(motionEvent);
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        } catch (java.lang.IllegalArgumentException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.scrollable) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (this.scrollable || this.mState != 1) {
            super.scrollTo(i, i2);
        }
    }

    public void startAutoScroll() {
        this.isAutoScroll = true;
        this.mAutoScrollHandler.removeCallbacksAndMessages(null);
        this.mAutoScrollHandler.sendEmptyMessageDelayed(1, this.intervalTime);
    }

    public void pauseAutoScroll() {
        this.mAutoScrollHandler.removeCallbacksAndMessages(null);
    }

    public void stopAutoScroll() {
        this.isAutoScroll = false;
        this.mAutoScrollHandler.removeCallbacksAndMessages(null);
    }

    public boolean isAutoScroll() {
        return this.isAutoScroll;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i) {
        setRealCurrentItem(i, true);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i, boolean z) {
        setRealCurrentItem(i, z);
    }

    public com.taobao.weex.ui.view.WXCirclePageAdapter getCirclePageAdapter() {
        return (com.taobao.weex.ui.view.WXCirclePageAdapter) getAdapter();
    }

    public void setCirclePageAdapter(com.taobao.weex.ui.view.WXCirclePageAdapter wXCirclePageAdapter) {
        setAdapter(wXCirclePageAdapter);
    }

    public long getIntervalTime() {
        return this.intervalTime;
    }

    public void setIntervalTime(long j) {
        this.intervalTime = j;
    }

    public void setCircle(boolean z) {
        this.needLoop = z;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0010  */
    /* JADX WARN: Code duplicated, block: B:13:0x0016  */
    /* JADX WARN: Code duplicated, block: B:14:0x001e  */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mAutoScrollHandler.removeCallbacksAndMessages(null);
        } else if (action == 1) {
            if (isAutoScroll()) {
                this.mAutoScrollHandler.sendEmptyMessageDelayed(1, this.intervalTime);
            }
        } else if (action == 2) {
            this.mAutoScrollHandler.removeCallbacksAndMessages(null);
        } else if (action == 3) {
            if (isAutoScroll()) {
                this.mAutoScrollHandler.sendEmptyMessageDelayed(1, this.intervalTime);
            }
        }
        try {
            boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            com.taobao.weex.ui.view.gesture.WXGesture wXGesture = this.wxGesture;
            return wXGesture != null ? wXGesture.onTouch(this, motionEvent) | zDispatchTouchEvent : zDispatchTouchEvent;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public void destory() {
        this.mAutoScrollHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(com.taobao.weex.ui.view.gesture.WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public com.taobao.weex.ui.view.gesture.WXGesture getGestureListener() {
        return this.wxGesture;
    }

    public int getRealCurrentItem() {
        return ((com.taobao.weex.ui.view.WXCirclePageAdapter) getAdapter()).getRealPosition(super.getCurrentItem());
    }

    private void setRealCurrentItem(int i, boolean z) {
        superSetCurrentItem(((com.taobao.weex.ui.view.WXCirclePageAdapter) getAdapter()).getFirst() + i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void superSetCurrentItem(int i, boolean z) {
        try {
            try {
                if (java.lang.Math.abs(i - getRealCurrentItem()) > 3 && this.needLoop && getRealCount() > 2 && i == getCirclePageAdapter().getCount() - 2) {
                    super.setCurrentItem(i - 2, false);
                }
            } catch (java.lang.Exception unused) {
            }
            super.setCurrentItem(i, z);
        } catch (java.lang.IllegalStateException e) {
            com.taobao.weex.utils.WXLogUtils.e(e.toString());
            if (getAdapter() != null) {
                getAdapter().notifyDataSetChanged();
                super.setCurrentItem(i, z);
            }
        }
    }

    public int getRealCount() {
        return ((com.taobao.weex.ui.view.WXCirclePageAdapter) getAdapter()).getRealCount();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (java.lang.IllegalStateException e) {
            com.taobao.weex.utils.WXLogUtils.e(e.toString());
            if (getAdapter() != null) {
                getAdapter().notifyDataSetChanged();
                super.onMeasure(i, i2);
            }
        }
    }

    public boolean isScrollable() {
        return this.scrollable;
    }

    public void setScrollable(boolean z) {
        this.scrollable = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNextItem() {
        if (getCirclePageAdapter() != null && getCirclePageAdapter().isRTL) {
            if (this.needLoop || superGetCurrentItem() != 0) {
                if (getRealCount() == 2 && superGetCurrentItem() == 0) {
                    superSetCurrentItem(1, true);
                    return;
                } else {
                    superSetCurrentItem(superGetCurrentItem() - 1, true);
                    return;
                }
            }
            return;
        }
        if (this.needLoop || superGetCurrentItem() != getRealCount() - 1) {
            if (getRealCount() == 2 && superGetCurrentItem() == 1) {
                superSetCurrentItem(0, true);
            } else {
                superSetCurrentItem(superGetCurrentItem() + 1, true);
            }
        }
    }
}
