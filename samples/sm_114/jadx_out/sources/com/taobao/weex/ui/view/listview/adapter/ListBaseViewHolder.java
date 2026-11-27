package com.taobao.weex.ui.view.listview.adapter;

/* JADX INFO: loaded from: classes.dex */
public class ListBaseViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    private boolean isRecycled;
    private java.lang.ref.WeakReference<com.taobao.weex.ui.component.WXComponent> mComponent;
    private int mViewType;

    public ListBaseViewHolder(com.taobao.weex.ui.component.WXComponent wXComponent, int i) {
        super(wXComponent.getHostView());
        this.mViewType = i;
        this.mComponent = new java.lang.ref.WeakReference<>(wXComponent);
        this.isRecycled = wXComponent.canRecycled();
    }

    public ListBaseViewHolder(com.taobao.weex.ui.component.WXComponent wXComponent, int i, boolean z) {
        this(wXComponent, i);
        this.isRecycled = this.isRecycled || z;
    }

    public ListBaseViewHolder(android.view.View view, int i) {
        super(view);
        this.mViewType = i;
    }

    public boolean isRecycled() {
        return this.isRecycled;
    }

    public void recycled() {
        java.lang.ref.WeakReference<com.taobao.weex.ui.component.WXComponent> weakReference = this.mComponent;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mComponent.get().recycled();
        this.isRecycled = true;
    }

    public void bindData(com.taobao.weex.ui.component.WXComponent wXComponent) {
        java.lang.ref.WeakReference<com.taobao.weex.ui.component.WXComponent> weakReference = this.mComponent;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mComponent.get().bindData(wXComponent);
        this.isRecycled = false;
    }

    public boolean isFullSpan() {
        java.lang.ref.WeakReference<com.taobao.weex.ui.component.WXComponent> weakReference = this.mComponent;
        return weakReference != null && (weakReference.get() instanceof com.taobao.weex.ui.component.WXHeader);
    }

    public boolean canRecycled() {
        java.lang.ref.WeakReference<com.taobao.weex.ui.component.WXComponent> weakReference = this.mComponent;
        if (weakReference == null || weakReference.get() == null) {
            return true;
        }
        return this.mComponent.get().canRecycled();
    }

    public android.view.View getView() {
        return this.itemView;
    }

    public int getViewType() {
        return this.mViewType;
    }

    public void setComponentUsing(boolean z) {
        java.lang.ref.WeakReference<com.taobao.weex.ui.component.WXComponent> weakReference = this.mComponent;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mComponent.get().setUsing(z);
    }

    public com.taobao.weex.ui.component.WXComponent getComponent() {
        java.lang.ref.WeakReference<com.taobao.weex.ui.component.WXComponent> weakReference = this.mComponent;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
