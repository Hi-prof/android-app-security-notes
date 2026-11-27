package com.taobao.weex.ui.view;

/* JADX INFO: loaded from: classes.dex */
public class WXHorizontalScrollView extends android.widget.HorizontalScrollView implements com.taobao.weex.ui.view.IWXScroller, com.taobao.weex.ui.view.gesture.WXGestureObservable {
    private com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener mScrollViewListener;
    private java.util.List<com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener> mScrollViewListeners;
    private boolean scrollable;
    private com.taobao.weex.ui.view.gesture.WXGesture wxGesture;

    public interface ScrollViewListener {
        void onScrollChanged(com.taobao.weex.ui.view.WXHorizontalScrollView wXHorizontalScrollView, int i, int i2, int i3, int i4);
    }

    @Override // com.taobao.weex.ui.view.IWXScroller
    public void destroy() {
    }

    public WXHorizontalScrollView(android.content.Context context) {
        super(context);
        this.scrollable = true;
        init();
    }

    private void init() {
        setWillNotDraw(false);
        setOverScrollMode(2);
    }

    public WXHorizontalScrollView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scrollable = true;
        init();
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener scrollViewListener = this.mScrollViewListener;
        com.taobao.weex.ui.view.WXHorizontalScrollView wXHorizontalScrollView = this;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(wXHorizontalScrollView, i5, i6, i7, i8);
        }
        java.util.List<com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener> list = wXHorizontalScrollView.mScrollViewListeners;
        if (list != null) {
            java.util.Iterator<com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener> it = list.iterator();
            while (it.hasNext()) {
                int i9 = i8;
                int i10 = i7;
                int i11 = i6;
                int i12 = i5;
                it.next().onScrollChanged(wXHorizontalScrollView, i12, i11, i10, i9);
                i5 = i12;
                i6 = i11;
                i7 = i10;
                wXHorizontalScrollView = this;
                i8 = i9;
            }
        }
    }

    public void setScrollViewListener(com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener scrollViewListener) {
        this.mScrollViewListener = scrollViewListener;
    }

    public void addScrollViewListener(com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener scrollViewListener) {
        if (this.mScrollViewListeners == null) {
            this.mScrollViewListeners = new java.util.concurrent.CopyOnWriteArrayList();
        }
        if (this.mScrollViewListeners.contains(scrollViewListener)) {
            return;
        }
        this.mScrollViewListeners.add(scrollViewListener);
    }

    public void removeScrollViewListener(com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener scrollViewListener) {
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
        if (this.scrollable) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
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
}
