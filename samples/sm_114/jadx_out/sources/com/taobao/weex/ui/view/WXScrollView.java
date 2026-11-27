package com.taobao.weex.ui.view;

/* JADX INFO: loaded from: classes.dex */
public class WXScrollView extends android.widget.ScrollView implements android.os.Handler.Callback, com.taobao.weex.ui.view.IWXScroller, com.taobao.weex.ui.view.gesture.WXGestureObservable, androidx.core.view.NestedScrollingChild {
    private androidx.core.view.NestedScrollingChildHelper childHelper;
    private int[] consumed;
    private int mCheckTime;
    private android.view.View mCurrentStickyView;
    private boolean mHasNotDoneActionDown;
    private int mInitialPosition;
    private boolean mRedirectTouchToStickyView;
    private android.graphics.Rect mScrollRect;
    private java.util.List<com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener> mScrollViewListeners;
    int mScrollX;
    int mScrollY;
    private android.os.Handler mScrollerTask;
    private int mStickyOffset;
    private int[] mStickyP;
    private com.taobao.weex.ui.component.WXBaseScroller mWAScroller;
    private int[] offsetInWindow;
    private float ox;
    private float oy;
    private boolean scrollable;
    private int[] stickyScrollerP;
    private int[] stickyViewP;
    private com.taobao.weex.ui.view.gesture.WXGesture wxGesture;

    public interface WXScrollViewListener {
        void onScroll(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2);

        void onScrollChanged(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2, int i3, int i4);

        void onScrollStopped(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2);

        void onScrollToBottom(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2);
    }

    public WXScrollView(android.content.Context context) {
        super(context);
        this.consumed = new int[2];
        this.offsetInWindow = new int[2];
        this.mHasNotDoneActionDown = true;
        this.mCheckTime = 100;
        this.mStickyP = new int[2];
        this.stickyScrollerP = new int[2];
        this.stickyViewP = new int[2];
        this.scrollable = true;
        this.mScrollViewListeners = new java.util.ArrayList();
        init();
        try {
            com.taobao.weex.utils.WXReflectionUtils.setValue(this, "mMinimumVelocity", 5);
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXScrollView] WXScrollView: ", e);
        }
    }

    private void init() {
        setWillNotDraw(false);
        startScrollerTask();
        setOverScrollMode(2);
        androidx.core.view.NestedScrollingChildHelper nestedScrollingChildHelper = new androidx.core.view.NestedScrollingChildHelper(this);
        this.childHelper = nestedScrollingChildHelper;
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
    }

    public void startScrollerTask() {
        if (this.mScrollerTask == null) {
            this.mScrollerTask = new android.os.Handler(com.taobao.weex.common.WXThread.secure(this));
        }
        this.mInitialPosition = getScrollY();
        this.mScrollerTask.sendEmptyMessageDelayed(0, this.mCheckTime);
    }

    public WXScrollView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.consumed = new int[2];
        this.offsetInWindow = new int[2];
        this.mHasNotDoneActionDown = true;
        this.mCheckTime = 100;
        this.mStickyP = new int[2];
        this.stickyScrollerP = new int[2];
        this.stickyViewP = new int[2];
        this.scrollable = true;
        init();
    }

    public WXScrollView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.consumed = new int[2];
        this.offsetInWindow = new int[2];
        this.mHasNotDoneActionDown = true;
        this.mCheckTime = 100;
        this.mStickyP = new int[2];
        this.stickyScrollerP = new int[2];
        this.stickyViewP = new int[2];
        this.scrollable = true;
        setOverScrollMode(2);
    }

    public void addScrollViewListener(com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener wXScrollViewListener) {
        if (this.mScrollViewListeners.contains(wXScrollViewListener)) {
            return;
        }
        this.mScrollViewListeners.add(wXScrollViewListener);
    }

    public void removeScrollViewListener(com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener wXScrollViewListener) {
        this.mScrollViewListeners.remove(wXScrollViewListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mRedirectTouchToStickyView = true;
        }
        if (this.mRedirectTouchToStickyView) {
            boolean z = false;
            boolean z2 = this.mCurrentStickyView != null;
            this.mRedirectTouchToStickyView = z2;
            if (z2) {
                if (motionEvent.getY() <= this.mCurrentStickyView.getHeight() && motionEvent.getX() >= this.mCurrentStickyView.getLeft() && motionEvent.getX() <= this.mCurrentStickyView.getRight()) {
                    z = true;
                }
                this.mRedirectTouchToStickyView = z;
            }
        }
        if (this.mRedirectTouchToStickyView) {
            if (this.mScrollRect == null) {
                android.graphics.Rect rect = new android.graphics.Rect();
                this.mScrollRect = rect;
                getGlobalVisibleRect(rect);
            }
            this.mCurrentStickyView.getLocationOnScreen(this.stickyViewP);
            motionEvent.offsetLocation(0.0f, this.stickyViewP[1] - this.mScrollRect.top);
        }
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        com.taobao.weex.ui.view.gesture.WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? wXGesture.onTouch(this, motionEvent) | zDispatchTouchEvent : zDispatchTouchEvent;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mCurrentStickyView != null) {
            canvas.save();
            this.mCurrentStickyView.getLocationOnScreen(this.mStickyP);
            int i = this.mStickyOffset;
            if (i > 0) {
                i = 0;
            }
            canvas.translate(this.mStickyP[0], getScrollY() + i);
            canvas.clipRect(0, i, this.mCurrentStickyView.getWidth(), this.mCurrentStickyView.getHeight());
            this.mCurrentStickyView.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!this.scrollable) {
            return true;
        }
        if (this.mRedirectTouchToStickyView) {
            if (this.mScrollRect == null) {
                android.graphics.Rect rect = new android.graphics.Rect();
                this.mScrollRect = rect;
                getGlobalVisibleRect(rect);
            }
            this.mCurrentStickyView.getLocationOnScreen(this.stickyViewP);
            motionEvent.offsetLocation(0.0f, -(this.stickyViewP[1] - this.mScrollRect.top));
        }
        if (motionEvent.getAction() == 0) {
            this.mHasNotDoneActionDown = false;
        }
        if (this.mHasNotDoneActionDown) {
            android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(0);
            this.mHasNotDoneActionDown = false;
            motionEventObtain.recycle();
        }
        if (motionEvent.getAction() == 0) {
            this.ox = motionEvent.getX();
            this.oy = motionEvent.getY();
            startNestedScroll(3);
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.mHasNotDoneActionDown = true;
            stopNestedScroll();
        }
        if (motionEvent.getAction() == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (dispatchNestedPreScroll((int) (this.ox - x), (int) (this.oy - y), this.consumed, this.offsetInWindow)) {
                int[] iArr = this.consumed;
                motionEvent.setLocation(x + iArr[0], y + iArr[1]);
            }
            this.ox = motionEvent.getX();
            this.oy = motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.childHelper.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.childHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.childHelper.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.childHelper.stopNestedScroll();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.childHelper.hasNestedScrollingParent();
    }

    public boolean isScrollable() {
        return this.scrollable;
    }

    public void setScrollable(boolean z) {
        this.scrollable = z;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.childHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.childHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.childHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.childHelper.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(android.view.View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(android.view.View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.widget.ScrollView
    public void fling(int i) {
        super.fling(i);
        android.os.Handler handler = this.mScrollerTask;
        if (handler != null) {
            handler.removeMessages(0);
        }
        startScrollerTask();
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        this.mScrollX = getScrollX();
        int scrollY = getScrollY();
        this.mScrollY = scrollY;
        onScroll(this, this.mScrollX, scrollY);
        android.view.View childAt = getChildAt(getChildCount() - 1);
        if (childAt == null) {
            return;
        }
        int bottom = childAt.getBottom();
        int height = getHeight();
        int i5 = this.mScrollY;
        if (bottom - (height + i5) == 0) {
            onScrollToBottom(this.mScrollX, i5);
        }
        java.util.List<com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener> list = this.mScrollViewListeners;
        int size = list == null ? 0 : list.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.mScrollViewListeners.get(i6).onScrollChanged(this, i, i2, i3, i4);
        }
        showStickyView();
    }

    protected void onScroll(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
        java.util.List<com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener> list = this.mScrollViewListeners;
        int size = list == null ? 0 : list.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mScrollViewListeners.get(i3).onScroll(this, i, i2);
        }
    }

    protected void onScrollToBottom(int i, int i2) {
        java.util.List<com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener> list = this.mScrollViewListeners;
        int size = list == null ? 0 : list.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mScrollViewListeners.get(i3).onScrollToBottom(this, i, i2);
        }
    }

    private void showStickyView() {
        com.taobao.weex.ui.component.WXBaseScroller wXBaseScroller = this.mWAScroller;
        if (wXBaseScroller == null) {
            return;
        }
        android.view.View viewProcSticky = procSticky(wXBaseScroller.getStickMap());
        if (viewProcSticky != null) {
            this.mCurrentStickyView = viewProcSticky;
        } else {
            this.mCurrentStickyView = null;
        }
    }

    private android.view.View procSticky(java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.taobao.weex.ui.component.WXComponent>> map) {
        java.util.Map<java.lang.String, com.taobao.weex.ui.component.WXComponent> map2;
        if (map == null || (map2 = map.get(this.mWAScroller.getRef())) == null) {
            return null;
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.taobao.weex.ui.component.WXComponent>> it = map2.entrySet().iterator();
        while (it.hasNext()) {
            com.taobao.weex.ui.component.WXComponent value = it.next().getValue();
            getLocationOnScreen(this.stickyScrollerP);
            value.getHostView().getLocationOnScreen(this.stickyViewP);
            int height = (value.getParent() == null || value.getParent().getRealView() == null) ? 0 : value.getParent().getRealView().getHeight();
            int height2 = value.getHostView().getHeight();
            int i = this.stickyScrollerP[1];
            int i2 = (-height) + i + height2;
            int i3 = this.stickyViewP[1];
            if (i3 <= i && i3 >= i2 - height2) {
                this.mStickyOffset = i3 - i2;
                value.setStickyOffset(i3 - i);
                return value.getHostView();
            }
            value.setStickyOffset(0);
        }
        return null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        if (message.what != 0) {
            return true;
        }
        android.os.Handler handler = this.mScrollerTask;
        if (handler != null) {
            handler.removeMessages(0);
        }
        if (this.mInitialPosition - getScrollY() == 0) {
            onScrollStopped(this, getScrollX(), getScrollY());
            return true;
        }
        onScroll(this, getScrollX(), getScrollY());
        this.mInitialPosition = getScrollY();
        android.os.Handler handler2 = this.mScrollerTask;
        if (handler2 == null) {
            return true;
        }
        handler2.sendEmptyMessageDelayed(0, this.mCheckTime);
        return true;
    }

    protected void onScrollStopped(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
        java.util.List<com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener> list = this.mScrollViewListeners;
        int size = list == null ? 0 : list.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mScrollViewListeners.get(i3).onScrollStopped(this, i, i2);
        }
    }

    @Override // com.taobao.weex.ui.view.IWXScroller
    public void destroy() {
        android.os.Handler handler = this.mScrollerTask;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(com.taobao.weex.ui.view.gesture.WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public com.taobao.weex.ui.view.gesture.WXGesture getGestureListener() {
        return this.wxGesture;
    }

    public android.graphics.Rect getContentFrame() {
        return new android.graphics.Rect(0, 0, computeHorizontalScrollRange(), computeVerticalScrollRange());
    }

    public void setWAScroller(com.taobao.weex.ui.component.WXBaseScroller wXBaseScroller) {
        this.mWAScroller = wXBaseScroller;
    }
}
