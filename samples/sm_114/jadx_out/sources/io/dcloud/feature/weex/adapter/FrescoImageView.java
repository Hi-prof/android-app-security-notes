package io.dcloud.feature.weex.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class FrescoImageView extends io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeView implements com.taobao.weex.ui.view.gesture.WXGestureObservable {
    private com.taobao.weex.ui.view.gesture.WXGesture wxGesture;

    public FrescoImageView(android.content.Context context) {
        super(context);
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(com.taobao.weex.ui.view.gesture.WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public com.taobao.weex.ui.view.gesture.WXGesture getGestureListener() {
        return this.wxGesture;
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        com.taobao.weex.ui.view.gesture.WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? wXGesture.onTouch(this, motionEvent) | zOnTouchEvent : zOnTouchEvent;
    }

    public void setFadeShow(boolean z) {
        if (getHierarchy() != null) {
            if (z) {
                getHierarchy().setFadeDuration(300);
                getHierarchy().getTopLevelDrawable().setRefresh(true);
            } else {
                getHierarchy().setFadeDuration(0);
                getHierarchy().getTopLevelDrawable().setRefresh(false);
            }
        }
    }
}
