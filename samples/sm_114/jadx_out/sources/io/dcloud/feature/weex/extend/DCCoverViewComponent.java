package io.dcloud.feature.weex.extend;

/* JADX INFO: loaded from: classes2.dex */
public class DCCoverViewComponent extends com.taobao.weex.ui.component.WXVContainer<android.view.ViewGroup> {
    java.util.HashMap<java.lang.String, java.lang.String> CalloutMarkerIds;
    private final android.view.ViewTreeObserver.OnDrawListener onDrawListener;
    private android.widget.FrameLayout realView;
    private final io.dcloud.common.util.ThrottleUtil throttle;

    public DCCoverViewComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.throttle = new io.dcloud.common.util.ThrottleUtil();
        this.onDrawListener = new android.view.ViewTreeObserver.OnDrawListener() { // from class: io.dcloud.feature.weex.extend.DCCoverViewComponent.1
            @Override // android.view.ViewTreeObserver.OnDrawListener
            public void onDraw() {
                io.dcloud.feature.weex.extend.DCCoverViewComponent.this.throttle.throttlePost(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.extend.DCCoverViewComponent.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        io.dcloud.feature.weex.extend.DCCoverViewComponent.this.updateCallout();
                    }
                }, 50L);
            }
        };
        this.CalloutMarkerIds = new java.util.HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public android.view.ViewGroup initComponentHostView(android.content.Context context) {
        android.view.ViewGroup viewGroup;
        java.lang.String string = "";
        if (getStyles().containsKey(com.taobao.weex.common.Constants.Name.OVERFLOW)) {
            string = com.taobao.weex.utils.WXUtils.getString(getStyles().get(com.taobao.weex.common.Constants.Name.OVERFLOW), "");
        } else if (getStyles().containsKey("overflowY")) {
            string = com.taobao.weex.utils.WXUtils.getString(getStyles().get("overflowY"), "");
        }
        this.realView = new android.widget.FrameLayout(context);
        if (string.equals("scroll")) {
            android.widget.ScrollView scrollView = new android.widget.ScrollView(context);
            scrollView.addView(this.realView, new android.widget.FrameLayout.LayoutParams(-1, -1));
            viewGroup = scrollView;
        } else {
            viewGroup = this.realView;
        }
        java.lang.Object obj = getAttrs().get("slot");
        if (obj != null && obj.equals("callout")) {
            viewGroup.setVisibility(4);
            viewGroup.getViewTreeObserver().addOnDrawListener(this.onDrawListener);
        }
        return viewGroup;
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent
    public android.view.ViewGroup getRealView() {
        return this.realView;
    }

    public java.util.HashMap<java.lang.String, java.lang.String> getCalloutMarkerIds() {
        return this.CalloutMarkerIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void addChild(com.taobao.weex.ui.component.WXComponent wXComponent, int i) {
        java.lang.Object obj;
        if ((wXComponent instanceof io.dcloud.feature.weex.extend.DCCoverViewComponent) && (obj = wXComponent.getAttrs().get("markerId")) != null) {
            this.CalloutMarkerIds.put(obj.toString(), wXComponent.getRef());
            if (getHostView() != 0) {
                ((android.view.ViewGroup) getHostView()).getViewTreeObserver().addOnDrawListener(this.onDrawListener);
            }
        }
        super.addChild(wXComponent, i);
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void remove(com.taobao.weex.ui.component.WXComponent wXComponent, boolean z) {
        if (wXComponent instanceof io.dcloud.feature.weex.extend.DCCoverViewComponent) {
            java.lang.Object obj = wXComponent.getAttrs().get("marker-id");
            if (obj == null || this.CalloutMarkerIds.get(obj).equals(wXComponent.getRef())) {
                return;
            }
            this.CalloutMarkerIds.remove(obj);
            return;
        }
        super.remove(wXComponent, z);
    }

    public void updateCallout() {
        if (!this.CalloutMarkerIds.isEmpty() && (getParent() instanceof io.dcloud.feature.weex.extend.IDCCoverViewUpdate) && (getParent() instanceof io.dcloud.feature.weex.adapter.IWeexMap)) {
            ((io.dcloud.feature.weex.extend.IDCCoverViewUpdate) getParent()).update(this.CalloutMarkerIds);
        }
        new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.extend.DCCoverViewComponent.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (io.dcloud.feature.weex.extend.DCCoverViewComponent.this.getHostView() != 0) {
                    ((android.view.ViewGroup) io.dcloud.feature.weex.extend.DCCoverViewComponent.this.getHostView()).getViewTreeObserver().removeOnDrawListener(io.dcloud.feature.weex.extend.DCCoverViewComponent.this.onDrawListener);
                }
            }
        });
    }
}
