package io.dcloud.common.adapter.ui.fresh;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class HeaderLoadingLayout extends io.dcloud.common.adapter.ui.fresh.LoadingLayout {
    private static final int ROTATE_ANIM_DURATION = 150;

    public HeaderLoadingLayout(android.content.Context context) {
        super(context);
        init(context);
    }

    private void init(android.content.Context context) {
    }

    @Override // io.dcloud.common.adapter.ui.fresh.LoadingLayout
    protected android.view.View createLoadingView(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new android.widget.TextView(context);
    }

    @Override // io.dcloud.common.adapter.ui.fresh.LoadingLayout, io.dcloud.common.adapter.ui.fresh.ILoadingLayout
    public int getContentSize() {
        return (int) (getResources().getDisplayMetrics().density * 100.0f);
    }

    @Override // io.dcloud.common.adapter.ui.fresh.LoadingLayout
    protected void onPullToRefresh() {
    }

    @Override // io.dcloud.common.adapter.ui.fresh.LoadingLayout
    protected void onRefreshing() {
    }

    @Override // io.dcloud.common.adapter.ui.fresh.LoadingLayout
    protected void onReleaseToRefresh() {
    }

    @Override // io.dcloud.common.adapter.ui.fresh.LoadingLayout
    protected void onReset() {
    }

    @Override // io.dcloud.common.adapter.ui.fresh.LoadingLayout
    protected void onStateChanged(io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state, io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state2) {
        super.onStateChanged(state, state2);
    }

    @Override // io.dcloud.common.adapter.ui.fresh.LoadingLayout
    public void setLastUpdatedLabel(java.lang.CharSequence charSequence) {
    }

    public HeaderLoadingLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }
}
