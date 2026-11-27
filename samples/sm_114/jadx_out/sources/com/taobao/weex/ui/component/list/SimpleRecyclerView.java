package com.taobao.weex.ui.component.list;

/* JADX INFO: loaded from: classes.dex */
class SimpleRecyclerView extends com.taobao.weex.ui.view.listview.WXRecyclerView implements com.taobao.weex.ui.component.list.ListComponentView {
    private com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter mAdapter;

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public com.taobao.weex.ui.view.listview.WXRecyclerView getInnerView() {
        return this;
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public void notifyStickyRemove(com.taobao.weex.ui.component.list.WXCell wXCell) {
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public void notifyStickyShow(com.taobao.weex.ui.component.list.WXCell wXCell) {
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public void updateStickyView(int i) {
    }

    public SimpleRecyclerView(android.content.Context context) {
        super(context);
        this.mAdapter = null;
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public void setRecyclerViewBaseAdapter(com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter recyclerViewBaseAdapter) {
        setAdapter(recyclerViewBaseAdapter);
        this.mAdapter = recyclerViewBaseAdapter;
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter getRecyclerViewBaseAdapter() {
        return this.mAdapter;
    }
}
