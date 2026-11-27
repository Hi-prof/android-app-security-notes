package com.taobao.weex.ui.view;

/* JADX INFO: loaded from: classes.dex */
public class WXSwitchView extends androidx.appcompat.widget.SwitchCompat implements com.taobao.weex.ui.view.gesture.WXGestureObservable {
    private com.taobao.weex.ui.view.gesture.WXGesture wxGesture;

    public WXSwitchView(android.content.Context context) {
        super(context);
        setShowText(false);
        setGravity(16);
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(com.taobao.weex.ui.view.gesture.WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public com.taobao.weex.ui.view.gesture.WXGesture getGestureListener() {
        return this.wxGesture;
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.TextView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        com.taobao.weex.ui.view.gesture.WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? wXGesture.onTouch(this, motionEvent) | zOnTouchEvent : zOnTouchEvent;
    }
}
