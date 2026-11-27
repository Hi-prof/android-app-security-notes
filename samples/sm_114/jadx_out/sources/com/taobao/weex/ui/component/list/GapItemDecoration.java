package com.taobao.weex.ui.component.list;

/* JADX INFO: loaded from: classes.dex */
public class GapItemDecoration extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    private com.taobao.weex.ui.component.list.WXListComponent listComponent;

    public GapItemDecoration(com.taobao.weex.ui.component.list.WXListComponent wXListComponent) {
        this.listComponent = wXListComponent;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
        int childAdapterPosition;
        java.lang.Float[] spanOffsets = this.listComponent.getSpanOffsets();
        if (spanOffsets != null && (childAdapterPosition = recyclerView.getChildAdapterPosition(view)) >= 0 && (view.getLayoutParams() instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams)) {
            androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams layoutParams = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
            if (layoutParams.isFullSpan()) {
                return;
            }
            com.taobao.weex.common.IWXObject listChild = this.listComponent.getListChild(childAdapterPosition);
            if (listChild instanceof com.taobao.weex.ui.component.list.WXCell) {
                com.taobao.weex.ui.component.list.WXCell wXCell = (com.taobao.weex.ui.component.list.WXCell) listChild;
                if (wXCell.isFixed() || wXCell.isSticky() || layoutParams.getSpanIndex() >= spanOffsets.length) {
                    return;
                }
                int iRound = java.lang.Math.round(com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(this.listComponent.getSpanOffsets()[this.listComponent.isLayoutRTL() ? (spanOffsets.length - layoutParams.getSpanIndex()) - 1 : layoutParams.getSpanIndex()].floatValue(), this.listComponent.getViewPortWidthForFloat()));
                if (this.listComponent.isLayoutRTL()) {
                    rect.left = -iRound;
                    rect.right = iRound;
                } else {
                    rect.left = iRound;
                    rect.right = -iRound;
                }
            }
        }
    }
}
