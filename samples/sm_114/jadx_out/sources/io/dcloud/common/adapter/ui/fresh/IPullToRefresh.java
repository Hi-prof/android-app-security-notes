package io.dcloud.common.adapter.ui.fresh;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IPullToRefresh<T extends android.view.View> {
    io.dcloud.common.adapter.ui.fresh.LoadingLayout getFooterLoadingLayout();

    io.dcloud.common.adapter.ui.fresh.LoadingLayout getHeaderLoadingLayout();

    T getRefreshableView();

    boolean isPullLoadEnabled();

    boolean isPullRefreshEnabled();

    boolean isScrollLoadEnabled();

    void onPullDownRefreshComplete();

    void onPullUpRefreshComplete();

    void setLastUpdatedLabel(java.lang.CharSequence charSequence);

    void setOnRefreshListener(io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.OnRefreshListener<T> onRefreshListener);

    void setPullLoadEnabled(boolean z);

    void setPullRefreshEnabled(boolean z);

    void setScrollLoadEnabled(boolean z);
}
