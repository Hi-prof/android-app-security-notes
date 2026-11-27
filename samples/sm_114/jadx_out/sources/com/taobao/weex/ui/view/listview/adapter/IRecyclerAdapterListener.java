package com.taobao.weex.ui.view.listview.adapter;

/* JADX INFO: loaded from: classes.dex */
public interface IRecyclerAdapterListener<T extends androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    int getItemCount();

    long getItemId(int i);

    int getItemViewType(int i);

    void onBindViewHolder(T t, int i);

    T onCreateViewHolder(android.view.ViewGroup viewGroup, int i);

    boolean onFailedToRecycleView(T t);

    void onViewRecycled(T t);
}
