package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXRefresh extends com.taobao.weex.ui.component.WXBaseRefresh implements com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXOnRefreshListener {
    public static final java.lang.String HIDE = "hide";

    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean canRecycled() {
        return false;
    }

    @java.lang.Deprecated
    public WXRefresh(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    public WXRefresh(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXBaseRefresh, com.taobao.weex.ui.component.WXComponent
    public com.taobao.weex.ui.view.WXFrameLayout initComponentHostView(android.content.Context context) {
        return new com.taobao.weex.ui.view.WXRefreshLayout(context);
    }

    @Override // com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXOnRefreshListener
    public void onRefresh() {
        if (!isDestoryed() && getEvents().contains("refresh")) {
            fireEvent("refresh");
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public int getLayoutTopOffsetForSibling() {
        if (getParent() instanceof com.taobao.weex.ui.component.Scrollable) {
            return -java.lang.Math.round(getLayoutHeight());
        }
        return 0;
    }

    @Override // com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXOnRefreshListener
    public void onPullingDown(float f, int i, float f2) {
        if (getEvents() == null || !getEvents().contains(com.taobao.weex.common.Constants.Event.ONPULLING_DOWN)) {
            return;
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.taobao.weex.common.Constants.Name.DISTANCE_Y, java.lang.Float.valueOf(f));
        map.put(com.taobao.weex.common.Constants.Name.PULLING_DISTANCE, java.lang.Integer.valueOf(i));
        map.put(com.taobao.weex.common.Constants.Name.VIEW_HEIGHT, java.lang.Float.valueOf(f2));
        fireEvent(com.taobao.weex.common.Constants.Event.ONPULLING_DOWN, map);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        if (str.equals("display")) {
            java.lang.String string = com.taobao.weex.utils.WXUtils.getString(obj, null);
            if (string == null) {
                return true;
            }
            setDisplay(string);
            return true;
        }
        return super.setProperty(str, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = "display")
    public void setDisplay(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || !str.equals("hide")) {
            return;
        }
        if (((getParent() instanceof com.taobao.weex.ui.component.list.WXListComponent) || (getParent() instanceof com.taobao.weex.ui.component.WXBaseScroller)) && ((com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView) getParent().getHostView()).getSwipeLayout().isRefreshing()) {
            ((com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView) getParent().getHostView()).finishPullRefresh();
            ((com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView) getParent().getHostView()).onRefreshingComplete();
        }
    }
}
