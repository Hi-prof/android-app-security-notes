package com.taobao.weex.ui.component.list;

/* JADX INFO: loaded from: classes.dex */
class DragSupportCallback extends androidx.recyclerview.widget.ItemTouchHelper.Callback {
    private static final java.lang.String TAG = "WXListExComponent";
    private int dragFrom;
    private int dragTo;
    private final com.taobao.weex.ui.component.list.DragHelper mDragHelper;
    private boolean mEnableDifferentViewTypeDrag;

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
    }

    DragSupportCallback(com.taobao.weex.ui.component.list.DragHelper dragHelper) {
        this.dragFrom = -1;
        this.dragTo = -1;
        this.mDragHelper = dragHelper;
        this.mEnableDifferentViewTypeDrag = false;
    }

    DragSupportCallback(com.taobao.weex.ui.component.list.DragHelper dragHelper, boolean z) {
        this.dragFrom = -1;
        this.dragTo = -1;
        this.mDragHelper = dragHelper;
        this.mEnableDifferentViewTypeDrag = z;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        if ((recyclerView.getLayoutManager() instanceof androidx.recyclerview.widget.GridLayoutManager) || (recyclerView.getLayoutManager() instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager)) {
            return makeMovementFlags(15, 0);
        }
        return makeMovementFlags(3, 48);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder2) {
        if (viewHolder != null && viewHolder2 != null) {
            if ((!this.mEnableDifferentViewTypeDrag && viewHolder.getItemViewType() != viewHolder2.getItemViewType()) || this.mDragHelper.isDragExcluded(viewHolder)) {
                return false;
            }
            try {
                int adapterPosition = viewHolder.getAdapterPosition();
                int adapterPosition2 = viewHolder2.getAdapterPosition();
                if (this.dragFrom == -1) {
                    this.dragFrom = adapterPosition;
                }
                this.dragTo = adapterPosition2;
                this.mDragHelper.onDragging(adapterPosition, adapterPosition2);
                return true;
            } catch (java.lang.Exception e) {
                com.taobao.weex.utils.WXLogUtils.e(TAG, e.getMessage());
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return this.mDragHelper.isDraggable() && this.mDragHelper.isLongPressDragEnabled();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        if (i != 0 && (viewHolder instanceof com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder)) {
            com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder listBaseViewHolder = (com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder) viewHolder;
            if (listBaseViewHolder.getComponent() != null) {
                this.mDragHelper.onDragStart(listBaseViewHolder.getComponent(), listBaseViewHolder.getAdapterPosition());
            }
        }
        super.onSelectedChanged(viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (viewHolder instanceof com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder) {
            com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder listBaseViewHolder = (com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder) viewHolder;
            if (listBaseViewHolder.getComponent() != null && this.dragFrom != -1 && this.dragTo != -1) {
                this.mDragHelper.onDragEnd(listBaseViewHolder.getComponent(), this.dragFrom, this.dragTo);
            }
        }
        this.dragTo = -1;
        this.dragFrom = -1;
    }
}
