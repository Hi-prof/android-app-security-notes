package com.taobao.weex.ui.component.list;

/* JADX INFO: loaded from: classes.dex */
class DefaultDragHelper implements com.taobao.weex.ui.component.list.DragHelper {
    private static final java.lang.String EVENT_END_DRAG = "dragend";
    private static final java.lang.String EVENT_START_DRAG = "dragstart";
    private static final java.lang.String TAG = "WXListExComponent";
    private static final java.lang.String TAG_EXCLUDED = "drag_excluded";
    private boolean isDraggable = false;
    private final java.util.List<com.taobao.weex.ui.component.WXComponent> mDataSource;
    private final com.taobao.weex.ui.component.list.EventTrigger mEventTrigger;
    private androidx.recyclerview.widget.ItemTouchHelper mItemTouchHelper;
    private boolean mLongPressEnabled;
    private final androidx.recyclerview.widget.RecyclerView mRecyclerView;

    DefaultDragHelper(java.util.List<com.taobao.weex.ui.component.WXComponent> list, androidx.recyclerview.widget.RecyclerView recyclerView, com.taobao.weex.ui.component.list.EventTrigger eventTrigger) {
        this.mDataSource = list;
        this.mEventTrigger = eventTrigger;
        this.mRecyclerView = recyclerView;
        androidx.recyclerview.widget.ItemTouchHelper itemTouchHelper = new androidx.recyclerview.widget.ItemTouchHelper(new com.taobao.weex.ui.component.list.DragSupportCallback(this, true));
        this.mItemTouchHelper = itemTouchHelper;
        try {
            itemTouchHelper.attachToRecyclerView(recyclerView);
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public void onDragStart(com.taobao.weex.ui.component.WXComponent wXComponent, int i) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d(TAG, "list on drag start : from index " + i);
        }
        this.mEventTrigger.triggerEvent(EVENT_START_DRAG, buildEvent(wXComponent.getRef(), i, -1));
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public void onDragEnd(com.taobao.weex.ui.component.WXComponent wXComponent, int i, int i2) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d(TAG, "list on drag end : from index " + i + " to index " + i2);
        }
        this.mEventTrigger.triggerEvent(EVENT_END_DRAG, buildEvent(wXComponent.getRef(), i, i2));
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public void onDragging(int i, int i2) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d(TAG, "list on dragging : from index " + i + " to index " + i2);
        }
        androidx.recyclerview.widget.RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
        if (adapter == null) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "drag failed because of RecyclerView#Adapter is not bound");
            return;
        }
        if (i < 0 || i > this.mDataSource.size() - 1 || i2 < 0 || i2 > this.mDataSource.size() - 1) {
            return;
        }
        java.util.Collections.swap(this.mDataSource, i, i2);
        adapter.notifyItemMoved(i, i2);
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public boolean isLongPressDragEnabled() {
        return this.mLongPressEnabled;
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public void setLongPressDragEnabled(boolean z) {
        this.mLongPressEnabled = z;
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public void startDrag(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        if (this.isDraggable) {
            this.mItemTouchHelper.startDrag(viewHolder);
        }
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public boolean isDraggable() {
        return this.isDraggable;
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public void setDraggable(boolean z) {
        this.isDraggable = z;
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public void setDragExcluded(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, boolean z) {
        if (viewHolder.itemView == null) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.e(TAG, "[error] viewHolder.itemView is null");
            }
        } else if (z) {
            viewHolder.itemView.setTag(TAG_EXCLUDED);
        } else {
            viewHolder.itemView.setTag(null);
        }
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public boolean isDragExcluded(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        if (viewHolder.itemView != null) {
            return viewHolder.itemView.getTag() != null && TAG_EXCLUDED.equals(viewHolder.itemView.getTag());
        }
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "[error] viewHolder.itemView is null");
        }
        return false;
    }

    private java.util.Map<java.lang.String, java.lang.Object> buildEvent(java.lang.String str, int i, int i2) {
        java.util.HashMap map = new java.util.HashMap(4);
        if (str == null) {
            str = "unknown";
        }
        map.put(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_TARGET, str);
        map.put("fromIndex", java.lang.Integer.valueOf(i));
        map.put("toIndex", java.lang.Integer.valueOf(i2));
        map.put("timestamp", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        return map;
    }
}
