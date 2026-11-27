package io.dcloud.feature.weex_scroller.view;

/* JADX INFO: loaded from: classes2.dex */
public class DCBounceScrollerView extends com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView<io.dcloud.feature.weex_scroller.view.DCWXScrollView> {
    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public void onLoadmoreComplete() {
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public void onRefreshingComplete() {
    }

    public DCBounceScrollerView(android.content.Context context, int i, com.taobao.weex.ui.component.DCWXScroller dCWXScroller) {
        super(context, i);
        init(context);
        if (getInnerView() != null) {
            getInnerView().setWAScroller(dCWXScroller);
        }
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public io.dcloud.feature.weex_scroller.view.DCWXScrollView setInnerView(android.content.Context context) {
        return new io.dcloud.feature.weex_scroller.view.DCWXScrollView(context);
    }
}
