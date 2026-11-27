package io.dcloud.common.adapter.ui.fresh;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class PullToRefreshWebView extends io.dcloud.common.adapter.ui.fresh.PullToRefreshBase<android.view.View> {
    public PullToRefreshWebView(android.content.Context context) {
        super(context);
    }

    @Override // io.dcloud.common.adapter.ui.fresh.PullToRefreshBase
    protected boolean isReadyForPullDown() {
        return this.mRefreshableView.getScrollY() == 0;
    }

    @Override // io.dcloud.common.adapter.ui.fresh.PullToRefreshBase
    protected boolean isReadyForPullUp() {
        float f = this.mRefreshableView.getContext().getResources().getDisplayMetrics().density;
        int measuredHeight = this.mRefreshableView.getMeasuredHeight();
        T t = this.mRefreshableView;
        if (t instanceof android.webkit.WebView) {
            measuredHeight = ((android.webkit.WebView) t).getContentHeight();
        }
        return ((double) this.mRefreshableView.getScrollY()) >= java.lang.Math.floor(java.lang.Double.valueOf(java.lang.String.valueOf(((float) measuredHeight) * f)).doubleValue()) - ((double) this.mRefreshableView.getHeight());
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }
}
