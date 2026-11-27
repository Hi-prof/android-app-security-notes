package io.dcloud.feature.weex_scroller.view;

/* JADX INFO: loaded from: classes2.dex */
public class DCWXHorizontalScrollView extends android.widget.HorizontalScrollView implements com.taobao.weex.ui.view.IWXScroller, com.taobao.weex.ui.view.gesture.WXGestureObservable {
    private boolean isTouch;
    private float lowwer;
    private io.dcloud.feature.weex_scroller.view.DCWXHorizontalScrollView.ScrollViewListener mScrollViewListener;
    private java.util.List<io.dcloud.feature.weex_scroller.view.DCWXHorizontalScrollView.ScrollViewListener> mScrollViewListeners;
    int mScrollX;
    int mScrollY;
    private boolean scrollable;
    private java.lang.reflect.Field scroller;
    private boolean shouldBeTriggerLower;
    private boolean shouldBeTriggerUpper;
    private float upper;
    private com.taobao.weex.ui.view.gesture.WXGesture wxGesture;

    public interface ScrollViewListener {
        void onScrollChanged(io.dcloud.feature.weex_scroller.view.DCWXHorizontalScrollView dCWXHorizontalScrollView, int i, int i2, int i3, int i4);

        void onScrollToBottom();

        void onScrolltoTop();
    }

    public DCWXHorizontalScrollView(android.content.Context context) {
        super(context);
        this.scrollable = true;
        this.scroller = null;
        this.isTouch = false;
        this.shouldBeTriggerUpper = true;
        this.shouldBeTriggerLower = true;
        this.upper = 50.0f;
        this.lowwer = 50.0f;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        setOverScrollMode(2);
        try {
            java.lang.reflect.Field declaredField = android.widget.HorizontalScrollView.class.getDeclaredField("mScroller");
            this.scroller = declaredField;
            declaredField.setAccessible(true);
        } catch (java.lang.Exception unused) {
        }
    }

    public DCWXHorizontalScrollView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scrollable = true;
        this.scroller = null;
        this.isTouch = false;
        this.shouldBeTriggerUpper = true;
        this.shouldBeTriggerLower = true;
        this.upper = 50.0f;
        this.lowwer = 50.0f;
        init();
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        io.dcloud.common.ui.blur.AppEventForBlurManager.onScrollChanged(i, i2);
        this.mScrollX = getScrollX();
        this.mScrollY = getScrollY();
        if (getScrollX() <= this.upper && !this.shouldBeTriggerUpper) {
            scrollToTop();
            this.shouldBeTriggerUpper = true;
        } else if (getScrollX() > this.upper) {
            this.shouldBeTriggerUpper = false;
        }
        android.view.View childAt = getChildAt(getChildCount() - 1);
        if (childAt == null) {
            return;
        }
        float right = childAt.getRight() - (getWidth() + this.mScrollX);
        float f = this.lowwer;
        if (right <= f && !this.shouldBeTriggerLower) {
            scrollToBottom();
            this.shouldBeTriggerLower = true;
        } else if (right > f) {
            this.shouldBeTriggerLower = false;
        }
        io.dcloud.feature.weex_scroller.view.DCWXHorizontalScrollView.ScrollViewListener scrollViewListener = this.mScrollViewListener;
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, i, i2, i3 - i, i4 - i2);
        }
        java.util.List<io.dcloud.feature.weex_scroller.view.DCWXHorizontalScrollView.ScrollViewListener> list = this.mScrollViewListeners;
        if (list != null) {
            java.util.Iterator<io.dcloud.feature.weex_scroller.view.DCWXHorizontalScrollView.ScrollViewListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onScrollChanged(this, i, i2, i3 - i, i4 - i2);
            }
        }
    }

    private void scrollToTop() {
        io.dcloud.feature.weex_scroller.view.DCWXHorizontalScrollView.ScrollViewListener scrollViewListener = this.mScrollViewListener;
        if (scrollViewListener != null) {
            scrollViewListener.onScrolltoTop();
        }
        java.util.List<io.dcloud.feature.weex_scroller.view.DCWXHorizontalScrollView.ScrollViewListener> list = this.mScrollViewListeners;
        if (list != null) {
            java.util.Iterator<io.dcloud.feature.weex_scroller.view.DCWXHorizontalScrollView.ScrollViewListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onScrolltoTop();
            }
        }
    }

    public void stopScroll() {
        java.lang.reflect.Field field = this.scroller;
        if (field == null || this.isTouch) {
            return;
        }
        try {
            java.lang.reflect.Method method = field.getType().getMethod("abortAnimation", null);
            if (method != null) {
                method.setAccessible(true);
                method.invoke(this.scroller.get(this), null);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void setUpperLength(float f) {
        this.upper = f;
    }

    public void setLowwerLength(float f) {
        this.lowwer = f;
    }

    private void scrollToBottom() {
        io.dcloud.feature.weex_scroller.view.DCWXHorizontalScrollView.ScrollViewListener scrollViewListener = this.mScrollViewListener;
        if (scrollViewListener != null) {
            scrollViewListener.onScrollToBottom();
        }
        java.util.List<io.dcloud.feature.weex_scroller.view.DCWXHorizontalScrollView.ScrollViewListener> list = this.mScrollViewListeners;
        if (list != null) {
            java.util.Iterator<io.dcloud.feature.weex_scroller.view.DCWXHorizontalScrollView.ScrollViewListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onScrollToBottom();
            }
        }
    }

    public void setScrollViewListener(io.dcloud.feature.weex_scroller.view.DCWXHorizontalScrollView.ScrollViewListener scrollViewListener) {
        this.mScrollViewListener = scrollViewListener;
    }

    @Override // com.taobao.weex.ui.view.IWXScroller
    public void destroy() {
        java.util.List<io.dcloud.feature.weex_scroller.view.DCWXHorizontalScrollView.ScrollViewListener> list = this.mScrollViewListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void addScrollViewListener(io.dcloud.feature.weex_scroller.view.DCWXHorizontalScrollView.ScrollViewListener scrollViewListener) {
        if (this.mScrollViewListeners == null) {
            this.mScrollViewListeners = new java.util.ArrayList();
        }
        if (this.mScrollViewListeners.contains(scrollViewListener)) {
            return;
        }
        this.mScrollViewListeners.add(scrollViewListener);
    }

    public void removeScrollViewListener(io.dcloud.feature.weex_scroller.view.DCWXHorizontalScrollView.ScrollViewListener scrollViewListener) {
        this.mScrollViewListeners.remove(scrollViewListener);
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(com.taobao.weex.ui.view.gesture.WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public com.taobao.weex.ui.view.gesture.WXGesture getGestureListener() {
        return this.wxGesture;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        com.taobao.weex.ui.view.gesture.WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? wXGesture.onTouch(this, motionEvent) | zDispatchTouchEvent : zDispatchTouchEvent;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.isTouch = true;
        } else if (action == 1 || action == 3) {
            this.isTouch = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean isScrollable() {
        return this.scrollable;
    }

    public void setScrollable(boolean z) {
        this.scrollable = z;
    }

    public android.graphics.Rect getContentFrame() {
        return new android.graphics.Rect(0, 0, computeHorizontalScrollRange(), computeVerticalScrollRange());
    }

    public void setWAScroller(com.taobao.weex.ui.component.DCWXScroller dCWXScroller) {
        this.upper = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(50.0f, dCWXScroller.getViewPortWidth());
        this.lowwer = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(50.0f, dCWXScroller.getViewPortWidth());
    }
}
