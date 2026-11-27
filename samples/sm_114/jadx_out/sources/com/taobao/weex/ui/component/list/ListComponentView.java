package com.taobao.weex.ui.component.list;

/* JADX INFO: loaded from: classes.dex */
public interface ListComponentView {
    com.taobao.weex.ui.view.listview.WXRecyclerView getInnerView();

    com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter getRecyclerViewBaseAdapter();

    void notifyStickyRemove(com.taobao.weex.ui.component.list.WXCell wXCell);

    void notifyStickyShow(com.taobao.weex.ui.component.list.WXCell wXCell);

    void setRecyclerViewBaseAdapter(com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter recyclerViewBaseAdapter);

    void updateStickyView(int i);
}
