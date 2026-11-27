package com.taobao.weex.ui.view.listview.adapter;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerViewBaseAdapter<T extends com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder> extends androidx.recyclerview.widget.RecyclerView.Adapter<T> {
    private com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener iRecyclerAdapterListener;

    public RecyclerViewBaseAdapter(com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener iRecyclerAdapterListener) {
        this.iRecyclerAdapterListener = iRecyclerAdapterListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public T onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener iRecyclerAdapterListener = this.iRecyclerAdapterListener;
        if (iRecyclerAdapterListener != null) {
            return (T) iRecyclerAdapterListener.onCreateViewHolder(viewGroup, i);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(T t) {
        android.view.ViewGroup.LayoutParams layoutParams;
        super.onViewAttachedToWindow(t);
        if (t == null || !t.isFullSpan() || (layoutParams = t.itemView.getLayoutParams()) == null || !(layoutParams instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams)) {
            return;
        }
        ((androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(T t) {
        super.onViewDetachedFromWindow(t);
        if (t != null) {
            t.setComponentUsing(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(T t, int i) {
        com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener iRecyclerAdapterListener = this.iRecyclerAdapterListener;
        if (iRecyclerAdapterListener != null) {
            iRecyclerAdapterListener.onBindViewHolder(t, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener iRecyclerAdapterListener = this.iRecyclerAdapterListener;
        return iRecyclerAdapterListener != null ? iRecyclerAdapterListener.getItemViewType(i) : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.iRecyclerAdapterListener.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener iRecyclerAdapterListener = this.iRecyclerAdapterListener;
        if (iRecyclerAdapterListener != null) {
            return iRecyclerAdapterListener.getItemCount();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(T t) {
        com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener iRecyclerAdapterListener = this.iRecyclerAdapterListener;
        if (iRecyclerAdapterListener != null) {
            iRecyclerAdapterListener.onViewRecycled(t);
        }
        super.onViewRecycled(t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(T t) {
        com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener iRecyclerAdapterListener = this.iRecyclerAdapterListener;
        if (iRecyclerAdapterListener != null) {
            return iRecyclerAdapterListener.onFailedToRecycleView(t);
        }
        return super.onFailedToRecycleView(t);
    }
}
