package com.taobao.weex.ui.component.list;

/* JADX INFO: loaded from: classes.dex */
interface DragHelper {
    boolean isDragExcluded(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder);

    boolean isDraggable();

    boolean isLongPressDragEnabled();

    void onDragEnd(com.taobao.weex.ui.component.WXComponent wXComponent, int i, int i2);

    void onDragStart(com.taobao.weex.ui.component.WXComponent wXComponent, int i);

    void onDragging(int i, int i2);

    void setDragExcluded(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, boolean z);

    void setDraggable(boolean z);

    void setLongPressDragEnabled(boolean z);

    void startDrag(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder);
}
