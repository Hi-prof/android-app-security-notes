package com.taobao.weex.ui.view.refresh.wrapper;

/* JADX INFO: loaded from: classes.dex */
public class BounceScrollerView extends com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView<com.taobao.weex.ui.view.WXScrollView> {
    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public void onLoadmoreComplete() {
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public void onRefreshingComplete() {
    }

    public BounceScrollerView(android.content.Context context, int i, com.taobao.weex.ui.component.WXBaseScroller wXBaseScroller) {
        super(context, i);
        init(context);
        if (getInnerView() != null) {
            getInnerView().setWAScroller(wXBaseScroller);
        }
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public com.taobao.weex.ui.view.WXScrollView setInnerView(android.content.Context context) {
        return new com.taobao.weex.ui.view.WXScrollView(context);
    }
}
